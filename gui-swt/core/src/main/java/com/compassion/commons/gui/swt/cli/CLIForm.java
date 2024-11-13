package com.compassion.commons.gui.swt.cli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.jooq.lambda.Seq;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.gui.swt.controls.CScrolledComposite;
import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
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
	private Color invalidColor;
	private Control extraSpace;
	
	public CLIForm(ResourceManager rm, Composite parent) {
		super(parent, SWT.HORIZONTAL | SWT.VERTICAL);
		this.rm = rm;
		this.cliArgs = new ArrayList<>();
		
		// TODO: Dark mode
		invalidColor = rm.getColor(255, 200, 200);
	}
	
	@Override
	public ResourceManager resourceManager() { return rm; }
	
	public void init(CommandSpec spec) {
		setLayout(grid(3).get());
		var sepData = gridData().hFill().hSpan(3).get();
		
		SWTUtilities.addSeperator(rm, this, "Command", null, SWT.TOP | SWT.BOLD).setLayoutData(sepData);

		// TODO: Support arbitrary levels of nesting, not just a top level group followed by specific commands
		
		label(this).text("&Group:").layoutData(gridData().hAlign(SWT.TRAIL));
		var groupCombo = this.<CLICommand>combo(this).layoutData(gridData().hFill().width(100));
	
		var groups = new ObservableSelection<>(groupCombo);
		groups.items().set(CLICommand.wrap(spec.subcommands().values()));
	
		var groupTooltip = label(this).layoutData(gridData());
	
		label(this).text("&Command:").layoutData(gridData().hAlign(SWT.TRAIL));
		var commandCombo = this.<CLICommand>combo(this).layoutData(gridData().hFill().width(100));
	
		var commands = new ObservableSelection<>(commandCombo);
	
		var commandTooltip = label(this).layoutData(gridData());
	
		var opts = new LinkedList<CLIOption<?>>();
		
		groups.selection().addObserver(sel -> {
			var g = Utilities.first(sel);
			groupTooltip.text(StringUtils.normalizeSpace(g.getDescription()));
			commands.items().set(g.getSubcommands());
			opts.forEach(CLIOption::dispose);
			opts.clear();
			autoSize();
		});
		
		var previewCopy = button(this).text("Copy").image(rm.getImage(IconsMS.COPY)).layoutData(gridData().hAlign(SWT.TRAIL));		
		var preview = text(this)
			.readOnly()
			.font(rm.getFont("Courier New", 10, SWT.NONE))
			.layoutData(gridData().hFill().hSpan(2).hGrab())
			.get();
		preview.setText(spec.name() + " ...");
		previewCopy.onSelect(e -> {
			preview.selectAll();
			preview.copy();
			preview.clearSelection();
		});
		
		Listener argListener = e -> {
			cliArgs.clear();
			cliArgs.add(spec.name());
			cliArgs.add(groupCombo.get().getText());
			cliArgs.add(commandCombo.get().getText());
			for (var opt : opts) {
				cliArgs.addAll(opt.getCliArgs());
			}
			preview.setText(String.join(StringUtils.SPACE, cliArgs));
		};
		groupCombo.get().addListener(SWT.Selection, argListener);
		commandCombo.get().addListener(SWT.Selection, argListener);
		
		SWTUtilities.addSeperator(rm, this, "Options", null, SWT.BOLD).setLayoutData(sepData);
		extraSpace = label(this).layoutData(gridData().hSpan(3).vAlign(SWT.TOP).grab())
			.font(rm.getFont(10, SWT.ITALIC))
			.text("Select a command above to see its options").get();
		
		commands.selection().addObserver(sel -> {
			var c = Utilities.first(sel);
			if (c != null) {
				commandTooltip.text(StringUtils.normalizeSpace(c.getDescription()));
				
				opts.forEach(CLIOption::dispose);
				opts.clear();
				extraSpace.dispose();
				for (var pp : c.getCommandSpec().positionalParameters()) {
					LambdaUtils.accept(CLIOption.newOption(this, pp), opts::add);
				}
				for (var opt : Seq.seq(c.getCommandSpec().options()).sorted($ -> $.order())) {
					LambdaUtils.accept(CLIOption.newOption(this, opt), opts::add);
				}
				opts.forEach($ -> $.addArgListener(argListener));
				extraSpace = label(this).layoutData(gridData().hSpan(3).grab()).get();
				autoSize();
			}
		});
	}
}
