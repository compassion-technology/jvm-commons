package com.compassion.commons.iac;

import static com.compassion.commons.LambdaUtils.accept;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.jooq.lambda.Seq;

import com.compassion.commons.config.CIEnvironment;

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
	
	private String application = "", name, projectCode, purpose, environmentCustom,
		creator      = "aws-cdk",
		contact      = SystemUtils.USER_NAME + "@us.ci.org",
		team         = "ADAPT";
	
	private final Map<String, String> otherTags = new LinkedHashMap<>();
	
	public Tagger<C> other(String tag, String value) {
		otherTags.put(tag, value);
		return this;
	}
	
	public Tagger<C> environment(CIEnvironment e) {
		return environmentCustom(e.toString());
	}
	
	/**
	 * Sets the name of the construct using the application, specified name, and environment (if defined):
	 * {@code application - name - ... - environment}
	 * @param names the specific name components of the construct
	 * @return this tagger for method chaining after the full name has been set from the application, name, 
	 * and optional environment 
	 * @see #name(String)
	 */
	public Tagger<C> fullName(String... names) {
		return name(Seq.of(application).append(names).append(environmentCustom).filter(StringUtils::isNotBlank).toString(" - "));
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
		accept(name,              $ -> tags.add("Name", $));
		accept(contact,           $ -> tags.add("Contact", $));
		accept(team,              $ -> tags.add("Team", $));
		accept(purpose,           $ -> tags.add("Purpose", $));
		accept(environmentCustom, $ -> tags.add("Environment", $));
		
		// Custom tags
		otherTags.forEach(tags::add);
		
		return construct;
	}
}
