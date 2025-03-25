package com.compassion.commons.gui.swt.cli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.jooq.lambda.Seq;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.gui.swt.controls.CScrolledComposite;
import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
import com.compassion.commons.gui.swt.util.MnemonicUtils;
import com.compassion.commons.gui.swt.util.ResourceManager;
import com.compassion.commons.gui.swt.util.SWTUtilities;
import com.elderresearch.commons.icons.ms.IconsMS;

import lombok.Getter;
import picocli.CommandLine.Model.CommandSpec;

/**
 * Creates a GUI form from a {@link CommandSpec}.
 * 
 * @author <a href="mailto:jdimeo@us.ci.org">John Dimeo</a>
 */
public class CLIForm extends CScrolledComposite implements SWTBuilders.WithResources {
	private ResourceManager rm;
	
	@Getter
	private final List<String> cliArgs;
	@Getter
	private Text command;
	
	@Getter
	private Color invalidColor;
	private Control extraSpace;
	
	private Listener argListener;
	
	public CLIForm(ResourceManager rm, Composite parent) {
		super(parent, SWT.HORIZONTAL | SWT.VERTICAL);
		this.rm = rm;
		this.cliArgs = new ArrayList<>();
		
		// TODO: Dark mode
		invalidColor = rm.getColor(255, 200, 200);
	}
	
	@Override
	public ResourceManager resourceManager() { return rm; }
	
	public void init(CommandSpec spec, String... levels) {
		setLayout(grid(3).get());
		var sepData = gridData().hFill().hSpan(3).get();
		
		SWTUtilities.addSeperator(rm, this, "Command", null, SWT.TOP | SWT.BOLD).setLayoutData(sepData);

		if (levels.length == 0) {
			levels = new String[] { "Command" };
		}
		
		var combos = new LinkedList<Combo>();
		var opts = new LinkedList<CLIOption<?>>();
		
		ObservableSelection<CLICommand> prev = null;
		var i = 0;
		for (var level : levels) {
			label(this).text(MnemonicUtils.getMnemonic(this, level, null) + ":").layoutData(gridData().hAlign(SWT.TRAIL));
			
			var combo = this.<CLICommand>combo(this).layoutData(gridData().hFill().width(100));
			combos.add(combo.get());
			
			var tooltip = label(this).layoutData(gridData());
			
			var sel = new ObservableSelection<>(combo);
			sel.selection().addObserver($ -> tooltip.text(StringUtils.normalizeSpace(Utilities.first($).getDescription())));
			
			if (prev == null) {
				sel.items().set(CLICommand.wrap(spec.subcommands().values()));
			} else {
				var levelIdx = i;
				prev.selection().addObserver($ -> {
					var cmd = Utilities.first($);
					if (cmd.getSubcommands().isEmpty()) {
						combos.subList(levelIdx, combos.size()).forEach(c -> {
							c.clearSelection();
							c.setEnabled(false);	
						});
						updateOptions(cmd, opts);
					} else {
						combo.enabled(true);
						sel.items().set(cmd.getSubcommands());						
					}
				});
			}
			prev = sel;
			i++;
		}
		prev.selection().addObserver($ -> updateOptions(Utilities.first($), opts));
		
		var commandCopy = button(this).text("Copy").image(rm.getImage(IconsMS.COPY)).layoutData(gridData().hAlign(SWT.TRAIL));		
		command = text(this)
			.readOnly()
			.font(rm.getFont("Courier New", 10, SWT.NONE))
			.layoutData(gridData().hFill().hSpan(2).hGrab())
			.get();
		command.setText(spec.name() + " ...");
		commandCopy.onSelect(e -> {
			command.selectAll();
			command.copy();
			command.clearSelection();
		});
		
		argListener = e -> {
			cliArgs.clear();
			cliArgs.add(spec.name());
			for (var cmd : combos) {
				cliArgs.add(cmd.getText());
			}
			for (var opt : opts) {
				cliArgs.addAll(opt.getCliArgs());
			}
			command.setText(String.join(StringUtils.SPACE, cliArgs));
		};
		for (var combo : combos) {
			combo.addListener(SWT.Selection, argListener);
		}
		
		SWTUtilities.addSeperator(rm, this, "Options", null, SWT.BOLD).setLayoutData(sepData);
		extraSpace = label(this).layoutData(gridData().hSpan(3).vAlign(SWT.TOP).grab())
			.font(rm.getFont(10, SWT.ITALIC))
			.text("Select a command above to see its options").get();
	}
	
	private void updateOptions(CLICommand c, List<CLIOption<?>> opts) {
		opts.forEach(CLIOption::dispose);
		opts.clear();
		extraSpace.dispose();
		for (var pp : c.getCommandSpec().positionalParameters()) {
			LambdaUtils.accept(CLIOption.withSpec(this, pp), opts::add);
		}
		for (var opt : Seq.seq(c.getCommandSpec().options()).sorted(o -> o.order())) {
			LambdaUtils.accept(CLIOption.withSpec(this, opt), opts::add);
		}
		opts.forEach(o -> o.addArgListener(argListener));
		extraSpace = label(this).layoutData(gridData().hSpan(3).fill()).get();
		autoSize();
	}
	
	public static String removeQuotes(String s) {
		if (s.length() > 3 && s.charAt(0) == '"' && s.charAt(s.length() - 1) == '"') {
			return s.substring(1, s.length() - 1);
		}
		return s;
	}
}
