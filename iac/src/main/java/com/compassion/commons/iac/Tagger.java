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
public class Tagger {
	private final IConstruct construct;
	
	private String application = "", name, projectCode, purpose,
		creator      = "aws-cdk",
		contact      = SystemUtils.USER_NAME + "@us.ci.org",
		team         = "Data Works";
	
	private final Map<String, String> otherTags = new LinkedHashMap<>();
	
	public Tagger other(String tag, String value) {
		otherTags.put(tag, value);
		return this;
	}
	
	public void tag() {
		var ret = Tags.of(construct);
		
		// See: https://ciorg.atlassian.net/wiki/spaces/ITA/pages/27600192537/AWS+Resource+Tagging+Standard
		
		// Required tags
		Objects.requireNonNull(application);
		ret.add("Application", application);
		Objects.requireNonNull(creator);
		ret.add("Creator", creator);

		// IET only
		accept(projectCode, $ -> ret.add("IETProjectCode", $));
		
		// Recommended tags
		accept(name,        $ -> ret.add("Name", $));
		accept(contact,     $ -> ret.add("Contact", $));
		accept(team,        $ -> ret.add("Team", $));
		accept(purpose,     $ -> ret.add("Purpose", $));
		
		// Custom tags
		otherTags.forEach(ret::add);
	}
}
