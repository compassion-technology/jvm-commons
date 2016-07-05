/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

/**
 * Declares commonly used special characters by their unicode (i.e. <tt>\u00A1</tt>) for use in
 * plain ASCII files.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Dec 29, 2012
 */
public final class UnicodeChars {
	private UnicodeChars() {
		// Prevent initialization
	}
	
	public static final char INVERTED_EXCLAMATION_MARK = '\u00A1';
	public static final char MULTIPLICATION_SIGN       = '\u00D7';
	public static final char COPYRIGHT_SIGN            = '\u00A9';
	public static final char REGISTERED_SIGN           = '\u00AE';
	public static final char DEGREE_SIGN               = '\u00B0';
    public static final char PILCROW_SIGN              = '\u00B6'; 
    public static final char SUPERSCRIPT_ONE           = '\u00B9';
    public static final char SUPERSCRIPT_TWO           = '\u00B2';
    public static final char MODIFIER_LETTER_CAPITAL_P = '\u1D3E';
    public static final char DIVISION_SIGN             = '\u00F7';
    public static final char HORIZONTAL_ELLIPSIS       = '\u2026';
    public static final char VERTICAL_FOUR_DOTS        = '\u205E';
    public static final char INFINITY                  = '\u221E';
    
    public static final char BOX_DRAW_LIGHT_HORIZ      = '\u2500';
    public static final char BOX_DRAW_LIGHT_VERT       = '\u2502';
    public static final char BOX_DRAW_LIGHT_DN_RT      = '\u250C';
    public static final char BOX_DRAW_LIGHT_DN_LF      = '\u2510';
    public static final char BOX_DRAW_LIGHT_UP_RT      = '\u2514';
    public static final char BOX_DRAW_LIGHT_UP_LF      = '\u2518';
    public static final char BOX_DRAW_LIGHT_VERT_RT    = '\u251C';
    public static final char BOX_DRAW_LIGHT_VERT_LT    = '\u2524';
    public static final char BOX_DRAW_LIGHT_DN_HORIZ   = '\u252C';
    public static final char BOX_DRAW_LIGHT_UP_HORIZ   = '\u2534';
    public static final char BOX_DRAW_LIGHT_VERT_HORIZ = '\u253C';
    
    public static final char LIGHT_SHADE               = '\u2591';
    public static final char MEDIUM_SHADE              = '\u2592';
    public static final char DARK_SHADE                = '\u2593';
    public static final char BLACK_SQUARE              = '\u25A0';
    public static final char WHITE_SQUARE              = '\u25A1';
}
