/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.compassion.commons.StatusListener;
import com.compassion.commons.StatusMonitor;
import com.elderresearch.commons.math.distance.Angle;
import com.elderresearch.commons.math.distance.Angle.AngleFormat;

public class TVSReutersTest implements FileVisitor<Path> {
	private static final int MAX_DIST = 500;
	
	private long totalSize;
	private StatusMonitor sm;
	private TokenVectorBuilder tvb;
	private TokenVectorSet<TokenVector> tvs;

	@Test
	@Disabled("Too long-running for Jenkins with no assertable output")
	public void testNoExceptions() throws IOException {
		// First count all files
		sm = new StatusMonitor("TVSReuters").addListener(StatusListener.LOG);
		sm.newTask("Counting files...");
		Path root = Paths.get("E:\\ERI\\General\\Reuters Corpora\\Sample");
		Files.walkFileTree(root, this);
		
		// Then iterate through and build token vectors
		sm.newTask("Reading files and building token vectors...", totalSize);
		tvb = new TokenVectorBuilder();
		tvs = new TokenVectorSet<>("reuters", TokenVector.class);
		Files.walkFileTree(root, this);
		
		tvs.updateWeights(sm, null);
		
		sm.newTask("Computing distances...");
		TVSDistanceSettings settings = new TVSDistanceSettings()
			.setStatusMonitor(sm)
			.setMaxDistances(MAX_DIST)
			.setThreads(24)
			.setRange(Range.between(Float.MIN_VALUE, Float.POSITIVE_INFINITY))
			.setMetric(new Angle().setFormat(AngleFormat.COSINE));
		
		for (TVSDistance d : tvs.computeDistances(settings)) {
			System.out.println(d.getKey1() + ", " + d.getKey2() + " = " + d.getDistance());
		}
		sm.setFinished();
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (tvs == null) {
			totalSize += attrs.size();
		} else {
			String fileName = file.getFileName().toString();
			long key = NumberUtils.toLong(fileName.replace("newsML.xml", ""));
			
			try (FileReader fr = new FileReader(file.toFile())) {
				tvs.add(key, tvb.build(fr));
			}
			sm.setProgress(attrs.size(), true);
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}
}
