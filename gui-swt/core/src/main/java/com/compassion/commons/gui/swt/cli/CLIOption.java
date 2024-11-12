package com.compassion.commons.gui.swt.cli;

import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.elderresearch.commons.icons.eri.IconsERI;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import picocli.CommandLine.Model.OptionSpec;

@Log4j2
@RequiredArgsConstructor
class CLIOption {
	private final CLIForm form;
	private final Composite parent;
	
	@Getter
	private final OptionSpec spec;
	
	protected Label name;
	protected Control input;
	protected Label description;
	
	protected void initName() {
		name = form.label(parent).text(StringUtils.removeStart(spec.longestName(), "--")).get();
	}
	
	protected void initDescription() {
		description = form.label(parent).text(StringUtils.normalizeSpace(StringUtils.join(spec.description(), " "))).get();
	}
	
	public void dispose() {
		List.of(name, input, description).forEach(Widget::dispose);
	}
	
	static class CLIFlag extends CLIOption {
		CLIFlag(CLIForm form, Composite parent, OptionSpec spec) {
			super(form, parent, spec);
			
			initName();
			input = form.check(parent)
				.selected(Boolean.parseBoolean(spec.defaultValue()))
				.text(name.getText())
				.get();
			initDescription();
			
			// Name is just a placeholder, since the checkbox has the name
			name.setText(StringUtils.EMPTY);
		}
	}
	
	static class CLIText extends CLIOption {
		CLIText(CLIForm form, Composite parent, OptionSpec spec, Class<?> type) {
			super(form, parent, spec);
			
			initName();
			var textbox = form.text(parent)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().fill())
				.get();
			input = textbox;
			initDescription();

			if (Number.class.isAssignableFrom(type) || type.isPrimitive()) {
				Predicate<String> validator = Double.class.isAssignableFrom(type) || Float.class.isAssignableFrom(type)
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
		CLIEnum(CLIForm form, Composite parent, OptionSpec spec) {
			super(form, parent, spec);
			
			initName();
			input = form.<String>combo(parent).items(spec.completionCandidates()).get();
			initDescription();
		}
	}
	
	static class CLIPath extends CLIOption {
		CLIPath(CLIForm form, Composite parent, OptionSpec spec) {
			super(form, parent, spec);
			
			initName();
			var composite = form.composite(parent)
				.layout(form.grid(1, 1).margin(0))
				.layoutData(form.gridData().hFill().hGrab())
				.get();
			input = composite;
			initDescription();

			var filePath = form.text(composite, SWT.NONE)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().fill().hGrab())
				.get();
			
			form.button(composite).text("Browse...").layoutData(form.gridData().button()).onSelect(e -> {
				var style = SWT.APPLICATION_MODAL;
				style |= spec.longestName().contains("output")? SWT.SAVE : SWT.OPEN;

				if (spec.longestName().contains("-dir")) {
					var dialog = new DirectoryDialog(form.getShell(), style);
					dialog.setText(name.getText());
					LambdaUtils.accept(dialog.open(), filePath::setText);
				} else {
					var dialog = new FileDialog(form.getShell(), style);
					dialog.setOverwrite(Utilities.isOn(style, SWT.SAVE));
					dialog.setText(name.getText());
					
					if (spec.paramLabel().contains(".")) {
						var filter = StringUtils.substringAfter(spec.paramLabel(), ".");
						dialog.setFilterExtensions(new String[] { "*." + filter, "*.*" });
						dialog.setFilterNames(new String[] { filter + " files (*." + filter + ")", "All files (*.*)" });
					}
					LambdaUtils.accept(dialog.open(), filePath::setText);
				}
			});
		}
	}
	
	static class CLICollection extends CLIOption {
		private List<CLIOption> items = new LinkedList<>();
		
		CLICollection(CLIForm form, Composite parent, OptionSpec spec) {
			super(form, parent, spec);
			
			initName();
			name.setLayoutData(form.gridData().vSpan(2).get());
			
			var composite = form.composite(parent, SWT.BORDER)
				.layout(form.grid(1, 1, 1, 1).vMargin(2))
				.layoutData(form.gridData().hFill().hGrab())
				.get();
			composite.setVisible(false);
			input = composite;
			
			initDescription();
			description.setLayoutData(form.gridData().vSpan(2).get());
			
			form.button(form).image(form.image(IconsERI.ADD)).text("Add").layoutData(form.gridData().button()).onSelect(e -> {
				composite.setVisible(true);
				
				var item = newOption(form, composite, spec, Utilities.first(spec.auxiliaryTypes()));
				item.name.setText(StringUtils.EMPTY);
				item.description.setText(StringUtils.EMPTY);
				items.add(item);
				
				form.button(composite).image(form.image(IconsERI.CLOSE)).tooltip("Remove").onSelect(remove -> {
					item.dispose();
					items.remove(item);
					composite.setVisible(!items.isEmpty());
					remove.widget.dispose();
					form.autoSize();
				});
				
				form.autoSize();
			});
		}
		
		@Override
		public void dispose() {
			items.forEach(CLIOption::dispose);
			super.dispose();
		}
	}
	
	static CLIOption newOption(CLIForm form, OptionSpec spec) {
		return newOption(form, form, spec, spec.type());
	}
	
	private static CLIOption newOption(CLIForm form, Composite parent, OptionSpec spec, Class<?> type) {
		if (Boolean.class.isAssignableFrom(type) || type.equals(boolean.class)) {
			return new CLIFlag(form, parent, spec);
		}
		if (CharSequence.class.isAssignableFrom(type) || Number.class.isAssignableFrom(type) || type.isPrimitive()) {
			return new CLIText(form, parent, spec, type);
		}
		if (Enum.class.isAssignableFrom(type)) {
			return new CLIEnum(form, parent, spec);
		}
		if (Path.class.isAssignableFrom(type)) {
			return new CLIPath(form, parent, spec);
		}
		if (spec.isMultiValue()) {
			if (Collection.class.isAssignableFrom(type)) {
				return new CLICollection(form, parent, spec);
			}
		}
		
		log.warn("Unsupported option type: {}", type);
		return null;
	}
}
