package com.compassion.commons.metrics.runlog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.compassion.commons.jooq.JOOQifyDDL;
import com.google.common.collect.ImmutableList;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ForwardEngineerRunLog {
	public static void main(String[] args) throws IOException, InterruptedException {
		var hackoladePath = Paths.get("C:", "Program Files", "Hackolade", "hackolade.exe");
		if (Files.notExists(hackoladePath)) {
			hackoladePath = Paths.get(System.getenv("LOCALAPPDATA"), "Programs", "Hackolade", "hackolade.exe");
			if (Files.notExists(hackoladePath)) {
				throw new IOException("No Hackolade program detected on this sytem");
			}
		}
		
		var model = Path.of("src", "main", "models", "ci_run_log.json");
		
		log.info("Forward engineering Snowflake DDL...");
		var cmd = ImmutableList.<String>builder()
			.add(hackoladePath.toString()).add("forwEng")
			.add("--outputType").add("script")
			.add("--logLevel").add("3")
			.add("--structuredPath").add("false")
			.add("--skipUndefinedLevel").add("true")
			.add("--format").add("classicUI")
			.add("--model").add(model.toString())
			.add("--path").add(Path.of("src", "main", "sql").toString());
		
		new ProcessBuilder(cmd.build()).inheritIO().start().waitFor();
		
		new JOOQifyDDL().rewrite(Path.of("src", "main", "sql", "ci_metrics", "run_log.sql"));
	}
}
