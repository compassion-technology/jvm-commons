package com.compassion.commons.cli;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import picocli.CommandLine.IVersionProvider;

@Log4j2
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CLIVersion implements IVersionProvider {
	private static final String POM_FILE = "pom.xml";
	
	private final Class<?> versionClass;
	private final String pomFolder;
	
	@Override
	public String[] getVersion() {
		return new String[] { getVersion(versionClass, pomFolder) };
	}
	
	/**
	 * Find the version of the executing code for reporting in CLIs or other contexts.
	 * This first looks for the package version in the bundled code's manifest.
	 * If that doesn't exist, it looks for a Maven {@code pom.xml} file in a folder named
	 * {@code pomFolder} which will be parsed for the version (which is useful for running
	 * from code/in the IDE).
	 * @param c the class that specifies the version in "production" .jar mode
	 * @param pomFolder the folder that contains the {@code pom.xml} file for "development" code mode
	 * @return the version or {@code null} if no version could be discovered
	 */
	public static String getVersion(Class<?> c, String pomFolder) {
		// Look for the version of the provided tools class file
		var ret = c.getPackage().getImplementationVersion();
		if (ret != null) { return ret; }

		// If it's null, we are running from raw source in an IDE. Find the code and find the POM
		try {
			var p = Path.of(c.getProtectionDomain().getCodeSource().getLocation().toURI());
			while (p != null && p.getFileName() != null && !p.getFileName().toString().equals(pomFolder)) { p = p.getParent(); }
			if (p == null) { return null; }

			try (var is = Files.newInputStream(p.resolve(POM_FILE))) {
				var pom = new MavenXpp3Reader().read(is);
				return pom.getVersion();
			}
		} catch (URISyntaxException | IOException | XmlPullParserException e) {
			log.debug("Error inferring {} version in IDE mode", pomFolder, e);
			return null;
		}
	}
}
