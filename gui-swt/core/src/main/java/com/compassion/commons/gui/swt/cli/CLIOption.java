package com.compassion.commons.gui.swt.cli;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import picocli.CommandLine.Model.OptionSpec;

@Log4j2
class CLIOption {
	private final CLIForm form;
	
	@Getter
	private final OptionSpec spec;
	
	protected Label name;
	protected Control input;
	protected Label description;
	
	CLIOption(CLIForm form, OptionSpec spec) {
		this.form = form;
		this.spec = spec;
	}
	
	protected void initName() {
		name = form.label(form).text(StringUtils.removeStart(spec.longestName(), "--")).get();
	}
	
	protected void initDescription() {
		description = form.label(form).text(StringUtils.normalizeSpace(StringUtils.join(spec.description(), " "))).get();
	}
	
	public void dispose() {
		List.of(name, input, description).forEach(Widget::dispose);
	}
	
	static class CLIFlag extends CLIOption {
		CLIFlag(CLIForm form, OptionSpec spec) {
			super(form, spec);
			
			initName();
			input = form.check(form)
				.selected(Boolean.parseBoolean(spec.defaultValue()))
				.text(name.getText())
				.get();
			initDescription();
			
			// Name is just a placeholder, since the checkbox has the name
			name.setText(StringUtils.EMPTY);
		}
	}
	
	static class CLIText extends CLIOption {
		CLIText(CLIForm form, OptionSpec spec) {
			super(form, spec);
			
			initName();
			input = form.text(form)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().hFill())
				.get();
			initDescription();
		}
	}
	
	static class CLIEnum extends CLIOption {
		CLIEnum(CLIForm form, OptionSpec spec) {
			super(form, spec);
			
			initName();
			input = form.<String>combo(form).items(spec.completionCandidates()).get();
			initDescription();
		}
	}
	
	static CLIOption newOption(CLIForm form, OptionSpec spec) {
		if (Boolean.class.isAssignableFrom(spec.type()) || spec.type().equals(boolean.class)) {
			return new CLIFlag(form, spec);
		}
		if (CharSequence.class.isAssignableFrom(spec.type())) {
			return new CLIText(form, spec);
		}
		if (Enum.class.isAssignableFrom(spec.type())) {
			return new CLIEnum(form, spec);
		}
		log.warn("Unsupported option type: {}", spec.type());
		return null;
	}
}
