package com.compassion.commons.gui.swt.cli;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;

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
			var textbox = form.text(form)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().hFill())
				.get();
			input = textbox;
			initDescription();

			if (Number.class.isAssignableFrom(spec.type())) {
				Predicate<String> validator = Double.class.isAssignableFrom(spec.type()) || Float.class.isAssignableFrom(spec.type())
					? $ -> NumberUtils.toDouble($, Double.NEGATIVE_INFINITY) > Double.NEGATIVE_INFINITY
					: $ -> NumberUtils.toLong($, Long.MIN_VALUE) > Long.MIN_VALUE;
				
				textbox.addModifyListener(e -> {
					var s = textbox.getText();
					var valid = s.isEmpty() || validator.test(s);
					textbox.setBackground(valid? form.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND) : form.getInvalidColor());
					if (!valid) { form.getDisplay().beep(); }
				});
			}
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
	
	static class CLIPath extends CLIOption {
		CLIPath(CLIForm form, OptionSpec spec) {
			super(form, spec);
			
			initName();
			var parent = form.composite(form)
				.layout(form.grid(1, 1).margin(0))
				.layoutData(form.gridData().hFill().hGrab())
				.get();
			input = parent;
			initDescription();

			var filePath = form.text(parent, SWT.NONE)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().hFill().hGrab())
				.get();
			
			form.button(parent).text("Browse...").layoutData(form.gridData().button()).onSelect(e -> {
				var style = SWT.APPLICATION_MODAL;
				style |= spec.longestName().contains("output")? SWT.SAVE : SWT.OPEN;
				
				var dialog = new FileDialog(form.getShell(), style);
				dialog.setOverwrite(Utilities.isOn(style, SWT.SAVE));
				dialog.setText(name.getText());
				LambdaUtils.accept(StringUtils.stripToNull(spec.paramLabel()), example -> {
					var filter = StringUtils.substringAfter(example, ".");
					dialog.setFilterExtensions(new String[] { "*." + filter, "*.*" });
					dialog.setFilterNames(new String[] { filter + " files (*." + filter + ")", "All files (*.*)" });
				});
				
				LambdaUtils.accept(dialog.open(), filePath::setText);
			});
		}
	}
	
	static CLIOption newOption(CLIForm form, OptionSpec spec) {
		if (Boolean.class.isAssignableFrom(spec.type()) || spec.type().equals(boolean.class)) {
			return new CLIFlag(form, spec);
		}
		if (CharSequence.class.isAssignableFrom(spec.type()) || Number.class.isAssignableFrom(spec.type())) {
			return new CLIText(form, spec);
		}
		if (Enum.class.isAssignableFrom(spec.type())) {
			return new CLIEnum(form, spec);
		}
		if (Path.class.isAssignableFrom(spec.type())) {
			return new CLIPath(form, spec);
		}
		
		log.warn("Unsupported option type: {}", spec.type());
		return null;
	}
}
