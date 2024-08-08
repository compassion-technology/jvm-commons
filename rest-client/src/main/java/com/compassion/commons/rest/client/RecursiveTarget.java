package com.compassion.commons.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.ws.rs.client.WebTarget;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter(AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RecursiveTarget {
	private RecursiveTarget parent;
	private String path;
	
	public RecursiveTarget append(String addToPath) {
		return sibling(path + addToPath);
	}
	public RecursiveTarget sibling(String p) {
		return new RecursiveTarget(parent, p);
	}
	public RecursiveTarget child(String p) {
		return new RecursiveTarget(this, p);
	}
	
	public WebTarget resolve(WebTarget base) {
		return Optional.ofNullable(parent).map($ -> $.resolve(base)).orElse(base).path(path);
	}
	
	public boolean isAbsolute() {
		try {
			return new URI(path).isAbsolute();
		} catch (URISyntaxException e) {
			return false;
		}
	}
	
	public static RecursiveTarget newTarget(RecursiveTarget parent, String path) {
		return new RecursiveTarget(parent, path);
	}
	public static RecursiveTarget newTarget(String path) {
		return newTarget(null, path);
	}
}
