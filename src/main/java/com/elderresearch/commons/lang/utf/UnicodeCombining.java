/*******************************************************************************
 * Copyright (c) 2019 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.utf;

// CHECKSTYLE:OFF
public interface UnicodeCombining {
    /** ̀ of type NON_SPACING_MARK */
    char COMBINING_GRAVE_ACCENT = '\u0300';
    /** ́ of type NON_SPACING_MARK */
    char COMBINING_ACUTE_ACCENT = '\u0301';
    /** ̂ of type NON_SPACING_MARK */
    char COMBINING_CIRCUMFLEX_ACCENT = '\u0302';
    /** ̃ of type NON_SPACING_MARK */
    char COMBINING_TILDE = '\u0303';
    /** ̄ of type NON_SPACING_MARK */
    char COMBINING_MACRON = '\u0304';
    /** ̅ of type NON_SPACING_MARK */
    char COMBINING_OVERLINE = '\u0305';
    /** ̆ of type NON_SPACING_MARK */
    char COMBINING_BREVE = '\u0306';
    /** ̇ of type NON_SPACING_MARK */
    char COMBINING_DOT_ABOVE = '\u0307';
    /** ̈ of type NON_SPACING_MARK */
    char COMBINING_DIAERESIS = '\u0308';
    /** ̉ of type NON_SPACING_MARK */
    char COMBINING_HOOK_ABOVE = '\u0309';
    /** ̊ of type NON_SPACING_MARK */
    char COMBINING_RING_ABOVE = '\u030A';
    /** ̋ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_ACUTE_ACCENT = '\u030B';
    /** ̌ of type NON_SPACING_MARK */
    char COMBINING_CARON = '\u030C';
    /** ̍ of type NON_SPACING_MARK */
    char COMBINING_VERTICAL_LINE_ABOVE = '\u030D';
    /** ̎ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_VERTICAL_LINE_ABOVE = '\u030E';
    /** ̏ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_GRAVE_ACCENT = '\u030F';
    /** ̐ of type NON_SPACING_MARK */
    char COMBINING_CANDRABINDU = '\u0310';
    /** ̑ of type NON_SPACING_MARK */
    char COMBINING_INVERTED_BREVE = '\u0311';
    /** ̒ of type NON_SPACING_MARK */
    char COMBINING_TURNED_COMMA_ABOVE = '\u0312';
    /** ̓ of type NON_SPACING_MARK */
    char COMBINING_COMMA_ABOVE = '\u0313';
    /** ̔ of type NON_SPACING_MARK */
    char COMBINING_REVERSED_COMMA_ABOVE = '\u0314';
    /** ̕ of type NON_SPACING_MARK */
    char COMBINING_COMMA_ABOVE_RIGHT = '\u0315';
    /** ̖ of type NON_SPACING_MARK */
    char COMBINING_GRAVE_ACCENT_BELOW = '\u0316';
    /** ̗ of type NON_SPACING_MARK */
    char COMBINING_ACUTE_ACCENT_BELOW = '\u0317';
    /** ̘ of type NON_SPACING_MARK */
    char COMBINING_LEFT_TACK_BELOW = '\u0318';
    /** ̙ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_TACK_BELOW = '\u0319';
    /** ̚ of type NON_SPACING_MARK */
    char COMBINING_LEFT_ANGLE_ABOVE = '\u031A';
    /** ̛ of type NON_SPACING_MARK */
    char COMBINING_HORN = '\u031B';
    /** ̜ of type NON_SPACING_MARK */
    char COMBINING_LEFT_HALF_RING_BELOW = '\u031C';
    /** ̝ of type NON_SPACING_MARK */
    char COMBINING_UP_TACK_BELOW = '\u031D';
    /** ̞ of type NON_SPACING_MARK */
    char COMBINING_DOWN_TACK_BELOW = '\u031E';
    /** ̟ of type NON_SPACING_MARK */
    char COMBINING_PLUS_SIGN_BELOW = '\u031F';
    /** ̠ of type NON_SPACING_MARK */
    char COMBINING_MINUS_SIGN_BELOW = '\u0320';
    /** ̡ of type NON_SPACING_MARK */
    char COMBINING_PALATALIZED_HOOK_BELOW = '\u0321';
    /** ̢ of type NON_SPACING_MARK */
    char COMBINING_RETROFLEX_HOOK_BELOW = '\u0322';
    /** ̣ of type NON_SPACING_MARK */
    char COMBINING_DOT_BELOW = '\u0323';
    /** ̤ of type NON_SPACING_MARK */
    char COMBINING_DIAERESIS_BELOW = '\u0324';
    /** ̥ of type NON_SPACING_MARK */
    char COMBINING_RING_BELOW = '\u0325';
    /** ̦ of type NON_SPACING_MARK */
    char COMBINING_COMMA_BELOW = '\u0326';
    /** ̧ of type NON_SPACING_MARK */
    char COMBINING_CEDILLA = '\u0327';
    /** ̨ of type NON_SPACING_MARK */
    char COMBINING_OGONEK = '\u0328';
    /** ̩ of type NON_SPACING_MARK */
    char COMBINING_VERTICAL_LINE_BELOW = '\u0329';
    /** ̪ of type NON_SPACING_MARK */
    char COMBINING_BRIDGE_BELOW = '\u032A';
    /** ̫ of type NON_SPACING_MARK */
    char COMBINING_INVERTED_DOUBLE_ARCH_BELOW = '\u032B';
    /** ̬ of type NON_SPACING_MARK */
    char COMBINING_CARON_BELOW = '\u032C';
    /** ̭ of type NON_SPACING_MARK */
    char COMBINING_CIRCUMFLEX_ACCENT_BELOW = '\u032D';
    /** ̮ of type NON_SPACING_MARK */
    char COMBINING_BREVE_BELOW = '\u032E';
    /** ̯ of type NON_SPACING_MARK */
    char COMBINING_INVERTED_BREVE_BELOW = '\u032F';
    /** ̰ of type NON_SPACING_MARK */
    char COMBINING_TILDE_BELOW = '\u0330';
    /** ̱ of type NON_SPACING_MARK */
    char COMBINING_MACRON_BELOW = '\u0331';
    /** ̲ of type NON_SPACING_MARK */
    char COMBINING_LOW_LINE = '\u0332';
    /** ̳ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_LOW_LINE = '\u0333';
    /** ̴ of type NON_SPACING_MARK */
    char COMBINING_TILDE_OVERLAY = '\u0334';
    /** ̵ of type NON_SPACING_MARK */
    char COMBINING_SHORT_STROKE_OVERLAY = '\u0335';
    /** ̶ of type NON_SPACING_MARK */
    char COMBINING_LONG_STROKE_OVERLAY = '\u0336';
    /** ̷ of type NON_SPACING_MARK */
    char COMBINING_SHORT_SOLIDUS_OVERLAY = '\u0337';
    /** ̸ of type NON_SPACING_MARK */
    char COMBINING_LONG_SOLIDUS_OVERLAY = '\u0338';
    /** ̹ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_HALF_RING_BELOW = '\u0339';
    /** ̺ of type NON_SPACING_MARK */
    char COMBINING_INVERTED_BRIDGE_BELOW = '\u033A';
    /** ̻ of type NON_SPACING_MARK */
    char COMBINING_SQUARE_BELOW = '\u033B';
    /** ̼ of type NON_SPACING_MARK */
    char COMBINING_SEAGULL_BELOW = '\u033C';
    /** ̽ of type NON_SPACING_MARK */
    char COMBINING_X_ABOVE = '\u033D';
    /** ̾ of type NON_SPACING_MARK */
    char COMBINING_VERTICAL_TILDE = '\u033E';
    /** ̿ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_OVERLINE = '\u033F';
    /** ̀ of type NON_SPACING_MARK */
    char COMBINING_GRAVE_TONE_MARK = '\u0340';
    /** ́ of type NON_SPACING_MARK */
    char COMBINING_ACUTE_TONE_MARK = '\u0341';
    /** ͂ of type NON_SPACING_MARK */
    char COMBINING_GREEK_PERISPOMENI = '\u0342';
    /** ̓ of type NON_SPACING_MARK */
    char COMBINING_GREEK_KORONIS = '\u0343';
    /** ̈́ of type NON_SPACING_MARK */
    char COMBINING_GREEK_DIALYTIKA_TONOS = '\u0344';
    /** ͅ of type NON_SPACING_MARK */
    char COMBINING_GREEK_YPOGEGRAMMENI = '\u0345';
    /** ͆ of type NON_SPACING_MARK */
    char COMBINING_BRIDGE_ABOVE = '\u0346';
    /** ͇ of type NON_SPACING_MARK */
    char COMBINING_EQUALS_SIGN_BELOW = '\u0347';
    /** ͈ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_VERTICAL_LINE_BELOW = '\u0348';
    /** ͉ of type NON_SPACING_MARK */
    char COMBINING_LEFT_ANGLE_BELOW = '\u0349';
    /** ͊ of type NON_SPACING_MARK */
    char COMBINING_NOT_TILDE_ABOVE = '\u034A';
    /** ͋ of type NON_SPACING_MARK */
    char COMBINING_HOMOTHETIC_ABOVE = '\u034B';
    /** ͌ of type NON_SPACING_MARK */
    char COMBINING_ALMOST_EQUAL_TO_ABOVE = '\u034C';
    /** ͍ of type NON_SPACING_MARK */
    char COMBINING_LEFT_RIGHT_ARROW_BELOW = '\u034D';
    /** ͎ of type NON_SPACING_MARK */
    char COMBINING_UPWARDS_ARROW_BELOW = '\u034E';
    /** ͏ of type NON_SPACING_MARK */
    char COMBINING_GRAPHEME_JOINER = '\u034F';
    /** ͐ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_ARROWHEAD_ABOVE = '\u0350';
    /** ͑ of type NON_SPACING_MARK */
    char COMBINING_LEFT_HALF_RING_ABOVE = '\u0351';
    /** ͒ of type NON_SPACING_MARK */
    char COMBINING_FERMATA = '\u0352';
    /** ͓ of type NON_SPACING_MARK */
    char COMBINING_X_BELOW = '\u0353';
    /** ͔ of type NON_SPACING_MARK */
    char COMBINING_LEFT_ARROWHEAD_BELOW = '\u0354';
    /** ͕ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_ARROWHEAD_BELOW = '\u0355';
    /** ͖ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_ARROWHEAD_AND_UP_ARROWHEAD_BELOW = '\u0356';
    /** ͗ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_HALF_RING_ABOVE = '\u0357';
    /** ͘ of type NON_SPACING_MARK */
    char COMBINING_DOT_ABOVE_RIGHT = '\u0358';
    /** ͙ of type NON_SPACING_MARK */
    char COMBINING_ASTERISK_BELOW = '\u0359';
    /** ͚ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_RING_BELOW = '\u035A';
    /** ͛ of type NON_SPACING_MARK */
    char COMBINING_ZIGZAG_ABOVE = '\u035B';
    /** ͜ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_BREVE_BELOW = '\u035C';
    /** ͝ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_BREVE = '\u035D';
    /** ͞ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_MACRON = '\u035E';
    /** ͟ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_MACRON_BELOW = '\u035F';
    /** ͠ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_TILDE = '\u0360';
    /** ͡ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_INVERTED_BREVE = '\u0361';
    /** ͢ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_RIGHTWARDS_ARROW_BELOW = '\u0362';
    /** ͣ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_A = '\u0363';
    /** ͤ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_E = '\u0364';
    /** ͥ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_I = '\u0365';
    /** ͦ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_O = '\u0366';
    /** ͧ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_U = '\u0367';
    /** ͨ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_C = '\u0368';
    /** ͩ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_D = '\u0369';
    /** ͪ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_H = '\u036A';
    /** ͫ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_M = '\u036B';
    /** ͬ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_R = '\u036C';
    /** ͭ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_T = '\u036D';
    /** ͮ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_V = '\u036E';
    /** ͯ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_X = '\u036F';
    /** ҃ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_TITLO = '\u0483';
    /** ҄ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_PALATALIZATION = '\u0484';
    /** ҅ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_DASIA_PNEUMATA = '\u0485';
    /** ҆ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_PSILI_PNEUMATA = '\u0486';
    /** ҇ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_POKRYTIE = '\u0487';
    /** ҈ of type ENCLOSING_MARK */
    char COMBINING_CYRILLIC_HUNDRED_THOUSANDS_SIGN = '\u0488';
    /** ҉ of type ENCLOSING_MARK */
    char COMBINING_CYRILLIC_MILLIONS_SIGN = '\u0489';
    /** ᷀ of type NON_SPACING_MARK */
    char COMBINING_DOTTED_GRAVE_ACCENT = '\u1DC0';
    /** ᷁ of type NON_SPACING_MARK */
    char COMBINING_DOTTED_ACUTE_ACCENT = '\u1DC1';
    /** ᷂ of type NON_SPACING_MARK */
    char COMBINING_SNAKE_BELOW = '\u1DC2';
    /** ᷃ of type NON_SPACING_MARK */
    char COMBINING_SUSPENSION_MARK = '\u1DC3';
    /** ᷄ of type NON_SPACING_MARK */
    char COMBINING_MACRON_ACUTE = '\u1DC4';
    /** ᷅ of type NON_SPACING_MARK */
    char COMBINING_GRAVE_MACRON = '\u1DC5';
    /** ᷆ of type NON_SPACING_MARK */
    char COMBINING_MACRON_GRAVE = '\u1DC6';
    /** ᷇ of type NON_SPACING_MARK */
    char COMBINING_ACUTE_MACRON = '\u1DC7';
    /** ᷈ of type NON_SPACING_MARK */
    char COMBINING_GRAVE_ACUTE_GRAVE = '\u1DC8';
    /** ᷉ of type NON_SPACING_MARK */
    char COMBINING_ACUTE_GRAVE_ACUTE = '\u1DC9';
    /** ᷊ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_R_BELOW = '\u1DCA';
    /** ᷋ of type NON_SPACING_MARK */
    char COMBINING_BREVE_MACRON = '\u1DCB';
    /** ᷌ of type NON_SPACING_MARK */
    char COMBINING_MACRON_BREVE = '\u1DCC';
    /** ᷍ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_CIRCUMFLEX_ABOVE = '\u1DCD';
    /** ᷎ of type NON_SPACING_MARK */
    char COMBINING_OGONEK_ABOVE = '\u1DCE';
    /** ᷏ of type NON_SPACING_MARK */
    char COMBINING_ZIGZAG_BELOW = '\u1DCF';
    /** ᷐ of type NON_SPACING_MARK */
    char COMBINING_IS_BELOW = '\u1DD0';
    /** ᷑ of type NON_SPACING_MARK */
    char COMBINING_UR_ABOVE = '\u1DD1';
    /** ᷒ of type NON_SPACING_MARK */
    char COMBINING_US_ABOVE = '\u1DD2';
    /** ᷓ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_FLATTENED_OPEN_A_ABOVE = '\u1DD3';
    /** ᷔ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_AE = '\u1DD4';
    /** ᷕ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_AO = '\u1DD5';
    /** ᷖ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_AV = '\u1DD6';
    /** ᷗ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_C_CEDILLA = '\u1DD7';
    /** ᷘ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_INSULAR_D = '\u1DD8';
    /** ᷙ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_ETH = '\u1DD9';
    /** ᷚ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_G = '\u1DDA';
    /** ᷛ of type NON_SPACING_MARK */
    char COMBINING_LATIN_LETTER_SMALL_CAPITAL_G = '\u1DDB';
    /** ᷜ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_K = '\u1DDC';
    /** ᷝ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_L = '\u1DDD';
    /** ᷞ of type NON_SPACING_MARK */
    char COMBINING_LATIN_LETTER_SMALL_CAPITAL_L = '\u1DDE';
    /** ᷟ of type NON_SPACING_MARK */
    char COMBINING_LATIN_LETTER_SMALL_CAPITAL_M = '\u1DDF';
    /** ᷠ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_N = '\u1DE0';
    /** ᷡ of type NON_SPACING_MARK */
    char COMBINING_LATIN_LETTER_SMALL_CAPITAL_N = '\u1DE1';
    /** ᷢ of type NON_SPACING_MARK */
    char COMBINING_LATIN_LETTER_SMALL_CAPITAL_R = '\u1DE2';
    /** ᷣ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_R_ROTUNDA = '\u1DE3';
    /** ᷤ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_S = '\u1DE4';
    /** ᷥ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_LONG_S = '\u1DE5';
    /** ᷦ of type NON_SPACING_MARK */
    char COMBINING_LATIN_SMALL_LETTER_Z = '\u1DE6';
    /** ᷼ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_INVERTED_BREVE_BELOW = '\u1DFC';
    /** ᷽ of type NON_SPACING_MARK */
    char COMBINING_ALMOST_EQUAL_TO_BELOW = '\u1DFD';
    /** ᷾ of type NON_SPACING_MARK */
    char COMBINING_LEFT_ARROWHEAD_ABOVE = '\u1DFE';
    /** ᷿ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_ARROWHEAD_AND_DOWN_ARROWHEAD_BELOW = '\u1DFF';
    /** ⃐ of type NON_SPACING_MARK */
    char COMBINING_LEFT_HARPOON_ABOVE = '\u20D0';
    /** ⃑ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_HARPOON_ABOVE = '\u20D1';
    /** ⃒ of type NON_SPACING_MARK */
    char COMBINING_LONG_VERTICAL_LINE_OVERLAY = '\u20D2';
    /** ⃓ of type NON_SPACING_MARK */
    char COMBINING_SHORT_VERTICAL_LINE_OVERLAY = '\u20D3';
    /** ⃔ of type NON_SPACING_MARK */
    char COMBINING_ANTICLOCKWISE_ARROW_ABOVE = '\u20D4';
    /** ⃕ of type NON_SPACING_MARK */
    char COMBINING_CLOCKWISE_ARROW_ABOVE = '\u20D5';
    /** ⃖ of type NON_SPACING_MARK */
    char COMBINING_LEFT_ARROW_ABOVE = '\u20D6';
    /** ⃗ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_ARROW_ABOVE = '\u20D7';
    /** ⃘ of type NON_SPACING_MARK */
    char COMBINING_RING_OVERLAY = '\u20D8';
    /** ⃙ of type NON_SPACING_MARK */
    char COMBINING_CLOCKWISE_RING_OVERLAY = '\u20D9';
    /** ⃚ of type NON_SPACING_MARK */
    char COMBINING_ANTICLOCKWISE_RING_OVERLAY = '\u20DA';
    /** ⃛ of type NON_SPACING_MARK */
    char COMBINING_THREE_DOTS_ABOVE = '\u20DB';
    /** ⃜ of type NON_SPACING_MARK */
    char COMBINING_FOUR_DOTS_ABOVE = '\u20DC';
    /** ⃝ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_CIRCLE = '\u20DD';
    /** ⃞ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_SQUARE = '\u20DE';
    /** ⃟ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_DIAMOND = '\u20DF';
    /** ⃠ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_CIRCLE_BACKSLASH = '\u20E0';
    /** ⃡ of type NON_SPACING_MARK */
    char COMBINING_LEFT_RIGHT_ARROW_ABOVE = '\u20E1';
    /** ⃢ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_SCREEN = '\u20E2';
    /** ⃣ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_KEYCAP = '\u20E3';
    /** ⃤ of type ENCLOSING_MARK */
    char COMBINING_ENCLOSING_UPWARD_POINTING_TRIANGLE = '\u20E4';
    /** ⃥ of type NON_SPACING_MARK */
    char COMBINING_REVERSE_SOLIDUS_OVERLAY = '\u20E5';
    /** ⃦ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_VERTICAL_STROKE_OVERLAY = '\u20E6';
    /** ⃧ of type NON_SPACING_MARK */
    char COMBINING_ANNUITY_SYMBOL = '\u20E7';
    /** ⃨ of type NON_SPACING_MARK */
    char COMBINING_TRIPLE_UNDERDOT = '\u20E8';
    /** ⃩ of type NON_SPACING_MARK */
    char COMBINING_WIDE_BRIDGE_ABOVE = '\u20E9';
    /** ⃪ of type NON_SPACING_MARK */
    char COMBINING_LEFTWARDS_ARROW_OVERLAY = '\u20EA';
    /** ⃫ of type NON_SPACING_MARK */
    char COMBINING_LONG_DOUBLE_SOLIDUS_OVERLAY = '\u20EB';
    /** ⃬ of type NON_SPACING_MARK */
    char COMBINING_RIGHTWARDS_HARPOON_WITH_BARB_DOWNWARDS = '\u20EC';
    /** ⃭ of type NON_SPACING_MARK */
    char COMBINING_LEFTWARDS_HARPOON_WITH_BARB_DOWNWARDS = '\u20ED';
    /** ⃮ of type NON_SPACING_MARK */
    char COMBINING_LEFT_ARROW_BELOW = '\u20EE';
    /** ⃯ of type NON_SPACING_MARK */
    char COMBINING_RIGHT_ARROW_BELOW = '\u20EF';
    /** ⃰ of type NON_SPACING_MARK */
    char COMBINING_ASTERISK_ABOVE = '\u20F0';
    /** ⷠ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_BE = '\u2DE0';
    /** ⷡ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_VE = '\u2DE1';
    /** ⷢ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_GHE = '\u2DE2';
    /** ⷣ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_DE = '\u2DE3';
    /** ⷤ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_ZHE = '\u2DE4';
    /** ⷥ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_ZE = '\u2DE5';
    /** ⷦ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_KA = '\u2DE6';
    /** ⷧ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_EL = '\u2DE7';
    /** ⷨ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_EM = '\u2DE8';
    /** ⷩ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_EN = '\u2DE9';
    /** ⷪ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_O = '\u2DEA';
    /** ⷫ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_PE = '\u2DEB';
    /** ⷬ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_ER = '\u2DEC';
    /** ⷭ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_ES = '\u2DED';
    /** ⷮ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_TE = '\u2DEE';
    /** ⷯ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_HA = '\u2DEF';
    /** ⷰ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_TSE = '\u2DF0';
    /** ⷱ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_CHE = '\u2DF1';
    /** ⷲ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_SHA = '\u2DF2';
    /** ⷳ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_SHCHA = '\u2DF3';
    /** ⷴ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_FITA = '\u2DF4';
    /** ⷵ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_ES_TE = '\u2DF5';
    /** ⷶ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_A = '\u2DF6';
    /** ⷷ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_IE = '\u2DF7';
    /** ⷸ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_DJERV = '\u2DF8';
    /** ⷹ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_MONOGRAPH_UK = '\u2DF9';
    /** ⷺ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_YAT = '\u2DFA';
    /** ⷻ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_YU = '\u2DFB';
    /** ⷼ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_IOTIFIED_A = '\u2DFC';
    /** ⷽ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_LITTLE_YUS = '\u2DFD';
    /** ⷾ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_BIG_YUS = '\u2DFE';
    /** ⷿ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_IOTIFIED_BIG_YUS = '\u2DFF';
    /** ゙ of type NON_SPACING_MARK */
    char COMBINING_KATAKANA_HIRAGANA_VOICED_SOUND_MARK = '\u3099';
    /** ゚ of type NON_SPACING_MARK */
    char COMBINING_KATAKANA_HIRAGANA_SEMI_VOICED_SOUND_MARK = '\u309A';
    /** ꙯ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_VZMET = '\uA66F';
    /** ꙰ of type ENCLOSING_MARK */
    char COMBINING_CYRILLIC_TEN_MILLIONS_SIGN = '\uA670';
    /** ꙱ of type ENCLOSING_MARK */
    char COMBINING_CYRILLIC_HUNDRED_MILLIONS_SIGN = '\uA671';
    /** ꙲ of type ENCLOSING_MARK */
    char COMBINING_CYRILLIC_THOUSAND_MILLIONS_SIGN = '\uA672';
    /** ꙴ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_UKRAINIAN_IE = '\uA674';
    /** ꙵ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_I = '\uA675';
    /** ꙶ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_YI = '\uA676';
    /** ꙷ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_U = '\uA677';
    /** ꙸ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_HARD_SIGN = '\uA678';
    /** ꙹ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_YERU = '\uA679';
    /** ꙺ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_SOFT_SIGN = '\uA67A';
    /** ꙻ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_OMEGA = '\uA67B';
    /** ꙼ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_KAVYKA = '\uA67C';
    /** ꙽ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_PAYEROK = '\uA67D';
    /** ꚟ of type NON_SPACING_MARK */
    char COMBINING_CYRILLIC_LETTER_IOTIFIED_E = '\uA69F';
    /** ꣠ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_ZERO = '\uA8E0';
    /** ꣡ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_ONE = '\uA8E1';
    /** ꣢ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_TWO = '\uA8E2';
    /** ꣣ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_THREE = '\uA8E3';
    /** ꣤ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_FOUR = '\uA8E4';
    /** ꣥ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_FIVE = '\uA8E5';
    /** ꣦ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_SIX = '\uA8E6';
    /** ꣧ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_SEVEN = '\uA8E7';
    /** ꣨ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_EIGHT = '\uA8E8';
    /** ꣩ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_DIGIT_NINE = '\uA8E9';
    /** ꣪ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_A = '\uA8EA';
    /** ꣫ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_U = '\uA8EB';
    /** ꣬ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_KA = '\uA8EC';
    /** ꣭ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_NA = '\uA8ED';
    /** ꣮ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_PA = '\uA8EE';
    /** ꣯ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_RA = '\uA8EF';
    /** ꣰ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_LETTER_VI = '\uA8F0';
    /** ꣱ of type NON_SPACING_MARK */
    char COMBINING_DEVANAGARI_SIGN_AVAGRAHA = '\uA8F1';
    /** ︠ of type NON_SPACING_MARK */
    char COMBINING_LIGATURE_LEFT_HALF = '\uFE20';
    /** ︡ of type NON_SPACING_MARK */
    char COMBINING_LIGATURE_RIGHT_HALF = '\uFE21';
    /** ︢ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_TILDE_LEFT_HALF = '\uFE22';
    /** ︣ of type NON_SPACING_MARK */
    char COMBINING_DOUBLE_TILDE_RIGHT_HALF = '\uFE23';
    /** ︤ of type NON_SPACING_MARK */
    char COMBINING_MACRON_LEFT_HALF = '\uFE24';
    /** ︥ of type NON_SPACING_MARK */
    char COMBINING_MACRON_RIGHT_HALF = '\uFE25';
    /** ︦ of type NON_SPACING_MARK */
    char COMBINING_CONJOINING_MACRON = '\uFE26';
}
// CHECKSTYLE:ON
