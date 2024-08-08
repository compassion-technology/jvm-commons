package com.compassion.commons.cli;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.Utilities;

import picocli.CommandLine;
import picocli.CommandLine.Help;
import picocli.CommandLine.Help.Column;
import picocli.CommandLine.Help.Column.Overflow;
import picocli.CommandLine.Help.TextTable;
import picocli.CommandLine.IHelpSectionRenderer;
import picocli.CommandLine.Model.UsageMessageSpec;

// Adapted from https://github.com/remkop/picocli/blob/main/picocli-examples/src/main/java/picocli/examples/customhelp/ShowCommandHierarchy.java
public class CommandTreeHelp implements IHelpSectionRenderer {
    @Override
	public String render(Help help) {
        var spec = help.commandSpec();
        if (spec.subcommands().isEmpty()) { return StringUtils.EMPTY; }

        // prepare layout: two columns
        // the left column overflows, the right column wraps if text is too long
        var textTable = TextTable.forColumns(help.colorScheme(),
        		new Column(18, 2, Overflow.SPAN),
                new Column(spec.usageMessage().width() - 15, 2, Overflow.WRAP));
        textTable.setAdjustLineBreaksForWideCJKCharacters(spec.usageMessage().adjustLineBreaksForWideCJKCharacters());

        spec.subcommands().forEach(($, sub) -> addHierarchy(sub, textTable, StringUtils.EMPTY));
        return textTable.toString();
    }

    private void addHierarchy(CommandLine cmd, TextTable textTable, String indent) {
        // create comma-separated list of command name and aliases
        var names = cmd.getCommandSpec().names().toString();
        names = names.substring(1, names.length() - 1); // remove leading '[' and trailing ']'

        // command description is taken from header or description
        var description = description(cmd.getCommandSpec().usageMessage());

        // add a line for this command to the layout
        textTable.addRowValues(indent + names, description);

        // add its subcommands (if any)
        cmd.getSubcommands().forEach(($, sub) -> addHierarchy(sub, textTable, indent + "  "));
    }

    private static String description(UsageMessageSpec usageMessage) {
    	return Objects.toString(
    		StringUtils.firstNonEmpty(Utilities.first(usageMessage.header()), Utilities.first(usageMessage.description())),
    	StringUtils.EMPTY);
    }
}