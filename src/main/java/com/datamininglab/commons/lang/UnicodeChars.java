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
// CHECKSTYLE:OFF
public interface UnicodeChars {
	char INVERTED_EXCLAMATION_MARK  = '\u00A1';
	char MULTIPLICATION_SIGN        = '\u00D7';
	char COPYRIGHT_SIGN             = '\u00A9';
	char REGISTERED_SIGN            = '\u00AE';
	char DEGREE_SIGN                = '\u00B0';
    char PILCROW_SIGN               = '\u00B6';
    char REVERSED_PILCROW_SIGN      = '\u204B';
    char NUMERO_SIGN                = '\u2116';
    char SUPERSCRIPT_ONE            = '\u00B9';
    char SUPERSCRIPT_TWO            = '\u00B2';
    char MODIFIER_LETTER_CAPITAL_P  = '\u1D3E';
    char DIVISION_SIGN              = '\u00F7';
    char HORIZONTAL_ELLIPSIS        = '\u2026';
    char VERTICAL_FOUR_DOTS         = '\u205E';
    char INFINITY                   = '\u221E';
    
    char BOX_DRAW_LIGHT_HORIZ       = '\u2500';
    char BOX_DRAW_LIGHT_VERT        = '\u2502';
    char BOX_DRAW_LIGHT_DN_RT       = '\u250C';
    char BOX_DRAW_LIGHT_DN_LF       = '\u2510';
    char BOX_DRAW_LIGHT_UP_RT       = '\u2514';
    char BOX_DRAW_LIGHT_UP_LF       = '\u2518';
    char BOX_DRAW_LIGHT_VERT_RT     = '\u251C';
    char BOX_DRAW_LIGHT_VERT_LT     = '\u2524';
    char BOX_DRAW_LIGHT_DN_HORIZ    = '\u252C';
    char BOX_DRAW_LIGHT_UP_HORIZ    = '\u2534';
    char BOX_DRAW_LIGHT_VERT_HORIZ  = '\u253C';
    
    char LIGHT_SHADE                = '\u2591';
    char MEDIUM_SHADE               = '\u2592';
    char DARK_SHADE                 = '\u2593';
    char BLACK_SQUARE               = '\u25A0';
    char WHITE_SQUARE               = '\u25A1';
    
    char BLACK_LEFT_POINTING_INDEX  = '\u261A';
    char BLACK_RIGHT_POINTING_INDEX = '\u261B';
    char WHITE_LEFT_POINTING_INDEX  = '\u261C';
    char WHITE_UP_POINTING_INDEX    = '\u261D';
    char WHITE_RIGHT_POINTING_INDEX = '\u261E';
    char WHITE_DOWN_POINTING_INDEX  = '\u261F';
}
//CHECKSTYLE:ON