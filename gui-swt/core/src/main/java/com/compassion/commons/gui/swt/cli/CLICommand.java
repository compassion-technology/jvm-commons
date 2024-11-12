package com.compassion.commons.gui.swt.cli;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.jooq.lambda.Seq;

import lombok.Getter;
import lombok.experimental.Delegate;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;

public class CLICommand {
	private static final String HELP = HelpCommand.class.getAnnotation(Command.class).name();
	
	@Delegate
	private final CommandLine delegate;

	@Getter
	private String description;
	@Getter
	private List<CLICommand> subcommands;
	
	public CLICommand(CommandLine delegate) {
		this.delegate = delegate;
		this.description = delegate.getHelp().description();
		this.subcommands = wrap(delegate.getSubcommands().values());
	}
	
	@Override
	public String toString() {
		return delegate.getCommandName();
	}
	
	static List<CLICommand> wrap(Collection<CommandLine> subcommands) {
		// Don't include help commands in the UI
		return Seq.seq(subcommands)
			.map(CLICommand::new).filter($ -> !$.getCommandName().equals(HELP))
			.sorted(Comparator.comparing(CLICommand::getCommandName))
			.toList();
	}
}
