package com.compassion.commons.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.SystemUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.services.ssm.model.OperatingSystem;

public class VSCodeSettings {
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Getter
	@JsonProperty("yaml.schemas")
	private Map<String, String> yamlSchemas = new HashMap<>();
	
	@Getter
	@JsonProperty("json.schemas")
	private Set<JsonSchema> jsonSchemas = new LinkedHashSet<>();
	
	@Getter @Setter
	@JsonProperty("git.replaceTagsWhenPull")
	private Boolean gitReplaceTags;
	
	@JsonAnyGetter
	@JsonAnySetter
	private Map<String, Object> otherSettings = new HashMap<>();
	
	public boolean addJsonSchema(String uri, String fileMatch) {
		var s = new JsonSchema();
		s.url = uri;
		s.getFileMatch().add(fileMatch);
		return getJsonSchemas().add(s);
	}
	
	@Getter
	@EqualsAndHashCode(exclude = "url")
	public static class JsonSchema {
		private String url;
		private Set<String> fileMatch = new LinkedHashSet<>();
	}
	
	public static Path getDefaultPath(OperatingSystem os) {
		// Originally this was a static map, but paths may not yet exist on a new computer if VS Code has not been installed
		return switch (os) {
			case WINDOWS -> Path.of(System.getenv("APPDATA"), "Code", "User", "settings.json");
			case MACOS -> Path.of(SystemUtils.USER_HOME, "Library", "Application Support", "Code", "User", "settings.json");
			default -> null;
		};
	}
	public static Path getDefaultPath() {
		return getDefaultPath(SystemUtils.IS_OS_WINDOWS? OperatingSystem.WINDOWS : OperatingSystem.MACOS);
	}
	public void save() throws IOException {
		mapper.writer().withDefaultPrettyPrinter().writeValue(getDefaultPath().toFile(), this);
	}
	public static VSCodeSettings load() throws IOException {
		var path = getDefaultPath();
		return Files.exists(path)? mapper.readValue(path.toFile(), VSCodeSettings.class) : new VSCodeSettings();
	}
}
