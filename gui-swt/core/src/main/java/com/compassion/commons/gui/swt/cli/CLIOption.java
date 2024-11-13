package com.compassion.commons.gui.swt.cli;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.jooq.lambda.Seq;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.gui.swt.events.SelectionLambda;
import com.elderresearch.commons.icons.eri.IconsERI;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import picocli.CommandLine.Model.ArgSpec;
import picocli.CommandLine.Model.OptionSpec;

@Log4j2
@RequiredArgsConstructor
abstract class CLIOption<T extends Control> {
	private final CLIForm form;
	private final Composite parent;
	private final int style;
	
	@Getter
	private final ArgSpec spec;
	@Getter
	protected List<String> cliArgs = List.of();
	
	protected Label name;
	protected T input;
	protected Label description;
	
	protected void initName() {
		if (Utilities.isOn(style, SWT.EMBEDDED)) { return; }
		
		if (spec instanceof OptionSpec os) {
			name = form.label(parent)
				.text(StringUtils.removeStart(os.longestName(), "--"))
				.layoutData(form.gridData().align(SWT.TRAIL).width(100))
				.get();
		} else {
			name = form.label(parent).get();
		}
	}
	
	protected void initDescription() {
		if (Utilities.isOn(style, SWT.EMBEDDED)) { return; }
		
		description = form.label(parent, SWT.WRAP)
			.text(StringUtils.normalizeSpace(StringUtils.join(spec.description(), " ")))
			.layoutData(form.gridData().hGrab())
			.get();
	}
	
	public void dispose() {
		Seq.of(name, input, description).filter(Objects::nonNull).forEach(Widget::dispose);
	}
	
	protected void updateCliArgs(String value) {
		if (StringUtils.isEmpty(value)) {
			cliArgs = List.of();
		} else if (spec instanceof OptionSpec os) {
			cliArgs = List.of(os.longestName(), value);
		} else {
			cliArgs = List.of(value);
		}
	}
	
	public abstract void addArgListener(Listener l);
	
	static class CLIFlag extends CLIOption<Button> {
		CLIFlag(CLIForm form, Composite parent, int style, ArgSpec spec) {
			super(form, parent, style, spec);
			
			initName();
			input = form.check(parent)
				.selected(Boolean.parseBoolean(spec.defaultValue()))
				.text(name.getText())
				.get();
			initDescription();
			
			// Name is just a placeholder, since the checkbox has the name
			name.setText(StringUtils.EMPTY);
		}
		
		@Override
		protected void updateCliArgs(String value) {
			if (getSpec() instanceof OptionSpec os) {
				cliArgs = List.of(os.longestName() + "=" + value);	
			}
		}
		
		@Override
		public void addArgListener(Listener l) {
			input.addSelectionListener((SelectionLambda) e -> {
				updateCliArgs(Boolean.toString(input.getSelection()));
				l.handleEvent(null);
			});
		}
	}
	
	static class CLIText extends CLIOption<Text> {
		CLIText(CLIForm form, Composite parent, int style, ArgSpec spec, Class<?> type) {
			super(form, parent, style, spec);
			
			initName();
			input = form.text(parent)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().align(SWT.FILL))
				.get();
			initDescription();

