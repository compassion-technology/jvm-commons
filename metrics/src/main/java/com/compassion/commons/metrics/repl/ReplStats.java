package com.compassion.commons.metrics.repl;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.statistics.descriptive.DoubleStatistics;
import org.apache.commons.statistics.descriptive.Statistic;
import org.jooq.lambda.Seq;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * Data replication stats, designed to work with DDO's replication dashboards/scripts
 * http://cloudrepl.ci.org/
 */
@Log4j2
@Getter
public class ReplStats {
	private String name, input, output;
	private long rowsRead, rowsWritten;
	private ZonedDateTime start, end;
	private Optional<ZonedDateTime>
		maxTimestampRead = Optional.empty(),
		maxTimestampWritten = Optional.empty();
	
	private DoubleStatistics processingTimesMs = DoubleStatistics.of(
		Statistic.MIN, Statistic.MEAN, Statistic.MAX
	);
	
	public void markStart() { start = ZonedDateTime.now(); }
	public void markEnd()   { end   = ZonedDateTime.now(); }
	
	public void rowRead(Optional<ZonedDateTime> sourceDataTimestamp) {
		rowsRead++;
		maxTimestampRead = Seq.concat(maxTimestampRead, sourceDataTimestamp).max();  
	}
	
	public void rowWritten(Optional<ZonedDateTime> sourceDataTimestamp) {
		rowsWritten++;
		maxTimestampWritten = Seq.concat(maxTimestampWritten, sourceDataTimestamp).max();
	}
	
	public void rowProcessed(long deltaNanos) {
		double deltaMs = TimeUnit.NANOSECONDS.toMillis(deltaNanos);
		synchronized (processingTimesMs) {
			processingTimesMs.accept(deltaMs);
		}
	}
	
	public void log() {
		log.info(String.format("Ingester stats for %s:%n"
				+ "       Rows read: %,d%n"
				+ "            From: %s%n"
				+ "    Rows written: %,d%n"
				+ "              To: %s%n"
				+ "      Started at: %tF %<tT%n"
				+ "     Finished at: %tF %<tT%n"
				+ " Read data as of: %tF %<tT%n"
				+ "Wrote data as of: %tF %<tT%n"
				+ "    Min proc. ms: %,10.2f%n"
				+ "Average proc. ms: %,10.2f%n"
				+ "    Max proc. ms: %,10.2f",
				name, rowsRead, input, rowsWritten, output, start, end,
				maxTimestampRead.orElse(null), maxTimestampWritten.orElse(null),
				processingTimesMs.getAsDouble(Statistic.MIN),
				processingTimesMs.getAsDouble(Statistic.MEAN),
				processingTimesMs.getAsDouble(Statistic.MAX)));
	}

	public static ReplStats merge(ReplStats... stats) {
		var merged = new ReplStats();
		merged.rowsRead = Seq.of(stats).mapToLong(ReplStats::getRowsRead).sum();
		merged.rowsWritten = Seq.of(stats).mapToLong(ReplStats::getRowsWritten).sum();
		merged.name = "merged: " + Seq.of(stats).map(ReplStats::getName).toString(", ");
		merged.input = "merged: " + Seq.of(stats).map(ReplStats::getInput).toString(", ");
		merged.output = "merged: " + Seq.of(stats).map(ReplStats::getOutput).toString(", ");
		merged.maxTimestampRead = Seq.of(stats).flatMap($ -> Seq.seq($.maxTimestampRead)).max();
		merged.start = Seq.of(stats).map(ReplStats::getStart).min().orElse(null);
		merged.end = Seq.of(stats).map(ReplStats::getStart).max().orElse(null);
		return merged;
	}
}
