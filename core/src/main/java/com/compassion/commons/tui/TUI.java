package com.compassion.commons.tui;

import java.util.function.Consumer;

import org.apache.commons.lang3.BooleanUtils;
import org.fusesource.jansi.Ansi;

/**
 * Convenience utilities for Text-based User Interfaces (TUI)
 */
public class TUI {
	public static void waitForEnter() {
		System.console().readLine();
	}
	
	public static String readLine(Consumer<Ansi> ansiPrompt) {
		var a = Ansi.ansi();
		ansiPrompt.accept(a);
		a.reset();
		return System.console().readLine(a.toString());
	}
	
	public static boolean readBoolean(String prompt, Object... args) {
		return BooleanUtils.toBoolean(System.console().readLine(prompt, args));
	}
	
	public static boolean shouldContinue() {
		return readBoolean("To continue, type 'y' or 'yes': ");
	}
}
