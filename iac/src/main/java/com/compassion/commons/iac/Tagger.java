package com.compassion.commons.iac;

import static com.compassion.commons.LambdaUtils.accept;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.SystemUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import software.amazon.awscdk.Tags;
import software.constructs.IConstruct;

@RequiredArgsConstructor(staticName = "with")
@Setter @Getter @Accessors(fluent = true)
public class Tagger<C extends IConstruct> {
	private final C construct;
	
	private String application = "", name, projectCode, purpose,
		creator      = "aws-cdk",
		contact      = SystemUtils.USER_NAME + "@us.ci.org",
		team         = "Data Works";
	
	private final Map<String, String> otherTags = new LinkedHashMap<>();
	
	public Tagger<C> other(String tag, String value) {
		otherTags.put(tag, value);
		return this;
	}
	
	public C tag() {
		var tags = Tags.of(construct);
		
		// See: https://ciorg.atlassian.net/wiki/spaces/ITA/pages/27600192537/AWS+Resource+Tagging+Standard
		
		// Required tags
		Objects.requireNonNull(application);
		tags.add("Application", application);
		Objects.requireNonNull(creator);
		tags.add("Creator", creator);

		// IET only
		accept(projectCode, $ -> tags.add("IETProjectCode", $));
		
		// Recommended tags
		accept(name,        $ -> tags.add("Name", $));
		accept(contact,     $ -> tags.add("Contact", $));
		accept(team,        $ -> tags.add("Team", $));
		accept(purpose,     $ -> tags.add("Purpose", $));
		
		// Custom tags
		otherTags.forEach(tags::add);
		
		return construct;
	}
}