			if (Number.class.isAssignableFrom(type) || type.isPrimitive()) {
				Predicate<String> validator = Double.class.isAssignableFrom(type) || Float.class.isAssignableFrom(type)
					? $ -> NumberUtils.toDouble($, Double.NEGATIVE_INFINITY) > Double.NEGATIVE_INFINITY
					: $ -> NumberUtils.toLong($, Long.MIN_VALUE) > Long.MIN_VALUE;
				
				input.addModifyListener(e -> {
					var s = input.getText();
					var valid = s.isEmpty() || validator.test(s);
					input.setBackground(valid? form.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND) : form.getInvalidColor());
					if (!valid) { form.getDisplay().beep(); }
				});
			}
		}
		
		@Override
		public void addArgListener(Listener l) {
			input.addModifyListener(e -> {
				updateCliArgs(input.getText());
				l.handleEvent(null);
			});
		}
	}
	
	static class CLIEnum extends CLIOption<Combo> {
		CLIEnum(CLIForm form, Composite parent, int style, ArgSpec spec) {
			super(form, parent, style, spec);
			
			initName();
			input = form.<String>combo(parent).items(spec.completionCandidates()).get();
			initDescription();
		}
		
		@Override
		public void addArgListener(Listener l) {
			input.addSelectionListener((SelectionLambda) e -> {
				updateCliArgs(input.getText());
				l.handleEvent(null);
			});
		}
	}
	
	static class CLIPath extends CLIOption<Text> {
		CLIPath(CLIForm form, Composite parent, int style, OptionSpec spec) {
			super(form, parent, style, spec);
			
			initName();
			var composite = form.composite(parent)
				.layout(form.grid(1, 1).margin(0))
				.layoutData(form.gridData().align(SWT.FILL))
				.get();
			initDescription();

			input = form.text(composite, SWT.BORDER)
				.text(StringUtils.defaultString(spec.defaultValue()))
				.layoutData(form.gridData().hGrab().align(SWT.FILL))
				.get();
			
			form.button(composite).text("Browse...").layoutData(form.gridData().button()).onSelect(e -> {
				var dialogStyle = SWT.APPLICATION_MODAL;
				dialogStyle |= spec.longestName().contains("output")? SWT.SAVE : SWT.OPEN;

				if (spec.longestName().contains("-dir")) {
					var dialog = new DirectoryDialog(form.getShell(), dialogStyle);
					dialog.setText(name.getText());
					LambdaUtils.accept(dialog.open(), input::setText);
				} else {
					var dialog = new FileDialog(form.getShell(), dialogStyle);
					dialog.setOverwrite(Utilities.isOn(style, SWT.SAVE));
					dialog.setText(name.getText());
					
					if (spec.paramLabel().contains(".")) {
						var filter = StringUtils.substringAfter(spec.paramLabel(), ".");
						dialog.setFilterExtensions(new String[] { "*." + filter, "*.*" });
						dialog.setFilterNames(new String[] { filter.toUpperCase() + " files (*." + filter + ")", "All files (*.*)" });
					}
					LambdaUtils.accept(dialog.open(), input::setText);
				}
			});
		}
		
		@Override
		public void addArgListener(Listener l) {
			input.addModifyListener(e -> {
				var path = input.getText();
				if (!path.isEmpty()) { path = '"' + path + '"'; }
				updateCliArgs(path);
				l.handleEvent(null);
			});
		}
		
		@Override
		public void dispose() {
			Seq.of(name, input.getParent(), description).filter(Objects::nonNull).forEach(Widget::dispose);
		}
	}
	
	static class CLICollection extends CLIOption<Composite> {
		private Button add;
		private List<CLIOption<?>> items = new LinkedList<>();
		private Listener argListener;
		
		CLICollection(CLIForm form, Composite parent, int style, ArgSpec spec) {
			super(form, parent, style, spec);
			
			initName();
			
			input = form.composite(parent, SWT.BORDER)
				.layout(form.grid(1, 1).vMargin(2))
				.layoutData(form.gridData().align(SWT.FILL))
				.get();
			
			initDescription();
			
			add = form.button(input).image(form.image(IconsERI.ADD)).text("Add").layoutData(form.gridData().hSpan(4).button()).onSelect(e -> {
				var item = newOption(form, input, SWT.EMBEDDED, spec, Utilities.first(spec.auxiliaryTypes()));
				item.addArgListener(argListener);
				if (item.input.getLayoutData() instanceof GridData gd) {
					gd.grabExcessHorizontalSpace = true;
				}
				
				form.button(input).image(form.image(IconsERI.CLOSE)).tooltip("Remove").onSelect(remove -> {
					item.dispose();
					items.remove(item);
					remove.widget.dispose();
					form.autoSize();
					argListener.handleEvent(null);
				});
				form.autoSize();
				
				items.add(item);
			}).get();
		}
		
		@Override
		public void addArgListener(Listener l) {
			argListener = l;
		}
		
		@Override
		public List<String> getCliArgs() {
			var ret = new ArrayList<String>();
			items.forEach($ -> ret.addAll($.getCliArgs()));
			return ret;
		}
		
		@Override
		public void dispose() {
			add.dispose();
			items.forEach(CLIOption::dispose);
			super.dispose();
		}
	}
	
	static CLIOption<?> newOption(CLIForm form, ArgSpec spec) {
		return newOption(form, form, SWT.NONE, spec, spec.type());
	}
	
	private static CLIOption<?> newOption(CLIForm form, Composite parent, int style, ArgSpec spec, Class<?> type) {
		if (Boolean.class.isAssignableFrom(type) || type.equals(boolean.class)) {
			return new CLIFlag(form, parent, style, spec);
		}
		if (CharSequence.class.isAssignableFrom(type) || Number.class.isAssignableFrom(type) || type.isPrimitive()) {
			return new CLIText(form, parent, style, spec, type);
		}
		if (Enum.class.isAssignableFrom(type)) {
			return new CLIEnum(form, parent, style, spec);
		}
		if (Path.class.isAssignableFrom(type) && spec instanceof OptionSpec os) {
			return new CLIPath(form, parent, style, os);
		}
		if (spec.isMultiValue()) {
			if (Collection.class.isAssignableFrom(type)) {
				return new CLICollection(form, parent, style, spec);
			}
		}
		
		if (spec instanceof OptionSpec os) {
			log.warn("Unsupported option type {} for option {}", type, os.longestName());	
		} else {
			log.warn("Unsupported positional parameter type {}", type);
		}
		return null;
	}
}
