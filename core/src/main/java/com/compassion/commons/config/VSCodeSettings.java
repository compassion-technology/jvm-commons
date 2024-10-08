package com.compassion.commons.config;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.SystemUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.services.ssm.model.OperatingSystem;

public class VSCodeSettings {
	private final static Map<OperatingSystem, Path> defaultPath = Map.of(
		OperatingSystem.WINDOWS, Path.of(System.getenv("APPDATA"), "Code", "User", "settings.json"),
		OperatingSystem.MACOS, Path.of(SystemUtils.USER_HOME, "Library", "Application Support", "Code", "User", "settings.json")
	);
	
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
	
	public void addJsonSchema(String uri, String fileMatch) {
		var s = new JsonSchema();
		s.url = uri;
		s.getFileMatch().add(fileMatch);
		getJsonSchemas().add(s);
	}
	
	@Getter
	@EqualsAndHashCode(exclude = "url")
	public static class JsonSchema {
		private String url;
		private Set<String> fileMatch = new LinkedHashSet<>();
	}
	
	public static Path getDefaultPath(OperatingSystem os) {
		return defaultPath.get(os);
	}
}
