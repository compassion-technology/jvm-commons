/* ©2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.tui;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.AnsiConsole.out;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Erase;
import org.jooq.lambda.Seq;

import com.compassion.commons.utf.UnicodeChars;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import lombok.experimental.Accessors;

/**
 * A chooser allows the user to pick one (or more) selections using an ANSI "dialog".
 * 
 * @author <a href="dimeo@elderresearch.com">John Dimeo</a>
 * @since Jun 28, 2020
 * @param <T> the specific choice type
 */
@Setter @Accessors(fluent = true, chain = true)
public class Chooser<T extends Choice> {
	public enum SelectAllMode {
		ALL {
			@Override
			void apply(Choice c, boolean anySelected) { c.selected(!anySelected); }
		},
		RESTORE_DEFAULTS {
			@Override
			void apply(Choice c, boolean anySelected) { c.selected(anySelected? false : c.selectedByDefault()); }
		};

		abstract void apply(Choice c, boolean anySelected);
	}
	
	@Getter private List<T> choices;
	
	private String title, prompt;
	private String selectNoneMessage, selectAllMessage = "Restore defaults";
	private SelectAllMode selectAllMode = SelectAllMode.RESTORE_DEFAULTS;
	private boolean selectMultiple = true;
	
	private char selectionChar = UnicodeChars.BLACK_SQUARE;
	private int choiceNameMaxWidth = 12;
	
	@SuppressWarnings("resource")
	public void show() {
		out().println(ansi().a(Ansi.Attribute.NEGATIVE_ON)
			.a(" > ").a(UnicodeChars.BOX_DRAWINGS_LIGHT_VERTICAL)
			.a(StringUtils.SPACE).a(title).a(StringUtils.SPACE).reset());
		
		boolean exit = false, first = true, error = false;
		val s = new Scanner(System.in);
		do {
			val anySel = anySelected();
			
			val a = first? ansi().saveCursorPosition() : ansi().restoreCursorPosition();
			if (selectMultiple) {
				out().println(a.eraseLine().a(" 0 ").a(UnicodeChars.BOX_DRAWINGS_LIGHT_VERTICAL).a(StringUtils.SPACE)
					.a(anySel? selectNoneMessage : selectAllMessage));
			} else {
				out().print(a);
			}
			
			choices.forEach(c -> out().println(toAnsi(c)));
			
			out().print(ansi().eraseLine()
				.a("Type a number to toggle ").a(prompt).a(" or press ")
				.bold().a("[Enter]").boldOff().a(" to continue: "));
			
			val input = s.hasNextLine()? s.nextLine() : StringUtils.EMPTY;
			val num = NumberUtils.toInt(input, -1);
			if (selectMultiple && num == 0) {
				Seq.seq(choices).forEach($ -> selectAllMode.apply($, anySel));
				if (error) { clearPreviousLines(1); }
				error = false;
			} else if (num > 0 && num <= choices.size()) {
				val sel = choices.get(num - 1).toggle();
				if (!selectMultiple) {
					if (sel) {
						Seq.seq(choices).filter($ -> $.ordinal() != num).forEach($ -> $.selected(false));
					} else {
						Seq.seq(choices).filter($ -> $.ordinal() != num).findAny().ifPresent($ -> $.selected(true));
					}
				}
				if (error) { clearPreviousLines(1); }
				error = false;
			} else if (!(exit = StringUtils.isBlank(input))) {
				out().print(ansi().fgBrightRed()
					.a(" ! ").a(UnicodeChars.BOX_DRAWINGS_LIGHT_VERTICAL)
					.a(" Invalid input - please try again").reset());
				error = true;
			} else {
				clearPreviousLines(error? 2 : 1);
			}
			first = false;
		} while (!exit);
	}
	
	private static void clearPreviousLines(int n) {
		val a = ansi();
		while (n-- > 0) { a.cursorUpLine().eraseLine(Erase.ALL); }
		out().print(a);
	}
	
	private boolean anySelected() {
		return Seq.seq(choices).anyMatch(Choice::selected);
	}
	
	private Ansi toAnsi(Choice c) {
		val a = ansi().format("%2d ", c.ordinal()).a(UnicodeChars.BOX_DRAWINGS_LIGHT_VERTICAL).a(" ");
		if (c.selected()) { a.fgBrightGreen().a(selectionChar).a(StringUtils.SPACE).reset(); } else { a.a("  "); }
		if (c.selected()) { a.bold().bgBrightDefault(); } else { a.a(Ansi.Attribute.STRIKETHROUGH_ON); }
		return a.a(c.name()).reset()
				.a(StringUtils.repeat(' ', choiceNameMaxWidth - c.name().length()))
				.fgBrightBlack().a(c.description()).reset();
	}
}
