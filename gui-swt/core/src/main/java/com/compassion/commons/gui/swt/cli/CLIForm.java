package com.compassion.commons.gui.swt.cli;

import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.gui.swt.controls.CScrolledComposite;
import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
import com.compassion.commons.gui.swt.util.ResourceManager;
import com.compassion.commons.gui.swt.util.SWTUtilities;

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
	private Color invalidColor;
	
	public CLIForm(ResourceManager rm, Composite parent) {
		super(parent, SWT.HORIZONTAL | SWT.VERTICAL);
		this.rm = rm;
		setLayout(grid(3).get());
		
		// TODO: Dark mode
		invalidColor = rm.getColor(255, 200, 200);
	}
	
	@Override
	public ResourceManager resourceManager() { return rm; }
	
	public void init(CommandSpec spec) {
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
	
		groups.selection().addObserver(sel -> {
			var g = Utilities.first(sel);
			groupTooltip.text(StringUtils.normalizeSpace(g.getDescription()));
			commands.items().set(g.getSubcommands());
			autoSize();
		});
		
		SWTUtilities.addSeperator(rm, this, "Options", null, SWT.BOLD).setLayoutData(sepData);
		
		var opts = new LinkedList<CLIOption>();
		
		commands.selection().addObserver(sel -> {
			var c = Utilities.first(sel);
			if (c != null) {
				commandTooltip.text(StringUtils.normalizeSpace(c.getDescription()));
				
				opts.forEach(CLIOption::dispose);
				opts.clear();
				
				for (var pp : c.getCommandSpec().positionalParameters()) {
					LambdaUtils.accept(CLIOption.newOption(this, pp), opts::add);
				}
				for (var opt : c.getCommandSpec().options()) {
					LambdaUtils.accept(CLIOption.newOption(this, opt), opts::add);
				}
				autoSize();
			}
		});
	}
}
