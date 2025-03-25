package com.compassion.commons.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.jooq.lambda.Seq;

import com.compassion.commons.Utilities;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.val;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCDriverExtensions {
	private static Map<DatabaseDriver, List<JDBCDriverExtension>> extensions = new HashMap<>();

	public static void register(JDBCDriverExtension ext) {
		extensions.computeIfAbsent(ext.driver, $ -> new LinkedList<>()).add(ext);
	}

	// Register the built-in/provided extensions
	static {
		register(JDBCDriverExtension.builder()
			.driver(JDBCDriver.MS_SQL_SERVER)
			.forThisOS(SystemUtils.IS_OS_WINDOWS)
			.nativeLibraryPath("/lib/win/sqljdbc_auth.dll")
			.build());
	}

	static void loadExtensions(DatabaseDriver driver) {
		Seq.seq(extensions.getOrDefault(driver, Collections.emptyList()))
		   .filter($ -> !$.isLoaded() && $.isForThisOS())
		   .forEach(JDBCDriverExtension::load);
	}

	@Builder
	@Getter(AccessLevel.PRIVATE)
	public static class JDBCDriverExtension {
		private DatabaseDriver driver;
		private boolean forThisOS;
		private boolean loaded;
		private String nativeLibraryPath;

		@Override
		public String toString() {
			return nativeLibraryPath + " for " + driver;
		}

		void load() {
			val dest = Paths.get(".").resolve(StringUtils.substringAfterLast(getNativeLibraryPath(), "/"));
			if (!Files.exists(dest)) {
				log.debug("Copying {} to {}", getNativeLibraryPath(), dest);
				try (val stream = Utilities.getResourceOrFile(JDBCDriverExtensions.class, getNativeLibraryPath())) {
					Files.copy(stream, dest);
				} catch (IOException e) {
					log.warn("Error loading native extension {}", this, e);
				}
			}
			try {
				System.load(dest.toAbsolutePath().toString());
			} catch (UnsatisfiedLinkError | SecurityException e) {
				log.warn("Error loading native extension {}", this, e);
			}
			loaded = true;
		}
	}
}
