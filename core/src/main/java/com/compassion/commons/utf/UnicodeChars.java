package com.compassion.commons.utf;

// CHECKSTYLE:OFF
public interface UnicodeChars {
    /**   of type SPACE_SEPARATOR */
    char SPACE = '\u0020';
    /** ! of type OTHER_PUNCTUATION */
    char EXCLAMATION_MARK = '\u0021';
    /** " of type OTHER_PUNCTUATION */
    char QUOTATION_MARK = '\u0022';
    /** # of type OTHER_PUNCTUATION */
    char NUMBER_SIGN = '\u0023';
    /** $ of type CURRENCY_SYMBOL */
    char DOLLAR_SIGN = '\u0024';
    /** % of type OTHER_PUNCTUATION */
    char PERCENT_SIGN = '\u0025';
    /** & of type OTHER_PUNCTUATION */
    char AMPERSAND = '\u0026';
    /** ' of type OTHER_PUNCTUATION */
    char APOSTROPHE = '\'';
    /** ( of type START_PUNCTUATION */
    char LEFT_PARENTHESIS = '\u0028';
    /** ) of type END_PUNCTUATION */
    char RIGHT_PARENTHESIS = '\u0029';
    /** * of type OTHER_PUNCTUATION */
    char ASTERISK = '\u002A';
    /** + of type MATH_SYMBOL */
    char PLUS_SIGN = '\u002B';
    /** , of type OTHER_PUNCTUATION */
    char COMMA = '\u002C';
    /** - of type DASH_PUNCTUATION */
    char HYPHEN_MINUS = '\u002D';
    /** . of type OTHER_PUNCTUATION */
    char FULL_STOP = '\u002E';
    /** / of type OTHER_PUNCTUATION */
    char SOLIDUS = '\u002F';
    /** 0 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_ZERO = '\u0030';
    /** 1 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_ONE = '\u0031';
    /** 2 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_TWO = '\u0032';
    /** 3 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_THREE = '\u0033';
    /** 4 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_FOUR = '\u0034';
    /** 5 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_FIVE = '\u0035';
    /** 6 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_SIX = '\u0036';
    /** 7 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_SEVEN = '\u0037';
    /** 8 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_EIGHT = '\u0038';
    /** 9 of type DECIMAL_DIGIT_NUMBER */
    char DIGIT_NINE = '\u0039';
    /** : of type OTHER_PUNCTUATION */
    char COLON = '\u003A';
    /** ; of type OTHER_PUNCTUATION */
    char SEMICOLON = '\u003B';
    /** < of type MATH_SYMBOL */
    char LESS_THAN_SIGN = '\u003C';
    /** = of type MATH_SYMBOL */
    char EQUALS_SIGN = '\u003D';
    /** > of type MATH_SYMBOL */
    char GREATER_THAN_SIGN = '\u003E';
    /** ? of type OTHER_PUNCTUATION */
    char QUESTION_MARK = '\u003F';
    /** &commat; of type OTHER_PUNCTUATION */
    char COMMERCIAL_AT = '\u0040';
    /** [ of type START_PUNCTUATION */
    char LEFT_SQUARE_BRACKET = '\u005B';
    /** ] of type END_PUNCTUATION */
    char RIGHT_SQUARE_BRACKET = '\u005D';
    /** ^ of type MODIFIER_SYMBOL */
    char CIRCUMFLEX_ACCENT = '\u005E';
    /** _ of type CONNECTOR_PUNCTUATION */
    char LOW_LINE = '\u005F';
    /** ` of type MODIFIER_SYMBOL */
    char GRAVE_ACCENT = '\u0060';
    /** { of type START_PUNCTUATION */
    char LEFT_CURLY_BRACKET = '\u007B';
    /** | of type MATH_SYMBOL */
    char VERTICAL_LINE = '\u007C';
    /** } of type END_PUNCTUATION */
    char RIGHT_CURLY_BRACKET = '\u007D';
    /** ~ of type MATH_SYMBOL */
    char TILDE = '\u007E';
    /**   of type SPACE_SEPARATOR */
    char NO_BREAK_SPACE = '\u00A0';
    /** ¡ of type OTHER_PUNCTUATION */
    char INVERTED_EXCLAMATION_MARK = '\u00A1';
    /** ¢ of type CURRENCY_SYMBOL */
    char CENT_SIGN = '\u00A2';
    /** £ of type CURRENCY_SYMBOL */
    char POUND_SIGN = '\u00A3';
    /** ¤ of type CURRENCY_SYMBOL */
    char CURRENCY_SIGN = '\u00A4';
    /** ¥ of type CURRENCY_SYMBOL */
    char YEN_SIGN = '\u00A5';
    /** ¦ of type OTHER_SYMBOL */
    char BROKEN_BAR = '\u00A6';
    /** § of type OTHER_PUNCTUATION */
    char SECTION_SIGN = '\u00A7';
    /** ¨ of type MODIFIER_SYMBOL */
    char DIAERESIS = '\u00A8';
    /** © of type OTHER_SYMBOL */
    char COPYRIGHT_SIGN = '\u00A9';
    /** ª of type OTHER_LETTER */
    char FEMININE_ORDINAL_INDICATOR = '\u00AA';
    /** « of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_POINTING_DOUBLE_ANGLE_QUOTATION_MARK = '\u00AB';
    /** ¬ of type MATH_SYMBOL */
    char NOT_SIGN = '\u00AC';
    /** ­ of type FORMAT */
    char SOFT_HYPHEN = '\u00AD';
    /** ® of type OTHER_SYMBOL */
    char REGISTERED_SIGN = '\u00AE';
    /** ¯ of type MODIFIER_SYMBOL */
    char MACRON = '\u00AF';
    /** ° of type OTHER_SYMBOL */
    char DEGREE_SIGN = '\u00B0';
    /** ± of type MATH_SYMBOL */
    char PLUS_MINUS_SIGN = '\u00B1';
    /** ² of type OTHER_NUMBER */
    char SUPERSCRIPT_TWO = '\u00B2';
    /** ³ of type OTHER_NUMBER */
    char SUPERSCRIPT_THREE = '\u00B3';
    /** ´ of type MODIFIER_SYMBOL */
    char ACUTE_ACCENT = '\u00B4';
    /** µ of type LOWERCASE_LETTER */
    char MICRO_SIGN = '\u00B5';
    /** ¶ of type OTHER_PUNCTUATION */
    char PILCROW_SIGN = '\u00B6';
    /** · of type OTHER_PUNCTUATION */
    char MIDDLE_DOT = '\u00B7';
    /** ¸ of type MODIFIER_SYMBOL */
    char CEDILLA = '\u00B8';
    /** ¹ of type OTHER_NUMBER */
    char SUPERSCRIPT_ONE = '\u00B9';
    /** º of type OTHER_LETTER */
    char MASCULINE_ORDINAL_INDICATOR = '\u00BA';
    /** » of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_POINTING_DOUBLE_ANGLE_QUOTATION_MARK = '\u00BB';
    /** ¼ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_QUARTER = '\u00BC';
    /** ½ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_HALF = '\u00BD';
    /** ¾ of type OTHER_NUMBER */
    char VULGAR_FRACTION_THREE_QUARTERS = '\u00BE';
    /** ¿ of type OTHER_PUNCTUATION */
    char INVERTED_QUESTION_MARK = '\u00BF';
    /** × of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN = '\u00D7';
    /** ÷ of type MATH_SYMBOL */
    char DIVISION_SIGN = '\u00F7';
    /** ʰ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_H = '\u02B0';
    /** ʱ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_H_WITH_HOOK = '\u02B1';
    /** ʲ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_J = '\u02B2';
    /** ʳ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_R = '\u02B3';
    /** ʴ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_R = '\u02B4';
    /** ʵ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_R_WITH_HOOK = '\u02B5';
    /** ʶ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CAPITAL_INVERTED_R = '\u02B6';
    /** ʷ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_W = '\u02B7';
    /** ʸ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_Y = '\u02B8';
    /** ʹ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_PRIME = '\u02B9';
    /** ʺ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_DOUBLE_PRIME = '\u02BA';
    /** ʻ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_TURNED_COMMA = '\u02BB';
    /** ʼ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_APOSTROPHE = '\u02BC';
    /** ʽ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_REVERSED_COMMA = '\u02BD';
    /** ʾ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_RIGHT_HALF_RING = '\u02BE';
    /** ʿ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LEFT_HALF_RING = '\u02BF';
    /** ˀ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_GLOTTAL_STOP = '\u02C0';
    /** ˁ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_REVERSED_GLOTTAL_STOP = '\u02C1';
    /** ˂ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LEFT_ARROWHEAD = '\u02C2';
    /** ˃ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_RIGHT_ARROWHEAD = '\u02C3';
    /** ˄ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_UP_ARROWHEAD = '\u02C4';
    /** ˅ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_DOWN_ARROWHEAD = '\u02C5';
    /** ˆ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CIRCUMFLEX_ACCENT = '\u02C6';
    /** ˇ of type MODIFIER_LETTER */
    char CARON = '\u02C7';
    /** ˈ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_VERTICAL_LINE = '\u02C8';
    /** ˉ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_MACRON = '\u02C9';
    /** ˊ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_ACUTE_ACCENT = '\u02CA';
    /** ˋ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_GRAVE_ACCENT = '\u02CB';
    /** ˌ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOW_VERTICAL_LINE = '\u02CC';
    /** ˍ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOW_MACRON = '\u02CD';
    /** ˎ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOW_GRAVE_ACCENT = '\u02CE';
    /** ˏ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOW_ACUTE_ACCENT = '\u02CF';
    /** ː of type MODIFIER_LETTER */
    char MODIFIER_LETTER_TRIANGULAR_COLON = '\u02D0';
    /** ˑ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_HALF_TRIANGULAR_COLON = '\u02D1';
    /** ˒ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CENTRED_RIGHT_HALF_RING = '\u02D2';
    /** ˓ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CENTRED_LEFT_HALF_RING = '\u02D3';
    /** ˔ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_UP_TACK = '\u02D4';
    /** ˕ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_DOWN_TACK = '\u02D5';
    /** ˖ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_PLUS_SIGN = '\u02D6';
    /** ˗ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MINUS_SIGN = '\u02D7';
    /** ˘ of type MODIFIER_SYMBOL */
    char BREVE = '\u02D8';
    /** ˙ of type MODIFIER_SYMBOL */
    char DOT_ABOVE = '\u02D9';
    /** ˚ of type MODIFIER_SYMBOL */
    char RING_ABOVE = '\u02DA';
    /** ˛ of type MODIFIER_SYMBOL */
    char OGONEK = '\u02DB';
    /** ˜ of type MODIFIER_SYMBOL */
    char SMALL_TILDE = '\u02DC';
    /** ˝ of type MODIFIER_SYMBOL */
    char DOUBLE_ACUTE_ACCENT = '\u02DD';
    /** ˞ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_RHOTIC_HOOK = '\u02DE';
    /** ˟ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CROSS_ACCENT = '\u02DF';
    /** ˠ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_GAMMA = '\u02E0';
    /** ˡ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_L = '\u02E1';
    /** ˢ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_S = '\u02E2';
    /** ˣ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_X = '\u02E3';
    /** ˤ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_REVERSED_GLOTTAL_STOP = '\u02E4';
    /** ˥ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_HIGH_TONE_BAR = '\u02E5';
    /** ˦ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_HIGH_TONE_BAR = '\u02E6';
    /** ˧ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MID_TONE_BAR = '\u02E7';
    /** ˨ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_TONE_BAR = '\u02E8';
    /** ˩ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_LOW_TONE_BAR = '\u02E9';
    /** ˪ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_YIN_DEPARTING_TONE_MARK = '\u02EA';
    /** ˫ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_YANG_DEPARTING_TONE_MARK = '\u02EB';
    /** ˬ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_VOICING = '\u02EC';
    /** ˭ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_UNASPIRATED = '\u02ED';
    /** ˮ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_DOUBLE_APOSTROPHE = '\u02EE';
    /** ˯ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_DOWN_ARROWHEAD = '\u02EF';
    /** ˰ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_UP_ARROWHEAD = '\u02F0';
    /** ˱ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_LEFT_ARROWHEAD = '\u02F1';
    /** ˲ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_RIGHT_ARROWHEAD = '\u02F2';
    /** ˳ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_RING = '\u02F3';
    /** ˴ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MIDDLE_GRAVE_ACCENT = '\u02F4';
    /** ˵ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MIDDLE_DOUBLE_GRAVE_ACCENT = '\u02F5';
    /** ˶ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MIDDLE_DOUBLE_ACUTE_ACCENT = '\u02F6';
    /** ˷ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_TILDE = '\u02F7';
    /** ˸ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_RAISED_COLON = '\u02F8';
    /** ˹ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_BEGIN_HIGH_TONE = '\u02F9';
    /** ˺ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_END_HIGH_TONE = '\u02FA';
    /** ˻ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_BEGIN_LOW_TONE = '\u02FB';
    /** ˼ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_END_LOW_TONE = '\u02FC';
    /** ˽ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_SHELF = '\u02FD';
    /** ˾ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_OPEN_SHELF = '\u02FE';
    /** ˿ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_LEFT_ARROW = '\u02FF';
    /** Ϣ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_SHEI = '\u03E2';
    /** ϣ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_SHEI = '\u03E3';
    /** Ϥ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_FEI = '\u03E4';
    /** ϥ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_FEI = '\u03E5';
    /** Ϧ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_KHEI = '\u03E6';
    /** ϧ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_KHEI = '\u03E7';
    /** Ϩ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_HORI = '\u03E8';
    /** ϩ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_HORI = '\u03E9';
    /** Ϫ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_GANGIA = '\u03EA';
    /** ϫ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_GANGIA = '\u03EB';
    /** Ϭ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_SHIMA = '\u03EC';
    /** ϭ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_SHIMA = '\u03ED';
    /** Ϯ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_DEI = '\u03EE';
    /** ϯ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_DEI = '\u03EF';
    /** Ա of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_AYB = '\u0531';
    /** Բ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_BEN = '\u0532';
    /** Գ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_GIM = '\u0533';
    /** Դ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_DA = '\u0534';
    /** Ե of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_ECH = '\u0535';
    /** Զ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_ZA = '\u0536';
    /** Է of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_EH = '\u0537';
    /** Ը of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_ET = '\u0538';
    /** Թ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_TO = '\u0539';
    /** Ժ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_ZHE = '\u053A';
    /** Ի of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_INI = '\u053B';
    /** Լ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_LIWN = '\u053C';
    /** Խ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_XEH = '\u053D';
    /** Ծ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_CA = '\u053E';
    /** Կ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_KEN = '\u053F';
    /** Հ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_HO = '\u0540';
    /** Ձ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_JA = '\u0541';
    /** Ղ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_GHAD = '\u0542';
    /** Ճ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_CHEH = '\u0543';
    /** Մ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_MEN = '\u0544';
    /** Յ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_YI = '\u0545';
    /** Ն of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_NOW = '\u0546';
    /** Շ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_SHA = '\u0547';
    /** Ո of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_VO = '\u0548';
    /** Չ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_CHA = '\u0549';
    /** Պ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_PEH = '\u054A';
    /** Ջ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_JHEH = '\u054B';
    /** Ռ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_RA = '\u054C';
    /** Ս of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_SEH = '\u054D';
    /** Վ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_VEW = '\u054E';
    /** Տ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_TIWN = '\u054F';
    /** Ր of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_REH = '\u0550';
    /** Ց of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_CO = '\u0551';
    /** Ւ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_YIWN = '\u0552';
    /** Փ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_PIWR = '\u0553';
    /** Ք of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_KEH = '\u0554';
    /** Օ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_OH = '\u0555';
    /** Ֆ of type UPPERCASE_LETTER */
    char ARMENIAN_CAPITAL_LETTER_FEH = '\u0556';
    /** ՙ of type MODIFIER_LETTER */
    char ARMENIAN_MODIFIER_LETTER_LEFT_HALF_RING = '\u0559';
    /** ՚ of type OTHER_PUNCTUATION */
    char ARMENIAN_APOSTROPHE = '\u055A';
    /** ՛ of type OTHER_PUNCTUATION */
    char ARMENIAN_EMPHASIS_MARK = '\u055B';
    /** ՜ of type OTHER_PUNCTUATION */
    char ARMENIAN_EXCLAMATION_MARK = '\u055C';
    /** ՝ of type OTHER_PUNCTUATION */
    char ARMENIAN_COMMA = '\u055D';
    /** ՞ of type OTHER_PUNCTUATION */
    char ARMENIAN_QUESTION_MARK = '\u055E';
    /** ՟ of type OTHER_PUNCTUATION */
    char ARMENIAN_ABBREVIATION_MARK = '\u055F';
    /** ա of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_AYB = '\u0561';
    /** բ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_BEN = '\u0562';
    /** գ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_GIM = '\u0563';
    /** դ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_DA = '\u0564';
    /** ե of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_ECH = '\u0565';
    /** զ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_ZA = '\u0566';
    /** է of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_EH = '\u0567';
    /** ը of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_ET = '\u0568';
    /** թ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_TO = '\u0569';
    /** ժ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_ZHE = '\u056A';
    /** ի of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_INI = '\u056B';
    /** լ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_LIWN = '\u056C';
    /** խ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_XEH = '\u056D';
    /** ծ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_CA = '\u056E';
    /** կ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_KEN = '\u056F';
    /** հ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_HO = '\u0570';
    /** ձ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_JA = '\u0571';
    /** ղ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_GHAD = '\u0572';
    /** ճ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_CHEH = '\u0573';
    /** մ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_MEN = '\u0574';
    /** յ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_YI = '\u0575';
    /** ն of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_NOW = '\u0576';
    /** շ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_SHA = '\u0577';
    /** ո of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_VO = '\u0578';
    /** չ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_CHA = '\u0579';
    /** պ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_PEH = '\u057A';
    /** ջ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_JHEH = '\u057B';
    /** ռ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_RA = '\u057C';
    /** ս of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_SEH = '\u057D';
    /** վ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_VEW = '\u057E';
    /** տ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_TIWN = '\u057F';
    /** ր of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_REH = '\u0580';
    /** ց of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_CO = '\u0581';
    /** ւ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_YIWN = '\u0582';
    /** փ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_PIWR = '\u0583';
    /** ք of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_KEH = '\u0584';
    /** օ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_OH = '\u0585';
    /** ֆ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LETTER_FEH = '\u0586';
    /** և of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LIGATURE_ECH_YIWN = '\u0587';
    /** ։ of type OTHER_PUNCTUATION */
    char ARMENIAN_FULL_STOP = '\u0589';
    /** ֊ of type DASH_PUNCTUATION */
    char ARMENIAN_HYPHEN = '\u058A';
    /** ֏ of type CURRENCY_SYMBOL */
    char ARMENIAN_DRAM_SIGN = '\u058F';
    /** ֑ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ETNAHTA = '\u0591';
    /** ֒ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_SEGOL = '\u0592';
    /** ֓ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_SHALSHELET = '\u0593';
    /** ֔ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ZAQEF_QATAN = '\u0594';
    /** ֕ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ZAQEF_GADOL = '\u0595';
    /** ֖ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_TIPEHA = '\u0596';
    /** ֗ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_REVIA = '\u0597';
    /** ֘ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ZARQA = '\u0598';
    /** ֙ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_PASHTA = '\u0599';
    /** ֚ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_YETIV = '\u059A';
    /** ֛ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_TEVIR = '\u059B';
    /** ֜ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_GERESH = '\u059C';
    /** ֝ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_GERESH_MUQDAM = '\u059D';
    /** ֞ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_GERSHAYIM = '\u059E';
    /** ֟ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_QARNEY_PARA = '\u059F';
    /** ֠ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_TELISHA_GEDOLA = '\u05A0';
    /** ֡ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_PAZER = '\u05A1';
    /** ֢ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ATNAH_HAFUKH = '\u05A2';
    /** ֣ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_MUNAH = '\u05A3';
    /** ֤ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_MAHAPAKH = '\u05A4';
    /** ֥ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_MERKHA = '\u05A5';
    /** ֦ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_MERKHA_KEFULA = '\u05A6';
    /** ֧ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_DARGA = '\u05A7';
    /** ֨ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_QADMA = '\u05A8';
    /** ֩ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_TELISHA_QETANA = '\u05A9';
    /** ֪ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_YERAH_BEN_YOMO = '\u05AA';
    /** ֫ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_OLE = '\u05AB';
    /** ֬ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ILUY = '\u05AC';
    /** ֭ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_DEHI = '\u05AD';
    /** ֮ of type NON_SPACING_MARK */
    char HEBREW_ACCENT_ZINOR = '\u05AE';
    /** ֯ of type NON_SPACING_MARK */
    char HEBREW_MARK_MASORA_CIRCLE = '\u05AF';
    /** ְ of type NON_SPACING_MARK */
    char HEBREW_POINT_SHEVA = '\u05B0';
    /** ֱ of type NON_SPACING_MARK */
    char HEBREW_POINT_HATAF_SEGOL = '\u05B1';
    /** ֲ of type NON_SPACING_MARK */
    char HEBREW_POINT_HATAF_PATAH = '\u05B2';
    /** ֳ of type NON_SPACING_MARK */
    char HEBREW_POINT_HATAF_QAMATS = '\u05B3';
    /** ִ of type NON_SPACING_MARK */
    char HEBREW_POINT_HIRIQ = '\u05B4';
    /** ֵ of type NON_SPACING_MARK */
    char HEBREW_POINT_TSERE = '\u05B5';
    /** ֶ of type NON_SPACING_MARK */
    char HEBREW_POINT_SEGOL = '\u05B6';
    /** ַ of type NON_SPACING_MARK */
    char HEBREW_POINT_PATAH = '\u05B7';
    /** ָ of type NON_SPACING_MARK */
    char HEBREW_POINT_QAMATS = '\u05B8';
    /** ֹ of type NON_SPACING_MARK */
    char HEBREW_POINT_HOLAM = '\u05B9';
    /** ֺ of type NON_SPACING_MARK */
    char HEBREW_POINT_HOLAM_HASER_FOR_VAV = '\u05BA';
    /** ֻ of type NON_SPACING_MARK */
    char HEBREW_POINT_QUBUTS = '\u05BB';
    /** ּ of type NON_SPACING_MARK */
    char HEBREW_POINT_DAGESH_OR_MAPIQ = '\u05BC';
    /** ֽ of type NON_SPACING_MARK */
    char HEBREW_POINT_METEG = '\u05BD';
    /** ־ of type DASH_PUNCTUATION */
    char HEBREW_PUNCTUATION_MAQAF = '\u05BE';
    /** ֿ of type NON_SPACING_MARK */
    char HEBREW_POINT_RAFE = '\u05BF';
    /** ׀ of type OTHER_PUNCTUATION */
    char HEBREW_PUNCTUATION_PASEQ = '\u05C0';
    /** ׁ of type NON_SPACING_MARK */
    char HEBREW_POINT_SHIN_DOT = '\u05C1';
    /** ׂ of type NON_SPACING_MARK */
    char HEBREW_POINT_SIN_DOT = '\u05C2';
    /** ׃ of type OTHER_PUNCTUATION */
    char HEBREW_PUNCTUATION_SOF_PASUQ = '\u05C3';
    /** ׄ of type NON_SPACING_MARK */
    char HEBREW_MARK_UPPER_DOT = '\u05C4';
    /** ׅ of type NON_SPACING_MARK */
    char HEBREW_MARK_LOWER_DOT = '\u05C5';
    /** ׆ of type OTHER_PUNCTUATION */
    char HEBREW_PUNCTUATION_NUN_HAFUKHA = '\u05C6';
    /** ׇ of type NON_SPACING_MARK */
    char HEBREW_POINT_QAMATS_QATAN = '\u05C7';
    /** א of type OTHER_LETTER */
    char HEBREW_LETTER_ALEF = '\u05D0';
    /** ב of type OTHER_LETTER */
    char HEBREW_LETTER_BET = '\u05D1';
    /** ג of type OTHER_LETTER */
    char HEBREW_LETTER_GIMEL = '\u05D2';
    /** ד of type OTHER_LETTER */
    char HEBREW_LETTER_DALET = '\u05D3';
    /** ה of type OTHER_LETTER */
    char HEBREW_LETTER_HE = '\u05D4';
    /** ו of type OTHER_LETTER */
    char HEBREW_LETTER_VAV = '\u05D5';
    /** ז of type OTHER_LETTER */
    char HEBREW_LETTER_ZAYIN = '\u05D6';
    /** ח of type OTHER_LETTER */
    char HEBREW_LETTER_HET = '\u05D7';
    /** ט of type OTHER_LETTER */
    char HEBREW_LETTER_TET = '\u05D8';
    /** י of type OTHER_LETTER */
    char HEBREW_LETTER_YOD = '\u05D9';
    /** ך of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_KAF = '\u05DA';
    /** כ of type OTHER_LETTER */
    char HEBREW_LETTER_KAF = '\u05DB';
    /** ל of type OTHER_LETTER */
    char HEBREW_LETTER_LAMED = '\u05DC';
    /** ם of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_MEM = '\u05DD';
    /** מ of type OTHER_LETTER */
    char HEBREW_LETTER_MEM = '\u05DE';
    /** ן of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_NUN = '\u05DF';
    /** נ of type OTHER_LETTER */
    char HEBREW_LETTER_NUN = '\u05E0';
    /** ס of type OTHER_LETTER */
    char HEBREW_LETTER_SAMEKH = '\u05E1';
    /** ע of type OTHER_LETTER */
    char HEBREW_LETTER_AYIN = '\u05E2';
    /** ף of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_PE = '\u05E3';
    /** פ of type OTHER_LETTER */
    char HEBREW_LETTER_PE = '\u05E4';
    /** ץ of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_TSADI = '\u05E5';
    /** צ of type OTHER_LETTER */
    char HEBREW_LETTER_TSADI = '\u05E6';
    /** ק of type OTHER_LETTER */
    char HEBREW_LETTER_QOF = '\u05E7';
    /** ר of type OTHER_LETTER */
    char HEBREW_LETTER_RESH = '\u05E8';
    /** ש of type OTHER_LETTER */
    char HEBREW_LETTER_SHIN = '\u05E9';
    /** ת of type OTHER_LETTER */
    char HEBREW_LETTER_TAV = '\u05EA';
    /** װ of type OTHER_LETTER */
    char HEBREW_LIGATURE_YIDDISH_DOUBLE_VAV = '\u05F0';
    /** ױ of type OTHER_LETTER */
    char HEBREW_LIGATURE_YIDDISH_VAV_YOD = '\u05F1';
    /** ײ of type OTHER_LETTER */
    char HEBREW_LIGATURE_YIDDISH_DOUBLE_YOD = '\u05F2';
    /** ׳ of type OTHER_PUNCTUATION */
    char HEBREW_PUNCTUATION_GERESH = '\u05F3';
    /** ״ of type OTHER_PUNCTUATION */
    char HEBREW_PUNCTUATION_GERSHAYIM = '\u05F4';
    /** ؋ of type CURRENCY_SYMBOL */
    char AFGHANI_SIGN = '\u060B';
    /** ۰ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_ZERO = '\u06F0';
    /** ۱ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_ONE = '\u06F1';
    /** ۲ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_TWO = '\u06F2';
    /** ۳ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_THREE = '\u06F3';
    /** ۴ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_FOUR = '\u06F4';
    /** ۵ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_FIVE = '\u06F5';
    /** ۶ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_SIX = '\u06F6';
    /** ۷ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_SEVEN = '\u06F7';
    /** ۸ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_EIGHT = '\u06F8';
    /** ۹ of type DECIMAL_DIGIT_NUMBER */
    char EXTENDED_ARABIC_INDIC_DIGIT_NINE = '\u06F9';
    /** ܀ of type OTHER_PUNCTUATION */
    char SYRIAC_END_OF_PARAGRAPH = '\u0700';
    /** ܁ of type OTHER_PUNCTUATION */
    char SYRIAC_SUPRALINEAR_FULL_STOP = '\u0701';
    /** ܂ of type OTHER_PUNCTUATION */
    char SYRIAC_SUBLINEAR_FULL_STOP = '\u0702';
    /** ܃ of type OTHER_PUNCTUATION */
    char SYRIAC_SUPRALINEAR_COLON = '\u0703';
    /** ܄ of type OTHER_PUNCTUATION */
    char SYRIAC_SUBLINEAR_COLON = '\u0704';
    /** ܅ of type OTHER_PUNCTUATION */
    char SYRIAC_HORIZONTAL_COLON = '\u0705';
    /** ܆ of type OTHER_PUNCTUATION */
    char SYRIAC_COLON_SKEWED_LEFT = '\u0706';
    /** ܇ of type OTHER_PUNCTUATION */
    char SYRIAC_COLON_SKEWED_RIGHT = '\u0707';
    /** ܈ of type OTHER_PUNCTUATION */
    char SYRIAC_SUPRALINEAR_COLON_SKEWED_LEFT = '\u0708';
    /** ܉ of type OTHER_PUNCTUATION */
    char SYRIAC_SUBLINEAR_COLON_SKEWED_RIGHT = '\u0709';
    /** ܊ of type OTHER_PUNCTUATION */
    char SYRIAC_CONTRACTION = '\u070A';
    /** ܋ of type OTHER_PUNCTUATION */
    char SYRIAC_HARKLEAN_OBELUS = '\u070B';
    /** ܌ of type OTHER_PUNCTUATION */
    char SYRIAC_HARKLEAN_METOBELUS = '\u070C';
    /** ܍ of type OTHER_PUNCTUATION */
    char SYRIAC_HARKLEAN_ASTERISCUS = '\u070D';
    /** ܏ of type FORMAT */
    char SYRIAC_ABBREVIATION_MARK = '\u070F';
    /** ܐ of type OTHER_LETTER */
    char SYRIAC_LETTER_ALAPH = '\u0710';
    /** ܑ of type NON_SPACING_MARK */
    char SYRIAC_LETTER_SUPERSCRIPT_ALAPH = '\u0711';
    /** ܒ of type OTHER_LETTER */
    char SYRIAC_LETTER_BETH = '\u0712';
    /** ܓ of type OTHER_LETTER */
    char SYRIAC_LETTER_GAMAL = '\u0713';
    /** ܔ of type OTHER_LETTER */
    char SYRIAC_LETTER_GAMAL_GARSHUNI = '\u0714';
    /** ܕ of type OTHER_LETTER */
    char SYRIAC_LETTER_DALATH = '\u0715';
    /** ܖ of type OTHER_LETTER */
    char SYRIAC_LETTER_DOTLESS_DALATH_RISH = '\u0716';
    /** ܗ of type OTHER_LETTER */
    char SYRIAC_LETTER_HE = '\u0717';
    /** ܘ of type OTHER_LETTER */
    char SYRIAC_LETTER_WAW = '\u0718';
    /** ܙ of type OTHER_LETTER */
    char SYRIAC_LETTER_ZAIN = '\u0719';
    /** ܚ of type OTHER_LETTER */
    char SYRIAC_LETTER_HETH = '\u071A';
    /** ܛ of type OTHER_LETTER */
    char SYRIAC_LETTER_TETH = '\u071B';
    /** ܜ of type OTHER_LETTER */
    char SYRIAC_LETTER_TETH_GARSHUNI = '\u071C';
    /** ܝ of type OTHER_LETTER */
    char SYRIAC_LETTER_YUDH = '\u071D';
    /** ܞ of type OTHER_LETTER */
    char SYRIAC_LETTER_YUDH_HE = '\u071E';
    /** ܟ of type OTHER_LETTER */
    char SYRIAC_LETTER_KAPH = '\u071F';
    /** ܠ of type OTHER_LETTER */
    char SYRIAC_LETTER_LAMADH = '\u0720';
    /** ܡ of type OTHER_LETTER */
    char SYRIAC_LETTER_MIM = '\u0721';
    /** ܢ of type OTHER_LETTER */
    char SYRIAC_LETTER_NUN = '\u0722';
    /** ܣ of type OTHER_LETTER */
    char SYRIAC_LETTER_SEMKATH = '\u0723';
    /** ܤ of type OTHER_LETTER */
    char SYRIAC_LETTER_FINAL_SEMKATH = '\u0724';
    /** ܥ of type OTHER_LETTER */
    char SYRIAC_LETTER_E = '\u0725';
    /** ܦ of type OTHER_LETTER */
    char SYRIAC_LETTER_PE = '\u0726';
    /** ܧ of type OTHER_LETTER */
    char SYRIAC_LETTER_REVERSED_PE = '\u0727';
    /** ܨ of type OTHER_LETTER */
    char SYRIAC_LETTER_SADHE = '\u0728';
    /** ܩ of type OTHER_LETTER */
    char SYRIAC_LETTER_QAPH = '\u0729';
    /** ܪ of type OTHER_LETTER */
    char SYRIAC_LETTER_RISH = '\u072A';
    /** ܫ of type OTHER_LETTER */
    char SYRIAC_LETTER_SHIN = '\u072B';
    /** ܬ of type OTHER_LETTER */
    char SYRIAC_LETTER_TAW = '\u072C';
    /** ܭ of type OTHER_LETTER */
    char SYRIAC_LETTER_PERSIAN_BHETH = '\u072D';
    /** ܮ of type OTHER_LETTER */
    char SYRIAC_LETTER_PERSIAN_GHAMAL = '\u072E';
    /** ܯ of type OTHER_LETTER */
    char SYRIAC_LETTER_PERSIAN_DHALATH = '\u072F';
    /** ܰ of type NON_SPACING_MARK */
    char SYRIAC_PTHAHA_ABOVE = '\u0730';
    /** ܱ of type NON_SPACING_MARK */
    char SYRIAC_PTHAHA_BELOW = '\u0731';
    /** ܲ of type NON_SPACING_MARK */
    char SYRIAC_PTHAHA_DOTTED = '\u0732';
    /** ܳ of type NON_SPACING_MARK */
    char SYRIAC_ZQAPHA_ABOVE = '\u0733';
    /** ܴ of type NON_SPACING_MARK */
    char SYRIAC_ZQAPHA_BELOW = '\u0734';
    /** ܵ of type NON_SPACING_MARK */
    char SYRIAC_ZQAPHA_DOTTED = '\u0735';
    /** ܶ of type NON_SPACING_MARK */
    char SYRIAC_RBASA_ABOVE = '\u0736';
    /** ܷ of type NON_SPACING_MARK */
    char SYRIAC_RBASA_BELOW = '\u0737';
    /** ܸ of type NON_SPACING_MARK */
    char SYRIAC_DOTTED_ZLAMA_HORIZONTAL = '\u0738';
    /** ܹ of type NON_SPACING_MARK */
    char SYRIAC_DOTTED_ZLAMA_ANGULAR = '\u0739';
    /** ܺ of type NON_SPACING_MARK */
    char SYRIAC_HBASA_ABOVE = '\u073A';
    /** ܻ of type NON_SPACING_MARK */
    char SYRIAC_HBASA_BELOW = '\u073B';
    /** ܼ of type NON_SPACING_MARK */
    char SYRIAC_HBASA_ESASA_DOTTED = '\u073C';
    /** ܽ of type NON_SPACING_MARK */
    char SYRIAC_ESASA_ABOVE = '\u073D';
    /** ܾ of type NON_SPACING_MARK */
    char SYRIAC_ESASA_BELOW = '\u073E';
    /** ܿ of type NON_SPACING_MARK */
    char SYRIAC_RWAHA = '\u073F';
    /** ݀ of type NON_SPACING_MARK */
    char SYRIAC_FEMININE_DOT = '\u0740';
    /** ݁ of type NON_SPACING_MARK */
    char SYRIAC_QUSHSHAYA = '\u0741';
    /** ݂ of type NON_SPACING_MARK */
    char SYRIAC_RUKKAKHA = '\u0742';
    /** ݃ of type NON_SPACING_MARK */
    char SYRIAC_TWO_VERTICAL_DOTS_ABOVE = '\u0743';
    /** ݄ of type NON_SPACING_MARK */
    char SYRIAC_TWO_VERTICAL_DOTS_BELOW = '\u0744';
    /** ݅ of type NON_SPACING_MARK */
    char SYRIAC_THREE_DOTS_ABOVE = '\u0745';
    /** ݆ of type NON_SPACING_MARK */
    char SYRIAC_THREE_DOTS_BELOW = '\u0746';
    /** ݇ of type NON_SPACING_MARK */
    char SYRIAC_OBLIQUE_LINE_ABOVE = '\u0747';
    /** ݈ of type NON_SPACING_MARK */
    char SYRIAC_OBLIQUE_LINE_BELOW = '\u0748';
    /** ݉ of type NON_SPACING_MARK */
    char SYRIAC_MUSIC = '\u0749';
    /** ݊ of type NON_SPACING_MARK */
    char SYRIAC_BARREKH = '\u074A';
    /** ݍ of type OTHER_LETTER */
    char SYRIAC_LETTER_SOGDIAN_ZHAIN = '\u074D';
    /** ݎ of type OTHER_LETTER */
    char SYRIAC_LETTER_SOGDIAN_KHAPH = '\u074E';
    /** ݏ of type OTHER_LETTER */
    char SYRIAC_LETTER_SOGDIAN_FE = '\u074F';
    /** ހ of type OTHER_LETTER */
    char THAANA_LETTER_HAA = '\u0780';
    /** ށ of type OTHER_LETTER */
    char THAANA_LETTER_SHAVIYANI = '\u0781';
    /** ނ of type OTHER_LETTER */
    char THAANA_LETTER_NOONU = '\u0782';
    /** ރ of type OTHER_LETTER */
    char THAANA_LETTER_RAA = '\u0783';
    /** ބ of type OTHER_LETTER */
    char THAANA_LETTER_BAA = '\u0784';
    /** ޅ of type OTHER_LETTER */
    char THAANA_LETTER_LHAVIYANI = '\u0785';
    /** ކ of type OTHER_LETTER */
    char THAANA_LETTER_KAAFU = '\u0786';
    /** އ of type OTHER_LETTER */
    char THAANA_LETTER_ALIFU = '\u0787';
    /** ވ of type OTHER_LETTER */
    char THAANA_LETTER_VAAVU = '\u0788';
    /** މ of type OTHER_LETTER */
    char THAANA_LETTER_MEEMU = '\u0789';
    /** ފ of type OTHER_LETTER */
    char THAANA_LETTER_FAAFU = '\u078A';
    /** ދ of type OTHER_LETTER */
    char THAANA_LETTER_DHAALU = '\u078B';
    /** ތ of type OTHER_LETTER */
    char THAANA_LETTER_THAA = '\u078C';
    /** ލ of type OTHER_LETTER */
    char THAANA_LETTER_LAAMU = '\u078D';
    /** ގ of type OTHER_LETTER */
    char THAANA_LETTER_GAAFU = '\u078E';
    /** ޏ of type OTHER_LETTER */
    char THAANA_LETTER_GNAVIYANI = '\u078F';
    /** ސ of type OTHER_LETTER */
    char THAANA_LETTER_SEENU = '\u0790';
    /** ޑ of type OTHER_LETTER */
    char THAANA_LETTER_DAVIYANI = '\u0791';
    /** ޒ of type OTHER_LETTER */
    char THAANA_LETTER_ZAVIYANI = '\u0792';
    /** ޓ of type OTHER_LETTER */
    char THAANA_LETTER_TAVIYANI = '\u0793';
    /** ޔ of type OTHER_LETTER */
    char THAANA_LETTER_YAA = '\u0794';
    /** ޕ of type OTHER_LETTER */
    char THAANA_LETTER_PAVIYANI = '\u0795';
    /** ޖ of type OTHER_LETTER */
    char THAANA_LETTER_JAVIYANI = '\u0796';
    /** ޗ of type OTHER_LETTER */
    char THAANA_LETTER_CHAVIYANI = '\u0797';
    /** ޘ of type OTHER_LETTER */
    char THAANA_LETTER_TTAA = '\u0798';
    /** ޙ of type OTHER_LETTER */
    char THAANA_LETTER_HHAA = '\u0799';
    /** ޚ of type OTHER_LETTER */
    char THAANA_LETTER_KHAA = '\u079A';
    /** ޛ of type OTHER_LETTER */
    char THAANA_LETTER_THAALU = '\u079B';
    /** ޜ of type OTHER_LETTER */
    char THAANA_LETTER_ZAA = '\u079C';
    /** ޝ of type OTHER_LETTER */
    char THAANA_LETTER_SHEENU = '\u079D';
    /** ޞ of type OTHER_LETTER */
    char THAANA_LETTER_SAADHU = '\u079E';
    /** ޟ of type OTHER_LETTER */
    char THAANA_LETTER_DAADHU = '\u079F';
    /** ޠ of type OTHER_LETTER */
    char THAANA_LETTER_TO = '\u07A0';
    /** ޡ of type OTHER_LETTER */
    char THAANA_LETTER_ZO = '\u07A1';
    /** ޢ of type OTHER_LETTER */
    char THAANA_LETTER_AINU = '\u07A2';
    /** ޣ of type OTHER_LETTER */
    char THAANA_LETTER_GHAINU = '\u07A3';
    /** ޤ of type OTHER_LETTER */
    char THAANA_LETTER_QAAFU = '\u07A4';
    /** ޥ of type OTHER_LETTER */
    char THAANA_LETTER_WAAVU = '\u07A5';
    /** ަ of type NON_SPACING_MARK */
    char THAANA_ABAFILI = '\u07A6';
    /** ާ of type NON_SPACING_MARK */
    char THAANA_AABAAFILI = '\u07A7';
    /** ި of type NON_SPACING_MARK */
    char THAANA_IBIFILI = '\u07A8';
    /** ީ of type NON_SPACING_MARK */
    char THAANA_EEBEEFILI = '\u07A9';
    /** ު of type NON_SPACING_MARK */
    char THAANA_UBUFILI = '\u07AA';
    /** ޫ of type NON_SPACING_MARK */
    char THAANA_OOBOOFILI = '\u07AB';
    /** ެ of type NON_SPACING_MARK */
    char THAANA_EBEFILI = '\u07AC';
    /** ޭ of type NON_SPACING_MARK */
    char THAANA_EYBEYFILI = '\u07AD';
    /** ޮ of type NON_SPACING_MARK */
    char THAANA_OBOFILI = '\u07AE';
    /** ޯ of type NON_SPACING_MARK */
    char THAANA_OABOAFILI = '\u07AF';
    /** ް of type NON_SPACING_MARK */
    char THAANA_SUKUN = '\u07B0';
    /** ޱ of type OTHER_LETTER */
    char THAANA_LETTER_NAA = '\u07B1';
    /** ߀ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_ZERO = '\u07C0';
    /** ߁ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_ONE = '\u07C1';
    /** ߂ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_TWO = '\u07C2';
    /** ߃ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_THREE = '\u07C3';
    /** ߄ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_FOUR = '\u07C4';
    /** ߅ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_FIVE = '\u07C5';
    /** ߆ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_SIX = '\u07C6';
    /** ߇ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_SEVEN = '\u07C7';
    /** ߈ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_EIGHT = '\u07C8';
    /** ߉ of type DECIMAL_DIGIT_NUMBER */
    char NKO_DIGIT_NINE = '\u07C9';
    /** ߊ of type OTHER_LETTER */
    char NKO_LETTER_A = '\u07CA';
    /** ߋ of type OTHER_LETTER */
    char NKO_LETTER_EE = '\u07CB';
    /** ߌ of type OTHER_LETTER */
    char NKO_LETTER_I = '\u07CC';
    /** ߍ of type OTHER_LETTER */
    char NKO_LETTER_E = '\u07CD';
    /** ߎ of type OTHER_LETTER */
    char NKO_LETTER_U = '\u07CE';
    /** ߏ of type OTHER_LETTER */
    char NKO_LETTER_OO = '\u07CF';
    /** ߐ of type OTHER_LETTER */
    char NKO_LETTER_O = '\u07D0';
    /** ߑ of type OTHER_LETTER */
    char NKO_LETTER_DAGBASINNA = '\u07D1';
    /** ߒ of type OTHER_LETTER */
    char NKO_LETTER_N = '\u07D2';
    /** ߓ of type OTHER_LETTER */
    char NKO_LETTER_BA = '\u07D3';
    /** ߔ of type OTHER_LETTER */
    char NKO_LETTER_PA = '\u07D4';
    /** ߕ of type OTHER_LETTER */
    char NKO_LETTER_TA = '\u07D5';
    /** ߖ of type OTHER_LETTER */
    char NKO_LETTER_JA = '\u07D6';
    /** ߗ of type OTHER_LETTER */
    char NKO_LETTER_CHA = '\u07D7';
    /** ߘ of type OTHER_LETTER */
    char NKO_LETTER_DA = '\u07D8';
    /** ߙ of type OTHER_LETTER */
    char NKO_LETTER_RA = '\u07D9';
    /** ߚ of type OTHER_LETTER */
    char NKO_LETTER_RRA = '\u07DA';
    /** ߛ of type OTHER_LETTER */
    char NKO_LETTER_SA = '\u07DB';
    /** ߜ of type OTHER_LETTER */
    char NKO_LETTER_GBA = '\u07DC';
    /** ߝ of type OTHER_LETTER */
    char NKO_LETTER_FA = '\u07DD';
    /** ߞ of type OTHER_LETTER */
    char NKO_LETTER_KA = '\u07DE';
    /** ߟ of type OTHER_LETTER */
    char NKO_LETTER_LA = '\u07DF';
    /** ߠ of type OTHER_LETTER */
    char NKO_LETTER_NA_WOLOSO = '\u07E0';
    /** ߡ of type OTHER_LETTER */
    char NKO_LETTER_MA = '\u07E1';
    /** ߢ of type OTHER_LETTER */
    char NKO_LETTER_NYA = '\u07E2';
    /** ߣ of type OTHER_LETTER */
    char NKO_LETTER_NA = '\u07E3';
    /** ߤ of type OTHER_LETTER */
    char NKO_LETTER_HA = '\u07E4';
    /** ߥ of type OTHER_LETTER */
    char NKO_LETTER_WA = '\u07E5';
    /** ߦ of type OTHER_LETTER */
    char NKO_LETTER_YA = '\u07E6';
    /** ߧ of type OTHER_LETTER */
    char NKO_LETTER_NYA_WOLOSO = '\u07E7';
    /** ߨ of type OTHER_LETTER */
    char NKO_LETTER_JONA_JA = '\u07E8';
    /** ߩ of type OTHER_LETTER */
    char NKO_LETTER_JONA_CHA = '\u07E9';
    /** ߪ of type OTHER_LETTER */
    char NKO_LETTER_JONA_RA = '\u07EA';
    /** ߫ of type NON_SPACING_MARK */
    char NKO_COMBINING_SHORT_HIGH_TONE = '\u07EB';
    /** ߬ of type NON_SPACING_MARK */
    char NKO_COMBINING_SHORT_LOW_TONE = '\u07EC';
    /** ߭ of type NON_SPACING_MARK */
    char NKO_COMBINING_SHORT_RISING_TONE = '\u07ED';
    /** ߮ of type NON_SPACING_MARK */
    char NKO_COMBINING_LONG_DESCENDING_TONE = '\u07EE';
    /** ߯ of type NON_SPACING_MARK */
    char NKO_COMBINING_LONG_HIGH_TONE = '\u07EF';
    /** ߰ of type NON_SPACING_MARK */
    char NKO_COMBINING_LONG_LOW_TONE = '\u07F0';
    /** ߱ of type NON_SPACING_MARK */
    char NKO_COMBINING_LONG_RISING_TONE = '\u07F1';
    /** ߲ of type NON_SPACING_MARK */
    char NKO_COMBINING_NASALIZATION_MARK = '\u07F2';
    /** ߳ of type NON_SPACING_MARK */
    char NKO_COMBINING_DOUBLE_DOT_ABOVE = '\u07F3';
    /** ߴ of type MODIFIER_LETTER */
    char NKO_HIGH_TONE_APOSTROPHE = '\u07F4';
    /** ߵ of type MODIFIER_LETTER */
    char NKO_LOW_TONE_APOSTROPHE = '\u07F5';
    /** ߶ of type OTHER_SYMBOL */
    char NKO_SYMBOL_OO_DENNEN = '\u07F6';
    /** ߷ of type OTHER_PUNCTUATION */
    char NKO_SYMBOL_GBAKURUNEN = '\u07F7';
    /** ߸ of type OTHER_PUNCTUATION */
    char NKO_COMMA = '\u07F8';
    /** ߹ of type OTHER_PUNCTUATION */
    char NKO_EXCLAMATION_MARK = '\u07F9';
    /** ߺ of type MODIFIER_LETTER */
    char NKO_LAJANYALAN = '\u07FA';
    /** ࠀ of type OTHER_LETTER */
    char SAMARITAN_LETTER_ALAF = '\u0800';
    /** ࠁ of type OTHER_LETTER */
    char SAMARITAN_LETTER_BIT = '\u0801';
    /** ࠂ of type OTHER_LETTER */
    char SAMARITAN_LETTER_GAMAN = '\u0802';
    /** ࠃ of type OTHER_LETTER */
    char SAMARITAN_LETTER_DALAT = '\u0803';
    /** ࠄ of type OTHER_LETTER */
    char SAMARITAN_LETTER_IY = '\u0804';
    /** ࠅ of type OTHER_LETTER */
    char SAMARITAN_LETTER_BAA = '\u0805';
    /** ࠆ of type OTHER_LETTER */
    char SAMARITAN_LETTER_ZEN = '\u0806';
    /** ࠇ of type OTHER_LETTER */
    char SAMARITAN_LETTER_IT = '\u0807';
    /** ࠈ of type OTHER_LETTER */
    char SAMARITAN_LETTER_TIT = '\u0808';
    /** ࠉ of type OTHER_LETTER */
    char SAMARITAN_LETTER_YUT = '\u0809';
    /** ࠊ of type OTHER_LETTER */
    char SAMARITAN_LETTER_KAAF = '\u080A';
    /** ࠋ of type OTHER_LETTER */
    char SAMARITAN_LETTER_LABAT = '\u080B';
    /** ࠌ of type OTHER_LETTER */
    char SAMARITAN_LETTER_MIM = '\u080C';
    /** ࠍ of type OTHER_LETTER */
    char SAMARITAN_LETTER_NUN = '\u080D';
    /** ࠎ of type OTHER_LETTER */
    char SAMARITAN_LETTER_SINGAAT = '\u080E';
    /** ࠏ of type OTHER_LETTER */
    char SAMARITAN_LETTER_IN = '\u080F';
    /** ࠐ of type OTHER_LETTER */
    char SAMARITAN_LETTER_FI = '\u0810';
    /** ࠑ of type OTHER_LETTER */
    char SAMARITAN_LETTER_TSAADIY = '\u0811';
    /** ࠒ of type OTHER_LETTER */
    char SAMARITAN_LETTER_QUF = '\u0812';
    /** ࠓ of type OTHER_LETTER */
    char SAMARITAN_LETTER_RISH = '\u0813';
    /** ࠔ of type OTHER_LETTER */
    char SAMARITAN_LETTER_SHAN = '\u0814';
    /** ࠕ of type OTHER_LETTER */
    char SAMARITAN_LETTER_TAAF = '\u0815';
    /** ࠖ of type NON_SPACING_MARK */
    char SAMARITAN_MARK_IN = '\u0816';
    /** ࠗ of type NON_SPACING_MARK */
    char SAMARITAN_MARK_IN_ALAF = '\u0817';
    /** ࠘ of type NON_SPACING_MARK */
    char SAMARITAN_MARK_OCCLUSION = '\u0818';
    /** ࠙ of type NON_SPACING_MARK */
    char SAMARITAN_MARK_DAGESH = '\u0819';
    /** ࠚ of type MODIFIER_LETTER */
    char SAMARITAN_MODIFIER_LETTER_EPENTHETIC_YUT = '\u081A';
    /** ࠛ of type NON_SPACING_MARK */
    char SAMARITAN_MARK_EPENTHETIC_YUT = '\u081B';
    /** ࠜ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_LONG_E = '\u081C';
    /** ࠝ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_E = '\u081D';
    /** ࠞ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_OVERLONG_AA = '\u081E';
    /** ࠟ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_LONG_AA = '\u081F';
    /** ࠠ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_AA = '\u0820';
    /** ࠡ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_OVERLONG_A = '\u0821';
    /** ࠢ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_LONG_A = '\u0822';
    /** ࠣ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_A = '\u0823';
    /** ࠤ of type MODIFIER_LETTER */
    char SAMARITAN_MODIFIER_LETTER_SHORT_A = '\u0824';
    /** ࠥ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_SHORT_A = '\u0825';
    /** ࠦ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_LONG_U = '\u0826';
    /** ࠧ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_U = '\u0827';
    /** ࠨ of type MODIFIER_LETTER */
    char SAMARITAN_MODIFIER_LETTER_I = '\u0828';
    /** ࠩ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_LONG_I = '\u0829';
    /** ࠪ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_I = '\u082A';
    /** ࠫ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_O = '\u082B';
    /** ࠬ of type NON_SPACING_MARK */
    char SAMARITAN_VOWEL_SIGN_SUKUN = '\u082C';
    /** ࠭ of type NON_SPACING_MARK */
    char SAMARITAN_MARK_NEQUDAA = '\u082D';
    /** ࠰ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_NEQUDAA = '\u0830';
    /** ࠱ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_AFSAAQ = '\u0831';
    /** ࠲ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_ANGED = '\u0832';
    /** ࠳ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_BAU = '\u0833';
    /** ࠴ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_ATMAAU = '\u0834';
    /** ࠵ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_SHIYYAALAA = '\u0835';
    /** ࠶ of type OTHER_PUNCTUATION */
    char SAMARITAN_ABBREVIATION_MARK = '\u0836';
    /** ࠷ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_MELODIC_QITSA = '\u0837';
    /** ࠸ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_ZIQAA = '\u0838';
    /** ࠹ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_QITSA = '\u0839';
    /** ࠺ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_ZAEF = '\u083A';
    /** ࠻ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_TURU = '\u083B';
    /** ࠼ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_ARKAANU = '\u083C';
    /** ࠽ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_SOF_MASHFAAT = '\u083D';
    /** ࠾ of type OTHER_PUNCTUATION */
    char SAMARITAN_PUNCTUATION_ANNAAU = '\u083E';
    /** ࡀ of type OTHER_LETTER */
    char MANDAIC_LETTER_HALQA = '\u0840';
    /** ࡁ of type OTHER_LETTER */
    char MANDAIC_LETTER_AB = '\u0841';
    /** ࡂ of type OTHER_LETTER */
    char MANDAIC_LETTER_AG = '\u0842';
    /** ࡃ of type OTHER_LETTER */
    char MANDAIC_LETTER_AD = '\u0843';
    /** ࡄ of type OTHER_LETTER */
    char MANDAIC_LETTER_AH = '\u0844';
    /** ࡅ of type OTHER_LETTER */
    char MANDAIC_LETTER_USHENNA = '\u0845';
    /** ࡆ of type OTHER_LETTER */
    char MANDAIC_LETTER_AZ = '\u0846';
    /** ࡇ of type OTHER_LETTER */
    char MANDAIC_LETTER_IT = '\u0847';
    /** ࡈ of type OTHER_LETTER */
    char MANDAIC_LETTER_ATT = '\u0848';
    /** ࡉ of type OTHER_LETTER */
    char MANDAIC_LETTER_AKSA = '\u0849';
    /** ࡊ of type OTHER_LETTER */
    char MANDAIC_LETTER_AK = '\u084A';
    /** ࡋ of type OTHER_LETTER */
    char MANDAIC_LETTER_AL = '\u084B';
    /** ࡌ of type OTHER_LETTER */
    char MANDAIC_LETTER_AM = '\u084C';
    /** ࡍ of type OTHER_LETTER */
    char MANDAIC_LETTER_AN = '\u084D';
    /** ࡎ of type OTHER_LETTER */
    char MANDAIC_LETTER_AS = '\u084E';
    /** ࡏ of type OTHER_LETTER */
    char MANDAIC_LETTER_IN = '\u084F';
    /** ࡐ of type OTHER_LETTER */
    char MANDAIC_LETTER_AP = '\u0850';
    /** ࡑ of type OTHER_LETTER */
    char MANDAIC_LETTER_ASZ = '\u0851';
    /** ࡒ of type OTHER_LETTER */
    char MANDAIC_LETTER_AQ = '\u0852';
    /** ࡓ of type OTHER_LETTER */
    char MANDAIC_LETTER_AR = '\u0853';
    /** ࡔ of type OTHER_LETTER */
    char MANDAIC_LETTER_ASH = '\u0854';
    /** ࡕ of type OTHER_LETTER */
    char MANDAIC_LETTER_AT = '\u0855';
    /** ࡖ of type OTHER_LETTER */
    char MANDAIC_LETTER_DUSHENNA = '\u0856';
    /** ࡗ of type OTHER_LETTER */
    char MANDAIC_LETTER_KAD = '\u0857';
    /** ࡘ of type OTHER_LETTER */
    char MANDAIC_LETTER_AIN = '\u0858';
    /** ࡙ of type NON_SPACING_MARK */
    char MANDAIC_AFFRICATION_MARK = '\u0859';
    /** ࡚ of type NON_SPACING_MARK */
    char MANDAIC_VOCALIZATION_MARK = '\u085A';
    /** ࡛ of type NON_SPACING_MARK */
    char MANDAIC_GEMINATION_MARK = '\u085B';
    /** ࡞ of type OTHER_PUNCTUATION */
    char MANDAIC_PUNCTUATION = '\u085E';
    /** ঁ of type NON_SPACING_MARK */
    char BENGALI_SIGN_CANDRABINDU = '\u0981';
    /** ং of type COMBINING_SPACING_MARK */
    char BENGALI_SIGN_ANUSVARA = '\u0982';
    /** ঃ of type COMBINING_SPACING_MARK */
    char BENGALI_SIGN_VISARGA = '\u0983';
    /** অ of type OTHER_LETTER */
    char BENGALI_LETTER_A = '\u0985';
    /** আ of type OTHER_LETTER */
    char BENGALI_LETTER_AA = '\u0986';
    /** ই of type OTHER_LETTER */
    char BENGALI_LETTER_I = '\u0987';
    /** ঈ of type OTHER_LETTER */
    char BENGALI_LETTER_II = '\u0988';
    /** উ of type OTHER_LETTER */
    char BENGALI_LETTER_U = '\u0989';
    /** ঊ of type OTHER_LETTER */
    char BENGALI_LETTER_UU = '\u098A';
    /** ঋ of type OTHER_LETTER */
    char BENGALI_LETTER_VOCALIC_R = '\u098B';
    /** ঌ of type OTHER_LETTER */
    char BENGALI_LETTER_VOCALIC_L = '\u098C';
    /** এ of type OTHER_LETTER */
    char BENGALI_LETTER_E = '\u098F';
    /** ঐ of type OTHER_LETTER */
    char BENGALI_LETTER_AI = '\u0990';
    /** ও of type OTHER_LETTER */
    char BENGALI_LETTER_O = '\u0993';
    /** ঔ of type OTHER_LETTER */
    char BENGALI_LETTER_AU = '\u0994';
    /** ক of type OTHER_LETTER */
    char BENGALI_LETTER_KA = '\u0995';
    /** খ of type OTHER_LETTER */
    char BENGALI_LETTER_KHA = '\u0996';
    /** গ of type OTHER_LETTER */
    char BENGALI_LETTER_GA = '\u0997';
    /** ঘ of type OTHER_LETTER */
    char BENGALI_LETTER_GHA = '\u0998';
    /** ঙ of type OTHER_LETTER */
    char BENGALI_LETTER_NGA = '\u0999';
    /** চ of type OTHER_LETTER */
    char BENGALI_LETTER_CA = '\u099A';
    /** ছ of type OTHER_LETTER */
    char BENGALI_LETTER_CHA = '\u099B';
    /** জ of type OTHER_LETTER */
    char BENGALI_LETTER_JA = '\u099C';
    /** ঝ of type OTHER_LETTER */
    char BENGALI_LETTER_JHA = '\u099D';
    /** ঞ of type OTHER_LETTER */
    char BENGALI_LETTER_NYA = '\u099E';
    /** ট of type OTHER_LETTER */
    char BENGALI_LETTER_TTA = '\u099F';
    /** ঠ of type OTHER_LETTER */
    char BENGALI_LETTER_TTHA = '\u09A0';
    /** ড of type OTHER_LETTER */
    char BENGALI_LETTER_DDA = '\u09A1';
    /** ঢ of type OTHER_LETTER */
    char BENGALI_LETTER_DDHA = '\u09A2';
    /** ণ of type OTHER_LETTER */
    char BENGALI_LETTER_NNA = '\u09A3';
    /** ত of type OTHER_LETTER */
    char BENGALI_LETTER_TA = '\u09A4';
    /** থ of type OTHER_LETTER */
    char BENGALI_LETTER_THA = '\u09A5';
    /** দ of type OTHER_LETTER */
    char BENGALI_LETTER_DA = '\u09A6';
    /** ধ of type OTHER_LETTER */
    char BENGALI_LETTER_DHA = '\u09A7';
    /** ন of type OTHER_LETTER */
    char BENGALI_LETTER_NA = '\u09A8';
    /** প of type OTHER_LETTER */
    char BENGALI_LETTER_PA = '\u09AA';
    /** ফ of type OTHER_LETTER */
    char BENGALI_LETTER_PHA = '\u09AB';
    /** ব of type OTHER_LETTER */
    char BENGALI_LETTER_BA = '\u09AC';
    /** ভ of type OTHER_LETTER */
    char BENGALI_LETTER_BHA = '\u09AD';
    /** ম of type OTHER_LETTER */
    char BENGALI_LETTER_MA = '\u09AE';
    /** য of type OTHER_LETTER */
    char BENGALI_LETTER_YA = '\u09AF';
    /** র of type OTHER_LETTER */
    char BENGALI_LETTER_RA = '\u09B0';
    /** ল of type OTHER_LETTER */
    char BENGALI_LETTER_LA = '\u09B2';
    /** শ of type OTHER_LETTER */
    char BENGALI_LETTER_SHA = '\u09B6';
    /** ষ of type OTHER_LETTER */
    char BENGALI_LETTER_SSA = '\u09B7';
    /** স of type OTHER_LETTER */
    char BENGALI_LETTER_SA = '\u09B8';
    /** হ of type OTHER_LETTER */
    char BENGALI_LETTER_HA = '\u09B9';
    /** ় of type NON_SPACING_MARK */
    char BENGALI_SIGN_NUKTA = '\u09BC';
    /** ঽ of type OTHER_LETTER */
    char BENGALI_SIGN_AVAGRAHA = '\u09BD';
    /** া of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_AA = '\u09BE';
    /** ি of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_I = '\u09BF';
    /** ী of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_II = '\u09C0';
    /** ু of type NON_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_U = '\u09C1';
    /** ূ of type NON_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_UU = '\u09C2';
    /** ৃ of type NON_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_VOCALIC_R = '\u09C3';
    /** ৄ of type NON_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_VOCALIC_RR = '\u09C4';
    /** ে of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_E = '\u09C7';
    /** ৈ of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_AI = '\u09C8';
    /** ো of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_O = '\u09CB';
    /** ৌ of type COMBINING_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_AU = '\u09CC';
    /** ্ of type NON_SPACING_MARK */
    char BENGALI_SIGN_VIRAMA = '\u09CD';
    /** ৎ of type OTHER_LETTER */
    char BENGALI_LETTER_KHANDA_TA = '\u09CE';
    /** ৗ of type COMBINING_SPACING_MARK */
    char BENGALI_AU_LENGTH_MARK = '\u09D7';
    /** ড় of type OTHER_LETTER */
    char BENGALI_LETTER_RRA = '\u09DC';
    /** ঢ় of type OTHER_LETTER */
    char BENGALI_LETTER_RHA = '\u09DD';
    /** য় of type OTHER_LETTER */
    char BENGALI_LETTER_YYA = '\u09DF';
    /** ৠ of type OTHER_LETTER */
    char BENGALI_LETTER_VOCALIC_RR = '\u09E0';
    /** ৡ of type OTHER_LETTER */
    char BENGALI_LETTER_VOCALIC_LL = '\u09E1';
    /** ৢ of type NON_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_VOCALIC_L = '\u09E2';
    /** ৣ of type NON_SPACING_MARK */
    char BENGALI_VOWEL_SIGN_VOCALIC_LL = '\u09E3';
    /** ০ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_ZERO = '\u09E6';
    /** ১ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_ONE = '\u09E7';
    /** ২ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_TWO = '\u09E8';
    /** ৩ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_THREE = '\u09E9';
    /** ৪ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_FOUR = '\u09EA';
    /** ৫ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_FIVE = '\u09EB';
    /** ৬ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_SIX = '\u09EC';
    /** ৭ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_SEVEN = '\u09ED';
    /** ৮ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_EIGHT = '\u09EE';
    /** ৯ of type DECIMAL_DIGIT_NUMBER */
    char BENGALI_DIGIT_NINE = '\u09EF';
    /** ৰ of type OTHER_LETTER */
    char BENGALI_LETTER_RA_WITH_MIDDLE_DIAGONAL = '\u09F0';
    /** ৱ of type OTHER_LETTER */
    char BENGALI_LETTER_RA_WITH_LOWER_DIAGONAL = '\u09F1';
    /** ৲ of type CURRENCY_SYMBOL */
    char BENGALI_RUPEE_MARK = '\u09F2';
    /** ৳ of type CURRENCY_SYMBOL */
    char BENGALI_RUPEE_SIGN = '\u09F3';
    /** ৴ of type OTHER_NUMBER */
    char BENGALI_CURRENCY_NUMERATOR_ONE = '\u09F4';
    /** ৵ of type OTHER_NUMBER */
    char BENGALI_CURRENCY_NUMERATOR_TWO = '\u09F5';
    /** ৶ of type OTHER_NUMBER */
    char BENGALI_CURRENCY_NUMERATOR_THREE = '\u09F6';
    /** ৷ of type OTHER_NUMBER */
    char BENGALI_CURRENCY_NUMERATOR_FOUR = '\u09F7';
    /** ৸ of type OTHER_NUMBER */
    char BENGALI_CURRENCY_NUMERATOR_ONE_LESS_THAN_THE_DENOMINATOR = '\u09F8';
    /** ৹ of type OTHER_NUMBER */
    char BENGALI_CURRENCY_DENOMINATOR_SIXTEEN = '\u09F9';
    /** ৺ of type OTHER_SYMBOL */
    char BENGALI_ISSHAR = '\u09FA';
    /** ৻ of type CURRENCY_SYMBOL */
    char BENGALI_GANDA_MARK = '\u09FB';
    /** ਁ of type NON_SPACING_MARK */
    char GURMUKHI_SIGN_ADAK_BINDI = '\u0A01';
    /** ਂ of type NON_SPACING_MARK */
    char GURMUKHI_SIGN_BINDI = '\u0A02';
    /** ਃ of type COMBINING_SPACING_MARK */
    char GURMUKHI_SIGN_VISARGA = '\u0A03';
    /** ਅ of type OTHER_LETTER */
    char GURMUKHI_LETTER_A = '\u0A05';
    /** ਆ of type OTHER_LETTER */
    char GURMUKHI_LETTER_AA = '\u0A06';
    /** ਇ of type OTHER_LETTER */
    char GURMUKHI_LETTER_I = '\u0A07';
    /** ਈ of type OTHER_LETTER */
    char GURMUKHI_LETTER_II = '\u0A08';
    /** ਉ of type OTHER_LETTER */
    char GURMUKHI_LETTER_U = '\u0A09';
    /** ਊ of type OTHER_LETTER */
    char GURMUKHI_LETTER_UU = '\u0A0A';
    /** ਏ of type OTHER_LETTER */
    char GURMUKHI_LETTER_EE = '\u0A0F';
    /** ਐ of type OTHER_LETTER */
    char GURMUKHI_LETTER_AI = '\u0A10';
    /** ਓ of type OTHER_LETTER */
    char GURMUKHI_LETTER_OO = '\u0A13';
    /** ਔ of type OTHER_LETTER */
    char GURMUKHI_LETTER_AU = '\u0A14';
    /** ਕ of type OTHER_LETTER */
    char GURMUKHI_LETTER_KA = '\u0A15';
    /** ਖ of type OTHER_LETTER */
    char GURMUKHI_LETTER_KHA = '\u0A16';
    /** ਗ of type OTHER_LETTER */
    char GURMUKHI_LETTER_GA = '\u0A17';
    /** ਘ of type OTHER_LETTER */
    char GURMUKHI_LETTER_GHA = '\u0A18';
    /** ਙ of type OTHER_LETTER */
    char GURMUKHI_LETTER_NGA = '\u0A19';
    /** ਚ of type OTHER_LETTER */
    char GURMUKHI_LETTER_CA = '\u0A1A';
    /** ਛ of type OTHER_LETTER */
    char GURMUKHI_LETTER_CHA = '\u0A1B';
    /** ਜ of type OTHER_LETTER */
    char GURMUKHI_LETTER_JA = '\u0A1C';
    /** ਝ of type OTHER_LETTER */
    char GURMUKHI_LETTER_JHA = '\u0A1D';
    /** ਞ of type OTHER_LETTER */
    char GURMUKHI_LETTER_NYA = '\u0A1E';
    /** ਟ of type OTHER_LETTER */
    char GURMUKHI_LETTER_TTA = '\u0A1F';
    /** ਠ of type OTHER_LETTER */
    char GURMUKHI_LETTER_TTHA = '\u0A20';
    /** ਡ of type OTHER_LETTER */
    char GURMUKHI_LETTER_DDA = '\u0A21';
    /** ਢ of type OTHER_LETTER */
    char GURMUKHI_LETTER_DDHA = '\u0A22';
    /** ਣ of type OTHER_LETTER */
    char GURMUKHI_LETTER_NNA = '\u0A23';
    /** ਤ of type OTHER_LETTER */
    char GURMUKHI_LETTER_TA = '\u0A24';
    /** ਥ of type OTHER_LETTER */
    char GURMUKHI_LETTER_THA = '\u0A25';
    /** ਦ of type OTHER_LETTER */
    char GURMUKHI_LETTER_DA = '\u0A26';
    /** ਧ of type OTHER_LETTER */
    char GURMUKHI_LETTER_DHA = '\u0A27';
    /** ਨ of type OTHER_LETTER */
    char GURMUKHI_LETTER_NA = '\u0A28';
    /** ਪ of type OTHER_LETTER */
    char GURMUKHI_LETTER_PA = '\u0A2A';
    /** ਫ of type OTHER_LETTER */
    char GURMUKHI_LETTER_PHA = '\u0A2B';
    /** ਬ of type OTHER_LETTER */
    char GURMUKHI_LETTER_BA = '\u0A2C';
    /** ਭ of type OTHER_LETTER */
    char GURMUKHI_LETTER_BHA = '\u0A2D';
    /** ਮ of type OTHER_LETTER */
    char GURMUKHI_LETTER_MA = '\u0A2E';
    /** ਯ of type OTHER_LETTER */
    char GURMUKHI_LETTER_YA = '\u0A2F';
    /** ਰ of type OTHER_LETTER */
    char GURMUKHI_LETTER_RA = '\u0A30';
    /** ਲ of type OTHER_LETTER */
    char GURMUKHI_LETTER_LA = '\u0A32';
    /** ਲ਼ of type OTHER_LETTER */
    char GURMUKHI_LETTER_LLA = '\u0A33';
    /** ਵ of type OTHER_LETTER */
    char GURMUKHI_LETTER_VA = '\u0A35';
    /** ਸ਼ of type OTHER_LETTER */
    char GURMUKHI_LETTER_SHA = '\u0A36';
    /** ਸ of type OTHER_LETTER */
    char GURMUKHI_LETTER_SA = '\u0A38';
    /** ਹ of type OTHER_LETTER */
    char GURMUKHI_LETTER_HA = '\u0A39';
    /** ਼ of type NON_SPACING_MARK */
    char GURMUKHI_SIGN_NUKTA = '\u0A3C';
    /** ਾ of type COMBINING_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_AA = '\u0A3E';
    /** ਿ of type COMBINING_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_I = '\u0A3F';
    /** ੀ of type COMBINING_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_II = '\u0A40';
    /** ੁ of type NON_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_U = '\u0A41';
    /** ੂ of type NON_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_UU = '\u0A42';
    /** ੇ of type NON_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_EE = '\u0A47';
    /** ੈ of type NON_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_AI = '\u0A48';
    /** ੋ of type NON_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_OO = '\u0A4B';
    /** ੌ of type NON_SPACING_MARK */
    char GURMUKHI_VOWEL_SIGN_AU = '\u0A4C';
    /** ੍ of type NON_SPACING_MARK */
    char GURMUKHI_SIGN_VIRAMA = '\u0A4D';
    /** ੑ of type NON_SPACING_MARK */
    char GURMUKHI_SIGN_UDAAT = '\u0A51';
    /** ਖ਼ of type OTHER_LETTER */
    char GURMUKHI_LETTER_KHHA = '\u0A59';
    /** ਗ਼ of type OTHER_LETTER */
    char GURMUKHI_LETTER_GHHA = '\u0A5A';
    /** ਜ਼ of type OTHER_LETTER */
    char GURMUKHI_LETTER_ZA = '\u0A5B';
    /** ੜ of type OTHER_LETTER */
    char GURMUKHI_LETTER_RRA = '\u0A5C';
    /** ਫ਼ of type OTHER_LETTER */
    char GURMUKHI_LETTER_FA = '\u0A5E';
    /** ੦ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_ZERO = '\u0A66';
    /** ੧ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_ONE = '\u0A67';
    /** ੨ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_TWO = '\u0A68';
    /** ੩ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_THREE = '\u0A69';
    /** ੪ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_FOUR = '\u0A6A';
    /** ੫ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_FIVE = '\u0A6B';
    /** ੬ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_SIX = '\u0A6C';
    /** ੭ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_SEVEN = '\u0A6D';
    /** ੮ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_EIGHT = '\u0A6E';
    /** ੯ of type DECIMAL_DIGIT_NUMBER */
    char GURMUKHI_DIGIT_NINE = '\u0A6F';
    /** ੰ of type NON_SPACING_MARK */
    char GURMUKHI_TIPPI = '\u0A70';
    /** ੱ of type NON_SPACING_MARK */
    char GURMUKHI_ADDAK = '\u0A71';
    /** ੲ of type OTHER_LETTER */
    char GURMUKHI_IRI = '\u0A72';
    /** ੳ of type OTHER_LETTER */
    char GURMUKHI_URA = '\u0A73';
    /** ੴ of type OTHER_LETTER */
    char GURMUKHI_EK_ONKAR = '\u0A74';
    /** ੵ of type NON_SPACING_MARK */
    char GURMUKHI_SIGN_YAKASH = '\u0A75';
    /** ઁ of type NON_SPACING_MARK */
    char GUJARATI_SIGN_CANDRABINDU = '\u0A81';
    /** ં of type NON_SPACING_MARK */
    char GUJARATI_SIGN_ANUSVARA = '\u0A82';
    /** ઃ of type COMBINING_SPACING_MARK */
    char GUJARATI_SIGN_VISARGA = '\u0A83';
    /** અ of type OTHER_LETTER */
    char GUJARATI_LETTER_A = '\u0A85';
    /** આ of type OTHER_LETTER */
    char GUJARATI_LETTER_AA = '\u0A86';
    /** ઇ of type OTHER_LETTER */
    char GUJARATI_LETTER_I = '\u0A87';
    /** ઈ of type OTHER_LETTER */
    char GUJARATI_LETTER_II = '\u0A88';
    /** ઉ of type OTHER_LETTER */
    char GUJARATI_LETTER_U = '\u0A89';
    /** ઊ of type OTHER_LETTER */
    char GUJARATI_LETTER_UU = '\u0A8A';
    /** ઋ of type OTHER_LETTER */
    char GUJARATI_LETTER_VOCALIC_R = '\u0A8B';
    /** ઌ of type OTHER_LETTER */
    char GUJARATI_LETTER_VOCALIC_L = '\u0A8C';
    /** ઍ of type OTHER_LETTER */
    char GUJARATI_VOWEL_CANDRA_E = '\u0A8D';
    /** એ of type OTHER_LETTER */
    char GUJARATI_LETTER_E = '\u0A8F';
    /** ઐ of type OTHER_LETTER */
    char GUJARATI_LETTER_AI = '\u0A90';
    /** ઑ of type OTHER_LETTER */
    char GUJARATI_VOWEL_CANDRA_O = '\u0A91';
    /** ઓ of type OTHER_LETTER */
    char GUJARATI_LETTER_O = '\u0A93';
    /** ઔ of type OTHER_LETTER */
    char GUJARATI_LETTER_AU = '\u0A94';
    /** ક of type OTHER_LETTER */
    char GUJARATI_LETTER_KA = '\u0A95';
    /** ખ of type OTHER_LETTER */
    char GUJARATI_LETTER_KHA = '\u0A96';
    /** ગ of type OTHER_LETTER */
    char GUJARATI_LETTER_GA = '\u0A97';
    /** ઘ of type OTHER_LETTER */
    char GUJARATI_LETTER_GHA = '\u0A98';
    /** ઙ of type OTHER_LETTER */
    char GUJARATI_LETTER_NGA = '\u0A99';
    /** ચ of type OTHER_LETTER */
    char GUJARATI_LETTER_CA = '\u0A9A';
    /** છ of type OTHER_LETTER */
    char GUJARATI_LETTER_CHA = '\u0A9B';
    /** જ of type OTHER_LETTER */
    char GUJARATI_LETTER_JA = '\u0A9C';
    /** ઝ of type OTHER_LETTER */
    char GUJARATI_LETTER_JHA = '\u0A9D';
    /** ઞ of type OTHER_LETTER */
    char GUJARATI_LETTER_NYA = '\u0A9E';
    /** ટ of type OTHER_LETTER */
    char GUJARATI_LETTER_TTA = '\u0A9F';
    /** ઠ of type OTHER_LETTER */
    char GUJARATI_LETTER_TTHA = '\u0AA0';
    /** ડ of type OTHER_LETTER */
    char GUJARATI_LETTER_DDA = '\u0AA1';
    /** ઢ of type OTHER_LETTER */
    char GUJARATI_LETTER_DDHA = '\u0AA2';
    /** ણ of type OTHER_LETTER */
    char GUJARATI_LETTER_NNA = '\u0AA3';
    /** ત of type OTHER_LETTER */
    char GUJARATI_LETTER_TA = '\u0AA4';
    /** થ of type OTHER_LETTER */
    char GUJARATI_LETTER_THA = '\u0AA5';
    /** દ of type OTHER_LETTER */
    char GUJARATI_LETTER_DA = '\u0AA6';
    /** ધ of type OTHER_LETTER */
    char GUJARATI_LETTER_DHA = '\u0AA7';
    /** ન of type OTHER_LETTER */
    char GUJARATI_LETTER_NA = '\u0AA8';
    /** પ of type OTHER_LETTER */
    char GUJARATI_LETTER_PA = '\u0AAA';
    /** ફ of type OTHER_LETTER */
    char GUJARATI_LETTER_PHA = '\u0AAB';
    /** બ of type OTHER_LETTER */
    char GUJARATI_LETTER_BA = '\u0AAC';
    /** ભ of type OTHER_LETTER */
    char GUJARATI_LETTER_BHA = '\u0AAD';
    /** મ of type OTHER_LETTER */
    char GUJARATI_LETTER_MA = '\u0AAE';
    /** ય of type OTHER_LETTER */
    char GUJARATI_LETTER_YA = '\u0AAF';
    /** ર of type OTHER_LETTER */
    char GUJARATI_LETTER_RA = '\u0AB0';
    /** લ of type OTHER_LETTER */
    char GUJARATI_LETTER_LA = '\u0AB2';
    /** ળ of type OTHER_LETTER */
    char GUJARATI_LETTER_LLA = '\u0AB3';
    /** વ of type OTHER_LETTER */
    char GUJARATI_LETTER_VA = '\u0AB5';
    /** શ of type OTHER_LETTER */
    char GUJARATI_LETTER_SHA = '\u0AB6';
    /** ષ of type OTHER_LETTER */
    char GUJARATI_LETTER_SSA = '\u0AB7';
    /** સ of type OTHER_LETTER */
    char GUJARATI_LETTER_SA = '\u0AB8';
    /** હ of type OTHER_LETTER */
    char GUJARATI_LETTER_HA = '\u0AB9';
    /** ઼ of type NON_SPACING_MARK */
    char GUJARATI_SIGN_NUKTA = '\u0ABC';
    /** ઽ of type OTHER_LETTER */
    char GUJARATI_SIGN_AVAGRAHA = '\u0ABD';
    /** ા of type COMBINING_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_AA = '\u0ABE';
    /** િ of type COMBINING_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_I = '\u0ABF';
    /** ી of type COMBINING_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_II = '\u0AC0';
    /** ુ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_U = '\u0AC1';
    /** ૂ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_UU = '\u0AC2';
    /** ૃ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_VOCALIC_R = '\u0AC3';
    /** ૄ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_VOCALIC_RR = '\u0AC4';
    /** ૅ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_CANDRA_E = '\u0AC5';
    /** ે of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_E = '\u0AC7';
    /** ૈ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_AI = '\u0AC8';
    /** ૉ of type COMBINING_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_CANDRA_O = '\u0AC9';
    /** ો of type COMBINING_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_O = '\u0ACB';
    /** ૌ of type COMBINING_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_AU = '\u0ACC';
    /** ્ of type NON_SPACING_MARK */
    char GUJARATI_SIGN_VIRAMA = '\u0ACD';
    /** ૐ of type OTHER_LETTER */
    char GUJARATI_OM = '\u0AD0';
    /** ૠ of type OTHER_LETTER */
    char GUJARATI_LETTER_VOCALIC_RR = '\u0AE0';
    /** ૡ of type OTHER_LETTER */
    char GUJARATI_LETTER_VOCALIC_LL = '\u0AE1';
    /** ૢ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_VOCALIC_L = '\u0AE2';
    /** ૣ of type NON_SPACING_MARK */
    char GUJARATI_VOWEL_SIGN_VOCALIC_LL = '\u0AE3';
    /** ૦ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_ZERO = '\u0AE6';
    /** ૧ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_ONE = '\u0AE7';
    /** ૨ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_TWO = '\u0AE8';
    /** ૩ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_THREE = '\u0AE9';
    /** ૪ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_FOUR = '\u0AEA';
    /** ૫ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_FIVE = '\u0AEB';
    /** ૬ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_SIX = '\u0AEC';
    /** ૭ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_SEVEN = '\u0AED';
    /** ૮ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_EIGHT = '\u0AEE';
    /** ૯ of type DECIMAL_DIGIT_NUMBER */
    char GUJARATI_DIGIT_NINE = '\u0AEF';
    /** ૰ of type OTHER_PUNCTUATION */
    char GUJARATI_ABBREVIATION_SIGN = '\u0AF0';
    /** ૱ of type CURRENCY_SYMBOL */
    char GUJARATI_RUPEE_SIGN = '\u0AF1';
    /** ଁ of type NON_SPACING_MARK */
    char ORIYA_SIGN_CANDRABINDU = '\u0B01';
    /** ଂ of type COMBINING_SPACING_MARK */
    char ORIYA_SIGN_ANUSVARA = '\u0B02';
    /** ଃ of type COMBINING_SPACING_MARK */
    char ORIYA_SIGN_VISARGA = '\u0B03';
    /** ଅ of type OTHER_LETTER */
    char ORIYA_LETTER_A = '\u0B05';
    /** ଆ of type OTHER_LETTER */
    char ORIYA_LETTER_AA = '\u0B06';
    /** ଇ of type OTHER_LETTER */
    char ORIYA_LETTER_I = '\u0B07';
    /** ଈ of type OTHER_LETTER */
    char ORIYA_LETTER_II = '\u0B08';
    /** ଉ of type OTHER_LETTER */
    char ORIYA_LETTER_U = '\u0B09';
    /** ଊ of type OTHER_LETTER */
    char ORIYA_LETTER_UU = '\u0B0A';
    /** ଋ of type OTHER_LETTER */
    char ORIYA_LETTER_VOCALIC_R = '\u0B0B';
    /** ଌ of type OTHER_LETTER */
    char ORIYA_LETTER_VOCALIC_L = '\u0B0C';
    /** ଏ of type OTHER_LETTER */
    char ORIYA_LETTER_E = '\u0B0F';
    /** ଐ of type OTHER_LETTER */
    char ORIYA_LETTER_AI = '\u0B10';
    /** ଓ of type OTHER_LETTER */
    char ORIYA_LETTER_O = '\u0B13';
    /** ଔ of type OTHER_LETTER */
    char ORIYA_LETTER_AU = '\u0B14';
    /** କ of type OTHER_LETTER */
    char ORIYA_LETTER_KA = '\u0B15';
    /** ଖ of type OTHER_LETTER */
    char ORIYA_LETTER_KHA = '\u0B16';
    /** ଗ of type OTHER_LETTER */
    char ORIYA_LETTER_GA = '\u0B17';
    /** ଘ of type OTHER_LETTER */
    char ORIYA_LETTER_GHA = '\u0B18';
    /** ଙ of type OTHER_LETTER */
    char ORIYA_LETTER_NGA = '\u0B19';
    /** ଚ of type OTHER_LETTER */
    char ORIYA_LETTER_CA = '\u0B1A';
    /** ଛ of type OTHER_LETTER */
    char ORIYA_LETTER_CHA = '\u0B1B';
    /** ଜ of type OTHER_LETTER */
    char ORIYA_LETTER_JA = '\u0B1C';
    /** ଝ of type OTHER_LETTER */
    char ORIYA_LETTER_JHA = '\u0B1D';
    /** ଞ of type OTHER_LETTER */
    char ORIYA_LETTER_NYA = '\u0B1E';
    /** ଟ of type OTHER_LETTER */
    char ORIYA_LETTER_TTA = '\u0B1F';
    /** ଠ of type OTHER_LETTER */
    char ORIYA_LETTER_TTHA = '\u0B20';
    /** ଡ of type OTHER_LETTER */
    char ORIYA_LETTER_DDA = '\u0B21';
    /** ଢ of type OTHER_LETTER */
    char ORIYA_LETTER_DDHA = '\u0B22';
    /** ଣ of type OTHER_LETTER */
    char ORIYA_LETTER_NNA = '\u0B23';
    /** ତ of type OTHER_LETTER */
    char ORIYA_LETTER_TA = '\u0B24';
    /** ଥ of type OTHER_LETTER */
    char ORIYA_LETTER_THA = '\u0B25';
    /** ଦ of type OTHER_LETTER */
    char ORIYA_LETTER_DA = '\u0B26';
    /** ଧ of type OTHER_LETTER */
    char ORIYA_LETTER_DHA = '\u0B27';
    /** ନ of type OTHER_LETTER */
    char ORIYA_LETTER_NA = '\u0B28';
    /** ପ of type OTHER_LETTER */
    char ORIYA_LETTER_PA = '\u0B2A';
    /** ଫ of type OTHER_LETTER */
    char ORIYA_LETTER_PHA = '\u0B2B';
    /** ବ of type OTHER_LETTER */
    char ORIYA_LETTER_BA = '\u0B2C';
    /** ଭ of type OTHER_LETTER */
    char ORIYA_LETTER_BHA = '\u0B2D';
    /** ମ of type OTHER_LETTER */
    char ORIYA_LETTER_MA = '\u0B2E';
    /** ଯ of type OTHER_LETTER */
    char ORIYA_LETTER_YA = '\u0B2F';
    /** ର of type OTHER_LETTER */
    char ORIYA_LETTER_RA = '\u0B30';
    /** ଲ of type OTHER_LETTER */
    char ORIYA_LETTER_LA = '\u0B32';
    /** ଳ of type OTHER_LETTER */
    char ORIYA_LETTER_LLA = '\u0B33';
    /** ଵ of type OTHER_LETTER */
    char ORIYA_LETTER_VA = '\u0B35';
    /** ଶ of type OTHER_LETTER */
    char ORIYA_LETTER_SHA = '\u0B36';
    /** ଷ of type OTHER_LETTER */
    char ORIYA_LETTER_SSA = '\u0B37';
    /** ସ of type OTHER_LETTER */
    char ORIYA_LETTER_SA = '\u0B38';
    /** ହ of type OTHER_LETTER */
    char ORIYA_LETTER_HA = '\u0B39';
    /** ଼ of type NON_SPACING_MARK */
    char ORIYA_SIGN_NUKTA = '\u0B3C';
    /** ଽ of type OTHER_LETTER */
    char ORIYA_SIGN_AVAGRAHA = '\u0B3D';
    /** ା of type COMBINING_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_AA = '\u0B3E';
    /** ି of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_I = '\u0B3F';
    /** ୀ of type COMBINING_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_II = '\u0B40';
    /** ୁ of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_U = '\u0B41';
    /** ୂ of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_UU = '\u0B42';
    /** ୃ of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_VOCALIC_R = '\u0B43';
    /** ୄ of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_VOCALIC_RR = '\u0B44';
    /** େ of type COMBINING_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_E = '\u0B47';
    /** ୈ of type COMBINING_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_AI = '\u0B48';
    /** ୋ of type COMBINING_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_O = '\u0B4B';
    /** ୌ of type COMBINING_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_AU = '\u0B4C';
    /** ୍ of type NON_SPACING_MARK */
    char ORIYA_SIGN_VIRAMA = '\u0B4D';
    /** ୖ of type NON_SPACING_MARK */
    char ORIYA_AI_LENGTH_MARK = '\u0B56';
    /** ୗ of type COMBINING_SPACING_MARK */
    char ORIYA_AU_LENGTH_MARK = '\u0B57';
    /** ଡ଼ of type OTHER_LETTER */
    char ORIYA_LETTER_RRA = '\u0B5C';
    /** ଢ଼ of type OTHER_LETTER */
    char ORIYA_LETTER_RHA = '\u0B5D';
    /** ୟ of type OTHER_LETTER */
    char ORIYA_LETTER_YYA = '\u0B5F';
    /** ୠ of type OTHER_LETTER */
    char ORIYA_LETTER_VOCALIC_RR = '\u0B60';
    /** ୡ of type OTHER_LETTER */
    char ORIYA_LETTER_VOCALIC_LL = '\u0B61';
    /** ୢ of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_VOCALIC_L = '\u0B62';
    /** ୣ of type NON_SPACING_MARK */
    char ORIYA_VOWEL_SIGN_VOCALIC_LL = '\u0B63';
    /** ୦ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_ZERO = '\u0B66';
    /** ୧ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_ONE = '\u0B67';
    /** ୨ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_TWO = '\u0B68';
    /** ୩ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_THREE = '\u0B69';
    /** ୪ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_FOUR = '\u0B6A';
    /** ୫ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_FIVE = '\u0B6B';
    /** ୬ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_SIX = '\u0B6C';
    /** ୭ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_SEVEN = '\u0B6D';
    /** ୮ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_EIGHT = '\u0B6E';
    /** ୯ of type DECIMAL_DIGIT_NUMBER */
    char ORIYA_DIGIT_NINE = '\u0B6F';
    /** ୰ of type OTHER_SYMBOL */
    char ORIYA_ISSHAR = '\u0B70';
    /** ୱ of type OTHER_LETTER */
    char ORIYA_LETTER_WA = '\u0B71';
    /** ୲ of type OTHER_NUMBER */
    char ORIYA_FRACTION_ONE_QUARTER = '\u0B72';
    /** ୳ of type OTHER_NUMBER */
    char ORIYA_FRACTION_ONE_HALF = '\u0B73';
    /** ୴ of type OTHER_NUMBER */
    char ORIYA_FRACTION_THREE_QUARTERS = '\u0B74';
    /** ୵ of type OTHER_NUMBER */
    char ORIYA_FRACTION_ONE_SIXTEENTH = '\u0B75';
    /** ୶ of type OTHER_NUMBER */
    char ORIYA_FRACTION_ONE_EIGHTH = '\u0B76';
    /** ୷ of type OTHER_NUMBER */
    char ORIYA_FRACTION_THREE_SIXTEENTHS = '\u0B77';
    /** ஂ of type NON_SPACING_MARK */
    char TAMIL_SIGN_ANUSVARA = '\u0B82';
    /** ஃ of type OTHER_LETTER */
    char TAMIL_SIGN_VISARGA = '\u0B83';
    /** அ of type OTHER_LETTER */
    char TAMIL_LETTER_A = '\u0B85';
    /** ஆ of type OTHER_LETTER */
    char TAMIL_LETTER_AA = '\u0B86';
    /** இ of type OTHER_LETTER */
    char TAMIL_LETTER_I = '\u0B87';
    /** ஈ of type OTHER_LETTER */
    char TAMIL_LETTER_II = '\u0B88';
    /** உ of type OTHER_LETTER */
    char TAMIL_LETTER_U = '\u0B89';
    /** ஊ of type OTHER_LETTER */
    char TAMIL_LETTER_UU = '\u0B8A';
    /** எ of type OTHER_LETTER */
    char TAMIL_LETTER_E = '\u0B8E';
    /** ஏ of type OTHER_LETTER */
    char TAMIL_LETTER_EE = '\u0B8F';
    /** ஐ of type OTHER_LETTER */
    char TAMIL_LETTER_AI = '\u0B90';
    /** ஒ of type OTHER_LETTER */
    char TAMIL_LETTER_O = '\u0B92';
    /** ஓ of type OTHER_LETTER */
    char TAMIL_LETTER_OO = '\u0B93';
    /** ஔ of type OTHER_LETTER */
    char TAMIL_LETTER_AU = '\u0B94';
    /** க of type OTHER_LETTER */
    char TAMIL_LETTER_KA = '\u0B95';
    /** ங of type OTHER_LETTER */
    char TAMIL_LETTER_NGA = '\u0B99';
    /** ச of type OTHER_LETTER */
    char TAMIL_LETTER_CA = '\u0B9A';
    /** ஜ of type OTHER_LETTER */
    char TAMIL_LETTER_JA = '\u0B9C';
    /** ஞ of type OTHER_LETTER */
    char TAMIL_LETTER_NYA = '\u0B9E';
    /** ட of type OTHER_LETTER */
    char TAMIL_LETTER_TTA = '\u0B9F';
    /** ண of type OTHER_LETTER */
    char TAMIL_LETTER_NNA = '\u0BA3';
    /** த of type OTHER_LETTER */
    char TAMIL_LETTER_TA = '\u0BA4';
    /** ந of type OTHER_LETTER */
    char TAMIL_LETTER_NA = '\u0BA8';
    /** ன of type OTHER_LETTER */
    char TAMIL_LETTER_NNNA = '\u0BA9';
    /** ப of type OTHER_LETTER */
    char TAMIL_LETTER_PA = '\u0BAA';
    /** ம of type OTHER_LETTER */
    char TAMIL_LETTER_MA = '\u0BAE';
    /** ய of type OTHER_LETTER */
    char TAMIL_LETTER_YA = '\u0BAF';
    /** ர of type OTHER_LETTER */
    char TAMIL_LETTER_RA = '\u0BB0';
    /** ற of type OTHER_LETTER */
    char TAMIL_LETTER_RRA = '\u0BB1';
    /** ல of type OTHER_LETTER */
    char TAMIL_LETTER_LA = '\u0BB2';
    /** ள of type OTHER_LETTER */
    char TAMIL_LETTER_LLA = '\u0BB3';
    /** ழ of type OTHER_LETTER */
    char TAMIL_LETTER_LLLA = '\u0BB4';
    /** வ of type OTHER_LETTER */
    char TAMIL_LETTER_VA = '\u0BB5';
    /** ஶ of type OTHER_LETTER */
    char TAMIL_LETTER_SHA = '\u0BB6';
    /** ஷ of type OTHER_LETTER */
    char TAMIL_LETTER_SSA = '\u0BB7';
    /** ஸ of type OTHER_LETTER */
    char TAMIL_LETTER_SA = '\u0BB8';
    /** ஹ of type OTHER_LETTER */
    char TAMIL_LETTER_HA = '\u0BB9';
    /** ா of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_AA = '\u0BBE';
    /** ி of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_I = '\u0BBF';
    /** ீ of type NON_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_II = '\u0BC0';
    /** ு of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_U = '\u0BC1';
    /** ூ of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_UU = '\u0BC2';
    /** ெ of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_E = '\u0BC6';
    /** ே of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_EE = '\u0BC7';
    /** ை of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_AI = '\u0BC8';
    /** ொ of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_O = '\u0BCA';
    /** ோ of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_OO = '\u0BCB';
    /** ௌ of type COMBINING_SPACING_MARK */
    char TAMIL_VOWEL_SIGN_AU = '\u0BCC';
    /** ் of type NON_SPACING_MARK */
    char TAMIL_SIGN_VIRAMA = '\u0BCD';
    /** ௐ of type OTHER_LETTER */
    char TAMIL_OM = '\u0BD0';
    /** ௗ of type COMBINING_SPACING_MARK */
    char TAMIL_AU_LENGTH_MARK = '\u0BD7';
    /** ௦ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_ZERO = '\u0BE6';
    /** ௧ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_ONE = '\u0BE7';
    /** ௨ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_TWO = '\u0BE8';
    /** ௩ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_THREE = '\u0BE9';
    /** ௪ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_FOUR = '\u0BEA';
    /** ௫ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_FIVE = '\u0BEB';
    /** ௬ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_SIX = '\u0BEC';
    /** ௭ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_SEVEN = '\u0BED';
    /** ௮ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_EIGHT = '\u0BEE';
    /** ௯ of type DECIMAL_DIGIT_NUMBER */
    char TAMIL_DIGIT_NINE = '\u0BEF';
    /** ௰ of type OTHER_NUMBER */
    char TAMIL_NUMBER_TEN = '\u0BF0';
    /** ௱ of type OTHER_NUMBER */
    char TAMIL_NUMBER_ONE_HUNDRED = '\u0BF1';
    /** ௲ of type OTHER_NUMBER */
    char TAMIL_NUMBER_ONE_THOUSAND = '\u0BF2';
    /** ௳ of type OTHER_SYMBOL */
    char TAMIL_DAY_SIGN = '\u0BF3';
    /** ௴ of type OTHER_SYMBOL */
    char TAMIL_MONTH_SIGN = '\u0BF4';
    /** ௵ of type OTHER_SYMBOL */
    char TAMIL_YEAR_SIGN = '\u0BF5';
    /** ௶ of type OTHER_SYMBOL */
    char TAMIL_DEBIT_SIGN = '\u0BF6';
    /** ௷ of type OTHER_SYMBOL */
    char TAMIL_CREDIT_SIGN = '\u0BF7';
    /** ௸ of type OTHER_SYMBOL */
    char TAMIL_AS_ABOVE_SIGN = '\u0BF8';
    /** ௹ of type CURRENCY_SYMBOL */
    char TAMIL_RUPEE_SIGN = '\u0BF9';
    /** ௺ of type OTHER_SYMBOL */
    char TAMIL_NUMBER_SIGN = '\u0BFA';
    /** ఁ of type COMBINING_SPACING_MARK */
    char TELUGU_SIGN_CANDRABINDU = '\u0C01';
    /** ం of type COMBINING_SPACING_MARK */
    char TELUGU_SIGN_ANUSVARA = '\u0C02';
    /** ః of type COMBINING_SPACING_MARK */
    char TELUGU_SIGN_VISARGA = '\u0C03';
    /** అ of type OTHER_LETTER */
    char TELUGU_LETTER_A = '\u0C05';
    /** ఆ of type OTHER_LETTER */
    char TELUGU_LETTER_AA = '\u0C06';
    /** ఇ of type OTHER_LETTER */
    char TELUGU_LETTER_I = '\u0C07';
    /** ఈ of type OTHER_LETTER */
    char TELUGU_LETTER_II = '\u0C08';
    /** ఉ of type OTHER_LETTER */
    char TELUGU_LETTER_U = '\u0C09';
    /** ఊ of type OTHER_LETTER */
    char TELUGU_LETTER_UU = '\u0C0A';
    /** ఋ of type OTHER_LETTER */
    char TELUGU_LETTER_VOCALIC_R = '\u0C0B';
    /** ఌ of type OTHER_LETTER */
    char TELUGU_LETTER_VOCALIC_L = '\u0C0C';
    /** ఎ of type OTHER_LETTER */
    char TELUGU_LETTER_E = '\u0C0E';
    /** ఏ of type OTHER_LETTER */
    char TELUGU_LETTER_EE = '\u0C0F';
    /** ఐ of type OTHER_LETTER */
    char TELUGU_LETTER_AI = '\u0C10';
    /** ఒ of type OTHER_LETTER */
    char TELUGU_LETTER_O = '\u0C12';
    /** ఓ of type OTHER_LETTER */
    char TELUGU_LETTER_OO = '\u0C13';
    /** ఔ of type OTHER_LETTER */
    char TELUGU_LETTER_AU = '\u0C14';
    /** క of type OTHER_LETTER */
    char TELUGU_LETTER_KA = '\u0C15';
    /** ఖ of type OTHER_LETTER */
    char TELUGU_LETTER_KHA = '\u0C16';
    /** గ of type OTHER_LETTER */
    char TELUGU_LETTER_GA = '\u0C17';
    /** ఘ of type OTHER_LETTER */
    char TELUGU_LETTER_GHA = '\u0C18';
    /** ఙ of type OTHER_LETTER */
    char TELUGU_LETTER_NGA = '\u0C19';
    /** చ of type OTHER_LETTER */
    char TELUGU_LETTER_CA = '\u0C1A';
    /** ఛ of type OTHER_LETTER */
    char TELUGU_LETTER_CHA = '\u0C1B';
    /** జ of type OTHER_LETTER */
    char TELUGU_LETTER_JA = '\u0C1C';
    /** ఝ of type OTHER_LETTER */
    char TELUGU_LETTER_JHA = '\u0C1D';
    /** ఞ of type OTHER_LETTER */
    char TELUGU_LETTER_NYA = '\u0C1E';
    /** ట of type OTHER_LETTER */
    char TELUGU_LETTER_TTA = '\u0C1F';
    /** ఠ of type OTHER_LETTER */
    char TELUGU_LETTER_TTHA = '\u0C20';
    /** డ of type OTHER_LETTER */
    char TELUGU_LETTER_DDA = '\u0C21';
    /** ఢ of type OTHER_LETTER */
    char TELUGU_LETTER_DDHA = '\u0C22';
    /** ణ of type OTHER_LETTER */
    char TELUGU_LETTER_NNA = '\u0C23';
    /** త of type OTHER_LETTER */
    char TELUGU_LETTER_TA = '\u0C24';
    /** థ of type OTHER_LETTER */
    char TELUGU_LETTER_THA = '\u0C25';
    /** ద of type OTHER_LETTER */
    char TELUGU_LETTER_DA = '\u0C26';
    /** ధ of type OTHER_LETTER */
    char TELUGU_LETTER_DHA = '\u0C27';
    /** న of type OTHER_LETTER */
    char TELUGU_LETTER_NA = '\u0C28';
    /** ప of type OTHER_LETTER */
    char TELUGU_LETTER_PA = '\u0C2A';
    /** ఫ of type OTHER_LETTER */
    char TELUGU_LETTER_PHA = '\u0C2B';
    /** బ of type OTHER_LETTER */
    char TELUGU_LETTER_BA = '\u0C2C';
    /** భ of type OTHER_LETTER */
    char TELUGU_LETTER_BHA = '\u0C2D';
    /** మ of type OTHER_LETTER */
    char TELUGU_LETTER_MA = '\u0C2E';
    /** య of type OTHER_LETTER */
    char TELUGU_LETTER_YA = '\u0C2F';
    /** ర of type OTHER_LETTER */
    char TELUGU_LETTER_RA = '\u0C30';
    /** ఱ of type OTHER_LETTER */
    char TELUGU_LETTER_RRA = '\u0C31';
    /** ల of type OTHER_LETTER */
    char TELUGU_LETTER_LA = '\u0C32';
    /** ళ of type OTHER_LETTER */
    char TELUGU_LETTER_LLA = '\u0C33';
    /** వ of type OTHER_LETTER */
    char TELUGU_LETTER_VA = '\u0C35';
    /** శ of type OTHER_LETTER */
    char TELUGU_LETTER_SHA = '\u0C36';
    /** ష of type OTHER_LETTER */
    char TELUGU_LETTER_SSA = '\u0C37';
    /** స of type OTHER_LETTER */
    char TELUGU_LETTER_SA = '\u0C38';
    /** హ of type OTHER_LETTER */
    char TELUGU_LETTER_HA = '\u0C39';
    /** ఽ of type OTHER_LETTER */
    char TELUGU_SIGN_AVAGRAHA = '\u0C3D';
    /** ా of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_AA = '\u0C3E';
    /** ి of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_I = '\u0C3F';
    /** ీ of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_II = '\u0C40';
    /** ు of type COMBINING_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_U = '\u0C41';
    /** ూ of type COMBINING_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_UU = '\u0C42';
    /** ృ of type COMBINING_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_VOCALIC_R = '\u0C43';
    /** ౄ of type COMBINING_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_VOCALIC_RR = '\u0C44';
    /** ె of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_E = '\u0C46';
    /** ే of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_EE = '\u0C47';
    /** ై of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_AI = '\u0C48';
    /** ొ of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_O = '\u0C4A';
    /** ో of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_OO = '\u0C4B';
    /** ౌ of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_AU = '\u0C4C';
    /** ్ of type NON_SPACING_MARK */
    char TELUGU_SIGN_VIRAMA = '\u0C4D';
    /** ౕ of type NON_SPACING_MARK */
    char TELUGU_LENGTH_MARK = '\u0C55';
    /** ౖ of type NON_SPACING_MARK */
    char TELUGU_AI_LENGTH_MARK = '\u0C56';
    /** ౘ of type OTHER_LETTER */
    char TELUGU_LETTER_TSA = '\u0C58';
    /** ౙ of type OTHER_LETTER */
    char TELUGU_LETTER_DZA = '\u0C59';
    /** ౠ of type OTHER_LETTER */
    char TELUGU_LETTER_VOCALIC_RR = '\u0C60';
    /** ౡ of type OTHER_LETTER */
    char TELUGU_LETTER_VOCALIC_LL = '\u0C61';
    /** ౢ of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_VOCALIC_L = '\u0C62';
    /** ౣ of type NON_SPACING_MARK */
    char TELUGU_VOWEL_SIGN_VOCALIC_LL = '\u0C63';
    /** ౦ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_ZERO = '\u0C66';
    /** ౧ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_ONE = '\u0C67';
    /** ౨ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_TWO = '\u0C68';
    /** ౩ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_THREE = '\u0C69';
    /** ౪ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_FOUR = '\u0C6A';
    /** ౫ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_FIVE = '\u0C6B';
    /** ౬ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_SIX = '\u0C6C';
    /** ౭ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_SEVEN = '\u0C6D';
    /** ౮ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_EIGHT = '\u0C6E';
    /** ౯ of type DECIMAL_DIGIT_NUMBER */
    char TELUGU_DIGIT_NINE = '\u0C6F';
    /** ౸ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_ZERO_FOR_ODD_POWERS_OF_FOUR = '\u0C78';
    /** ౹ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_ONE_FOR_ODD_POWERS_OF_FOUR = '\u0C79';
    /** ౺ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_TWO_FOR_ODD_POWERS_OF_FOUR = '\u0C7A';
    /** ౻ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_THREE_FOR_ODD_POWERS_OF_FOUR = '\u0C7B';
    /** ౼ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_ONE_FOR_EVEN_POWERS_OF_FOUR = '\u0C7C';
    /** ౽ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_TWO_FOR_EVEN_POWERS_OF_FOUR = '\u0C7D';
    /** ౾ of type OTHER_NUMBER */
    char TELUGU_FRACTION_DIGIT_THREE_FOR_EVEN_POWERS_OF_FOUR = '\u0C7E';
    /** ౿ of type OTHER_SYMBOL */
    char TELUGU_SIGN_TUUMU = '\u0C7F';
    /** ಂ of type COMBINING_SPACING_MARK */
    char KANNADA_SIGN_ANUSVARA = '\u0C82';
    /** ಃ of type COMBINING_SPACING_MARK */
    char KANNADA_SIGN_VISARGA = '\u0C83';
    /** ಅ of type OTHER_LETTER */
    char KANNADA_LETTER_A = '\u0C85';
    /** ಆ of type OTHER_LETTER */
    char KANNADA_LETTER_AA = '\u0C86';
    /** ಇ of type OTHER_LETTER */
    char KANNADA_LETTER_I = '\u0C87';
    /** ಈ of type OTHER_LETTER */
    char KANNADA_LETTER_II = '\u0C88';
    /** ಉ of type OTHER_LETTER */
    char KANNADA_LETTER_U = '\u0C89';
    /** ಊ of type OTHER_LETTER */
    char KANNADA_LETTER_UU = '\u0C8A';
    /** ಋ of type OTHER_LETTER */
    char KANNADA_LETTER_VOCALIC_R = '\u0C8B';
    /** ಌ of type OTHER_LETTER */
    char KANNADA_LETTER_VOCALIC_L = '\u0C8C';
    /** ಎ of type OTHER_LETTER */
    char KANNADA_LETTER_E = '\u0C8E';
    /** ಏ of type OTHER_LETTER */
    char KANNADA_LETTER_EE = '\u0C8F';
    /** ಐ of type OTHER_LETTER */
    char KANNADA_LETTER_AI = '\u0C90';
    /** ಒ of type OTHER_LETTER */
    char KANNADA_LETTER_O = '\u0C92';
    /** ಓ of type OTHER_LETTER */
    char KANNADA_LETTER_OO = '\u0C93';
    /** ಔ of type OTHER_LETTER */
    char KANNADA_LETTER_AU = '\u0C94';
    /** ಕ of type OTHER_LETTER */
    char KANNADA_LETTER_KA = '\u0C95';
    /** ಖ of type OTHER_LETTER */
    char KANNADA_LETTER_KHA = '\u0C96';
    /** ಗ of type OTHER_LETTER */
    char KANNADA_LETTER_GA = '\u0C97';
    /** ಘ of type OTHER_LETTER */
    char KANNADA_LETTER_GHA = '\u0C98';
    /** ಙ of type OTHER_LETTER */
    char KANNADA_LETTER_NGA = '\u0C99';
    /** ಚ of type OTHER_LETTER */
    char KANNADA_LETTER_CA = '\u0C9A';
    /** ಛ of type OTHER_LETTER */
    char KANNADA_LETTER_CHA = '\u0C9B';
    /** ಜ of type OTHER_LETTER */
    char KANNADA_LETTER_JA = '\u0C9C';
    /** ಝ of type OTHER_LETTER */
    char KANNADA_LETTER_JHA = '\u0C9D';
    /** ಞ of type OTHER_LETTER */
    char KANNADA_LETTER_NYA = '\u0C9E';
    /** ಟ of type OTHER_LETTER */
    char KANNADA_LETTER_TTA = '\u0C9F';
    /** ಠ of type OTHER_LETTER */
    char KANNADA_LETTER_TTHA = '\u0CA0';
    /** ಡ of type OTHER_LETTER */
    char KANNADA_LETTER_DDA = '\u0CA1';
    /** ಢ of type OTHER_LETTER */
    char KANNADA_LETTER_DDHA = '\u0CA2';
    /** ಣ of type OTHER_LETTER */
    char KANNADA_LETTER_NNA = '\u0CA3';
    /** ತ of type OTHER_LETTER */
    char KANNADA_LETTER_TA = '\u0CA4';
    /** ಥ of type OTHER_LETTER */
    char KANNADA_LETTER_THA = '\u0CA5';
    /** ದ of type OTHER_LETTER */
    char KANNADA_LETTER_DA = '\u0CA6';
    /** ಧ of type OTHER_LETTER */
    char KANNADA_LETTER_DHA = '\u0CA7';
    /** ನ of type OTHER_LETTER */
    char KANNADA_LETTER_NA = '\u0CA8';
    /** ಪ of type OTHER_LETTER */
    char KANNADA_LETTER_PA = '\u0CAA';
    /** ಫ of type OTHER_LETTER */
    char KANNADA_LETTER_PHA = '\u0CAB';
    /** ಬ of type OTHER_LETTER */
    char KANNADA_LETTER_BA = '\u0CAC';
    /** ಭ of type OTHER_LETTER */
    char KANNADA_LETTER_BHA = '\u0CAD';
    /** ಮ of type OTHER_LETTER */
    char KANNADA_LETTER_MA = '\u0CAE';
    /** ಯ of type OTHER_LETTER */
    char KANNADA_LETTER_YA = '\u0CAF';
    /** ರ of type OTHER_LETTER */
    char KANNADA_LETTER_RA = '\u0CB0';
    /** ಱ of type OTHER_LETTER */
    char KANNADA_LETTER_RRA = '\u0CB1';
    /** ಲ of type OTHER_LETTER */
    char KANNADA_LETTER_LA = '\u0CB2';
    /** ಳ of type OTHER_LETTER */
    char KANNADA_LETTER_LLA = '\u0CB3';
    /** ವ of type OTHER_LETTER */
    char KANNADA_LETTER_VA = '\u0CB5';
    /** ಶ of type OTHER_LETTER */
    char KANNADA_LETTER_SHA = '\u0CB6';
    /** ಷ of type OTHER_LETTER */
    char KANNADA_LETTER_SSA = '\u0CB7';
    /** ಸ of type OTHER_LETTER */
    char KANNADA_LETTER_SA = '\u0CB8';
    /** ಹ of type OTHER_LETTER */
    char KANNADA_LETTER_HA = '\u0CB9';
    /** ಼ of type NON_SPACING_MARK */
    char KANNADA_SIGN_NUKTA = '\u0CBC';
    /** ಽ of type OTHER_LETTER */
    char KANNADA_SIGN_AVAGRAHA = '\u0CBD';
    /** ಾ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_AA = '\u0CBE';
    /** ಿ of type NON_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_I = '\u0CBF';
    /** ೀ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_II = '\u0CC0';
    /** ು of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_U = '\u0CC1';
    /** ೂ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_UU = '\u0CC2';
    /** ೃ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_VOCALIC_R = '\u0CC3';
    /** ೄ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_VOCALIC_RR = '\u0CC4';
    /** ೆ of type NON_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_E = '\u0CC6';
    /** ೇ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_EE = '\u0CC7';
    /** ೈ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_AI = '\u0CC8';
    /** ೊ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_O = '\u0CCA';
    /** ೋ of type COMBINING_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_OO = '\u0CCB';
    /** ೌ of type NON_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_AU = '\u0CCC';
    /** ್ of type NON_SPACING_MARK */
    char KANNADA_SIGN_VIRAMA = '\u0CCD';
    /** ೕ of type COMBINING_SPACING_MARK */
    char KANNADA_LENGTH_MARK = '\u0CD5';
    /** ೖ of type COMBINING_SPACING_MARK */
    char KANNADA_AI_LENGTH_MARK = '\u0CD6';
    /** ೞ of type OTHER_LETTER */
    char KANNADA_LETTER_FA = '\u0CDE';
    /** ೠ of type OTHER_LETTER */
    char KANNADA_LETTER_VOCALIC_RR = '\u0CE0';
    /** ೡ of type OTHER_LETTER */
    char KANNADA_LETTER_VOCALIC_LL = '\u0CE1';
    /** ೢ of type NON_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_VOCALIC_L = '\u0CE2';
    /** ೣ of type NON_SPACING_MARK */
    char KANNADA_VOWEL_SIGN_VOCALIC_LL = '\u0CE3';
    /** ೦ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_ZERO = '\u0CE6';
    /** ೧ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_ONE = '\u0CE7';
    /** ೨ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_TWO = '\u0CE8';
    /** ೩ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_THREE = '\u0CE9';
    /** ೪ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_FOUR = '\u0CEA';
    /** ೫ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_FIVE = '\u0CEB';
    /** ೬ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_SIX = '\u0CEC';
    /** ೭ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_SEVEN = '\u0CED';
    /** ೮ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_EIGHT = '\u0CEE';
    /** ೯ of type DECIMAL_DIGIT_NUMBER */
    char KANNADA_DIGIT_NINE = '\u0CEF';
    /** ೱ of type OTHER_LETTER */
    char KANNADA_SIGN_JIHVAMULIYA = '\u0CF1';
    /** ೲ of type OTHER_LETTER */
    char KANNADA_SIGN_UPADHMANIYA = '\u0CF2';
    /** ം of type COMBINING_SPACING_MARK */
    char MALAYALAM_SIGN_ANUSVARA = '\u0D02';
    /** ഃ of type COMBINING_SPACING_MARK */
    char MALAYALAM_SIGN_VISARGA = '\u0D03';
    /** അ of type OTHER_LETTER */
    char MALAYALAM_LETTER_A = '\u0D05';
    /** ആ of type OTHER_LETTER */
    char MALAYALAM_LETTER_AA = '\u0D06';
    /** ഇ of type OTHER_LETTER */
    char MALAYALAM_LETTER_I = '\u0D07';
    /** ഈ of type OTHER_LETTER */
    char MALAYALAM_LETTER_II = '\u0D08';
    /** ഉ of type OTHER_LETTER */
    char MALAYALAM_LETTER_U = '\u0D09';
    /** ഊ of type OTHER_LETTER */
    char MALAYALAM_LETTER_UU = '\u0D0A';
    /** ഋ of type OTHER_LETTER */
    char MALAYALAM_LETTER_VOCALIC_R = '\u0D0B';
    /** ഌ of type OTHER_LETTER */
    char MALAYALAM_LETTER_VOCALIC_L = '\u0D0C';
    /** എ of type OTHER_LETTER */
    char MALAYALAM_LETTER_E = '\u0D0E';
    /** ഏ of type OTHER_LETTER */
    char MALAYALAM_LETTER_EE = '\u0D0F';
    /** ഐ of type OTHER_LETTER */
    char MALAYALAM_LETTER_AI = '\u0D10';
    /** ഒ of type OTHER_LETTER */
    char MALAYALAM_LETTER_O = '\u0D12';
    /** ഓ of type OTHER_LETTER */
    char MALAYALAM_LETTER_OO = '\u0D13';
    /** ഔ of type OTHER_LETTER */
    char MALAYALAM_LETTER_AU = '\u0D14';
    /** ക of type OTHER_LETTER */
    char MALAYALAM_LETTER_KA = '\u0D15';
    /** ഖ of type OTHER_LETTER */
    char MALAYALAM_LETTER_KHA = '\u0D16';
    /** ഗ of type OTHER_LETTER */
    char MALAYALAM_LETTER_GA = '\u0D17';
    /** ഘ of type OTHER_LETTER */
    char MALAYALAM_LETTER_GHA = '\u0D18';
    /** ങ of type OTHER_LETTER */
    char MALAYALAM_LETTER_NGA = '\u0D19';
    /** ച of type OTHER_LETTER */
    char MALAYALAM_LETTER_CA = '\u0D1A';
    /** ഛ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHA = '\u0D1B';
    /** ജ of type OTHER_LETTER */
    char MALAYALAM_LETTER_JA = '\u0D1C';
    /** ഝ of type OTHER_LETTER */
    char MALAYALAM_LETTER_JHA = '\u0D1D';
    /** ഞ of type OTHER_LETTER */
    char MALAYALAM_LETTER_NYA = '\u0D1E';
    /** ട of type OTHER_LETTER */
    char MALAYALAM_LETTER_TTA = '\u0D1F';
    /** ഠ of type OTHER_LETTER */
    char MALAYALAM_LETTER_TTHA = '\u0D20';
    /** ഡ of type OTHER_LETTER */
    char MALAYALAM_LETTER_DDA = '\u0D21';
    /** ഢ of type OTHER_LETTER */
    char MALAYALAM_LETTER_DDHA = '\u0D22';
    /** ണ of type OTHER_LETTER */
    char MALAYALAM_LETTER_NNA = '\u0D23';
    /** ത of type OTHER_LETTER */
    char MALAYALAM_LETTER_TA = '\u0D24';
    /** ഥ of type OTHER_LETTER */
    char MALAYALAM_LETTER_THA = '\u0D25';
    /** ദ of type OTHER_LETTER */
    char MALAYALAM_LETTER_DA = '\u0D26';
    /** ധ of type OTHER_LETTER */
    char MALAYALAM_LETTER_DHA = '\u0D27';
    /** ന of type OTHER_LETTER */
    char MALAYALAM_LETTER_NA = '\u0D28';
    /** ഩ of type OTHER_LETTER */
    char MALAYALAM_LETTER_NNNA = '\u0D29';
    /** പ of type OTHER_LETTER */
    char MALAYALAM_LETTER_PA = '\u0D2A';
    /** ഫ of type OTHER_LETTER */
    char MALAYALAM_LETTER_PHA = '\u0D2B';
    /** ബ of type OTHER_LETTER */
    char MALAYALAM_LETTER_BA = '\u0D2C';
    /** ഭ of type OTHER_LETTER */
    char MALAYALAM_LETTER_BHA = '\u0D2D';
    /** മ of type OTHER_LETTER */
    char MALAYALAM_LETTER_MA = '\u0D2E';
    /** യ of type OTHER_LETTER */
    char MALAYALAM_LETTER_YA = '\u0D2F';
    /** ര of type OTHER_LETTER */
    char MALAYALAM_LETTER_RA = '\u0D30';
    /** റ of type OTHER_LETTER */
    char MALAYALAM_LETTER_RRA = '\u0D31';
    /** ല of type OTHER_LETTER */
    char MALAYALAM_LETTER_LA = '\u0D32';
    /** ള of type OTHER_LETTER */
    char MALAYALAM_LETTER_LLA = '\u0D33';
    /** ഴ of type OTHER_LETTER */
    char MALAYALAM_LETTER_LLLA = '\u0D34';
    /** വ of type OTHER_LETTER */
    char MALAYALAM_LETTER_VA = '\u0D35';
    /** ശ of type OTHER_LETTER */
    char MALAYALAM_LETTER_SHA = '\u0D36';
    /** ഷ of type OTHER_LETTER */
    char MALAYALAM_LETTER_SSA = '\u0D37';
    /** സ of type OTHER_LETTER */
    char MALAYALAM_LETTER_SA = '\u0D38';
    /** ഹ of type OTHER_LETTER */
    char MALAYALAM_LETTER_HA = '\u0D39';
    /** ഺ of type OTHER_LETTER */
    char MALAYALAM_LETTER_TTTA = '\u0D3A';
    /** ഽ of type OTHER_LETTER */
    char MALAYALAM_SIGN_AVAGRAHA = '\u0D3D';
    /** ാ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_AA = '\u0D3E';
    /** ി of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_I = '\u0D3F';
    /** ീ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_II = '\u0D40';
    /** ു of type NON_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_U = '\u0D41';
    /** ൂ of type NON_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_UU = '\u0D42';
    /** ൃ of type NON_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_VOCALIC_R = '\u0D43';
    /** ൄ of type NON_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_VOCALIC_RR = '\u0D44';
    /** െ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_E = '\u0D46';
    /** േ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_EE = '\u0D47';
    /** ൈ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_AI = '\u0D48';
    /** ൊ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_O = '\u0D4A';
    /** ോ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_OO = '\u0D4B';
    /** ൌ of type COMBINING_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_AU = '\u0D4C';
    /** ് of type NON_SPACING_MARK */
    char MALAYALAM_SIGN_VIRAMA = '\u0D4D';
    /** ൎ of type OTHER_LETTER */
    char MALAYALAM_LETTER_DOT_REPH = '\u0D4E';
    /** ൗ of type COMBINING_SPACING_MARK */
    char MALAYALAM_AU_LENGTH_MARK = '\u0D57';
    /** ൠ of type OTHER_LETTER */
    char MALAYALAM_LETTER_VOCALIC_RR = '\u0D60';
    /** ൡ of type OTHER_LETTER */
    char MALAYALAM_LETTER_VOCALIC_LL = '\u0D61';
    /** ൢ of type NON_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_VOCALIC_L = '\u0D62';
    /** ൣ of type NON_SPACING_MARK */
    char MALAYALAM_VOWEL_SIGN_VOCALIC_LL = '\u0D63';
    /** ൦ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_ZERO = '\u0D66';
    /** ൧ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_ONE = '\u0D67';
    /** ൨ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_TWO = '\u0D68';
    /** ൩ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_THREE = '\u0D69';
    /** ൪ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_FOUR = '\u0D6A';
    /** ൫ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_FIVE = '\u0D6B';
    /** ൬ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_SIX = '\u0D6C';
    /** ൭ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_SEVEN = '\u0D6D';
    /** ൮ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_EIGHT = '\u0D6E';
    /** ൯ of type DECIMAL_DIGIT_NUMBER */
    char MALAYALAM_DIGIT_NINE = '\u0D6F';
    /** ൰ of type OTHER_NUMBER */
    char MALAYALAM_NUMBER_TEN = '\u0D70';
    /** ൱ of type OTHER_NUMBER */
    char MALAYALAM_NUMBER_ONE_HUNDRED = '\u0D71';
    /** ൲ of type OTHER_NUMBER */
    char MALAYALAM_NUMBER_ONE_THOUSAND = '\u0D72';
    /** ൳ of type OTHER_NUMBER */
    char MALAYALAM_FRACTION_ONE_QUARTER = '\u0D73';
    /** ൴ of type OTHER_NUMBER */
    char MALAYALAM_FRACTION_ONE_HALF = '\u0D74';
    /** ൵ of type OTHER_NUMBER */
    char MALAYALAM_FRACTION_THREE_QUARTERS = '\u0D75';
    /** ൹ of type OTHER_SYMBOL */
    char MALAYALAM_DATE_MARK = '\u0D79';
    /** ൺ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHILLU_NN = '\u0D7A';
    /** ൻ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHILLU_N = '\u0D7B';
    /** ർ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHILLU_RR = '\u0D7C';
    /** ൽ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHILLU_L = '\u0D7D';
    /** ൾ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHILLU_LL = '\u0D7E';
    /** ൿ of type OTHER_LETTER */
    char MALAYALAM_LETTER_CHILLU_K = '\u0D7F';
    /** ං of type COMBINING_SPACING_MARK */
    char SINHALA_SIGN_ANUSVARAYA = '\u0D82';
    /** ඃ of type COMBINING_SPACING_MARK */
    char SINHALA_SIGN_VISARGAYA = '\u0D83';
    /** අ of type OTHER_LETTER */
    char SINHALA_LETTER_AYANNA = '\u0D85';
    /** ආ of type OTHER_LETTER */
    char SINHALA_LETTER_AAYANNA = '\u0D86';
    /** ඇ of type OTHER_LETTER */
    char SINHALA_LETTER_AEYANNA = '\u0D87';
    /** ඈ of type OTHER_LETTER */
    char SINHALA_LETTER_AEEYANNA = '\u0D88';
    /** ඉ of type OTHER_LETTER */
    char SINHALA_LETTER_IYANNA = '\u0D89';
    /** ඊ of type OTHER_LETTER */
    char SINHALA_LETTER_IIYANNA = '\u0D8A';
    /** උ of type OTHER_LETTER */
    char SINHALA_LETTER_UYANNA = '\u0D8B';
    /** ඌ of type OTHER_LETTER */
    char SINHALA_LETTER_UUYANNA = '\u0D8C';
    /** ඍ of type OTHER_LETTER */
    char SINHALA_LETTER_IRUYANNA = '\u0D8D';
    /** ඎ of type OTHER_LETTER */
    char SINHALA_LETTER_IRUUYANNA = '\u0D8E';
    /** ඏ of type OTHER_LETTER */
    char SINHALA_LETTER_ILUYANNA = '\u0D8F';
    /** ඐ of type OTHER_LETTER */
    char SINHALA_LETTER_ILUUYANNA = '\u0D90';
    /** එ of type OTHER_LETTER */
    char SINHALA_LETTER_EYANNA = '\u0D91';
    /** ඒ of type OTHER_LETTER */
    char SINHALA_LETTER_EEYANNA = '\u0D92';
    /** ඓ of type OTHER_LETTER */
    char SINHALA_LETTER_AIYANNA = '\u0D93';
    /** ඔ of type OTHER_LETTER */
    char SINHALA_LETTER_OYANNA = '\u0D94';
    /** ඕ of type OTHER_LETTER */
    char SINHALA_LETTER_OOYANNA = '\u0D95';
    /** ඖ of type OTHER_LETTER */
    char SINHALA_LETTER_AUYANNA = '\u0D96';
    /** ක of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_KAYANNA = '\u0D9A';
    /** ඛ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_KAYANNA = '\u0D9B';
    /** ග of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_GAYANNA = '\u0D9C';
    /** ඝ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_GAYANNA = '\u0D9D';
    /** ඞ of type OTHER_LETTER */
    char SINHALA_LETTER_KANTAJA_NAASIKYAYA = '\u0D9E';
    /** ඟ of type OTHER_LETTER */
    char SINHALA_LETTER_SANYAKA_GAYANNA = '\u0D9F';
    /** ච of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_CAYANNA = '\u0DA0';
    /** ඡ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_CAYANNA = '\u0DA1';
    /** ජ of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_JAYANNA = '\u0DA2';
    /** ඣ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_JAYANNA = '\u0DA3';
    /** ඤ of type OTHER_LETTER */
    char SINHALA_LETTER_TAALUJA_NAASIKYAYA = '\u0DA4';
    /** ඥ of type OTHER_LETTER */
    char SINHALA_LETTER_TAALUJA_SANYOOGA_NAAKSIKYAYA = '\u0DA5';
    /** ඦ of type OTHER_LETTER */
    char SINHALA_LETTER_SANYAKA_JAYANNA = '\u0DA6';
    /** ට of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_TTAYANNA = '\u0DA7';
    /** ඨ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_TTAYANNA = '\u0DA8';
    /** ඩ of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_DDAYANNA = '\u0DA9';
    /** ඪ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_DDAYANNA = '\u0DAA';
    /** ණ of type OTHER_LETTER */
    char SINHALA_LETTER_MUURDHAJA_NAYANNA = '\u0DAB';
    /** ඬ of type OTHER_LETTER */
    char SINHALA_LETTER_SANYAKA_DDAYANNA = '\u0DAC';
    /** ත of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_TAYANNA = '\u0DAD';
    /** ථ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_TAYANNA = '\u0DAE';
    /** ද of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_DAYANNA = '\u0DAF';
    /** ධ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_DAYANNA = '\u0DB0';
    /** න of type OTHER_LETTER */
    char SINHALA_LETTER_DANTAJA_NAYANNA = '\u0DB1';
    /** ඳ of type OTHER_LETTER */
    char SINHALA_LETTER_SANYAKA_DAYANNA = '\u0DB3';
    /** ප of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_PAYANNA = '\u0DB4';
    /** ඵ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_PAYANNA = '\u0DB5';
    /** බ of type OTHER_LETTER */
    char SINHALA_LETTER_ALPAPRAANA_BAYANNA = '\u0DB6';
    /** භ of type OTHER_LETTER */
    char SINHALA_LETTER_MAHAAPRAANA_BAYANNA = '\u0DB7';
    /** ම of type OTHER_LETTER */
    char SINHALA_LETTER_MAYANNA = '\u0DB8';
    /** ඹ of type OTHER_LETTER */
    char SINHALA_LETTER_AMBA_BAYANNA = '\u0DB9';
    /** ය of type OTHER_LETTER */
    char SINHALA_LETTER_YAYANNA = '\u0DBA';
    /** ර of type OTHER_LETTER */
    char SINHALA_LETTER_RAYANNA = '\u0DBB';
    /** ල of type OTHER_LETTER */
    char SINHALA_LETTER_DANTAJA_LAYANNA = '\u0DBD';
    /** ව of type OTHER_LETTER */
    char SINHALA_LETTER_VAYANNA = '\u0DC0';
    /** ශ of type OTHER_LETTER */
    char SINHALA_LETTER_TAALUJA_SAYANNA = '\u0DC1';
    /** ෂ of type OTHER_LETTER */
    char SINHALA_LETTER_MUURDHAJA_SAYANNA = '\u0DC2';
    /** ස of type OTHER_LETTER */
    char SINHALA_LETTER_DANTAJA_SAYANNA = '\u0DC3';
    /** හ of type OTHER_LETTER */
    char SINHALA_LETTER_HAYANNA = '\u0DC4';
    /** ළ of type OTHER_LETTER */
    char SINHALA_LETTER_MUURDHAJA_LAYANNA = '\u0DC5';
    /** ෆ of type OTHER_LETTER */
    char SINHALA_LETTER_FAYANNA = '\u0DC6';
    /** ් of type NON_SPACING_MARK */
    char SINHALA_SIGN_AL_LAKUNA = '\u0DCA';
    /** ා of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_AELA_PILLA = '\u0DCF';
    /** ැ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KETTI_AEDA_PILLA = '\u0DD0';
    /** ෑ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_DIGA_AEDA_PILLA = '\u0DD1';
    /** ි of type NON_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KETTI_IS_PILLA = '\u0DD2';
    /** ී of type NON_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_DIGA_IS_PILLA = '\u0DD3';
    /** ු of type NON_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KETTI_PAA_PILLA = '\u0DD4';
    /** ූ of type NON_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_DIGA_PAA_PILLA = '\u0DD6';
    /** ෘ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_GAETTA_PILLA = '\u0DD8';
    /** ෙ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KOMBUVA = '\u0DD9';
    /** ේ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_DIGA_KOMBUVA = '\u0DDA';
    /** ෛ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KOMBU_DEKA = '\u0DDB';
    /** ො of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KOMBUVA_HAA_AELA_PILLA = '\u0DDC';
    /** ෝ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KOMBUVA_HAA_DIGA_AELA_PILLA = '\u0DDD';
    /** ෞ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_KOMBUVA_HAA_GAYANUKITTA = '\u0DDE';
    /** ෟ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_GAYANUKITTA = '\u0DDF';
    /** ෲ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_DIGA_GAETTA_PILLA = '\u0DF2';
    /** ෳ of type COMBINING_SPACING_MARK */
    char SINHALA_VOWEL_SIGN_DIGA_GAYANUKITTA = '\u0DF3';
    /** ෴ of type OTHER_PUNCTUATION */
    char SINHALA_PUNCTUATION_KUNDDALIYA = '\u0DF4';
    /** ก of type OTHER_LETTER */
    char THAI_CHARACTER_KO_KAI = '\u0E01';
    /** ข of type OTHER_LETTER */
    char THAI_CHARACTER_KHO_KHAI = '\u0E02';
    /** ฃ of type OTHER_LETTER */
    char THAI_CHARACTER_KHO_KHUAT = '\u0E03';
    /** ค of type OTHER_LETTER */
    char THAI_CHARACTER_KHO_KHWAI = '\u0E04';
    /** ฅ of type OTHER_LETTER */
    char THAI_CHARACTER_KHO_KHON = '\u0E05';
    /** ฆ of type OTHER_LETTER */
    char THAI_CHARACTER_KHO_RAKHANG = '\u0E06';
    /** ง of type OTHER_LETTER */
    char THAI_CHARACTER_NGO_NGU = '\u0E07';
    /** จ of type OTHER_LETTER */
    char THAI_CHARACTER_CHO_CHAN = '\u0E08';
    /** ฉ of type OTHER_LETTER */
    char THAI_CHARACTER_CHO_CHING = '\u0E09';
    /** ช of type OTHER_LETTER */
    char THAI_CHARACTER_CHO_CHANG = '\u0E0A';
    /** ซ of type OTHER_LETTER */
    char THAI_CHARACTER_SO_SO = '\u0E0B';
    /** ฌ of type OTHER_LETTER */
    char THAI_CHARACTER_CHO_CHOE = '\u0E0C';
    /** ญ of type OTHER_LETTER */
    char THAI_CHARACTER_YO_YING = '\u0E0D';
    /** ฎ of type OTHER_LETTER */
    char THAI_CHARACTER_DO_CHADA = '\u0E0E';
    /** ฏ of type OTHER_LETTER */
    char THAI_CHARACTER_TO_PATAK = '\u0E0F';
    /** ฐ of type OTHER_LETTER */
    char THAI_CHARACTER_THO_THAN = '\u0E10';
    /** ฑ of type OTHER_LETTER */
    char THAI_CHARACTER_THO_NANGMONTHO = '\u0E11';
    /** ฒ of type OTHER_LETTER */
    char THAI_CHARACTER_THO_PHUTHAO = '\u0E12';
    /** ณ of type OTHER_LETTER */
    char THAI_CHARACTER_NO_NEN = '\u0E13';
    /** ด of type OTHER_LETTER */
    char THAI_CHARACTER_DO_DEK = '\u0E14';
    /** ต of type OTHER_LETTER */
    char THAI_CHARACTER_TO_TAO = '\u0E15';
    /** ถ of type OTHER_LETTER */
    char THAI_CHARACTER_THO_THUNG = '\u0E16';
    /** ท of type OTHER_LETTER */
    char THAI_CHARACTER_THO_THAHAN = '\u0E17';
    /** ธ of type OTHER_LETTER */
    char THAI_CHARACTER_THO_THONG = '\u0E18';
    /** น of type OTHER_LETTER */
    char THAI_CHARACTER_NO_NU = '\u0E19';
    /** บ of type OTHER_LETTER */
    char THAI_CHARACTER_BO_BAIMAI = '\u0E1A';
    /** ป of type OTHER_LETTER */
    char THAI_CHARACTER_PO_PLA = '\u0E1B';
    /** ผ of type OTHER_LETTER */
    char THAI_CHARACTER_PHO_PHUNG = '\u0E1C';
    /** ฝ of type OTHER_LETTER */
    char THAI_CHARACTER_FO_FA = '\u0E1D';
    /** พ of type OTHER_LETTER */
    char THAI_CHARACTER_PHO_PHAN = '\u0E1E';
    /** ฟ of type OTHER_LETTER */
    char THAI_CHARACTER_FO_FAN = '\u0E1F';
    /** ภ of type OTHER_LETTER */
    char THAI_CHARACTER_PHO_SAMPHAO = '\u0E20';
    /** ม of type OTHER_LETTER */
    char THAI_CHARACTER_MO_MA = '\u0E21';
    /** ย of type OTHER_LETTER */
    char THAI_CHARACTER_YO_YAK = '\u0E22';
    /** ร of type OTHER_LETTER */
    char THAI_CHARACTER_RO_RUA = '\u0E23';
    /** ฤ of type OTHER_LETTER */
    char THAI_CHARACTER_RU = '\u0E24';
    /** ล of type OTHER_LETTER */
    char THAI_CHARACTER_LO_LING = '\u0E25';
    /** ฦ of type OTHER_LETTER */
    char THAI_CHARACTER_LU = '\u0E26';
    /** ว of type OTHER_LETTER */
    char THAI_CHARACTER_WO_WAEN = '\u0E27';
    /** ศ of type OTHER_LETTER */
    char THAI_CHARACTER_SO_SALA = '\u0E28';
    /** ษ of type OTHER_LETTER */
    char THAI_CHARACTER_SO_RUSI = '\u0E29';
    /** ส of type OTHER_LETTER */
    char THAI_CHARACTER_SO_SUA = '\u0E2A';
    /** ห of type OTHER_LETTER */
    char THAI_CHARACTER_HO_HIP = '\u0E2B';
    /** ฬ of type OTHER_LETTER */
    char THAI_CHARACTER_LO_CHULA = '\u0E2C';
    /** อ of type OTHER_LETTER */
    char THAI_CHARACTER_O_ANG = '\u0E2D';
    /** ฮ of type OTHER_LETTER */
    char THAI_CHARACTER_HO_NOKHUK = '\u0E2E';
    /** ฯ of type OTHER_LETTER */
    char THAI_CHARACTER_PAIYANNOI = '\u0E2F';
    /** ะ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_A = '\u0E30';
    /** ั of type NON_SPACING_MARK */
    char THAI_CHARACTER_MAI_HAN_AKAT = '\u0E31';
    /** า of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_AA = '\u0E32';
    /** ำ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_AM = '\u0E33';
    /** ิ of type NON_SPACING_MARK */
    char THAI_CHARACTER_SARA_I = '\u0E34';
    /** ี of type NON_SPACING_MARK */
    char THAI_CHARACTER_SARA_II = '\u0E35';
    /** ึ of type NON_SPACING_MARK */
    char THAI_CHARACTER_SARA_UE = '\u0E36';
    /** ื of type NON_SPACING_MARK */
    char THAI_CHARACTER_SARA_UEE = '\u0E37';
    /** ุ of type NON_SPACING_MARK */
    char THAI_CHARACTER_SARA_U = '\u0E38';
    /** ู of type NON_SPACING_MARK */
    char THAI_CHARACTER_SARA_UU = '\u0E39';
    /** ฺ of type NON_SPACING_MARK */
    char THAI_CHARACTER_PHINTHU = '\u0E3A';
    /** ฿ of type CURRENCY_SYMBOL */
    char THAI_CURRENCY_SYMBOL_BAHT = '\u0E3F';
    /** เ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_E = '\u0E40';
    /** แ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_AE = '\u0E41';
    /** โ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_O = '\u0E42';
    /** ใ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_AI_MAIMUAN = '\u0E43';
    /** ไ of type OTHER_LETTER */
    char THAI_CHARACTER_SARA_AI_MAIMALAI = '\u0E44';
    /** ๅ of type OTHER_LETTER */
    char THAI_CHARACTER_LAKKHANGYAO = '\u0E45';
    /** ๆ of type MODIFIER_LETTER */
    char THAI_CHARACTER_MAIYAMOK = '\u0E46';
    /** ็ of type NON_SPACING_MARK */
    char THAI_CHARACTER_MAITAIKHU = '\u0E47';
    /** ่ of type NON_SPACING_MARK */
    char THAI_CHARACTER_MAI_EK = '\u0E48';
    /** ้ of type NON_SPACING_MARK */
    char THAI_CHARACTER_MAI_THO = '\u0E49';
    /** ๊ of type NON_SPACING_MARK */
    char THAI_CHARACTER_MAI_TRI = '\u0E4A';
    /** ๋ of type NON_SPACING_MARK */
    char THAI_CHARACTER_MAI_CHATTAWA = '\u0E4B';
    /** ์ of type NON_SPACING_MARK */
    char THAI_CHARACTER_THANTHAKHAT = '\u0E4C';
    /** ํ of type NON_SPACING_MARK */
    char THAI_CHARACTER_NIKHAHIT = '\u0E4D';
    /** ๎ of type NON_SPACING_MARK */
    char THAI_CHARACTER_YAMAKKAN = '\u0E4E';
    /** ๏ of type OTHER_PUNCTUATION */
    char THAI_CHARACTER_FONGMAN = '\u0E4F';
    /** ๐ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_ZERO = '\u0E50';
    /** ๑ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_ONE = '\u0E51';
    /** ๒ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_TWO = '\u0E52';
    /** ๓ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_THREE = '\u0E53';
    /** ๔ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_FOUR = '\u0E54';
    /** ๕ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_FIVE = '\u0E55';
    /** ๖ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_SIX = '\u0E56';
    /** ๗ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_SEVEN = '\u0E57';
    /** ๘ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_EIGHT = '\u0E58';
    /** ๙ of type DECIMAL_DIGIT_NUMBER */
    char THAI_DIGIT_NINE = '\u0E59';
    /** ๚ of type OTHER_PUNCTUATION */
    char THAI_CHARACTER_ANGKHANKHU = '\u0E5A';
    /** ๛ of type OTHER_PUNCTUATION */
    char THAI_CHARACTER_KHOMUT = '\u0E5B';
    /** ກ of type OTHER_LETTER */
    char LAO_LETTER_KO = '\u0E81';
    /** ຂ of type OTHER_LETTER */
    char LAO_LETTER_KHO_SUNG = '\u0E82';
    /** ຄ of type OTHER_LETTER */
    char LAO_LETTER_KHO_TAM = '\u0E84';
    /** ງ of type OTHER_LETTER */
    char LAO_LETTER_NGO = '\u0E87';
    /** ຈ of type OTHER_LETTER */
    char LAO_LETTER_CO = '\u0E88';
    /** ຊ of type OTHER_LETTER */
    char LAO_LETTER_SO_TAM = '\u0E8A';
    /** ຍ of type OTHER_LETTER */
    char LAO_LETTER_NYO = '\u0E8D';
    /** ດ of type OTHER_LETTER */
    char LAO_LETTER_DO = '\u0E94';
    /** ຕ of type OTHER_LETTER */
    char LAO_LETTER_TO = '\u0E95';
    /** ຖ of type OTHER_LETTER */
    char LAO_LETTER_THO_SUNG = '\u0E96';
    /** ທ of type OTHER_LETTER */
    char LAO_LETTER_THO_TAM = '\u0E97';
    /** ນ of type OTHER_LETTER */
    char LAO_LETTER_NO = '\u0E99';
    /** ບ of type OTHER_LETTER */
    char LAO_LETTER_BO = '\u0E9A';
    /** ປ of type OTHER_LETTER */
    char LAO_LETTER_PO = '\u0E9B';
    /** ຜ of type OTHER_LETTER */
    char LAO_LETTER_PHO_SUNG = '\u0E9C';
    /** ຝ of type OTHER_LETTER */
    char LAO_LETTER_FO_TAM = '\u0E9D';
    /** ພ of type OTHER_LETTER */
    char LAO_LETTER_PHO_TAM = '\u0E9E';
    /** ຟ of type OTHER_LETTER */
    char LAO_LETTER_FO_SUNG = '\u0E9F';
    /** ມ of type OTHER_LETTER */
    char LAO_LETTER_MO = '\u0EA1';
    /** ຢ of type OTHER_LETTER */
    char LAO_LETTER_YO = '\u0EA2';
    /** ຣ of type OTHER_LETTER */
    char LAO_LETTER_LO_LING = '\u0EA3';
    /** ລ of type OTHER_LETTER */
    char LAO_LETTER_LO_LOOT = '\u0EA5';
    /** ວ of type OTHER_LETTER */
    char LAO_LETTER_WO = '\u0EA7';
    /** ສ of type OTHER_LETTER */
    char LAO_LETTER_SO_SUNG = '\u0EAA';
    /** ຫ of type OTHER_LETTER */
    char LAO_LETTER_HO_SUNG = '\u0EAB';
    /** ອ of type OTHER_LETTER */
    char LAO_LETTER_O = '\u0EAD';
    /** ຮ of type OTHER_LETTER */
    char LAO_LETTER_HO_TAM = '\u0EAE';
    /** ຯ of type OTHER_LETTER */
    char LAO_ELLIPSIS = '\u0EAF';
    /** ະ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_A = '\u0EB0';
    /** ັ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_MAI_KAN = '\u0EB1';
    /** າ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_AA = '\u0EB2';
    /** ຳ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_AM = '\u0EB3';
    /** ິ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_I = '\u0EB4';
    /** ີ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_II = '\u0EB5';
    /** ຶ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_Y = '\u0EB6';
    /** ື of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_YY = '\u0EB7';
    /** ຸ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_U = '\u0EB8';
    /** ູ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_UU = '\u0EB9';
    /** ົ of type NON_SPACING_MARK */
    char LAO_VOWEL_SIGN_MAI_KON = '\u0EBB';
    /** ຼ of type NON_SPACING_MARK */
    char LAO_SEMIVOWEL_SIGN_LO = '\u0EBC';
    /** ຽ of type OTHER_LETTER */
    char LAO_SEMIVOWEL_SIGN_NYO = '\u0EBD';
    /** ເ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_E = '\u0EC0';
    /** ແ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_EI = '\u0EC1';
    /** ໂ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_O = '\u0EC2';
    /** ໃ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_AY = '\u0EC3';
    /** ໄ of type OTHER_LETTER */
    char LAO_VOWEL_SIGN_AI = '\u0EC4';
    /** ໆ of type MODIFIER_LETTER */
    char LAO_KO_LA = '\u0EC6';
    /** ່ of type NON_SPACING_MARK */
    char LAO_TONE_MAI_EK = '\u0EC8';
    /** ້ of type NON_SPACING_MARK */
    char LAO_TONE_MAI_THO = '\u0EC9';
    /** ໊ of type NON_SPACING_MARK */
    char LAO_TONE_MAI_TI = '\u0ECA';
    /** ໋ of type NON_SPACING_MARK */
    char LAO_TONE_MAI_CATAWA = '\u0ECB';
    /** ໌ of type NON_SPACING_MARK */
    char LAO_CANCELLATION_MARK = '\u0ECC';
    /** ໍ of type NON_SPACING_MARK */
    char LAO_NIGGAHITA = '\u0ECD';
    /** ໐ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_ZERO = '\u0ED0';
    /** ໑ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_ONE = '\u0ED1';
    /** ໒ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_TWO = '\u0ED2';
    /** ໓ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_THREE = '\u0ED3';
    /** ໔ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_FOUR = '\u0ED4';
    /** ໕ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_FIVE = '\u0ED5';
    /** ໖ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_SIX = '\u0ED6';
    /** ໗ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_SEVEN = '\u0ED7';
    /** ໘ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_EIGHT = '\u0ED8';
    /** ໙ of type DECIMAL_DIGIT_NUMBER */
    char LAO_DIGIT_NINE = '\u0ED9';
    /** ໜ of type OTHER_LETTER */
    char LAO_HO_NO = '\u0EDC';
    /** ໝ of type OTHER_LETTER */
    char LAO_HO_MO = '\u0EDD';
    /** ໞ of type OTHER_LETTER */
    char LAO_LETTER_KHMU_GO = '\u0EDE';
    /** ໟ of type OTHER_LETTER */
    char LAO_LETTER_KHMU_NYO = '\u0EDF';
    /** ༀ of type OTHER_LETTER */
    char TIBETAN_SYLLABLE_OM = '\u0F00';
    /** ༁ of type OTHER_SYMBOL */
    char TIBETAN_MARK_GTER_YIG_MGO_TRUNCATED_A = '\u0F01';
    /** ༂ of type OTHER_SYMBOL */
    char TIBETAN_MARK_GTER_YIG_MGO__UM_RNAM_BCAD_MA = '\u0F02';
    /** ༃ of type OTHER_SYMBOL */
    char TIBETAN_MARK_GTER_YIG_MGO__UM_GTER_TSHEG_MA = '\u0F03';
    /** ༄ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_INITIAL_YIG_MGO_MDUN_MA = '\u0F04';
    /** ༅ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_CLOSING_YIG_MGO_SGAB_MA = '\u0F05';
    /** ༆ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_CARET_YIG_MGO_PHUR_SHAD_MA = '\u0F06';
    /** ༇ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_YIG_MGO_TSHEG_SHAD_MA = '\u0F07';
    /** ༈ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_SBRUL_SHAD = '\u0F08';
    /** ༉ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_BSKUR_YIG_MGO = '\u0F09';
    /** ༊ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_BKA__SHOG_YIG_MGO = '\u0F0A';
    /** ་ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_INTERSYLLABIC_TSHEG = '\u0F0B';
    /** ༌ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_DELIMITER_TSHEG_BSTAR = '\u0F0C';
    /** ། of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_SHAD = '\u0F0D';
    /** ༎ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_NYIS_SHAD = '\u0F0E';
    /** ༏ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_TSHEG_SHAD = '\u0F0F';
    /** ༐ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_NYIS_TSHEG_SHAD = '\u0F10';
    /** ༑ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_RIN_CHEN_SPUNGS_SHAD = '\u0F11';
    /** ༒ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_RGYA_GRAM_SHAD = '\u0F12';
    /** ༓ of type OTHER_SYMBOL */
    char TIBETAN_MARK_CARET__DZUD_RTAGS_ME_LONG_CAN = '\u0F13';
    /** ༔ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_GTER_TSHEG = '\u0F14';
    /** ༕ of type OTHER_SYMBOL */
    char TIBETAN_LOGOTYPE_SIGN_CHAD_RTAGS = '\u0F15';
    /** ༖ of type OTHER_SYMBOL */
    char TIBETAN_LOGOTYPE_SIGN_LHAG_RTAGS = '\u0F16';
    /** ༗ of type OTHER_SYMBOL */
    char TIBETAN_ASTROLOGICAL_SIGN_SGRA_GCAN__CHAR_RTAGS = '\u0F17';
    /** ༘ of type NON_SPACING_MARK */
    char TIBETAN_ASTROLOGICAL_SIGN__KHYUD_PA = '\u0F18';
    /** ༙ of type NON_SPACING_MARK */
    char TIBETAN_ASTROLOGICAL_SIGN_SDONG_TSHUGS = '\u0F19';
    /** ༚ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_DKAR_GCIG = '\u0F1A';
    /** ༛ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_DKAR_GNYIS = '\u0F1B';
    /** ༜ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_DKAR_GSUM = '\u0F1C';
    /** ༝ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_NAG_GCIG = '\u0F1D';
    /** ༞ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_NAG_GNYIS = '\u0F1E';
    /** ༟ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_DKAR_RDEL_NAG = '\u0F1F';
    /** ༠ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_ZERO = '\u0F20';
    /** ༡ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_ONE = '\u0F21';
    /** ༢ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_TWO = '\u0F22';
    /** ༣ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_THREE = '\u0F23';
    /** ༤ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_FOUR = '\u0F24';
    /** ༥ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_FIVE = '\u0F25';
    /** ༦ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_SIX = '\u0F26';
    /** ༧ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_SEVEN = '\u0F27';
    /** ༨ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_EIGHT = '\u0F28';
    /** ༩ of type DECIMAL_DIGIT_NUMBER */
    char TIBETAN_DIGIT_NINE = '\u0F29';
    /** ༪ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_ONE = '\u0F2A';
    /** ༫ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_TWO = '\u0F2B';
    /** ༬ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_THREE = '\u0F2C';
    /** ༭ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_FOUR = '\u0F2D';
    /** ༮ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_FIVE = '\u0F2E';
    /** ༯ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_SIX = '\u0F2F';
    /** ༰ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_SEVEN = '\u0F30';
    /** ༱ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_EIGHT = '\u0F31';
    /** ༲ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_NINE = '\u0F32';
    /** ༳ of type OTHER_NUMBER */
    char TIBETAN_DIGIT_HALF_ZERO = '\u0F33';
    /** ༴ of type OTHER_SYMBOL */
    char TIBETAN_MARK_BSDUS_RTAGS = '\u0F34';
    /** ༵ of type NON_SPACING_MARK */
    char TIBETAN_MARK_NGAS_BZUNG_NYI_ZLA = '\u0F35';
    /** ༶ of type OTHER_SYMBOL */
    char TIBETAN_MARK_CARET__DZUD_RTAGS_BZHI_MIG_CAN = '\u0F36';
    /** ༷ of type NON_SPACING_MARK */
    char TIBETAN_MARK_NGAS_BZUNG_SGOR_RTAGS = '\u0F37';
    /** ༸ of type OTHER_SYMBOL */
    char TIBETAN_MARK_CHE_MGO = '\u0F38';
    /** ༹ of type NON_SPACING_MARK */
    char TIBETAN_MARK_TSA__PHRU = '\u0F39';
    /** ༺ of type START_PUNCTUATION */
    char TIBETAN_MARK_GUG_RTAGS_GYON = '\u0F3A';
    /** ༻ of type END_PUNCTUATION */
    char TIBETAN_MARK_GUG_RTAGS_GYAS = '\u0F3B';
    /** ༼ of type START_PUNCTUATION */
    char TIBETAN_MARK_ANG_KHANG_GYON = '\u0F3C';
    /** ༽ of type END_PUNCTUATION */
    char TIBETAN_MARK_ANG_KHANG_GYAS = '\u0F3D';
    /** ༾ of type COMBINING_SPACING_MARK */
    char TIBETAN_SIGN_YAR_TSHES = '\u0F3E';
    /** ༿ of type COMBINING_SPACING_MARK */
    char TIBETAN_SIGN_MAR_TSHES = '\u0F3F';
    /** ཀ of type OTHER_LETTER */
    char TIBETAN_LETTER_KA = '\u0F40';
    /** ཁ of type OTHER_LETTER */
    char TIBETAN_LETTER_KHA = '\u0F41';
    /** ག of type OTHER_LETTER */
    char TIBETAN_LETTER_GA = '\u0F42';
    /** གྷ of type OTHER_LETTER */
    char TIBETAN_LETTER_GHA = '\u0F43';
    /** ང of type OTHER_LETTER */
    char TIBETAN_LETTER_NGA = '\u0F44';
    /** ཅ of type OTHER_LETTER */
    char TIBETAN_LETTER_CA = '\u0F45';
    /** ཆ of type OTHER_LETTER */
    char TIBETAN_LETTER_CHA = '\u0F46';
    /** ཇ of type OTHER_LETTER */
    char TIBETAN_LETTER_JA = '\u0F47';
    /** ཉ of type OTHER_LETTER */
    char TIBETAN_LETTER_NYA = '\u0F49';
    /** ཊ of type OTHER_LETTER */
    char TIBETAN_LETTER_TTA = '\u0F4A';
    /** ཋ of type OTHER_LETTER */
    char TIBETAN_LETTER_TTHA = '\u0F4B';
    /** ཌ of type OTHER_LETTER */
    char TIBETAN_LETTER_DDA = '\u0F4C';
    /** ཌྷ of type OTHER_LETTER */
    char TIBETAN_LETTER_DDHA = '\u0F4D';
    /** ཎ of type OTHER_LETTER */
    char TIBETAN_LETTER_NNA = '\u0F4E';
    /** ཏ of type OTHER_LETTER */
    char TIBETAN_LETTER_TA = '\u0F4F';
    /** ཐ of type OTHER_LETTER */
    char TIBETAN_LETTER_THA = '\u0F50';
    /** ད of type OTHER_LETTER */
    char TIBETAN_LETTER_DA = '\u0F51';
    /** དྷ of type OTHER_LETTER */
    char TIBETAN_LETTER_DHA = '\u0F52';
    /** ན of type OTHER_LETTER */
    char TIBETAN_LETTER_NA = '\u0F53';
    /** པ of type OTHER_LETTER */
    char TIBETAN_LETTER_PA = '\u0F54';
    /** ཕ of type OTHER_LETTER */
    char TIBETAN_LETTER_PHA = '\u0F55';
    /** བ of type OTHER_LETTER */
    char TIBETAN_LETTER_BA = '\u0F56';
    /** བྷ of type OTHER_LETTER */
    char TIBETAN_LETTER_BHA = '\u0F57';
    /** མ of type OTHER_LETTER */
    char TIBETAN_LETTER_MA = '\u0F58';
    /** ཙ of type OTHER_LETTER */
    char TIBETAN_LETTER_TSA = '\u0F59';
    /** ཚ of type OTHER_LETTER */
    char TIBETAN_LETTER_TSHA = '\u0F5A';
    /** ཛ of type OTHER_LETTER */
    char TIBETAN_LETTER_DZA = '\u0F5B';
    /** ཛྷ of type OTHER_LETTER */
    char TIBETAN_LETTER_DZHA = '\u0F5C';
    /** ཝ of type OTHER_LETTER */
    char TIBETAN_LETTER_WA = '\u0F5D';
    /** ཞ of type OTHER_LETTER */
    char TIBETAN_LETTER_ZHA = '\u0F5E';
    /** ཟ of type OTHER_LETTER */
    char TIBETAN_LETTER_ZA = '\u0F5F';
    /** འ of type OTHER_LETTER */
    char TIBETAN_LETTER__A = '\u0F60';
    /** ཡ of type OTHER_LETTER */
    char TIBETAN_LETTER_YA = '\u0F61';
    /** ར of type OTHER_LETTER */
    char TIBETAN_LETTER_RA = '\u0F62';
    /** ལ of type OTHER_LETTER */
    char TIBETAN_LETTER_LA = '\u0F63';
    /** ཤ of type OTHER_LETTER */
    char TIBETAN_LETTER_SHA = '\u0F64';
    /** ཥ of type OTHER_LETTER */
    char TIBETAN_LETTER_SSA = '\u0F65';
    /** ས of type OTHER_LETTER */
    char TIBETAN_LETTER_SA = '\u0F66';
    /** ཧ of type OTHER_LETTER */
    char TIBETAN_LETTER_HA = '\u0F67';
    /** ཨ of type OTHER_LETTER */
    char TIBETAN_LETTER_A = '\u0F68';
    /** ཀྵ of type OTHER_LETTER */
    char TIBETAN_LETTER_KSSA = '\u0F69';
    /** ཪ of type OTHER_LETTER */
    char TIBETAN_LETTER_FIXED_FORM_RA = '\u0F6A';
    /** ཫ of type OTHER_LETTER */
    char TIBETAN_LETTER_KKA = '\u0F6B';
    /** ཬ of type OTHER_LETTER */
    char TIBETAN_LETTER_RRA = '\u0F6C';
    /** ཱ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_AA = '\u0F71';
    /** ི of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_I = '\u0F72';
    /** ཱི of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_II = '\u0F73';
    /** ུ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_U = '\u0F74';
    /** ཱུ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_UU = '\u0F75';
    /** ྲྀ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_VOCALIC_R = '\u0F76';
    /** ཷ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_VOCALIC_RR = '\u0F77';
    /** ླྀ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_VOCALIC_L = '\u0F78';
    /** ཹ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_VOCALIC_LL = '\u0F79';
    /** ེ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_E = '\u0F7A';
    /** ཻ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_EE = '\u0F7B';
    /** ོ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_O = '\u0F7C';
    /** ཽ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_OO = '\u0F7D';
    /** ཾ of type NON_SPACING_MARK */
    char TIBETAN_SIGN_RJES_SU_NGA_RO = '\u0F7E';
    /** ཿ of type COMBINING_SPACING_MARK */
    char TIBETAN_SIGN_RNAM_BCAD = '\u0F7F';
    /** ྀ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_REVERSED_I = '\u0F80';
    /** ཱྀ of type NON_SPACING_MARK */
    char TIBETAN_VOWEL_SIGN_REVERSED_II = '\u0F81';
    /** ྂ of type NON_SPACING_MARK */
    char TIBETAN_SIGN_NYI_ZLA_NAA_DA = '\u0F82';
    /** ྃ of type NON_SPACING_MARK */
    char TIBETAN_SIGN_SNA_LDAN = '\u0F83';
    /** ྄ of type NON_SPACING_MARK */
    char TIBETAN_MARK_HALANTA = '\u0F84';
    /** ྅ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_PALUTA = '\u0F85';
    /** ྆ of type NON_SPACING_MARK */
    char TIBETAN_SIGN_LCI_RTAGS = '\u0F86';
    /** ྇ of type NON_SPACING_MARK */
    char TIBETAN_SIGN_YANG_RTAGS = '\u0F87';
    /** ྈ of type OTHER_LETTER */
    char TIBETAN_SIGN_LCE_TSA_CAN = '\u0F88';
    /** ྉ of type OTHER_LETTER */
    char TIBETAN_SIGN_MCHU_CAN = '\u0F89';
    /** ྊ of type OTHER_LETTER */
    char TIBETAN_SIGN_GRU_CAN_RGYINGS = '\u0F8A';
    /** ྋ of type OTHER_LETTER */
    char TIBETAN_SIGN_GRU_MED_RGYINGS = '\u0F8B';
    /** ྌ of type OTHER_LETTER */
    char TIBETAN_SIGN_INVERTED_MCHU_CAN = '\u0F8C';
    /** ྍ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_SIGN_LCE_TSA_CAN = '\u0F8D';
    /** ྎ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_SIGN_MCHU_CAN = '\u0F8E';
    /** ྏ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_SIGN_INVERTED_MCHU_CAN = '\u0F8F';
    /** ྐ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_KA = '\u0F90';
    /** ྑ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_KHA = '\u0F91';
    /** ྒ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_GA = '\u0F92';
    /** ྒྷ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_GHA = '\u0F93';
    /** ྔ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_NGA = '\u0F94';
    /** ྕ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_CA = '\u0F95';
    /** ྖ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_CHA = '\u0F96';
    /** ྗ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_JA = '\u0F97';
    /** ྙ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_NYA = '\u0F99';
    /** ྚ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_TTA = '\u0F9A';
    /** ྛ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_TTHA = '\u0F9B';
    /** ྜ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_DDA = '\u0F9C';
    /** ྜྷ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_DDHA = '\u0F9D';
    /** ྞ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_NNA = '\u0F9E';
    /** ྟ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_TA = '\u0F9F';
    /** ྠ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_THA = '\u0FA0';
    /** ྡ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_DA = '\u0FA1';
    /** ྡྷ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_DHA = '\u0FA2';
    /** ྣ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_NA = '\u0FA3';
    /** ྤ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_PA = '\u0FA4';
    /** ྥ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_PHA = '\u0FA5';
    /** ྦ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_BA = '\u0FA6';
    /** ྦྷ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_BHA = '\u0FA7';
    /** ྨ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_MA = '\u0FA8';
    /** ྩ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_TSA = '\u0FA9';
    /** ྪ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_TSHA = '\u0FAA';
    /** ྫ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_DZA = '\u0FAB';
    /** ྫྷ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_DZHA = '\u0FAC';
    /** ྭ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_WA = '\u0FAD';
    /** ྮ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_ZHA = '\u0FAE';
    /** ྯ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_ZA = '\u0FAF';
    /** ྰ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER__A = '\u0FB0';
    /** ྱ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_YA = '\u0FB1';
    /** ྲ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_RA = '\u0FB2';
    /** ླ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_LA = '\u0FB3';
    /** ྴ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_SHA = '\u0FB4';
    /** ྵ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_SSA = '\u0FB5';
    /** ྶ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_SA = '\u0FB6';
    /** ྷ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_HA = '\u0FB7';
    /** ྸ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_A = '\u0FB8';
    /** ྐྵ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_KSSA = '\u0FB9';
    /** ྺ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_FIXED_FORM_WA = '\u0FBA';
    /** ྻ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_FIXED_FORM_YA = '\u0FBB';
    /** ྼ of type NON_SPACING_MARK */
    char TIBETAN_SUBJOINED_LETTER_FIXED_FORM_RA = '\u0FBC';
    /** ྾ of type OTHER_SYMBOL */
    char TIBETAN_KU_RU_KHA = '\u0FBE';
    /** ྿ of type OTHER_SYMBOL */
    char TIBETAN_KU_RU_KHA_BZHI_MIG_CAN = '\u0FBF';
    /** ࿀ of type OTHER_SYMBOL */
    char TIBETAN_CANTILLATION_SIGN_HEAVY_BEAT = '\u0FC0';
    /** ࿁ of type OTHER_SYMBOL */
    char TIBETAN_CANTILLATION_SIGN_LIGHT_BEAT = '\u0FC1';
    /** ࿂ of type OTHER_SYMBOL */
    char TIBETAN_CANTILLATION_SIGN_CANG_TE_U = '\u0FC2';
    /** ࿃ of type OTHER_SYMBOL */
    char TIBETAN_CANTILLATION_SIGN_SBUB__CHAL = '\u0FC3';
    /** ࿄ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_DRIL_BU = '\u0FC4';
    /** ࿅ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_RDO_RJE = '\u0FC5';
    /** ࿆ of type NON_SPACING_MARK */
    char TIBETAN_SYMBOL_PADMA_GDAN = '\u0FC6';
    /** ࿇ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_RDO_RJE_RGYA_GRAM = '\u0FC7';
    /** ࿈ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_PHUR_PA = '\u0FC8';
    /** ࿉ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_NOR_BU = '\u0FC9';
    /** ࿊ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_NOR_BU_NYIS__KHYIL = '\u0FCA';
    /** ࿋ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_NOR_BU_GSUM__KHYIL = '\u0FCB';
    /** ࿌ of type OTHER_SYMBOL */
    char TIBETAN_SYMBOL_NOR_BU_BZHI__KHYIL = '\u0FCC';
    /** ࿎ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_NAG_RDEL_DKAR = '\u0FCE';
    /** ࿏ of type OTHER_SYMBOL */
    char TIBETAN_SIGN_RDEL_NAG_GSUM = '\u0FCF';
    /** ࿐ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_BSKA__SHOG_GI_MGO_RGYAN = '\u0FD0';
    /** ࿑ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_MNYAM_YIG_GI_MGO_RGYAN = '\u0FD1';
    /** ࿒ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_NYIS_TSHEG = '\u0FD2';
    /** ࿓ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_INITIAL_BRDA_RNYING_YIG_MGO_MDUN_MA = '\u0FD3';
    /** ࿔ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_CLOSING_BRDA_RNYING_YIG_MGO_SGAB_MA = '\u0FD4';
    /** ࿕ of type OTHER_SYMBOL */
    char RIGHT_FACING_SVASTI_SIGN = '\u0FD5';
    /** ࿖ of type OTHER_SYMBOL */
    char LEFT_FACING_SVASTI_SIGN = '\u0FD6';
    /** ࿗ of type OTHER_SYMBOL */
    char RIGHT_FACING_SVASTI_SIGN_WITH_DOTS = '\u0FD7';
    /** ࿘ of type OTHER_SYMBOL */
    char LEFT_FACING_SVASTI_SIGN_WITH_DOTS = '\u0FD8';
    /** ࿙ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_LEADING_MCHAN_RTAGS = '\u0FD9';
    /** ࿚ of type OTHER_PUNCTUATION */
    char TIBETAN_MARK_TRAILING_MCHAN_RTAGS = '\u0FDA';
    /** ჼ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_GEORGIAN_NAR = '\u10FC';
    /** Ꭰ of type OTHER_LETTER */
    char CHEROKEE_LETTER_A = '\u13A0';
    /** Ꭱ of type OTHER_LETTER */
    char CHEROKEE_LETTER_E = '\u13A1';
    /** Ꭲ of type OTHER_LETTER */
    char CHEROKEE_LETTER_I = '\u13A2';
    /** Ꭳ of type OTHER_LETTER */
    char CHEROKEE_LETTER_O = '\u13A3';
    /** Ꭴ of type OTHER_LETTER */
    char CHEROKEE_LETTER_U = '\u13A4';
    /** Ꭵ of type OTHER_LETTER */
    char CHEROKEE_LETTER_V = '\u13A5';
    /** Ꭶ of type OTHER_LETTER */
    char CHEROKEE_LETTER_GA = '\u13A6';
    /** Ꭷ of type OTHER_LETTER */
    char CHEROKEE_LETTER_KA = '\u13A7';
    /** Ꭸ of type OTHER_LETTER */
    char CHEROKEE_LETTER_GE = '\u13A8';
    /** Ꭹ of type OTHER_LETTER */
    char CHEROKEE_LETTER_GI = '\u13A9';
    /** Ꭺ of type OTHER_LETTER */
    char CHEROKEE_LETTER_GO = '\u13AA';
    /** Ꭻ of type OTHER_LETTER */
    char CHEROKEE_LETTER_GU = '\u13AB';
    /** Ꭼ of type OTHER_LETTER */
    char CHEROKEE_LETTER_GV = '\u13AC';
    /** Ꭽ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HA = '\u13AD';
    /** Ꭾ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HE = '\u13AE';
    /** Ꭿ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HI = '\u13AF';
    /** Ꮀ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HO = '\u13B0';
    /** Ꮁ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HU = '\u13B1';
    /** Ꮂ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HV = '\u13B2';
    /** Ꮃ of type OTHER_LETTER */
    char CHEROKEE_LETTER_LA = '\u13B3';
    /** Ꮄ of type OTHER_LETTER */
    char CHEROKEE_LETTER_LE = '\u13B4';
    /** Ꮅ of type OTHER_LETTER */
    char CHEROKEE_LETTER_LI = '\u13B5';
    /** Ꮆ of type OTHER_LETTER */
    char CHEROKEE_LETTER_LO = '\u13B6';
    /** Ꮇ of type OTHER_LETTER */
    char CHEROKEE_LETTER_LU = '\u13B7';
    /** Ꮈ of type OTHER_LETTER */
    char CHEROKEE_LETTER_LV = '\u13B8';
    /** Ꮉ of type OTHER_LETTER */
    char CHEROKEE_LETTER_MA = '\u13B9';
    /** Ꮊ of type OTHER_LETTER */
    char CHEROKEE_LETTER_ME = '\u13BA';
    /** Ꮋ of type OTHER_LETTER */
    char CHEROKEE_LETTER_MI = '\u13BB';
    /** Ꮌ of type OTHER_LETTER */
    char CHEROKEE_LETTER_MO = '\u13BC';
    /** Ꮍ of type OTHER_LETTER */
    char CHEROKEE_LETTER_MU = '\u13BD';
    /** Ꮎ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NA = '\u13BE';
    /** Ꮏ of type OTHER_LETTER */
    char CHEROKEE_LETTER_HNA = '\u13BF';
    /** Ꮐ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NAH = '\u13C0';
    /** Ꮑ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NE = '\u13C1';
    /** Ꮒ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NI = '\u13C2';
    /** Ꮓ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NO = '\u13C3';
    /** Ꮔ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NU = '\u13C4';
    /** Ꮕ of type OTHER_LETTER */
    char CHEROKEE_LETTER_NV = '\u13C5';
    /** Ꮖ of type OTHER_LETTER */
    char CHEROKEE_LETTER_QUA = '\u13C6';
    /** Ꮗ of type OTHER_LETTER */
    char CHEROKEE_LETTER_QUE = '\u13C7';
    /** Ꮘ of type OTHER_LETTER */
    char CHEROKEE_LETTER_QUI = '\u13C8';
    /** Ꮙ of type OTHER_LETTER */
    char CHEROKEE_LETTER_QUO = '\u13C9';
    /** Ꮚ of type OTHER_LETTER */
    char CHEROKEE_LETTER_QUU = '\u13CA';
    /** Ꮛ of type OTHER_LETTER */
    char CHEROKEE_LETTER_QUV = '\u13CB';
    /** Ꮜ of type OTHER_LETTER */
    char CHEROKEE_LETTER_SA = '\u13CC';
    /** Ꮝ of type OTHER_LETTER */
    char CHEROKEE_LETTER_S = '\u13CD';
    /** Ꮞ of type OTHER_LETTER */
    char CHEROKEE_LETTER_SE = '\u13CE';
    /** Ꮟ of type OTHER_LETTER */
    char CHEROKEE_LETTER_SI = '\u13CF';
    /** Ꮠ of type OTHER_LETTER */
    char CHEROKEE_LETTER_SO = '\u13D0';
    /** Ꮡ of type OTHER_LETTER */
    char CHEROKEE_LETTER_SU = '\u13D1';
    /** Ꮢ of type OTHER_LETTER */
    char CHEROKEE_LETTER_SV = '\u13D2';
    /** Ꮣ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DA = '\u13D3';
    /** Ꮤ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TA = '\u13D4';
    /** Ꮥ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DE = '\u13D5';
    /** Ꮦ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TE = '\u13D6';
    /** Ꮧ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DI = '\u13D7';
    /** Ꮨ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TI = '\u13D8';
    /** Ꮩ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DO = '\u13D9';
    /** Ꮪ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DU = '\u13DA';
    /** Ꮫ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DV = '\u13DB';
    /** Ꮬ of type OTHER_LETTER */
    char CHEROKEE_LETTER_DLA = '\u13DC';
    /** Ꮭ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TLA = '\u13DD';
    /** Ꮮ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TLE = '\u13DE';
    /** Ꮯ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TLI = '\u13DF';
    /** Ꮰ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TLO = '\u13E0';
    /** Ꮱ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TLU = '\u13E1';
    /** Ꮲ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TLV = '\u13E2';
    /** Ꮳ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TSA = '\u13E3';
    /** Ꮴ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TSE = '\u13E4';
    /** Ꮵ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TSI = '\u13E5';
    /** Ꮶ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TSO = '\u13E6';
    /** Ꮷ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TSU = '\u13E7';
    /** Ꮸ of type OTHER_LETTER */
    char CHEROKEE_LETTER_TSV = '\u13E8';
    /** Ꮹ of type OTHER_LETTER */
    char CHEROKEE_LETTER_WA = '\u13E9';
    /** Ꮺ of type OTHER_LETTER */
    char CHEROKEE_LETTER_WE = '\u13EA';
    /** Ꮻ of type OTHER_LETTER */
    char CHEROKEE_LETTER_WI = '\u13EB';
    /** Ꮼ of type OTHER_LETTER */
    char CHEROKEE_LETTER_WO = '\u13EC';
    /** Ꮽ of type OTHER_LETTER */
    char CHEROKEE_LETTER_WU = '\u13ED';
    /** Ꮾ of type OTHER_LETTER */
    char CHEROKEE_LETTER_WV = '\u13EE';
    /** Ꮿ of type OTHER_LETTER */
    char CHEROKEE_LETTER_YA = '\u13EF';
    /** Ᏸ of type OTHER_LETTER */
    char CHEROKEE_LETTER_YE = '\u13F0';
    /** Ᏹ of type OTHER_LETTER */
    char CHEROKEE_LETTER_YI = '\u13F1';
    /** Ᏺ of type OTHER_LETTER */
    char CHEROKEE_LETTER_YO = '\u13F2';
    /** Ᏻ of type OTHER_LETTER */
    char CHEROKEE_LETTER_YU = '\u13F3';
    /** Ᏼ of type OTHER_LETTER */
    char CHEROKEE_LETTER_YV = '\u13F4';
    /** ᐀ of type DASH_PUNCTUATION */
    char CANADIAN_SYLLABICS_HYPHEN = '\u1400';
    /** ᐁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_E = '\u1401';
    /** ᐂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AAI = '\u1402';
    /** ᐃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_I = '\u1403';
    /** ᐄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_II = '\u1404';
    /** ᐅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_O = '\u1405';
    /** ᐆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OO = '\u1406';
    /** ᐇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_OO = '\u1407';
    /** ᐈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_EE = '\u1408';
    /** ᐉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_I = '\u1409';
    /** ᐊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_A = '\u140A';
    /** ᐋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AA = '\u140B';
    /** ᐌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WE = '\u140C';
    /** ᐍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WE = '\u140D';
    /** ᐎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WI = '\u140E';
    /** ᐏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WI = '\u140F';
    /** ᐐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WII = '\u1410';
    /** ᐑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WII = '\u1411';
    /** ᐒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WO = '\u1412';
    /** ᐓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WO = '\u1413';
    /** ᐔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOO = '\u1414';
    /** ᐕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WOO = '\u1415';
    /** ᐖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_WOO = '\u1416';
    /** ᐗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WA = '\u1417';
    /** ᐘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WA = '\u1418';
    /** ᐙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WAA = '\u1419';
    /** ᐚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_WAA = '\u141A';
    /** ᐛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_WAA = '\u141B';
    /** ᐜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AI = '\u141C';
    /** ᐝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_W = '\u141D';
    /** ᐞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_GLOTTAL_STOP = '\u141E';
    /** ᐟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_ACUTE = '\u141F';
    /** ᐠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_GRAVE = '\u1420';
    /** ᐡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_BOTTOM_HALF_RING = '\u1421';
    /** ᐢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_TOP_HALF_RING = '\u1422';
    /** ᐣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_RIGHT_HALF_RING = '\u1423';
    /** ᐤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_RING = '\u1424';
    /** ᐥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_DOUBLE_ACUTE = '\u1425';
    /** ᐦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_DOUBLE_SHORT_VERTICAL_STROKES = '\u1426';
    /** ᐧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_MIDDLE_DOT = '\u1427';
    /** ᐨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_SHORT_HORIZONTAL_STROKE = '\u1428';
    /** ᐩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_PLUS = '\u1429';
    /** ᐪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_DOWN_TACK = '\u142A';
    /** ᐫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_EN = '\u142B';
    /** ᐬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_IN = '\u142C';
    /** ᐭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_ON = '\u142D';
    /** ᐮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AN = '\u142E';
    /** ᐯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PE = '\u142F';
    /** ᐰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PAAI = '\u1430';
    /** ᐱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PI = '\u1431';
    /** ᐲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PII = '\u1432';
    /** ᐳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PO = '\u1433';
    /** ᐴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_POO = '\u1434';
    /** ᐵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_POO = '\u1435';
    /** ᐶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HEE = '\u1436';
    /** ᐷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HI = '\u1437';
    /** ᐸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PA = '\u1438';
    /** ᐹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PAA = '\u1439';
    /** ᐺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWE = '\u143A';
    /** ᐻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWE = '\u143B';
    /** ᐼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWI = '\u143C';
    /** ᐽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWI = '\u143D';
    /** ᐾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWII = '\u143E';
    /** ᐿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWII = '\u143F';
    /** ᑀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWO = '\u1440';
    /** ᑁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWO = '\u1441';
    /** ᑂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWOO = '\u1442';
    /** ᑃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWOO = '\u1443';
    /** ᑄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWA = '\u1444';
    /** ᑅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWA = '\u1445';
    /** ᑆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWAA = '\u1446';
    /** ᑇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_PWAA = '\u1447';
    /** ᑈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_PWAA = '\u1448';
    /** ᑉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_P = '\u1449';
    /** ᑊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_P = '\u144A';
    /** ᑋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_H = '\u144B';
    /** ᑌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TE = '\u144C';
    /** ᑍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TAAI = '\u144D';
    /** ᑎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TI = '\u144E';
    /** ᑏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TII = '\u144F';
    /** ᑐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TO = '\u1450';
    /** ᑑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TOO = '\u1451';
    /** ᑒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_TOO = '\u1452';
    /** ᑓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DEE = '\u1453';
    /** ᑔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DI = '\u1454';
    /** ᑕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TA = '\u1455';
    /** ᑖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TAA = '\u1456';
    /** ᑗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWE = '\u1457';
    /** ᑘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWE = '\u1458';
    /** ᑙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWI = '\u1459';
    /** ᑚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWI = '\u145A';
    /** ᑛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWII = '\u145B';
    /** ᑜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWII = '\u145C';
    /** ᑝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWO = '\u145D';
    /** ᑞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWO = '\u145E';
    /** ᑟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWOO = '\u145F';
    /** ᑠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWOO = '\u1460';
    /** ᑡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWA = '\u1461';
    /** ᑢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWA = '\u1462';
    /** ᑣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TWAA = '\u1463';
    /** ᑤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_TWAA = '\u1464';
    /** ᑥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_TWAA = '\u1465';
    /** ᑦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_T = '\u1466';
    /** ᑧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTE = '\u1467';
    /** ᑨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTI = '\u1468';
    /** ᑩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTO = '\u1469';
    /** ᑪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTA = '\u146A';
    /** ᑫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KE = '\u146B';
    /** ᑬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KAAI = '\u146C';
    /** ᑭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KI = '\u146D';
    /** ᑮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KII = '\u146E';
    /** ᑯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KO = '\u146F';
    /** ᑰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KOO = '\u1470';
    /** ᑱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_KOO = '\u1471';
    /** ᑲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KA = '\u1472';
    /** ᑳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KAA = '\u1473';
    /** ᑴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWE = '\u1474';
    /** ᑵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWE = '\u1475';
    /** ᑶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWI = '\u1476';
    /** ᑷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWI = '\u1477';
    /** ᑸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWII = '\u1478';
    /** ᑹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWII = '\u1479';
    /** ᑺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWO = '\u147A';
    /** ᑻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWO = '\u147B';
    /** ᑼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWOO = '\u147C';
    /** ᑽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWOO = '\u147D';
    /** ᑾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWA = '\u147E';
    /** ᑿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWA = '\u147F';
    /** ᒀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWAA = '\u1480';
    /** ᒁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_KWAA = '\u1481';
    /** ᒂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_KWAA = '\u1482';
    /** ᒃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_K = '\u1483';
    /** ᒄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KW = '\u1484';
    /** ᒅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SOUTH_SLAVEY_KEH = '\u1485';
    /** ᒆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SOUTH_SLAVEY_KIH = '\u1486';
    /** ᒇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SOUTH_SLAVEY_KOH = '\u1487';
    /** ᒈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SOUTH_SLAVEY_KAH = '\u1488';
    /** ᒉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CE = '\u1489';
    /** ᒊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CAAI = '\u148A';
    /** ᒋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CI = '\u148B';
    /** ᒌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CII = '\u148C';
    /** ᒍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CO = '\u148D';
    /** ᒎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_COO = '\u148E';
    /** ᒏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_COO = '\u148F';
    /** ᒐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CA = '\u1490';
    /** ᒑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CAA = '\u1491';
    /** ᒒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWE = '\u1492';
    /** ᒓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWE = '\u1493';
    /** ᒔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWI = '\u1494';
    /** ᒕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWI = '\u1495';
    /** ᒖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWII = '\u1496';
    /** ᒗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWII = '\u1497';
    /** ᒘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWO = '\u1498';
    /** ᒙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWO = '\u1499';
    /** ᒚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWOO = '\u149A';
    /** ᒛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWOO = '\u149B';
    /** ᒜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWA = '\u149C';
    /** ᒝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWA = '\u149D';
    /** ᒞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CWAA = '\u149E';
    /** ᒟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_CWAA = '\u149F';
    /** ᒠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_CWAA = '\u14A0';
    /** ᒡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_C = '\u14A1';
    /** ᒢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_TH = '\u14A2';
    /** ᒣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_ME = '\u14A3';
    /** ᒤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MAAI = '\u14A4';
    /** ᒥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MI = '\u14A5';
    /** ᒦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MII = '\u14A6';
    /** ᒧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MO = '\u14A7';
    /** ᒨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MOO = '\u14A8';
    /** ᒩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_MOO = '\u14A9';
    /** ᒪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MA = '\u14AA';
    /** ᒫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MAA = '\u14AB';
    /** ᒬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWE = '\u14AC';
    /** ᒭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWE = '\u14AD';
    /** ᒮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWI = '\u14AE';
    /** ᒯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWI = '\u14AF';
    /** ᒰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWII = '\u14B0';
    /** ᒱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWII = '\u14B1';
    /** ᒲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWO = '\u14B2';
    /** ᒳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWO = '\u14B3';
    /** ᒴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWOO = '\u14B4';
    /** ᒵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWOO = '\u14B5';
    /** ᒶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWA = '\u14B6';
    /** ᒷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWA = '\u14B7';
    /** ᒸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MWAA = '\u14B8';
    /** ᒹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_MWAA = '\u14B9';
    /** ᒺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_MWAA = '\u14BA';
    /** ᒻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_M = '\u14BB';
    /** ᒼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_M = '\u14BC';
    /** ᒽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MH = '\u14BD';
    /** ᒾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_ATHAPASCAN_M = '\u14BE';
    /** ᒿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_M = '\u14BF';
    /** ᓀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NE = '\u14C0';
    /** ᓁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NAAI = '\u14C1';
    /** ᓂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NI = '\u14C2';
    /** ᓃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NII = '\u14C3';
    /** ᓄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NO = '\u14C4';
    /** ᓅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NOO = '\u14C5';
    /** ᓆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_NOO = '\u14C6';
    /** ᓇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NA = '\u14C7';
    /** ᓈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NAA = '\u14C8';
    /** ᓉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWE = '\u14C9';
    /** ᓊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_NWE = '\u14CA';
    /** ᓋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWA = '\u14CB';
    /** ᓌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_NWA = '\u14CC';
    /** ᓍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWAA = '\u14CD';
    /** ᓎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_NWAA = '\u14CE';
    /** ᓏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_NWAA = '\u14CF';
    /** ᓐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_N = '\u14D0';
    /** ᓑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NG = '\u14D1';
    /** ᓒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NH = '\u14D2';
    /** ᓓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LE = '\u14D3';
    /** ᓔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LAAI = '\u14D4';
    /** ᓕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LI = '\u14D5';
    /** ᓖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LII = '\u14D6';
    /** ᓗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LO = '\u14D7';
    /** ᓘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LOO = '\u14D8';
    /** ᓙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_LOO = '\u14D9';
    /** ᓚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LA = '\u14DA';
    /** ᓛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LAA = '\u14DB';
    /** ᓜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWE = '\u14DC';
    /** ᓝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWE = '\u14DD';
    /** ᓞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWI = '\u14DE';
    /** ᓟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWI = '\u14DF';
    /** ᓠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWII = '\u14E0';
    /** ᓡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWII = '\u14E1';
    /** ᓢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWO = '\u14E2';
    /** ᓣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWO = '\u14E3';
    /** ᓤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWOO = '\u14E4';
    /** ᓥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWOO = '\u14E5';
    /** ᓦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWA = '\u14E6';
    /** ᓧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWA = '\u14E7';
    /** ᓨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LWAA = '\u14E8';
    /** ᓩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LWAA = '\u14E9';
    /** ᓪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_L = '\u14EA';
    /** ᓫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_L = '\u14EB';
    /** ᓬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MEDIAL_L = '\u14EC';
    /** ᓭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SE = '\u14ED';
    /** ᓮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAAI = '\u14EE';
    /** ᓯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SI = '\u14EF';
    /** ᓰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SII = '\u14F0';
    /** ᓱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SO = '\u14F1';
    /** ᓲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SOO = '\u14F2';
    /** ᓳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_SOO = '\u14F3';
    /** ᓴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SA = '\u14F4';
    /** ᓵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAA = '\u14F5';
    /** ᓶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWE = '\u14F6';
    /** ᓷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWE = '\u14F7';
    /** ᓸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWI = '\u14F8';
    /** ᓹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWI = '\u14F9';
    /** ᓺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWII = '\u14FA';
    /** ᓻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWII = '\u14FB';
    /** ᓼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWO = '\u14FC';
    /** ᓽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWO = '\u14FD';
    /** ᓾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWOO = '\u14FE';
    /** ᓿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWOO = '\u14FF';
    /** ᔀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWA = '\u1500';
    /** ᔁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWA = '\u1501';
    /** ᔂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SWAA = '\u1502';
    /** ᔃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SWAA = '\u1503';
    /** ᔄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_SWAA = '\u1504';
    /** ᔅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_S = '\u1505';
    /** ᔆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_ATHAPASCAN_S = '\u1506';
    /** ᔇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SW = '\u1507';
    /** ᔈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_S = '\u1508';
    /** ᔉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MOOSE_CREE_SK = '\u1509';
    /** ᔊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_SKW = '\u150A';
    /** ᔋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_S_W = '\u150B';
    /** ᔌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_SPWA = '\u150C';
    /** ᔍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_STWA = '\u150D';
    /** ᔎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_SKWA = '\u150E';
    /** ᔏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_SCWA = '\u150F';
    /** ᔐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHE = '\u1510';
    /** ᔑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHI = '\u1511';
    /** ᔒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHII = '\u1512';
    /** ᔓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHO = '\u1513';
    /** ᔔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHOO = '\u1514';
    /** ᔕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHA = '\u1515';
    /** ᔖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHAA = '\u1516';
    /** ᔗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWE = '\u1517';
    /** ᔘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWE = '\u1518';
    /** ᔙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWI = '\u1519';
    /** ᔚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWI = '\u151A';
    /** ᔛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWII = '\u151B';
    /** ᔜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWII = '\u151C';
    /** ᔝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWO = '\u151D';
    /** ᔞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWO = '\u151E';
    /** ᔟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWOO = '\u151F';
    /** ᔠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWOO = '\u1520';
    /** ᔡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWA = '\u1521';
    /** ᔢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWA = '\u1522';
    /** ᔣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWAA = '\u1523';
    /** ᔤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_SHWAA = '\u1524';
    /** ᔥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SH = '\u1525';
    /** ᔦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YE = '\u1526';
    /** ᔧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YAAI = '\u1527';
    /** ᔨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YI = '\u1528';
    /** ᔩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YII = '\u1529';
    /** ᔪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YO = '\u152A';
    /** ᔫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YOO = '\u152B';
    /** ᔬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y_CREE_YOO = '\u152C';
    /** ᔭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YA = '\u152D';
    /** ᔮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YAA = '\u152E';
    /** ᔯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWE = '\u152F';
    /** ᔰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWE = '\u1530';
    /** ᔱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWI = '\u1531';
    /** ᔲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWI = '\u1532';
    /** ᔳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWII = '\u1533';
    /** ᔴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWII = '\u1534';
    /** ᔵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWO = '\u1535';
    /** ᔶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWO = '\u1536';
    /** ᔷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWOO = '\u1537';
    /** ᔸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWOO = '\u1538';
    /** ᔹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWA = '\u1539';
    /** ᔺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWA = '\u153A';
    /** ᔻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YWAA = '\u153B';
    /** ᔼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_YWAA = '\u153C';
    /** ᔽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NASKAPI_YWAA = '\u153D';
    /** ᔾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Y = '\u153E';
    /** ᔿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BIBLE_CREE_Y = '\u153F';
    /** ᕀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_Y = '\u1540';
    /** ᕁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_YI = '\u1541';
    /** ᕂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RE = '\u1542';
    /** ᕃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_R_CREE_RE = '\u1543';
    /** ᕄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LE = '\u1544';
    /** ᕅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RAAI = '\u1545';
    /** ᕆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RI = '\u1546';
    /** ᕇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RII = '\u1547';
    /** ᕈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RO = '\u1548';
    /** ᕉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_ROO = '\u1549';
    /** ᕊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LO = '\u154A';
    /** ᕋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RA = '\u154B';
    /** ᕌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RAA = '\u154C';
    /** ᕍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LA = '\u154D';
    /** ᕎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWAA = '\u154E';
    /** ᕏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_RWAA = '\u154F';
    /** ᕐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_R = '\u1550';
    /** ᕑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_R = '\u1551';
    /** ᕒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MEDIAL_R = '\u1552';
    /** ᕓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FE = '\u1553';
    /** ᕔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FAAI = '\u1554';
    /** ᕕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FI = '\u1555';
    /** ᕖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FII = '\u1556';
    /** ᕗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FO = '\u1557';
    /** ᕘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FOO = '\u1558';
    /** ᕙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FA = '\u1559';
    /** ᕚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FAA = '\u155A';
    /** ᕛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FWAA = '\u155B';
    /** ᕜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_FWAA = '\u155C';
    /** ᕝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_F = '\u155D';
    /** ᕞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THE = '\u155E';
    /** ᕟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_N_CREE_THE = '\u155F';
    /** ᕠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THI = '\u1560';
    /** ᕡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_N_CREE_THI = '\u1561';
    /** ᕢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THII = '\u1562';
    /** ᕣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_N_CREE_THII = '\u1563';
    /** ᕤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THO = '\u1564';
    /** ᕥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THOO = '\u1565';
    /** ᕦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THA = '\u1566';
    /** ᕧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THAA = '\u1567';
    /** ᕨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THWAA = '\u1568';
    /** ᕩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_THWAA = '\u1569';
    /** ᕪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH = '\u156A';
    /** ᕫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHE = '\u156B';
    /** ᕬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHI = '\u156C';
    /** ᕭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHO = '\u156D';
    /** ᕮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHA = '\u156E';
    /** ᕯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTH = '\u156F';
    /** ᕰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TYE = '\u1570';
    /** ᕱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TYI = '\u1571';
    /** ᕲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TYO = '\u1572';
    /** ᕳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TYA = '\u1573';
    /** ᕴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HE = '\u1574';
    /** ᕵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HI = '\u1575';
    /** ᕶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HII = '\u1576';
    /** ᕷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HO = '\u1577';
    /** ᕸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HOO = '\u1578';
    /** ᕹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HA = '\u1579';
    /** ᕺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_HAA = '\u157A';
    /** ᕻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVIK_H = '\u157B';
    /** ᕼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NUNAVUT_H = '\u157C';
    /** ᕽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_HK = '\u157D';
    /** ᕾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QAAI = '\u157E';
    /** ᕿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QI = '\u157F';
    /** ᖀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QII = '\u1580';
    /** ᖁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QO = '\u1581';
    /** ᖂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QOO = '\u1582';
    /** ᖃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QA = '\u1583';
    /** ᖄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QAA = '\u1584';
    /** ᖅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_Q = '\u1585';
    /** ᖆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TLHE = '\u1586';
    /** ᖇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TLHI = '\u1587';
    /** ᖈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TLHO = '\u1588';
    /** ᖉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TLHA = '\u1589';
    /** ᖊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_RE = '\u158A';
    /** ᖋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_RI = '\u158B';
    /** ᖌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_RO = '\u158C';
    /** ᖍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_RA = '\u158D';
    /** ᖎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGAAI = '\u158E';
    /** ᖏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGI = '\u158F';
    /** ᖐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGII = '\u1590';
    /** ᖑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGO = '\u1591';
    /** ᖒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGOO = '\u1592';
    /** ᖓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGA = '\u1593';
    /** ᖔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGAA = '\u1594';
    /** ᖕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NG = '\u1595';
    /** ᖖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNG = '\u1596';
    /** ᖗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_SHE = '\u1597';
    /** ᖘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_SHI = '\u1598';
    /** ᖙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_SHO = '\u1599';
    /** ᖚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_SHA = '\u159A';
    /** ᖛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THE = '\u159B';
    /** ᖜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THI = '\u159C';
    /** ᖝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THO = '\u159D';
    /** ᖞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THA = '\u159E';
    /** ᖟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_TH = '\u159F';
    /** ᖠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LHI = '\u15A0';
    /** ᖡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LHII = '\u15A1';
    /** ᖢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LHO = '\u15A2';
    /** ᖣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LHOO = '\u15A3';
    /** ᖤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LHA = '\u15A4';
    /** ᖥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LHAA = '\u15A5';
    /** ᖦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LH = '\u15A6';
    /** ᖧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THE = '\u15A7';
    /** ᖨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THI = '\u15A8';
    /** ᖩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THII = '\u15A9';
    /** ᖪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THO = '\u15AA';
    /** ᖫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THOO = '\u15AB';
    /** ᖬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THA = '\u15AC';
    /** ᖭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_THAA = '\u15AD';
    /** ᖮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TH_CREE_TH = '\u15AE';
    /** ᖯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AIVILIK_B = '\u15AF';
    /** ᖰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_E = '\u15B0';
    /** ᖱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_I = '\u15B1';
    /** ᖲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_O = '\u15B2';
    /** ᖳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_A = '\u15B3';
    /** ᖴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_WE = '\u15B4';
    /** ᖵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_WI = '\u15B5';
    /** ᖶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_WO = '\u15B6';
    /** ᖷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_WA = '\u15B7';
    /** ᖸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_NE = '\u15B8';
    /** ᖹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_NI = '\u15B9';
    /** ᖺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_NO = '\u15BA';
    /** ᖻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_NA = '\u15BB';
    /** ᖼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_KE = '\u15BC';
    /** ᖽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_KI = '\u15BD';
    /** ᖾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_KO = '\u15BE';
    /** ᖿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_KA = '\u15BF';
    /** ᗀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_HE = '\u15C0';
    /** ᗁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_HI = '\u15C1';
    /** ᗂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_HO = '\u15C2';
    /** ᗃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_HA = '\u15C3';
    /** ᗄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GHU = '\u15C4';
    /** ᗅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GHO = '\u15C5';
    /** ᗆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GHE = '\u15C6';
    /** ᗇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GHEE = '\u15C7';
    /** ᗈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GHI = '\u15C8';
    /** ᗉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GHA = '\u15C9';
    /** ᗊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_RU = '\u15CA';
    /** ᗋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_RO = '\u15CB';
    /** ᗌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_RE = '\u15CC';
    /** ᗍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_REE = '\u15CD';
    /** ᗎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_RI = '\u15CE';
    /** ᗏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_RA = '\u15CF';
    /** ᗐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_WU = '\u15D0';
    /** ᗑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_WO = '\u15D1';
    /** ᗒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_WE = '\u15D2';
    /** ᗓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_WEE = '\u15D3';
    /** ᗔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_WI = '\u15D4';
    /** ᗕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_WA = '\u15D5';
    /** ᗖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HWU = '\u15D6';
    /** ᗗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HWO = '\u15D7';
    /** ᗘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HWE = '\u15D8';
    /** ᗙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HWEE = '\u15D9';
    /** ᗚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HWI = '\u15DA';
    /** ᗛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_HWA = '\u15DB';
    /** ᗜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_THU = '\u15DC';
    /** ᗝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_THO = '\u15DD';
    /** ᗞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_THE = '\u15DE';
    /** ᗟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_THEE = '\u15DF';
    /** ᗠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_THI = '\u15E0';
    /** ᗡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_THA = '\u15E1';
    /** ᗢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTU = '\u15E2';
    /** ᗣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTO = '\u15E3';
    /** ᗤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTE = '\u15E4';
    /** ᗥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTEE = '\u15E5';
    /** ᗦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTI = '\u15E6';
    /** ᗧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTA = '\u15E7';
    /** ᗨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_PU = '\u15E8';
    /** ᗩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_PO = '\u15E9';
    /** ᗪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_PE = '\u15EA';
    /** ᗫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_PEE = '\u15EB';
    /** ᗬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_PI = '\u15EC';
    /** ᗭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_PA = '\u15ED';
    /** ᗮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_P = '\u15EE';
    /** ᗯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GU = '\u15EF';
    /** ᗰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GO = '\u15F0';
    /** ᗱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GE = '\u15F1';
    /** ᗲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GEE = '\u15F2';
    /** ᗳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GI = '\u15F3';
    /** ᗴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GA = '\u15F4';
    /** ᗵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KHU = '\u15F5';
    /** ᗶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KHO = '\u15F6';
    /** ᗷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KHE = '\u15F7';
    /** ᗸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KHEE = '\u15F8';
    /** ᗹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KHI = '\u15F9';
    /** ᗺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KHA = '\u15FA';
    /** ᗻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KKU = '\u15FB';
    /** ᗼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KKO = '\u15FC';
    /** ᗽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KKE = '\u15FD';
    /** ᗾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KKEE = '\u15FE';
    /** ᗿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KKI = '\u15FF';
    /** ᘀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KKA = '\u1600';
    /** ᘁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_KK = '\u1601';
    /** ᘂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NU = '\u1602';
    /** ᘃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NO = '\u1603';
    /** ᘄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NE = '\u1604';
    /** ᘅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NEE = '\u1605';
    /** ᘆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NI = '\u1606';
    /** ᘇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_NA = '\u1607';
    /** ᘈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_MU = '\u1608';
    /** ᘉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_MO = '\u1609';
    /** ᘊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ME = '\u160A';
    /** ᘋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_MEE = '\u160B';
    /** ᘌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_MI = '\u160C';
    /** ᘍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_MA = '\u160D';
    /** ᘎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_YU = '\u160E';
    /** ᘏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_YO = '\u160F';
    /** ᘐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_YE = '\u1610';
    /** ᘑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_YEE = '\u1611';
    /** ᘒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_YI = '\u1612';
    /** ᘓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_YA = '\u1613';
    /** ᘔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JU = '\u1614';
    /** ᘕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_JU = '\u1615';
    /** ᘖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JO = '\u1616';
    /** ᘗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JE = '\u1617';
    /** ᘘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JEE = '\u1618';
    /** ᘙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JI = '\u1619';
    /** ᘚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_JI = '\u161A';
    /** ᘛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JA = '\u161B';
    /** ᘜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JJU = '\u161C';
    /** ᘝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JJO = '\u161D';
    /** ᘞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JJE = '\u161E';
    /** ᘟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JJEE = '\u161F';
    /** ᘠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JJI = '\u1620';
    /** ᘡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JJA = '\u1621';
    /** ᘢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LU = '\u1622';
    /** ᘣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LO = '\u1623';
    /** ᘤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LE = '\u1624';
    /** ᘥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LEE = '\u1625';
    /** ᘦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LI = '\u1626';
    /** ᘧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LA = '\u1627';
    /** ᘨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DLU = '\u1628';
    /** ᘩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DLO = '\u1629';
    /** ᘪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DLE = '\u162A';
    /** ᘫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DLEE = '\u162B';
    /** ᘬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DLI = '\u162C';
    /** ᘭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DLA = '\u162D';
    /** ᘮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LHU = '\u162E';
    /** ᘯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LHO = '\u162F';
    /** ᘰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LHE = '\u1630';
    /** ᘱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LHEE = '\u1631';
    /** ᘲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LHI = '\u1632';
    /** ᘳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_LHA = '\u1633';
    /** ᘴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLHU = '\u1634';
    /** ᘵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLHO = '\u1635';
    /** ᘶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLHE = '\u1636';
    /** ᘷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLHEE = '\u1637';
    /** ᘸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLHI = '\u1638';
    /** ᘹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLHA = '\u1639';
    /** ᘺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLU = '\u163A';
    /** ᘻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLO = '\u163B';
    /** ᘼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLE = '\u163C';
    /** ᘽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLEE = '\u163D';
    /** ᘾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLI = '\u163E';
    /** ᘿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TLA = '\u163F';
    /** ᙀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ZU = '\u1640';
    /** ᙁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ZO = '\u1641';
    /** ᙂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ZE = '\u1642';
    /** ᙃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ZEE = '\u1643';
    /** ᙄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ZI = '\u1644';
    /** ᙅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_ZA = '\u1645';
    /** ᙆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_Z = '\u1646';
    /** ᙇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_INITIAL_Z = '\u1647';
    /** ᙈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DZU = '\u1648';
    /** ᙉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DZO = '\u1649';
    /** ᙊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DZE = '\u164A';
    /** ᙋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DZEE = '\u164B';
    /** ᙌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DZI = '\u164C';
    /** ᙍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DZA = '\u164D';
    /** ᙎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SU = '\u164E';
    /** ᙏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SO = '\u164F';
    /** ᙐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SE = '\u1650';
    /** ᙑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SEE = '\u1651';
    /** ᙒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SI = '\u1652';
    /** ᙓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SA = '\u1653';
    /** ᙔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SHU = '\u1654';
    /** ᙕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SHO = '\u1655';
    /** ᙖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SHE = '\u1656';
    /** ᙗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SHEE = '\u1657';
    /** ᙘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SHI = '\u1658';
    /** ᙙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SHA = '\u1659';
    /** ᙚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_SH = '\u165A';
    /** ᙛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TSU = '\u165B';
    /** ᙜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TSO = '\u165C';
    /** ᙝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TSE = '\u165D';
    /** ᙞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TSEE = '\u165E';
    /** ᙟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TSI = '\u165F';
    /** ᙠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TSA = '\u1660';
    /** ᙡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_CHU = '\u1661';
    /** ᙢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_CHO = '\u1662';
    /** ᙣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_CHE = '\u1663';
    /** ᙤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_CHEE = '\u1664';
    /** ᙥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_CHI = '\u1665';
    /** ᙦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_CHA = '\u1666';
    /** ᙧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTSU = '\u1667';
    /** ᙨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTSO = '\u1668';
    /** ᙩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTSE = '\u1669';
    /** ᙪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTSEE = '\u166A';
    /** ᙫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTSI = '\u166B';
    /** ᙬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_TTSA = '\u166C';
    /** ᙭ of type OTHER_PUNCTUATION */
    char CANADIAN_SYLLABICS_CHI_SIGN = '\u166D';
    /** ᙮ of type OTHER_PUNCTUATION */
    char CANADIAN_SYLLABICS_FULL_STOP = '\u166E';
    /** ᙯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_QAI = '\u166F';
    /** ᙰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NGAI = '\u1670';
    /** ᙱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNGI = '\u1671';
    /** ᙲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNGII = '\u1672';
    /** ᙳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNGO = '\u1673';
    /** ᙴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNGOO = '\u1674';
    /** ᙵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNGA = '\u1675';
    /** ᙶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NNGAA = '\u1676';
    /** ᙷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWEE = '\u1677';
    /** ᙸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWI = '\u1678';
    /** ᙹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWII = '\u1679';
    /** ᙺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWO = '\u167A';
    /** ᙻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWOO = '\u167B';
    /** ᙼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWA = '\u167C';
    /** ᙽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_THWAA = '\u167D';
    /** ᙾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WOODS_CREE_FINAL_TH = '\u167E';
    /** ᙿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BLACKFOOT_W = '\u167F';
    /**   of type SPACE_SEPARATOR */
    char OGHAM_SPACE_MARK = '\u1680';
    /** ᚁ of type OTHER_LETTER */
    char OGHAM_LETTER_BEITH = '\u1681';
    /** ᚂ of type OTHER_LETTER */
    char OGHAM_LETTER_LUIS = '\u1682';
    /** ᚃ of type OTHER_LETTER */
    char OGHAM_LETTER_FEARN = '\u1683';
    /** ᚄ of type OTHER_LETTER */
    char OGHAM_LETTER_SAIL = '\u1684';
    /** ᚅ of type OTHER_LETTER */
    char OGHAM_LETTER_NION = '\u1685';
    /** ᚆ of type OTHER_LETTER */
    char OGHAM_LETTER_UATH = '\u1686';
    /** ᚇ of type OTHER_LETTER */
    char OGHAM_LETTER_DAIR = '\u1687';
    /** ᚈ of type OTHER_LETTER */
    char OGHAM_LETTER_TINNE = '\u1688';
    /** ᚉ of type OTHER_LETTER */
    char OGHAM_LETTER_COLL = '\u1689';
    /** ᚊ of type OTHER_LETTER */
    char OGHAM_LETTER_CEIRT = '\u168A';
    /** ᚋ of type OTHER_LETTER */
    char OGHAM_LETTER_MUIN = '\u168B';
    /** ᚌ of type OTHER_LETTER */
    char OGHAM_LETTER_GORT = '\u168C';
    /** ᚍ of type OTHER_LETTER */
    char OGHAM_LETTER_NGEADAL = '\u168D';
    /** ᚎ of type OTHER_LETTER */
    char OGHAM_LETTER_STRAIF = '\u168E';
    /** ᚏ of type OTHER_LETTER */
    char OGHAM_LETTER_RUIS = '\u168F';
    /** ᚐ of type OTHER_LETTER */
    char OGHAM_LETTER_AILM = '\u1690';
    /** ᚑ of type OTHER_LETTER */
    char OGHAM_LETTER_ONN = '\u1691';
    /** ᚒ of type OTHER_LETTER */
    char OGHAM_LETTER_UR = '\u1692';
    /** ᚓ of type OTHER_LETTER */
    char OGHAM_LETTER_EADHADH = '\u1693';
    /** ᚔ of type OTHER_LETTER */
    char OGHAM_LETTER_IODHADH = '\u1694';
    /** ᚕ of type OTHER_LETTER */
    char OGHAM_LETTER_EABHADH = '\u1695';
    /** ᚖ of type OTHER_LETTER */
    char OGHAM_LETTER_OR = '\u1696';
    /** ᚗ of type OTHER_LETTER */
    char OGHAM_LETTER_UILLEANN = '\u1697';
    /** ᚘ of type OTHER_LETTER */
    char OGHAM_LETTER_IFIN = '\u1698';
    /** ᚙ of type OTHER_LETTER */
    char OGHAM_LETTER_EAMHANCHOLL = '\u1699';
    /** ᚚ of type OTHER_LETTER */
    char OGHAM_LETTER_PEITH = '\u169A';
    /** ᚛ of type START_PUNCTUATION */
    char OGHAM_FEATHER_MARK = '\u169B';
    /** ᚜ of type END_PUNCTUATION */
    char OGHAM_REVERSED_FEATHER_MARK = '\u169C';
    /** ᚠ of type OTHER_LETTER */
    char RUNIC_LETTER_FEHU_FEOH_FE_F = '\u16A0';
    /** ᚡ of type OTHER_LETTER */
    char RUNIC_LETTER_V = '\u16A1';
    /** ᚢ of type OTHER_LETTER */
    char RUNIC_LETTER_URUZ_UR_U = '\u16A2';
    /** ᚣ of type OTHER_LETTER */
    char RUNIC_LETTER_YR = '\u16A3';
    /** ᚤ of type OTHER_LETTER */
    char RUNIC_LETTER_Y = '\u16A4';
    /** ᚥ of type OTHER_LETTER */
    char RUNIC_LETTER_W = '\u16A5';
    /** ᚦ of type OTHER_LETTER */
    char RUNIC_LETTER_THURISAZ_THURS_THORN = '\u16A6';
    /** ᚧ of type OTHER_LETTER */
    char RUNIC_LETTER_ETH = '\u16A7';
    /** ᚨ of type OTHER_LETTER */
    char RUNIC_LETTER_ANSUZ_A = '\u16A8';
    /** ᚩ of type OTHER_LETTER */
    char RUNIC_LETTER_OS_O = '\u16A9';
    /** ᚪ of type OTHER_LETTER */
    char RUNIC_LETTER_AC_A = '\u16AA';
    /** ᚫ of type OTHER_LETTER */
    char RUNIC_LETTER_AESC = '\u16AB';
    /** ᚬ of type OTHER_LETTER */
    char RUNIC_LETTER_LONG_BRANCH_OSS_O = '\u16AC';
    /** ᚭ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_OSS_O = '\u16AD';
    /** ᚮ of type OTHER_LETTER */
    char RUNIC_LETTER_O = '\u16AE';
    /** ᚯ of type OTHER_LETTER */
    char RUNIC_LETTER_OE = '\u16AF';
    /** ᚰ of type OTHER_LETTER */
    char RUNIC_LETTER_ON = '\u16B0';
    /** ᚱ of type OTHER_LETTER */
    char RUNIC_LETTER_RAIDO_RAD_REID_R = '\u16B1';
    /** ᚲ of type OTHER_LETTER */
    char RUNIC_LETTER_KAUNA = '\u16B2';
    /** ᚳ of type OTHER_LETTER */
    char RUNIC_LETTER_CEN = '\u16B3';
    /** ᚴ of type OTHER_LETTER */
    char RUNIC_LETTER_KAUN_K = '\u16B4';
    /** ᚵ of type OTHER_LETTER */
    char RUNIC_LETTER_G = '\u16B5';
    /** ᚶ of type OTHER_LETTER */
    char RUNIC_LETTER_ENG = '\u16B6';
    /** ᚷ of type OTHER_LETTER */
    char RUNIC_LETTER_GEBO_GYFU_G = '\u16B7';
    /** ᚸ of type OTHER_LETTER */
    char RUNIC_LETTER_GAR = '\u16B8';
    /** ᚹ of type OTHER_LETTER */
    char RUNIC_LETTER_WUNJO_WYNN_W = '\u16B9';
    /** ᚺ of type OTHER_LETTER */
    char RUNIC_LETTER_HAGLAZ_H = '\u16BA';
    /** ᚻ of type OTHER_LETTER */
    char RUNIC_LETTER_HAEGL_H = '\u16BB';
    /** ᚼ of type OTHER_LETTER */
    char RUNIC_LETTER_LONG_BRANCH_HAGALL_H = '\u16BC';
    /** ᚽ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_HAGALL_H = '\u16BD';
    /** ᚾ of type OTHER_LETTER */
    char RUNIC_LETTER_NAUDIZ_NYD_NAUD_N = '\u16BE';
    /** ᚿ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_NAUD_N = '\u16BF';
    /** ᛀ of type OTHER_LETTER */
    char RUNIC_LETTER_DOTTED_N = '\u16C0';
    /** ᛁ of type OTHER_LETTER */
    char RUNIC_LETTER_ISAZ_IS_ISS_I = '\u16C1';
    /** ᛂ of type OTHER_LETTER */
    char RUNIC_LETTER_E = '\u16C2';
    /** ᛃ of type OTHER_LETTER */
    char RUNIC_LETTER_JERAN_J = '\u16C3';
    /** ᛄ of type OTHER_LETTER */
    char RUNIC_LETTER_GER = '\u16C4';
    /** ᛅ of type OTHER_LETTER */
    char RUNIC_LETTER_LONG_BRANCH_AR_AE = '\u16C5';
    /** ᛆ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_AR_A = '\u16C6';
    /** ᛇ of type OTHER_LETTER */
    char RUNIC_LETTER_IWAZ_EOH = '\u16C7';
    /** ᛈ of type OTHER_LETTER */
    char RUNIC_LETTER_PERTHO_PEORTH_P = '\u16C8';
    /** ᛉ of type OTHER_LETTER */
    char RUNIC_LETTER_ALGIZ_EOLHX = '\u16C9';
    /** ᛊ of type OTHER_LETTER */
    char RUNIC_LETTER_SOWILO_S = '\u16CA';
    /** ᛋ of type OTHER_LETTER */
    char RUNIC_LETTER_SIGEL_LONG_BRANCH_SOL_S = '\u16CB';
    /** ᛌ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_SOL_S = '\u16CC';
    /** ᛍ of type OTHER_LETTER */
    char RUNIC_LETTER_C = '\u16CD';
    /** ᛎ of type OTHER_LETTER */
    char RUNIC_LETTER_Z = '\u16CE';
    /** ᛏ of type OTHER_LETTER */
    char RUNIC_LETTER_TIWAZ_TIR_TYR_T = '\u16CF';
    /** ᛐ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_TYR_T = '\u16D0';
    /** ᛑ of type OTHER_LETTER */
    char RUNIC_LETTER_D = '\u16D1';
    /** ᛒ of type OTHER_LETTER */
    char RUNIC_LETTER_BERKANAN_BEORC_BJARKAN_B = '\u16D2';
    /** ᛓ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_BJARKAN_B = '\u16D3';
    /** ᛔ of type OTHER_LETTER */
    char RUNIC_LETTER_DOTTED_P = '\u16D4';
    /** ᛕ of type OTHER_LETTER */
    char RUNIC_LETTER_OPEN_P = '\u16D5';
    /** ᛖ of type OTHER_LETTER */
    char RUNIC_LETTER_EHWAZ_EH_E = '\u16D6';
    /** ᛗ of type OTHER_LETTER */
    char RUNIC_LETTER_MANNAZ_MAN_M = '\u16D7';
    /** ᛘ of type OTHER_LETTER */
    char RUNIC_LETTER_LONG_BRANCH_MADR_M = '\u16D8';
    /** ᛙ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_MADR_M = '\u16D9';
    /** ᛚ of type OTHER_LETTER */
    char RUNIC_LETTER_LAUKAZ_LAGU_LOGR_L = '\u16DA';
    /** ᛛ of type OTHER_LETTER */
    char RUNIC_LETTER_DOTTED_L = '\u16DB';
    /** ᛜ of type OTHER_LETTER */
    char RUNIC_LETTER_INGWAZ = '\u16DC';
    /** ᛝ of type OTHER_LETTER */
    char RUNIC_LETTER_ING = '\u16DD';
    /** ᛞ of type OTHER_LETTER */
    char RUNIC_LETTER_DAGAZ_DAEG_D = '\u16DE';
    /** ᛟ of type OTHER_LETTER */
    char RUNIC_LETTER_OTHALAN_ETHEL_O = '\u16DF';
    /** ᛠ of type OTHER_LETTER */
    char RUNIC_LETTER_EAR = '\u16E0';
    /** ᛡ of type OTHER_LETTER */
    char RUNIC_LETTER_IOR = '\u16E1';
    /** ᛢ of type OTHER_LETTER */
    char RUNIC_LETTER_CWEORTH = '\u16E2';
    /** ᛣ of type OTHER_LETTER */
    char RUNIC_LETTER_CALC = '\u16E3';
    /** ᛤ of type OTHER_LETTER */
    char RUNIC_LETTER_CEALC = '\u16E4';
    /** ᛥ of type OTHER_LETTER */
    char RUNIC_LETTER_STAN = '\u16E5';
    /** ᛦ of type OTHER_LETTER */
    char RUNIC_LETTER_LONG_BRANCH_YR = '\u16E6';
    /** ᛧ of type OTHER_LETTER */
    char RUNIC_LETTER_SHORT_TWIG_YR = '\u16E7';
    /** ᛨ of type OTHER_LETTER */
    char RUNIC_LETTER_ICELANDIC_YR = '\u16E8';
    /** ᛩ of type OTHER_LETTER */
    char RUNIC_LETTER_Q = '\u16E9';
    /** ᛪ of type OTHER_LETTER */
    char RUNIC_LETTER_X = '\u16EA';
    /** ᛫ of type OTHER_PUNCTUATION */
    char RUNIC_SINGLE_PUNCTUATION = '\u16EB';
    /** ᛬ of type OTHER_PUNCTUATION */
    char RUNIC_MULTIPLE_PUNCTUATION = '\u16EC';
    /** ᛭ of type OTHER_PUNCTUATION */
    char RUNIC_CROSS_PUNCTUATION = '\u16ED';
    /** ᛮ of type LETTER_NUMBER */
    char RUNIC_ARLAUG_SYMBOL = '\u16EE';
    /** ᛯ of type LETTER_NUMBER */
    char RUNIC_TVIMADUR_SYMBOL = '\u16EF';
    /** ᛰ of type LETTER_NUMBER */
    char RUNIC_BELGTHOR_SYMBOL = '\u16F0';
    /** ᜀ of type OTHER_LETTER */
    char TAGALOG_LETTER_A = '\u1700';
    /** ᜁ of type OTHER_LETTER */
    char TAGALOG_LETTER_I = '\u1701';
    /** ᜂ of type OTHER_LETTER */
    char TAGALOG_LETTER_U = '\u1702';
    /** ᜃ of type OTHER_LETTER */
    char TAGALOG_LETTER_KA = '\u1703';
    /** ᜄ of type OTHER_LETTER */
    char TAGALOG_LETTER_GA = '\u1704';
    /** ᜅ of type OTHER_LETTER */
    char TAGALOG_LETTER_NGA = '\u1705';
    /** ᜆ of type OTHER_LETTER */
    char TAGALOG_LETTER_TA = '\u1706';
    /** ᜇ of type OTHER_LETTER */
    char TAGALOG_LETTER_DA = '\u1707';
    /** ᜈ of type OTHER_LETTER */
    char TAGALOG_LETTER_NA = '\u1708';
    /** ᜉ of type OTHER_LETTER */
    char TAGALOG_LETTER_PA = '\u1709';
    /** ᜊ of type OTHER_LETTER */
    char TAGALOG_LETTER_BA = '\u170A';
    /** ᜋ of type OTHER_LETTER */
    char TAGALOG_LETTER_MA = '\u170B';
    /** ᜌ of type OTHER_LETTER */
    char TAGALOG_LETTER_YA = '\u170C';
    /** ᜎ of type OTHER_LETTER */
    char TAGALOG_LETTER_LA = '\u170E';
    /** ᜏ of type OTHER_LETTER */
    char TAGALOG_LETTER_WA = '\u170F';
    /** ᜐ of type OTHER_LETTER */
    char TAGALOG_LETTER_SA = '\u1710';
    /** ᜑ of type OTHER_LETTER */
    char TAGALOG_LETTER_HA = '\u1711';
    /** ᜒ of type NON_SPACING_MARK */
    char TAGALOG_VOWEL_SIGN_I = '\u1712';
    /** ᜓ of type NON_SPACING_MARK */
    char TAGALOG_VOWEL_SIGN_U = '\u1713';
    /** ᜔ of type NON_SPACING_MARK */
    char TAGALOG_SIGN_VIRAMA = '\u1714';
    /** ᜠ of type OTHER_LETTER */
    char HANUNOO_LETTER_A = '\u1720';
    /** ᜡ of type OTHER_LETTER */
    char HANUNOO_LETTER_I = '\u1721';
    /** ᜢ of type OTHER_LETTER */
    char HANUNOO_LETTER_U = '\u1722';
    /** ᜣ of type OTHER_LETTER */
    char HANUNOO_LETTER_KA = '\u1723';
    /** ᜤ of type OTHER_LETTER */
    char HANUNOO_LETTER_GA = '\u1724';
    /** ᜥ of type OTHER_LETTER */
    char HANUNOO_LETTER_NGA = '\u1725';
    /** ᜦ of type OTHER_LETTER */
    char HANUNOO_LETTER_TA = '\u1726';
    /** ᜧ of type OTHER_LETTER */
    char HANUNOO_LETTER_DA = '\u1727';
    /** ᜨ of type OTHER_LETTER */
    char HANUNOO_LETTER_NA = '\u1728';
    /** ᜩ of type OTHER_LETTER */
    char HANUNOO_LETTER_PA = '\u1729';
    /** ᜪ of type OTHER_LETTER */
    char HANUNOO_LETTER_BA = '\u172A';
    /** ᜫ of type OTHER_LETTER */
    char HANUNOO_LETTER_MA = '\u172B';
    /** ᜬ of type OTHER_LETTER */
    char HANUNOO_LETTER_YA = '\u172C';
    /** ᜭ of type OTHER_LETTER */
    char HANUNOO_LETTER_RA = '\u172D';
    /** ᜮ of type OTHER_LETTER */
    char HANUNOO_LETTER_LA = '\u172E';
    /** ᜯ of type OTHER_LETTER */
    char HANUNOO_LETTER_WA = '\u172F';
    /** ᜰ of type OTHER_LETTER */
    char HANUNOO_LETTER_SA = '\u1730';
    /** ᜱ of type OTHER_LETTER */
    char HANUNOO_LETTER_HA = '\u1731';
    /** ᜲ of type NON_SPACING_MARK */
    char HANUNOO_VOWEL_SIGN_I = '\u1732';
    /** ᜳ of type NON_SPACING_MARK */
    char HANUNOO_VOWEL_SIGN_U = '\u1733';
    /** ᜴ of type NON_SPACING_MARK */
    char HANUNOO_SIGN_PAMUDPOD = '\u1734';
    /** ᜵ of type OTHER_PUNCTUATION */
    char PHILIPPINE_SINGLE_PUNCTUATION = '\u1735';
    /** ᜶ of type OTHER_PUNCTUATION */
    char PHILIPPINE_DOUBLE_PUNCTUATION = '\u1736';
    /** ᝀ of type OTHER_LETTER */
    char BUHID_LETTER_A = '\u1740';
    /** ᝁ of type OTHER_LETTER */
    char BUHID_LETTER_I = '\u1741';
    /** ᝂ of type OTHER_LETTER */
    char BUHID_LETTER_U = '\u1742';
    /** ᝃ of type OTHER_LETTER */
    char BUHID_LETTER_KA = '\u1743';
    /** ᝄ of type OTHER_LETTER */
    char BUHID_LETTER_GA = '\u1744';
    /** ᝅ of type OTHER_LETTER */
    char BUHID_LETTER_NGA = '\u1745';
    /** ᝆ of type OTHER_LETTER */
    char BUHID_LETTER_TA = '\u1746';
    /** ᝇ of type OTHER_LETTER */
    char BUHID_LETTER_DA = '\u1747';
    /** ᝈ of type OTHER_LETTER */
    char BUHID_LETTER_NA = '\u1748';
    /** ᝉ of type OTHER_LETTER */
    char BUHID_LETTER_PA = '\u1749';
    /** ᝊ of type OTHER_LETTER */
    char BUHID_LETTER_BA = '\u174A';
    /** ᝋ of type OTHER_LETTER */
    char BUHID_LETTER_MA = '\u174B';
    /** ᝌ of type OTHER_LETTER */
    char BUHID_LETTER_YA = '\u174C';
    /** ᝍ of type OTHER_LETTER */
    char BUHID_LETTER_RA = '\u174D';
    /** ᝎ of type OTHER_LETTER */
    char BUHID_LETTER_LA = '\u174E';
    /** ᝏ of type OTHER_LETTER */
    char BUHID_LETTER_WA = '\u174F';
    /** ᝐ of type OTHER_LETTER */
    char BUHID_LETTER_SA = '\u1750';
    /** ᝑ of type OTHER_LETTER */
    char BUHID_LETTER_HA = '\u1751';
    /** ᝒ of type NON_SPACING_MARK */
    char BUHID_VOWEL_SIGN_I = '\u1752';
    /** ᝓ of type NON_SPACING_MARK */
    char BUHID_VOWEL_SIGN_U = '\u1753';
    /** ᝠ of type OTHER_LETTER */
    char TAGBANWA_LETTER_A = '\u1760';
    /** ᝡ of type OTHER_LETTER */
    char TAGBANWA_LETTER_I = '\u1761';
    /** ᝢ of type OTHER_LETTER */
    char TAGBANWA_LETTER_U = '\u1762';
    /** ᝣ of type OTHER_LETTER */
    char TAGBANWA_LETTER_KA = '\u1763';
    /** ᝤ of type OTHER_LETTER */
    char TAGBANWA_LETTER_GA = '\u1764';
    /** ᝥ of type OTHER_LETTER */
    char TAGBANWA_LETTER_NGA = '\u1765';
    /** ᝦ of type OTHER_LETTER */
    char TAGBANWA_LETTER_TA = '\u1766';
    /** ᝧ of type OTHER_LETTER */
    char TAGBANWA_LETTER_DA = '\u1767';
    /** ᝨ of type OTHER_LETTER */
    char TAGBANWA_LETTER_NA = '\u1768';
    /** ᝩ of type OTHER_LETTER */
    char TAGBANWA_LETTER_PA = '\u1769';
    /** ᝪ of type OTHER_LETTER */
    char TAGBANWA_LETTER_BA = '\u176A';
    /** ᝫ of type OTHER_LETTER */
    char TAGBANWA_LETTER_MA = '\u176B';
    /** ᝬ of type OTHER_LETTER */
    char TAGBANWA_LETTER_YA = '\u176C';
    /** ᝮ of type OTHER_LETTER */
    char TAGBANWA_LETTER_LA = '\u176E';
    /** ᝯ of type OTHER_LETTER */
    char TAGBANWA_LETTER_WA = '\u176F';
    /** ᝰ of type OTHER_LETTER */
    char TAGBANWA_LETTER_SA = '\u1770';
    /** ᝲ of type NON_SPACING_MARK */
    char TAGBANWA_VOWEL_SIGN_I = '\u1772';
    /** ᝳ of type NON_SPACING_MARK */
    char TAGBANWA_VOWEL_SIGN_U = '\u1773';
    /** ᠀ of type OTHER_PUNCTUATION */
    char MONGOLIAN_BIRGA = '\u1800';
    /** ᠁ of type OTHER_PUNCTUATION */
    char MONGOLIAN_ELLIPSIS = '\u1801';
    /** ᠂ of type OTHER_PUNCTUATION */
    char MONGOLIAN_COMMA = '\u1802';
    /** ᠃ of type OTHER_PUNCTUATION */
    char MONGOLIAN_FULL_STOP = '\u1803';
    /** ᠄ of type OTHER_PUNCTUATION */
    char MONGOLIAN_COLON = '\u1804';
    /** ᠅ of type OTHER_PUNCTUATION */
    char MONGOLIAN_FOUR_DOTS = '\u1805';
    /** ᠆ of type DASH_PUNCTUATION */
    char MONGOLIAN_TODO_SOFT_HYPHEN = '\u1806';
    /** ᠇ of type OTHER_PUNCTUATION */
    char MONGOLIAN_SIBE_SYLLABLE_BOUNDARY_MARKER = '\u1807';
    /** ᠈ of type OTHER_PUNCTUATION */
    char MONGOLIAN_MANCHU_COMMA = '\u1808';
    /** ᠉ of type OTHER_PUNCTUATION */
    char MONGOLIAN_MANCHU_FULL_STOP = '\u1809';
    /** ᠊ of type OTHER_PUNCTUATION */
    char MONGOLIAN_NIRUGU = '\u180A';
    /** ᠋ of type NON_SPACING_MARK */
    char MONGOLIAN_FREE_VARIATION_SELECTOR_ONE = '\u180B';
    /** ᠌ of type NON_SPACING_MARK */
    char MONGOLIAN_FREE_VARIATION_SELECTOR_TWO = '\u180C';
    /** ᠍ of type NON_SPACING_MARK */
    char MONGOLIAN_FREE_VARIATION_SELECTOR_THREE = '\u180D';
    /** ᠎ of type SPACE_SEPARATOR */
    char MONGOLIAN_VOWEL_SEPARATOR = '\u180E';
    /** ᠐ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_ZERO = '\u1810';
    /** ᠑ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_ONE = '\u1811';
    /** ᠒ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_TWO = '\u1812';
    /** ᠓ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_THREE = '\u1813';
    /** ᠔ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_FOUR = '\u1814';
    /** ᠕ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_FIVE = '\u1815';
    /** ᠖ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_SIX = '\u1816';
    /** ᠗ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_SEVEN = '\u1817';
    /** ᠘ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_EIGHT = '\u1818';
    /** ᠙ of type DECIMAL_DIGIT_NUMBER */
    char MONGOLIAN_DIGIT_NINE = '\u1819';
    /** ᠠ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_A = '\u1820';
    /** ᠡ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_E = '\u1821';
    /** ᠢ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_I = '\u1822';
    /** ᠣ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_O = '\u1823';
    /** ᠤ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_U = '\u1824';
    /** ᠥ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_OE = '\u1825';
    /** ᠦ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_UE = '\u1826';
    /** ᠧ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_EE = '\u1827';
    /** ᠨ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_NA = '\u1828';
    /** ᠩ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ANG = '\u1829';
    /** ᠪ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_BA = '\u182A';
    /** ᠫ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_PA = '\u182B';
    /** ᠬ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_QA = '\u182C';
    /** ᠭ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_GA = '\u182D';
    /** ᠮ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MA = '\u182E';
    /** ᠯ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_LA = '\u182F';
    /** ᠰ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SA = '\u1830';
    /** ᠱ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SHA = '\u1831';
    /** ᠲ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TA = '\u1832';
    /** ᠳ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_DA = '\u1833';
    /** ᠴ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_CHA = '\u1834';
    /** ᠵ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_JA = '\u1835';
    /** ᠶ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_YA = '\u1836';
    /** ᠷ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_RA = '\u1837';
    /** ᠸ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_WA = '\u1838';
    /** ᠹ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_FA = '\u1839';
    /** ᠺ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_KA = '\u183A';
    /** ᠻ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_KHA = '\u183B';
    /** ᠼ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TSA = '\u183C';
    /** ᠽ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ZA = '\u183D';
    /** ᠾ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_HAA = '\u183E';
    /** ᠿ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ZRA = '\u183F';
    /** ᡀ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_LHA = '\u1840';
    /** ᡁ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ZHI = '\u1841';
    /** ᡂ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_CHI = '\u1842';
    /** ᡃ of type MODIFIER_LETTER */
    char MONGOLIAN_LETTER_TODO_LONG_VOWEL_SIGN = '\u1843';
    /** ᡄ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_E = '\u1844';
    /** ᡅ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_I = '\u1845';
    /** ᡆ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_O = '\u1846';
    /** ᡇ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_U = '\u1847';
    /** ᡈ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_OE = '\u1848';
    /** ᡉ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_UE = '\u1849';
    /** ᡊ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_ANG = '\u184A';
    /** ᡋ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_BA = '\u184B';
    /** ᡌ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_PA = '\u184C';
    /** ᡍ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_QA = '\u184D';
    /** ᡎ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_GA = '\u184E';
    /** ᡏ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_MA = '\u184F';
    /** ᡐ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_TA = '\u1850';
    /** ᡑ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_DA = '\u1851';
    /** ᡒ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_CHA = '\u1852';
    /** ᡓ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_JA = '\u1853';
    /** ᡔ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_TSA = '\u1854';
    /** ᡕ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_YA = '\u1855';
    /** ᡖ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_WA = '\u1856';
    /** ᡗ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_KA = '\u1857';
    /** ᡘ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_GAA = '\u1858';
    /** ᡙ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_HAA = '\u1859';
    /** ᡚ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_JIA = '\u185A';
    /** ᡛ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_NIA = '\u185B';
    /** ᡜ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_DZA = '\u185C';
    /** ᡝ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_E = '\u185D';
    /** ᡞ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_I = '\u185E';
    /** ᡟ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_IY = '\u185F';
    /** ᡠ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_UE = '\u1860';
    /** ᡡ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_U = '\u1861';
    /** ᡢ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_ANG = '\u1862';
    /** ᡣ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_KA = '\u1863';
    /** ᡤ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_GA = '\u1864';
    /** ᡥ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_HA = '\u1865';
    /** ᡦ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_PA = '\u1866';
    /** ᡧ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_SHA = '\u1867';
    /** ᡨ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_TA = '\u1868';
    /** ᡩ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_DA = '\u1869';
    /** ᡪ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_JA = '\u186A';
    /** ᡫ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_FA = '\u186B';
    /** ᡬ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_GAA = '\u186C';
    /** ᡭ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_HAA = '\u186D';
    /** ᡮ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_TSA = '\u186E';
    /** ᡯ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_ZA = '\u186F';
    /** ᡰ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_RAA = '\u1870';
    /** ᡱ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_CHA = '\u1871';
    /** ᡲ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_SIBE_ZHA = '\u1872';
    /** ᡳ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_I = '\u1873';
    /** ᡴ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_KA = '\u1874';
    /** ᡵ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_RA = '\u1875';
    /** ᡶ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_FA = '\u1876';
    /** ᡷ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ZHA = '\u1877';
    /** ᢀ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_ANUSVARA_ONE = '\u1880';
    /** ᢁ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_VISARGA_ONE = '\u1881';
    /** ᢂ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_DAMARU = '\u1882';
    /** ᢃ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_UBADAMA = '\u1883';
    /** ᢄ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_INVERTED_UBADAMA = '\u1884';
    /** ᢅ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_BALUDA = '\u1885';
    /** ᢆ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_THREE_BALUDA = '\u1886';
    /** ᢇ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_A = '\u1887';
    /** ᢈ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_I = '\u1888';
    /** ᢉ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_KA = '\u1889';
    /** ᢊ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_NGA = '\u188A';
    /** ᢋ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_CA = '\u188B';
    /** ᢌ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_TTA = '\u188C';
    /** ᢍ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_TTHA = '\u188D';
    /** ᢎ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_DDA = '\u188E';
    /** ᢏ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_NNA = '\u188F';
    /** ᢐ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_TA = '\u1890';
    /** ᢑ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_DA = '\u1891';
    /** ᢒ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_PA = '\u1892';
    /** ᢓ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_PHA = '\u1893';
    /** ᢔ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_SSA = '\u1894';
    /** ᢕ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_ZHA = '\u1895';
    /** ᢖ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_ZA = '\u1896';
    /** ᢗ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_AH = '\u1897';
    /** ᢘ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_ALI_GALI_TA = '\u1898';
    /** ᢙ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_TODO_ALI_GALI_ZHA = '\u1899';
    /** ᢚ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_GHA = '\u189A';
    /** ᢛ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_NGA = '\u189B';
    /** ᢜ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_CA = '\u189C';
    /** ᢝ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_JHA = '\u189D';
    /** ᢞ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_TTA = '\u189E';
    /** ᢟ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_DDHA = '\u189F';
    /** ᢠ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_TA = '\u18A0';
    /** ᢡ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_DHA = '\u18A1';
    /** ᢢ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_SSA = '\u18A2';
    /** ᢣ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_CYA = '\u18A3';
    /** ᢤ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_ZHA = '\u18A4';
    /** ᢥ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_ZA = '\u18A5';
    /** ᢦ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_HALF_U = '\u18A6';
    /** ᢧ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_ALI_GALI_HALF_YA = '\u18A7';
    /** ᢨ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_BHA = '\u18A8';
    /** ᢩ of type NON_SPACING_MARK */
    char MONGOLIAN_LETTER_ALI_GALI_DAGALGA = '\u18A9';
    /** ᢪ of type OTHER_LETTER */
    char MONGOLIAN_LETTER_MANCHU_ALI_GALI_LHA = '\u18AA';
    /** ᢰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OY = '\u18B0';
    /** ᢱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AY = '\u18B1';
    /** ᢲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_AAY = '\u18B2';
    /** ᢳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WAY = '\u18B3';
    /** ᢴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_POY = '\u18B4';
    /** ᢵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PAY = '\u18B5';
    /** ᢶ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_PWOY = '\u18B6';
    /** ᢷ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TAY = '\u18B7';
    /** ᢸ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KAY = '\u18B8';
    /** ᢹ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_KWAY = '\u18B9';
    /** ᢺ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_MAY = '\u18BA';
    /** ᢻ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NOY = '\u18BB';
    /** ᢼ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NAY = '\u18BC';
    /** ᢽ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_LAY = '\u18BD';
    /** ᢾ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SOY = '\u18BE';
    /** ᢿ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAY = '\u18BF';
    /** ᣀ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHOY = '\u18C0';
    /** ᣁ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHAY = '\u18C1';
    /** ᣂ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SHWOY = '\u18C2';
    /** ᣃ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YOY = '\u18C3';
    /** ᣄ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_YAY = '\u18C4';
    /** ᣅ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RAY = '\u18C5';
    /** ᣆ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWI = '\u18C6';
    /** ᣇ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_NWI = '\u18C7';
    /** ᣈ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWII = '\u18C8';
    /** ᣉ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_NWII = '\u18C9';
    /** ᣊ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWO = '\u18CA';
    /** ᣋ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_NWO = '\u18CB';
    /** ᣌ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_NWOO = '\u18CC';
    /** ᣍ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_NWOO = '\u18CD';
    /** ᣎ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWEE = '\u18CE';
    /** ᣏ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWI = '\u18CF';
    /** ᣐ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWII = '\u18D0';
    /** ᣑ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWO = '\u18D1';
    /** ᣒ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWOO = '\u18D2';
    /** ᣓ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_RWA = '\u18D3';
    /** ᣔ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_P = '\u18D4';
    /** ᣕ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_T = '\u18D5';
    /** ᣖ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_K = '\u18D6';
    /** ᣗ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_C = '\u18D7';
    /** ᣘ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_M = '\u18D8';
    /** ᣙ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_N = '\u18D9';
    /** ᣚ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_S = '\u18DA';
    /** ᣛ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_OJIBWAY_SH = '\u18DB';
    /** ᣜ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_EASTERN_W = '\u18DC';
    /** ᣝ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WESTERN_W = '\u18DD';
    /** ᣞ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_SMALL_RING = '\u18DE';
    /** ᣟ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_FINAL_RAISED_DOT = '\u18DF';
    /** ᣠ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_R_CREE_RWE = '\u18E0';
    /** ᣡ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LOO = '\u18E1';
    /** ᣢ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_WEST_CREE_LAA = '\u18E2';
    /** ᣣ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THWE = '\u18E3';
    /** ᣤ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_THWA = '\u18E4';
    /** ᣥ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHWE = '\u18E5';
    /** ᣦ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHOO = '\u18E6';
    /** ᣧ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TTHAA = '\u18E7';
    /** ᣨ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TLHWE = '\u18E8';
    /** ᣩ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_TLHOO = '\u18E9';
    /** ᣪ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_SHWE = '\u18EA';
    /** ᣫ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_SHOO = '\u18EB';
    /** ᣬ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_HOO = '\u18EC';
    /** ᣭ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GWU = '\u18ED';
    /** ᣮ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DENE_GEE = '\u18EE';
    /** ᣯ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GAA = '\u18EF';
    /** ᣰ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_GWA = '\u18F0';
    /** ᣱ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_SAYISI_JUU = '\u18F1';
    /** ᣲ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_JWA = '\u18F2';
    /** ᣳ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BEAVER_DENE_L = '\u18F3';
    /** ᣴ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_BEAVER_DENE_R = '\u18F4';
    /** ᣵ of type OTHER_LETTER */
    char CANADIAN_SYLLABICS_CARRIER_DENTAL_S = '\u18F5';
    /** ᤀ of type OTHER_LETTER */
    char LIMBU_VOWEL_CARRIER_LETTER = '\u1900';
    /** ᤁ of type OTHER_LETTER */
    char LIMBU_LETTER_KA = '\u1901';
    /** ᤂ of type OTHER_LETTER */
    char LIMBU_LETTER_KHA = '\u1902';
    /** ᤃ of type OTHER_LETTER */
    char LIMBU_LETTER_GA = '\u1903';
    /** ᤄ of type OTHER_LETTER */
    char LIMBU_LETTER_GHA = '\u1904';
    /** ᤅ of type OTHER_LETTER */
    char LIMBU_LETTER_NGA = '\u1905';
    /** ᤆ of type OTHER_LETTER */
    char LIMBU_LETTER_CA = '\u1906';
    /** ᤇ of type OTHER_LETTER */
    char LIMBU_LETTER_CHA = '\u1907';
    /** ᤈ of type OTHER_LETTER */
    char LIMBU_LETTER_JA = '\u1908';
    /** ᤉ of type OTHER_LETTER */
    char LIMBU_LETTER_JHA = '\u1909';
    /** ᤊ of type OTHER_LETTER */
    char LIMBU_LETTER_YAN = '\u190A';
    /** ᤋ of type OTHER_LETTER */
    char LIMBU_LETTER_TA = '\u190B';
    /** ᤌ of type OTHER_LETTER */
    char LIMBU_LETTER_THA = '\u190C';
    /** ᤍ of type OTHER_LETTER */
    char LIMBU_LETTER_DA = '\u190D';
    /** ᤎ of type OTHER_LETTER */
    char LIMBU_LETTER_DHA = '\u190E';
    /** ᤏ of type OTHER_LETTER */
    char LIMBU_LETTER_NA = '\u190F';
    /** ᤐ of type OTHER_LETTER */
    char LIMBU_LETTER_PA = '\u1910';
    /** ᤑ of type OTHER_LETTER */
    char LIMBU_LETTER_PHA = '\u1911';
    /** ᤒ of type OTHER_LETTER */
    char LIMBU_LETTER_BA = '\u1912';
    /** ᤓ of type OTHER_LETTER */
    char LIMBU_LETTER_BHA = '\u1913';
    /** ᤔ of type OTHER_LETTER */
    char LIMBU_LETTER_MA = '\u1914';
    /** ᤕ of type OTHER_LETTER */
    char LIMBU_LETTER_YA = '\u1915';
    /** ᤖ of type OTHER_LETTER */
    char LIMBU_LETTER_RA = '\u1916';
    /** ᤗ of type OTHER_LETTER */
    char LIMBU_LETTER_LA = '\u1917';
    /** ᤘ of type OTHER_LETTER */
    char LIMBU_LETTER_WA = '\u1918';
    /** ᤙ of type OTHER_LETTER */
    char LIMBU_LETTER_SHA = '\u1919';
    /** ᤚ of type OTHER_LETTER */
    char LIMBU_LETTER_SSA = '\u191A';
    /** ᤛ of type OTHER_LETTER */
    char LIMBU_LETTER_SA = '\u191B';
    /** ᤜ of type OTHER_LETTER */
    char LIMBU_LETTER_HA = '\u191C';
    /** ᤠ of type NON_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_A = '\u1920';
    /** ᤡ of type NON_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_I = '\u1921';
    /** ᤢ of type NON_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_U = '\u1922';
    /** ᤣ of type COMBINING_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_EE = '\u1923';
    /** ᤤ of type COMBINING_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_AI = '\u1924';
    /** ᤥ of type COMBINING_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_OO = '\u1925';
    /** ᤦ of type COMBINING_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_AU = '\u1926';
    /** ᤧ of type NON_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_E = '\u1927';
    /** ᤨ of type NON_SPACING_MARK */
    char LIMBU_VOWEL_SIGN_O = '\u1928';
    /** ᤩ of type COMBINING_SPACING_MARK */
    char LIMBU_SUBJOINED_LETTER_YA = '\u1929';
    /** ᤪ of type COMBINING_SPACING_MARK */
    char LIMBU_SUBJOINED_LETTER_RA = '\u192A';
    /** ᤫ of type COMBINING_SPACING_MARK */
    char LIMBU_SUBJOINED_LETTER_WA = '\u192B';
    /** ᤰ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_KA = '\u1930';
    /** ᤱ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_NGA = '\u1931';
    /** ᤲ of type NON_SPACING_MARK */
    char LIMBU_SMALL_LETTER_ANUSVARA = '\u1932';
    /** ᤳ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_TA = '\u1933';
    /** ᤴ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_NA = '\u1934';
    /** ᤵ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_PA = '\u1935';
    /** ᤶ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_MA = '\u1936';
    /** ᤷ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_RA = '\u1937';
    /** ᤸ of type COMBINING_SPACING_MARK */
    char LIMBU_SMALL_LETTER_LA = '\u1938';
    /** ᤹ of type NON_SPACING_MARK */
    char LIMBU_SIGN_MUKPHRENG = '\u1939';
    /** ᤺ of type NON_SPACING_MARK */
    char LIMBU_SIGN_KEMPHRENG = '\u193A';
    /** ᤻ of type NON_SPACING_MARK */
    char LIMBU_SIGN_SA_I = '\u193B';
    /** ᥀ of type OTHER_SYMBOL */
    char LIMBU_SIGN_LOO = '\u1940';
    /** ᥄ of type OTHER_PUNCTUATION */
    char LIMBU_EXCLAMATION_MARK = '\u1944';
    /** ᥅ of type OTHER_PUNCTUATION */
    char LIMBU_QUESTION_MARK = '\u1945';
    /** ᥆ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_ZERO = '\u1946';
    /** ᥇ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_ONE = '\u1947';
    /** ᥈ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_TWO = '\u1948';
    /** ᥉ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_THREE = '\u1949';
    /** ᥊ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_FOUR = '\u194A';
    /** ᥋ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_FIVE = '\u194B';
    /** ᥌ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_SIX = '\u194C';
    /** ᥍ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_SEVEN = '\u194D';
    /** ᥎ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_EIGHT = '\u194E';
    /** ᥏ of type DECIMAL_DIGIT_NUMBER */
    char LIMBU_DIGIT_NINE = '\u194F';
    /** ᦀ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_QA = '\u1980';
    /** ᦁ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_QA = '\u1981';
    /** ᦂ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_KA = '\u1982';
    /** ᦃ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_XA = '\u1983';
    /** ᦄ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_NGA = '\u1984';
    /** ᦅ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_KA = '\u1985';
    /** ᦆ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_XA = '\u1986';
    /** ᦇ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_NGA = '\u1987';
    /** ᦈ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_TSA = '\u1988';
    /** ᦉ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_SA = '\u1989';
    /** ᦊ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_YA = '\u198A';
    /** ᦋ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_TSA = '\u198B';
    /** ᦌ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_SA = '\u198C';
    /** ᦍ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_YA = '\u198D';
    /** ᦎ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_TA = '\u198E';
    /** ᦏ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_THA = '\u198F';
    /** ᦐ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_NA = '\u1990';
    /** ᦑ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_TA = '\u1991';
    /** ᦒ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_THA = '\u1992';
    /** ᦓ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_NA = '\u1993';
    /** ᦔ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_PA = '\u1994';
    /** ᦕ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_PHA = '\u1995';
    /** ᦖ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_MA = '\u1996';
    /** ᦗ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_PA = '\u1997';
    /** ᦘ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_PHA = '\u1998';
    /** ᦙ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_MA = '\u1999';
    /** ᦚ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_FA = '\u199A';
    /** ᦛ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_VA = '\u199B';
    /** ᦜ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_LA = '\u199C';
    /** ᦝ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_FA = '\u199D';
    /** ᦞ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_VA = '\u199E';
    /** ᦟ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_LA = '\u199F';
    /** ᦠ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_HA = '\u19A0';
    /** ᦡ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_DA = '\u19A1';
    /** ᦢ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_BA = '\u19A2';
    /** ᦣ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_HA = '\u19A3';
    /** ᦤ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_DA = '\u19A4';
    /** ᦥ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_BA = '\u19A5';
    /** ᦦ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_KVA = '\u19A6';
    /** ᦧ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_XVA = '\u19A7';
    /** ᦨ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_KVA = '\u19A8';
    /** ᦩ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_XVA = '\u19A9';
    /** ᦪ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_HIGH_SUA = '\u19AA';
    /** ᦫ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_LOW_SUA = '\u19AB';
    /** ᦰ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_VOWEL_SHORTENER = '\u19B0';
    /** ᦱ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_AA = '\u19B1';
    /** ᦲ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_II = '\u19B2';
    /** ᦳ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_U = '\u19B3';
    /** ᦴ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_UU = '\u19B4';
    /** ᦵ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_E = '\u19B5';
    /** ᦶ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_AE = '\u19B6';
    /** ᦷ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_O = '\u19B7';
    /** ᦸ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_OA = '\u19B8';
    /** ᦹ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_UE = '\u19B9';
    /** ᦺ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_AY = '\u19BA';
    /** ᦻ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_AAY = '\u19BB';
    /** ᦼ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_UY = '\u19BC';
    /** ᦽ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_OY = '\u19BD';
    /** ᦾ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_OAY = '\u19BE';
    /** ᦿ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_UEY = '\u19BF';
    /** ᧀ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_VOWEL_SIGN_IY = '\u19C0';
    /** ᧁ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_V = '\u19C1';
    /** ᧂ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_NG = '\u19C2';
    /** ᧃ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_N = '\u19C3';
    /** ᧄ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_M = '\u19C4';
    /** ᧅ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_K = '\u19C5';
    /** ᧆ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_D = '\u19C6';
    /** ᧇ of type OTHER_LETTER */
    char NEW_TAI_LUE_LETTER_FINAL_B = '\u19C7';
    /** ᧈ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_TONE_MARK_1 = '\u19C8';
    /** ᧉ of type COMBINING_SPACING_MARK */
    char NEW_TAI_LUE_TONE_MARK_2 = '\u19C9';
    /** ᧐ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_ZERO = '\u19D0';
    /** ᧑ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_ONE = '\u19D1';
    /** ᧒ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_TWO = '\u19D2';
    /** ᧓ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_THREE = '\u19D3';
    /** ᧔ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_FOUR = '\u19D4';
    /** ᧕ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_FIVE = '\u19D5';
    /** ᧖ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_SIX = '\u19D6';
    /** ᧗ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_SEVEN = '\u19D7';
    /** ᧘ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_EIGHT = '\u19D8';
    /** ᧙ of type DECIMAL_DIGIT_NUMBER */
    char NEW_TAI_LUE_DIGIT_NINE = '\u19D9';
    /** ᧚ of type OTHER_NUMBER */
    char NEW_TAI_LUE_THAM_DIGIT_ONE = '\u19DA';
    /** ᧞ of type OTHER_SYMBOL */
    char NEW_TAI_LUE_SIGN_LAE = '\u19DE';
    /** ᧟ of type OTHER_SYMBOL */
    char NEW_TAI_LUE_SIGN_LAEV = '\u19DF';
    /** ᨀ of type OTHER_LETTER */
    char BUGINESE_LETTER_KA = '\u1A00';
    /** ᨁ of type OTHER_LETTER */
    char BUGINESE_LETTER_GA = '\u1A01';
    /** ᨂ of type OTHER_LETTER */
    char BUGINESE_LETTER_NGA = '\u1A02';
    /** ᨃ of type OTHER_LETTER */
    char BUGINESE_LETTER_NGKA = '\u1A03';
    /** ᨄ of type OTHER_LETTER */
    char BUGINESE_LETTER_PA = '\u1A04';
    /** ᨅ of type OTHER_LETTER */
    char BUGINESE_LETTER_BA = '\u1A05';
    /** ᨆ of type OTHER_LETTER */
    char BUGINESE_LETTER_MA = '\u1A06';
    /** ᨇ of type OTHER_LETTER */
    char BUGINESE_LETTER_MPA = '\u1A07';
    /** ᨈ of type OTHER_LETTER */
    char BUGINESE_LETTER_TA = '\u1A08';
    /** ᨉ of type OTHER_LETTER */
    char BUGINESE_LETTER_DA = '\u1A09';
    /** ᨊ of type OTHER_LETTER */
    char BUGINESE_LETTER_NA = '\u1A0A';
    /** ᨋ of type OTHER_LETTER */
    char BUGINESE_LETTER_NRA = '\u1A0B';
    /** ᨌ of type OTHER_LETTER */
    char BUGINESE_LETTER_CA = '\u1A0C';
    /** ᨍ of type OTHER_LETTER */
    char BUGINESE_LETTER_JA = '\u1A0D';
    /** ᨎ of type OTHER_LETTER */
    char BUGINESE_LETTER_NYA = '\u1A0E';
    /** ᨏ of type OTHER_LETTER */
    char BUGINESE_LETTER_NYCA = '\u1A0F';
    /** ᨐ of type OTHER_LETTER */
    char BUGINESE_LETTER_YA = '\u1A10';
    /** ᨑ of type OTHER_LETTER */
    char BUGINESE_LETTER_RA = '\u1A11';
    /** ᨒ of type OTHER_LETTER */
    char BUGINESE_LETTER_LA = '\u1A12';
    /** ᨓ of type OTHER_LETTER */
    char BUGINESE_LETTER_VA = '\u1A13';
    /** ᨔ of type OTHER_LETTER */
    char BUGINESE_LETTER_SA = '\u1A14';
    /** ᨕ of type OTHER_LETTER */
    char BUGINESE_LETTER_A = '\u1A15';
    /** ᨖ of type OTHER_LETTER */
    char BUGINESE_LETTER_HA = '\u1A16';
    /** ᨗ of type NON_SPACING_MARK */
    char BUGINESE_VOWEL_SIGN_I = '\u1A17';
    /** ᨘ of type NON_SPACING_MARK */
    char BUGINESE_VOWEL_SIGN_U = '\u1A18';
    /** ᨙ of type COMBINING_SPACING_MARK */
    char BUGINESE_VOWEL_SIGN_E = '\u1A19';
    /** ᨚ of type COMBINING_SPACING_MARK */
    char BUGINESE_VOWEL_SIGN_O = '\u1A1A';
    /** ᨛ of type COMBINING_SPACING_MARK */
    char BUGINESE_VOWEL_SIGN_AE = '\u1A1B';
    /** ᨞ of type OTHER_PUNCTUATION */
    char BUGINESE_PALLAWA = '\u1A1E';
    /** ᨟ of type OTHER_PUNCTUATION */
    char BUGINESE_END_OF_SECTION = '\u1A1F';
    /** ᬀ of type NON_SPACING_MARK */
    char BALINESE_SIGN_ULU_RICEM = '\u1B00';
    /** ᬁ of type NON_SPACING_MARK */
    char BALINESE_SIGN_ULU_CANDRA = '\u1B01';
    /** ᬂ of type NON_SPACING_MARK */
    char BALINESE_SIGN_CECEK = '\u1B02';
    /** ᬃ of type NON_SPACING_MARK */
    char BALINESE_SIGN_SURANG = '\u1B03';
    /** ᬄ of type COMBINING_SPACING_MARK */
    char BALINESE_SIGN_BISAH = '\u1B04';
    /** ᬅ of type OTHER_LETTER */
    char BALINESE_LETTER_AKARA = '\u1B05';
    /** ᬆ of type OTHER_LETTER */
    char BALINESE_LETTER_AKARA_TEDUNG = '\u1B06';
    /** ᬇ of type OTHER_LETTER */
    char BALINESE_LETTER_IKARA = '\u1B07';
    /** ᬈ of type OTHER_LETTER */
    char BALINESE_LETTER_IKARA_TEDUNG = '\u1B08';
    /** ᬉ of type OTHER_LETTER */
    char BALINESE_LETTER_UKARA = '\u1B09';
    /** ᬊ of type OTHER_LETTER */
    char BALINESE_LETTER_UKARA_TEDUNG = '\u1B0A';
    /** ᬋ of type OTHER_LETTER */
    char BALINESE_LETTER_RA_REPA = '\u1B0B';
    /** ᬌ of type OTHER_LETTER */
    char BALINESE_LETTER_RA_REPA_TEDUNG = '\u1B0C';
    /** ᬍ of type OTHER_LETTER */
    char BALINESE_LETTER_LA_LENGA = '\u1B0D';
    /** ᬎ of type OTHER_LETTER */
    char BALINESE_LETTER_LA_LENGA_TEDUNG = '\u1B0E';
    /** ᬏ of type OTHER_LETTER */
    char BALINESE_LETTER_EKARA = '\u1B0F';
    /** ᬐ of type OTHER_LETTER */
    char BALINESE_LETTER_AIKARA = '\u1B10';
    /** ᬑ of type OTHER_LETTER */
    char BALINESE_LETTER_OKARA = '\u1B11';
    /** ᬒ of type OTHER_LETTER */
    char BALINESE_LETTER_OKARA_TEDUNG = '\u1B12';
    /** ᬓ of type OTHER_LETTER */
    char BALINESE_LETTER_KA = '\u1B13';
    /** ᬔ of type OTHER_LETTER */
    char BALINESE_LETTER_KA_MAHAPRANA = '\u1B14';
    /** ᬕ of type OTHER_LETTER */
    char BALINESE_LETTER_GA = '\u1B15';
    /** ᬖ of type OTHER_LETTER */
    char BALINESE_LETTER_GA_GORA = '\u1B16';
    /** ᬗ of type OTHER_LETTER */
    char BALINESE_LETTER_NGA = '\u1B17';
    /** ᬘ of type OTHER_LETTER */
    char BALINESE_LETTER_CA = '\u1B18';
    /** ᬙ of type OTHER_LETTER */
    char BALINESE_LETTER_CA_LACA = '\u1B19';
    /** ᬚ of type OTHER_LETTER */
    char BALINESE_LETTER_JA = '\u1B1A';
    /** ᬛ of type OTHER_LETTER */
    char BALINESE_LETTER_JA_JERA = '\u1B1B';
    /** ᬜ of type OTHER_LETTER */
    char BALINESE_LETTER_NYA = '\u1B1C';
    /** ᬝ of type OTHER_LETTER */
    char BALINESE_LETTER_TA_LATIK = '\u1B1D';
    /** ᬞ of type OTHER_LETTER */
    char BALINESE_LETTER_TA_MURDA_MAHAPRANA = '\u1B1E';
    /** ᬟ of type OTHER_LETTER */
    char BALINESE_LETTER_DA_MURDA_ALPAPRANA = '\u1B1F';
    /** ᬠ of type OTHER_LETTER */
    char BALINESE_LETTER_DA_MURDA_MAHAPRANA = '\u1B20';
    /** ᬡ of type OTHER_LETTER */
    char BALINESE_LETTER_NA_RAMBAT = '\u1B21';
    /** ᬢ of type OTHER_LETTER */
    char BALINESE_LETTER_TA = '\u1B22';
    /** ᬣ of type OTHER_LETTER */
    char BALINESE_LETTER_TA_TAWA = '\u1B23';
    /** ᬤ of type OTHER_LETTER */
    char BALINESE_LETTER_DA = '\u1B24';
    /** ᬥ of type OTHER_LETTER */
    char BALINESE_LETTER_DA_MADU = '\u1B25';
    /** ᬦ of type OTHER_LETTER */
    char BALINESE_LETTER_NA = '\u1B26';
    /** ᬧ of type OTHER_LETTER */
    char BALINESE_LETTER_PA = '\u1B27';
    /** ᬨ of type OTHER_LETTER */
    char BALINESE_LETTER_PA_KAPAL = '\u1B28';
    /** ᬩ of type OTHER_LETTER */
    char BALINESE_LETTER_BA = '\u1B29';
    /** ᬪ of type OTHER_LETTER */
    char BALINESE_LETTER_BA_KEMBANG = '\u1B2A';
    /** ᬫ of type OTHER_LETTER */
    char BALINESE_LETTER_MA = '\u1B2B';
    /** ᬬ of type OTHER_LETTER */
    char BALINESE_LETTER_YA = '\u1B2C';
    /** ᬭ of type OTHER_LETTER */
    char BALINESE_LETTER_RA = '\u1B2D';
    /** ᬮ of type OTHER_LETTER */
    char BALINESE_LETTER_LA = '\u1B2E';
    /** ᬯ of type OTHER_LETTER */
    char BALINESE_LETTER_WA = '\u1B2F';
    /** ᬰ of type OTHER_LETTER */
    char BALINESE_LETTER_SA_SAGA = '\u1B30';
    /** ᬱ of type OTHER_LETTER */
    char BALINESE_LETTER_SA_SAPA = '\u1B31';
    /** ᬲ of type OTHER_LETTER */
    char BALINESE_LETTER_SA = '\u1B32';
    /** ᬳ of type OTHER_LETTER */
    char BALINESE_LETTER_HA = '\u1B33';
    /** ᬴ of type NON_SPACING_MARK */
    char BALINESE_SIGN_REREKAN = '\u1B34';
    /** ᬵ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_TEDUNG = '\u1B35';
    /** ᬶ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_ULU = '\u1B36';
    /** ᬷ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_ULU_SARI = '\u1B37';
    /** ᬸ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_SUKU = '\u1B38';
    /** ᬹ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_SUKU_ILUT = '\u1B39';
    /** ᬺ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_RA_REPA = '\u1B3A';
    /** ᬻ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_RA_REPA_TEDUNG = '\u1B3B';
    /** ᬼ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_LA_LENGA = '\u1B3C';
    /** ᬽ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_LA_LENGA_TEDUNG = '\u1B3D';
    /** ᬾ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_TALING = '\u1B3E';
    /** ᬿ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_TALING_REPA = '\u1B3F';
    /** ᭀ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_TALING_TEDUNG = '\u1B40';
    /** ᭁ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_TALING_REPA_TEDUNG = '\u1B41';
    /** ᭂ of type NON_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_PEPET = '\u1B42';
    /** ᭃ of type COMBINING_SPACING_MARK */
    char BALINESE_VOWEL_SIGN_PEPET_TEDUNG = '\u1B43';
    /** ᭄ of type COMBINING_SPACING_MARK */
    char BALINESE_ADEG_ADEG = '\u1B44';
    /** ᭅ of type OTHER_LETTER */
    char BALINESE_LETTER_KAF_SASAK = '\u1B45';
    /** ᭆ of type OTHER_LETTER */
    char BALINESE_LETTER_KHOT_SASAK = '\u1B46';
    /** ᭇ of type OTHER_LETTER */
    char BALINESE_LETTER_TZIR_SASAK = '\u1B47';
    /** ᭈ of type OTHER_LETTER */
    char BALINESE_LETTER_EF_SASAK = '\u1B48';
    /** ᭉ of type OTHER_LETTER */
    char BALINESE_LETTER_VE_SASAK = '\u1B49';
    /** ᭊ of type OTHER_LETTER */
    char BALINESE_LETTER_ZAL_SASAK = '\u1B4A';
    /** ᭋ of type OTHER_LETTER */
    char BALINESE_LETTER_ASYURA_SASAK = '\u1B4B';
    /** ᭐ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_ZERO = '\u1B50';
    /** ᭑ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_ONE = '\u1B51';
    /** ᭒ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_TWO = '\u1B52';
    /** ᭓ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_THREE = '\u1B53';
    /** ᭔ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_FOUR = '\u1B54';
    /** ᭕ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_FIVE = '\u1B55';
    /** ᭖ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_SIX = '\u1B56';
    /** ᭗ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_SEVEN = '\u1B57';
    /** ᭘ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_EIGHT = '\u1B58';
    /** ᭙ of type DECIMAL_DIGIT_NUMBER */
    char BALINESE_DIGIT_NINE = '\u1B59';
    /** ᭚ of type OTHER_PUNCTUATION */
    char BALINESE_PANTI = '\u1B5A';
    /** ᭛ of type OTHER_PUNCTUATION */
    char BALINESE_PAMADA = '\u1B5B';
    /** ᭜ of type OTHER_PUNCTUATION */
    char BALINESE_WINDU = '\u1B5C';
    /** ᭝ of type OTHER_PUNCTUATION */
    char BALINESE_CARIK_PAMUNGKAH = '\u1B5D';
    /** ᭞ of type OTHER_PUNCTUATION */
    char BALINESE_CARIK_SIKI = '\u1B5E';
    /** ᭟ of type OTHER_PUNCTUATION */
    char BALINESE_CARIK_PAREREN = '\u1B5F';
    /** ᭠ of type OTHER_PUNCTUATION */
    char BALINESE_PAMENENG = '\u1B60';
    /** ᭡ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DONG = '\u1B61';
    /** ᭢ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DENG = '\u1B62';
    /** ᭣ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DUNG = '\u1B63';
    /** ᭤ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DANG = '\u1B64';
    /** ᭥ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DANG_SURANG = '\u1B65';
    /** ᭦ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DING = '\u1B66';
    /** ᭧ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DAENG = '\u1B67';
    /** ᭨ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DEUNG = '\u1B68';
    /** ᭩ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DAING = '\u1B69';
    /** ᭪ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_DANG_GEDE = '\u1B6A';
    /** ᭫ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_TEGEH = '\u1B6B';
    /** ᭬ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_ENDEP = '\u1B6C';
    /** ᭭ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_KEMPUL = '\u1B6D';
    /** ᭮ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_KEMPLI = '\u1B6E';
    /** ᭯ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_JEGOGAN = '\u1B6F';
    /** ᭰ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_KEMPUL_WITH_JEGOGAN = '\u1B70';
    /** ᭱ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_KEMPLI_WITH_JEGOGAN = '\u1B71';
    /** ᭲ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_BENDE = '\u1B72';
    /** ᭳ of type NON_SPACING_MARK */
    char BALINESE_MUSICAL_SYMBOL_COMBINING_GONG = '\u1B73';
    /** ᭴ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_RIGHT_HAND_OPEN_DUG = '\u1B74';
    /** ᭵ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_RIGHT_HAND_OPEN_DAG = '\u1B75';
    /** ᭶ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_RIGHT_HAND_CLOSED_TUK = '\u1B76';
    /** ᭷ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_RIGHT_HAND_CLOSED_TAK = '\u1B77';
    /** ᭸ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_LEFT_HAND_OPEN_PANG = '\u1B78';
    /** ᭹ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_LEFT_HAND_OPEN_PUNG = '\u1B79';
    /** ᭺ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_LEFT_HAND_CLOSED_PLAK = '\u1B7A';
    /** ᭻ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_LEFT_HAND_CLOSED_PLUK = '\u1B7B';
    /** ᭼ of type OTHER_SYMBOL */
    char BALINESE_MUSICAL_SYMBOL_LEFT_HAND_OPEN_PING = '\u1B7C';
    /** ᯀ of type OTHER_LETTER */
    char BATAK_LETTER_A = '\u1BC0';
    /** ᯁ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_A = '\u1BC1';
    /** ᯂ of type OTHER_LETTER */
    char BATAK_LETTER_HA = '\u1BC2';
    /** ᯃ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_HA = '\u1BC3';
    /** ᯄ of type OTHER_LETTER */
    char BATAK_LETTER_MANDAILING_HA = '\u1BC4';
    /** ᯅ of type OTHER_LETTER */
    char BATAK_LETTER_BA = '\u1BC5';
    /** ᯆ of type OTHER_LETTER */
    char BATAK_LETTER_KARO_BA = '\u1BC6';
    /** ᯇ of type OTHER_LETTER */
    char BATAK_LETTER_PA = '\u1BC7';
    /** ᯈ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_PA = '\u1BC8';
    /** ᯉ of type OTHER_LETTER */
    char BATAK_LETTER_NA = '\u1BC9';
    /** ᯊ of type OTHER_LETTER */
    char BATAK_LETTER_MANDAILING_NA = '\u1BCA';
    /** ᯋ of type OTHER_LETTER */
    char BATAK_LETTER_WA = '\u1BCB';
    /** ᯌ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_WA = '\u1BCC';
    /** ᯍ of type OTHER_LETTER */
    char BATAK_LETTER_PAKPAK_WA = '\u1BCD';
    /** ᯎ of type OTHER_LETTER */
    char BATAK_LETTER_GA = '\u1BCE';
    /** ᯏ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_GA = '\u1BCF';
    /** ᯐ of type OTHER_LETTER */
    char BATAK_LETTER_JA = '\u1BD0';
    /** ᯑ of type OTHER_LETTER */
    char BATAK_LETTER_DA = '\u1BD1';
    /** ᯒ of type OTHER_LETTER */
    char BATAK_LETTER_RA = '\u1BD2';
    /** ᯓ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_RA = '\u1BD3';
    /** ᯔ of type OTHER_LETTER */
    char BATAK_LETTER_MA = '\u1BD4';
    /** ᯕ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_MA = '\u1BD5';
    /** ᯖ of type OTHER_LETTER */
    char BATAK_LETTER_SOUTHERN_TA = '\u1BD6';
    /** ᯗ of type OTHER_LETTER */
    char BATAK_LETTER_NORTHERN_TA = '\u1BD7';
    /** ᯘ of type OTHER_LETTER */
    char BATAK_LETTER_SA = '\u1BD8';
    /** ᯙ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_SA = '\u1BD9';
    /** ᯚ of type OTHER_LETTER */
    char BATAK_LETTER_MANDAILING_SA = '\u1BDA';
    /** ᯛ of type OTHER_LETTER */
    char BATAK_LETTER_YA = '\u1BDB';
    /** ᯜ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_YA = '\u1BDC';
    /** ᯝ of type OTHER_LETTER */
    char BATAK_LETTER_NGA = '\u1BDD';
    /** ᯞ of type OTHER_LETTER */
    char BATAK_LETTER_LA = '\u1BDE';
    /** ᯟ of type OTHER_LETTER */
    char BATAK_LETTER_SIMALUNGUN_LA = '\u1BDF';
    /** ᯠ of type OTHER_LETTER */
    char BATAK_LETTER_NYA = '\u1BE0';
    /** ᯡ of type OTHER_LETTER */
    char BATAK_LETTER_CA = '\u1BE1';
    /** ᯢ of type OTHER_LETTER */
    char BATAK_LETTER_NDA = '\u1BE2';
    /** ᯣ of type OTHER_LETTER */
    char BATAK_LETTER_MBA = '\u1BE3';
    /** ᯤ of type OTHER_LETTER */
    char BATAK_LETTER_I = '\u1BE4';
    /** ᯥ of type OTHER_LETTER */
    char BATAK_LETTER_U = '\u1BE5';
    /** ᯦ of type NON_SPACING_MARK */
    char BATAK_SIGN_TOMPI = '\u1BE6';
    /** ᯧ of type COMBINING_SPACING_MARK */
    char BATAK_VOWEL_SIGN_E = '\u1BE7';
    /** ᯨ of type NON_SPACING_MARK */
    char BATAK_VOWEL_SIGN_PAKPAK_E = '\u1BE8';
    /** ᯩ of type NON_SPACING_MARK */
    char BATAK_VOWEL_SIGN_EE = '\u1BE9';
    /** ᯪ of type COMBINING_SPACING_MARK */
    char BATAK_VOWEL_SIGN_I = '\u1BEA';
    /** ᯫ of type COMBINING_SPACING_MARK */
    char BATAK_VOWEL_SIGN_KARO_I = '\u1BEB';
    /** ᯬ of type COMBINING_SPACING_MARK */
    char BATAK_VOWEL_SIGN_O = '\u1BEC';
    /** ᯭ of type NON_SPACING_MARK */
    char BATAK_VOWEL_SIGN_KARO_O = '\u1BED';
    /** ᯮ of type COMBINING_SPACING_MARK */
    char BATAK_VOWEL_SIGN_U = '\u1BEE';
    /** ᯯ of type NON_SPACING_MARK */
    char BATAK_VOWEL_SIGN_U_FOR_SIMALUNGUN_SA = '\u1BEF';
    /** ᯰ of type NON_SPACING_MARK */
    char BATAK_CONSONANT_SIGN_NG = '\u1BF0';
    /** ᯱ of type NON_SPACING_MARK */
    char BATAK_CONSONANT_SIGN_H = '\u1BF1';
    /** ᯲ of type COMBINING_SPACING_MARK */
    char BATAK_PANGOLAT = '\u1BF2';
    /** ᯳ of type COMBINING_SPACING_MARK */
    char BATAK_PANONGONAN = '\u1BF3';
    /** ᯼ of type OTHER_PUNCTUATION */
    char BATAK_SYMBOL_BINDU_NA_METEK = '\u1BFC';
    /** ᯽ of type OTHER_PUNCTUATION */
    char BATAK_SYMBOL_BINDU_PINARBORAS = '\u1BFD';
    /** ᯾ of type OTHER_PUNCTUATION */
    char BATAK_SYMBOL_BINDU_JUDUL = '\u1BFE';
    /** ᯿ of type OTHER_PUNCTUATION */
    char BATAK_SYMBOL_BINDU_PANGOLAT = '\u1BFF';
    /** ᰀ of type OTHER_LETTER */
    char LEPCHA_LETTER_KA = '\u1C00';
    /** ᰁ of type OTHER_LETTER */
    char LEPCHA_LETTER_KLA = '\u1C01';
    /** ᰂ of type OTHER_LETTER */
    char LEPCHA_LETTER_KHA = '\u1C02';
    /** ᰃ of type OTHER_LETTER */
    char LEPCHA_LETTER_GA = '\u1C03';
    /** ᰄ of type OTHER_LETTER */
    char LEPCHA_LETTER_GLA = '\u1C04';
    /** ᰅ of type OTHER_LETTER */
    char LEPCHA_LETTER_NGA = '\u1C05';
    /** ᰆ of type OTHER_LETTER */
    char LEPCHA_LETTER_CA = '\u1C06';
    /** ᰇ of type OTHER_LETTER */
    char LEPCHA_LETTER_CHA = '\u1C07';
    /** ᰈ of type OTHER_LETTER */
    char LEPCHA_LETTER_JA = '\u1C08';
    /** ᰉ of type OTHER_LETTER */
    char LEPCHA_LETTER_NYA = '\u1C09';
    /** ᰊ of type OTHER_LETTER */
    char LEPCHA_LETTER_TA = '\u1C0A';
    /** ᰋ of type OTHER_LETTER */
    char LEPCHA_LETTER_THA = '\u1C0B';
    /** ᰌ of type OTHER_LETTER */
    char LEPCHA_LETTER_DA = '\u1C0C';
    /** ᰍ of type OTHER_LETTER */
    char LEPCHA_LETTER_NA = '\u1C0D';
    /** ᰎ of type OTHER_LETTER */
    char LEPCHA_LETTER_PA = '\u1C0E';
    /** ᰏ of type OTHER_LETTER */
    char LEPCHA_LETTER_PLA = '\u1C0F';
    /** ᰐ of type OTHER_LETTER */
    char LEPCHA_LETTER_PHA = '\u1C10';
    /** ᰑ of type OTHER_LETTER */
    char LEPCHA_LETTER_FA = '\u1C11';
    /** ᰒ of type OTHER_LETTER */
    char LEPCHA_LETTER_FLA = '\u1C12';
    /** ᰓ of type OTHER_LETTER */
    char LEPCHA_LETTER_BA = '\u1C13';
    /** ᰔ of type OTHER_LETTER */
    char LEPCHA_LETTER_BLA = '\u1C14';
    /** ᰕ of type OTHER_LETTER */
    char LEPCHA_LETTER_MA = '\u1C15';
    /** ᰖ of type OTHER_LETTER */
    char LEPCHA_LETTER_MLA = '\u1C16';
    /** ᰗ of type OTHER_LETTER */
    char LEPCHA_LETTER_TSA = '\u1C17';
    /** ᰘ of type OTHER_LETTER */
    char LEPCHA_LETTER_TSHA = '\u1C18';
    /** ᰙ of type OTHER_LETTER */
    char LEPCHA_LETTER_DZA = '\u1C19';
    /** ᰚ of type OTHER_LETTER */
    char LEPCHA_LETTER_YA = '\u1C1A';
    /** ᰛ of type OTHER_LETTER */
    char LEPCHA_LETTER_RA = '\u1C1B';
    /** ᰜ of type OTHER_LETTER */
    char LEPCHA_LETTER_LA = '\u1C1C';
    /** ᰝ of type OTHER_LETTER */
    char LEPCHA_LETTER_HA = '\u1C1D';
    /** ᰞ of type OTHER_LETTER */
    char LEPCHA_LETTER_HLA = '\u1C1E';
    /** ᰟ of type OTHER_LETTER */
    char LEPCHA_LETTER_VA = '\u1C1F';
    /** ᰠ of type OTHER_LETTER */
    char LEPCHA_LETTER_SA = '\u1C20';
    /** ᰡ of type OTHER_LETTER */
    char LEPCHA_LETTER_SHA = '\u1C21';
    /** ᰢ of type OTHER_LETTER */
    char LEPCHA_LETTER_WA = '\u1C22';
    /** ᰣ of type OTHER_LETTER */
    char LEPCHA_LETTER_A = '\u1C23';
    /** ᰤ of type COMBINING_SPACING_MARK */
    char LEPCHA_SUBJOINED_LETTER_YA = '\u1C24';
    /** ᰥ of type COMBINING_SPACING_MARK */
    char LEPCHA_SUBJOINED_LETTER_RA = '\u1C25';
    /** ᰦ of type COMBINING_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_AA = '\u1C26';
    /** ᰧ of type COMBINING_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_I = '\u1C27';
    /** ᰨ of type COMBINING_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_O = '\u1C28';
    /** ᰩ of type COMBINING_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_OO = '\u1C29';
    /** ᰪ of type COMBINING_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_U = '\u1C2A';
    /** ᰫ of type COMBINING_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_UU = '\u1C2B';
    /** ᰬ of type NON_SPACING_MARK */
    char LEPCHA_VOWEL_SIGN_E = '\u1C2C';
    /** ᰭ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_K = '\u1C2D';
    /** ᰮ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_M = '\u1C2E';
    /** ᰯ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_L = '\u1C2F';
    /** ᰰ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_N = '\u1C30';
    /** ᰱ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_P = '\u1C31';
    /** ᰲ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_R = '\u1C32';
    /** ᰳ of type NON_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_T = '\u1C33';
    /** ᰴ of type COMBINING_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_NYIN_DO = '\u1C34';
    /** ᰵ of type COMBINING_SPACING_MARK */
    char LEPCHA_CONSONANT_SIGN_KANG = '\u1C35';
    /** ᰶ of type NON_SPACING_MARK */
    char LEPCHA_SIGN_RAN = '\u1C36';
    /** ᰷ of type NON_SPACING_MARK */
    char LEPCHA_SIGN_NUKTA = '\u1C37';
    /** ᰻ of type OTHER_PUNCTUATION */
    char LEPCHA_PUNCTUATION_TA_ROL = '\u1C3B';
    /** ᰼ of type OTHER_PUNCTUATION */
    char LEPCHA_PUNCTUATION_NYET_THYOOM_TA_ROL = '\u1C3C';
    /** ᰽ of type OTHER_PUNCTUATION */
    char LEPCHA_PUNCTUATION_CER_WA = '\u1C3D';
    /** ᰾ of type OTHER_PUNCTUATION */
    char LEPCHA_PUNCTUATION_TSHOOK_CER_WA = '\u1C3E';
    /** ᰿ of type OTHER_PUNCTUATION */
    char LEPCHA_PUNCTUATION_TSHOOK = '\u1C3F';
    /** ᱀ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_ZERO = '\u1C40';
    /** ᱁ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_ONE = '\u1C41';
    /** ᱂ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_TWO = '\u1C42';
    /** ᱃ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_THREE = '\u1C43';
    /** ᱄ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_FOUR = '\u1C44';
    /** ᱅ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_FIVE = '\u1C45';
    /** ᱆ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_SIX = '\u1C46';
    /** ᱇ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_SEVEN = '\u1C47';
    /** ᱈ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_EIGHT = '\u1C48';
    /** ᱉ of type DECIMAL_DIGIT_NUMBER */
    char LEPCHA_DIGIT_NINE = '\u1C49';
    /** ᱍ of type OTHER_LETTER */
    char LEPCHA_LETTER_TTA = '\u1C4D';
    /** ᱎ of type OTHER_LETTER */
    char LEPCHA_LETTER_TTHA = '\u1C4E';
    /** ᱏ of type OTHER_LETTER */
    char LEPCHA_LETTER_DDA = '\u1C4F';
    /** ᱐ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_ZERO = '\u1C50';
    /** ᱑ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_ONE = '\u1C51';
    /** ᱒ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_TWO = '\u1C52';
    /** ᱓ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_THREE = '\u1C53';
    /** ᱔ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_FOUR = '\u1C54';
    /** ᱕ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_FIVE = '\u1C55';
    /** ᱖ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_SIX = '\u1C56';
    /** ᱗ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_SEVEN = '\u1C57';
    /** ᱘ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_EIGHT = '\u1C58';
    /** ᱙ of type DECIMAL_DIGIT_NUMBER */
    char OL_CHIKI_DIGIT_NINE = '\u1C59';
    /** ᱚ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_LA = '\u1C5A';
    /** ᱛ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AT = '\u1C5B';
    /** ᱜ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AG = '\u1C5C';
    /** ᱝ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_ANG = '\u1C5D';
    /** ᱞ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AL = '\u1C5E';
    /** ᱟ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_LAA = '\u1C5F';
    /** ᱠ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AAK = '\u1C60';
    /** ᱡ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AAJ = '\u1C61';
    /** ᱢ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AAM = '\u1C62';
    /** ᱣ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_AAW = '\u1C63';
    /** ᱤ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_LI = '\u1C64';
    /** ᱥ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_IS = '\u1C65';
    /** ᱦ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_IH = '\u1C66';
    /** ᱧ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_INY = '\u1C67';
    /** ᱨ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_IR = '\u1C68';
    /** ᱩ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_LU = '\u1C69';
    /** ᱪ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_UC = '\u1C6A';
    /** ᱫ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_UD = '\u1C6B';
    /** ᱬ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_UNN = '\u1C6C';
    /** ᱭ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_UY = '\u1C6D';
    /** ᱮ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_LE = '\u1C6E';
    /** ᱯ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_EP = '\u1C6F';
    /** ᱰ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_EDD = '\u1C70';
    /** ᱱ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_EN = '\u1C71';
    /** ᱲ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_ERR = '\u1C72';
    /** ᱳ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_LO = '\u1C73';
    /** ᱴ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_OTT = '\u1C74';
    /** ᱵ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_OB = '\u1C75';
    /** ᱶ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_OV = '\u1C76';
    /** ᱷ of type OTHER_LETTER */
    char OL_CHIKI_LETTER_OH = '\u1C77';
    /** ᱸ of type MODIFIER_LETTER */
    char OL_CHIKI_MU_TTUDDAG = '\u1C78';
    /** ᱹ of type MODIFIER_LETTER */
    char OL_CHIKI_GAAHLAA_TTUDDAAG = '\u1C79';
    /** ᱺ of type MODIFIER_LETTER */
    char OL_CHIKI_MU_GAAHLAA_TTUDDAAG = '\u1C7A';
    /** ᱻ of type MODIFIER_LETTER */
    char OL_CHIKI_RELAA = '\u1C7B';
    /** ᱼ of type MODIFIER_LETTER */
    char OL_CHIKI_PHAARKAA = '\u1C7C';
    /** ᱽ of type MODIFIER_LETTER */
    char OL_CHIKI_AHAD = '\u1C7D';
    /** ᱾ of type OTHER_PUNCTUATION */
    char OL_CHIKI_PUNCTUATION_MUCAAD = '\u1C7E';
    /** ᱿ of type OTHER_PUNCTUATION */
    char OL_CHIKI_PUNCTUATION_DOUBLE_MUCAAD = '\u1C7F';
    /** ᳐ of type NON_SPACING_MARK */
    char VEDIC_TONE_KARSHANA = '\u1CD0';
    /** ᳑ of type NON_SPACING_MARK */
    char VEDIC_TONE_SHARA = '\u1CD1';
    /** ᳒ of type NON_SPACING_MARK */
    char VEDIC_TONE_PRENKHA = '\u1CD2';
    /** ᳓ of type OTHER_PUNCTUATION */
    char VEDIC_SIGN_NIHSHVASA = '\u1CD3';
    /** ᳔ of type NON_SPACING_MARK */
    char VEDIC_SIGN_YAJURVEDIC_MIDLINE_SVARITA = '\u1CD4';
    /** ᳕ of type NON_SPACING_MARK */
    char VEDIC_TONE_YAJURVEDIC_AGGRAVATED_INDEPENDENT_SVARITA = '\u1CD5';
    /** ᳖ of type NON_SPACING_MARK */
    char VEDIC_TONE_YAJURVEDIC_INDEPENDENT_SVARITA = '\u1CD6';
    /** ᳗ of type NON_SPACING_MARK */
    char VEDIC_TONE_YAJURVEDIC_KATHAKA_INDEPENDENT_SVARITA = '\u1CD7';
    /** ᳘ of type NON_SPACING_MARK */
    char VEDIC_TONE_CANDRA_BELOW = '\u1CD8';
    /** ᳙ of type NON_SPACING_MARK */
    char VEDIC_TONE_YAJURVEDIC_KATHAKA_INDEPENDENT_SVARITA_SCHROEDER = '\u1CD9';
    /** ᳚ of type NON_SPACING_MARK */
    char VEDIC_TONE_DOUBLE_SVARITA = '\u1CDA';
    /** ᳛ of type NON_SPACING_MARK */
    char VEDIC_TONE_TRIPLE_SVARITA = '\u1CDB';
    /** ᳜ of type NON_SPACING_MARK */
    char VEDIC_TONE_KATHAKA_ANUDATTA = '\u1CDC';
    /** ᳝ of type NON_SPACING_MARK */
    char VEDIC_TONE_DOT_BELOW = '\u1CDD';
    /** ᳞ of type NON_SPACING_MARK */
    char VEDIC_TONE_TWO_DOTS_BELOW = '\u1CDE';
    /** ᳟ of type NON_SPACING_MARK */
    char VEDIC_TONE_THREE_DOTS_BELOW = '\u1CDF';
    /** ᳠ of type NON_SPACING_MARK */
    char VEDIC_TONE_RIGVEDIC_KASHMIRI_INDEPENDENT_SVARITA = '\u1CE0';
    /** ᳡ of type COMBINING_SPACING_MARK */
    char VEDIC_TONE_ATHARVAVEDIC_INDEPENDENT_SVARITA = '\u1CE1';
    /** ᳢ of type NON_SPACING_MARK */
    char VEDIC_SIGN_VISARGA_SVARITA = '\u1CE2';
    /** ᳣ of type NON_SPACING_MARK */
    char VEDIC_SIGN_VISARGA_UDATTA = '\u1CE3';
    /** ᳤ of type NON_SPACING_MARK */
    char VEDIC_SIGN_REVERSED_VISARGA_UDATTA = '\u1CE4';
    /** ᳥ of type NON_SPACING_MARK */
    char VEDIC_SIGN_VISARGA_ANUDATTA = '\u1CE5';
    /** ᳦ of type NON_SPACING_MARK */
    char VEDIC_SIGN_REVERSED_VISARGA_ANUDATTA = '\u1CE6';
    /** ᳧ of type NON_SPACING_MARK */
    char VEDIC_SIGN_VISARGA_UDATTA_WITH_TAIL = '\u1CE7';
    /** ᳨ of type NON_SPACING_MARK */
    char VEDIC_SIGN_VISARGA_ANUDATTA_WITH_TAIL = '\u1CE8';
    /** ᳩ of type OTHER_LETTER */
    char VEDIC_SIGN_ANUSVARA_ANTARGOMUKHA = '\u1CE9';
    /** ᳪ of type OTHER_LETTER */
    char VEDIC_SIGN_ANUSVARA_BAHIRGOMUKHA = '\u1CEA';
    /** ᳫ of type OTHER_LETTER */
    char VEDIC_SIGN_ANUSVARA_VAMAGOMUKHA = '\u1CEB';
    /** ᳬ of type OTHER_LETTER */
    char VEDIC_SIGN_ANUSVARA_VAMAGOMUKHA_WITH_TAIL = '\u1CEC';
    /** ᳭ of type NON_SPACING_MARK */
    char VEDIC_SIGN_TIRYAK = '\u1CED';
    /** ᳮ of type OTHER_LETTER */
    char VEDIC_SIGN_HEXIFORM_LONG_ANUSVARA = '\u1CEE';
    /** ᳯ of type OTHER_LETTER */
    char VEDIC_SIGN_LONG_ANUSVARA = '\u1CEF';
    /** ᳰ of type OTHER_LETTER */
    char VEDIC_SIGN_RTHANG_LONG_ANUSVARA = '\u1CF0';
    /** ᳱ of type OTHER_LETTER */
    char VEDIC_SIGN_ANUSVARA_UBHAYATO_MUKHA = '\u1CF1';
    /** ᳲ of type COMBINING_SPACING_MARK */
    char VEDIC_SIGN_ARDHAVISARGA = '\u1CF2';
    /** ᳳ of type COMBINING_SPACING_MARK */
    char VEDIC_SIGN_ROTATED_ARDHAVISARGA = '\u1CF3';
    /** ᳴ of type NON_SPACING_MARK */
    char VEDIC_TONE_CANDRA_ABOVE = '\u1CF4';
    /** ᳵ of type OTHER_LETTER */
    char VEDIC_SIGN_JIHVAMULIYA = '\u1CF5';
    /** ᳶ of type OTHER_LETTER */
    char VEDIC_SIGN_UPADHMANIYA = '\u1CF6';
    /** ᴬ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_A = '\u1D2C';
    /** ᴭ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_AE = '\u1D2D';
    /** ᴮ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_B = '\u1D2E';
    /** ᴯ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_BARRED_B = '\u1D2F';
    /** ᴰ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_D = '\u1D30';
    /** ᴱ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_E = '\u1D31';
    /** ᴲ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_REVERSED_E = '\u1D32';
    /** ᴳ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_G = '\u1D33';
    /** ᴴ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_H = '\u1D34';
    /** ᴵ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_I = '\u1D35';
    /** ᴶ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_J = '\u1D36';
    /** ᴷ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_K = '\u1D37';
    /** ᴸ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_L = '\u1D38';
    /** ᴹ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_M = '\u1D39';
    /** ᴺ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_N = '\u1D3A';
    /** ᴻ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_REVERSED_N = '\u1D3B';
    /** ᴼ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_O = '\u1D3C';
    /** ᴽ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_OU = '\u1D3D';
    /** ᴾ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_P = '\u1D3E';
    /** ᴿ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_R = '\u1D3F';
    /** ᵀ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_T = '\u1D40';
    /** ᵁ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_U = '\u1D41';
    /** ᵂ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_W = '\u1D42';
    /** ᵃ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_A = '\u1D43';
    /** ᵄ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_A = '\u1D44';
    /** ᵅ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_ALPHA = '\u1D45';
    /** ᵆ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_AE = '\u1D46';
    /** ᵇ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_B = '\u1D47';
    /** ᵈ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_D = '\u1D48';
    /** ᵉ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_E = '\u1D49';
    /** ᵊ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_SCHWA = '\u1D4A';
    /** ᵋ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_OPEN_E = '\u1D4B';
    /** ᵌ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_OPEN_E = '\u1D4C';
    /** ᵍ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_G = '\u1D4D';
    /** ᵎ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_I = '\u1D4E';
    /** ᵏ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_K = '\u1D4F';
    /** ᵐ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_M = '\u1D50';
    /** ᵑ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_ENG = '\u1D51';
    /** ᵒ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_O = '\u1D52';
    /** ᵓ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_OPEN_O = '\u1D53';
    /** ᵔ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TOP_HALF_O = '\u1D54';
    /** ᵕ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_BOTTOM_HALF_O = '\u1D55';
    /** ᵖ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_P = '\u1D56';
    /** ᵗ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_T = '\u1D57';
    /** ᵘ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_U = '\u1D58';
    /** ᵙ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_SIDEWAYS_U = '\u1D59';
    /** ᵚ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_M = '\u1D5A';
    /** ᵛ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_V = '\u1D5B';
    /** ᵜ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_AIN = '\u1D5C';
    /** ᵝ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_BETA = '\u1D5D';
    /** ᵞ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_GREEK_GAMMA = '\u1D5E';
    /** ᵟ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_DELTA = '\u1D5F';
    /** ᵠ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_GREEK_PHI = '\u1D60';
    /** ᵡ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CHI = '\u1D61';
    /** ᵸ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CYRILLIC_EN = '\u1D78';
    /** ᶛ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_ALPHA = '\u1D9B';
    /** ᶜ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_C = '\u1D9C';
    /** ᶝ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_C_WITH_CURL = '\u1D9D';
    /** ᶞ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_ETH = '\u1D9E';
    /** ᶟ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_REVERSED_OPEN_E = '\u1D9F';
    /** ᶠ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_F = '\u1DA0';
    /** ᶡ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_DOTLESS_J_WITH_STROKE = '\u1DA1';
    /** ᶢ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_SCRIPT_G = '\u1DA2';
    /** ᶣ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_H = '\u1DA3';
    /** ᶤ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_I_WITH_STROKE = '\u1DA4';
    /** ᶥ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_IOTA = '\u1DA5';
    /** ᶦ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CAPITAL_I = '\u1DA6';
    /** ᶧ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CAPITAL_I_WITH_STROKE = '\u1DA7';
    /** ᶨ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_J_WITH_CROSSED_TAIL = '\u1DA8';
    /** ᶩ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_L_WITH_RETROFLEX_HOOK = '\u1DA9';
    /** ᶪ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_L_WITH_PALATAL_HOOK = '\u1DAA';
    /** ᶫ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CAPITAL_L = '\u1DAB';
    /** ᶬ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_M_WITH_HOOK = '\u1DAC';
    /** ᶭ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_M_WITH_LONG_LEG = '\u1DAD';
    /** ᶮ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_N_WITH_LEFT_HOOK = '\u1DAE';
    /** ᶯ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_N_WITH_RETROFLEX_HOOK = '\u1DAF';
    /** ᶰ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CAPITAL_N = '\u1DB0';
    /** ᶱ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_BARRED_O = '\u1DB1';
    /** ᶲ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_PHI = '\u1DB2';
    /** ᶳ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_S_WITH_HOOK = '\u1DB3';
    /** ᶴ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_ESH = '\u1DB4';
    /** ᶵ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_T_WITH_PALATAL_HOOK = '\u1DB5';
    /** ᶶ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_U_BAR = '\u1DB6';
    /** ᶷ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_UPSILON = '\u1DB7';
    /** ᶸ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_CAPITAL_U = '\u1DB8';
    /** ᶹ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_V_WITH_HOOK = '\u1DB9';
    /** ᶺ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_TURNED_V = '\u1DBA';
    /** ᶻ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_Z = '\u1DBB';
    /** ᶼ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_Z_WITH_RETROFLEX_HOOK = '\u1DBC';
    /** ᶽ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_Z_WITH_CURL = '\u1DBD';
    /** ᶾ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_EZH = '\u1DBE';
    /** ᶿ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_THETA = '\u1DBF';
    /**   of type SPACE_SEPARATOR */
    char EN_QUAD = '\u2000';
    /**   of type SPACE_SEPARATOR */
    char EM_QUAD = '\u2001';
    /**   of type SPACE_SEPARATOR */
    char EN_SPACE = '\u2002';
    /**   of type SPACE_SEPARATOR */
    char EM_SPACE = '\u2003';
    /**   of type SPACE_SEPARATOR */
    char THREE_PER_EM_SPACE = '\u2004';
    /**   of type SPACE_SEPARATOR */
    char FOUR_PER_EM_SPACE = '\u2005';
    /**   of type SPACE_SEPARATOR */
    char SIX_PER_EM_SPACE = '\u2006';
    /**   of type SPACE_SEPARATOR */
    char FIGURE_SPACE = '\u2007';
    /**   of type SPACE_SEPARATOR */
    char PUNCTUATION_SPACE = '\u2008';
    /**   of type SPACE_SEPARATOR */
    char THIN_SPACE = '\u2009';
    /**   of type SPACE_SEPARATOR */
    char HAIR_SPACE = '\u200A';
    /** ​ of type FORMAT */
    char ZERO_WIDTH_SPACE = '\u200B';
    /** ‌ of type FORMAT */
    char ZERO_WIDTH_NON_JOINER = '\u200C';
    /** ‍ of type FORMAT */
    char ZERO_WIDTH_JOINER = '\u200D';
    /** ‎ of type FORMAT */
    char LEFT_TO_RIGHT_MARK = '\u200E';
    /** ‏ of type FORMAT */
    char RIGHT_TO_LEFT_MARK = '\u200F';
    /** ‐ of type DASH_PUNCTUATION */
    char HYPHEN = '\u2010';
    /** ‑ of type DASH_PUNCTUATION */
    char NON_BREAKING_HYPHEN = '\u2011';
    /** ‒ of type DASH_PUNCTUATION */
    char FIGURE_DASH = '\u2012';
    /** – of type DASH_PUNCTUATION */
    char EN_DASH = '\u2013';
    /** — of type DASH_PUNCTUATION */
    char EM_DASH = '\u2014';
    /** ― of type DASH_PUNCTUATION */
    char HORIZONTAL_BAR = '\u2015';
    /** ‖ of type OTHER_PUNCTUATION */
    char DOUBLE_VERTICAL_LINE = '\u2016';
    /** ‗ of type OTHER_PUNCTUATION */
    char DOUBLE_LOW_LINE = '\u2017';
    /** ‘ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_SINGLE_QUOTATION_MARK = '\u2018';
    /** ’ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_SINGLE_QUOTATION_MARK = '\u2019';
    /** ‚ of type START_PUNCTUATION */
    char SINGLE_LOW_9_QUOTATION_MARK = '\u201A';
    /** ‛ of type INITIAL_QUOTE_PUNCTUATION */
    char SINGLE_HIGH_REVERSED_9_QUOTATION_MARK = '\u201B';
    /** “ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_DOUBLE_QUOTATION_MARK = '\u201C';
    /** ” of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_DOUBLE_QUOTATION_MARK = '\u201D';
    /** „ of type START_PUNCTUATION */
    char DOUBLE_LOW_9_QUOTATION_MARK = '\u201E';
    /** ‟ of type INITIAL_QUOTE_PUNCTUATION */
    char DOUBLE_HIGH_REVERSED_9_QUOTATION_MARK = '\u201F';
    /** † of type OTHER_PUNCTUATION */
    char DAGGER = '\u2020';
    /** ‡ of type OTHER_PUNCTUATION */
    char DOUBLE_DAGGER = '\u2021';
    /** • of type OTHER_PUNCTUATION */
    char BULLET = '\u2022';
    /** ‣ of type OTHER_PUNCTUATION */
    char TRIANGULAR_BULLET = '\u2023';
    /** ․ of type OTHER_PUNCTUATION */
    char ONE_DOT_LEADER = '\u2024';
    /** ‥ of type OTHER_PUNCTUATION */
    char TWO_DOT_LEADER = '\u2025';
    /** … of type OTHER_PUNCTUATION */
    char HORIZONTAL_ELLIPSIS = '\u2026';
    /** ‧ of type OTHER_PUNCTUATION */
    char HYPHENATION_POINT = '\u2027';
    /** 
 of type LINE_SEPARATOR */
    char LINE_SEPARATOR = '\u2028';
    /** 
 of type PARAGRAPH_SEPARATOR */
    char PARAGRAPH_SEPARATOR = '\u2029';
    /** ‪ of type FORMAT */
    char LEFT_TO_RIGHT_EMBEDDING = '\u202A';
    /** ‫ of type FORMAT */
    char RIGHT_TO_LEFT_EMBEDDING = '\u202B';
    /** ‬ of type FORMAT */
    char POP_DIRECTIONAL_FORMATTING = '\u202C';
    /** ‭ of type FORMAT */
    char LEFT_TO_RIGHT_OVERRIDE = '\u202D';
    /** ‮ of type FORMAT */
    char RIGHT_TO_LEFT_OVERRIDE = '\u202E';
    /**   of type SPACE_SEPARATOR */
    char NARROW_NO_BREAK_SPACE = '\u202F';
    /** ‰ of type OTHER_PUNCTUATION */
    char PER_MILLE_SIGN = '\u2030';
    /** ‱ of type OTHER_PUNCTUATION */
    char PER_TEN_THOUSAND_SIGN = '\u2031';
    /** ′ of type OTHER_PUNCTUATION */
    char PRIME = '\u2032';
    /** ″ of type OTHER_PUNCTUATION */
    char DOUBLE_PRIME = '\u2033';
    /** ‴ of type OTHER_PUNCTUATION */
    char TRIPLE_PRIME = '\u2034';
    /** ‵ of type OTHER_PUNCTUATION */
    char REVERSED_PRIME = '\u2035';
    /** ‶ of type OTHER_PUNCTUATION */
    char REVERSED_DOUBLE_PRIME = '\u2036';
    /** ‷ of type OTHER_PUNCTUATION */
    char REVERSED_TRIPLE_PRIME = '\u2037';
    /** ‸ of type OTHER_PUNCTUATION */
    char CARET = '\u2038';
    /** ‹ of type INITIAL_QUOTE_PUNCTUATION */
    char SINGLE_LEFT_POINTING_ANGLE_QUOTATION_MARK = '\u2039';
    /** › of type FINAL_QUOTE_PUNCTUATION */
    char SINGLE_RIGHT_POINTING_ANGLE_QUOTATION_MARK = '\u203A';
    /** ※ of type OTHER_PUNCTUATION */
    char REFERENCE_MARK = '\u203B';
    /** ‼ of type OTHER_PUNCTUATION */
    char DOUBLE_EXCLAMATION_MARK = '\u203C';
    /** ‽ of type OTHER_PUNCTUATION */
    char INTERROBANG = '\u203D';
    /** ‾ of type OTHER_PUNCTUATION */
    char OVERLINE = '\u203E';
    /** ‿ of type CONNECTOR_PUNCTUATION */
    char UNDERTIE = '\u203F';
    /** ⁀ of type CONNECTOR_PUNCTUATION */
    char CHARACTER_TIE = '\u2040';
    /** ⁁ of type OTHER_PUNCTUATION */
    char CARET_INSERTION_POINT = '\u2041';
    /** ⁂ of type OTHER_PUNCTUATION */
    char ASTERISM = '\u2042';
    /** ⁃ of type OTHER_PUNCTUATION */
    char HYPHEN_BULLET = '\u2043';
    /** ⁄ of type MATH_SYMBOL */
    char FRACTION_SLASH = '\u2044';
    /** ⁅ of type START_PUNCTUATION */
    char LEFT_SQUARE_BRACKET_WITH_QUILL = '\u2045';
    /** ⁆ of type END_PUNCTUATION */
    char RIGHT_SQUARE_BRACKET_WITH_QUILL = '\u2046';
    /** ⁇ of type OTHER_PUNCTUATION */
    char DOUBLE_QUESTION_MARK = '\u2047';
    /** ⁈ of type OTHER_PUNCTUATION */
    char QUESTION_EXCLAMATION_MARK = '\u2048';
    /** ⁉ of type OTHER_PUNCTUATION */
    char EXCLAMATION_QUESTION_MARK = '\u2049';
    /** ⁊ of type OTHER_PUNCTUATION */
    char TIRONIAN_SIGN_ET = '\u204A';
    /** ⁋ of type OTHER_PUNCTUATION */
    char REVERSED_PILCROW_SIGN = '\u204B';
    /** ⁌ of type OTHER_PUNCTUATION */
    char BLACK_LEFTWARDS_BULLET = '\u204C';
    /** ⁍ of type OTHER_PUNCTUATION */
    char BLACK_RIGHTWARDS_BULLET = '\u204D';
    /** ⁎ of type OTHER_PUNCTUATION */
    char LOW_ASTERISK = '\u204E';
    /** ⁏ of type OTHER_PUNCTUATION */
    char REVERSED_SEMICOLON = '\u204F';
    /** ⁐ of type OTHER_PUNCTUATION */
    char CLOSE_UP = '\u2050';
    /** ⁑ of type OTHER_PUNCTUATION */
    char TWO_ASTERISKS_ALIGNED_VERTICALLY = '\u2051';
    /** ⁒ of type MATH_SYMBOL */
    char COMMERCIAL_MINUS_SIGN = '\u2052';
    /** ⁓ of type OTHER_PUNCTUATION */
    char SWUNG_DASH = '\u2053';
    /** ⁔ of type CONNECTOR_PUNCTUATION */
    char INVERTED_UNDERTIE = '\u2054';
    /** ⁕ of type OTHER_PUNCTUATION */
    char FLOWER_PUNCTUATION_MARK = '\u2055';
    /** ⁖ of type OTHER_PUNCTUATION */
    char THREE_DOT_PUNCTUATION = '\u2056';
    /** ⁗ of type OTHER_PUNCTUATION */
    char QUADRUPLE_PRIME = '\u2057';
    /** ⁘ of type OTHER_PUNCTUATION */
    char FOUR_DOT_PUNCTUATION = '\u2058';
    /** ⁙ of type OTHER_PUNCTUATION */
    char FIVE_DOT_PUNCTUATION = '\u2059';
    /** ⁚ of type OTHER_PUNCTUATION */
    char TWO_DOT_PUNCTUATION = '\u205A';
    /** ⁛ of type OTHER_PUNCTUATION */
    char FOUR_DOT_MARK = '\u205B';
    /** ⁜ of type OTHER_PUNCTUATION */
    char DOTTED_CROSS = '\u205C';
    /** ⁝ of type OTHER_PUNCTUATION */
    char TRICOLON = '\u205D';
    /** ⁞ of type OTHER_PUNCTUATION */
    char VERTICAL_FOUR_DOTS = '\u205E';
    /**   of type SPACE_SEPARATOR */
    char MEDIUM_MATHEMATICAL_SPACE = '\u205F';
    /** ⁠ of type FORMAT */
    char WORD_JOINER = '\u2060';
    /** ⁡ of type FORMAT */
    char FUNCTION_APPLICATION = '\u2061';
    /** ⁢ of type FORMAT */
    char INVISIBLE_TIMES = '\u2062';
    /** ⁣ of type FORMAT */
    char INVISIBLE_SEPARATOR = '\u2063';
    /** ⁤ of type FORMAT */
    char INVISIBLE_PLUS = '\u2064';
    /** ⁪ of type FORMAT */
    char INHIBIT_SYMMETRIC_SWAPPING = '\u206A';
    /** ⁫ of type FORMAT */
    char ACTIVATE_SYMMETRIC_SWAPPING = '\u206B';
    /** ⁬ of type FORMAT */
    char INHIBIT_ARABIC_FORM_SHAPING = '\u206C';
    /** ⁭ of type FORMAT */
    char ACTIVATE_ARABIC_FORM_SHAPING = '\u206D';
    /** ⁮ of type FORMAT */
    char NATIONAL_DIGIT_SHAPES = '\u206E';
    /** ⁯ of type FORMAT */
    char NOMINAL_DIGIT_SHAPES = '\u206F';
    /** ⁰ of type OTHER_NUMBER */
    char SUPERSCRIPT_ZERO = '\u2070';
    /** ⁱ of type MODIFIER_LETTER */
    char SUPERSCRIPT_LATIN_SMALL_LETTER_I = '\u2071';
    /** ⁴ of type OTHER_NUMBER */
    char SUPERSCRIPT_FOUR = '\u2074';
    /** ⁵ of type OTHER_NUMBER */
    char SUPERSCRIPT_FIVE = '\u2075';
    /** ⁶ of type OTHER_NUMBER */
    char SUPERSCRIPT_SIX = '\u2076';
    /** ⁷ of type OTHER_NUMBER */
    char SUPERSCRIPT_SEVEN = '\u2077';
    /** ⁸ of type OTHER_NUMBER */
    char SUPERSCRIPT_EIGHT = '\u2078';
    /** ⁹ of type OTHER_NUMBER */
    char SUPERSCRIPT_NINE = '\u2079';
    /** ⁺ of type MATH_SYMBOL */
    char SUPERSCRIPT_PLUS_SIGN = '\u207A';
    /** ⁻ of type MATH_SYMBOL */
    char SUPERSCRIPT_MINUS = '\u207B';
    /** ⁼ of type MATH_SYMBOL */
    char SUPERSCRIPT_EQUALS_SIGN = '\u207C';
    /** ⁽ of type START_PUNCTUATION */
    char SUPERSCRIPT_LEFT_PARENTHESIS = '\u207D';
    /** ⁾ of type END_PUNCTUATION */
    char SUPERSCRIPT_RIGHT_PARENTHESIS = '\u207E';
    /** ⁿ of type MODIFIER_LETTER */
    char SUPERSCRIPT_LATIN_SMALL_LETTER_N = '\u207F';
    /** ₀ of type OTHER_NUMBER */
    char SUBSCRIPT_ZERO = '\u2080';
    /** ₁ of type OTHER_NUMBER */
    char SUBSCRIPT_ONE = '\u2081';
    /** ₂ of type OTHER_NUMBER */
    char SUBSCRIPT_TWO = '\u2082';
    /** ₃ of type OTHER_NUMBER */
    char SUBSCRIPT_THREE = '\u2083';
    /** ₄ of type OTHER_NUMBER */
    char SUBSCRIPT_FOUR = '\u2084';
    /** ₅ of type OTHER_NUMBER */
    char SUBSCRIPT_FIVE = '\u2085';
    /** ₆ of type OTHER_NUMBER */
    char SUBSCRIPT_SIX = '\u2086';
    /** ₇ of type OTHER_NUMBER */
    char SUBSCRIPT_SEVEN = '\u2087';
    /** ₈ of type OTHER_NUMBER */
    char SUBSCRIPT_EIGHT = '\u2088';
    /** ₉ of type OTHER_NUMBER */
    char SUBSCRIPT_NINE = '\u2089';
    /** ₊ of type MATH_SYMBOL */
    char SUBSCRIPT_PLUS_SIGN = '\u208A';
    /** ₋ of type MATH_SYMBOL */
    char SUBSCRIPT_MINUS = '\u208B';
    /** ₌ of type MATH_SYMBOL */
    char SUBSCRIPT_EQUALS_SIGN = '\u208C';
    /** ₍ of type START_PUNCTUATION */
    char SUBSCRIPT_LEFT_PARENTHESIS = '\u208D';
    /** ₎ of type END_PUNCTUATION */
    char SUBSCRIPT_RIGHT_PARENTHESIS = '\u208E';
    /** ₠ of type CURRENCY_SYMBOL */
    char EURO_CURRENCY_SIGN = '\u20A0';
    /** ₡ of type CURRENCY_SYMBOL */
    char COLON_SIGN = '\u20A1';
    /** ₢ of type CURRENCY_SYMBOL */
    char CRUZEIRO_SIGN = '\u20A2';
    /** ₣ of type CURRENCY_SYMBOL */
    char FRENCH_FRANC_SIGN = '\u20A3';
    /** ₤ of type CURRENCY_SYMBOL */
    char LIRA_SIGN = '\u20A4';
    /** ₥ of type CURRENCY_SYMBOL */
    char MILL_SIGN = '\u20A5';
    /** ₦ of type CURRENCY_SYMBOL */
    char NAIRA_SIGN = '\u20A6';
    /** ₧ of type CURRENCY_SYMBOL */
    char PESETA_SIGN = '\u20A7';
    /** ₨ of type CURRENCY_SYMBOL */
    char RUPEE_SIGN = '\u20A8';
    /** ₩ of type CURRENCY_SYMBOL */
    char WON_SIGN = '\u20A9';
    /** ₪ of type CURRENCY_SYMBOL */
    char NEW_SHEQEL_SIGN = '\u20AA';
    /** ₫ of type CURRENCY_SYMBOL */
    char DONG_SIGN = '\u20AB';
    /** € of type CURRENCY_SYMBOL */
    char EURO_SIGN = '\u20AC';
    /** ₭ of type CURRENCY_SYMBOL */
    char KIP_SIGN = '\u20AD';
    /** ₮ of type CURRENCY_SYMBOL */
    char TUGRIK_SIGN = '\u20AE';
    /** ₯ of type CURRENCY_SYMBOL */
    char DRACHMA_SIGN = '\u20AF';
    /** ₰ of type CURRENCY_SYMBOL */
    char GERMAN_PENNY_SIGN = '\u20B0';
    /** ₱ of type CURRENCY_SYMBOL */
    char PESO_SIGN = '\u20B1';
    /** ₲ of type CURRENCY_SYMBOL */
    char GUARANI_SIGN = '\u20B2';
    /** ₳ of type CURRENCY_SYMBOL */
    char AUSTRAL_SIGN = '\u20B3';
    /** ₴ of type CURRENCY_SYMBOL */
    char HRYVNIA_SIGN = '\u20B4';
    /** ₵ of type CURRENCY_SYMBOL */
    char CEDI_SIGN = '\u20B5';
    /** ₶ of type CURRENCY_SYMBOL */
    char LIVRE_TOURNOIS_SIGN = '\u20B6';
    /** ₷ of type CURRENCY_SYMBOL */
    char SPESMILO_SIGN = '\u20B7';
    /** ₸ of type CURRENCY_SYMBOL */
    char TENGE_SIGN = '\u20B8';
    /** ₹ of type CURRENCY_SYMBOL */
    char INDIAN_RUPEE_SIGN = '\u20B9';
    /** ₺ of type CURRENCY_SYMBOL */
    char TURKISH_LIRA_SIGN = '\u20BA';
    /** ₻ of type CURRENCY_SYMBOL */
    char NORDIC_MARK_SIGN = '\u20BB';
    /** ₼ of type CURRENCY_SYMBOL */
    char MANAT_SIGN = '\u20BC';
    /** ₽ of type CURRENCY_SYMBOL */
    char RUBLE_SIGN = '\u20BD';
    /** ₾ of type CURRENCY_SYMBOL */
    char LARI_SIGN = '\u20BE';
    /** ₿ of type CURRENCY_SYMBOL */
    char BITCOIN_SIGN = '\u20BF';
    /** ℀ of type OTHER_SYMBOL */
    char ACCOUNT_OF = '\u2100';
    /** ℁ of type OTHER_SYMBOL */
    char ADDRESSED_TO_THE_SUBJECT = '\u2101';
    /** ℂ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_C = '\u2102';
    /** ℃ of type OTHER_SYMBOL */
    char DEGREE_CELSIUS = '\u2103';
    /** ℄ of type OTHER_SYMBOL */
    char CENTRE_LINE_SYMBOL = '\u2104';
    /** ℅ of type OTHER_SYMBOL */
    char CARE_OF = '\u2105';
    /** ℆ of type OTHER_SYMBOL */
    char CADA_UNA = '\u2106';
    /** ℇ of type UPPERCASE_LETTER */
    char EULER_CONSTANT = '\u2107';
    /** ℈ of type OTHER_SYMBOL */
    char SCRUPLE = '\u2108';
    /** ℉ of type OTHER_SYMBOL */
    char DEGREE_FAHRENHEIT = '\u2109';
    /** ℊ of type LOWERCASE_LETTER */
    char SCRIPT_SMALL_G = '\u210A';
    /** ℋ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_H = '\u210B';
    /** ℌ of type UPPERCASE_LETTER */
    char BLACK_LETTER_CAPITAL_H = '\u210C';
    /** ℍ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_H = '\u210D';
    /** ℎ of type LOWERCASE_LETTER */
    char PLANCK_CONSTANT = '\u210E';
    /** ℏ of type LOWERCASE_LETTER */
    char PLANCK_CONSTANT_OVER_TWO_PI = '\u210F';
    /** ℐ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_I = '\u2110';
    /** ℑ of type UPPERCASE_LETTER */
    char BLACK_LETTER_CAPITAL_I = '\u2111';
    /** ℒ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_L = '\u2112';
    /** ℓ of type LOWERCASE_LETTER */
    char SCRIPT_SMALL_L = '\u2113';
    /** ℔ of type OTHER_SYMBOL */
    char L_B_BAR_SYMBOL = '\u2114';
    /** ℕ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_N = '\u2115';
    /** № of type OTHER_SYMBOL */
    char NUMERO_SIGN = '\u2116';
    /** ℗ of type OTHER_SYMBOL */
    char SOUND_RECORDING_COPYRIGHT = '\u2117';
    /** ℘ of type MATH_SYMBOL */
    char SCRIPT_CAPITAL_P = '\u2118';
    /** ℙ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_P = '\u2119';
    /** ℚ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_Q = '\u211A';
    /** ℛ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_R = '\u211B';
    /** ℜ of type UPPERCASE_LETTER */
    char BLACK_LETTER_CAPITAL_R = '\u211C';
    /** ℝ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_R = '\u211D';
    /** ℞ of type OTHER_SYMBOL */
    char PRESCRIPTION_TAKE = '\u211E';
    /** ℟ of type OTHER_SYMBOL */
    char RESPONSE = '\u211F';
    /** ℠ of type OTHER_SYMBOL */
    char SERVICE_MARK = '\u2120';
    /** ℡ of type OTHER_SYMBOL */
    char TELEPHONE_SIGN = '\u2121';
    /** ™ of type OTHER_SYMBOL */
    char TRADE_MARK_SIGN = '\u2122';
    /** ℣ of type OTHER_SYMBOL */
    char VERSICLE = '\u2123';
    /** ℤ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_Z = '\u2124';
    /** ℥ of type OTHER_SYMBOL */
    char OUNCE_SIGN = '\u2125';
    /** Ω of type UPPERCASE_LETTER */
    char OHM_SIGN = '\u2126';
    /** ℧ of type OTHER_SYMBOL */
    char INVERTED_OHM_SIGN = '\u2127';
    /** ℨ of type UPPERCASE_LETTER */
    char BLACK_LETTER_CAPITAL_Z = '\u2128';
    /** ℩ of type OTHER_SYMBOL */
    char TURNED_GREEK_SMALL_LETTER_IOTA = '\u2129';
    /** K of type UPPERCASE_LETTER */
    char KELVIN_SIGN = '\u212A';
    /** Å of type UPPERCASE_LETTER */
    char ANGSTROM_SIGN = '\u212B';
    /** ℬ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_B = '\u212C';
    /** ℭ of type UPPERCASE_LETTER */
    char BLACK_LETTER_CAPITAL_C = '\u212D';
    /** ℮ of type OTHER_SYMBOL */
    char ESTIMATED_SYMBOL = '\u212E';
    /** ℯ of type LOWERCASE_LETTER */
    char SCRIPT_SMALL_E = '\u212F';
    /** ℰ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_E = '\u2130';
    /** ℱ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_F = '\u2131';
    /** Ⅎ of type UPPERCASE_LETTER */
    char TURNED_CAPITAL_F = '\u2132';
    /** ℳ of type UPPERCASE_LETTER */
    char SCRIPT_CAPITAL_M = '\u2133';
    /** ℴ of type LOWERCASE_LETTER */
    char SCRIPT_SMALL_O = '\u2134';
    /** ℵ of type OTHER_LETTER */
    char ALEF_SYMBOL = '\u2135';
    /** ℶ of type OTHER_LETTER */
    char BET_SYMBOL = '\u2136';
    /** ℷ of type OTHER_LETTER */
    char GIMEL_SYMBOL = '\u2137';
    /** ℸ of type OTHER_LETTER */
    char DALET_SYMBOL = '\u2138';
    /** ℹ of type LOWERCASE_LETTER */
    char INFORMATION_SOURCE = '\u2139';
    /** ℺ of type OTHER_SYMBOL */
    char ROTATED_CAPITAL_Q = '\u213A';
    /** ℻ of type OTHER_SYMBOL */
    char FACSIMILE_SIGN = '\u213B';
    /** ℼ of type LOWERCASE_LETTER */
    char DOUBLE_STRUCK_SMALL_PI = '\u213C';
    /** ℽ of type LOWERCASE_LETTER */
    char DOUBLE_STRUCK_SMALL_GAMMA = '\u213D';
    /** ℾ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_GAMMA = '\u213E';
    /** ℿ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_CAPITAL_PI = '\u213F';
    /** ⅀ of type MATH_SYMBOL */
    char DOUBLE_STRUCK_N_ARY_SUMMATION = '\u2140';
    /** ⅁ of type MATH_SYMBOL */
    char TURNED_SANS_SERIF_CAPITAL_G = '\u2141';
    /** ⅂ of type MATH_SYMBOL */
    char TURNED_SANS_SERIF_CAPITAL_L = '\u2142';
    /** ⅃ of type MATH_SYMBOL */
    char REVERSED_SANS_SERIF_CAPITAL_L = '\u2143';
    /** ⅄ of type MATH_SYMBOL */
    char TURNED_SANS_SERIF_CAPITAL_Y = '\u2144';
    /** ⅅ of type UPPERCASE_LETTER */
    char DOUBLE_STRUCK_ITALIC_CAPITAL_D = '\u2145';
    /** ⅆ of type LOWERCASE_LETTER */
    char DOUBLE_STRUCK_ITALIC_SMALL_D = '\u2146';
    /** ⅇ of type LOWERCASE_LETTER */
    char DOUBLE_STRUCK_ITALIC_SMALL_E = '\u2147';
    /** ⅈ of type LOWERCASE_LETTER */
    char DOUBLE_STRUCK_ITALIC_SMALL_I = '\u2148';
    /** ⅉ of type LOWERCASE_LETTER */
    char DOUBLE_STRUCK_ITALIC_SMALL_J = '\u2149';
    /** ⅊ of type OTHER_SYMBOL */
    char PROPERTY_LINE = '\u214A';
    /** ⅋ of type MATH_SYMBOL */
    char TURNED_AMPERSAND = '\u214B';
    /** ⅌ of type OTHER_SYMBOL */
    char PER_SIGN = '\u214C';
    /** ⅍ of type OTHER_SYMBOL */
    char AKTIESELSKAB = '\u214D';
    /** ⅎ of type LOWERCASE_LETTER */
    char TURNED_SMALL_F = '\u214E';
    /** ⅏ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SAMARITAN_SOURCE = '\u214F';
    /** ⅐ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_SEVENTH = '\u2150';
    /** ⅑ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_NINTH = '\u2151';
    /** ⅒ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_TENTH = '\u2152';
    /** ⅓ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_THIRD = '\u2153';
    /** ⅔ of type OTHER_NUMBER */
    char VULGAR_FRACTION_TWO_THIRDS = '\u2154';
    /** ⅕ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_FIFTH = '\u2155';
    /** ⅖ of type OTHER_NUMBER */
    char VULGAR_FRACTION_TWO_FIFTHS = '\u2156';
    /** ⅗ of type OTHER_NUMBER */
    char VULGAR_FRACTION_THREE_FIFTHS = '\u2157';
    /** ⅘ of type OTHER_NUMBER */
    char VULGAR_FRACTION_FOUR_FIFTHS = '\u2158';
    /** ⅙ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_SIXTH = '\u2159';
    /** ⅚ of type OTHER_NUMBER */
    char VULGAR_FRACTION_FIVE_SIXTHS = '\u215A';
    /** ⅛ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ONE_EIGHTH = '\u215B';
    /** ⅜ of type OTHER_NUMBER */
    char VULGAR_FRACTION_THREE_EIGHTHS = '\u215C';
    /** ⅝ of type OTHER_NUMBER */
    char VULGAR_FRACTION_FIVE_EIGHTHS = '\u215D';
    /** ⅞ of type OTHER_NUMBER */
    char VULGAR_FRACTION_SEVEN_EIGHTHS = '\u215E';
    /** ⅟ of type OTHER_NUMBER */
    char FRACTION_NUMERATOR_ONE = '\u215F';
    /** Ⅰ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_ONE = '\u2160';
    /** Ⅱ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_TWO = '\u2161';
    /** Ⅲ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_THREE = '\u2162';
    /** Ⅳ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FOUR = '\u2163';
    /** Ⅴ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FIVE = '\u2164';
    /** Ⅵ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_SIX = '\u2165';
    /** Ⅶ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_SEVEN = '\u2166';
    /** Ⅷ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_EIGHT = '\u2167';
    /** Ⅸ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_NINE = '\u2168';
    /** Ⅹ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_TEN = '\u2169';
    /** Ⅺ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_ELEVEN = '\u216A';
    /** Ⅻ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_TWELVE = '\u216B';
    /** Ⅼ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FIFTY = '\u216C';
    /** Ⅽ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_ONE_HUNDRED = '\u216D';
    /** Ⅾ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FIVE_HUNDRED = '\u216E';
    /** Ⅿ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_ONE_THOUSAND = '\u216F';
    /** ⅰ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_ONE = '\u2170';
    /** ⅱ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_TWO = '\u2171';
    /** ⅲ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_THREE = '\u2172';
    /** ⅳ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_FOUR = '\u2173';
    /** ⅴ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_FIVE = '\u2174';
    /** ⅵ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_SIX = '\u2175';
    /** ⅶ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_SEVEN = '\u2176';
    /** ⅷ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_EIGHT = '\u2177';
    /** ⅸ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_NINE = '\u2178';
    /** ⅹ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_TEN = '\u2179';
    /** ⅺ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_ELEVEN = '\u217A';
    /** ⅻ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_TWELVE = '\u217B';
    /** ⅼ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_FIFTY = '\u217C';
    /** ⅽ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_ONE_HUNDRED = '\u217D';
    /** ⅾ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_FIVE_HUNDRED = '\u217E';
    /** ⅿ of type LETTER_NUMBER */
    char SMALL_ROMAN_NUMERAL_ONE_THOUSAND = '\u217F';
    /** ↀ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_ONE_THOUSAND_C_D = '\u2180';
    /** ↁ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FIVE_THOUSAND = '\u2181';
    /** ↂ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_TEN_THOUSAND = '\u2182';
    /** Ↄ of type UPPERCASE_LETTER */
    char ROMAN_NUMERAL_REVERSED_ONE_HUNDRED = '\u2183';
    /** ↅ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_SIX_LATE_FORM = '\u2185';
    /** ↆ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FIFTY_EARLY_FORM = '\u2186';
    /** ↇ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_FIFTY_THOUSAND = '\u2187';
    /** ↈ of type LETTER_NUMBER */
    char ROMAN_NUMERAL_ONE_HUNDRED_THOUSAND = '\u2188';
    /** ↉ of type OTHER_NUMBER */
    char VULGAR_FRACTION_ZERO_THIRDS = '\u2189';
    /** ← of type MATH_SYMBOL */
    char LEFTWARDS_ARROW = '\u2190';
    /** ↑ of type MATH_SYMBOL */
    char UPWARDS_ARROW = '\u2191';
    /** → of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW = '\u2192';
    /** ↓ of type MATH_SYMBOL */
    char DOWNWARDS_ARROW = '\u2193';
    /** ↔ of type MATH_SYMBOL */
    char LEFT_RIGHT_ARROW = '\u2194';
    /** ↕ of type OTHER_SYMBOL */
    char UP_DOWN_ARROW = '\u2195';
    /** ↖ of type OTHER_SYMBOL */
    char NORTH_WEST_ARROW = '\u2196';
    /** ↗ of type OTHER_SYMBOL */
    char NORTH_EAST_ARROW = '\u2197';
    /** ↘ of type OTHER_SYMBOL */
    char SOUTH_EAST_ARROW = '\u2198';
    /** ↙ of type OTHER_SYMBOL */
    char SOUTH_WEST_ARROW = '\u2199';
    /** ↚ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_STROKE = '\u219A';
    /** ↛ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_STROKE = '\u219B';
    /** ↜ of type OTHER_SYMBOL */
    char LEFTWARDS_WAVE_ARROW = '\u219C';
    /** ↝ of type OTHER_SYMBOL */
    char RIGHTWARDS_WAVE_ARROW = '\u219D';
    /** ↞ of type OTHER_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW = '\u219E';
    /** ↟ of type OTHER_SYMBOL */
    char UPWARDS_TWO_HEADED_ARROW = '\u219F';
    /** ↠ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW = '\u21A0';
    /** ↡ of type OTHER_SYMBOL */
    char DOWNWARDS_TWO_HEADED_ARROW = '\u21A1';
    /** ↢ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_WITH_TAIL = '\u21A2';
    /** ↣ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_TAIL = '\u21A3';
    /** ↤ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_FROM_BAR = '\u21A4';
    /** ↥ of type OTHER_SYMBOL */
    char UPWARDS_ARROW_FROM_BAR = '\u21A5';
    /** ↦ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_FROM_BAR = '\u21A6';
    /** ↧ of type OTHER_SYMBOL */
    char DOWNWARDS_ARROW_FROM_BAR = '\u21A7';
    /** ↨ of type OTHER_SYMBOL */
    char UP_DOWN_ARROW_WITH_BASE = '\u21A8';
    /** ↩ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_WITH_HOOK = '\u21A9';
    /** ↪ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_HOOK = '\u21AA';
    /** ↫ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_WITH_LOOP = '\u21AB';
    /** ↬ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_LOOP = '\u21AC';
    /** ↭ of type OTHER_SYMBOL */
    char LEFT_RIGHT_WAVE_ARROW = '\u21AD';
    /** ↮ of type MATH_SYMBOL */
    char LEFT_RIGHT_ARROW_WITH_STROKE = '\u21AE';
    /** ↯ of type OTHER_SYMBOL */
    char DOWNWARDS_ZIGZAG_ARROW = '\u21AF';
    /** ↰ of type OTHER_SYMBOL */
    char UPWARDS_ARROW_WITH_TIP_LEFTWARDS = '\u21B0';
    /** ↱ of type OTHER_SYMBOL */
    char UPWARDS_ARROW_WITH_TIP_RIGHTWARDS = '\u21B1';
    /** ↲ of type OTHER_SYMBOL */
    char DOWNWARDS_ARROW_WITH_TIP_LEFTWARDS = '\u21B2';
    /** ↳ of type OTHER_SYMBOL */
    char DOWNWARDS_ARROW_WITH_TIP_RIGHTWARDS = '\u21B3';
    /** ↴ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_CORNER_DOWNWARDS = '\u21B4';
    /** ↵ of type OTHER_SYMBOL */
    char DOWNWARDS_ARROW_WITH_CORNER_LEFTWARDS = '\u21B5';
    /** ↶ of type OTHER_SYMBOL */
    char ANTICLOCKWISE_TOP_SEMICIRCLE_ARROW = '\u21B6';
    /** ↷ of type OTHER_SYMBOL */
    char CLOCKWISE_TOP_SEMICIRCLE_ARROW = '\u21B7';
    /** ↸ of type OTHER_SYMBOL */
    char NORTH_WEST_ARROW_TO_LONG_BAR = '\u21B8';
    /** ↹ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_TO_BAR_OVER_RIGHTWARDS_ARROW_TO_BAR = '\u21B9';
    /** ↺ of type OTHER_SYMBOL */
    char ANTICLOCKWISE_OPEN_CIRCLE_ARROW = '\u21BA';
    /** ↻ of type OTHER_SYMBOL */
    char CLOCKWISE_OPEN_CIRCLE_ARROW = '\u21BB';
    /** ↼ of type OTHER_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_UPWARDS = '\u21BC';
    /** ↽ of type OTHER_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_DOWNWARDS = '\u21BD';
    /** ↾ of type OTHER_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_RIGHTWARDS = '\u21BE';
    /** ↿ of type OTHER_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_LEFTWARDS = '\u21BF';
    /** ⇀ of type OTHER_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_UPWARDS = '\u21C0';
    /** ⇁ of type OTHER_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_DOWNWARDS = '\u21C1';
    /** ⇂ of type OTHER_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_RIGHTWARDS = '\u21C2';
    /** ⇃ of type OTHER_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_LEFTWARDS = '\u21C3';
    /** ⇄ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_OVER_LEFTWARDS_ARROW = '\u21C4';
    /** ⇅ of type OTHER_SYMBOL */
    char UPWARDS_ARROW_LEFTWARDS_OF_DOWNWARDS_ARROW = '\u21C5';
    /** ⇆ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_OVER_RIGHTWARDS_ARROW = '\u21C6';
    /** ⇇ of type OTHER_SYMBOL */
    char LEFTWARDS_PAIRED_ARROWS = '\u21C7';
    /** ⇈ of type OTHER_SYMBOL */
    char UPWARDS_PAIRED_ARROWS = '\u21C8';
    /** ⇉ of type OTHER_SYMBOL */
    char RIGHTWARDS_PAIRED_ARROWS = '\u21C9';
    /** ⇊ of type OTHER_SYMBOL */
    char DOWNWARDS_PAIRED_ARROWS = '\u21CA';
    /** ⇋ of type OTHER_SYMBOL */
    char LEFTWARDS_HARPOON_OVER_RIGHTWARDS_HARPOON = '\u21CB';
    /** ⇌ of type OTHER_SYMBOL */
    char RIGHTWARDS_HARPOON_OVER_LEFTWARDS_HARPOON = '\u21CC';
    /** ⇍ of type OTHER_SYMBOL */
    char LEFTWARDS_DOUBLE_ARROW_WITH_STROKE = '\u21CD';
    /** ⇎ of type MATH_SYMBOL */
    char LEFT_RIGHT_DOUBLE_ARROW_WITH_STROKE = '\u21CE';
    /** ⇏ of type MATH_SYMBOL */
    char RIGHTWARDS_DOUBLE_ARROW_WITH_STROKE = '\u21CF';
    /** ⇐ of type OTHER_SYMBOL */
    char LEFTWARDS_DOUBLE_ARROW = '\u21D0';
    /** ⇑ of type OTHER_SYMBOL */
    char UPWARDS_DOUBLE_ARROW = '\u21D1';
    /** ⇒ of type MATH_SYMBOL */
    char RIGHTWARDS_DOUBLE_ARROW = '\u21D2';
    /** ⇓ of type OTHER_SYMBOL */
    char DOWNWARDS_DOUBLE_ARROW = '\u21D3';
    /** ⇔ of type MATH_SYMBOL */
    char LEFT_RIGHT_DOUBLE_ARROW = '\u21D4';
    /** ⇕ of type OTHER_SYMBOL */
    char UP_DOWN_DOUBLE_ARROW = '\u21D5';
    /** ⇖ of type OTHER_SYMBOL */
    char NORTH_WEST_DOUBLE_ARROW = '\u21D6';
    /** ⇗ of type OTHER_SYMBOL */
    char NORTH_EAST_DOUBLE_ARROW = '\u21D7';
    /** ⇘ of type OTHER_SYMBOL */
    char SOUTH_EAST_DOUBLE_ARROW = '\u21D8';
    /** ⇙ of type OTHER_SYMBOL */
    char SOUTH_WEST_DOUBLE_ARROW = '\u21D9';
    /** ⇚ of type OTHER_SYMBOL */
    char LEFTWARDS_TRIPLE_ARROW = '\u21DA';
    /** ⇛ of type OTHER_SYMBOL */
    char RIGHTWARDS_TRIPLE_ARROW = '\u21DB';
    /** ⇜ of type OTHER_SYMBOL */
    char LEFTWARDS_SQUIGGLE_ARROW = '\u21DC';
    /** ⇝ of type OTHER_SYMBOL */
    char RIGHTWARDS_SQUIGGLE_ARROW = '\u21DD';
    /** ⇞ of type OTHER_SYMBOL */
    char UPWARDS_ARROW_WITH_DOUBLE_STROKE = '\u21DE';
    /** ⇟ of type OTHER_SYMBOL */
    char DOWNWARDS_ARROW_WITH_DOUBLE_STROKE = '\u21DF';
    /** ⇠ of type OTHER_SYMBOL */
    char LEFTWARDS_DASHED_ARROW = '\u21E0';
    /** ⇡ of type OTHER_SYMBOL */
    char UPWARDS_DASHED_ARROW = '\u21E1';
    /** ⇢ of type OTHER_SYMBOL */
    char RIGHTWARDS_DASHED_ARROW = '\u21E2';
    /** ⇣ of type OTHER_SYMBOL */
    char DOWNWARDS_DASHED_ARROW = '\u21E3';
    /** ⇤ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_TO_BAR = '\u21E4';
    /** ⇥ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_TO_BAR = '\u21E5';
    /** ⇦ of type OTHER_SYMBOL */
    char LEFTWARDS_WHITE_ARROW = '\u21E6';
    /** ⇧ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_ARROW = '\u21E7';
    /** ⇨ of type OTHER_SYMBOL */
    char RIGHTWARDS_WHITE_ARROW = '\u21E8';
    /** ⇩ of type OTHER_SYMBOL */
    char DOWNWARDS_WHITE_ARROW = '\u21E9';
    /** ⇪ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_ARROW_FROM_BAR = '\u21EA';
    /** ⇫ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_ARROW_ON_PEDESTAL = '\u21EB';
    /** ⇬ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_ARROW_ON_PEDESTAL_WITH_HORIZONTAL_BAR = '\u21EC';
    /** ⇭ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_ARROW_ON_PEDESTAL_WITH_VERTICAL_BAR = '\u21ED';
    /** ⇮ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_DOUBLE_ARROW = '\u21EE';
    /** ⇯ of type OTHER_SYMBOL */
    char UPWARDS_WHITE_DOUBLE_ARROW_ON_PEDESTAL = '\u21EF';
    /** ⇰ of type OTHER_SYMBOL */
    char RIGHTWARDS_WHITE_ARROW_FROM_WALL = '\u21F0';
    /** ⇱ of type OTHER_SYMBOL */
    char NORTH_WEST_ARROW_TO_CORNER = '\u21F1';
    /** ⇲ of type OTHER_SYMBOL */
    char SOUTH_EAST_ARROW_TO_CORNER = '\u21F2';
    /** ⇳ of type OTHER_SYMBOL */
    char UP_DOWN_WHITE_ARROW = '\u21F3';
    /** ⇴ of type MATH_SYMBOL */
    char RIGHT_ARROW_WITH_SMALL_CIRCLE = '\u21F4';
    /** ⇵ of type MATH_SYMBOL */
    char DOWNWARDS_ARROW_LEFTWARDS_OF_UPWARDS_ARROW = '\u21F5';
    /** ⇶ of type MATH_SYMBOL */
    char THREE_RIGHTWARDS_ARROWS = '\u21F6';
    /** ⇷ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_VERTICAL_STROKE = '\u21F7';
    /** ⇸ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_VERTICAL_STROKE = '\u21F8';
    /** ⇹ of type MATH_SYMBOL */
    char LEFT_RIGHT_ARROW_WITH_VERTICAL_STROKE = '\u21F9';
    /** ⇺ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_DOUBLE_VERTICAL_STROKE = '\u21FA';
    /** ⇻ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_DOUBLE_VERTICAL_STROKE = '\u21FB';
    /** ⇼ of type MATH_SYMBOL */
    char LEFT_RIGHT_ARROW_WITH_DOUBLE_VERTICAL_STROKE = '\u21FC';
    /** ⇽ of type MATH_SYMBOL */
    char LEFTWARDS_OPEN_HEADED_ARROW = '\u21FD';
    /** ⇾ of type MATH_SYMBOL */
    char RIGHTWARDS_OPEN_HEADED_ARROW = '\u21FE';
    /** ⇿ of type MATH_SYMBOL */
    char LEFT_RIGHT_OPEN_HEADED_ARROW = '\u21FF';
    /** ∀ of type MATH_SYMBOL */
    char FOR_ALL = '\u2200';
    /** ∁ of type MATH_SYMBOL */
    char COMPLEMENT = '\u2201';
    /** ∂ of type MATH_SYMBOL */
    char PARTIAL_DIFFERENTIAL = '\u2202';
    /** ∃ of type MATH_SYMBOL */
    char THERE_EXISTS = '\u2203';
    /** ∄ of type MATH_SYMBOL */
    char THERE_DOES_NOT_EXIST = '\u2204';
    /** ∅ of type MATH_SYMBOL */
    char EMPTY_SET = '\u2205';
    /** ∆ of type MATH_SYMBOL */
    char INCREMENT = '\u2206';
    /** ∇ of type MATH_SYMBOL */
    char NABLA = '\u2207';
    /** ∈ of type MATH_SYMBOL */
    char ELEMENT_OF = '\u2208';
    /** ∉ of type MATH_SYMBOL */
    char NOT_AN_ELEMENT_OF = '\u2209';
    /** ∊ of type MATH_SYMBOL */
    char SMALL_ELEMENT_OF = '\u220A';
    /** ∋ of type MATH_SYMBOL */
    char CONTAINS_AS_MEMBER = '\u220B';
    /** ∌ of type MATH_SYMBOL */
    char DOES_NOT_CONTAIN_AS_MEMBER = '\u220C';
    /** ∍ of type MATH_SYMBOL */
    char SMALL_CONTAINS_AS_MEMBER = '\u220D';
    /** ∎ of type MATH_SYMBOL */
    char END_OF_PROOF = '\u220E';
    /** ∏ of type MATH_SYMBOL */
    char N_ARY_PRODUCT = '\u220F';
    /** ∐ of type MATH_SYMBOL */
    char N_ARY_COPRODUCT = '\u2210';
    /** ∑ of type MATH_SYMBOL */
    char N_ARY_SUMMATION = '\u2211';
    /** − of type MATH_SYMBOL */
    char MINUS_SIGN = '\u2212';
    /** ∓ of type MATH_SYMBOL */
    char MINUS_OR_PLUS_SIGN = '\u2213';
    /** ∔ of type MATH_SYMBOL */
    char DOT_PLUS = '\u2214';
    /** ∕ of type MATH_SYMBOL */
    char DIVISION_SLASH = '\u2215';
    /** ∖ of type MATH_SYMBOL */
    char SET_MINUS = '\u2216';
    /** ∗ of type MATH_SYMBOL */
    char ASTERISK_OPERATOR = '\u2217';
    /** ∘ of type MATH_SYMBOL */
    char RING_OPERATOR = '\u2218';
    /** ∙ of type MATH_SYMBOL */
    char BULLET_OPERATOR = '\u2219';
    /** √ of type MATH_SYMBOL */
    char SQUARE_ROOT = '\u221A';
    /** ∛ of type MATH_SYMBOL */
    char CUBE_ROOT = '\u221B';
    /** ∜ of type MATH_SYMBOL */
    char FOURTH_ROOT = '\u221C';
    /** ∝ of type MATH_SYMBOL */
    char PROPORTIONAL_TO = '\u221D';
    /** ∞ of type MATH_SYMBOL */
    char INFINITY = '\u221E';
    /** ∟ of type MATH_SYMBOL */
    char RIGHT_ANGLE = '\u221F';
    /** ∠ of type MATH_SYMBOL */
    char ANGLE = '\u2220';
    /** ∡ of type MATH_SYMBOL */
    char MEASURED_ANGLE = '\u2221';
    /** ∢ of type MATH_SYMBOL */
    char SPHERICAL_ANGLE = '\u2222';
    /** ∣ of type MATH_SYMBOL */
    char DIVIDES = '\u2223';
    /** ∤ of type MATH_SYMBOL */
    char DOES_NOT_DIVIDE = '\u2224';
    /** ∥ of type MATH_SYMBOL */
    char PARALLEL_TO = '\u2225';
    /** ∦ of type MATH_SYMBOL */
    char NOT_PARALLEL_TO = '\u2226';
    /** ∧ of type MATH_SYMBOL */
    char LOGICAL_AND = '\u2227';
    /** ∨ of type MATH_SYMBOL */
    char LOGICAL_OR = '\u2228';
    /** ∩ of type MATH_SYMBOL */
    char INTERSECTION = '\u2229';
    /** ∪ of type MATH_SYMBOL */
    char UNION = '\u222A';
    /** ∫ of type MATH_SYMBOL */
    char INTEGRAL = '\u222B';
    /** ∬ of type MATH_SYMBOL */
    char DOUBLE_INTEGRAL = '\u222C';
    /** ∭ of type MATH_SYMBOL */
    char TRIPLE_INTEGRAL = '\u222D';
    /** ∮ of type MATH_SYMBOL */
    char CONTOUR_INTEGRAL = '\u222E';
    /** ∯ of type MATH_SYMBOL */
    char SURFACE_INTEGRAL = '\u222F';
    /** ∰ of type MATH_SYMBOL */
    char VOLUME_INTEGRAL = '\u2230';
    /** ∱ of type MATH_SYMBOL */
    char CLOCKWISE_INTEGRAL = '\u2231';
    /** ∲ of type MATH_SYMBOL */
    char CLOCKWISE_CONTOUR_INTEGRAL = '\u2232';
    /** ∳ of type MATH_SYMBOL */
    char ANTICLOCKWISE_CONTOUR_INTEGRAL = '\u2233';
    /** ∴ of type MATH_SYMBOL */
    char THEREFORE = '\u2234';
    /** ∵ of type MATH_SYMBOL */
    char BECAUSE = '\u2235';
    /** ∶ of type MATH_SYMBOL */
    char RATIO = '\u2236';
    /** ∷ of type MATH_SYMBOL */
    char PROPORTION = '\u2237';
    /** ∸ of type MATH_SYMBOL */
    char DOT_MINUS = '\u2238';
    /** ∹ of type MATH_SYMBOL */
    char EXCESS = '\u2239';
    /** ∺ of type MATH_SYMBOL */
    char GEOMETRIC_PROPORTION = '\u223A';
    /** ∻ of type MATH_SYMBOL */
    char HOMOTHETIC = '\u223B';
    /** ∼ of type MATH_SYMBOL */
    char TILDE_OPERATOR = '\u223C';
    /** ∽ of type MATH_SYMBOL */
    char REVERSED_TILDE = '\u223D';
    /** ∾ of type MATH_SYMBOL */
    char INVERTED_LAZY_S = '\u223E';
    /** ∿ of type MATH_SYMBOL */
    char SINE_WAVE = '\u223F';
    /** ≀ of type MATH_SYMBOL */
    char WREATH_PRODUCT = '\u2240';
    /** ≁ of type MATH_SYMBOL */
    char NOT_TILDE = '\u2241';
    /** ≂ of type MATH_SYMBOL */
    char MINUS_TILDE = '\u2242';
    /** ≃ of type MATH_SYMBOL */
    char ASYMPTOTICALLY_EQUAL_TO = '\u2243';
    /** ≄ of type MATH_SYMBOL */
    char NOT_ASYMPTOTICALLY_EQUAL_TO = '\u2244';
    /** ≅ of type MATH_SYMBOL */
    char APPROXIMATELY_EQUAL_TO = '\u2245';
    /** ≆ of type MATH_SYMBOL */
    char APPROXIMATELY_BUT_NOT_ACTUALLY_EQUAL_TO = '\u2246';
    /** ≇ of type MATH_SYMBOL */
    char NEITHER_APPROXIMATELY_NOR_ACTUALLY_EQUAL_TO = '\u2247';
    /** ≈ of type MATH_SYMBOL */
    char ALMOST_EQUAL_TO = '\u2248';
    /** ≉ of type MATH_SYMBOL */
    char NOT_ALMOST_EQUAL_TO = '\u2249';
    /** ≊ of type MATH_SYMBOL */
    char ALMOST_EQUAL_OR_EQUAL_TO = '\u224A';
    /** ≋ of type MATH_SYMBOL */
    char TRIPLE_TILDE = '\u224B';
    /** ≌ of type MATH_SYMBOL */
    char ALL_EQUAL_TO = '\u224C';
    /** ≍ of type MATH_SYMBOL */
    char EQUIVALENT_TO = '\u224D';
    /** ≎ of type MATH_SYMBOL */
    char GEOMETRICALLY_EQUIVALENT_TO = '\u224E';
    /** ≏ of type MATH_SYMBOL */
    char DIFFERENCE_BETWEEN = '\u224F';
    /** ≐ of type MATH_SYMBOL */
    char APPROACHES_THE_LIMIT = '\u2250';
    /** ≑ of type MATH_SYMBOL */
    char GEOMETRICALLY_EQUAL_TO = '\u2251';
    /** ≒ of type MATH_SYMBOL */
    char APPROXIMATELY_EQUAL_TO_OR_THE_IMAGE_OF = '\u2252';
    /** ≓ of type MATH_SYMBOL */
    char IMAGE_OF_OR_APPROXIMATELY_EQUAL_TO = '\u2253';
    /** ≔ of type MATH_SYMBOL */
    char COLON_EQUALS = '\u2254';
    /** ≕ of type MATH_SYMBOL */
    char EQUALS_COLON = '\u2255';
    /** ≖ of type MATH_SYMBOL */
    char RING_IN_EQUAL_TO = '\u2256';
    /** ≗ of type MATH_SYMBOL */
    char RING_EQUAL_TO = '\u2257';
    /** ≘ of type MATH_SYMBOL */
    char CORRESPONDS_TO = '\u2258';
    /** ≙ of type MATH_SYMBOL */
    char ESTIMATES = '\u2259';
    /** ≚ of type MATH_SYMBOL */
    char EQUIANGULAR_TO = '\u225A';
    /** ≛ of type MATH_SYMBOL */
    char STAR_EQUALS = '\u225B';
    /** ≜ of type MATH_SYMBOL */
    char DELTA_EQUAL_TO = '\u225C';
    /** ≝ of type MATH_SYMBOL */
    char EQUAL_TO_BY_DEFINITION = '\u225D';
    /** ≞ of type MATH_SYMBOL */
    char MEASURED_BY = '\u225E';
    /** ≟ of type MATH_SYMBOL */
    char QUESTIONED_EQUAL_TO = '\u225F';
    /** ≠ of type MATH_SYMBOL */
    char NOT_EQUAL_TO = '\u2260';
    /** ≡ of type MATH_SYMBOL */
    char IDENTICAL_TO = '\u2261';
    /** ≢ of type MATH_SYMBOL */
    char NOT_IDENTICAL_TO = '\u2262';
    /** ≣ of type MATH_SYMBOL */
    char STRICTLY_EQUIVALENT_TO = '\u2263';
    /** ≤ of type MATH_SYMBOL */
    char LESS_THAN_OR_EQUAL_TO = '\u2264';
    /** ≥ of type MATH_SYMBOL */
    char GREATER_THAN_OR_EQUAL_TO = '\u2265';
    /** ≦ of type MATH_SYMBOL */
    char LESS_THAN_OVER_EQUAL_TO = '\u2266';
    /** ≧ of type MATH_SYMBOL */
    char GREATER_THAN_OVER_EQUAL_TO = '\u2267';
    /** ≨ of type MATH_SYMBOL */
    char LESS_THAN_BUT_NOT_EQUAL_TO = '\u2268';
    /** ≩ of type MATH_SYMBOL */
    char GREATER_THAN_BUT_NOT_EQUAL_TO = '\u2269';
    /** ≪ of type MATH_SYMBOL */
    char MUCH_LESS_THAN = '\u226A';
    /** ≫ of type MATH_SYMBOL */
    char MUCH_GREATER_THAN = '\u226B';
    /** ≬ of type MATH_SYMBOL */
    char BETWEEN = '\u226C';
    /** ≭ of type MATH_SYMBOL */
    char NOT_EQUIVALENT_TO = '\u226D';
    /** ≮ of type MATH_SYMBOL */
    char NOT_LESS_THAN = '\u226E';
    /** ≯ of type MATH_SYMBOL */
    char NOT_GREATER_THAN = '\u226F';
    /** ≰ of type MATH_SYMBOL */
    char NEITHER_LESS_THAN_NOR_EQUAL_TO = '\u2270';
    /** ≱ of type MATH_SYMBOL */
    char NEITHER_GREATER_THAN_NOR_EQUAL_TO = '\u2271';
    /** ≲ of type MATH_SYMBOL */
    char LESS_THAN_OR_EQUIVALENT_TO = '\u2272';
    /** ≳ of type MATH_SYMBOL */
    char GREATER_THAN_OR_EQUIVALENT_TO = '\u2273';
    /** ≴ of type MATH_SYMBOL */
    char NEITHER_LESS_THAN_NOR_EQUIVALENT_TO = '\u2274';
    /** ≵ of type MATH_SYMBOL */
    char NEITHER_GREATER_THAN_NOR_EQUIVALENT_TO = '\u2275';
    /** ≶ of type MATH_SYMBOL */
    char LESS_THAN_OR_GREATER_THAN = '\u2276';
    /** ≷ of type MATH_SYMBOL */
    char GREATER_THAN_OR_LESS_THAN = '\u2277';
    /** ≸ of type MATH_SYMBOL */
    char NEITHER_LESS_THAN_NOR_GREATER_THAN = '\u2278';
    /** ≹ of type MATH_SYMBOL */
    char NEITHER_GREATER_THAN_NOR_LESS_THAN = '\u2279';
    /** ≺ of type MATH_SYMBOL */
    char PRECEDES = '\u227A';
    /** ≻ of type MATH_SYMBOL */
    char SUCCEEDS = '\u227B';
    /** ≼ of type MATH_SYMBOL */
    char PRECEDES_OR_EQUAL_TO = '\u227C';
    /** ≽ of type MATH_SYMBOL */
    char SUCCEEDS_OR_EQUAL_TO = '\u227D';
    /** ≾ of type MATH_SYMBOL */
    char PRECEDES_OR_EQUIVALENT_TO = '\u227E';
    /** ≿ of type MATH_SYMBOL */
    char SUCCEEDS_OR_EQUIVALENT_TO = '\u227F';
    /** ⊀ of type MATH_SYMBOL */
    char DOES_NOT_PRECEDE = '\u2280';
    /** ⊁ of type MATH_SYMBOL */
    char DOES_NOT_SUCCEED = '\u2281';
    /** ⊂ of type MATH_SYMBOL */
    char SUBSET_OF = '\u2282';
    /** ⊃ of type MATH_SYMBOL */
    char SUPERSET_OF = '\u2283';
    /** ⊄ of type MATH_SYMBOL */
    char NOT_A_SUBSET_OF = '\u2284';
    /** ⊅ of type MATH_SYMBOL */
    char NOT_A_SUPERSET_OF = '\u2285';
    /** ⊆ of type MATH_SYMBOL */
    char SUBSET_OF_OR_EQUAL_TO = '\u2286';
    /** ⊇ of type MATH_SYMBOL */
    char SUPERSET_OF_OR_EQUAL_TO = '\u2287';
    /** ⊈ of type MATH_SYMBOL */
    char NEITHER_A_SUBSET_OF_NOR_EQUAL_TO = '\u2288';
    /** ⊉ of type MATH_SYMBOL */
    char NEITHER_A_SUPERSET_OF_NOR_EQUAL_TO = '\u2289';
    /** ⊊ of type MATH_SYMBOL */
    char SUBSET_OF_WITH_NOT_EQUAL_TO = '\u228A';
    /** ⊋ of type MATH_SYMBOL */
    char SUPERSET_OF_WITH_NOT_EQUAL_TO = '\u228B';
    /** ⊌ of type MATH_SYMBOL */
    char MULTISET = '\u228C';
    /** ⊍ of type MATH_SYMBOL */
    char MULTISET_MULTIPLICATION = '\u228D';
    /** ⊎ of type MATH_SYMBOL */
    char MULTISET_UNION = '\u228E';
    /** ⊏ of type MATH_SYMBOL */
    char SQUARE_IMAGE_OF = '\u228F';
    /** ⊐ of type MATH_SYMBOL */
    char SQUARE_ORIGINAL_OF = '\u2290';
    /** ⊑ of type MATH_SYMBOL */
    char SQUARE_IMAGE_OF_OR_EQUAL_TO = '\u2291';
    /** ⊒ of type MATH_SYMBOL */
    char SQUARE_ORIGINAL_OF_OR_EQUAL_TO = '\u2292';
    /** ⊓ of type MATH_SYMBOL */
    char SQUARE_CAP = '\u2293';
    /** ⊔ of type MATH_SYMBOL */
    char SQUARE_CUP = '\u2294';
    /** ⊕ of type MATH_SYMBOL */
    char CIRCLED_PLUS = '\u2295';
    /** ⊖ of type MATH_SYMBOL */
    char CIRCLED_MINUS = '\u2296';
    /** ⊗ of type MATH_SYMBOL */
    char CIRCLED_TIMES = '\u2297';
    /** ⊘ of type MATH_SYMBOL */
    char CIRCLED_DIVISION_SLASH = '\u2298';
    /** ⊙ of type MATH_SYMBOL */
    char CIRCLED_DOT_OPERATOR = '\u2299';
    /** ⊚ of type MATH_SYMBOL */
    char CIRCLED_RING_OPERATOR = '\u229A';
    /** ⊛ of type MATH_SYMBOL */
    char CIRCLED_ASTERISK_OPERATOR = '\u229B';
    /** ⊜ of type MATH_SYMBOL */
    char CIRCLED_EQUALS = '\u229C';
    /** ⊝ of type MATH_SYMBOL */
    char CIRCLED_DASH = '\u229D';
    /** ⊞ of type MATH_SYMBOL */
    char SQUARED_PLUS = '\u229E';
    /** ⊟ of type MATH_SYMBOL */
    char SQUARED_MINUS = '\u229F';
    /** ⊠ of type MATH_SYMBOL */
    char SQUARED_TIMES = '\u22A0';
    /** ⊡ of type MATH_SYMBOL */
    char SQUARED_DOT_OPERATOR = '\u22A1';
    /** ⊢ of type MATH_SYMBOL */
    char RIGHT_TACK = '\u22A2';
    /** ⊣ of type MATH_SYMBOL */
    char LEFT_TACK = '\u22A3';
    /** ⊤ of type MATH_SYMBOL */
    char DOWN_TACK = '\u22A4';
    /** ⊥ of type MATH_SYMBOL */
    char UP_TACK = '\u22A5';
    /** ⊦ of type MATH_SYMBOL */
    char ASSERTION = '\u22A6';
    /** ⊧ of type MATH_SYMBOL */
    char MODELS = '\u22A7';
    /** ⊨ of type MATH_SYMBOL */
    char TRUE = '\u22A8';
    /** ⊩ of type MATH_SYMBOL */
    char FORCES = '\u22A9';
    /** ⊪ of type MATH_SYMBOL */
    char TRIPLE_VERTICAL_BAR_RIGHT_TURNSTILE = '\u22AA';
    /** ⊫ of type MATH_SYMBOL */
    char DOUBLE_VERTICAL_BAR_DOUBLE_RIGHT_TURNSTILE = '\u22AB';
    /** ⊬ of type MATH_SYMBOL */
    char DOES_NOT_PROVE = '\u22AC';
    /** ⊭ of type MATH_SYMBOL */
    char NOT_TRUE = '\u22AD';
    /** ⊮ of type MATH_SYMBOL */
    char DOES_NOT_FORCE = '\u22AE';
    /** ⊯ of type MATH_SYMBOL */
    char NEGATED_DOUBLE_VERTICAL_BAR_DOUBLE_RIGHT_TURNSTILE = '\u22AF';
    /** ⊰ of type MATH_SYMBOL */
    char PRECEDES_UNDER_RELATION = '\u22B0';
    /** ⊱ of type MATH_SYMBOL */
    char SUCCEEDS_UNDER_RELATION = '\u22B1';
    /** ⊲ of type MATH_SYMBOL */
    char NORMAL_SUBGROUP_OF = '\u22B2';
    /** ⊳ of type MATH_SYMBOL */
    char CONTAINS_AS_NORMAL_SUBGROUP = '\u22B3';
    /** ⊴ of type MATH_SYMBOL */
    char NORMAL_SUBGROUP_OF_OR_EQUAL_TO = '\u22B4';
    /** ⊵ of type MATH_SYMBOL */
    char CONTAINS_AS_NORMAL_SUBGROUP_OR_EQUAL_TO = '\u22B5';
    /** ⊶ of type MATH_SYMBOL */
    char ORIGINAL_OF = '\u22B6';
    /** ⊷ of type MATH_SYMBOL */
    char IMAGE_OF = '\u22B7';
    /** ⊸ of type MATH_SYMBOL */
    char MULTIMAP = '\u22B8';
    /** ⊹ of type MATH_SYMBOL */
    char HERMITIAN_CONJUGATE_MATRIX = '\u22B9';
    /** ⊺ of type MATH_SYMBOL */
    char INTERCALATE = '\u22BA';
    /** ⊻ of type MATH_SYMBOL */
    char XOR = '\u22BB';
    /** ⊼ of type MATH_SYMBOL */
    char NAND = '\u22BC';
    /** ⊽ of type MATH_SYMBOL */
    char NOR = '\u22BD';
    /** ⊾ of type MATH_SYMBOL */
    char RIGHT_ANGLE_WITH_ARC = '\u22BE';
    /** ⊿ of type MATH_SYMBOL */
    char RIGHT_TRIANGLE = '\u22BF';
    /** ⋀ of type MATH_SYMBOL */
    char N_ARY_LOGICAL_AND = '\u22C0';
    /** ⋁ of type MATH_SYMBOL */
    char N_ARY_LOGICAL_OR = '\u22C1';
    /** ⋂ of type MATH_SYMBOL */
    char N_ARY_INTERSECTION = '\u22C2';
    /** ⋃ of type MATH_SYMBOL */
    char N_ARY_UNION = '\u22C3';
    /** ⋄ of type MATH_SYMBOL */
    char DIAMOND_OPERATOR = '\u22C4';
    /** ⋅ of type MATH_SYMBOL */
    char DOT_OPERATOR = '\u22C5';
    /** ⋆ of type MATH_SYMBOL */
    char STAR_OPERATOR = '\u22C6';
    /** ⋇ of type MATH_SYMBOL */
    char DIVISION_TIMES = '\u22C7';
    /** ⋈ of type MATH_SYMBOL */
    char BOWTIE = '\u22C8';
    /** ⋉ of type MATH_SYMBOL */
    char LEFT_NORMAL_FACTOR_SEMIDIRECT_PRODUCT = '\u22C9';
    /** ⋊ of type MATH_SYMBOL */
    char RIGHT_NORMAL_FACTOR_SEMIDIRECT_PRODUCT = '\u22CA';
    /** ⋋ of type MATH_SYMBOL */
    char LEFT_SEMIDIRECT_PRODUCT = '\u22CB';
    /** ⋌ of type MATH_SYMBOL */
    char RIGHT_SEMIDIRECT_PRODUCT = '\u22CC';
    /** ⋍ of type MATH_SYMBOL */
    char REVERSED_TILDE_EQUALS = '\u22CD';
    /** ⋎ of type MATH_SYMBOL */
    char CURLY_LOGICAL_OR = '\u22CE';
    /** ⋏ of type MATH_SYMBOL */
    char CURLY_LOGICAL_AND = '\u22CF';
    /** ⋐ of type MATH_SYMBOL */
    char DOUBLE_SUBSET = '\u22D0';
    /** ⋑ of type MATH_SYMBOL */
    char DOUBLE_SUPERSET = '\u22D1';
    /** ⋒ of type MATH_SYMBOL */
    char DOUBLE_INTERSECTION = '\u22D2';
    /** ⋓ of type MATH_SYMBOL */
    char DOUBLE_UNION = '\u22D3';
    /** ⋔ of type MATH_SYMBOL */
    char PITCHFORK = '\u22D4';
    /** ⋕ of type MATH_SYMBOL */
    char EQUAL_AND_PARALLEL_TO = '\u22D5';
    /** ⋖ of type MATH_SYMBOL */
    char LESS_THAN_WITH_DOT = '\u22D6';
    /** ⋗ of type MATH_SYMBOL */
    char GREATER_THAN_WITH_DOT = '\u22D7';
    /** ⋘ of type MATH_SYMBOL */
    char VERY_MUCH_LESS_THAN = '\u22D8';
    /** ⋙ of type MATH_SYMBOL */
    char VERY_MUCH_GREATER_THAN = '\u22D9';
    /** ⋚ of type MATH_SYMBOL */
    char LESS_THAN_EQUAL_TO_OR_GREATER_THAN = '\u22DA';
    /** ⋛ of type MATH_SYMBOL */
    char GREATER_THAN_EQUAL_TO_OR_LESS_THAN = '\u22DB';
    /** ⋜ of type MATH_SYMBOL */
    char EQUAL_TO_OR_LESS_THAN = '\u22DC';
    /** ⋝ of type MATH_SYMBOL */
    char EQUAL_TO_OR_GREATER_THAN = '\u22DD';
    /** ⋞ of type MATH_SYMBOL */
    char EQUAL_TO_OR_PRECEDES = '\u22DE';
    /** ⋟ of type MATH_SYMBOL */
    char EQUAL_TO_OR_SUCCEEDS = '\u22DF';
    /** ⋠ of type MATH_SYMBOL */
    char DOES_NOT_PRECEDE_OR_EQUAL = '\u22E0';
    /** ⋡ of type MATH_SYMBOL */
    char DOES_NOT_SUCCEED_OR_EQUAL = '\u22E1';
    /** ⋢ of type MATH_SYMBOL */
    char NOT_SQUARE_IMAGE_OF_OR_EQUAL_TO = '\u22E2';
    /** ⋣ of type MATH_SYMBOL */
    char NOT_SQUARE_ORIGINAL_OF_OR_EQUAL_TO = '\u22E3';
    /** ⋤ of type MATH_SYMBOL */
    char SQUARE_IMAGE_OF_OR_NOT_EQUAL_TO = '\u22E4';
    /** ⋥ of type MATH_SYMBOL */
    char SQUARE_ORIGINAL_OF_OR_NOT_EQUAL_TO = '\u22E5';
    /** ⋦ of type MATH_SYMBOL */
    char LESS_THAN_BUT_NOT_EQUIVALENT_TO = '\u22E6';
    /** ⋧ of type MATH_SYMBOL */
    char GREATER_THAN_BUT_NOT_EQUIVALENT_TO = '\u22E7';
    /** ⋨ of type MATH_SYMBOL */
    char PRECEDES_BUT_NOT_EQUIVALENT_TO = '\u22E8';
    /** ⋩ of type MATH_SYMBOL */
    char SUCCEEDS_BUT_NOT_EQUIVALENT_TO = '\u22E9';
    /** ⋪ of type MATH_SYMBOL */
    char NOT_NORMAL_SUBGROUP_OF = '\u22EA';
    /** ⋫ of type MATH_SYMBOL */
    char DOES_NOT_CONTAIN_AS_NORMAL_SUBGROUP = '\u22EB';
    /** ⋬ of type MATH_SYMBOL */
    char NOT_NORMAL_SUBGROUP_OF_OR_EQUAL_TO = '\u22EC';
    /** ⋭ of type MATH_SYMBOL */
    char DOES_NOT_CONTAIN_AS_NORMAL_SUBGROUP_OR_EQUAL = '\u22ED';
    /** ⋮ of type MATH_SYMBOL */
    char VERTICAL_ELLIPSIS = '\u22EE';
    /** ⋯ of type MATH_SYMBOL */
    char MIDLINE_HORIZONTAL_ELLIPSIS = '\u22EF';
    /** ⋰ of type MATH_SYMBOL */
    char UP_RIGHT_DIAGONAL_ELLIPSIS = '\u22F0';
    /** ⋱ of type MATH_SYMBOL */
    char DOWN_RIGHT_DIAGONAL_ELLIPSIS = '\u22F1';
    /** ⋲ of type MATH_SYMBOL */
    char ELEMENT_OF_WITH_LONG_HORIZONTAL_STROKE = '\u22F2';
    /** ⋳ of type MATH_SYMBOL */
    char ELEMENT_OF_WITH_VERTICAL_BAR_AT_END_OF_HORIZONTAL_STROKE = '\u22F3';
    /** ⋴ of type MATH_SYMBOL */
    char SMALL_ELEMENT_OF_WITH_VERTICAL_BAR_AT_END_OF_HORIZONTAL_STROKE = '\u22F4';
    /** ⋵ of type MATH_SYMBOL */
    char ELEMENT_OF_WITH_DOT_ABOVE = '\u22F5';
    /** ⋶ of type MATH_SYMBOL */
    char ELEMENT_OF_WITH_OVERBAR = '\u22F6';
    /** ⋷ of type MATH_SYMBOL */
    char SMALL_ELEMENT_OF_WITH_OVERBAR = '\u22F7';
    /** ⋸ of type MATH_SYMBOL */
    char ELEMENT_OF_WITH_UNDERBAR = '\u22F8';
    /** ⋹ of type MATH_SYMBOL */
    char ELEMENT_OF_WITH_TWO_HORIZONTAL_STROKES = '\u22F9';
    /** ⋺ of type MATH_SYMBOL */
    char CONTAINS_WITH_LONG_HORIZONTAL_STROKE = '\u22FA';
    /** ⋻ of type MATH_SYMBOL */
    char CONTAINS_WITH_VERTICAL_BAR_AT_END_OF_HORIZONTAL_STROKE = '\u22FB';
    /** ⋼ of type MATH_SYMBOL */
    char SMALL_CONTAINS_WITH_VERTICAL_BAR_AT_END_OF_HORIZONTAL_STROKE = '\u22FC';
    /** ⋽ of type MATH_SYMBOL */
    char CONTAINS_WITH_OVERBAR = '\u22FD';
    /** ⋾ of type MATH_SYMBOL */
    char SMALL_CONTAINS_WITH_OVERBAR = '\u22FE';
    /** ⋿ of type MATH_SYMBOL */
    char Z_NOTATION_BAG_MEMBERSHIP = '\u22FF';
    /** ⌀ of type OTHER_SYMBOL */
    char DIAMETER_SIGN = '\u2300';
    /** ⌁ of type OTHER_SYMBOL */
    char ELECTRIC_ARROW = '\u2301';
    /** ⌂ of type OTHER_SYMBOL */
    char HOUSE = '\u2302';
    /** ⌃ of type OTHER_SYMBOL */
    char UP_ARROWHEAD = '\u2303';
    /** ⌄ of type OTHER_SYMBOL */
    char DOWN_ARROWHEAD = '\u2304';
    /** ⌅ of type OTHER_SYMBOL */
    char PROJECTIVE = '\u2305';
    /** ⌆ of type OTHER_SYMBOL */
    char PERSPECTIVE = '\u2306';
    /** ⌇ of type OTHER_SYMBOL */
    char WAVY_LINE = '\u2307';
    /** ⌈ of type MATH_SYMBOL */
    char LEFT_CEILING = '\u2308';
    /** ⌉ of type MATH_SYMBOL */
    char RIGHT_CEILING = '\u2309';
    /** ⌊ of type MATH_SYMBOL */
    char LEFT_FLOOR = '\u230A';
    /** ⌋ of type MATH_SYMBOL */
    char RIGHT_FLOOR = '\u230B';
    /** ⌌ of type OTHER_SYMBOL */
    char BOTTOM_RIGHT_CROP = '\u230C';
    /** ⌍ of type OTHER_SYMBOL */
    char BOTTOM_LEFT_CROP = '\u230D';
    /** ⌎ of type OTHER_SYMBOL */
    char TOP_RIGHT_CROP = '\u230E';
    /** ⌏ of type OTHER_SYMBOL */
    char TOP_LEFT_CROP = '\u230F';
    /** ⌐ of type OTHER_SYMBOL */
    char REVERSED_NOT_SIGN = '\u2310';
    /** ⌑ of type OTHER_SYMBOL */
    char SQUARE_LOZENGE = '\u2311';
    /** ⌒ of type OTHER_SYMBOL */
    char ARC = '\u2312';
    /** ⌓ of type OTHER_SYMBOL */
    char SEGMENT = '\u2313';
    /** ⌔ of type OTHER_SYMBOL */
    char SECTOR = '\u2314';
    /** ⌕ of type OTHER_SYMBOL */
    char TELEPHONE_RECORDER = '\u2315';
    /** ⌖ of type OTHER_SYMBOL */
    char POSITION_INDICATOR = '\u2316';
    /** ⌗ of type OTHER_SYMBOL */
    char VIEWDATA_SQUARE = '\u2317';
    /** ⌘ of type OTHER_SYMBOL */
    char PLACE_OF_INTEREST_SIGN = '\u2318';
    /** ⌙ of type OTHER_SYMBOL */
    char TURNED_NOT_SIGN = '\u2319';
    /** ⌚ of type OTHER_SYMBOL */
    char WATCH = '\u231A';
    /** ⌛ of type OTHER_SYMBOL */
    char HOURGLASS = '\u231B';
    /** ⌜ of type OTHER_SYMBOL */
    char TOP_LEFT_CORNER = '\u231C';
    /** ⌝ of type OTHER_SYMBOL */
    char TOP_RIGHT_CORNER = '\u231D';
    /** ⌞ of type OTHER_SYMBOL */
    char BOTTOM_LEFT_CORNER = '\u231E';
    /** ⌟ of type OTHER_SYMBOL */
    char BOTTOM_RIGHT_CORNER = '\u231F';
    /** ⌠ of type MATH_SYMBOL */
    char TOP_HALF_INTEGRAL = '\u2320';
    /** ⌡ of type MATH_SYMBOL */
    char BOTTOM_HALF_INTEGRAL = '\u2321';
    /** ⌢ of type OTHER_SYMBOL */
    char FROWN = '\u2322';
    /** ⌣ of type OTHER_SYMBOL */
    char SMILE = '\u2323';
    /** ⌤ of type OTHER_SYMBOL */
    char UP_ARROWHEAD_BETWEEN_TWO_HORIZONTAL_BARS = '\u2324';
    /** ⌥ of type OTHER_SYMBOL */
    char OPTION_KEY = '\u2325';
    /** ⌦ of type OTHER_SYMBOL */
    char ERASE_TO_THE_RIGHT = '\u2326';
    /** ⌧ of type OTHER_SYMBOL */
    char X_IN_A_RECTANGLE_BOX = '\u2327';
    /** ⌨ of type OTHER_SYMBOL */
    char KEYBOARD = '\u2328';
    /** 〈 of type START_PUNCTUATION */
    char LEFT_POINTING_ANGLE_BRACKET = '\u2329';
    /** 〉 of type END_PUNCTUATION */
    char RIGHT_POINTING_ANGLE_BRACKET = '\u232A';
    /** ⌫ of type OTHER_SYMBOL */
    char ERASE_TO_THE_LEFT = '\u232B';
    /** ⌬ of type OTHER_SYMBOL */
    char BENZENE_RING = '\u232C';
    /** ⌭ of type OTHER_SYMBOL */
    char CYLINDRICITY = '\u232D';
    /** ⌮ of type OTHER_SYMBOL */
    char ALL_AROUND_PROFILE = '\u232E';
    /** ⌯ of type OTHER_SYMBOL */
    char SYMMETRY = '\u232F';
    /** ⌰ of type OTHER_SYMBOL */
    char TOTAL_RUNOUT = '\u2330';
    /** ⌱ of type OTHER_SYMBOL */
    char DIMENSION_ORIGIN = '\u2331';
    /** ⌲ of type OTHER_SYMBOL */
    char CONICAL_TAPER = '\u2332';
    /** ⌳ of type OTHER_SYMBOL */
    char SLOPE = '\u2333';
    /** ⌴ of type OTHER_SYMBOL */
    char COUNTERBORE = '\u2334';
    /** ⌵ of type OTHER_SYMBOL */
    char COUNTERSINK = '\u2335';
    /** ⌶ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_I_BEAM = '\u2336';
    /** ⌷ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_SQUISH_QUAD = '\u2337';
    /** ⌸ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_EQUAL = '\u2338';
    /** ⌹ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_DIVIDE = '\u2339';
    /** ⌺ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_DIAMOND = '\u233A';
    /** ⌻ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_JOT = '\u233B';
    /** ⌼ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_CIRCLE = '\u233C';
    /** ⌽ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_CIRCLE_STILE = '\u233D';
    /** ⌾ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_CIRCLE_JOT = '\u233E';
    /** ⌿ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_SLASH_BAR = '\u233F';
    /** ⍀ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_BACKSLASH_BAR = '\u2340';
    /** ⍁ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_SLASH = '\u2341';
    /** ⍂ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_BACKSLASH = '\u2342';
    /** ⍃ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_LESS_THAN = '\u2343';
    /** ⍄ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_GREATER_THAN = '\u2344';
    /** ⍅ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_LEFTWARDS_VANE = '\u2345';
    /** ⍆ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_RIGHTWARDS_VANE = '\u2346';
    /** ⍇ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_LEFTWARDS_ARROW = '\u2347';
    /** ⍈ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_RIGHTWARDS_ARROW = '\u2348';
    /** ⍉ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_CIRCLE_BACKSLASH = '\u2349';
    /** ⍊ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DOWN_TACK_UNDERBAR = '\u234A';
    /** ⍋ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DELTA_STILE = '\u234B';
    /** ⍌ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_DOWN_CARET = '\u234C';
    /** ⍍ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_DELTA = '\u234D';
    /** ⍎ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DOWN_TACK_JOT = '\u234E';
    /** ⍏ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_UPWARDS_VANE = '\u234F';
    /** ⍐ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_UPWARDS_ARROW = '\u2350';
    /** ⍑ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_UP_TACK_OVERBAR = '\u2351';
    /** ⍒ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DEL_STILE = '\u2352';
    /** ⍓ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_UP_CARET = '\u2353';
    /** ⍔ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_DEL = '\u2354';
    /** ⍕ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_UP_TACK_JOT = '\u2355';
    /** ⍖ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DOWNWARDS_VANE = '\u2356';
    /** ⍗ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_DOWNWARDS_ARROW = '\u2357';
    /** ⍘ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUOTE_UNDERBAR = '\u2358';
    /** ⍙ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DELTA_UNDERBAR = '\u2359';
    /** ⍚ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DIAMOND_UNDERBAR = '\u235A';
    /** ⍛ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_JOT_UNDERBAR = '\u235B';
    /** ⍜ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_CIRCLE_UNDERBAR = '\u235C';
    /** ⍝ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_UP_SHOE_JOT = '\u235D';
    /** ⍞ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUOTE_QUAD = '\u235E';
    /** ⍟ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_CIRCLE_STAR = '\u235F';
    /** ⍠ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_COLON = '\u2360';
    /** ⍡ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_UP_TACK_DIAERESIS = '\u2361';
    /** ⍢ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DEL_DIAERESIS = '\u2362';
    /** ⍣ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_STAR_DIAERESIS = '\u2363';
    /** ⍤ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_JOT_DIAERESIS = '\u2364';
    /** ⍥ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_CIRCLE_DIAERESIS = '\u2365';
    /** ⍦ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DOWN_SHOE_STILE = '\u2366';
    /** ⍧ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_LEFT_SHOE_STILE = '\u2367';
    /** ⍨ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_TILDE_DIAERESIS = '\u2368';
    /** ⍩ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_GREATER_THAN_DIAERESIS = '\u2369';
    /** ⍪ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_COMMA_BAR = '\u236A';
    /** ⍫ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DEL_TILDE = '\u236B';
    /** ⍬ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_ZILDE = '\u236C';
    /** ⍭ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_STILE_TILDE = '\u236D';
    /** ⍮ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_SEMICOLON_UNDERBAR = '\u236E';
    /** ⍯ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_NOT_EQUAL = '\u236F';
    /** ⍰ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD_QUESTION = '\u2370';
    /** ⍱ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_DOWN_CARET_TILDE = '\u2371';
    /** ⍲ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_UP_CARET_TILDE = '\u2372';
    /** ⍳ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_IOTA = '\u2373';
    /** ⍴ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_RHO = '\u2374';
    /** ⍵ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_OMEGA = '\u2375';
    /** ⍶ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_ALPHA_UNDERBAR = '\u2376';
    /** ⍷ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_EPSILON_UNDERBAR = '\u2377';
    /** ⍸ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_IOTA_UNDERBAR = '\u2378';
    /** ⍹ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_OMEGA_UNDERBAR = '\u2379';
    /** ⍺ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_ALPHA = '\u237A';
    /** ⍻ of type OTHER_SYMBOL */
    char NOT_CHECK_MARK = '\u237B';
    /** ⍼ of type MATH_SYMBOL */
    char RIGHT_ANGLE_WITH_DOWNWARDS_ZIGZAG_ARROW = '\u237C';
    /** ⍽ of type OTHER_SYMBOL */
    char SHOULDERED_OPEN_BOX = '\u237D';
    /** ⍾ of type OTHER_SYMBOL */
    char BELL_SYMBOL = '\u237E';
    /** ⍿ of type OTHER_SYMBOL */
    char VERTICAL_LINE_WITH_MIDDLE_DOT = '\u237F';
    /** ⎀ of type OTHER_SYMBOL */
    char INSERTION_SYMBOL = '\u2380';
    /** ⎁ of type OTHER_SYMBOL */
    char CONTINUOUS_UNDERLINE_SYMBOL = '\u2381';
    /** ⎂ of type OTHER_SYMBOL */
    char DISCONTINUOUS_UNDERLINE_SYMBOL = '\u2382';
    /** ⎃ of type OTHER_SYMBOL */
    char EMPHASIS_SYMBOL = '\u2383';
    /** ⎄ of type OTHER_SYMBOL */
    char COMPOSITION_SYMBOL = '\u2384';
    /** ⎅ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_CENTRE_VERTICAL_LINE = '\u2385';
    /** ⎆ of type OTHER_SYMBOL */
    char ENTER_SYMBOL = '\u2386';
    /** ⎇ of type OTHER_SYMBOL */
    char ALTERNATIVE_KEY_SYMBOL = '\u2387';
    /** ⎈ of type OTHER_SYMBOL */
    char HELM_SYMBOL = '\u2388';
    /** ⎉ of type OTHER_SYMBOL */
    char CIRCLED_HORIZONTAL_BAR_WITH_NOTCH = '\u2389';
    /** ⎊ of type OTHER_SYMBOL */
    char CIRCLED_TRIANGLE_DOWN = '\u238A';
    /** ⎋ of type OTHER_SYMBOL */
    char BROKEN_CIRCLE_WITH_NORTHWEST_ARROW = '\u238B';
    /** ⎌ of type OTHER_SYMBOL */
    char UNDO_SYMBOL = '\u238C';
    /** ⎍ of type OTHER_SYMBOL */
    char MONOSTABLE_SYMBOL = '\u238D';
    /** ⎎ of type OTHER_SYMBOL */
    char HYSTERESIS_SYMBOL = '\u238E';
    /** ⎏ of type OTHER_SYMBOL */
    char OPEN_CIRCUIT_OUTPUT_H_TYPE_SYMBOL = '\u238F';
    /** ⎐ of type OTHER_SYMBOL */
    char OPEN_CIRCUIT_OUTPUT_L_TYPE_SYMBOL = '\u2390';
    /** ⎑ of type OTHER_SYMBOL */
    char PASSIVE_PULL_DOWN_OUTPUT_SYMBOL = '\u2391';
    /** ⎒ of type OTHER_SYMBOL */
    char PASSIVE_PULL_UP_OUTPUT_SYMBOL = '\u2392';
    /** ⎓ of type OTHER_SYMBOL */
    char DIRECT_CURRENT_SYMBOL_FORM_TWO = '\u2393';
    /** ⎔ of type OTHER_SYMBOL */
    char SOFTWARE_FUNCTION_SYMBOL = '\u2394';
    /** ⎕ of type OTHER_SYMBOL */
    char APL_FUNCTIONAL_SYMBOL_QUAD = '\u2395';
    /** ⎖ of type OTHER_SYMBOL */
    char DECIMAL_SEPARATOR_KEY_SYMBOL = '\u2396';
    /** ⎗ of type OTHER_SYMBOL */
    char PREVIOUS_PAGE = '\u2397';
    /** ⎘ of type OTHER_SYMBOL */
    char NEXT_PAGE = '\u2398';
    /** ⎙ of type OTHER_SYMBOL */
    char PRINT_SCREEN_SYMBOL = '\u2399';
    /** ⎚ of type OTHER_SYMBOL */
    char CLEAR_SCREEN_SYMBOL = '\u239A';
    /** ⎛ of type MATH_SYMBOL */
    char LEFT_PARENTHESIS_UPPER_HOOK = '\u239B';
    /** ⎜ of type MATH_SYMBOL */
    char LEFT_PARENTHESIS_EXTENSION = '\u239C';
    /** ⎝ of type MATH_SYMBOL */
    char LEFT_PARENTHESIS_LOWER_HOOK = '\u239D';
    /** ⎞ of type MATH_SYMBOL */
    char RIGHT_PARENTHESIS_UPPER_HOOK = '\u239E';
    /** ⎟ of type MATH_SYMBOL */
    char RIGHT_PARENTHESIS_EXTENSION = '\u239F';
    /** ⎠ of type MATH_SYMBOL */
    char RIGHT_PARENTHESIS_LOWER_HOOK = '\u23A0';
    /** ⎡ of type MATH_SYMBOL */
    char LEFT_SQUARE_BRACKET_UPPER_CORNER = '\u23A1';
    /** ⎢ of type MATH_SYMBOL */
    char LEFT_SQUARE_BRACKET_EXTENSION = '\u23A2';
    /** ⎣ of type MATH_SYMBOL */
    char LEFT_SQUARE_BRACKET_LOWER_CORNER = '\u23A3';
    /** ⎤ of type MATH_SYMBOL */
    char RIGHT_SQUARE_BRACKET_UPPER_CORNER = '\u23A4';
    /** ⎥ of type MATH_SYMBOL */
    char RIGHT_SQUARE_BRACKET_EXTENSION = '\u23A5';
    /** ⎦ of type MATH_SYMBOL */
    char RIGHT_SQUARE_BRACKET_LOWER_CORNER = '\u23A6';
    /** ⎧ of type MATH_SYMBOL */
    char LEFT_CURLY_BRACKET_UPPER_HOOK = '\u23A7';
    /** ⎨ of type MATH_SYMBOL */
    char LEFT_CURLY_BRACKET_MIDDLE_PIECE = '\u23A8';
    /** ⎩ of type MATH_SYMBOL */
    char LEFT_CURLY_BRACKET_LOWER_HOOK = '\u23A9';
    /** ⎪ of type MATH_SYMBOL */
    char CURLY_BRACKET_EXTENSION = '\u23AA';
    /** ⎫ of type MATH_SYMBOL */
    char RIGHT_CURLY_BRACKET_UPPER_HOOK = '\u23AB';
    /** ⎬ of type MATH_SYMBOL */
    char RIGHT_CURLY_BRACKET_MIDDLE_PIECE = '\u23AC';
    /** ⎭ of type MATH_SYMBOL */
    char RIGHT_CURLY_BRACKET_LOWER_HOOK = '\u23AD';
    /** ⎮ of type MATH_SYMBOL */
    char INTEGRAL_EXTENSION = '\u23AE';
    /** ⎯ of type MATH_SYMBOL */
    char HORIZONTAL_LINE_EXTENSION = '\u23AF';
    /** ⎰ of type MATH_SYMBOL */
    char UPPER_LEFT_OR_LOWER_RIGHT_CURLY_BRACKET_SECTION = '\u23B0';
    /** ⎱ of type MATH_SYMBOL */
    char UPPER_RIGHT_OR_LOWER_LEFT_CURLY_BRACKET_SECTION = '\u23B1';
    /** ⎲ of type MATH_SYMBOL */
    char SUMMATION_TOP = '\u23B2';
    /** ⎳ of type MATH_SYMBOL */
    char SUMMATION_BOTTOM = '\u23B3';
    /** ⎴ of type OTHER_SYMBOL */
    char TOP_SQUARE_BRACKET = '\u23B4';
    /** ⎵ of type OTHER_SYMBOL */
    char BOTTOM_SQUARE_BRACKET = '\u23B5';
    /** ⎶ of type OTHER_SYMBOL */
    char BOTTOM_SQUARE_BRACKET_OVER_TOP_SQUARE_BRACKET = '\u23B6';
    /** ⎷ of type OTHER_SYMBOL */
    char RADICAL_SYMBOL_BOTTOM = '\u23B7';
    /** ⎸ of type OTHER_SYMBOL */
    char LEFT_VERTICAL_BOX_LINE = '\u23B8';
    /** ⎹ of type OTHER_SYMBOL */
    char RIGHT_VERTICAL_BOX_LINE = '\u23B9';
    /** ⎺ of type OTHER_SYMBOL */
    char HORIZONTAL_SCAN_LINE_1 = '\u23BA';
    /** ⎻ of type OTHER_SYMBOL */
    char HORIZONTAL_SCAN_LINE_3 = '\u23BB';
    /** ⎼ of type OTHER_SYMBOL */
    char HORIZONTAL_SCAN_LINE_7 = '\u23BC';
    /** ⎽ of type OTHER_SYMBOL */
    char HORIZONTAL_SCAN_LINE_9 = '\u23BD';
    /** ⎾ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_AND_TOP_RIGHT = '\u23BE';
    /** ⎿ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_AND_BOTTOM_RIGHT = '\u23BF';
    /** ⏀ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_WITH_CIRCLE = '\u23C0';
    /** ⏁ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_DOWN_AND_HORIZONTAL_WITH_CIRCLE = '\u23C1';
    /** ⏂ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_UP_AND_HORIZONTAL_WITH_CIRCLE = '\u23C2';
    /** ⏃ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_WITH_TRIANGLE = '\u23C3';
    /** ⏄ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_DOWN_AND_HORIZONTAL_WITH_TRIANGLE = '\u23C4';
    /** ⏅ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_UP_AND_HORIZONTAL_WITH_TRIANGLE = '\u23C5';
    /** ⏆ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_AND_WAVE = '\u23C6';
    /** ⏇ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_DOWN_AND_HORIZONTAL_WITH_WAVE = '\u23C7';
    /** ⏈ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_UP_AND_HORIZONTAL_WITH_WAVE = '\u23C8';
    /** ⏉ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_DOWN_AND_HORIZONTAL = '\u23C9';
    /** ⏊ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_UP_AND_HORIZONTAL = '\u23CA';
    /** ⏋ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_AND_TOP_LEFT = '\u23CB';
    /** ⏌ of type OTHER_SYMBOL */
    char DENTISTRY_SYMBOL_LIGHT_VERTICAL_AND_BOTTOM_LEFT = '\u23CC';
    /** ⏍ of type OTHER_SYMBOL */
    char SQUARE_FOOT = '\u23CD';
    /** ⏎ of type OTHER_SYMBOL */
    char RETURN_SYMBOL = '\u23CE';
    /** ⏏ of type OTHER_SYMBOL */
    char EJECT_SYMBOL = '\u23CF';
    /** ⏐ of type OTHER_SYMBOL */
    char VERTICAL_LINE_EXTENSION = '\u23D0';
    /** ⏑ of type OTHER_SYMBOL */
    char METRICAL_BREVE = '\u23D1';
    /** ⏒ of type OTHER_SYMBOL */
    char METRICAL_LONG_OVER_SHORT = '\u23D2';
    /** ⏓ of type OTHER_SYMBOL */
    char METRICAL_SHORT_OVER_LONG = '\u23D3';
    /** ⏔ of type OTHER_SYMBOL */
    char METRICAL_LONG_OVER_TWO_SHORTS = '\u23D4';
    /** ⏕ of type OTHER_SYMBOL */
    char METRICAL_TWO_SHORTS_OVER_LONG = '\u23D5';
    /** ⏖ of type OTHER_SYMBOL */
    char METRICAL_TWO_SHORTS_JOINED = '\u23D6';
    /** ⏗ of type OTHER_SYMBOL */
    char METRICAL_TRISEME = '\u23D7';
    /** ⏘ of type OTHER_SYMBOL */
    char METRICAL_TETRASEME = '\u23D8';
    /** ⏙ of type OTHER_SYMBOL */
    char METRICAL_PENTASEME = '\u23D9';
    /** ⏚ of type OTHER_SYMBOL */
    char EARTH_GROUND = '\u23DA';
    /** ⏛ of type OTHER_SYMBOL */
    char FUSE = '\u23DB';
    /** ⏜ of type MATH_SYMBOL */
    char TOP_PARENTHESIS = '\u23DC';
    /** ⏝ of type MATH_SYMBOL */
    char BOTTOM_PARENTHESIS = '\u23DD';
    /** ⏞ of type MATH_SYMBOL */
    char TOP_CURLY_BRACKET = '\u23DE';
    /** ⏟ of type MATH_SYMBOL */
    char BOTTOM_CURLY_BRACKET = '\u23DF';
    /** ⏠ of type MATH_SYMBOL */
    char TOP_TORTOISE_SHELL_BRACKET = '\u23E0';
    /** ⏡ of type MATH_SYMBOL */
    char BOTTOM_TORTOISE_SHELL_BRACKET = '\u23E1';
    /** ⏢ of type OTHER_SYMBOL */
    char WHITE_TRAPEZIUM = '\u23E2';
    /** ⏣ of type OTHER_SYMBOL */
    char BENZENE_RING_WITH_CIRCLE = '\u23E3';
    /** ⏤ of type OTHER_SYMBOL */
    char STRAIGHTNESS = '\u23E4';
    /** ⏥ of type OTHER_SYMBOL */
    char FLATNESS = '\u23E5';
    /** ⏦ of type OTHER_SYMBOL */
    char AC_CURRENT = '\u23E6';
    /** ⏧ of type OTHER_SYMBOL */
    char ELECTRICAL_INTERSECTION = '\u23E7';
    /** ⏨ of type OTHER_SYMBOL */
    char DECIMAL_EXPONENT_SYMBOL = '\u23E8';
    /** ⏩ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_DOUBLE_TRIANGLE = '\u23E9';
    /** ⏪ of type OTHER_SYMBOL */
    char BLACK_LEFT_POINTING_DOUBLE_TRIANGLE = '\u23EA';
    /** ⏫ of type OTHER_SYMBOL */
    char BLACK_UP_POINTING_DOUBLE_TRIANGLE = '\u23EB';
    /** ⏬ of type OTHER_SYMBOL */
    char BLACK_DOWN_POINTING_DOUBLE_TRIANGLE = '\u23EC';
    /** ⏭ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_DOUBLE_TRIANGLE_WITH_VERTICAL_BAR = '\u23ED';
    /** ⏮ of type OTHER_SYMBOL */
    char BLACK_LEFT_POINTING_DOUBLE_TRIANGLE_WITH_VERTICAL_BAR = '\u23EE';
    /** ⏯ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_TRIANGLE_WITH_DOUBLE_VERTICAL_BAR = '\u23EF';
    /** ⏰ of type OTHER_SYMBOL */
    char ALARM_CLOCK = '\u23F0';
    /** ⏱ of type OTHER_SYMBOL */
    char STOPWATCH = '\u23F1';
    /** ⏲ of type OTHER_SYMBOL */
    char TIMER_CLOCK = '\u23F2';
    /** ⏳ of type OTHER_SYMBOL */
    char HOURGLASS_WITH_FLOWING_SAND = '\u23F3';
    /** ␀ of type OTHER_SYMBOL */
    char SYMBOL_FOR_NULL = '\u2400';
    /** ␁ of type OTHER_SYMBOL */
    char SYMBOL_FOR_START_OF_HEADING = '\u2401';
    /** ␂ of type OTHER_SYMBOL */
    char SYMBOL_FOR_START_OF_TEXT = '\u2402';
    /** ␃ of type OTHER_SYMBOL */
    char SYMBOL_FOR_END_OF_TEXT = '\u2403';
    /** ␄ of type OTHER_SYMBOL */
    char SYMBOL_FOR_END_OF_TRANSMISSION = '\u2404';
    /** ␅ of type OTHER_SYMBOL */
    char SYMBOL_FOR_ENQUIRY = '\u2405';
    /** ␆ of type OTHER_SYMBOL */
    char SYMBOL_FOR_ACKNOWLEDGE = '\u2406';
    /** ␇ of type OTHER_SYMBOL */
    char SYMBOL_FOR_BELL = '\u2407';
    /** ␈ of type OTHER_SYMBOL */
    char SYMBOL_FOR_BACKSPACE = '\u2408';
    /** ␉ of type OTHER_SYMBOL */
    char SYMBOL_FOR_HORIZONTAL_TABULATION = '\u2409';
    /** ␊ of type OTHER_SYMBOL */
    char SYMBOL_FOR_LINE_FEED = '\u240A';
    /** ␋ of type OTHER_SYMBOL */
    char SYMBOL_FOR_VERTICAL_TABULATION = '\u240B';
    /** ␌ of type OTHER_SYMBOL */
    char SYMBOL_FOR_FORM_FEED = '\u240C';
    /** ␍ of type OTHER_SYMBOL */
    char SYMBOL_FOR_CARRIAGE_RETURN = '\u240D';
    /** ␎ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SHIFT_OUT = '\u240E';
    /** ␏ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SHIFT_IN = '\u240F';
    /** ␐ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DATA_LINK_ESCAPE = '\u2410';
    /** ␑ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DEVICE_CONTROL_ONE = '\u2411';
    /** ␒ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DEVICE_CONTROL_TWO = '\u2412';
    /** ␓ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DEVICE_CONTROL_THREE = '\u2413';
    /** ␔ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DEVICE_CONTROL_FOUR = '\u2414';
    /** ␕ of type OTHER_SYMBOL */
    char SYMBOL_FOR_NEGATIVE_ACKNOWLEDGE = '\u2415';
    /** ␖ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SYNCHRONOUS_IDLE = '\u2416';
    /** ␗ of type OTHER_SYMBOL */
    char SYMBOL_FOR_END_OF_TRANSMISSION_BLOCK = '\u2417';
    /** ␘ of type OTHER_SYMBOL */
    char SYMBOL_FOR_CANCEL = '\u2418';
    /** ␙ of type OTHER_SYMBOL */
    char SYMBOL_FOR_END_OF_MEDIUM = '\u2419';
    /** ␚ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SUBSTITUTE = '\u241A';
    /** ␛ of type OTHER_SYMBOL */
    char SYMBOL_FOR_ESCAPE = '\u241B';
    /** ␜ of type OTHER_SYMBOL */
    char SYMBOL_FOR_FILE_SEPARATOR = '\u241C';
    /** ␝ of type OTHER_SYMBOL */
    char SYMBOL_FOR_GROUP_SEPARATOR = '\u241D';
    /** ␞ of type OTHER_SYMBOL */
    char SYMBOL_FOR_RECORD_SEPARATOR = '\u241E';
    /** ␟ of type OTHER_SYMBOL */
    char SYMBOL_FOR_UNIT_SEPARATOR = '\u241F';
    /** ␠ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SPACE = '\u2420';
    /** ␡ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DELETE = '\u2421';
    /** ␢ of type OTHER_SYMBOL */
    char BLANK_SYMBOL = '\u2422';
    /** ␣ of type OTHER_SYMBOL */
    char OPEN_BOX = '\u2423';
    /** ␤ of type OTHER_SYMBOL */
    char SYMBOL_FOR_NEWLINE = '\u2424';
    /** ␥ of type OTHER_SYMBOL */
    char SYMBOL_FOR_DELETE_FORM_TWO = '\u2425';
    /** ␦ of type OTHER_SYMBOL */
    char SYMBOL_FOR_SUBSTITUTE_FORM_TWO = '\u2426';
    /** ⑀ of type OTHER_SYMBOL */
    char OCR_HOOK = '\u2440';
    /** ⑁ of type OTHER_SYMBOL */
    char OCR_CHAIR = '\u2441';
    /** ⑂ of type OTHER_SYMBOL */
    char OCR_FORK = '\u2442';
    /** ⑃ of type OTHER_SYMBOL */
    char OCR_INVERTED_FORK = '\u2443';
    /** ⑄ of type OTHER_SYMBOL */
    char OCR_BELT_BUCKLE = '\u2444';
    /** ⑅ of type OTHER_SYMBOL */
    char OCR_BOW_TIE = '\u2445';
    /** ⑆ of type OTHER_SYMBOL */
    char OCR_BRANCH_BANK_IDENTIFICATION = '\u2446';
    /** ⑇ of type OTHER_SYMBOL */
    char OCR_AMOUNT_OF_CHECK = '\u2447';
    /** ⑈ of type OTHER_SYMBOL */
    char OCR_DASH = '\u2448';
    /** ⑉ of type OTHER_SYMBOL */
    char OCR_CUSTOMER_ACCOUNT_NUMBER = '\u2449';
    /** ⑊ of type OTHER_SYMBOL */
    char OCR_DOUBLE_BACKSLASH = '\u244A';
    /** ① of type OTHER_NUMBER */
    char CIRCLED_DIGIT_ONE = '\u2460';
    /** ② of type OTHER_NUMBER */
    char CIRCLED_DIGIT_TWO = '\u2461';
    /** ③ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_THREE = '\u2462';
    /** ④ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_FOUR = '\u2463';
    /** ⑤ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_FIVE = '\u2464';
    /** ⑥ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_SIX = '\u2465';
    /** ⑦ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_SEVEN = '\u2466';
    /** ⑧ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_EIGHT = '\u2467';
    /** ⑨ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_NINE = '\u2468';
    /** ⑩ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TEN = '\u2469';
    /** ⑪ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_ELEVEN = '\u246A';
    /** ⑫ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWELVE = '\u246B';
    /** ⑬ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTEEN = '\u246C';
    /** ⑭ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FOURTEEN = '\u246D';
    /** ⑮ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FIFTEEN = '\u246E';
    /** ⑯ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_SIXTEEN = '\u246F';
    /** ⑰ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_SEVENTEEN = '\u2470';
    /** ⑱ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_EIGHTEEN = '\u2471';
    /** ⑲ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_NINETEEN = '\u2472';
    /** ⑳ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY = '\u2473';
    /** ⑴ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_ONE = '\u2474';
    /** ⑵ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_TWO = '\u2475';
    /** ⑶ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_THREE = '\u2476';
    /** ⑷ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_FOUR = '\u2477';
    /** ⑸ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_FIVE = '\u2478';
    /** ⑹ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_SIX = '\u2479';
    /** ⑺ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_SEVEN = '\u247A';
    /** ⑻ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_EIGHT = '\u247B';
    /** ⑼ of type OTHER_NUMBER */
    char PARENTHESIZED_DIGIT_NINE = '\u247C';
    /** ⑽ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_TEN = '\u247D';
    /** ⑾ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_ELEVEN = '\u247E';
    /** ⑿ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_TWELVE = '\u247F';
    /** ⒀ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_THIRTEEN = '\u2480';
    /** ⒁ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_FOURTEEN = '\u2481';
    /** ⒂ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_FIFTEEN = '\u2482';
    /** ⒃ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_SIXTEEN = '\u2483';
    /** ⒄ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_SEVENTEEN = '\u2484';
    /** ⒅ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_EIGHTEEN = '\u2485';
    /** ⒆ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_NINETEEN = '\u2486';
    /** ⒇ of type OTHER_NUMBER */
    char PARENTHESIZED_NUMBER_TWENTY = '\u2487';
    /** ⒈ of type OTHER_NUMBER */
    char DIGIT_ONE_FULL_STOP = '\u2488';
    /** ⒉ of type OTHER_NUMBER */
    char DIGIT_TWO_FULL_STOP = '\u2489';
    /** ⒊ of type OTHER_NUMBER */
    char DIGIT_THREE_FULL_STOP = '\u248A';
    /** ⒋ of type OTHER_NUMBER */
    char DIGIT_FOUR_FULL_STOP = '\u248B';
    /** ⒌ of type OTHER_NUMBER */
    char DIGIT_FIVE_FULL_STOP = '\u248C';
    /** ⒍ of type OTHER_NUMBER */
    char DIGIT_SIX_FULL_STOP = '\u248D';
    /** ⒎ of type OTHER_NUMBER */
    char DIGIT_SEVEN_FULL_STOP = '\u248E';
    /** ⒏ of type OTHER_NUMBER */
    char DIGIT_EIGHT_FULL_STOP = '\u248F';
    /** ⒐ of type OTHER_NUMBER */
    char DIGIT_NINE_FULL_STOP = '\u2490';
    /** ⒑ of type OTHER_NUMBER */
    char NUMBER_TEN_FULL_STOP = '\u2491';
    /** ⒒ of type OTHER_NUMBER */
    char NUMBER_ELEVEN_FULL_STOP = '\u2492';
    /** ⒓ of type OTHER_NUMBER */
    char NUMBER_TWELVE_FULL_STOP = '\u2493';
    /** ⒔ of type OTHER_NUMBER */
    char NUMBER_THIRTEEN_FULL_STOP = '\u2494';
    /** ⒕ of type OTHER_NUMBER */
    char NUMBER_FOURTEEN_FULL_STOP = '\u2495';
    /** ⒖ of type OTHER_NUMBER */
    char NUMBER_FIFTEEN_FULL_STOP = '\u2496';
    /** ⒗ of type OTHER_NUMBER */
    char NUMBER_SIXTEEN_FULL_STOP = '\u2497';
    /** ⒘ of type OTHER_NUMBER */
    char NUMBER_SEVENTEEN_FULL_STOP = '\u2498';
    /** ⒙ of type OTHER_NUMBER */
    char NUMBER_EIGHTEEN_FULL_STOP = '\u2499';
    /** ⒚ of type OTHER_NUMBER */
    char NUMBER_NINETEEN_FULL_STOP = '\u249A';
    /** ⒛ of type OTHER_NUMBER */
    char NUMBER_TWENTY_FULL_STOP = '\u249B';
    /** ⒜ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_A = '\u249C';
    /** ⒝ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_B = '\u249D';
    /** ⒞ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_C = '\u249E';
    /** ⒟ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_D = '\u249F';
    /** ⒠ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_E = '\u24A0';
    /** ⒡ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_F = '\u24A1';
    /** ⒢ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_G = '\u24A2';
    /** ⒣ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_H = '\u24A3';
    /** ⒤ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_I = '\u24A4';
    /** ⒥ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_J = '\u24A5';
    /** ⒦ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_K = '\u24A6';
    /** ⒧ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_L = '\u24A7';
    /** ⒨ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_M = '\u24A8';
    /** ⒩ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_N = '\u24A9';
    /** ⒪ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_O = '\u24AA';
    /** ⒫ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_P = '\u24AB';
    /** ⒬ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_Q = '\u24AC';
    /** ⒭ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_R = '\u24AD';
    /** ⒮ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_S = '\u24AE';
    /** ⒯ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_T = '\u24AF';
    /** ⒰ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_U = '\u24B0';
    /** ⒱ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_V = '\u24B1';
    /** ⒲ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_W = '\u24B2';
    /** ⒳ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_X = '\u24B3';
    /** ⒴ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_Y = '\u24B4';
    /** ⒵ of type OTHER_SYMBOL */
    char PARENTHESIZED_LATIN_SMALL_LETTER_Z = '\u24B5';
    /** Ⓐ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_A = '\u24B6';
    /** Ⓑ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_B = '\u24B7';
    /** Ⓒ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_C = '\u24B8';
    /** Ⓓ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_D = '\u24B9';
    /** Ⓔ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_E = '\u24BA';
    /** Ⓕ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_F = '\u24BB';
    /** Ⓖ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_G = '\u24BC';
    /** Ⓗ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_H = '\u24BD';
    /** Ⓘ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_I = '\u24BE';
    /** Ⓙ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_J = '\u24BF';
    /** Ⓚ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_K = '\u24C0';
    /** Ⓛ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_L = '\u24C1';
    /** Ⓜ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_M = '\u24C2';
    /** Ⓝ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_N = '\u24C3';
    /** Ⓞ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_O = '\u24C4';
    /** Ⓟ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_P = '\u24C5';
    /** Ⓠ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_Q = '\u24C6';
    /** Ⓡ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_R = '\u24C7';
    /** Ⓢ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_S = '\u24C8';
    /** Ⓣ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_T = '\u24C9';
    /** Ⓤ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_U = '\u24CA';
    /** Ⓥ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_V = '\u24CB';
    /** Ⓦ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_W = '\u24CC';
    /** Ⓧ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_X = '\u24CD';
    /** Ⓨ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_Y = '\u24CE';
    /** Ⓩ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_CAPITAL_LETTER_Z = '\u24CF';
    /** ⓐ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_A = '\u24D0';
    /** ⓑ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_B = '\u24D1';
    /** ⓒ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_C = '\u24D2';
    /** ⓓ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_D = '\u24D3';
    /** ⓔ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_E = '\u24D4';
    /** ⓕ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_F = '\u24D5';
    /** ⓖ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_G = '\u24D6';
    /** ⓗ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_H = '\u24D7';
    /** ⓘ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_I = '\u24D8';
    /** ⓙ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_J = '\u24D9';
    /** ⓚ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_K = '\u24DA';
    /** ⓛ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_L = '\u24DB';
    /** ⓜ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_M = '\u24DC';
    /** ⓝ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_N = '\u24DD';
    /** ⓞ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_O = '\u24DE';
    /** ⓟ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_P = '\u24DF';
    /** ⓠ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_Q = '\u24E0';
    /** ⓡ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_R = '\u24E1';
    /** ⓢ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_S = '\u24E2';
    /** ⓣ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_T = '\u24E3';
    /** ⓤ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_U = '\u24E4';
    /** ⓥ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_V = '\u24E5';
    /** ⓦ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_W = '\u24E6';
    /** ⓧ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_X = '\u24E7';
    /** ⓨ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_Y = '\u24E8';
    /** ⓩ of type OTHER_SYMBOL */
    char CIRCLED_LATIN_SMALL_LETTER_Z = '\u24E9';
    /** ⓪ of type OTHER_NUMBER */
    char CIRCLED_DIGIT_ZERO = '\u24EA';
    /** ⓫ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_ELEVEN = '\u24EB';
    /** ⓬ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_TWELVE = '\u24EC';
    /** ⓭ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_THIRTEEN = '\u24ED';
    /** ⓮ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_FOURTEEN = '\u24EE';
    /** ⓯ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_FIFTEEN = '\u24EF';
    /** ⓰ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_SIXTEEN = '\u24F0';
    /** ⓱ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_SEVENTEEN = '\u24F1';
    /** ⓲ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_EIGHTEEN = '\u24F2';
    /** ⓳ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_NINETEEN = '\u24F3';
    /** ⓴ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_NUMBER_TWENTY = '\u24F4';
    /** ⓵ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_ONE = '\u24F5';
    /** ⓶ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_TWO = '\u24F6';
    /** ⓷ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_THREE = '\u24F7';
    /** ⓸ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_FOUR = '\u24F8';
    /** ⓹ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_FIVE = '\u24F9';
    /** ⓺ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_SIX = '\u24FA';
    /** ⓻ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_SEVEN = '\u24FB';
    /** ⓼ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_EIGHT = '\u24FC';
    /** ⓽ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_DIGIT_NINE = '\u24FD';
    /** ⓾ of type OTHER_NUMBER */
    char DOUBLE_CIRCLED_NUMBER_TEN = '\u24FE';
    /** ⓿ of type OTHER_NUMBER */
    char NEGATIVE_CIRCLED_DIGIT_ZERO = '\u24FF';
    /** ─ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_HORIZONTAL = '\u2500';
    /** ━ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_HORIZONTAL = '\u2501';
    /** │ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_VERTICAL = '\u2502';
    /** ┃ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_VERTICAL = '\u2503';
    /** ┄ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_TRIPLE_DASH_HORIZONTAL = '\u2504';
    /** ┅ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_TRIPLE_DASH_HORIZONTAL = '\u2505';
    /** ┆ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_TRIPLE_DASH_VERTICAL = '\u2506';
    /** ┇ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_TRIPLE_DASH_VERTICAL = '\u2507';
    /** ┈ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_QUADRUPLE_DASH_HORIZONTAL = '\u2508';
    /** ┉ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_QUADRUPLE_DASH_HORIZONTAL = '\u2509';
    /** ┊ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_QUADRUPLE_DASH_VERTICAL = '\u250A';
    /** ┋ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_QUADRUPLE_DASH_VERTICAL = '\u250B';
    /** ┌ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DOWN_AND_RIGHT = '\u250C';
    /** ┍ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_LIGHT_AND_RIGHT_HEAVY = '\u250D';
    /** ┎ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_HEAVY_AND_RIGHT_LIGHT = '\u250E';
    /** ┏ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_DOWN_AND_RIGHT = '\u250F';
    /** ┐ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DOWN_AND_LEFT = '\u2510';
    /** ┑ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_LIGHT_AND_LEFT_HEAVY = '\u2511';
    /** ┒ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_HEAVY_AND_LEFT_LIGHT = '\u2512';
    /** ┓ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_DOWN_AND_LEFT = '\u2513';
    /** └ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_UP_AND_RIGHT = '\u2514';
    /** ┕ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_LIGHT_AND_RIGHT_HEAVY = '\u2515';
    /** ┖ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_HEAVY_AND_RIGHT_LIGHT = '\u2516';
    /** ┗ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_UP_AND_RIGHT = '\u2517';
    /** ┘ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_UP_AND_LEFT = '\u2518';
    /** ┙ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_LIGHT_AND_LEFT_HEAVY = '\u2519';
    /** ┚ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_HEAVY_AND_LEFT_LIGHT = '\u251A';
    /** ┛ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_UP_AND_LEFT = '\u251B';
    /** ├ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_VERTICAL_AND_RIGHT = '\u251C';
    /** ┝ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_LIGHT_AND_RIGHT_HEAVY = '\u251D';
    /** ┞ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_HEAVY_AND_RIGHT_DOWN_LIGHT = '\u251E';
    /** ┟ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_HEAVY_AND_RIGHT_UP_LIGHT = '\u251F';
    /** ┠ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_HEAVY_AND_RIGHT_LIGHT = '\u2520';
    /** ┡ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_LIGHT_AND_RIGHT_UP_HEAVY = '\u2521';
    /** ┢ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_LIGHT_AND_RIGHT_DOWN_HEAVY = '\u2522';
    /** ┣ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_VERTICAL_AND_RIGHT = '\u2523';
    /** ┤ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_VERTICAL_AND_LEFT = '\u2524';
    /** ┥ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_LIGHT_AND_LEFT_HEAVY = '\u2525';
    /** ┦ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_HEAVY_AND_LEFT_DOWN_LIGHT = '\u2526';
    /** ┧ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_HEAVY_AND_LEFT_UP_LIGHT = '\u2527';
    /** ┨ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_HEAVY_AND_LEFT_LIGHT = '\u2528';
    /** ┩ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_LIGHT_AND_LEFT_UP_HEAVY = '\u2529';
    /** ┪ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_LIGHT_AND_LEFT_DOWN_HEAVY = '\u252A';
    /** ┫ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_VERTICAL_AND_LEFT = '\u252B';
    /** ┬ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DOWN_AND_HORIZONTAL = '\u252C';
    /** ┭ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_HEAVY_AND_RIGHT_DOWN_LIGHT = '\u252D';
    /** ┮ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_HEAVY_AND_LEFT_DOWN_LIGHT = '\u252E';
    /** ┯ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_LIGHT_AND_HORIZONTAL_HEAVY = '\u252F';
    /** ┰ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_HEAVY_AND_HORIZONTAL_LIGHT = '\u2530';
    /** ┱ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_LIGHT_AND_LEFT_DOWN_HEAVY = '\u2531';
    /** ┲ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_LIGHT_AND_RIGHT_DOWN_HEAVY = '\u2532';
    /** ┳ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_DOWN_AND_HORIZONTAL = '\u2533';
    /** ┴ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_UP_AND_HORIZONTAL = '\u2534';
    /** ┵ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_HEAVY_AND_RIGHT_UP_LIGHT = '\u2535';
    /** ┶ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_HEAVY_AND_LEFT_UP_LIGHT = '\u2536';
    /** ┷ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_LIGHT_AND_HORIZONTAL_HEAVY = '\u2537';
    /** ┸ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_HEAVY_AND_HORIZONTAL_LIGHT = '\u2538';
    /** ┹ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_LIGHT_AND_LEFT_UP_HEAVY = '\u2539';
    /** ┺ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_LIGHT_AND_RIGHT_UP_HEAVY = '\u253A';
    /** ┻ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_UP_AND_HORIZONTAL = '\u253B';
    /** ┼ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_VERTICAL_AND_HORIZONTAL = '\u253C';
    /** ┽ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_HEAVY_AND_RIGHT_VERTICAL_LIGHT = '\u253D';
    /** ┾ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_HEAVY_AND_LEFT_VERTICAL_LIGHT = '\u253E';
    /** ┿ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_LIGHT_AND_HORIZONTAL_HEAVY = '\u253F';
    /** ╀ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_HEAVY_AND_DOWN_HORIZONTAL_LIGHT = '\u2540';
    /** ╁ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_HEAVY_AND_UP_HORIZONTAL_LIGHT = '\u2541';
    /** ╂ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_HEAVY_AND_HORIZONTAL_LIGHT = '\u2542';
    /** ╃ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_UP_HEAVY_AND_RIGHT_DOWN_LIGHT = '\u2543';
    /** ╄ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_UP_HEAVY_AND_LEFT_DOWN_LIGHT = '\u2544';
    /** ╅ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_DOWN_HEAVY_AND_RIGHT_UP_LIGHT = '\u2545';
    /** ╆ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_DOWN_HEAVY_AND_LEFT_UP_LIGHT = '\u2546';
    /** ╇ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_LIGHT_AND_UP_HORIZONTAL_HEAVY = '\u2547';
    /** ╈ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_LIGHT_AND_DOWN_HORIZONTAL_HEAVY = '\u2548';
    /** ╉ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_RIGHT_LIGHT_AND_LEFT_VERTICAL_HEAVY = '\u2549';
    /** ╊ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LEFT_LIGHT_AND_RIGHT_VERTICAL_HEAVY = '\u254A';
    /** ╋ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_VERTICAL_AND_HORIZONTAL = '\u254B';
    /** ╌ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DOUBLE_DASH_HORIZONTAL = '\u254C';
    /** ╍ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_DOUBLE_DASH_HORIZONTAL = '\u254D';
    /** ╎ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DOUBLE_DASH_VERTICAL = '\u254E';
    /** ╏ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_DOUBLE_DASH_VERTICAL = '\u254F';
    /** ═ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_HORIZONTAL = '\u2550';
    /** ║ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_VERTICAL = '\u2551';
    /** ╒ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_SINGLE_AND_RIGHT_DOUBLE = '\u2552';
    /** ╓ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_DOUBLE_AND_RIGHT_SINGLE = '\u2553';
    /** ╔ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_DOWN_AND_RIGHT = '\u2554';
    /** ╕ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_SINGLE_AND_LEFT_DOUBLE = '\u2555';
    /** ╖ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_DOUBLE_AND_LEFT_SINGLE = '\u2556';
    /** ╗ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_DOWN_AND_LEFT = '\u2557';
    /** ╘ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_SINGLE_AND_RIGHT_DOUBLE = '\u2558';
    /** ╙ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_DOUBLE_AND_RIGHT_SINGLE = '\u2559';
    /** ╚ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_UP_AND_RIGHT = '\u255A';
    /** ╛ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_SINGLE_AND_LEFT_DOUBLE = '\u255B';
    /** ╜ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_DOUBLE_AND_LEFT_SINGLE = '\u255C';
    /** ╝ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_UP_AND_LEFT = '\u255D';
    /** ╞ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_SINGLE_AND_RIGHT_DOUBLE = '\u255E';
    /** ╟ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_DOUBLE_AND_RIGHT_SINGLE = '\u255F';
    /** ╠ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_VERTICAL_AND_RIGHT = '\u2560';
    /** ╡ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_SINGLE_AND_LEFT_DOUBLE = '\u2561';
    /** ╢ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_DOUBLE_AND_LEFT_SINGLE = '\u2562';
    /** ╣ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_VERTICAL_AND_LEFT = '\u2563';
    /** ╤ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_SINGLE_AND_HORIZONTAL_DOUBLE = '\u2564';
    /** ╥ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOWN_DOUBLE_AND_HORIZONTAL_SINGLE = '\u2565';
    /** ╦ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_DOWN_AND_HORIZONTAL = '\u2566';
    /** ╧ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_SINGLE_AND_HORIZONTAL_DOUBLE = '\u2567';
    /** ╨ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_UP_DOUBLE_AND_HORIZONTAL_SINGLE = '\u2568';
    /** ╩ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_UP_AND_HORIZONTAL = '\u2569';
    /** ╪ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_SINGLE_AND_HORIZONTAL_DOUBLE = '\u256A';
    /** ╫ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_VERTICAL_DOUBLE_AND_HORIZONTAL_SINGLE = '\u256B';
    /** ╬ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_DOUBLE_VERTICAL_AND_HORIZONTAL = '\u256C';
    /** ╭ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_ARC_DOWN_AND_RIGHT = '\u256D';
    /** ╮ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_ARC_DOWN_AND_LEFT = '\u256E';
    /** ╯ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_ARC_UP_AND_LEFT = '\u256F';
    /** ╰ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_ARC_UP_AND_RIGHT = '\u2570';
    /** ╱ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DIAGONAL_UPPER_RIGHT_TO_LOWER_LEFT = '\u2571';
    /** ╲ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DIAGONAL_UPPER_LEFT_TO_LOWER_RIGHT = '\u2572';
    /** ╳ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DIAGONAL_CROSS = '\u2573';
    /** ╴ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_LEFT = '\u2574';
    /** ╵ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_UP = '\u2575';
    /** ╶ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_RIGHT = '\u2576';
    /** ╷ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_DOWN = '\u2577';
    /** ╸ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_LEFT = '\u2578';
    /** ╹ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_UP = '\u2579';
    /** ╺ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_RIGHT = '\u257A';
    /** ╻ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_DOWN = '\u257B';
    /** ╼ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_LEFT_AND_HEAVY_RIGHT = '\u257C';
    /** ╽ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_LIGHT_UP_AND_HEAVY_DOWN = '\u257D';
    /** ╾ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_LEFT_AND_LIGHT_RIGHT = '\u257E';
    /** ╿ of type OTHER_SYMBOL */
    char BOX_DRAWINGS_HEAVY_UP_AND_LIGHT_DOWN = '\u257F';
    /** ▀ of type OTHER_SYMBOL */
    char UPPER_HALF_BLOCK = '\u2580';
    /** ▁ of type OTHER_SYMBOL */
    char LOWER_ONE_EIGHTH_BLOCK = '\u2581';
    /** ▂ of type OTHER_SYMBOL */
    char LOWER_ONE_QUARTER_BLOCK = '\u2582';
    /** ▃ of type OTHER_SYMBOL */
    char LOWER_THREE_EIGHTHS_BLOCK = '\u2583';
    /** ▄ of type OTHER_SYMBOL */
    char LOWER_HALF_BLOCK = '\u2584';
    /** ▅ of type OTHER_SYMBOL */
    char LOWER_FIVE_EIGHTHS_BLOCK = '\u2585';
    /** ▆ of type OTHER_SYMBOL */
    char LOWER_THREE_QUARTERS_BLOCK = '\u2586';
    /** ▇ of type OTHER_SYMBOL */
    char LOWER_SEVEN_EIGHTHS_BLOCK = '\u2587';
    /** █ of type OTHER_SYMBOL */
    char FULL_BLOCK = '\u2588';
    /** ▉ of type OTHER_SYMBOL */
    char LEFT_SEVEN_EIGHTHS_BLOCK = '\u2589';
    /** ▊ of type OTHER_SYMBOL */
    char LEFT_THREE_QUARTERS_BLOCK = '\u258A';
    /** ▋ of type OTHER_SYMBOL */
    char LEFT_FIVE_EIGHTHS_BLOCK = '\u258B';
    /** ▌ of type OTHER_SYMBOL */
    char LEFT_HALF_BLOCK = '\u258C';
    /** ▍ of type OTHER_SYMBOL */
    char LEFT_THREE_EIGHTHS_BLOCK = '\u258D';
    /** ▎ of type OTHER_SYMBOL */
    char LEFT_ONE_QUARTER_BLOCK = '\u258E';
    /** ▏ of type OTHER_SYMBOL */
    char LEFT_ONE_EIGHTH_BLOCK = '\u258F';
    /** ▐ of type OTHER_SYMBOL */
    char RIGHT_HALF_BLOCK = '\u2590';
    /** ░ of type OTHER_SYMBOL */
    char LIGHT_SHADE = '\u2591';
    /** ▒ of type OTHER_SYMBOL */
    char MEDIUM_SHADE = '\u2592';
    /** ▓ of type OTHER_SYMBOL */
    char DARK_SHADE = '\u2593';
    /** ▔ of type OTHER_SYMBOL */
    char UPPER_ONE_EIGHTH_BLOCK = '\u2594';
    /** ▕ of type OTHER_SYMBOL */
    char RIGHT_ONE_EIGHTH_BLOCK = '\u2595';
    /** ▖ of type OTHER_SYMBOL */
    char QUADRANT_LOWER_LEFT = '\u2596';
    /** ▗ of type OTHER_SYMBOL */
    char QUADRANT_LOWER_RIGHT = '\u2597';
    /** ▘ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_LEFT = '\u2598';
    /** ▙ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_LEFT_AND_LOWER_LEFT_AND_LOWER_RIGHT = '\u2599';
    /** ▚ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_LEFT_AND_LOWER_RIGHT = '\u259A';
    /** ▛ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_LEFT_AND_UPPER_RIGHT_AND_LOWER_LEFT = '\u259B';
    /** ▜ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_LEFT_AND_UPPER_RIGHT_AND_LOWER_RIGHT = '\u259C';
    /** ▝ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_RIGHT = '\u259D';
    /** ▞ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_RIGHT_AND_LOWER_LEFT = '\u259E';
    /** ▟ of type OTHER_SYMBOL */
    char QUADRANT_UPPER_RIGHT_AND_LOWER_LEFT_AND_LOWER_RIGHT = '\u259F';
    /** ■ of type OTHER_SYMBOL */
    char BLACK_SQUARE = '\u25A0';
    /** □ of type OTHER_SYMBOL */
    char WHITE_SQUARE = '\u25A1';
    /** ▢ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_ROUNDED_CORNERS = '\u25A2';
    /** ▣ of type OTHER_SYMBOL */
    char WHITE_SQUARE_CONTAINING_BLACK_SMALL_SQUARE = '\u25A3';
    /** ▤ of type OTHER_SYMBOL */
    char SQUARE_WITH_HORIZONTAL_FILL = '\u25A4';
    /** ▥ of type OTHER_SYMBOL */
    char SQUARE_WITH_VERTICAL_FILL = '\u25A5';
    /** ▦ of type OTHER_SYMBOL */
    char SQUARE_WITH_ORTHOGONAL_CROSSHATCH_FILL = '\u25A6';
    /** ▧ of type OTHER_SYMBOL */
    char SQUARE_WITH_UPPER_LEFT_TO_LOWER_RIGHT_FILL = '\u25A7';
    /** ▨ of type OTHER_SYMBOL */
    char SQUARE_WITH_UPPER_RIGHT_TO_LOWER_LEFT_FILL = '\u25A8';
    /** ▩ of type OTHER_SYMBOL */
    char SQUARE_WITH_DIAGONAL_CROSSHATCH_FILL = '\u25A9';
    /** ▪ of type OTHER_SYMBOL */
    char BLACK_SMALL_SQUARE = '\u25AA';
    /** ▫ of type OTHER_SYMBOL */
    char WHITE_SMALL_SQUARE = '\u25AB';
    /** ▬ of type OTHER_SYMBOL */
    char BLACK_RECTANGLE = '\u25AC';
    /** ▭ of type OTHER_SYMBOL */
    char WHITE_RECTANGLE = '\u25AD';
    /** ▮ of type OTHER_SYMBOL */
    char BLACK_VERTICAL_RECTANGLE = '\u25AE';
    /** ▯ of type OTHER_SYMBOL */
    char WHITE_VERTICAL_RECTANGLE = '\u25AF';
    /** ▰ of type OTHER_SYMBOL */
    char BLACK_PARALLELOGRAM = '\u25B0';
    /** ▱ of type OTHER_SYMBOL */
    char WHITE_PARALLELOGRAM = '\u25B1';
    /** ▲ of type OTHER_SYMBOL */
    char BLACK_UP_POINTING_TRIANGLE = '\u25B2';
    /** △ of type OTHER_SYMBOL */
    char WHITE_UP_POINTING_TRIANGLE = '\u25B3';
    /** ▴ of type OTHER_SYMBOL */
    char BLACK_UP_POINTING_SMALL_TRIANGLE = '\u25B4';
    /** ▵ of type OTHER_SYMBOL */
    char WHITE_UP_POINTING_SMALL_TRIANGLE = '\u25B5';
    /** ▶ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_TRIANGLE = '\u25B6';
    /** ▷ of type MATH_SYMBOL */
    char WHITE_RIGHT_POINTING_TRIANGLE = '\u25B7';
    /** ▸ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_SMALL_TRIANGLE = '\u25B8';
    /** ▹ of type OTHER_SYMBOL */
    char WHITE_RIGHT_POINTING_SMALL_TRIANGLE = '\u25B9';
    /** ► of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_POINTER = '\u25BA';
    /** ▻ of type OTHER_SYMBOL */
    char WHITE_RIGHT_POINTING_POINTER = '\u25BB';
    /** ▼ of type OTHER_SYMBOL */
    char BLACK_DOWN_POINTING_TRIANGLE = '\u25BC';
    /** ▽ of type OTHER_SYMBOL */
    char WHITE_DOWN_POINTING_TRIANGLE = '\u25BD';
    /** ▾ of type OTHER_SYMBOL */
    char BLACK_DOWN_POINTING_SMALL_TRIANGLE = '\u25BE';
    /** ▿ of type OTHER_SYMBOL */
    char WHITE_DOWN_POINTING_SMALL_TRIANGLE = '\u25BF';
    /** ◀ of type OTHER_SYMBOL */
    char BLACK_LEFT_POINTING_TRIANGLE = '\u25C0';
    /** ◁ of type MATH_SYMBOL */
    char WHITE_LEFT_POINTING_TRIANGLE = '\u25C1';
    /** ◂ of type OTHER_SYMBOL */
    char BLACK_LEFT_POINTING_SMALL_TRIANGLE = '\u25C2';
    /** ◃ of type OTHER_SYMBOL */
    char WHITE_LEFT_POINTING_SMALL_TRIANGLE = '\u25C3';
    /** ◄ of type OTHER_SYMBOL */
    char BLACK_LEFT_POINTING_POINTER = '\u25C4';
    /** ◅ of type OTHER_SYMBOL */
    char WHITE_LEFT_POINTING_POINTER = '\u25C5';
    /** ◆ of type OTHER_SYMBOL */
    char BLACK_DIAMOND = '\u25C6';
    /** ◇ of type OTHER_SYMBOL */
    char WHITE_DIAMOND = '\u25C7';
    /** ◈ of type OTHER_SYMBOL */
    char WHITE_DIAMOND_CONTAINING_BLACK_SMALL_DIAMOND = '\u25C8';
    /** ◉ of type OTHER_SYMBOL */
    char FISHEYE = '\u25C9';
    /** ◊ of type OTHER_SYMBOL */
    char LOZENGE = '\u25CA';
    /** ○ of type OTHER_SYMBOL */
    char WHITE_CIRCLE = '\u25CB';
    /** ◌ of type OTHER_SYMBOL */
    char DOTTED_CIRCLE = '\u25CC';
    /** ◍ of type OTHER_SYMBOL */
    char CIRCLE_WITH_VERTICAL_FILL = '\u25CD';
    /** ◎ of type OTHER_SYMBOL */
    char BULLSEYE = '\u25CE';
    /** ● of type OTHER_SYMBOL */
    char BLACK_CIRCLE = '\u25CF';
    /** ◐ of type OTHER_SYMBOL */
    char CIRCLE_WITH_LEFT_HALF_BLACK = '\u25D0';
    /** ◑ of type OTHER_SYMBOL */
    char CIRCLE_WITH_RIGHT_HALF_BLACK = '\u25D1';
    /** ◒ of type OTHER_SYMBOL */
    char CIRCLE_WITH_LOWER_HALF_BLACK = '\u25D2';
    /** ◓ of type OTHER_SYMBOL */
    char CIRCLE_WITH_UPPER_HALF_BLACK = '\u25D3';
    /** ◔ of type OTHER_SYMBOL */
    char CIRCLE_WITH_UPPER_RIGHT_QUADRANT_BLACK = '\u25D4';
    /** ◕ of type OTHER_SYMBOL */
    char CIRCLE_WITH_ALL_BUT_UPPER_LEFT_QUADRANT_BLACK = '\u25D5';
    /** ◖ of type OTHER_SYMBOL */
    char LEFT_HALF_BLACK_CIRCLE = '\u25D6';
    /** ◗ of type OTHER_SYMBOL */
    char RIGHT_HALF_BLACK_CIRCLE = '\u25D7';
    /** ◘ of type OTHER_SYMBOL */
    char INVERSE_BULLET = '\u25D8';
    /** ◙ of type OTHER_SYMBOL */
    char INVERSE_WHITE_CIRCLE = '\u25D9';
    /** ◚ of type OTHER_SYMBOL */
    char UPPER_HALF_INVERSE_WHITE_CIRCLE = '\u25DA';
    /** ◛ of type OTHER_SYMBOL */
    char LOWER_HALF_INVERSE_WHITE_CIRCLE = '\u25DB';
    /** ◜ of type OTHER_SYMBOL */
    char UPPER_LEFT_QUADRANT_CIRCULAR_ARC = '\u25DC';
    /** ◝ of type OTHER_SYMBOL */
    char UPPER_RIGHT_QUADRANT_CIRCULAR_ARC = '\u25DD';
    /** ◞ of type OTHER_SYMBOL */
    char LOWER_RIGHT_QUADRANT_CIRCULAR_ARC = '\u25DE';
    /** ◟ of type OTHER_SYMBOL */
    char LOWER_LEFT_QUADRANT_CIRCULAR_ARC = '\u25DF';
    /** ◠ of type OTHER_SYMBOL */
    char UPPER_HALF_CIRCLE = '\u25E0';
    /** ◡ of type OTHER_SYMBOL */
    char LOWER_HALF_CIRCLE = '\u25E1';
    /** ◢ of type OTHER_SYMBOL */
    char BLACK_LOWER_RIGHT_TRIANGLE = '\u25E2';
    /** ◣ of type OTHER_SYMBOL */
    char BLACK_LOWER_LEFT_TRIANGLE = '\u25E3';
    /** ◤ of type OTHER_SYMBOL */
    char BLACK_UPPER_LEFT_TRIANGLE = '\u25E4';
    /** ◥ of type OTHER_SYMBOL */
    char BLACK_UPPER_RIGHT_TRIANGLE = '\u25E5';
    /** ◦ of type OTHER_SYMBOL */
    char WHITE_BULLET = '\u25E6';
    /** ◧ of type OTHER_SYMBOL */
    char SQUARE_WITH_LEFT_HALF_BLACK = '\u25E7';
    /** ◨ of type OTHER_SYMBOL */
    char SQUARE_WITH_RIGHT_HALF_BLACK = '\u25E8';
    /** ◩ of type OTHER_SYMBOL */
    char SQUARE_WITH_UPPER_LEFT_DIAGONAL_HALF_BLACK = '\u25E9';
    /** ◪ of type OTHER_SYMBOL */
    char SQUARE_WITH_LOWER_RIGHT_DIAGONAL_HALF_BLACK = '\u25EA';
    /** ◫ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_VERTICAL_BISECTING_LINE = '\u25EB';
    /** ◬ of type OTHER_SYMBOL */
    char WHITE_UP_POINTING_TRIANGLE_WITH_DOT = '\u25EC';
    /** ◭ of type OTHER_SYMBOL */
    char UP_POINTING_TRIANGLE_WITH_LEFT_HALF_BLACK = '\u25ED';
    /** ◮ of type OTHER_SYMBOL */
    char UP_POINTING_TRIANGLE_WITH_RIGHT_HALF_BLACK = '\u25EE';
    /** ◯ of type OTHER_SYMBOL */
    char LARGE_CIRCLE = '\u25EF';
    /** ◰ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_UPPER_LEFT_QUADRANT = '\u25F0';
    /** ◱ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_LOWER_LEFT_QUADRANT = '\u25F1';
    /** ◲ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_LOWER_RIGHT_QUADRANT = '\u25F2';
    /** ◳ of type OTHER_SYMBOL */
    char WHITE_SQUARE_WITH_UPPER_RIGHT_QUADRANT = '\u25F3';
    /** ◴ of type OTHER_SYMBOL */
    char WHITE_CIRCLE_WITH_UPPER_LEFT_QUADRANT = '\u25F4';
    /** ◵ of type OTHER_SYMBOL */
    char WHITE_CIRCLE_WITH_LOWER_LEFT_QUADRANT = '\u25F5';
    /** ◶ of type OTHER_SYMBOL */
    char WHITE_CIRCLE_WITH_LOWER_RIGHT_QUADRANT = '\u25F6';
    /** ◷ of type OTHER_SYMBOL */
    char WHITE_CIRCLE_WITH_UPPER_RIGHT_QUADRANT = '\u25F7';
    /** ◸ of type MATH_SYMBOL */
    char UPPER_LEFT_TRIANGLE = '\u25F8';
    /** ◹ of type MATH_SYMBOL */
    char UPPER_RIGHT_TRIANGLE = '\u25F9';
    /** ◺ of type MATH_SYMBOL */
    char LOWER_LEFT_TRIANGLE = '\u25FA';
    /** ◻ of type MATH_SYMBOL */
    char WHITE_MEDIUM_SQUARE = '\u25FB';
    /** ◼ of type MATH_SYMBOL */
    char BLACK_MEDIUM_SQUARE = '\u25FC';
    /** ◽ of type MATH_SYMBOL */
    char WHITE_MEDIUM_SMALL_SQUARE = '\u25FD';
    /** ◾ of type MATH_SYMBOL */
    char BLACK_MEDIUM_SMALL_SQUARE = '\u25FE';
    /** ◿ of type MATH_SYMBOL */
    char LOWER_RIGHT_TRIANGLE = '\u25FF';
    /** ☀ of type OTHER_SYMBOL */
    char BLACK_SUN_WITH_RAYS = '\u2600';
    /** ☁ of type OTHER_SYMBOL */
    char CLOUD = '\u2601';
    /** ☂ of type OTHER_SYMBOL */
    char UMBRELLA = '\u2602';
    /** ☃ of type OTHER_SYMBOL */
    char SNOWMAN = '\u2603';
    /** ☄ of type OTHER_SYMBOL */
    char COMET = '\u2604';
    /** ★ of type OTHER_SYMBOL */
    char BLACK_STAR = '\u2605';
    /** ☆ of type OTHER_SYMBOL */
    char WHITE_STAR = '\u2606';
    /** ☇ of type OTHER_SYMBOL */
    char LIGHTNING = '\u2607';
    /** ☈ of type OTHER_SYMBOL */
    char THUNDERSTORM = '\u2608';
    /** ☉ of type OTHER_SYMBOL */
    char SUN = '\u2609';
    /** ☊ of type OTHER_SYMBOL */
    char ASCENDING_NODE = '\u260A';
    /** ☋ of type OTHER_SYMBOL */
    char DESCENDING_NODE = '\u260B';
    /** ☌ of type OTHER_SYMBOL */
    char CONJUNCTION = '\u260C';
    /** ☍ of type OTHER_SYMBOL */
    char OPPOSITION = '\u260D';
    /** ☎ of type OTHER_SYMBOL */
    char BLACK_TELEPHONE = '\u260E';
    /** ☏ of type OTHER_SYMBOL */
    char WHITE_TELEPHONE = '\u260F';
    /** ☐ of type OTHER_SYMBOL */
    char BALLOT_BOX = '\u2610';
    /** ☑ of type OTHER_SYMBOL */
    char BALLOT_BOX_WITH_CHECK = '\u2611';
    /** ☒ of type OTHER_SYMBOL */
    char BALLOT_BOX_WITH_X = '\u2612';
    /** ☓ of type OTHER_SYMBOL */
    char SALTIRE = '\u2613';
    /** ☔ of type OTHER_SYMBOL */
    char UMBRELLA_WITH_RAIN_DROPS = '\u2614';
    /** ☕ of type OTHER_SYMBOL */
    char HOT_BEVERAGE = '\u2615';
    /** ☖ of type OTHER_SYMBOL */
    char WHITE_SHOGI_PIECE = '\u2616';
    /** ☗ of type OTHER_SYMBOL */
    char BLACK_SHOGI_PIECE = '\u2617';
    /** ☘ of type OTHER_SYMBOL */
    char SHAMROCK = '\u2618';
    /** ☙ of type OTHER_SYMBOL */
    char REVERSED_ROTATED_FLORAL_HEART_BULLET = '\u2619';
    /** ☚ of type OTHER_SYMBOL */
    char BLACK_LEFT_POINTING_INDEX = '\u261A';
    /** ☛ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_INDEX = '\u261B';
    /** ☜ of type OTHER_SYMBOL */
    char WHITE_LEFT_POINTING_INDEX = '\u261C';
    /** ☝ of type OTHER_SYMBOL */
    char WHITE_UP_POINTING_INDEX = '\u261D';
    /** ☞ of type OTHER_SYMBOL */
    char WHITE_RIGHT_POINTING_INDEX = '\u261E';
    /** ☟ of type OTHER_SYMBOL */
    char WHITE_DOWN_POINTING_INDEX = '\u261F';
    /** ☠ of type OTHER_SYMBOL */
    char SKULL_AND_CROSSBONES = '\u2620';
    /** ☡ of type OTHER_SYMBOL */
    char CAUTION_SIGN = '\u2621';
    /** ☢ of type OTHER_SYMBOL */
    char RADIOACTIVE_SIGN = '\u2622';
    /** ☣ of type OTHER_SYMBOL */
    char BIOHAZARD_SIGN = '\u2623';
    /** ☤ of type OTHER_SYMBOL */
    char CADUCEUS = '\u2624';
    /** ☥ of type OTHER_SYMBOL */
    char ANKH = '\u2625';
    /** ☦ of type OTHER_SYMBOL */
    char ORTHODOX_CROSS = '\u2626';
    /** ☧ of type OTHER_SYMBOL */
    char CHI_RHO = '\u2627';
    /** ☨ of type OTHER_SYMBOL */
    char CROSS_OF_LORRAINE = '\u2628';
    /** ☩ of type OTHER_SYMBOL */
    char CROSS_OF_JERUSALEM = '\u2629';
    /** ☪ of type OTHER_SYMBOL */
    char STAR_AND_CRESCENT = '\u262A';
    /** ☫ of type OTHER_SYMBOL */
    char FARSI_SYMBOL = '\u262B';
    /** ☬ of type OTHER_SYMBOL */
    char ADI_SHAKTI = '\u262C';
    /** ☭ of type OTHER_SYMBOL */
    char HAMMER_AND_SICKLE = '\u262D';
    /** ☮ of type OTHER_SYMBOL */
    char PEACE_SYMBOL = '\u262E';
    /** ☯ of type OTHER_SYMBOL */
    char YIN_YANG = '\u262F';
    /** ☰ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_HEAVEN = '\u2630';
    /** ☱ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_LAKE = '\u2631';
    /** ☲ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_FIRE = '\u2632';
    /** ☳ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_THUNDER = '\u2633';
    /** ☴ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_WIND = '\u2634';
    /** ☵ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_WATER = '\u2635';
    /** ☶ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_MOUNTAIN = '\u2636';
    /** ☷ of type OTHER_SYMBOL */
    char TRIGRAM_FOR_EARTH = '\u2637';
    /** ☸ of type OTHER_SYMBOL */
    char WHEEL_OF_DHARMA = '\u2638';
    /** ☹ of type OTHER_SYMBOL */
    char WHITE_FROWNING_FACE = '\u2639';
    /** ☺ of type OTHER_SYMBOL */
    char WHITE_SMILING_FACE = '\u263A';
    /** ☻ of type OTHER_SYMBOL */
    char BLACK_SMILING_FACE = '\u263B';
    /** ☼ of type OTHER_SYMBOL */
    char WHITE_SUN_WITH_RAYS = '\u263C';
    /** ☽ of type OTHER_SYMBOL */
    char FIRST_QUARTER_MOON = '\u263D';
    /** ☾ of type OTHER_SYMBOL */
    char LAST_QUARTER_MOON = '\u263E';
    /** ☿ of type OTHER_SYMBOL */
    char MERCURY = '\u263F';
    /** ♀ of type OTHER_SYMBOL */
    char FEMALE_SIGN = '\u2640';
    /** ♁ of type OTHER_SYMBOL */
    char EARTH = '\u2641';
    /** ♂ of type OTHER_SYMBOL */
    char MALE_SIGN = '\u2642';
    /** ♃ of type OTHER_SYMBOL */
    char JUPITER = '\u2643';
    /** ♄ of type OTHER_SYMBOL */
    char SATURN = '\u2644';
    /** ♅ of type OTHER_SYMBOL */
    char URANUS = '\u2645';
    /** ♆ of type OTHER_SYMBOL */
    char NEPTUNE = '\u2646';
    /** ♇ of type OTHER_SYMBOL */
    char PLUTO = '\u2647';
    /** ♈ of type OTHER_SYMBOL */
    char ARIES = '\u2648';
    /** ♉ of type OTHER_SYMBOL */
    char TAURUS = '\u2649';
    /** ♊ of type OTHER_SYMBOL */
    char GEMINI = '\u264A';
    /** ♋ of type OTHER_SYMBOL */
    char CANCER = '\u264B';
    /** ♌ of type OTHER_SYMBOL */
    char LEO = '\u264C';
    /** ♍ of type OTHER_SYMBOL */
    char VIRGO = '\u264D';
    /** ♎ of type OTHER_SYMBOL */
    char LIBRA = '\u264E';
    /** ♏ of type OTHER_SYMBOL */
    char SCORPIUS = '\u264F';
    /** ♐ of type OTHER_SYMBOL */
    char SAGITTARIUS = '\u2650';
    /** ♑ of type OTHER_SYMBOL */
    char CAPRICORN = '\u2651';
    /** ♒ of type OTHER_SYMBOL */
    char AQUARIUS = '\u2652';
    /** ♓ of type OTHER_SYMBOL */
    char PISCES = '\u2653';
    /** ♔ of type OTHER_SYMBOL */
    char WHITE_CHESS_KING = '\u2654';
    /** ♕ of type OTHER_SYMBOL */
    char WHITE_CHESS_QUEEN = '\u2655';
    /** ♖ of type OTHER_SYMBOL */
    char WHITE_CHESS_ROOK = '\u2656';
    /** ♗ of type OTHER_SYMBOL */
    char WHITE_CHESS_BISHOP = '\u2657';
    /** ♘ of type OTHER_SYMBOL */
    char WHITE_CHESS_KNIGHT = '\u2658';
    /** ♙ of type OTHER_SYMBOL */
    char WHITE_CHESS_PAWN = '\u2659';
    /** ♚ of type OTHER_SYMBOL */
    char BLACK_CHESS_KING = '\u265A';
    /** ♛ of type OTHER_SYMBOL */
    char BLACK_CHESS_QUEEN = '\u265B';
    /** ♜ of type OTHER_SYMBOL */
    char BLACK_CHESS_ROOK = '\u265C';
    /** ♝ of type OTHER_SYMBOL */
    char BLACK_CHESS_BISHOP = '\u265D';
    /** ♞ of type OTHER_SYMBOL */
    char BLACK_CHESS_KNIGHT = '\u265E';
    /** ♟ of type OTHER_SYMBOL */
    char BLACK_CHESS_PAWN = '\u265F';
    /** ♠ of type OTHER_SYMBOL */
    char BLACK_SPADE_SUIT = '\u2660';
    /** ♡ of type OTHER_SYMBOL */
    char WHITE_HEART_SUIT = '\u2661';
    /** ♢ of type OTHER_SYMBOL */
    char WHITE_DIAMOND_SUIT = '\u2662';
    /** ♣ of type OTHER_SYMBOL */
    char BLACK_CLUB_SUIT = '\u2663';
    /** ♤ of type OTHER_SYMBOL */
    char WHITE_SPADE_SUIT = '\u2664';
    /** ♥ of type OTHER_SYMBOL */
    char BLACK_HEART_SUIT = '\u2665';
    /** ♦ of type OTHER_SYMBOL */
    char BLACK_DIAMOND_SUIT = '\u2666';
    /** ♧ of type OTHER_SYMBOL */
    char WHITE_CLUB_SUIT = '\u2667';
    /** ♨ of type OTHER_SYMBOL */
    char HOT_SPRINGS = '\u2668';
    /** ♩ of type OTHER_SYMBOL */
    char QUARTER_NOTE = '\u2669';
    /** ♪ of type OTHER_SYMBOL */
    char EIGHTH_NOTE = '\u266A';
    /** ♫ of type OTHER_SYMBOL */
    char BEAMED_EIGHTH_NOTES = '\u266B';
    /** ♬ of type OTHER_SYMBOL */
    char BEAMED_SIXTEENTH_NOTES = '\u266C';
    /** ♭ of type OTHER_SYMBOL */
    char MUSIC_FLAT_SIGN = '\u266D';
    /** ♮ of type OTHER_SYMBOL */
    char MUSIC_NATURAL_SIGN = '\u266E';
    /** ♯ of type MATH_SYMBOL */
    char MUSIC_SHARP_SIGN = '\u266F';
    /** ♰ of type OTHER_SYMBOL */
    char WEST_SYRIAC_CROSS = '\u2670';
    /** ♱ of type OTHER_SYMBOL */
    char EAST_SYRIAC_CROSS = '\u2671';
    /** ♲ of type OTHER_SYMBOL */
    char UNIVERSAL_RECYCLING_SYMBOL = '\u2672';
    /** ♳ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_1_PLASTICS = '\u2673';
    /** ♴ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_2_PLASTICS = '\u2674';
    /** ♵ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_3_PLASTICS = '\u2675';
    /** ♶ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_4_PLASTICS = '\u2676';
    /** ♷ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_5_PLASTICS = '\u2677';
    /** ♸ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_6_PLASTICS = '\u2678';
    /** ♹ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_TYPE_7_PLASTICS = '\u2679';
    /** ♺ of type OTHER_SYMBOL */
    char RECYCLING_SYMBOL_FOR_GENERIC_MATERIALS = '\u267A';
    /** ♻ of type OTHER_SYMBOL */
    char BLACK_UNIVERSAL_RECYCLING_SYMBOL = '\u267B';
    /** ♼ of type OTHER_SYMBOL */
    char RECYCLED_PAPER_SYMBOL = '\u267C';
    /** ♽ of type OTHER_SYMBOL */
    char PARTIALLY_RECYCLED_PAPER_SYMBOL = '\u267D';
    /** ♾ of type OTHER_SYMBOL */
    char PERMANENT_PAPER_SIGN = '\u267E';
    /** ♿ of type OTHER_SYMBOL */
    char WHEELCHAIR_SYMBOL = '\u267F';
    /** ⚀ of type OTHER_SYMBOL */
    char DIE_FACE_1 = '\u2680';
    /** ⚁ of type OTHER_SYMBOL */
    char DIE_FACE_2 = '\u2681';
    /** ⚂ of type OTHER_SYMBOL */
    char DIE_FACE_3 = '\u2682';
    /** ⚃ of type OTHER_SYMBOL */
    char DIE_FACE_4 = '\u2683';
    /** ⚄ of type OTHER_SYMBOL */
    char DIE_FACE_5 = '\u2684';
    /** ⚅ of type OTHER_SYMBOL */
    char DIE_FACE_6 = '\u2685';
    /** ⚆ of type OTHER_SYMBOL */
    char WHITE_CIRCLE_WITH_DOT_RIGHT = '\u2686';
    /** ⚇ of type OTHER_SYMBOL */
    char WHITE_CIRCLE_WITH_TWO_DOTS = '\u2687';
    /** ⚈ of type OTHER_SYMBOL */
    char BLACK_CIRCLE_WITH_WHITE_DOT_RIGHT = '\u2688';
    /** ⚉ of type OTHER_SYMBOL */
    char BLACK_CIRCLE_WITH_TWO_WHITE_DOTS = '\u2689';
    /** ⚊ of type OTHER_SYMBOL */
    char MONOGRAM_FOR_YANG = '\u268A';
    /** ⚋ of type OTHER_SYMBOL */
    char MONOGRAM_FOR_YIN = '\u268B';
    /** ⚌ of type OTHER_SYMBOL */
    char DIGRAM_FOR_GREATER_YANG = '\u268C';
    /** ⚍ of type OTHER_SYMBOL */
    char DIGRAM_FOR_LESSER_YIN = '\u268D';
    /** ⚎ of type OTHER_SYMBOL */
    char DIGRAM_FOR_LESSER_YANG = '\u268E';
    /** ⚏ of type OTHER_SYMBOL */
    char DIGRAM_FOR_GREATER_YIN = '\u268F';
    /** ⚐ of type OTHER_SYMBOL */
    char WHITE_FLAG = '\u2690';
    /** ⚑ of type OTHER_SYMBOL */
    char BLACK_FLAG = '\u2691';
    /** ⚒ of type OTHER_SYMBOL */
    char HAMMER_AND_PICK = '\u2692';
    /** ⚓ of type OTHER_SYMBOL */
    char ANCHOR = '\u2693';
    /** ⚔ of type OTHER_SYMBOL */
    char CROSSED_SWORDS = '\u2694';
    /** ⚕ of type OTHER_SYMBOL */
    char STAFF_OF_AESCULAPIUS = '\u2695';
    /** ⚖ of type OTHER_SYMBOL */
    char SCALES = '\u2696';
    /** ⚗ of type OTHER_SYMBOL */
    char ALEMBIC = '\u2697';
    /** ⚘ of type OTHER_SYMBOL */
    char FLOWER = '\u2698';
    /** ⚙ of type OTHER_SYMBOL */
    char GEAR = '\u2699';
    /** ⚚ of type OTHER_SYMBOL */
    char STAFF_OF_HERMES = '\u269A';
    /** ⚛ of type OTHER_SYMBOL */
    char ATOM_SYMBOL = '\u269B';
    /** ⚜ of type OTHER_SYMBOL */
    char FLEUR_DE_LIS = '\u269C';
    /** ⚝ of type OTHER_SYMBOL */
    char OUTLINED_WHITE_STAR = '\u269D';
    /** ⚞ of type OTHER_SYMBOL */
    char THREE_LINES_CONVERGING_RIGHT = '\u269E';
    /** ⚟ of type OTHER_SYMBOL */
    char THREE_LINES_CONVERGING_LEFT = '\u269F';
    /** ⚠ of type OTHER_SYMBOL */
    char WARNING_SIGN = '\u26A0';
    /** ⚢ of type OTHER_SYMBOL */
    char DOUBLED_FEMALE_SIGN = '\u26A2';
    /** ⚣ of type OTHER_SYMBOL */
    char DOUBLED_MALE_SIGN = '\u26A3';
    /** ⚤ of type OTHER_SYMBOL */
    char INTERLOCKED_FEMALE_AND_MALE_SIGN = '\u26A4';
    /** ⚥ of type OTHER_SYMBOL */
    char MALE_AND_FEMALE_SIGN = '\u26A5';
    /** ⚦ of type OTHER_SYMBOL */
    char MALE_WITH_STROKE_SIGN = '\u26A6';
    /** ⚧ of type OTHER_SYMBOL */
    char MALE_WITH_STROKE_AND_MALE_AND_FEMALE_SIGN = '\u26A7';
    /** ⚨ of type OTHER_SYMBOL */
    char VERTICAL_MALE_WITH_STROKE_SIGN = '\u26A8';
    /** ⚩ of type OTHER_SYMBOL */
    char HORIZONTAL_MALE_WITH_STROKE_SIGN = '\u26A9';
    /** ⚪ of type OTHER_SYMBOL */
    char MEDIUM_WHITE_CIRCLE = '\u26AA';
    /** ⚫ of type OTHER_SYMBOL */
    char MEDIUM_BLACK_CIRCLE = '\u26AB';
    /** ⚬ of type OTHER_SYMBOL */
    char MEDIUM_SMALL_WHITE_CIRCLE = '\u26AC';
    /** ⚭ of type OTHER_SYMBOL */
    char MARRIAGE_SYMBOL = '\u26AD';
    /** ⚮ of type OTHER_SYMBOL */
    char DIVORCE_SYMBOL = '\u26AE';
    /** ⚯ of type OTHER_SYMBOL */
    char UNMARRIED_PARTNERSHIP_SYMBOL = '\u26AF';
    /** ⚰ of type OTHER_SYMBOL */
    char COFFIN = '\u26B0';
    /** ⚱ of type OTHER_SYMBOL */
    char FUNERAL_URN = '\u26B1';
    /** ⚲ of type OTHER_SYMBOL */
    char NEUTER = '\u26B2';
    /** ⚳ of type OTHER_SYMBOL */
    char CERES = '\u26B3';
    /** ⚴ of type OTHER_SYMBOL */
    char PALLAS = '\u26B4';
    /** ⚵ of type OTHER_SYMBOL */
    char JUNO = '\u26B5';
    /** ⚶ of type OTHER_SYMBOL */
    char VESTA = '\u26B6';
    /** ⚷ of type OTHER_SYMBOL */
    char CHIRON = '\u26B7';
    /** ⚸ of type OTHER_SYMBOL */
    char BLACK_MOON_LILITH = '\u26B8';
    /** ⚹ of type OTHER_SYMBOL */
    char SEXTILE = '\u26B9';
    /** ⚺ of type OTHER_SYMBOL */
    char SEMISEXTILE = '\u26BA';
    /** ⚻ of type OTHER_SYMBOL */
    char QUINCUNX = '\u26BB';
    /** ⚼ of type OTHER_SYMBOL */
    char SESQUIQUADRATE = '\u26BC';
    /** ⚽ of type OTHER_SYMBOL */
    char SOCCER_BALL = '\u26BD';
    /** ⚾ of type OTHER_SYMBOL */
    char BASEBALL = '\u26BE';
    /** ⚿ of type OTHER_SYMBOL */
    char SQUARED_KEY = '\u26BF';
    /** ⛀ of type OTHER_SYMBOL */
    char WHITE_DRAUGHTS_MAN = '\u26C0';
    /** ⛁ of type OTHER_SYMBOL */
    char WHITE_DRAUGHTS_KING = '\u26C1';
    /** ⛂ of type OTHER_SYMBOL */
    char BLACK_DRAUGHTS_MAN = '\u26C2';
    /** ⛃ of type OTHER_SYMBOL */
    char BLACK_DRAUGHTS_KING = '\u26C3';
    /** ⛄ of type OTHER_SYMBOL */
    char SNOWMAN_WITHOUT_SNOW = '\u26C4';
    /** ⛅ of type OTHER_SYMBOL */
    char SUN_BEHIND_CLOUD = '\u26C5';
    /** ⛆ of type OTHER_SYMBOL */
    char RAIN = '\u26C6';
    /** ⛇ of type OTHER_SYMBOL */
    char BLACK_SNOWMAN = '\u26C7';
    /** ⛈ of type OTHER_SYMBOL */
    char THUNDER_CLOUD_AND_RAIN = '\u26C8';
    /** ⛉ of type OTHER_SYMBOL */
    char TURNED_WHITE_SHOGI_PIECE = '\u26C9';
    /** ⛊ of type OTHER_SYMBOL */
    char TURNED_BLACK_SHOGI_PIECE = '\u26CA';
    /** ⛋ of type OTHER_SYMBOL */
    char WHITE_DIAMOND_IN_SQUARE = '\u26CB';
    /** ⛌ of type OTHER_SYMBOL */
    char CROSSING_LANES = '\u26CC';
    /** ⛍ of type OTHER_SYMBOL */
    char DISABLED_CAR = '\u26CD';
    /** ⛎ of type OTHER_SYMBOL */
    char OPHIUCHUS = '\u26CE';
    /** ⛏ of type OTHER_SYMBOL */
    char PICK = '\u26CF';
    /** ⛐ of type OTHER_SYMBOL */
    char CAR_SLIDING = '\u26D0';
    /** ⛑ of type OTHER_SYMBOL */
    char HELMET_WITH_WHITE_CROSS = '\u26D1';
    /** ⛒ of type OTHER_SYMBOL */
    char CIRCLED_CROSSING_LANES = '\u26D2';
    /** ⛓ of type OTHER_SYMBOL */
    char CHAINS = '\u26D3';
    /** ⛔ of type OTHER_SYMBOL */
    char NO_ENTRY = '\u26D4';
    /** ⛕ of type OTHER_SYMBOL */
    char ALTERNATE_ONE_WAY_LEFT_WAY_TRAFFIC = '\u26D5';
    /** ⛖ of type OTHER_SYMBOL */
    char BLACK_TWO_WAY_LEFT_WAY_TRAFFIC = '\u26D6';
    /** ⛗ of type OTHER_SYMBOL */
    char WHITE_TWO_WAY_LEFT_WAY_TRAFFIC = '\u26D7';
    /** ⛘ of type OTHER_SYMBOL */
    char BLACK_LEFT_LANE_MERGE = '\u26D8';
    /** ⛙ of type OTHER_SYMBOL */
    char WHITE_LEFT_LANE_MERGE = '\u26D9';
    /** ⛚ of type OTHER_SYMBOL */
    char DRIVE_SLOW_SIGN = '\u26DA';
    /** ⛛ of type OTHER_SYMBOL */
    char HEAVY_WHITE_DOWN_POINTING_TRIANGLE = '\u26DB';
    /** ⛜ of type OTHER_SYMBOL */
    char LEFT_CLOSED_ENTRY = '\u26DC';
    /** ⛝ of type OTHER_SYMBOL */
    char SQUARED_SALTIRE = '\u26DD';
    /** ⛞ of type OTHER_SYMBOL */
    char FALLING_DIAGONAL_IN_WHITE_CIRCLE_IN_BLACK_SQUARE = '\u26DE';
    /** ⛟ of type OTHER_SYMBOL */
    char BLACK_TRUCK = '\u26DF';
    /** ⛠ of type OTHER_SYMBOL */
    char RESTRICTED_LEFT_ENTRY_1 = '\u26E0';
    /** ⛡ of type OTHER_SYMBOL */
    char RESTRICTED_LEFT_ENTRY_2 = '\u26E1';
    /** ⛢ of type OTHER_SYMBOL */
    char ASTRONOMICAL_SYMBOL_FOR_URANUS = '\u26E2';
    /** ⛣ of type OTHER_SYMBOL */
    char HEAVY_CIRCLE_WITH_STROKE_AND_TWO_DOTS_ABOVE = '\u26E3';
    /** ⛤ of type OTHER_SYMBOL */
    char PENTAGRAM = '\u26E4';
    /** ⛥ of type OTHER_SYMBOL */
    char RIGHT_HANDED_INTERLACED_PENTAGRAM = '\u26E5';
    /** ⛦ of type OTHER_SYMBOL */
    char LEFT_HANDED_INTERLACED_PENTAGRAM = '\u26E6';
    /** ⛧ of type OTHER_SYMBOL */
    char INVERTED_PENTAGRAM = '\u26E7';
    /** ⛨ of type OTHER_SYMBOL */
    char BLACK_CROSS_ON_SHIELD = '\u26E8';
    /** ⛩ of type OTHER_SYMBOL */
    char SHINTO_SHRINE = '\u26E9';
    /** ⛪ of type OTHER_SYMBOL */
    char CHURCH = '\u26EA';
    /** ⛫ of type OTHER_SYMBOL */
    char CASTLE = '\u26EB';
    /** ⛬ of type OTHER_SYMBOL */
    char HISTORIC_SITE = '\u26EC';
    /** ⛭ of type OTHER_SYMBOL */
    char GEAR_WITHOUT_HUB = '\u26ED';
    /** ⛮ of type OTHER_SYMBOL */
    char GEAR_WITH_HANDLES = '\u26EE';
    /** ⛯ of type OTHER_SYMBOL */
    char MAP_SYMBOL_FOR_LIGHTHOUSE = '\u26EF';
    /** ⛰ of type OTHER_SYMBOL */
    char MOUNTAIN = '\u26F0';
    /** ⛱ of type OTHER_SYMBOL */
    char UMBRELLA_ON_GROUND = '\u26F1';
    /** ⛲ of type OTHER_SYMBOL */
    char FOUNTAIN = '\u26F2';
    /** ⛳ of type OTHER_SYMBOL */
    char FLAG_IN_HOLE = '\u26F3';
    /** ⛴ of type OTHER_SYMBOL */
    char FERRY = '\u26F4';
    /** ⛵ of type OTHER_SYMBOL */
    char SAILBOAT = '\u26F5';
    /** ⛶ of type OTHER_SYMBOL */
    char SQUARE_FOUR_CORNERS = '\u26F6';
    /** ⛷ of type OTHER_SYMBOL */
    char SKIER = '\u26F7';
    /** ⛸ of type OTHER_SYMBOL */
    char ICE_SKATE = '\u26F8';
    /** ⛹ of type OTHER_SYMBOL */
    char PERSON_WITH_BALL = '\u26F9';
    /** ⛺ of type OTHER_SYMBOL */
    char TENT = '\u26FA';
    /** ⛻ of type OTHER_SYMBOL */
    char JAPANESE_BANK_SYMBOL = '\u26FB';
    /** ⛼ of type OTHER_SYMBOL */
    char HEADSTONE_GRAVEYARD_SYMBOL = '\u26FC';
    /** ⛽ of type OTHER_SYMBOL */
    char FUEL_PUMP = '\u26FD';
    /** ⛾ of type OTHER_SYMBOL */
    char CUP_ON_BLACK_SQUARE = '\u26FE';
    /** ⛿ of type OTHER_SYMBOL */
    char WHITE_FLAG_WITH_HORIZONTAL_MIDDLE_BLACK_STRIPE = '\u26FF';
    /** ✁ of type OTHER_SYMBOL */
    char UPPER_BLADE_SCISSORS = '\u2701';
    /** ✂ of type OTHER_SYMBOL */
    char BLACK_SCISSORS = '\u2702';
    /** ✃ of type OTHER_SYMBOL */
    char LOWER_BLADE_SCISSORS = '\u2703';
    /** ✄ of type OTHER_SYMBOL */
    char WHITE_SCISSORS = '\u2704';
    /** ✅ of type OTHER_SYMBOL */
    char WHITE_HEAVY_CHECK_MARK = '\u2705';
    /** ✆ of type OTHER_SYMBOL */
    char TELEPHONE_LOCATION_SIGN = '\u2706';
    /** ✇ of type OTHER_SYMBOL */
    char TAPE_DRIVE = '\u2707';
    /** ✈ of type OTHER_SYMBOL */
    char AIRPLANE = '\u2708';
    /** ✉ of type OTHER_SYMBOL */
    char ENVELOPE = '\u2709';
    /** ✊ of type OTHER_SYMBOL */
    char RAISED_FIST = '\u270A';
    /** ✋ of type OTHER_SYMBOL */
    char RAISED_HAND = '\u270B';
    /** ✌ of type OTHER_SYMBOL */
    char VICTORY_HAND = '\u270C';
    /** ✍ of type OTHER_SYMBOL */
    char WRITING_HAND = '\u270D';
    /** ✎ of type OTHER_SYMBOL */
    char LOWER_RIGHT_PENCIL = '\u270E';
    /** ✏ of type OTHER_SYMBOL */
    char PENCIL = '\u270F';
    /** ✐ of type OTHER_SYMBOL */
    char UPPER_RIGHT_PENCIL = '\u2710';
    /** ✑ of type OTHER_SYMBOL */
    char WHITE_NIB = '\u2711';
    /** ✒ of type OTHER_SYMBOL */
    char BLACK_NIB = '\u2712';
    /** ✓ of type OTHER_SYMBOL */
    char CHECK_MARK = '\u2713';
    /** ✔ of type OTHER_SYMBOL */
    char HEAVY_CHECK_MARK = '\u2714';
    /** ✕ of type OTHER_SYMBOL */
    char MULTIPLICATION_X = '\u2715';
    /** ✖ of type OTHER_SYMBOL */
    char HEAVY_MULTIPLICATION_X = '\u2716';
    /** ✗ of type OTHER_SYMBOL */
    char BALLOT_X = '\u2717';
    /** ✘ of type OTHER_SYMBOL */
    char HEAVY_BALLOT_X = '\u2718';
    /** ✙ of type OTHER_SYMBOL */
    char OUTLINED_GREEK_CROSS = '\u2719';
    /** ✚ of type OTHER_SYMBOL */
    char HEAVY_GREEK_CROSS = '\u271A';
    /** ✛ of type OTHER_SYMBOL */
    char OPEN_CENTRE_CROSS = '\u271B';
    /** ✜ of type OTHER_SYMBOL */
    char HEAVY_OPEN_CENTRE_CROSS = '\u271C';
    /** ✞ of type OTHER_SYMBOL */
    char SHADOWED_WHITE_LATIN_CROSS = '\u271E';
    /** ✟ of type OTHER_SYMBOL */
    char OUTLINED_LATIN_CROSS = '\u271F';
    /** ✠ of type OTHER_SYMBOL */
    char MALTESE_CROSS = '\u2720';
    /** ✡ of type OTHER_SYMBOL */
    char STAR_OF_DAVID = '\u2721';
    /** ✢ of type OTHER_SYMBOL */
    char FOUR_TEARDROP_SPOKED_ASTERISK = '\u2722';
    /** ✣ of type OTHER_SYMBOL */
    char FOUR_BALLOON_SPOKED_ASTERISK = '\u2723';
    /** ✤ of type OTHER_SYMBOL */
    char HEAVY_FOUR_BALLOON_SPOKED_ASTERISK = '\u2724';
    /** ✥ of type OTHER_SYMBOL */
    char FOUR_CLUB_SPOKED_ASTERISK = '\u2725';
    /** ✦ of type OTHER_SYMBOL */
    char BLACK_FOUR_POINTED_STAR = '\u2726';
    /** ✧ of type OTHER_SYMBOL */
    char WHITE_FOUR_POINTED_STAR = '\u2727';
    /** ✨ of type OTHER_SYMBOL */
    char SPARKLES = '\u2728';
    /** ✩ of type OTHER_SYMBOL */
    char STRESS_OUTLINED_WHITE_STAR = '\u2729';
    /** ✪ of type OTHER_SYMBOL */
    char CIRCLED_WHITE_STAR = '\u272A';
    /** ✫ of type OTHER_SYMBOL */
    char OPEN_CENTRE_BLACK_STAR = '\u272B';
    /** ✬ of type OTHER_SYMBOL */
    char BLACK_CENTRE_WHITE_STAR = '\u272C';
    /** ✭ of type OTHER_SYMBOL */
    char OUTLINED_BLACK_STAR = '\u272D';
    /** ✮ of type OTHER_SYMBOL */
    char HEAVY_OUTLINED_BLACK_STAR = '\u272E';
    /** ✯ of type OTHER_SYMBOL */
    char PINWHEEL_STAR = '\u272F';
    /** ✰ of type OTHER_SYMBOL */
    char SHADOWED_WHITE_STAR = '\u2730';
    /** ✱ of type OTHER_SYMBOL */
    char HEAVY_ASTERISK = '\u2731';
    /** ✲ of type OTHER_SYMBOL */
    char OPEN_CENTRE_ASTERISK = '\u2732';
    /** ✳ of type OTHER_SYMBOL */
    char EIGHT_SPOKED_ASTERISK = '\u2733';
    /** ✴ of type OTHER_SYMBOL */
    char EIGHT_POINTED_BLACK_STAR = '\u2734';
    /** ✵ of type OTHER_SYMBOL */
    char EIGHT_POINTED_PINWHEEL_STAR = '\u2735';
    /** ✶ of type OTHER_SYMBOL */
    char SIX_POINTED_BLACK_STAR = '\u2736';
    /** ✷ of type OTHER_SYMBOL */
    char EIGHT_POINTED_RECTILINEAR_BLACK_STAR = '\u2737';
    /** ✸ of type OTHER_SYMBOL */
    char HEAVY_EIGHT_POINTED_RECTILINEAR_BLACK_STAR = '\u2738';
    /** ✹ of type OTHER_SYMBOL */
    char TWELVE_POINTED_BLACK_STAR = '\u2739';
    /** ✺ of type OTHER_SYMBOL */
    char SIXTEEN_POINTED_ASTERISK = '\u273A';
    /** ✻ of type OTHER_SYMBOL */
    char TEARDROP_SPOKED_ASTERISK = '\u273B';
    /** ✼ of type OTHER_SYMBOL */
    char OPEN_CENTRE_TEARDROP_SPOKED_ASTERISK = '\u273C';
    /** ✽ of type OTHER_SYMBOL */
    char HEAVY_TEARDROP_SPOKED_ASTERISK = '\u273D';
    /** ✾ of type OTHER_SYMBOL */
    char SIX_PETALLED_BLACK_AND_WHITE_FLORETTE = '\u273E';
    /** ✿ of type OTHER_SYMBOL */
    char BLACK_FLORETTE = '\u273F';
    /** ❀ of type OTHER_SYMBOL */
    char WHITE_FLORETTE = '\u2740';
    /** ❁ of type OTHER_SYMBOL */
    char EIGHT_PETALLED_OUTLINED_BLACK_FLORETTE = '\u2741';
    /** ❂ of type OTHER_SYMBOL */
    char CIRCLED_OPEN_CENTRE_EIGHT_POINTED_STAR = '\u2742';
    /** ❃ of type OTHER_SYMBOL */
    char HEAVY_TEARDROP_SPOKED_PINWHEEL_ASTERISK = '\u2743';
    /** ❄ of type OTHER_SYMBOL */
    char SNOWFLAKE = '\u2744';
    /** ❅ of type OTHER_SYMBOL */
    char TIGHT_TRIFOLIATE_SNOWFLAKE = '\u2745';
    /** ❆ of type OTHER_SYMBOL */
    char HEAVY_CHEVRON_SNOWFLAKE = '\u2746';
    /** ❇ of type OTHER_SYMBOL */
    char SPARKLE = '\u2747';
    /** ❈ of type OTHER_SYMBOL */
    char HEAVY_SPARKLE = '\u2748';
    /** ❉ of type OTHER_SYMBOL */
    char BALLOON_SPOKED_ASTERISK = '\u2749';
    /** ❊ of type OTHER_SYMBOL */
    char EIGHT_TEARDROP_SPOKED_PROPELLER_ASTERISK = '\u274A';
    /** ❋ of type OTHER_SYMBOL */
    char HEAVY_EIGHT_TEARDROP_SPOKED_PROPELLER_ASTERISK = '\u274B';
    /** ❌ of type OTHER_SYMBOL */
    char CROSS_MARK = '\u274C';
    /** ❍ of type OTHER_SYMBOL */
    char SHADOWED_WHITE_CIRCLE = '\u274D';
    /** ❎ of type OTHER_SYMBOL */
    char NEGATIVE_SQUARED_CROSS_MARK = '\u274E';
    /** ❏ of type OTHER_SYMBOL */
    char LOWER_RIGHT_DROP_SHADOWED_WHITE_SQUARE = '\u274F';
    /** ❐ of type OTHER_SYMBOL */
    char UPPER_RIGHT_DROP_SHADOWED_WHITE_SQUARE = '\u2750';
    /** ❑ of type OTHER_SYMBOL */
    char LOWER_RIGHT_SHADOWED_WHITE_SQUARE = '\u2751';
    /** ❒ of type OTHER_SYMBOL */
    char UPPER_RIGHT_SHADOWED_WHITE_SQUARE = '\u2752';
    /** ❓ of type OTHER_SYMBOL */
    char BLACK_QUESTION_MARK_ORNAMENT = '\u2753';
    /** ❔ of type OTHER_SYMBOL */
    char WHITE_QUESTION_MARK_ORNAMENT = '\u2754';
    /** ❕ of type OTHER_SYMBOL */
    char WHITE_EXCLAMATION_MARK_ORNAMENT = '\u2755';
    /** ❖ of type OTHER_SYMBOL */
    char BLACK_DIAMOND_MINUS_WHITE_X = '\u2756';
    /** ❗ of type OTHER_SYMBOL */
    char HEAVY_EXCLAMATION_MARK_SYMBOL = '\u2757';
    /** ❘ of type OTHER_SYMBOL */
    char LIGHT_VERTICAL_BAR = '\u2758';
    /** ❙ of type OTHER_SYMBOL */
    char MEDIUM_VERTICAL_BAR = '\u2759';
    /** ❚ of type OTHER_SYMBOL */
    char HEAVY_VERTICAL_BAR = '\u275A';
    /** ❛ of type OTHER_SYMBOL */
    char HEAVY_SINGLE_TURNED_COMMA_QUOTATION_MARK_ORNAMENT = '\u275B';
    /** ❜ of type OTHER_SYMBOL */
    char HEAVY_SINGLE_COMMA_QUOTATION_MARK_ORNAMENT = '\u275C';
    /** ❝ of type OTHER_SYMBOL */
    char HEAVY_DOUBLE_TURNED_COMMA_QUOTATION_MARK_ORNAMENT = '\u275D';
    /** ❞ of type OTHER_SYMBOL */
    char HEAVY_DOUBLE_COMMA_QUOTATION_MARK_ORNAMENT = '\u275E';
    /** ❟ of type OTHER_SYMBOL */
    char HEAVY_LOW_SINGLE_COMMA_QUOTATION_MARK_ORNAMENT = '\u275F';
    /** ❠ of type OTHER_SYMBOL */
    char HEAVY_LOW_DOUBLE_COMMA_QUOTATION_MARK_ORNAMENT = '\u2760';
    /** ❡ of type OTHER_SYMBOL */
    char CURVED_STEM_PARAGRAPH_SIGN_ORNAMENT = '\u2761';
    /** ❢ of type OTHER_SYMBOL */
    char HEAVY_EXCLAMATION_MARK_ORNAMENT = '\u2762';
    /** ❣ of type OTHER_SYMBOL */
    char HEAVY_HEART_EXCLAMATION_MARK_ORNAMENT = '\u2763';
    /** ❤ of type OTHER_SYMBOL */
    char HEAVY_BLACK_HEART = '\u2764';
    /** ❥ of type OTHER_SYMBOL */
    char ROTATED_HEAVY_BLACK_HEART_BULLET = '\u2765';
    /** ❦ of type OTHER_SYMBOL */
    char FLORAL_HEART = '\u2766';
    /** ❧ of type OTHER_SYMBOL */
    char ROTATED_FLORAL_HEART_BULLET = '\u2767';
    /** ❨ of type START_PUNCTUATION */
    char MEDIUM_LEFT_PARENTHESIS_ORNAMENT = '\u2768';
    /** ❩ of type END_PUNCTUATION */
    char MEDIUM_RIGHT_PARENTHESIS_ORNAMENT = '\u2769';
    /** ❪ of type START_PUNCTUATION */
    char MEDIUM_FLATTENED_LEFT_PARENTHESIS_ORNAMENT = '\u276A';
    /** ❫ of type END_PUNCTUATION */
    char MEDIUM_FLATTENED_RIGHT_PARENTHESIS_ORNAMENT = '\u276B';
    /** ❬ of type START_PUNCTUATION */
    char MEDIUM_LEFT_POINTING_ANGLE_BRACKET_ORNAMENT = '\u276C';
    /** ❭ of type END_PUNCTUATION */
    char MEDIUM_RIGHT_POINTING_ANGLE_BRACKET_ORNAMENT = '\u276D';
    /** ❮ of type START_PUNCTUATION */
    char HEAVY_LEFT_POINTING_ANGLE_QUOTATION_MARK_ORNAMENT = '\u276E';
    /** ❯ of type END_PUNCTUATION */
    char HEAVY_RIGHT_POINTING_ANGLE_QUOTATION_MARK_ORNAMENT = '\u276F';
    /** ❰ of type START_PUNCTUATION */
    char HEAVY_LEFT_POINTING_ANGLE_BRACKET_ORNAMENT = '\u2770';
    /** ❱ of type END_PUNCTUATION */
    char HEAVY_RIGHT_POINTING_ANGLE_BRACKET_ORNAMENT = '\u2771';
    /** ❲ of type START_PUNCTUATION */
    char LIGHT_LEFT_TORTOISE_SHELL_BRACKET_ORNAMENT = '\u2772';
    /** ❳ of type END_PUNCTUATION */
    char LIGHT_RIGHT_TORTOISE_SHELL_BRACKET_ORNAMENT = '\u2773';
    /** ❴ of type START_PUNCTUATION */
    char MEDIUM_LEFT_CURLY_BRACKET_ORNAMENT = '\u2774';
    /** ❵ of type END_PUNCTUATION */
    char MEDIUM_RIGHT_CURLY_BRACKET_ORNAMENT = '\u2775';
    /** ❶ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_ONE = '\u2776';
    /** ❷ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_TWO = '\u2777';
    /** ❸ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_THREE = '\u2778';
    /** ❹ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_FOUR = '\u2779';
    /** ❺ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_FIVE = '\u277A';
    /** ❻ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_SIX = '\u277B';
    /** ❼ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_SEVEN = '\u277C';
    /** ❽ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_EIGHT = '\u277D';
    /** ❾ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_DIGIT_NINE = '\u277E';
    /** ❿ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_NUMBER_TEN = '\u277F';
    /** ➀ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_ONE = '\u2780';
    /** ➁ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_TWO = '\u2781';
    /** ➂ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_THREE = '\u2782';
    /** ➃ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_FOUR = '\u2783';
    /** ➄ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_FIVE = '\u2784';
    /** ➅ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_SIX = '\u2785';
    /** ➆ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_SEVEN = '\u2786';
    /** ➇ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_EIGHT = '\u2787';
    /** ➈ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_DIGIT_NINE = '\u2788';
    /** ➉ of type OTHER_NUMBER */
    char DINGBAT_CIRCLED_SANS_SERIF_NUMBER_TEN = '\u2789';
    /** ➊ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_ONE = '\u278A';
    /** ➋ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_TWO = '\u278B';
    /** ➌ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_THREE = '\u278C';
    /** ➍ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_FOUR = '\u278D';
    /** ➎ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_FIVE = '\u278E';
    /** ➏ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_SIX = '\u278F';
    /** ➐ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_SEVEN = '\u2790';
    /** ➑ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_EIGHT = '\u2791';
    /** ➒ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_DIGIT_NINE = '\u2792';
    /** ➓ of type OTHER_NUMBER */
    char DINGBAT_NEGATIVE_CIRCLED_SANS_SERIF_NUMBER_TEN = '\u2793';
    /** ➔ of type OTHER_SYMBOL */
    char HEAVY_WIDE_HEADED_RIGHTWARDS_ARROW = '\u2794';
    /** ➕ of type OTHER_SYMBOL */
    char HEAVY_PLUS_SIGN = '\u2795';
    /** ➖ of type OTHER_SYMBOL */
    char HEAVY_MINUS_SIGN = '\u2796';
    /** ➗ of type OTHER_SYMBOL */
    char HEAVY_DIVISION_SIGN = '\u2797';
    /** ➘ of type OTHER_SYMBOL */
    char HEAVY_SOUTH_EAST_ARROW = '\u2798';
    /** ➙ of type OTHER_SYMBOL */
    char HEAVY_RIGHTWARDS_ARROW = '\u2799';
    /** ➚ of type OTHER_SYMBOL */
    char HEAVY_NORTH_EAST_ARROW = '\u279A';
    /** ➛ of type OTHER_SYMBOL */
    char DRAFTING_POINT_RIGHTWARDS_ARROW = '\u279B';
    /** ➜ of type OTHER_SYMBOL */
    char HEAVY_ROUND_TIPPED_RIGHTWARDS_ARROW = '\u279C';
    /** ➝ of type OTHER_SYMBOL */
    char TRIANGLE_HEADED_RIGHTWARDS_ARROW = '\u279D';
    /** ➞ of type OTHER_SYMBOL */
    char HEAVY_TRIANGLE_HEADED_RIGHTWARDS_ARROW = '\u279E';
    /** ➟ of type OTHER_SYMBOL */
    char DASHED_TRIANGLE_HEADED_RIGHTWARDS_ARROW = '\u279F';
    /** ➠ of type OTHER_SYMBOL */
    char HEAVY_DASHED_TRIANGLE_HEADED_RIGHTWARDS_ARROW = '\u27A0';
    /** ➡ of type OTHER_SYMBOL */
    char BLACK_RIGHTWARDS_ARROW = '\u27A1';
    /** ➢ of type OTHER_SYMBOL */
    char THREE_D_TOP_LIGHTED_RIGHTWARDS_ARROWHEAD = '\u27A2';
    /** ➣ of type OTHER_SYMBOL */
    char THREE_D_BOTTOM_LIGHTED_RIGHTWARDS_ARROWHEAD = '\u27A3';
    /** ➤ of type OTHER_SYMBOL */
    char BLACK_RIGHTWARDS_ARROWHEAD = '\u27A4';
    /** ➥ of type OTHER_SYMBOL */
    char HEAVY_BLACK_CURVED_DOWNWARDS_AND_RIGHTWARDS_ARROW = '\u27A5';
    /** ➦ of type OTHER_SYMBOL */
    char HEAVY_BLACK_CURVED_UPWARDS_AND_RIGHTWARDS_ARROW = '\u27A6';
    /** ➧ of type OTHER_SYMBOL */
    char SQUAT_BLACK_RIGHTWARDS_ARROW = '\u27A7';
    /** ➨ of type OTHER_SYMBOL */
    char HEAVY_CONCAVE_POINTED_BLACK_RIGHTWARDS_ARROW = '\u27A8';
    /** ➩ of type OTHER_SYMBOL */
    char RIGHT_SHADED_WHITE_RIGHTWARDS_ARROW = '\u27A9';
    /** ➪ of type OTHER_SYMBOL */
    char LEFT_SHADED_WHITE_RIGHTWARDS_ARROW = '\u27AA';
    /** ➫ of type OTHER_SYMBOL */
    char BACK_TILTED_SHADOWED_WHITE_RIGHTWARDS_ARROW = '\u27AB';
    /** ➬ of type OTHER_SYMBOL */
    char FRONT_TILTED_SHADOWED_WHITE_RIGHTWARDS_ARROW = '\u27AC';
    /** ➭ of type OTHER_SYMBOL */
    char HEAVY_LOWER_RIGHT_SHADOWED_WHITE_RIGHTWARDS_ARROW = '\u27AD';
    /** ➮ of type OTHER_SYMBOL */
    char HEAVY_UPPER_RIGHT_SHADOWED_WHITE_RIGHTWARDS_ARROW = '\u27AE';
    /** ➯ of type OTHER_SYMBOL */
    char NOTCHED_LOWER_RIGHT_SHADOWED_WHITE_RIGHTWARDS_ARROW = '\u27AF';
    /** ➰ of type OTHER_SYMBOL */
    char CURLY_LOOP = '\u27B0';
    /** ➱ of type OTHER_SYMBOL */
    char NOTCHED_UPPER_RIGHT_SHADOWED_WHITE_RIGHTWARDS_ARROW = '\u27B1';
    /** ➲ of type OTHER_SYMBOL */
    char CIRCLED_HEAVY_WHITE_RIGHTWARDS_ARROW = '\u27B2';
    /** ➳ of type OTHER_SYMBOL */
    char WHITE_FEATHERED_RIGHTWARDS_ARROW = '\u27B3';
    /** ➴ of type OTHER_SYMBOL */
    char BLACK_FEATHERED_SOUTH_EAST_ARROW = '\u27B4';
    /** ➵ of type OTHER_SYMBOL */
    char BLACK_FEATHERED_RIGHTWARDS_ARROW = '\u27B5';
    /** ➶ of type OTHER_SYMBOL */
    char BLACK_FEATHERED_NORTH_EAST_ARROW = '\u27B6';
    /** ➷ of type OTHER_SYMBOL */
    char HEAVY_BLACK_FEATHERED_SOUTH_EAST_ARROW = '\u27B7';
    /** ➸ of type OTHER_SYMBOL */
    char HEAVY_BLACK_FEATHERED_RIGHTWARDS_ARROW = '\u27B8';
    /** ➹ of type OTHER_SYMBOL */
    char HEAVY_BLACK_FEATHERED_NORTH_EAST_ARROW = '\u27B9';
    /** ➺ of type OTHER_SYMBOL */
    char TEARDROP_BARBED_RIGHTWARDS_ARROW = '\u27BA';
    /** ➻ of type OTHER_SYMBOL */
    char HEAVY_TEARDROP_SHANKED_RIGHTWARDS_ARROW = '\u27BB';
    /** ➼ of type OTHER_SYMBOL */
    char WEDGE_TAILED_RIGHTWARDS_ARROW = '\u27BC';
    /** ➽ of type OTHER_SYMBOL */
    char HEAVY_WEDGE_TAILED_RIGHTWARDS_ARROW = '\u27BD';
    /** ➾ of type OTHER_SYMBOL */
    char OPEN_OUTLINED_RIGHTWARDS_ARROW = '\u27BE';
    /** ➿ of type OTHER_SYMBOL */
    char DOUBLE_CURLY_LOOP = '\u27BF';
    /** ⟀ of type MATH_SYMBOL */
    char THREE_DIMENSIONAL_ANGLE = '\u27C0';
    /** ⟁ of type MATH_SYMBOL */
    char WHITE_TRIANGLE_CONTAINING_SMALL_WHITE_TRIANGLE = '\u27C1';
    /** ⟂ of type MATH_SYMBOL */
    char PERPENDICULAR = '\u27C2';
    /** ⟃ of type MATH_SYMBOL */
    char OPEN_SUBSET = '\u27C3';
    /** ⟄ of type MATH_SYMBOL */
    char OPEN_SUPERSET = '\u27C4';
    /** ⟅ of type START_PUNCTUATION */
    char LEFT_S_SHAPED_BAG_DELIMITER = '\u27C5';
    /** ⟆ of type END_PUNCTUATION */
    char RIGHT_S_SHAPED_BAG_DELIMITER = '\u27C6';
    /** ⟇ of type MATH_SYMBOL */
    char OR_WITH_DOT_INSIDE = '\u27C7';
    /** ⟈ of type MATH_SYMBOL */
    char REVERSE_SOLIDUS_PRECEDING_SUBSET = '\u27C8';
    /** ⟉ of type MATH_SYMBOL */
    char SUPERSET_PRECEDING_SOLIDUS = '\u27C9';
    /** ⟊ of type MATH_SYMBOL */
    char VERTICAL_BAR_WITH_HORIZONTAL_STROKE = '\u27CA';
    /** ⟌ of type MATH_SYMBOL */
    char LONG_DIVISION = '\u27CC';
    /** ⟎ of type MATH_SYMBOL */
    char SQUARED_LOGICAL_AND = '\u27CE';
    /** ⟏ of type MATH_SYMBOL */
    char SQUARED_LOGICAL_OR = '\u27CF';
    /** ⟐ of type MATH_SYMBOL */
    char WHITE_DIAMOND_WITH_CENTRED_DOT = '\u27D0';
    /** ⟑ of type MATH_SYMBOL */
    char AND_WITH_DOT = '\u27D1';
    /** ⟒ of type MATH_SYMBOL */
    char ELEMENT_OF_OPENING_UPWARDS = '\u27D2';
    /** ⟓ of type MATH_SYMBOL */
    char LOWER_RIGHT_CORNER_WITH_DOT = '\u27D3';
    /** ⟔ of type MATH_SYMBOL */
    char UPPER_LEFT_CORNER_WITH_DOT = '\u27D4';
    /** ⟕ of type MATH_SYMBOL */
    char LEFT_OUTER_JOIN = '\u27D5';
    /** ⟖ of type MATH_SYMBOL */
    char RIGHT_OUTER_JOIN = '\u27D6';
    /** ⟗ of type MATH_SYMBOL */
    char FULL_OUTER_JOIN = '\u27D7';
    /** ⟘ of type MATH_SYMBOL */
    char LARGE_UP_TACK = '\u27D8';
    /** ⟙ of type MATH_SYMBOL */
    char LARGE_DOWN_TACK = '\u27D9';
    /** ⟚ of type MATH_SYMBOL */
    char LEFT_AND_RIGHT_DOUBLE_TURNSTILE = '\u27DA';
    /** ⟛ of type MATH_SYMBOL */
    char LEFT_AND_RIGHT_TACK = '\u27DB';
    /** ⟜ of type MATH_SYMBOL */
    char LEFT_MULTIMAP = '\u27DC';
    /** ⟝ of type MATH_SYMBOL */
    char LONG_RIGHT_TACK = '\u27DD';
    /** ⟞ of type MATH_SYMBOL */
    char LONG_LEFT_TACK = '\u27DE';
    /** ⟟ of type MATH_SYMBOL */
    char UP_TACK_WITH_CIRCLE_ABOVE = '\u27DF';
    /** ⟠ of type MATH_SYMBOL */
    char LOZENGE_DIVIDED_BY_HORIZONTAL_RULE = '\u27E0';
    /** ⟡ of type MATH_SYMBOL */
    char WHITE_CONCAVE_SIDED_DIAMOND = '\u27E1';
    /** ⟢ of type MATH_SYMBOL */
    char WHITE_CONCAVE_SIDED_DIAMOND_WITH_LEFTWARDS_TICK = '\u27E2';
    /** ⟣ of type MATH_SYMBOL */
    char WHITE_CONCAVE_SIDED_DIAMOND_WITH_RIGHTWARDS_TICK = '\u27E3';
    /** ⟤ of type MATH_SYMBOL */
    char WHITE_SQUARE_WITH_LEFTWARDS_TICK = '\u27E4';
    /** ⟥ of type MATH_SYMBOL */
    char WHITE_SQUARE_WITH_RIGHTWARDS_TICK = '\u27E5';
    /** ⟰ of type MATH_SYMBOL */
    char UPWARDS_QUADRUPLE_ARROW = '\u27F0';
    /** ⟱ of type MATH_SYMBOL */
    char DOWNWARDS_QUADRUPLE_ARROW = '\u27F1';
    /** ⟲ of type MATH_SYMBOL */
    char ANTICLOCKWISE_GAPPED_CIRCLE_ARROW = '\u27F2';
    /** ⟳ of type MATH_SYMBOL */
    char CLOCKWISE_GAPPED_CIRCLE_ARROW = '\u27F3';
    /** ⟴ of type MATH_SYMBOL */
    char RIGHT_ARROW_WITH_CIRCLED_PLUS = '\u27F4';
    /** ⟵ of type MATH_SYMBOL */
    char LONG_LEFTWARDS_ARROW = '\u27F5';
    /** ⟶ of type MATH_SYMBOL */
    char LONG_RIGHTWARDS_ARROW = '\u27F6';
    /** ⟷ of type MATH_SYMBOL */
    char LONG_LEFT_RIGHT_ARROW = '\u27F7';
    /** ⟸ of type MATH_SYMBOL */
    char LONG_LEFTWARDS_DOUBLE_ARROW = '\u27F8';
    /** ⟹ of type MATH_SYMBOL */
    char LONG_RIGHTWARDS_DOUBLE_ARROW = '\u27F9';
    /** ⟺ of type MATH_SYMBOL */
    char LONG_LEFT_RIGHT_DOUBLE_ARROW = '\u27FA';
    /** ⟻ of type MATH_SYMBOL */
    char LONG_LEFTWARDS_ARROW_FROM_BAR = '\u27FB';
    /** ⟼ of type MATH_SYMBOL */
    char LONG_RIGHTWARDS_ARROW_FROM_BAR = '\u27FC';
    /** ⟽ of type MATH_SYMBOL */
    char LONG_LEFTWARDS_DOUBLE_ARROW_FROM_BAR = '\u27FD';
    /** ⟾ of type MATH_SYMBOL */
    char LONG_RIGHTWARDS_DOUBLE_ARROW_FROM_BAR = '\u27FE';
    /** ⟿ of type MATH_SYMBOL */
    char LONG_RIGHTWARDS_SQUIGGLE_ARROW = '\u27FF';
    /** ⠀ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_BLANK = '\u2800';
    /** ⠁ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1 = '\u2801';
    /** ⠂ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2 = '\u2802';
    /** ⠃ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12 = '\u2803';
    /** ⠄ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3 = '\u2804';
    /** ⠅ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13 = '\u2805';
    /** ⠆ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23 = '\u2806';
    /** ⠇ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123 = '\u2807';
    /** ⠈ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_4 = '\u2808';
    /** ⠉ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_14 = '\u2809';
    /** ⠊ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_24 = '\u280A';
    /** ⠋ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_124 = '\u280B';
    /** ⠌ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_34 = '\u280C';
    /** ⠍ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_134 = '\u280D';
    /** ⠎ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_234 = '\u280E';
    /** ⠏ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1234 = '\u280F';
    /** ⠐ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_5 = '\u2810';
    /** ⠑ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_15 = '\u2811';
    /** ⠒ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_25 = '\u2812';
    /** ⠓ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_125 = '\u2813';
    /** ⠔ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_35 = '\u2814';
    /** ⠕ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_135 = '\u2815';
    /** ⠖ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_235 = '\u2816';
    /** ⠗ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1235 = '\u2817';
    /** ⠘ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_45 = '\u2818';
    /** ⠙ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_145 = '\u2819';
    /** ⠚ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_245 = '\u281A';
    /** ⠛ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1245 = '\u281B';
    /** ⠜ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_345 = '\u281C';
    /** ⠝ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1345 = '\u281D';
    /** ⠞ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2345 = '\u281E';
    /** ⠟ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12345 = '\u281F';
    /** ⠠ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_6 = '\u2820';
    /** ⠡ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_16 = '\u2821';
    /** ⠢ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_26 = '\u2822';
    /** ⠣ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_126 = '\u2823';
    /** ⠤ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_36 = '\u2824';
    /** ⠥ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_136 = '\u2825';
    /** ⠦ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_236 = '\u2826';
    /** ⠧ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1236 = '\u2827';
    /** ⠨ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_46 = '\u2828';
    /** ⠩ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_146 = '\u2829';
    /** ⠪ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_246 = '\u282A';
    /** ⠫ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1246 = '\u282B';
    /** ⠬ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_346 = '\u282C';
    /** ⠭ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1346 = '\u282D';
    /** ⠮ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2346 = '\u282E';
    /** ⠯ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12346 = '\u282F';
    /** ⠰ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_56 = '\u2830';
    /** ⠱ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_156 = '\u2831';
    /** ⠲ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_256 = '\u2832';
    /** ⠳ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1256 = '\u2833';
    /** ⠴ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_356 = '\u2834';
    /** ⠵ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1356 = '\u2835';
    /** ⠶ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2356 = '\u2836';
    /** ⠷ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12356 = '\u2837';
    /** ⠸ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_456 = '\u2838';
    /** ⠹ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1456 = '\u2839';
    /** ⠺ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2456 = '\u283A';
    /** ⠻ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12456 = '\u283B';
    /** ⠼ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3456 = '\u283C';
    /** ⠽ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13456 = '\u283D';
    /** ⠾ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23456 = '\u283E';
    /** ⠿ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123456 = '\u283F';
    /** ⡀ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_7 = '\u2840';
    /** ⡁ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_17 = '\u2841';
    /** ⡂ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_27 = '\u2842';
    /** ⡃ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_127 = '\u2843';
    /** ⡄ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_37 = '\u2844';
    /** ⡅ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_137 = '\u2845';
    /** ⡆ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_237 = '\u2846';
    /** ⡇ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1237 = '\u2847';
    /** ⡈ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_47 = '\u2848';
    /** ⡉ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_147 = '\u2849';
    /** ⡊ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_247 = '\u284A';
    /** ⡋ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1247 = '\u284B';
    /** ⡌ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_347 = '\u284C';
    /** ⡍ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1347 = '\u284D';
    /** ⡎ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2347 = '\u284E';
    /** ⡏ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12347 = '\u284F';
    /** ⡐ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_57 = '\u2850';
    /** ⡑ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_157 = '\u2851';
    /** ⡒ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_257 = '\u2852';
    /** ⡓ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1257 = '\u2853';
    /** ⡔ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_357 = '\u2854';
    /** ⡕ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1357 = '\u2855';
    /** ⡖ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2357 = '\u2856';
    /** ⡗ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12357 = '\u2857';
    /** ⡘ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_457 = '\u2858';
    /** ⡙ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1457 = '\u2859';
    /** ⡚ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2457 = '\u285A';
    /** ⡛ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12457 = '\u285B';
    /** ⡜ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3457 = '\u285C';
    /** ⡝ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13457 = '\u285D';
    /** ⡞ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23457 = '\u285E';
    /** ⡟ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123457 = '\u285F';
    /** ⡠ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_67 = '\u2860';
    /** ⡡ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_167 = '\u2861';
    /** ⡢ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_267 = '\u2862';
    /** ⡣ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1267 = '\u2863';
    /** ⡤ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_367 = '\u2864';
    /** ⡥ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1367 = '\u2865';
    /** ⡦ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2367 = '\u2866';
    /** ⡧ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12367 = '\u2867';
    /** ⡨ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_467 = '\u2868';
    /** ⡩ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1467 = '\u2869';
    /** ⡪ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2467 = '\u286A';
    /** ⡫ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12467 = '\u286B';
    /** ⡬ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3467 = '\u286C';
    /** ⡭ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13467 = '\u286D';
    /** ⡮ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23467 = '\u286E';
    /** ⡯ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123467 = '\u286F';
    /** ⡰ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_567 = '\u2870';
    /** ⡱ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1567 = '\u2871';
    /** ⡲ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2567 = '\u2872';
    /** ⡳ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12567 = '\u2873';
    /** ⡴ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3567 = '\u2874';
    /** ⡵ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13567 = '\u2875';
    /** ⡶ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23567 = '\u2876';
    /** ⡷ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123567 = '\u2877';
    /** ⡸ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_4567 = '\u2878';
    /** ⡹ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_14567 = '\u2879';
    /** ⡺ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_24567 = '\u287A';
    /** ⡻ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_124567 = '\u287B';
    /** ⡼ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_34567 = '\u287C';
    /** ⡽ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_134567 = '\u287D';
    /** ⡾ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_234567 = '\u287E';
    /** ⡿ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1234567 = '\u287F';
    /** ⢀ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_8 = '\u2880';
    /** ⢁ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_18 = '\u2881';
    /** ⢂ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_28 = '\u2882';
    /** ⢃ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_128 = '\u2883';
    /** ⢄ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_38 = '\u2884';
    /** ⢅ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_138 = '\u2885';
    /** ⢆ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_238 = '\u2886';
    /** ⢇ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1238 = '\u2887';
    /** ⢈ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_48 = '\u2888';
    /** ⢉ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_148 = '\u2889';
    /** ⢊ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_248 = '\u288A';
    /** ⢋ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1248 = '\u288B';
    /** ⢌ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_348 = '\u288C';
    /** ⢍ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1348 = '\u288D';
    /** ⢎ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2348 = '\u288E';
    /** ⢏ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12348 = '\u288F';
    /** ⢐ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_58 = '\u2890';
    /** ⢑ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_158 = '\u2891';
    /** ⢒ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_258 = '\u2892';
    /** ⢓ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1258 = '\u2893';
    /** ⢔ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_358 = '\u2894';
    /** ⢕ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1358 = '\u2895';
    /** ⢖ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2358 = '\u2896';
    /** ⢗ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12358 = '\u2897';
    /** ⢘ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_458 = '\u2898';
    /** ⢙ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1458 = '\u2899';
    /** ⢚ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2458 = '\u289A';
    /** ⢛ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12458 = '\u289B';
    /** ⢜ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3458 = '\u289C';
    /** ⢝ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13458 = '\u289D';
    /** ⢞ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23458 = '\u289E';
    /** ⢟ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123458 = '\u289F';
    /** ⢠ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_68 = '\u28A0';
    /** ⢡ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_168 = '\u28A1';
    /** ⢢ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_268 = '\u28A2';
    /** ⢣ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1268 = '\u28A3';
    /** ⢤ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_368 = '\u28A4';
    /** ⢥ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1368 = '\u28A5';
    /** ⢦ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2368 = '\u28A6';
    /** ⢧ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12368 = '\u28A7';
    /** ⢨ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_468 = '\u28A8';
    /** ⢩ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1468 = '\u28A9';
    /** ⢪ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2468 = '\u28AA';
    /** ⢫ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12468 = '\u28AB';
    /** ⢬ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3468 = '\u28AC';
    /** ⢭ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13468 = '\u28AD';
    /** ⢮ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23468 = '\u28AE';
    /** ⢯ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123468 = '\u28AF';
    /** ⢰ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_568 = '\u28B0';
    /** ⢱ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1568 = '\u28B1';
    /** ⢲ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2568 = '\u28B2';
    /** ⢳ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12568 = '\u28B3';
    /** ⢴ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3568 = '\u28B4';
    /** ⢵ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13568 = '\u28B5';
    /** ⢶ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23568 = '\u28B6';
    /** ⢷ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123568 = '\u28B7';
    /** ⢸ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_4568 = '\u28B8';
    /** ⢹ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_14568 = '\u28B9';
    /** ⢺ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_24568 = '\u28BA';
    /** ⢻ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_124568 = '\u28BB';
    /** ⢼ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_34568 = '\u28BC';
    /** ⢽ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_134568 = '\u28BD';
    /** ⢾ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_234568 = '\u28BE';
    /** ⢿ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1234568 = '\u28BF';
    /** ⣀ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_78 = '\u28C0';
    /** ⣁ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_178 = '\u28C1';
    /** ⣂ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_278 = '\u28C2';
    /** ⣃ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1278 = '\u28C3';
    /** ⣄ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_378 = '\u28C4';
    /** ⣅ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1378 = '\u28C5';
    /** ⣆ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2378 = '\u28C6';
    /** ⣇ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12378 = '\u28C7';
    /** ⣈ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_478 = '\u28C8';
    /** ⣉ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1478 = '\u28C9';
    /** ⣊ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2478 = '\u28CA';
    /** ⣋ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12478 = '\u28CB';
    /** ⣌ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3478 = '\u28CC';
    /** ⣍ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13478 = '\u28CD';
    /** ⣎ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23478 = '\u28CE';
    /** ⣏ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123478 = '\u28CF';
    /** ⣐ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_578 = '\u28D0';
    /** ⣑ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1578 = '\u28D1';
    /** ⣒ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2578 = '\u28D2';
    /** ⣓ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12578 = '\u28D3';
    /** ⣔ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3578 = '\u28D4';
    /** ⣕ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13578 = '\u28D5';
    /** ⣖ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23578 = '\u28D6';
    /** ⣗ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123578 = '\u28D7';
    /** ⣘ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_4578 = '\u28D8';
    /** ⣙ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_14578 = '\u28D9';
    /** ⣚ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_24578 = '\u28DA';
    /** ⣛ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_124578 = '\u28DB';
    /** ⣜ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_34578 = '\u28DC';
    /** ⣝ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_134578 = '\u28DD';
    /** ⣞ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_234578 = '\u28DE';
    /** ⣟ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1234578 = '\u28DF';
    /** ⣠ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_678 = '\u28E0';
    /** ⣡ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1678 = '\u28E1';
    /** ⣢ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2678 = '\u28E2';
    /** ⣣ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12678 = '\u28E3';
    /** ⣤ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_3678 = '\u28E4';
    /** ⣥ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_13678 = '\u28E5';
    /** ⣦ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_23678 = '\u28E6';
    /** ⣧ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_123678 = '\u28E7';
    /** ⣨ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_4678 = '\u28E8';
    /** ⣩ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_14678 = '\u28E9';
    /** ⣪ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_24678 = '\u28EA';
    /** ⣫ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_124678 = '\u28EB';
    /** ⣬ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_34678 = '\u28EC';
    /** ⣭ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_134678 = '\u28ED';
    /** ⣮ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_234678 = '\u28EE';
    /** ⣯ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1234678 = '\u28EF';
    /** ⣰ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_5678 = '\u28F0';
    /** ⣱ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_15678 = '\u28F1';
    /** ⣲ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_25678 = '\u28F2';
    /** ⣳ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_125678 = '\u28F3';
    /** ⣴ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_35678 = '\u28F4';
    /** ⣵ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_135678 = '\u28F5';
    /** ⣶ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_235678 = '\u28F6';
    /** ⣷ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1235678 = '\u28F7';
    /** ⣸ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_45678 = '\u28F8';
    /** ⣹ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_145678 = '\u28F9';
    /** ⣺ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_245678 = '\u28FA';
    /** ⣻ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1245678 = '\u28FB';
    /** ⣼ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_345678 = '\u28FC';
    /** ⣽ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_1345678 = '\u28FD';
    /** ⣾ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_2345678 = '\u28FE';
    /** ⣿ of type OTHER_SYMBOL */
    char BRAILLE_PATTERN_DOTS_12345678 = '\u28FF';
    /** ⤀ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW_WITH_VERTICAL_STROKE = '\u2900';
    /** ⤁ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW_WITH_DOUBLE_VERTICAL_STROKE = '\u2901';
    /** ⤂ of type MATH_SYMBOL */
    char LEFTWARDS_DOUBLE_ARROW_WITH_VERTICAL_STROKE = '\u2902';
    /** ⤃ of type MATH_SYMBOL */
    char RIGHTWARDS_DOUBLE_ARROW_WITH_VERTICAL_STROKE = '\u2903';
    /** ⤄ of type MATH_SYMBOL */
    char LEFT_RIGHT_DOUBLE_ARROW_WITH_VERTICAL_STROKE = '\u2904';
    /** ⤅ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW_FROM_BAR = '\u2905';
    /** ⤆ of type MATH_SYMBOL */
    char LEFTWARDS_DOUBLE_ARROW_FROM_BAR = '\u2906';
    /** ⤇ of type MATH_SYMBOL */
    char RIGHTWARDS_DOUBLE_ARROW_FROM_BAR = '\u2907';
    /** ⤈ of type MATH_SYMBOL */
    char DOWNWARDS_ARROW_WITH_HORIZONTAL_STROKE = '\u2908';
    /** ⤉ of type MATH_SYMBOL */
    char UPWARDS_ARROW_WITH_HORIZONTAL_STROKE = '\u2909';
    /** ⤊ of type MATH_SYMBOL */
    char UPWARDS_TRIPLE_ARROW = '\u290A';
    /** ⤋ of type MATH_SYMBOL */
    char DOWNWARDS_TRIPLE_ARROW = '\u290B';
    /** ⤌ of type MATH_SYMBOL */
    char LEFTWARDS_DOUBLE_DASH_ARROW = '\u290C';
    /** ⤍ of type MATH_SYMBOL */
    char RIGHTWARDS_DOUBLE_DASH_ARROW = '\u290D';
    /** ⤎ of type MATH_SYMBOL */
    char LEFTWARDS_TRIPLE_DASH_ARROW = '\u290E';
    /** ⤏ of type MATH_SYMBOL */
    char RIGHTWARDS_TRIPLE_DASH_ARROW = '\u290F';
    /** ⤐ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_TRIPLE_DASH_ARROW = '\u2910';
    /** ⤑ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_DOTTED_STEM = '\u2911';
    /** ⤒ of type MATH_SYMBOL */
    char UPWARDS_ARROW_TO_BAR = '\u2912';
    /** ⤓ of type MATH_SYMBOL */
    char DOWNWARDS_ARROW_TO_BAR = '\u2913';
    /** ⤔ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_TAIL_WITH_VERTICAL_STROKE = '\u2914';
    /** ⤕ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_TAIL_WITH_DOUBLE_VERTICAL_STROKE = '\u2915';
    /** ⤖ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW_WITH_TAIL = '\u2916';
    /** ⤗ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW_WITH_TAIL_WITH_VERTICAL_STROKE = '\u2917';
    /** ⤘ of type MATH_SYMBOL */
    char RIGHTWARDS_TWO_HEADED_ARROW_WITH_TAIL_WITH_DOUBLE_VERTICAL_STROKE = '\u2918';
    /** ⤙ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_TAIL = '\u2919';
    /** ⤚ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_TAIL = '\u291A';
    /** ⤛ of type MATH_SYMBOL */
    char LEFTWARDS_DOUBLE_ARROW_TAIL = '\u291B';
    /** ⤜ of type MATH_SYMBOL */
    char RIGHTWARDS_DOUBLE_ARROW_TAIL = '\u291C';
    /** ⤝ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_TO_BLACK_DIAMOND = '\u291D';
    /** ⤞ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_TO_BLACK_DIAMOND = '\u291E';
    /** ⤟ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_FROM_BAR_TO_BLACK_DIAMOND = '\u291F';
    /** ⤠ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_FROM_BAR_TO_BLACK_DIAMOND = '\u2920';
    /** ⤡ of type MATH_SYMBOL */
    char NORTH_WEST_AND_SOUTH_EAST_ARROW = '\u2921';
    /** ⤢ of type MATH_SYMBOL */
    char NORTH_EAST_AND_SOUTH_WEST_ARROW = '\u2922';
    /** ⤣ of type MATH_SYMBOL */
    char NORTH_WEST_ARROW_WITH_HOOK = '\u2923';
    /** ⤤ of type MATH_SYMBOL */
    char NORTH_EAST_ARROW_WITH_HOOK = '\u2924';
    /** ⤥ of type MATH_SYMBOL */
    char SOUTH_EAST_ARROW_WITH_HOOK = '\u2925';
    /** ⤦ of type MATH_SYMBOL */
    char SOUTH_WEST_ARROW_WITH_HOOK = '\u2926';
    /** ⤧ of type MATH_SYMBOL */
    char NORTH_WEST_ARROW_AND_NORTH_EAST_ARROW = '\u2927';
    /** ⤨ of type MATH_SYMBOL */
    char NORTH_EAST_ARROW_AND_SOUTH_EAST_ARROW = '\u2928';
    /** ⤩ of type MATH_SYMBOL */
    char SOUTH_EAST_ARROW_AND_SOUTH_WEST_ARROW = '\u2929';
    /** ⤪ of type MATH_SYMBOL */
    char SOUTH_WEST_ARROW_AND_NORTH_WEST_ARROW = '\u292A';
    /** ⤫ of type MATH_SYMBOL */
    char RISING_DIAGONAL_CROSSING_FALLING_DIAGONAL = '\u292B';
    /** ⤬ of type MATH_SYMBOL */
    char FALLING_DIAGONAL_CROSSING_RISING_DIAGONAL = '\u292C';
    /** ⤭ of type MATH_SYMBOL */
    char SOUTH_EAST_ARROW_CROSSING_NORTH_EAST_ARROW = '\u292D';
    /** ⤮ of type MATH_SYMBOL */
    char NORTH_EAST_ARROW_CROSSING_SOUTH_EAST_ARROW = '\u292E';
    /** ⤯ of type MATH_SYMBOL */
    char FALLING_DIAGONAL_CROSSING_NORTH_EAST_ARROW = '\u292F';
    /** ⤰ of type MATH_SYMBOL */
    char RISING_DIAGONAL_CROSSING_SOUTH_EAST_ARROW = '\u2930';
    /** ⤱ of type MATH_SYMBOL */
    char NORTH_EAST_ARROW_CROSSING_NORTH_WEST_ARROW = '\u2931';
    /** ⤲ of type MATH_SYMBOL */
    char NORTH_WEST_ARROW_CROSSING_NORTH_EAST_ARROW = '\u2932';
    /** ⤳ of type MATH_SYMBOL */
    char WAVE_ARROW_POINTING_DIRECTLY_RIGHT = '\u2933';
    /** ⤴ of type MATH_SYMBOL */
    char ARROW_POINTING_RIGHTWARDS_THEN_CURVING_UPWARDS = '\u2934';
    /** ⤵ of type MATH_SYMBOL */
    char ARROW_POINTING_RIGHTWARDS_THEN_CURVING_DOWNWARDS = '\u2935';
    /** ⤶ of type MATH_SYMBOL */
    char ARROW_POINTING_DOWNWARDS_THEN_CURVING_LEFTWARDS = '\u2936';
    /** ⤷ of type MATH_SYMBOL */
    char ARROW_POINTING_DOWNWARDS_THEN_CURVING_RIGHTWARDS = '\u2937';
    /** ⤸ of type MATH_SYMBOL */
    char RIGHT_SIDE_ARC_CLOCKWISE_ARROW = '\u2938';
    /** ⤹ of type MATH_SYMBOL */
    char LEFT_SIDE_ARC_ANTICLOCKWISE_ARROW = '\u2939';
    /** ⤺ of type MATH_SYMBOL */
    char TOP_ARC_ANTICLOCKWISE_ARROW = '\u293A';
    /** ⤻ of type MATH_SYMBOL */
    char BOTTOM_ARC_ANTICLOCKWISE_ARROW = '\u293B';
    /** ⤼ of type MATH_SYMBOL */
    char TOP_ARC_CLOCKWISE_ARROW_WITH_MINUS = '\u293C';
    /** ⤽ of type MATH_SYMBOL */
    char TOP_ARC_ANTICLOCKWISE_ARROW_WITH_PLUS = '\u293D';
    /** ⤾ of type MATH_SYMBOL */
    char LOWER_RIGHT_SEMICIRCULAR_CLOCKWISE_ARROW = '\u293E';
    /** ⤿ of type MATH_SYMBOL */
    char LOWER_LEFT_SEMICIRCULAR_ANTICLOCKWISE_ARROW = '\u293F';
    /** ⥀ of type MATH_SYMBOL */
    char ANTICLOCKWISE_CLOSED_CIRCLE_ARROW = '\u2940';
    /** ⥁ of type MATH_SYMBOL */
    char CLOCKWISE_CLOSED_CIRCLE_ARROW = '\u2941';
    /** ⥂ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_ABOVE_SHORT_LEFTWARDS_ARROW = '\u2942';
    /** ⥃ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_ABOVE_SHORT_RIGHTWARDS_ARROW = '\u2943';
    /** ⥄ of type MATH_SYMBOL */
    char SHORT_RIGHTWARDS_ARROW_ABOVE_LEFTWARDS_ARROW = '\u2944';
    /** ⥅ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_PLUS_BELOW = '\u2945';
    /** ⥆ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_PLUS_BELOW = '\u2946';
    /** ⥇ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_THROUGH_X = '\u2947';
    /** ⥈ of type MATH_SYMBOL */
    char LEFT_RIGHT_ARROW_THROUGH_SMALL_CIRCLE = '\u2948';
    /** ⥉ of type MATH_SYMBOL */
    char UPWARDS_TWO_HEADED_ARROW_FROM_SMALL_CIRCLE = '\u2949';
    /** ⥊ of type MATH_SYMBOL */
    char LEFT_BARB_UP_RIGHT_BARB_DOWN_HARPOON = '\u294A';
    /** ⥋ of type MATH_SYMBOL */
    char LEFT_BARB_DOWN_RIGHT_BARB_UP_HARPOON = '\u294B';
    /** ⥌ of type MATH_SYMBOL */
    char UP_BARB_RIGHT_DOWN_BARB_LEFT_HARPOON = '\u294C';
    /** ⥍ of type MATH_SYMBOL */
    char UP_BARB_LEFT_DOWN_BARB_RIGHT_HARPOON = '\u294D';
    /** ⥎ of type MATH_SYMBOL */
    char LEFT_BARB_UP_RIGHT_BARB_UP_HARPOON = '\u294E';
    /** ⥏ of type MATH_SYMBOL */
    char UP_BARB_RIGHT_DOWN_BARB_RIGHT_HARPOON = '\u294F';
    /** ⥐ of type MATH_SYMBOL */
    char LEFT_BARB_DOWN_RIGHT_BARB_DOWN_HARPOON = '\u2950';
    /** ⥑ of type MATH_SYMBOL */
    char UP_BARB_LEFT_DOWN_BARB_LEFT_HARPOON = '\u2951';
    /** ⥒ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_UP_TO_BAR = '\u2952';
    /** ⥓ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_UP_TO_BAR = '\u2953';
    /** ⥔ of type MATH_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_RIGHT_TO_BAR = '\u2954';
    /** ⥕ of type MATH_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_RIGHT_TO_BAR = '\u2955';
    /** ⥖ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_DOWN_TO_BAR = '\u2956';
    /** ⥗ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_DOWN_TO_BAR = '\u2957';
    /** ⥘ of type MATH_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_LEFT_TO_BAR = '\u2958';
    /** ⥙ of type MATH_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_LEFT_TO_BAR = '\u2959';
    /** ⥚ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_UP_FROM_BAR = '\u295A';
    /** ⥛ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_UP_FROM_BAR = '\u295B';
    /** ⥜ of type MATH_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_RIGHT_FROM_BAR = '\u295C';
    /** ⥝ of type MATH_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_RIGHT_FROM_BAR = '\u295D';
    /** ⥞ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_DOWN_FROM_BAR = '\u295E';
    /** ⥟ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_DOWN_FROM_BAR = '\u295F';
    /** ⥠ of type MATH_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_LEFT_FROM_BAR = '\u2960';
    /** ⥡ of type MATH_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_LEFT_FROM_BAR = '\u2961';
    /** ⥢ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_UP_ABOVE_LEFTWARDS_HARPOON_WITH_BARB_DOWN = '\u2962';
    /** ⥣ of type MATH_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_LEFT_BESIDE_UPWARDS_HARPOON_WITH_BARB_RIGHT = '\u2963';
    /** ⥤ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_UP_ABOVE_RIGHTWARDS_HARPOON_WITH_BARB_DOWN = '\u2964';
    /** ⥥ of type MATH_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_LEFT_BESIDE_DOWNWARDS_HARPOON_WITH_BARB_RIGHT = '\u2965';
    /** ⥦ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_UP_ABOVE_RIGHTWARDS_HARPOON_WITH_BARB_UP = '\u2966';
    /** ⥧ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_DOWN_ABOVE_RIGHTWARDS_HARPOON_WITH_BARB_DOWN = '\u2967';
    /** ⥨ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_UP_ABOVE_LEFTWARDS_HARPOON_WITH_BARB_UP = '\u2968';
    /** ⥩ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_DOWN_ABOVE_LEFTWARDS_HARPOON_WITH_BARB_DOWN = '\u2969';
    /** ⥪ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_UP_ABOVE_LONG_DASH = '\u296A';
    /** ⥫ of type MATH_SYMBOL */
    char LEFTWARDS_HARPOON_WITH_BARB_DOWN_BELOW_LONG_DASH = '\u296B';
    /** ⥬ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_UP_ABOVE_LONG_DASH = '\u296C';
    /** ⥭ of type MATH_SYMBOL */
    char RIGHTWARDS_HARPOON_WITH_BARB_DOWN_BELOW_LONG_DASH = '\u296D';
    /** ⥮ of type MATH_SYMBOL */
    char UPWARDS_HARPOON_WITH_BARB_LEFT_BESIDE_DOWNWARDS_HARPOON_WITH_BARB_RIGHT = '\u296E';
    /** ⥯ of type MATH_SYMBOL */
    char DOWNWARDS_HARPOON_WITH_BARB_LEFT_BESIDE_UPWARDS_HARPOON_WITH_BARB_RIGHT = '\u296F';
    /** ⥰ of type MATH_SYMBOL */
    char RIGHT_DOUBLE_ARROW_WITH_ROUNDED_HEAD = '\u2970';
    /** ⥱ of type MATH_SYMBOL */
    char EQUALS_SIGN_ABOVE_RIGHTWARDS_ARROW = '\u2971';
    /** ⥲ of type MATH_SYMBOL */
    char TILDE_OPERATOR_ABOVE_RIGHTWARDS_ARROW = '\u2972';
    /** ⥳ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_ABOVE_TILDE_OPERATOR = '\u2973';
    /** ⥴ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_ABOVE_TILDE_OPERATOR = '\u2974';
    /** ⥵ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_ABOVE_ALMOST_EQUAL_TO = '\u2975';
    /** ⥶ of type MATH_SYMBOL */
    char LESS_THAN_ABOVE_LEFTWARDS_ARROW = '\u2976';
    /** ⥷ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_THROUGH_LESS_THAN = '\u2977';
    /** ⥸ of type MATH_SYMBOL */
    char GREATER_THAN_ABOVE_RIGHTWARDS_ARROW = '\u2978';
    /** ⥹ of type MATH_SYMBOL */
    char SUBSET_ABOVE_RIGHTWARDS_ARROW = '\u2979';
    /** ⥺ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_THROUGH_SUBSET = '\u297A';
    /** ⥻ of type MATH_SYMBOL */
    char SUPERSET_ABOVE_LEFTWARDS_ARROW = '\u297B';
    /** ⥼ of type MATH_SYMBOL */
    char LEFT_FISH_TAIL = '\u297C';
    /** ⥽ of type MATH_SYMBOL */
    char RIGHT_FISH_TAIL = '\u297D';
    /** ⥾ of type MATH_SYMBOL */
    char UP_FISH_TAIL = '\u297E';
    /** ⥿ of type MATH_SYMBOL */
    char DOWN_FISH_TAIL = '\u297F';
    /** ⦀ of type MATH_SYMBOL */
    char TRIPLE_VERTICAL_BAR_DELIMITER = '\u2980';
    /** ⦁ of type MATH_SYMBOL */
    char Z_NOTATION_SPOT = '\u2981';
    /** ⦂ of type MATH_SYMBOL */
    char Z_NOTATION_TYPE_COLON = '\u2982';
    /** ⦃ of type START_PUNCTUATION */
    char LEFT_WHITE_CURLY_BRACKET = '\u2983';
    /** ⦄ of type END_PUNCTUATION */
    char RIGHT_WHITE_CURLY_BRACKET = '\u2984';
    /** ⦅ of type START_PUNCTUATION */
    char LEFT_WHITE_PARENTHESIS = '\u2985';
    /** ⦆ of type END_PUNCTUATION */
    char RIGHT_WHITE_PARENTHESIS = '\u2986';
    /** ⦇ of type START_PUNCTUATION */
    char Z_NOTATION_LEFT_IMAGE_BRACKET = '\u2987';
    /** ⦈ of type END_PUNCTUATION */
    char Z_NOTATION_RIGHT_IMAGE_BRACKET = '\u2988';
    /** ⦉ of type START_PUNCTUATION */
    char Z_NOTATION_LEFT_BINDING_BRACKET = '\u2989';
    /** ⦊ of type END_PUNCTUATION */
    char Z_NOTATION_RIGHT_BINDING_BRACKET = '\u298A';
    /** ⦋ of type START_PUNCTUATION */
    char LEFT_SQUARE_BRACKET_WITH_UNDERBAR = '\u298B';
    /** ⦌ of type END_PUNCTUATION */
    char RIGHT_SQUARE_BRACKET_WITH_UNDERBAR = '\u298C';
    /** ⦍ of type START_PUNCTUATION */
    char LEFT_SQUARE_BRACKET_WITH_TICK_IN_TOP_CORNER = '\u298D';
    /** ⦎ of type END_PUNCTUATION */
    char RIGHT_SQUARE_BRACKET_WITH_TICK_IN_BOTTOM_CORNER = '\u298E';
    /** ⦏ of type START_PUNCTUATION */
    char LEFT_SQUARE_BRACKET_WITH_TICK_IN_BOTTOM_CORNER = '\u298F';
    /** ⦐ of type END_PUNCTUATION */
    char RIGHT_SQUARE_BRACKET_WITH_TICK_IN_TOP_CORNER = '\u2990';
    /** ⦑ of type START_PUNCTUATION */
    char LEFT_ANGLE_BRACKET_WITH_DOT = '\u2991';
    /** ⦒ of type END_PUNCTUATION */
    char RIGHT_ANGLE_BRACKET_WITH_DOT = '\u2992';
    /** ⦓ of type START_PUNCTUATION */
    char LEFT_ARC_LESS_THAN_BRACKET = '\u2993';
    /** ⦔ of type END_PUNCTUATION */
    char RIGHT_ARC_GREATER_THAN_BRACKET = '\u2994';
    /** ⦕ of type START_PUNCTUATION */
    char DOUBLE_LEFT_ARC_GREATER_THAN_BRACKET = '\u2995';
    /** ⦖ of type END_PUNCTUATION */
    char DOUBLE_RIGHT_ARC_LESS_THAN_BRACKET = '\u2996';
    /** ⦗ of type START_PUNCTUATION */
    char LEFT_BLACK_TORTOISE_SHELL_BRACKET = '\u2997';
    /** ⦘ of type END_PUNCTUATION */
    char RIGHT_BLACK_TORTOISE_SHELL_BRACKET = '\u2998';
    /** ⦙ of type MATH_SYMBOL */
    char DOTTED_FENCE = '\u2999';
    /** ⦚ of type MATH_SYMBOL */
    char VERTICAL_ZIGZAG_LINE = '\u299A';
    /** ⦛ of type MATH_SYMBOL */
    char MEASURED_ANGLE_OPENING_LEFT = '\u299B';
    /** ⦜ of type MATH_SYMBOL */
    char RIGHT_ANGLE_VARIANT_WITH_SQUARE = '\u299C';
    /** ⦝ of type MATH_SYMBOL */
    char MEASURED_RIGHT_ANGLE_WITH_DOT = '\u299D';
    /** ⦞ of type MATH_SYMBOL */
    char ANGLE_WITH_S_INSIDE = '\u299E';
    /** ⦟ of type MATH_SYMBOL */
    char ACUTE_ANGLE = '\u299F';
    /** ⦠ of type MATH_SYMBOL */
    char SPHERICAL_ANGLE_OPENING_LEFT = '\u29A0';
    /** ⦡ of type MATH_SYMBOL */
    char SPHERICAL_ANGLE_OPENING_UP = '\u29A1';
    /** ⦢ of type MATH_SYMBOL */
    char TURNED_ANGLE = '\u29A2';
    /** ⦣ of type MATH_SYMBOL */
    char REVERSED_ANGLE = '\u29A3';
    /** ⦤ of type MATH_SYMBOL */
    char ANGLE_WITH_UNDERBAR = '\u29A4';
    /** ⦥ of type MATH_SYMBOL */
    char REVERSED_ANGLE_WITH_UNDERBAR = '\u29A5';
    /** ⦦ of type MATH_SYMBOL */
    char OBLIQUE_ANGLE_OPENING_UP = '\u29A6';
    /** ⦧ of type MATH_SYMBOL */
    char OBLIQUE_ANGLE_OPENING_DOWN = '\u29A7';
    /** ⦨ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_UP_AND_RIGHT = '\u29A8';
    /** ⦩ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_UP_AND_LEFT = '\u29A9';
    /** ⦪ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_DOWN_AND_RIGHT = '\u29AA';
    /** ⦫ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_DOWN_AND_LEFT = '\u29AB';
    /** ⦬ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_RIGHT_AND_UP = '\u29AC';
    /** ⦭ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_LEFT_AND_UP = '\u29AD';
    /** ⦮ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_RIGHT_AND_DOWN = '\u29AE';
    /** ⦯ of type MATH_SYMBOL */
    char MEASURED_ANGLE_WITH_OPEN_ARM_ENDING_IN_ARROW_POINTING_LEFT_AND_DOWN = '\u29AF';
    /** ⦰ of type MATH_SYMBOL */
    char REVERSED_EMPTY_SET = '\u29B0';
    /** ⦱ of type MATH_SYMBOL */
    char EMPTY_SET_WITH_OVERBAR = '\u29B1';
    /** ⦲ of type MATH_SYMBOL */
    char EMPTY_SET_WITH_SMALL_CIRCLE_ABOVE = '\u29B2';
    /** ⦳ of type MATH_SYMBOL */
    char EMPTY_SET_WITH_RIGHT_ARROW_ABOVE = '\u29B3';
    /** ⦴ of type MATH_SYMBOL */
    char EMPTY_SET_WITH_LEFT_ARROW_ABOVE = '\u29B4';
    /** ⦵ of type MATH_SYMBOL */
    char CIRCLE_WITH_HORIZONTAL_BAR = '\u29B5';
    /** ⦶ of type MATH_SYMBOL */
    char CIRCLED_VERTICAL_BAR = '\u29B6';
    /** ⦷ of type MATH_SYMBOL */
    char CIRCLED_PARALLEL = '\u29B7';
    /** ⦸ of type MATH_SYMBOL */
    char CIRCLED_REVERSE_SOLIDUS = '\u29B8';
    /** ⦹ of type MATH_SYMBOL */
    char CIRCLED_PERPENDICULAR = '\u29B9';
    /** ⦺ of type MATH_SYMBOL */
    char CIRCLE_DIVIDED_BY_HORIZONTAL_BAR_AND_TOP_HALF_DIVIDED_BY_VERTICAL_BAR = '\u29BA';
    /** ⦻ of type MATH_SYMBOL */
    char CIRCLE_WITH_SUPERIMPOSED_X = '\u29BB';
    /** ⦼ of type MATH_SYMBOL */
    char CIRCLED_ANTICLOCKWISE_ROTATED_DIVISION_SIGN = '\u29BC';
    /** ⦽ of type MATH_SYMBOL */
    char UP_ARROW_THROUGH_CIRCLE = '\u29BD';
    /** ⦾ of type MATH_SYMBOL */
    char CIRCLED_WHITE_BULLET = '\u29BE';
    /** ⦿ of type MATH_SYMBOL */
    char CIRCLED_BULLET = '\u29BF';
    /** ⧀ of type MATH_SYMBOL */
    char CIRCLED_LESS_THAN = '\u29C0';
    /** ⧁ of type MATH_SYMBOL */
    char CIRCLED_GREATER_THAN = '\u29C1';
    /** ⧂ of type MATH_SYMBOL */
    char CIRCLE_WITH_SMALL_CIRCLE_TO_THE_RIGHT = '\u29C2';
    /** ⧃ of type MATH_SYMBOL */
    char CIRCLE_WITH_TWO_HORIZONTAL_STROKES_TO_THE_RIGHT = '\u29C3';
    /** ⧄ of type MATH_SYMBOL */
    char SQUARED_RISING_DIAGONAL_SLASH = '\u29C4';
    /** ⧅ of type MATH_SYMBOL */
    char SQUARED_FALLING_DIAGONAL_SLASH = '\u29C5';
    /** ⧆ of type MATH_SYMBOL */
    char SQUARED_ASTERISK = '\u29C6';
    /** ⧇ of type MATH_SYMBOL */
    char SQUARED_SMALL_CIRCLE = '\u29C7';
    /** ⧈ of type MATH_SYMBOL */
    char SQUARED_SQUARE = '\u29C8';
    /** ⧉ of type MATH_SYMBOL */
    char TWO_JOINED_SQUARES = '\u29C9';
    /** ⧊ of type MATH_SYMBOL */
    char TRIANGLE_WITH_DOT_ABOVE = '\u29CA';
    /** ⧋ of type MATH_SYMBOL */
    char TRIANGLE_WITH_UNDERBAR = '\u29CB';
    /** ⧌ of type MATH_SYMBOL */
    char S_IN_TRIANGLE = '\u29CC';
    /** ⧍ of type MATH_SYMBOL */
    char TRIANGLE_WITH_SERIFS_AT_BOTTOM = '\u29CD';
    /** ⧎ of type MATH_SYMBOL */
    char RIGHT_TRIANGLE_ABOVE_LEFT_TRIANGLE = '\u29CE';
    /** ⧏ of type MATH_SYMBOL */
    char LEFT_TRIANGLE_BESIDE_VERTICAL_BAR = '\u29CF';
    /** ⧐ of type MATH_SYMBOL */
    char VERTICAL_BAR_BESIDE_RIGHT_TRIANGLE = '\u29D0';
    /** ⧑ of type MATH_SYMBOL */
    char BOWTIE_WITH_LEFT_HALF_BLACK = '\u29D1';
    /** ⧒ of type MATH_SYMBOL */
    char BOWTIE_WITH_RIGHT_HALF_BLACK = '\u29D2';
    /** ⧓ of type MATH_SYMBOL */
    char BLACK_BOWTIE = '\u29D3';
    /** ⧔ of type MATH_SYMBOL */
    char TIMES_WITH_LEFT_HALF_BLACK = '\u29D4';
    /** ⧕ of type MATH_SYMBOL */
    char TIMES_WITH_RIGHT_HALF_BLACK = '\u29D5';
    /** ⧖ of type MATH_SYMBOL */
    char WHITE_HOURGLASS = '\u29D6';
    /** ⧗ of type MATH_SYMBOL */
    char BLACK_HOURGLASS = '\u29D7';
    /** ⧘ of type START_PUNCTUATION */
    char LEFT_WIGGLY_FENCE = '\u29D8';
    /** ⧙ of type END_PUNCTUATION */
    char RIGHT_WIGGLY_FENCE = '\u29D9';
    /** ⧚ of type START_PUNCTUATION */
    char LEFT_DOUBLE_WIGGLY_FENCE = '\u29DA';
    /** ⧛ of type END_PUNCTUATION */
    char RIGHT_DOUBLE_WIGGLY_FENCE = '\u29DB';
    /** ⧜ of type MATH_SYMBOL */
    char INCOMPLETE_INFINITY = '\u29DC';
    /** ⧝ of type MATH_SYMBOL */
    char TIE_OVER_INFINITY = '\u29DD';
    /** ⧞ of type MATH_SYMBOL */
    char INFINITY_NEGATED_WITH_VERTICAL_BAR = '\u29DE';
    /** ⧟ of type MATH_SYMBOL */
    char DOUBLE_ENDED_MULTIMAP = '\u29DF';
    /** ⧠ of type MATH_SYMBOL */
    char SQUARE_WITH_CONTOURED_OUTLINE = '\u29E0';
    /** ⧡ of type MATH_SYMBOL */
    char INCREASES_AS = '\u29E1';
    /** ⧢ of type MATH_SYMBOL */
    char SHUFFLE_PRODUCT = '\u29E2';
    /** ⧣ of type MATH_SYMBOL */
    char EQUALS_SIGN_AND_SLANTED_PARALLEL = '\u29E3';
    /** ⧤ of type MATH_SYMBOL */
    char EQUALS_SIGN_AND_SLANTED_PARALLEL_WITH_TILDE_ABOVE = '\u29E4';
    /** ⧥ of type MATH_SYMBOL */
    char IDENTICAL_TO_AND_SLANTED_PARALLEL = '\u29E5';
    /** ⧦ of type MATH_SYMBOL */
    char GLEICH_STARK = '\u29E6';
    /** ⧧ of type MATH_SYMBOL */
    char THERMODYNAMIC = '\u29E7';
    /** ⧨ of type MATH_SYMBOL */
    char DOWN_POINTING_TRIANGLE_WITH_LEFT_HALF_BLACK = '\u29E8';
    /** ⧩ of type MATH_SYMBOL */
    char DOWN_POINTING_TRIANGLE_WITH_RIGHT_HALF_BLACK = '\u29E9';
    /** ⧪ of type MATH_SYMBOL */
    char BLACK_DIAMOND_WITH_DOWN_ARROW = '\u29EA';
    /** ⧫ of type MATH_SYMBOL */
    char BLACK_LOZENGE = '\u29EB';
    /** ⧬ of type MATH_SYMBOL */
    char WHITE_CIRCLE_WITH_DOWN_ARROW = '\u29EC';
    /** ⧭ of type MATH_SYMBOL */
    char BLACK_CIRCLE_WITH_DOWN_ARROW = '\u29ED';
    /** ⧮ of type MATH_SYMBOL */
    char ERROR_BARRED_WHITE_SQUARE = '\u29EE';
    /** ⧯ of type MATH_SYMBOL */
    char ERROR_BARRED_BLACK_SQUARE = '\u29EF';
    /** ⧰ of type MATH_SYMBOL */
    char ERROR_BARRED_WHITE_DIAMOND = '\u29F0';
    /** ⧱ of type MATH_SYMBOL */
    char ERROR_BARRED_BLACK_DIAMOND = '\u29F1';
    /** ⧲ of type MATH_SYMBOL */
    char ERROR_BARRED_WHITE_CIRCLE = '\u29F2';
    /** ⧳ of type MATH_SYMBOL */
    char ERROR_BARRED_BLACK_CIRCLE = '\u29F3';
    /** ⧴ of type MATH_SYMBOL */
    char RULE_DELAYED = '\u29F4';
    /** ⧵ of type MATH_SYMBOL */
    char REVERSE_SOLIDUS_OPERATOR = '\u29F5';
    /** ⧶ of type MATH_SYMBOL */
    char SOLIDUS_WITH_OVERBAR = '\u29F6';
    /** ⧷ of type MATH_SYMBOL */
    char REVERSE_SOLIDUS_WITH_HORIZONTAL_STROKE = '\u29F7';
    /** ⧸ of type MATH_SYMBOL */
    char BIG_SOLIDUS = '\u29F8';
    /** ⧹ of type MATH_SYMBOL */
    char BIG_REVERSE_SOLIDUS = '\u29F9';
    /** ⧺ of type MATH_SYMBOL */
    char DOUBLE_PLUS = '\u29FA';
    /** ⧻ of type MATH_SYMBOL */
    char TRIPLE_PLUS = '\u29FB';
    /** ⧼ of type START_PUNCTUATION */
    char LEFT_POINTING_CURVED_ANGLE_BRACKET = '\u29FC';
    /** ⧽ of type END_PUNCTUATION */
    char RIGHT_POINTING_CURVED_ANGLE_BRACKET = '\u29FD';
    /** ⧾ of type MATH_SYMBOL */
    char TINY = '\u29FE';
    /** ⧿ of type MATH_SYMBOL */
    char MINY = '\u29FF';
    /** ⨀ of type MATH_SYMBOL */
    char N_ARY_CIRCLED_DOT_OPERATOR = '\u2A00';
    /** ⨁ of type MATH_SYMBOL */
    char N_ARY_CIRCLED_PLUS_OPERATOR = '\u2A01';
    /** ⨂ of type MATH_SYMBOL */
    char N_ARY_CIRCLED_TIMES_OPERATOR = '\u2A02';
    /** ⨃ of type MATH_SYMBOL */
    char N_ARY_UNION_OPERATOR_WITH_DOT = '\u2A03';
    /** ⨄ of type MATH_SYMBOL */
    char N_ARY_UNION_OPERATOR_WITH_PLUS = '\u2A04';
    /** ⨅ of type MATH_SYMBOL */
    char N_ARY_SQUARE_INTERSECTION_OPERATOR = '\u2A05';
    /** ⨆ of type MATH_SYMBOL */
    char N_ARY_SQUARE_UNION_OPERATOR = '\u2A06';
    /** ⨇ of type MATH_SYMBOL */
    char TWO_LOGICAL_AND_OPERATOR = '\u2A07';
    /** ⨈ of type MATH_SYMBOL */
    char TWO_LOGICAL_OR_OPERATOR = '\u2A08';
    /** ⨉ of type MATH_SYMBOL */
    char N_ARY_TIMES_OPERATOR = '\u2A09';
    /** ⨊ of type MATH_SYMBOL */
    char MODULO_TWO_SUM = '\u2A0A';
    /** ⨋ of type MATH_SYMBOL */
    char SUMMATION_WITH_INTEGRAL = '\u2A0B';
    /** ⨌ of type MATH_SYMBOL */
    char QUADRUPLE_INTEGRAL_OPERATOR = '\u2A0C';
    /** ⨍ of type MATH_SYMBOL */
    char FINITE_PART_INTEGRAL = '\u2A0D';
    /** ⨎ of type MATH_SYMBOL */
    char INTEGRAL_WITH_DOUBLE_STROKE = '\u2A0E';
    /** ⨏ of type MATH_SYMBOL */
    char INTEGRAL_AVERAGE_WITH_SLASH = '\u2A0F';
    /** ⨐ of type MATH_SYMBOL */
    char CIRCULATION_FUNCTION = '\u2A10';
    /** ⨑ of type MATH_SYMBOL */
    char ANTICLOCKWISE_INTEGRATION = '\u2A11';
    /** ⨒ of type MATH_SYMBOL */
    char LINE_INTEGRATION_WITH_RECTANGULAR_PATH_AROUND_POLE = '\u2A12';
    /** ⨓ of type MATH_SYMBOL */
    char LINE_INTEGRATION_WITH_SEMICIRCULAR_PATH_AROUND_POLE = '\u2A13';
    /** ⨔ of type MATH_SYMBOL */
    char LINE_INTEGRATION_NOT_INCLUDING_THE_POLE = '\u2A14';
    /** ⨕ of type MATH_SYMBOL */
    char INTEGRAL_AROUND_A_POINT_OPERATOR = '\u2A15';
    /** ⨖ of type MATH_SYMBOL */
    char QUATERNION_INTEGRAL_OPERATOR = '\u2A16';
    /** ⨗ of type MATH_SYMBOL */
    char INTEGRAL_WITH_LEFTWARDS_ARROW_WITH_HOOK = '\u2A17';
    /** ⨘ of type MATH_SYMBOL */
    char INTEGRAL_WITH_TIMES_SIGN = '\u2A18';
    /** ⨙ of type MATH_SYMBOL */
    char INTEGRAL_WITH_INTERSECTION = '\u2A19';
    /** ⨚ of type MATH_SYMBOL */
    char INTEGRAL_WITH_UNION = '\u2A1A';
    /** ⨛ of type MATH_SYMBOL */
    char INTEGRAL_WITH_OVERBAR = '\u2A1B';
    /** ⨜ of type MATH_SYMBOL */
    char INTEGRAL_WITH_UNDERBAR = '\u2A1C';
    /** ⨝ of type MATH_SYMBOL */
    char JOIN = '\u2A1D';
    /** ⨞ of type MATH_SYMBOL */
    char LARGE_LEFT_TRIANGLE_OPERATOR = '\u2A1E';
    /** ⨟ of type MATH_SYMBOL */
    char Z_NOTATION_SCHEMA_COMPOSITION = '\u2A1F';
    /** ⨠ of type MATH_SYMBOL */
    char Z_NOTATION_SCHEMA_PIPING = '\u2A20';
    /** ⨡ of type MATH_SYMBOL */
    char Z_NOTATION_SCHEMA_PROJECTION = '\u2A21';
    /** ⨢ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_SMALL_CIRCLE_ABOVE = '\u2A22';
    /** ⨣ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_CIRCUMFLEX_ACCENT_ABOVE = '\u2A23';
    /** ⨤ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_TILDE_ABOVE = '\u2A24';
    /** ⨥ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_DOT_BELOW = '\u2A25';
    /** ⨦ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_TILDE_BELOW = '\u2A26';
    /** ⨧ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_SUBSCRIPT_TWO = '\u2A27';
    /** ⨨ of type MATH_SYMBOL */
    char PLUS_SIGN_WITH_BLACK_TRIANGLE = '\u2A28';
    /** ⨩ of type MATH_SYMBOL */
    char MINUS_SIGN_WITH_COMMA_ABOVE = '\u2A29';
    /** ⨪ of type MATH_SYMBOL */
    char MINUS_SIGN_WITH_DOT_BELOW = '\u2A2A';
    /** ⨫ of type MATH_SYMBOL */
    char MINUS_SIGN_WITH_FALLING_DOTS = '\u2A2B';
    /** ⨬ of type MATH_SYMBOL */
    char MINUS_SIGN_WITH_RISING_DOTS = '\u2A2C';
    /** ⨭ of type MATH_SYMBOL */
    char PLUS_SIGN_IN_LEFT_HALF_CIRCLE = '\u2A2D';
    /** ⨮ of type MATH_SYMBOL */
    char PLUS_SIGN_IN_RIGHT_HALF_CIRCLE = '\u2A2E';
    /** ⨯ of type MATH_SYMBOL */
    char VECTOR_OR_CROSS_PRODUCT = '\u2A2F';
    /** ⨰ of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN_WITH_DOT_ABOVE = '\u2A30';
    /** ⨱ of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN_WITH_UNDERBAR = '\u2A31';
    /** ⨲ of type MATH_SYMBOL */
    char SEMIDIRECT_PRODUCT_WITH_BOTTOM_CLOSED = '\u2A32';
    /** ⨳ of type MATH_SYMBOL */
    char SMASH_PRODUCT = '\u2A33';
    /** ⨴ of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN_IN_LEFT_HALF_CIRCLE = '\u2A34';
    /** ⨵ of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN_IN_RIGHT_HALF_CIRCLE = '\u2A35';
    /** ⨶ of type MATH_SYMBOL */
    char CIRCLED_MULTIPLICATION_SIGN_WITH_CIRCUMFLEX_ACCENT = '\u2A36';
    /** ⨷ of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN_IN_DOUBLE_CIRCLE = '\u2A37';
    /** ⨸ of type MATH_SYMBOL */
    char CIRCLED_DIVISION_SIGN = '\u2A38';
    /** ⨹ of type MATH_SYMBOL */
    char PLUS_SIGN_IN_TRIANGLE = '\u2A39';
    /** ⨺ of type MATH_SYMBOL */
    char MINUS_SIGN_IN_TRIANGLE = '\u2A3A';
    /** ⨻ of type MATH_SYMBOL */
    char MULTIPLICATION_SIGN_IN_TRIANGLE = '\u2A3B';
    /** ⨼ of type MATH_SYMBOL */
    char INTERIOR_PRODUCT = '\u2A3C';
    /** ⨽ of type MATH_SYMBOL */
    char RIGHTHAND_INTERIOR_PRODUCT = '\u2A3D';
    /** ⨾ of type MATH_SYMBOL */
    char Z_NOTATION_RELATIONAL_COMPOSITION = '\u2A3E';
    /** ⨿ of type MATH_SYMBOL */
    char AMALGAMATION_OR_COPRODUCT = '\u2A3F';
    /** ⩀ of type MATH_SYMBOL */
    char INTERSECTION_WITH_DOT = '\u2A40';
    /** ⩁ of type MATH_SYMBOL */
    char UNION_WITH_MINUS_SIGN = '\u2A41';
    /** ⩂ of type MATH_SYMBOL */
    char UNION_WITH_OVERBAR = '\u2A42';
    /** ⩃ of type MATH_SYMBOL */
    char INTERSECTION_WITH_OVERBAR = '\u2A43';
    /** ⩄ of type MATH_SYMBOL */
    char INTERSECTION_WITH_LOGICAL_AND = '\u2A44';
    /** ⩅ of type MATH_SYMBOL */
    char UNION_WITH_LOGICAL_OR = '\u2A45';
    /** ⩆ of type MATH_SYMBOL */
    char UNION_ABOVE_INTERSECTION = '\u2A46';
    /** ⩇ of type MATH_SYMBOL */
    char INTERSECTION_ABOVE_UNION = '\u2A47';
    /** ⩈ of type MATH_SYMBOL */
    char UNION_ABOVE_BAR_ABOVE_INTERSECTION = '\u2A48';
    /** ⩉ of type MATH_SYMBOL */
    char INTERSECTION_ABOVE_BAR_ABOVE_UNION = '\u2A49';
    /** ⩊ of type MATH_SYMBOL */
    char UNION_BESIDE_AND_JOINED_WITH_UNION = '\u2A4A';
    /** ⩋ of type MATH_SYMBOL */
    char INTERSECTION_BESIDE_AND_JOINED_WITH_INTERSECTION = '\u2A4B';
    /** ⩌ of type MATH_SYMBOL */
    char CLOSED_UNION_WITH_SERIFS = '\u2A4C';
    /** ⩍ of type MATH_SYMBOL */
    char CLOSED_INTERSECTION_WITH_SERIFS = '\u2A4D';
    /** ⩎ of type MATH_SYMBOL */
    char DOUBLE_SQUARE_INTERSECTION = '\u2A4E';
    /** ⩏ of type MATH_SYMBOL */
    char DOUBLE_SQUARE_UNION = '\u2A4F';
    /** ⩐ of type MATH_SYMBOL */
    char CLOSED_UNION_WITH_SERIFS_AND_SMASH_PRODUCT = '\u2A50';
    /** ⩑ of type MATH_SYMBOL */
    char LOGICAL_AND_WITH_DOT_ABOVE = '\u2A51';
    /** ⩒ of type MATH_SYMBOL */
    char LOGICAL_OR_WITH_DOT_ABOVE = '\u2A52';
    /** ⩓ of type MATH_SYMBOL */
    char DOUBLE_LOGICAL_AND = '\u2A53';
    /** ⩔ of type MATH_SYMBOL */
    char DOUBLE_LOGICAL_OR = '\u2A54';
    /** ⩕ of type MATH_SYMBOL */
    char TWO_INTERSECTING_LOGICAL_AND = '\u2A55';
    /** ⩖ of type MATH_SYMBOL */
    char TWO_INTERSECTING_LOGICAL_OR = '\u2A56';
    /** ⩗ of type MATH_SYMBOL */
    char SLOPING_LARGE_OR = '\u2A57';
    /** ⩘ of type MATH_SYMBOL */
    char SLOPING_LARGE_AND = '\u2A58';
    /** ⩙ of type MATH_SYMBOL */
    char LOGICAL_OR_OVERLAPPING_LOGICAL_AND = '\u2A59';
    /** ⩚ of type MATH_SYMBOL */
    char LOGICAL_AND_WITH_MIDDLE_STEM = '\u2A5A';
    /** ⩛ of type MATH_SYMBOL */
    char LOGICAL_OR_WITH_MIDDLE_STEM = '\u2A5B';
    /** ⩜ of type MATH_SYMBOL */
    char LOGICAL_AND_WITH_HORIZONTAL_DASH = '\u2A5C';
    /** ⩝ of type MATH_SYMBOL */
    char LOGICAL_OR_WITH_HORIZONTAL_DASH = '\u2A5D';
    /** ⩞ of type MATH_SYMBOL */
    char LOGICAL_AND_WITH_DOUBLE_OVERBAR = '\u2A5E';
    /** ⩟ of type MATH_SYMBOL */
    char LOGICAL_AND_WITH_UNDERBAR = '\u2A5F';
    /** ⩠ of type MATH_SYMBOL */
    char LOGICAL_AND_WITH_DOUBLE_UNDERBAR = '\u2A60';
    /** ⩡ of type MATH_SYMBOL */
    char SMALL_VEE_WITH_UNDERBAR = '\u2A61';
    /** ⩢ of type MATH_SYMBOL */
    char LOGICAL_OR_WITH_DOUBLE_OVERBAR = '\u2A62';
    /** ⩣ of type MATH_SYMBOL */
    char LOGICAL_OR_WITH_DOUBLE_UNDERBAR = '\u2A63';
    /** ⩤ of type MATH_SYMBOL */
    char Z_NOTATION_DOMAIN_ANTIRESTRICTION = '\u2A64';
    /** ⩥ of type MATH_SYMBOL */
    char Z_NOTATION_RANGE_ANTIRESTRICTION = '\u2A65';
    /** ⩦ of type MATH_SYMBOL */
    char EQUALS_SIGN_WITH_DOT_BELOW = '\u2A66';
    /** ⩧ of type MATH_SYMBOL */
    char IDENTICAL_WITH_DOT_ABOVE = '\u2A67';
    /** ⩨ of type MATH_SYMBOL */
    char TRIPLE_HORIZONTAL_BAR_WITH_DOUBLE_VERTICAL_STROKE = '\u2A68';
    /** ⩩ of type MATH_SYMBOL */
    char TRIPLE_HORIZONTAL_BAR_WITH_TRIPLE_VERTICAL_STROKE = '\u2A69';
    /** ⩪ of type MATH_SYMBOL */
    char TILDE_OPERATOR_WITH_DOT_ABOVE = '\u2A6A';
    /** ⩫ of type MATH_SYMBOL */
    char TILDE_OPERATOR_WITH_RISING_DOTS = '\u2A6B';
    /** ⩬ of type MATH_SYMBOL */
    char SIMILAR_MINUS_SIMILAR = '\u2A6C';
    /** ⩭ of type MATH_SYMBOL */
    char CONGRUENT_WITH_DOT_ABOVE = '\u2A6D';
    /** ⩮ of type MATH_SYMBOL */
    char EQUALS_WITH_ASTERISK = '\u2A6E';
    /** ⩯ of type MATH_SYMBOL */
    char ALMOST_EQUAL_TO_WITH_CIRCUMFLEX_ACCENT = '\u2A6F';
    /** ⩰ of type MATH_SYMBOL */
    char APPROXIMATELY_EQUAL_OR_EQUAL_TO = '\u2A70';
    /** ⩱ of type MATH_SYMBOL */
    char EQUALS_SIGN_ABOVE_PLUS_SIGN = '\u2A71';
    /** ⩲ of type MATH_SYMBOL */
    char PLUS_SIGN_ABOVE_EQUALS_SIGN = '\u2A72';
    /** ⩳ of type MATH_SYMBOL */
    char EQUALS_SIGN_ABOVE_TILDE_OPERATOR = '\u2A73';
    /** ⩴ of type MATH_SYMBOL */
    char DOUBLE_COLON_EQUAL = '\u2A74';
    /** ⩵ of type MATH_SYMBOL */
    char TWO_CONSECUTIVE_EQUALS_SIGNS = '\u2A75';
    /** ⩶ of type MATH_SYMBOL */
    char THREE_CONSECUTIVE_EQUALS_SIGNS = '\u2A76';
    /** ⩷ of type MATH_SYMBOL */
    char EQUALS_SIGN_WITH_TWO_DOTS_ABOVE_AND_TWO_DOTS_BELOW = '\u2A77';
    /** ⩸ of type MATH_SYMBOL */
    char EQUIVALENT_WITH_FOUR_DOTS_ABOVE = '\u2A78';
    /** ⩹ of type MATH_SYMBOL */
    char LESS_THAN_WITH_CIRCLE_INSIDE = '\u2A79';
    /** ⩺ of type MATH_SYMBOL */
    char GREATER_THAN_WITH_CIRCLE_INSIDE = '\u2A7A';
    /** ⩻ of type MATH_SYMBOL */
    char LESS_THAN_WITH_QUESTION_MARK_ABOVE = '\u2A7B';
    /** ⩼ of type MATH_SYMBOL */
    char GREATER_THAN_WITH_QUESTION_MARK_ABOVE = '\u2A7C';
    /** ⩽ of type MATH_SYMBOL */
    char LESS_THAN_OR_SLANTED_EQUAL_TO = '\u2A7D';
    /** ⩾ of type MATH_SYMBOL */
    char GREATER_THAN_OR_SLANTED_EQUAL_TO = '\u2A7E';
    /** ⩿ of type MATH_SYMBOL */
    char LESS_THAN_OR_SLANTED_EQUAL_TO_WITH_DOT_INSIDE = '\u2A7F';
    /** ⪀ of type MATH_SYMBOL */
    char GREATER_THAN_OR_SLANTED_EQUAL_TO_WITH_DOT_INSIDE = '\u2A80';
    /** ⪁ of type MATH_SYMBOL */
    char LESS_THAN_OR_SLANTED_EQUAL_TO_WITH_DOT_ABOVE = '\u2A81';
    /** ⪂ of type MATH_SYMBOL */
    char GREATER_THAN_OR_SLANTED_EQUAL_TO_WITH_DOT_ABOVE = '\u2A82';
    /** ⪃ of type MATH_SYMBOL */
    char LESS_THAN_OR_SLANTED_EQUAL_TO_WITH_DOT_ABOVE_RIGHT = '\u2A83';
    /** ⪄ of type MATH_SYMBOL */
    char GREATER_THAN_OR_SLANTED_EQUAL_TO_WITH_DOT_ABOVE_LEFT = '\u2A84';
    /** ⪅ of type MATH_SYMBOL */
    char LESS_THAN_OR_APPROXIMATE = '\u2A85';
    /** ⪆ of type MATH_SYMBOL */
    char GREATER_THAN_OR_APPROXIMATE = '\u2A86';
    /** ⪇ of type MATH_SYMBOL */
    char LESS_THAN_AND_SINGLE_LINE_NOT_EQUAL_TO = '\u2A87';
    /** ⪈ of type MATH_SYMBOL */
    char GREATER_THAN_AND_SINGLE_LINE_NOT_EQUAL_TO = '\u2A88';
    /** ⪉ of type MATH_SYMBOL */
    char LESS_THAN_AND_NOT_APPROXIMATE = '\u2A89';
    /** ⪊ of type MATH_SYMBOL */
    char GREATER_THAN_AND_NOT_APPROXIMATE = '\u2A8A';
    /** ⪋ of type MATH_SYMBOL */
    char LESS_THAN_ABOVE_DOUBLE_LINE_EQUAL_ABOVE_GREATER_THAN = '\u2A8B';
    /** ⪌ of type MATH_SYMBOL */
    char GREATER_THAN_ABOVE_DOUBLE_LINE_EQUAL_ABOVE_LESS_THAN = '\u2A8C';
    /** ⪍ of type MATH_SYMBOL */
    char LESS_THAN_ABOVE_SIMILAR_OR_EQUAL = '\u2A8D';
    /** ⪎ of type MATH_SYMBOL */
    char GREATER_THAN_ABOVE_SIMILAR_OR_EQUAL = '\u2A8E';
    /** ⪏ of type MATH_SYMBOL */
    char LESS_THAN_ABOVE_SIMILAR_ABOVE_GREATER_THAN = '\u2A8F';
    /** ⪐ of type MATH_SYMBOL */
    char GREATER_THAN_ABOVE_SIMILAR_ABOVE_LESS_THAN = '\u2A90';
    /** ⪑ of type MATH_SYMBOL */
    char LESS_THAN_ABOVE_GREATER_THAN_ABOVE_DOUBLE_LINE_EQUAL = '\u2A91';
    /** ⪒ of type MATH_SYMBOL */
    char GREATER_THAN_ABOVE_LESS_THAN_ABOVE_DOUBLE_LINE_EQUAL = '\u2A92';
    /** ⪓ of type MATH_SYMBOL */
    char LESS_THAN_ABOVE_SLANTED_EQUAL_ABOVE_GREATER_THAN_ABOVE_SLANTED_EQUAL = '\u2A93';
    /** ⪔ of type MATH_SYMBOL */
    char GREATER_THAN_ABOVE_SLANTED_EQUAL_ABOVE_LESS_THAN_ABOVE_SLANTED_EQUAL = '\u2A94';
    /** ⪕ of type MATH_SYMBOL */
    char SLANTED_EQUAL_TO_OR_LESS_THAN = '\u2A95';
    /** ⪖ of type MATH_SYMBOL */
    char SLANTED_EQUAL_TO_OR_GREATER_THAN = '\u2A96';
    /** ⪗ of type MATH_SYMBOL */
    char SLANTED_EQUAL_TO_OR_LESS_THAN_WITH_DOT_INSIDE = '\u2A97';
    /** ⪘ of type MATH_SYMBOL */
    char SLANTED_EQUAL_TO_OR_GREATER_THAN_WITH_DOT_INSIDE = '\u2A98';
    /** ⪙ of type MATH_SYMBOL */
    char DOUBLE_LINE_EQUAL_TO_OR_LESS_THAN = '\u2A99';
    /** ⪚ of type MATH_SYMBOL */
    char DOUBLE_LINE_EQUAL_TO_OR_GREATER_THAN = '\u2A9A';
    /** ⪛ of type MATH_SYMBOL */
    char DOUBLE_LINE_SLANTED_EQUAL_TO_OR_LESS_THAN = '\u2A9B';
    /** ⪜ of type MATH_SYMBOL */
    char DOUBLE_LINE_SLANTED_EQUAL_TO_OR_GREATER_THAN = '\u2A9C';
    /** ⪝ of type MATH_SYMBOL */
    char SIMILAR_OR_LESS_THAN = '\u2A9D';
    /** ⪞ of type MATH_SYMBOL */
    char SIMILAR_OR_GREATER_THAN = '\u2A9E';
    /** ⪟ of type MATH_SYMBOL */
    char SIMILAR_ABOVE_LESS_THAN_ABOVE_EQUALS_SIGN = '\u2A9F';
    /** ⪠ of type MATH_SYMBOL */
    char SIMILAR_ABOVE_GREATER_THAN_ABOVE_EQUALS_SIGN = '\u2AA0';
    /** ⪡ of type MATH_SYMBOL */
    char DOUBLE_NESTED_LESS_THAN = '\u2AA1';
    /** ⪢ of type MATH_SYMBOL */
    char DOUBLE_NESTED_GREATER_THAN = '\u2AA2';
    /** ⪣ of type MATH_SYMBOL */
    char DOUBLE_NESTED_LESS_THAN_WITH_UNDERBAR = '\u2AA3';
    /** ⪤ of type MATH_SYMBOL */
    char GREATER_THAN_OVERLAPPING_LESS_THAN = '\u2AA4';
    /** ⪥ of type MATH_SYMBOL */
    char GREATER_THAN_BESIDE_LESS_THAN = '\u2AA5';
    /** ⪦ of type MATH_SYMBOL */
    char LESS_THAN_CLOSED_BY_CURVE = '\u2AA6';
    /** ⪧ of type MATH_SYMBOL */
    char GREATER_THAN_CLOSED_BY_CURVE = '\u2AA7';
    /** ⪨ of type MATH_SYMBOL */
    char LESS_THAN_CLOSED_BY_CURVE_ABOVE_SLANTED_EQUAL = '\u2AA8';
    /** ⪩ of type MATH_SYMBOL */
    char GREATER_THAN_CLOSED_BY_CURVE_ABOVE_SLANTED_EQUAL = '\u2AA9';
    /** ⪪ of type MATH_SYMBOL */
    char SMALLER_THAN = '\u2AAA';
    /** ⪫ of type MATH_SYMBOL */
    char LARGER_THAN = '\u2AAB';
    /** ⪬ of type MATH_SYMBOL */
    char SMALLER_THAN_OR_EQUAL_TO = '\u2AAC';
    /** ⪭ of type MATH_SYMBOL */
    char LARGER_THAN_OR_EQUAL_TO = '\u2AAD';
    /** ⪮ of type MATH_SYMBOL */
    char EQUALS_SIGN_WITH_BUMPY_ABOVE = '\u2AAE';
    /** ⪯ of type MATH_SYMBOL */
    char PRECEDES_ABOVE_SINGLE_LINE_EQUALS_SIGN = '\u2AAF';
    /** ⪰ of type MATH_SYMBOL */
    char SUCCEEDS_ABOVE_SINGLE_LINE_EQUALS_SIGN = '\u2AB0';
    /** ⪱ of type MATH_SYMBOL */
    char PRECEDES_ABOVE_SINGLE_LINE_NOT_EQUAL_TO = '\u2AB1';
    /** ⪲ of type MATH_SYMBOL */
    char SUCCEEDS_ABOVE_SINGLE_LINE_NOT_EQUAL_TO = '\u2AB2';
    /** ⪳ of type MATH_SYMBOL */
    char PRECEDES_ABOVE_EQUALS_SIGN = '\u2AB3';
    /** ⪴ of type MATH_SYMBOL */
    char SUCCEEDS_ABOVE_EQUALS_SIGN = '\u2AB4';
    /** ⪵ of type MATH_SYMBOL */
    char PRECEDES_ABOVE_NOT_EQUAL_TO = '\u2AB5';
    /** ⪶ of type MATH_SYMBOL */
    char SUCCEEDS_ABOVE_NOT_EQUAL_TO = '\u2AB6';
    /** ⪷ of type MATH_SYMBOL */
    char PRECEDES_ABOVE_ALMOST_EQUAL_TO = '\u2AB7';
    /** ⪸ of type MATH_SYMBOL */
    char SUCCEEDS_ABOVE_ALMOST_EQUAL_TO = '\u2AB8';
    /** ⪹ of type MATH_SYMBOL */
    char PRECEDES_ABOVE_NOT_ALMOST_EQUAL_TO = '\u2AB9';
    /** ⪺ of type MATH_SYMBOL */
    char SUCCEEDS_ABOVE_NOT_ALMOST_EQUAL_TO = '\u2ABA';
    /** ⪻ of type MATH_SYMBOL */
    char DOUBLE_PRECEDES = '\u2ABB';
    /** ⪼ of type MATH_SYMBOL */
    char DOUBLE_SUCCEEDS = '\u2ABC';
    /** ⪽ of type MATH_SYMBOL */
    char SUBSET_WITH_DOT = '\u2ABD';
    /** ⪾ of type MATH_SYMBOL */
    char SUPERSET_WITH_DOT = '\u2ABE';
    /** ⪿ of type MATH_SYMBOL */
    char SUBSET_WITH_PLUS_SIGN_BELOW = '\u2ABF';
    /** ⫀ of type MATH_SYMBOL */
    char SUPERSET_WITH_PLUS_SIGN_BELOW = '\u2AC0';
    /** ⫁ of type MATH_SYMBOL */
    char SUBSET_WITH_MULTIPLICATION_SIGN_BELOW = '\u2AC1';
    /** ⫂ of type MATH_SYMBOL */
    char SUPERSET_WITH_MULTIPLICATION_SIGN_BELOW = '\u2AC2';
    /** ⫃ of type MATH_SYMBOL */
    char SUBSET_OF_OR_EQUAL_TO_WITH_DOT_ABOVE = '\u2AC3';
    /** ⫄ of type MATH_SYMBOL */
    char SUPERSET_OF_OR_EQUAL_TO_WITH_DOT_ABOVE = '\u2AC4';
    /** ⫅ of type MATH_SYMBOL */
    char SUBSET_OF_ABOVE_EQUALS_SIGN = '\u2AC5';
    /** ⫆ of type MATH_SYMBOL */
    char SUPERSET_OF_ABOVE_EQUALS_SIGN = '\u2AC6';
    /** ⫇ of type MATH_SYMBOL */
    char SUBSET_OF_ABOVE_TILDE_OPERATOR = '\u2AC7';
    /** ⫈ of type MATH_SYMBOL */
    char SUPERSET_OF_ABOVE_TILDE_OPERATOR = '\u2AC8';
    /** ⫉ of type MATH_SYMBOL */
    char SUBSET_OF_ABOVE_ALMOST_EQUAL_TO = '\u2AC9';
    /** ⫊ of type MATH_SYMBOL */
    char SUPERSET_OF_ABOVE_ALMOST_EQUAL_TO = '\u2ACA';
    /** ⫋ of type MATH_SYMBOL */
    char SUBSET_OF_ABOVE_NOT_EQUAL_TO = '\u2ACB';
    /** ⫌ of type MATH_SYMBOL */
    char SUPERSET_OF_ABOVE_NOT_EQUAL_TO = '\u2ACC';
    /** ⫍ of type MATH_SYMBOL */
    char SQUARE_LEFT_OPEN_BOX_OPERATOR = '\u2ACD';
    /** ⫎ of type MATH_SYMBOL */
    char SQUARE_RIGHT_OPEN_BOX_OPERATOR = '\u2ACE';
    /** ⫏ of type MATH_SYMBOL */
    char CLOSED_SUBSET = '\u2ACF';
    /** ⫐ of type MATH_SYMBOL */
    char CLOSED_SUPERSET = '\u2AD0';
    /** ⫑ of type MATH_SYMBOL */
    char CLOSED_SUBSET_OR_EQUAL_TO = '\u2AD1';
    /** ⫒ of type MATH_SYMBOL */
    char CLOSED_SUPERSET_OR_EQUAL_TO = '\u2AD2';
    /** ⫓ of type MATH_SYMBOL */
    char SUBSET_ABOVE_SUPERSET = '\u2AD3';
    /** ⫔ of type MATH_SYMBOL */
    char SUPERSET_ABOVE_SUBSET = '\u2AD4';
    /** ⫕ of type MATH_SYMBOL */
    char SUBSET_ABOVE_SUBSET = '\u2AD5';
    /** ⫖ of type MATH_SYMBOL */
    char SUPERSET_ABOVE_SUPERSET = '\u2AD6';
    /** ⫗ of type MATH_SYMBOL */
    char SUPERSET_BESIDE_SUBSET = '\u2AD7';
    /** ⫘ of type MATH_SYMBOL */
    char SUPERSET_BESIDE_AND_JOINED_BY_DASH_WITH_SUBSET = '\u2AD8';
    /** ⫙ of type MATH_SYMBOL */
    char ELEMENT_OF_OPENING_DOWNWARDS = '\u2AD9';
    /** ⫚ of type MATH_SYMBOL */
    char PITCHFORK_WITH_TEE_TOP = '\u2ADA';
    /** ⫛ of type MATH_SYMBOL */
    char TRANSVERSAL_INTERSECTION = '\u2ADB';
    /** ⫝̸ of type MATH_SYMBOL */
    char FORKING = '\u2ADC';
    /** ⫝ of type MATH_SYMBOL */
    char NONFORKING = '\u2ADD';
    /** ⫞ of type MATH_SYMBOL */
    char SHORT_LEFT_TACK = '\u2ADE';
    /** ⫟ of type MATH_SYMBOL */
    char SHORT_DOWN_TACK = '\u2ADF';
    /** ⫠ of type MATH_SYMBOL */
    char SHORT_UP_TACK = '\u2AE0';
    /** ⫡ of type MATH_SYMBOL */
    char PERPENDICULAR_WITH_S = '\u2AE1';
    /** ⫢ of type MATH_SYMBOL */
    char VERTICAL_BAR_TRIPLE_RIGHT_TURNSTILE = '\u2AE2';
    /** ⫣ of type MATH_SYMBOL */
    char DOUBLE_VERTICAL_BAR_LEFT_TURNSTILE = '\u2AE3';
    /** ⫤ of type MATH_SYMBOL */
    char VERTICAL_BAR_DOUBLE_LEFT_TURNSTILE = '\u2AE4';
    /** ⫥ of type MATH_SYMBOL */
    char DOUBLE_VERTICAL_BAR_DOUBLE_LEFT_TURNSTILE = '\u2AE5';
    /** ⫦ of type MATH_SYMBOL */
    char LONG_DASH_FROM_LEFT_MEMBER_OF_DOUBLE_VERTICAL = '\u2AE6';
    /** ⫧ of type MATH_SYMBOL */
    char SHORT_DOWN_TACK_WITH_OVERBAR = '\u2AE7';
    /** ⫨ of type MATH_SYMBOL */
    char SHORT_UP_TACK_WITH_UNDERBAR = '\u2AE8';
    /** ⫩ of type MATH_SYMBOL */
    char SHORT_UP_TACK_ABOVE_SHORT_DOWN_TACK = '\u2AE9';
    /** ⫪ of type MATH_SYMBOL */
    char DOUBLE_DOWN_TACK = '\u2AEA';
    /** ⫫ of type MATH_SYMBOL */
    char DOUBLE_UP_TACK = '\u2AEB';
    /** ⫬ of type MATH_SYMBOL */
    char DOUBLE_STROKE_NOT_SIGN = '\u2AEC';
    /** ⫭ of type MATH_SYMBOL */
    char REVERSED_DOUBLE_STROKE_NOT_SIGN = '\u2AED';
    /** ⫮ of type MATH_SYMBOL */
    char DOES_NOT_DIVIDE_WITH_REVERSED_NEGATION_SLASH = '\u2AEE';
    /** ⫯ of type MATH_SYMBOL */
    char VERTICAL_LINE_WITH_CIRCLE_ABOVE = '\u2AEF';
    /** ⫰ of type MATH_SYMBOL */
    char VERTICAL_LINE_WITH_CIRCLE_BELOW = '\u2AF0';
    /** ⫱ of type MATH_SYMBOL */
    char DOWN_TACK_WITH_CIRCLE_BELOW = '\u2AF1';
    /** ⫲ of type MATH_SYMBOL */
    char PARALLEL_WITH_HORIZONTAL_STROKE = '\u2AF2';
    /** ⫳ of type MATH_SYMBOL */
    char PARALLEL_WITH_TILDE_OPERATOR = '\u2AF3';
    /** ⫴ of type MATH_SYMBOL */
    char TRIPLE_VERTICAL_BAR_BINARY_RELATION = '\u2AF4';
    /** ⫵ of type MATH_SYMBOL */
    char TRIPLE_VERTICAL_BAR_WITH_HORIZONTAL_STROKE = '\u2AF5';
    /** ⫶ of type MATH_SYMBOL */
    char TRIPLE_COLON_OPERATOR = '\u2AF6';
    /** ⫷ of type MATH_SYMBOL */
    char TRIPLE_NESTED_LESS_THAN = '\u2AF7';
    /** ⫸ of type MATH_SYMBOL */
    char TRIPLE_NESTED_GREATER_THAN = '\u2AF8';
    /** ⫹ of type MATH_SYMBOL */
    char DOUBLE_LINE_SLANTED_LESS_THAN_OR_EQUAL_TO = '\u2AF9';
    /** ⫺ of type MATH_SYMBOL */
    char DOUBLE_LINE_SLANTED_GREATER_THAN_OR_EQUAL_TO = '\u2AFA';
    /** ⫻ of type MATH_SYMBOL */
    char TRIPLE_SOLIDUS_BINARY_RELATION = '\u2AFB';
    /** ⫼ of type MATH_SYMBOL */
    char LARGE_TRIPLE_VERTICAL_BAR_OPERATOR = '\u2AFC';
    /** ⫽ of type MATH_SYMBOL */
    char DOUBLE_SOLIDUS_OPERATOR = '\u2AFD';
    /** ⫾ of type MATH_SYMBOL */
    char WHITE_VERTICAL_BAR = '\u2AFE';
    /** ⫿ of type MATH_SYMBOL */
    char N_ARY_WHITE_VERTICAL_BAR = '\u2AFF';
    /** ⬀ of type OTHER_SYMBOL */
    char NORTH_EAST_WHITE_ARROW = '\u2B00';
    /** ⬁ of type OTHER_SYMBOL */
    char NORTH_WEST_WHITE_ARROW = '\u2B01';
    /** ⬂ of type OTHER_SYMBOL */
    char SOUTH_EAST_WHITE_ARROW = '\u2B02';
    /** ⬃ of type OTHER_SYMBOL */
    char SOUTH_WEST_WHITE_ARROW = '\u2B03';
    /** ⬄ of type OTHER_SYMBOL */
    char LEFT_RIGHT_WHITE_ARROW = '\u2B04';
    /** ⬅ of type OTHER_SYMBOL */
    char LEFTWARDS_BLACK_ARROW = '\u2B05';
    /** ⬆ of type OTHER_SYMBOL */
    char UPWARDS_BLACK_ARROW = '\u2B06';
    /** ⬇ of type OTHER_SYMBOL */
    char DOWNWARDS_BLACK_ARROW = '\u2B07';
    /** ⬈ of type OTHER_SYMBOL */
    char NORTH_EAST_BLACK_ARROW = '\u2B08';
    /** ⬉ of type OTHER_SYMBOL */
    char NORTH_WEST_BLACK_ARROW = '\u2B09';
    /** ⬊ of type OTHER_SYMBOL */
    char SOUTH_EAST_BLACK_ARROW = '\u2B0A';
    /** ⬋ of type OTHER_SYMBOL */
    char SOUTH_WEST_BLACK_ARROW = '\u2B0B';
    /** ⬌ of type OTHER_SYMBOL */
    char LEFT_RIGHT_BLACK_ARROW = '\u2B0C';
    /** ⬍ of type OTHER_SYMBOL */
    char UP_DOWN_BLACK_ARROW = '\u2B0D';
    /** ⬎ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_TIP_DOWNWARDS = '\u2B0E';
    /** ⬏ of type OTHER_SYMBOL */
    char RIGHTWARDS_ARROW_WITH_TIP_UPWARDS = '\u2B0F';
    /** ⬐ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_WITH_TIP_DOWNWARDS = '\u2B10';
    /** ⬑ of type OTHER_SYMBOL */
    char LEFTWARDS_ARROW_WITH_TIP_UPWARDS = '\u2B11';
    /** ⬒ of type OTHER_SYMBOL */
    char SQUARE_WITH_TOP_HALF_BLACK = '\u2B12';
    /** ⬓ of type OTHER_SYMBOL */
    char SQUARE_WITH_BOTTOM_HALF_BLACK = '\u2B13';
    /** ⬔ of type OTHER_SYMBOL */
    char SQUARE_WITH_UPPER_RIGHT_DIAGONAL_HALF_BLACK = '\u2B14';
    /** ⬕ of type OTHER_SYMBOL */
    char SQUARE_WITH_LOWER_LEFT_DIAGONAL_HALF_BLACK = '\u2B15';
    /** ⬖ of type OTHER_SYMBOL */
    char DIAMOND_WITH_LEFT_HALF_BLACK = '\u2B16';
    /** ⬗ of type OTHER_SYMBOL */
    char DIAMOND_WITH_RIGHT_HALF_BLACK = '\u2B17';
    /** ⬘ of type OTHER_SYMBOL */
    char DIAMOND_WITH_TOP_HALF_BLACK = '\u2B18';
    /** ⬙ of type OTHER_SYMBOL */
    char DIAMOND_WITH_BOTTOM_HALF_BLACK = '\u2B19';
    /** ⬚ of type OTHER_SYMBOL */
    char DOTTED_SQUARE = '\u2B1A';
    /** ⬛ of type OTHER_SYMBOL */
    char BLACK_LARGE_SQUARE = '\u2B1B';
    /** ⬜ of type OTHER_SYMBOL */
    char WHITE_LARGE_SQUARE = '\u2B1C';
    /** ⬝ of type OTHER_SYMBOL */
    char BLACK_VERY_SMALL_SQUARE = '\u2B1D';
    /** ⬞ of type OTHER_SYMBOL */
    char WHITE_VERY_SMALL_SQUARE = '\u2B1E';
    /** ⬟ of type OTHER_SYMBOL */
    char BLACK_PENTAGON = '\u2B1F';
    /** ⬠ of type OTHER_SYMBOL */
    char WHITE_PENTAGON = '\u2B20';
    /** ⬡ of type OTHER_SYMBOL */
    char WHITE_HEXAGON = '\u2B21';
    /** ⬢ of type OTHER_SYMBOL */
    char BLACK_HEXAGON = '\u2B22';
    /** ⬣ of type OTHER_SYMBOL */
    char HORIZONTAL_BLACK_HEXAGON = '\u2B23';
    /** ⬤ of type OTHER_SYMBOL */
    char BLACK_LARGE_CIRCLE = '\u2B24';
    /** ⬥ of type OTHER_SYMBOL */
    char BLACK_MEDIUM_DIAMOND = '\u2B25';
    /** ⬦ of type OTHER_SYMBOL */
    char WHITE_MEDIUM_DIAMOND = '\u2B26';
    /** ⬧ of type OTHER_SYMBOL */
    char BLACK_MEDIUM_LOZENGE = '\u2B27';
    /** ⬨ of type OTHER_SYMBOL */
    char WHITE_MEDIUM_LOZENGE = '\u2B28';
    /** ⬩ of type OTHER_SYMBOL */
    char BLACK_SMALL_DIAMOND = '\u2B29';
    /** ⬪ of type OTHER_SYMBOL */
    char BLACK_SMALL_LOZENGE = '\u2B2A';
    /** ⬫ of type OTHER_SYMBOL */
    char WHITE_SMALL_LOZENGE = '\u2B2B';
    /** ⬬ of type OTHER_SYMBOL */
    char BLACK_HORIZONTAL_ELLIPSE = '\u2B2C';
    /** ⬭ of type OTHER_SYMBOL */
    char WHITE_HORIZONTAL_ELLIPSE = '\u2B2D';
    /** ⬮ of type OTHER_SYMBOL */
    char BLACK_VERTICAL_ELLIPSE = '\u2B2E';
    /** ⬯ of type OTHER_SYMBOL */
    char WHITE_VERTICAL_ELLIPSE = '\u2B2F';
    /** ⬰ of type MATH_SYMBOL */
    char LEFT_ARROW_WITH_SMALL_CIRCLE = '\u2B30';
    /** ⬱ of type MATH_SYMBOL */
    char THREE_LEFTWARDS_ARROWS = '\u2B31';
    /** ⬲ of type MATH_SYMBOL */
    char LEFT_ARROW_WITH_CIRCLED_PLUS = '\u2B32';
    /** ⬳ of type MATH_SYMBOL */
    char LONG_LEFTWARDS_SQUIGGLE_ARROW = '\u2B33';
    /** ⬴ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW_WITH_VERTICAL_STROKE = '\u2B34';
    /** ⬵ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW_WITH_DOUBLE_VERTICAL_STROKE = '\u2B35';
    /** ⬶ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW_FROM_BAR = '\u2B36';
    /** ⬷ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_TRIPLE_DASH_ARROW = '\u2B37';
    /** ⬸ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_DOTTED_STEM = '\u2B38';
    /** ⬹ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_TAIL_WITH_VERTICAL_STROKE = '\u2B39';
    /** ⬺ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_WITH_TAIL_WITH_DOUBLE_VERTICAL_STROKE = '\u2B3A';
    /** ⬻ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW_WITH_TAIL = '\u2B3B';
    /** ⬼ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW_WITH_TAIL_WITH_VERTICAL_STROKE = '\u2B3C';
    /** ⬽ of type MATH_SYMBOL */
    char LEFTWARDS_TWO_HEADED_ARROW_WITH_TAIL_WITH_DOUBLE_VERTICAL_STROKE = '\u2B3D';
    /** ⬾ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_THROUGH_X = '\u2B3E';
    /** ⬿ of type MATH_SYMBOL */
    char WAVE_ARROW_POINTING_DIRECTLY_LEFT = '\u2B3F';
    /** ⭀ of type MATH_SYMBOL */
    char EQUALS_SIGN_ABOVE_LEFTWARDS_ARROW = '\u2B40';
    /** ⭁ of type MATH_SYMBOL */
    char REVERSE_TILDE_OPERATOR_ABOVE_LEFTWARDS_ARROW = '\u2B41';
    /** ⭂ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_ABOVE_REVERSE_ALMOST_EQUAL_TO = '\u2B42';
    /** ⭃ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_THROUGH_GREATER_THAN = '\u2B43';
    /** ⭄ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_THROUGH_SUPERSET = '\u2B44';
    /** ⭅ of type OTHER_SYMBOL */
    char LEFTWARDS_QUADRUPLE_ARROW = '\u2B45';
    /** ⭆ of type OTHER_SYMBOL */
    char RIGHTWARDS_QUADRUPLE_ARROW = '\u2B46';
    /** ⭇ of type MATH_SYMBOL */
    char REVERSE_TILDE_OPERATOR_ABOVE_RIGHTWARDS_ARROW = '\u2B47';
    /** ⭈ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_ABOVE_REVERSE_ALMOST_EQUAL_TO = '\u2B48';
    /** ⭉ of type MATH_SYMBOL */
    char TILDE_OPERATOR_ABOVE_LEFTWARDS_ARROW = '\u2B49';
    /** ⭊ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_ABOVE_ALMOST_EQUAL_TO = '\u2B4A';
    /** ⭋ of type MATH_SYMBOL */
    char LEFTWARDS_ARROW_ABOVE_REVERSE_TILDE_OPERATOR = '\u2B4B';
    /** ⭌ of type MATH_SYMBOL */
    char RIGHTWARDS_ARROW_ABOVE_REVERSE_TILDE_OPERATOR = '\u2B4C';
    /** ⭐ of type OTHER_SYMBOL */
    char WHITE_MEDIUM_STAR = '\u2B50';
    /** ⭑ of type OTHER_SYMBOL */
    char BLACK_SMALL_STAR = '\u2B51';
    /** ⭒ of type OTHER_SYMBOL */
    char WHITE_SMALL_STAR = '\u2B52';
    /** ⭓ of type OTHER_SYMBOL */
    char BLACK_RIGHT_POINTING_PENTAGON = '\u2B53';
    /** ⭔ of type OTHER_SYMBOL */
    char WHITE_RIGHT_POINTING_PENTAGON = '\u2B54';
    /** ⭕ of type OTHER_SYMBOL */
    char HEAVY_LARGE_CIRCLE = '\u2B55';
    /** ⭖ of type OTHER_SYMBOL */
    char HEAVY_OVAL_WITH_OVAL_INSIDE = '\u2B56';
    /** ⭗ of type OTHER_SYMBOL */
    char HEAVY_CIRCLE_WITH_CIRCLE_INSIDE = '\u2B57';
    /** ⭘ of type OTHER_SYMBOL */
    char HEAVY_CIRCLE = '\u2B58';
    /** ⭙ of type OTHER_SYMBOL */
    char HEAVY_CIRCLED_SALTIRE = '\u2B59';
    /** Ⰰ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_AZU = '\u2C00';
    /** Ⰱ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_BUKY = '\u2C01';
    /** Ⰲ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_VEDE = '\u2C02';
    /** Ⰳ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_GLAGOLI = '\u2C03';
    /** Ⰴ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_DOBRO = '\u2C04';
    /** Ⰵ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_YESTU = '\u2C05';
    /** Ⰶ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_ZHIVETE = '\u2C06';
    /** Ⰷ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_DZELO = '\u2C07';
    /** Ⰸ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_ZEMLJA = '\u2C08';
    /** Ⰹ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_IZHE = '\u2C09';
    /** Ⰺ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_INITIAL_IZHE = '\u2C0A';
    /** Ⰻ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_I = '\u2C0B';
    /** Ⰼ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_DJERVI = '\u2C0C';
    /** Ⰽ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_KAKO = '\u2C0D';
    /** Ⰾ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_LJUDIJE = '\u2C0E';
    /** Ⰿ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_MYSLITE = '\u2C0F';
    /** Ⱀ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_NASHI = '\u2C10';
    /** Ⱁ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_ONU = '\u2C11';
    /** Ⱂ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_POKOJI = '\u2C12';
    /** Ⱃ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_RITSI = '\u2C13';
    /** Ⱄ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SLOVO = '\u2C14';
    /** Ⱅ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_TVRIDO = '\u2C15';
    /** Ⱆ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_UKU = '\u2C16';
    /** Ⱇ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_FRITU = '\u2C17';
    /** Ⱈ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_HERU = '\u2C18';
    /** Ⱉ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_OTU = '\u2C19';
    /** Ⱊ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_PE = '\u2C1A';
    /** Ⱋ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SHTA = '\u2C1B';
    /** Ⱌ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_TSI = '\u2C1C';
    /** Ⱍ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_CHRIVI = '\u2C1D';
    /** Ⱎ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SHA = '\u2C1E';
    /** Ⱏ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_YERU = '\u2C1F';
    /** Ⱐ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_YERI = '\u2C20';
    /** Ⱑ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_YATI = '\u2C21';
    /** Ⱒ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SPIDERY_HA = '\u2C22';
    /** Ⱓ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_YU = '\u2C23';
    /** Ⱔ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SMALL_YUS = '\u2C24';
    /** Ⱕ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SMALL_YUS_WITH_TAIL = '\u2C25';
    /** Ⱖ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_YO = '\u2C26';
    /** Ⱗ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_IOTATED_SMALL_YUS = '\u2C27';
    /** Ⱘ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_BIG_YUS = '\u2C28';
    /** Ⱙ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_IOTATED_BIG_YUS = '\u2C29';
    /** Ⱚ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_FITA = '\u2C2A';
    /** Ⱛ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_IZHITSA = '\u2C2B';
    /** Ⱜ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_SHTAPIC = '\u2C2C';
    /** Ⱝ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_TROKUTASTI_A = '\u2C2D';
    /** Ⱞ of type UPPERCASE_LETTER */
    char GLAGOLITIC_CAPITAL_LETTER_LATINATE_MYSLITE = '\u2C2E';
    /** ⰰ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_AZU = '\u2C30';
    /** ⰱ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_BUKY = '\u2C31';
    /** ⰲ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_VEDE = '\u2C32';
    /** ⰳ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_GLAGOLI = '\u2C33';
    /** ⰴ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_DOBRO = '\u2C34';
    /** ⰵ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_YESTU = '\u2C35';
    /** ⰶ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_ZHIVETE = '\u2C36';
    /** ⰷ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_DZELO = '\u2C37';
    /** ⰸ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_ZEMLJA = '\u2C38';
    /** ⰹ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_IZHE = '\u2C39';
    /** ⰺ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_INITIAL_IZHE = '\u2C3A';
    /** ⰻ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_I = '\u2C3B';
    /** ⰼ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_DJERVI = '\u2C3C';
    /** ⰽ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_KAKO = '\u2C3D';
    /** ⰾ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_LJUDIJE = '\u2C3E';
    /** ⰿ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_MYSLITE = '\u2C3F';
    /** ⱀ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_NASHI = '\u2C40';
    /** ⱁ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_ONU = '\u2C41';
    /** ⱂ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_POKOJI = '\u2C42';
    /** ⱃ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_RITSI = '\u2C43';
    /** ⱄ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SLOVO = '\u2C44';
    /** ⱅ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_TVRIDO = '\u2C45';
    /** ⱆ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_UKU = '\u2C46';
    /** ⱇ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_FRITU = '\u2C47';
    /** ⱈ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_HERU = '\u2C48';
    /** ⱉ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_OTU = '\u2C49';
    /** ⱊ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_PE = '\u2C4A';
    /** ⱋ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SHTA = '\u2C4B';
    /** ⱌ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_TSI = '\u2C4C';
    /** ⱍ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_CHRIVI = '\u2C4D';
    /** ⱎ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SHA = '\u2C4E';
    /** ⱏ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_YERU = '\u2C4F';
    /** ⱐ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_YERI = '\u2C50';
    /** ⱑ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_YATI = '\u2C51';
    /** ⱒ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SPIDERY_HA = '\u2C52';
    /** ⱓ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_YU = '\u2C53';
    /** ⱔ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SMALL_YUS = '\u2C54';
    /** ⱕ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SMALL_YUS_WITH_TAIL = '\u2C55';
    /** ⱖ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_YO = '\u2C56';
    /** ⱗ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_IOTATED_SMALL_YUS = '\u2C57';
    /** ⱘ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_BIG_YUS = '\u2C58';
    /** ⱙ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_IOTATED_BIG_YUS = '\u2C59';
    /** ⱚ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_FITA = '\u2C5A';
    /** ⱛ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_IZHITSA = '\u2C5B';
    /** ⱜ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_SHTAPIC = '\u2C5C';
    /** ⱝ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_TROKUTASTI_A = '\u2C5D';
    /** ⱞ of type LOWERCASE_LETTER */
    char GLAGOLITIC_SMALL_LETTER_LATINATE_MYSLITE = '\u2C5E';
    /** ⱽ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_V = '\u2C7D';
    /** Ⲁ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_ALFA = '\u2C80';
    /** ⲁ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_ALFA = '\u2C81';
    /** Ⲃ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_VIDA = '\u2C82';
    /** ⲃ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_VIDA = '\u2C83';
    /** Ⲅ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_GAMMA = '\u2C84';
    /** ⲅ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_GAMMA = '\u2C85';
    /** Ⲇ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_DALDA = '\u2C86';
    /** ⲇ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_DALDA = '\u2C87';
    /** Ⲉ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_EIE = '\u2C88';
    /** ⲉ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_EIE = '\u2C89';
    /** Ⲋ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_SOU = '\u2C8A';
    /** ⲋ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_SOU = '\u2C8B';
    /** Ⲍ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_ZATA = '\u2C8C';
    /** ⲍ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_ZATA = '\u2C8D';
    /** Ⲏ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_HATE = '\u2C8E';
    /** ⲏ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_HATE = '\u2C8F';
    /** Ⲑ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_THETHE = '\u2C90';
    /** ⲑ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_THETHE = '\u2C91';
    /** Ⲓ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_IAUDA = '\u2C92';
    /** ⲓ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_IAUDA = '\u2C93';
    /** Ⲕ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_KAPA = '\u2C94';
    /** ⲕ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_KAPA = '\u2C95';
    /** Ⲗ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_LAULA = '\u2C96';
    /** ⲗ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_LAULA = '\u2C97';
    /** Ⲙ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_MI = '\u2C98';
    /** ⲙ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_MI = '\u2C99';
    /** Ⲛ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_NI = '\u2C9A';
    /** ⲛ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_NI = '\u2C9B';
    /** Ⲝ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_KSI = '\u2C9C';
    /** ⲝ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_KSI = '\u2C9D';
    /** Ⲟ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_O = '\u2C9E';
    /** ⲟ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_O = '\u2C9F';
    /** Ⲡ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_PI = '\u2CA0';
    /** ⲡ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_PI = '\u2CA1';
    /** Ⲣ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_RO = '\u2CA2';
    /** ⲣ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_RO = '\u2CA3';
    /** Ⲥ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_SIMA = '\u2CA4';
    /** ⲥ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_SIMA = '\u2CA5';
    /** Ⲧ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_TAU = '\u2CA6';
    /** ⲧ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_TAU = '\u2CA7';
    /** Ⲩ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_UA = '\u2CA8';
    /** ⲩ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_UA = '\u2CA9';
    /** Ⲫ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_FI = '\u2CAA';
    /** ⲫ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_FI = '\u2CAB';
    /** Ⲭ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_KHI = '\u2CAC';
    /** ⲭ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_KHI = '\u2CAD';
    /** Ⲯ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_PSI = '\u2CAE';
    /** ⲯ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_PSI = '\u2CAF';
    /** Ⲱ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OOU = '\u2CB0';
    /** ⲱ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OOU = '\u2CB1';
    /** Ⲳ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_DIALECT_P_ALEF = '\u2CB2';
    /** ⲳ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_DIALECT_P_ALEF = '\u2CB3';
    /** Ⲵ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_AIN = '\u2CB4';
    /** ⲵ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_AIN = '\u2CB5';
    /** Ⲷ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_CRYPTOGRAMMIC_EIE = '\u2CB6';
    /** ⲷ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_CRYPTOGRAMMIC_EIE = '\u2CB7';
    /** Ⲹ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_DIALECT_P_KAPA = '\u2CB8';
    /** ⲹ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_DIALECT_P_KAPA = '\u2CB9';
    /** Ⲻ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_DIALECT_P_NI = '\u2CBA';
    /** ⲻ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_DIALECT_P_NI = '\u2CBB';
    /** Ⲽ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_CRYPTOGRAMMIC_NI = '\u2CBC';
    /** ⲽ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_CRYPTOGRAMMIC_NI = '\u2CBD';
    /** Ⲿ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_OOU = '\u2CBE';
    /** ⲿ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_OOU = '\u2CBF';
    /** Ⳁ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_SAMPI = '\u2CC0';
    /** ⳁ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_SAMPI = '\u2CC1';
    /** Ⳃ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_CROSSED_SHEI = '\u2CC2';
    /** ⳃ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_CROSSED_SHEI = '\u2CC3';
    /** Ⳅ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_SHEI = '\u2CC4';
    /** ⳅ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_SHEI = '\u2CC5';
    /** Ⳇ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_ESH = '\u2CC6';
    /** ⳇ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_ESH = '\u2CC7';
    /** Ⳉ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_AKHMIMIC_KHEI = '\u2CC8';
    /** ⳉ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_AKHMIMIC_KHEI = '\u2CC9';
    /** Ⳋ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_DIALECT_P_HORI = '\u2CCA';
    /** ⳋ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_DIALECT_P_HORI = '\u2CCB';
    /** Ⳍ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_HORI = '\u2CCC';
    /** ⳍ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_HORI = '\u2CCD';
    /** Ⳏ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_HA = '\u2CCE';
    /** ⳏ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_HA = '\u2CCF';
    /** Ⳑ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_L_SHAPED_HA = '\u2CD0';
    /** ⳑ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_L_SHAPED_HA = '\u2CD1';
    /** Ⳓ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_HEI = '\u2CD2';
    /** ⳓ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_HEI = '\u2CD3';
    /** Ⳕ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_HAT = '\u2CD4';
    /** ⳕ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_HAT = '\u2CD5';
    /** Ⳗ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_GANGIA = '\u2CD6';
    /** ⳗ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_GANGIA = '\u2CD7';
    /** Ⳙ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_DJA = '\u2CD8';
    /** ⳙ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_DJA = '\u2CD9';
    /** Ⳛ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_COPTIC_SHIMA = '\u2CDA';
    /** ⳛ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_COPTIC_SHIMA = '\u2CDB';
    /** Ⳝ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_NUBIAN_SHIMA = '\u2CDC';
    /** ⳝ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_NUBIAN_SHIMA = '\u2CDD';
    /** Ⳟ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_NUBIAN_NGI = '\u2CDE';
    /** ⳟ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_NUBIAN_NGI = '\u2CDF';
    /** Ⳡ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_NUBIAN_NYI = '\u2CE0';
    /** ⳡ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_NUBIAN_NYI = '\u2CE1';
    /** Ⳣ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_OLD_NUBIAN_WAU = '\u2CE2';
    /** ⳣ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_OLD_NUBIAN_WAU = '\u2CE3';
    /** ⳤ of type LOWERCASE_LETTER */
    char COPTIC_SYMBOL_KAI = '\u2CE4';
    /** ⳥ of type OTHER_SYMBOL */
    char COPTIC_SYMBOL_MI_RO = '\u2CE5';
    /** ⳦ of type OTHER_SYMBOL */
    char COPTIC_SYMBOL_PI_RO = '\u2CE6';
    /** ⳧ of type OTHER_SYMBOL */
    char COPTIC_SYMBOL_STAUROS = '\u2CE7';
    /** ⳨ of type OTHER_SYMBOL */
    char COPTIC_SYMBOL_TAU_RO = '\u2CE8';
    /** ⳩ of type OTHER_SYMBOL */
    char COPTIC_SYMBOL_KHI_RO = '\u2CE9';
    /** ⳪ of type OTHER_SYMBOL */
    char COPTIC_SYMBOL_SHIMA_SIMA = '\u2CEA';
    /** Ⳬ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_CRYPTOGRAMMIC_SHEI = '\u2CEB';
    /** ⳬ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_CRYPTOGRAMMIC_SHEI = '\u2CEC';
    /** Ⳮ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_CRYPTOGRAMMIC_GANGIA = '\u2CED';
    /** ⳮ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_CRYPTOGRAMMIC_GANGIA = '\u2CEE';
    /** ⳯ of type NON_SPACING_MARK */
    char COPTIC_COMBINING_NI_ABOVE = '\u2CEF';
    /** ⳰ of type NON_SPACING_MARK */
    char COPTIC_COMBINING_SPIRITUS_ASPER = '\u2CF0';
    /** ⳱ of type NON_SPACING_MARK */
    char COPTIC_COMBINING_SPIRITUS_LENIS = '\u2CF1';
    /** Ⳳ of type UPPERCASE_LETTER */
    char COPTIC_CAPITAL_LETTER_BOHAIRIC_KHEI = '\u2CF2';
    /** ⳳ of type LOWERCASE_LETTER */
    char COPTIC_SMALL_LETTER_BOHAIRIC_KHEI = '\u2CF3';
    /** ⳹ of type OTHER_PUNCTUATION */
    char COPTIC_OLD_NUBIAN_FULL_STOP = '\u2CF9';
    /** ⳺ of type OTHER_PUNCTUATION */
    char COPTIC_OLD_NUBIAN_DIRECT_QUESTION_MARK = '\u2CFA';
    /** ⳻ of type OTHER_PUNCTUATION */
    char COPTIC_OLD_NUBIAN_INDIRECT_QUESTION_MARK = '\u2CFB';
    /** ⳼ of type OTHER_PUNCTUATION */
    char COPTIC_OLD_NUBIAN_VERSE_DIVIDER = '\u2CFC';
    /** ⳽ of type OTHER_NUMBER */
    char COPTIC_FRACTION_ONE_HALF = '\u2CFD';
    /** ⳾ of type OTHER_PUNCTUATION */
    char COPTIC_FULL_STOP = '\u2CFE';
    /** ⳿ of type OTHER_PUNCTUATION */
    char COPTIC_MORPHOLOGICAL_DIVIDER = '\u2CFF';
    /** ⴰ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YA = '\u2D30';
    /** ⴱ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAB = '\u2D31';
    /** ⴲ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YABH = '\u2D32';
    /** ⴳ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAG = '\u2D33';
    /** ⴴ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAGHH = '\u2D34';
    /** ⴵ of type OTHER_LETTER */
    char TIFINAGH_LETTER_BERBER_ACADEMY_YAJ = '\u2D35';
    /** ⴶ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAJ = '\u2D36';
    /** ⴷ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAD = '\u2D37';
    /** ⴸ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YADH = '\u2D38';
    /** ⴹ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YADD = '\u2D39';
    /** ⴺ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YADDH = '\u2D3A';
    /** ⴻ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YEY = '\u2D3B';
    /** ⴼ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAF = '\u2D3C';
    /** ⴽ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAK = '\u2D3D';
    /** ⴾ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAK = '\u2D3E';
    /** ⴿ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAKHH = '\u2D3F';
    /** ⵀ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAH = '\u2D40';
    /** ⵁ of type OTHER_LETTER */
    char TIFINAGH_LETTER_BERBER_ACADEMY_YAH = '\u2D41';
    /** ⵂ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAH = '\u2D42';
    /** ⵃ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAHH = '\u2D43';
    /** ⵄ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAA = '\u2D44';
    /** ⵅ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAKH = '\u2D45';
    /** ⵆ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAKH = '\u2D46';
    /** ⵇ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAQ = '\u2D47';
    /** ⵈ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAQ = '\u2D48';
    /** ⵉ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YI = '\u2D49';
    /** ⵊ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAZH = '\u2D4A';
    /** ⵋ of type OTHER_LETTER */
    char TIFINAGH_LETTER_AHAGGAR_YAZH = '\u2D4B';
    /** ⵌ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAZH = '\u2D4C';
    /** ⵍ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAL = '\u2D4D';
    /** ⵎ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAM = '\u2D4E';
    /** ⵏ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAN = '\u2D4F';
    /** ⵐ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAGN = '\u2D50';
    /** ⵑ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YANG = '\u2D51';
    /** ⵒ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAP = '\u2D52';
    /** ⵓ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YU = '\u2D53';
    /** ⵔ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAR = '\u2D54';
    /** ⵕ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YARR = '\u2D55';
    /** ⵖ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAGH = '\u2D56';
    /** ⵗ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TUAREG_YAGH = '\u2D57';
    /** ⵘ of type OTHER_LETTER */
    char TIFINAGH_LETTER_AYER_YAGH = '\u2D58';
    /** ⵙ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAS = '\u2D59';
    /** ⵚ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YASS = '\u2D5A';
    /** ⵛ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YASH = '\u2D5B';
    /** ⵜ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAT = '\u2D5C';
    /** ⵝ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YATH = '\u2D5D';
    /** ⵞ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YACH = '\u2D5E';
    /** ⵟ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YATT = '\u2D5F';
    /** ⵠ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAV = '\u2D60';
    /** ⵡ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAW = '\u2D61';
    /** ⵢ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAY = '\u2D62';
    /** ⵣ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAZ = '\u2D63';
    /** ⵤ of type OTHER_LETTER */
    char TIFINAGH_LETTER_TAWELLEMET_YAZ = '\u2D64';
    /** ⵥ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YAZZ = '\u2D65';
    /** ⵦ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YE = '\u2D66';
    /** ⵧ of type OTHER_LETTER */
    char TIFINAGH_LETTER_YO = '\u2D67';
    /** ⵯ of type MODIFIER_LETTER */
    char TIFINAGH_MODIFIER_LETTER_LABIALIZATION_MARK = '\u2D6F';
    /** ⵰ of type OTHER_PUNCTUATION */
    char TIFINAGH_SEPARATOR_MARK = '\u2D70';
    /** ⵿ of type NON_SPACING_MARK */
    char TIFINAGH_CONSONANT_JOINER = '\u2D7F';
    /** ⸀ of type OTHER_PUNCTUATION */
    char RIGHT_ANGLE_SUBSTITUTION_MARKER = '\u2E00';
    /** ⸁ of type OTHER_PUNCTUATION */
    char RIGHT_ANGLE_DOTTED_SUBSTITUTION_MARKER = '\u2E01';
    /** ⸂ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_SUBSTITUTION_BRACKET = '\u2E02';
    /** ⸃ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_SUBSTITUTION_BRACKET = '\u2E03';
    /** ⸄ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_DOTTED_SUBSTITUTION_BRACKET = '\u2E04';
    /** ⸅ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_DOTTED_SUBSTITUTION_BRACKET = '\u2E05';
    /** ⸆ of type OTHER_PUNCTUATION */
    char RAISED_INTERPOLATION_MARKER = '\u2E06';
    /** ⸇ of type OTHER_PUNCTUATION */
    char RAISED_DOTTED_INTERPOLATION_MARKER = '\u2E07';
    /** ⸈ of type OTHER_PUNCTUATION */
    char DOTTED_TRANSPOSITION_MARKER = '\u2E08';
    /** ⸉ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_TRANSPOSITION_BRACKET = '\u2E09';
    /** ⸊ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_TRANSPOSITION_BRACKET = '\u2E0A';
    /** ⸋ of type OTHER_PUNCTUATION */
    char RAISED_SQUARE = '\u2E0B';
    /** ⸌ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_RAISED_OMISSION_BRACKET = '\u2E0C';
    /** ⸍ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_RAISED_OMISSION_BRACKET = '\u2E0D';
    /** ⸎ of type OTHER_PUNCTUATION */
    char EDITORIAL_CORONIS = '\u2E0E';
    /** ⸏ of type OTHER_PUNCTUATION */
    char PARAGRAPHOS = '\u2E0F';
    /** ⸐ of type OTHER_PUNCTUATION */
    char FORKED_PARAGRAPHOS = '\u2E10';
    /** ⸑ of type OTHER_PUNCTUATION */
    char REVERSED_FORKED_PARAGRAPHOS = '\u2E11';
    /** ⸒ of type OTHER_PUNCTUATION */
    char HYPODIASTOLE = '\u2E12';
    /** ⸓ of type OTHER_PUNCTUATION */
    char DOTTED_OBELOS = '\u2E13';
    /** ⸔ of type OTHER_PUNCTUATION */
    char DOWNWARDS_ANCORA = '\u2E14';
    /** ⸕ of type OTHER_PUNCTUATION */
    char UPWARDS_ANCORA = '\u2E15';
    /** ⸖ of type OTHER_PUNCTUATION */
    char DOTTED_RIGHT_POINTING_ANGLE = '\u2E16';
    /** ⸗ of type DASH_PUNCTUATION */
    char DOUBLE_OBLIQUE_HYPHEN = '\u2E17';
    /** ⸘ of type OTHER_PUNCTUATION */
    char INVERTED_INTERROBANG = '\u2E18';
    /** ⸙ of type OTHER_PUNCTUATION */
    char PALM_BRANCH = '\u2E19';
    /** ⸚ of type DASH_PUNCTUATION */
    char HYPHEN_WITH_DIAERESIS = '\u2E1A';
    /** ⸛ of type OTHER_PUNCTUATION */
    char TILDE_WITH_RING_ABOVE = '\u2E1B';
    /** ⸜ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_LOW_PARAPHRASE_BRACKET = '\u2E1C';
    /** ⸝ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_LOW_PARAPHRASE_BRACKET = '\u2E1D';
    /** ⸞ of type OTHER_PUNCTUATION */
    char TILDE_WITH_DOT_ABOVE = '\u2E1E';
    /** ⸟ of type OTHER_PUNCTUATION */
    char TILDE_WITH_DOT_BELOW = '\u2E1F';
    /** ⸠ of type INITIAL_QUOTE_PUNCTUATION */
    char LEFT_VERTICAL_BAR_WITH_QUILL = '\u2E20';
    /** ⸡ of type FINAL_QUOTE_PUNCTUATION */
    char RIGHT_VERTICAL_BAR_WITH_QUILL = '\u2E21';
    /** ⸢ of type START_PUNCTUATION */
    char TOP_LEFT_HALF_BRACKET = '\u2E22';
    /** ⸣ of type END_PUNCTUATION */
    char TOP_RIGHT_HALF_BRACKET = '\u2E23';
    /** ⸤ of type START_PUNCTUATION */
    char BOTTOM_LEFT_HALF_BRACKET = '\u2E24';
    /** ⸥ of type END_PUNCTUATION */
    char BOTTOM_RIGHT_HALF_BRACKET = '\u2E25';
    /** ⸦ of type START_PUNCTUATION */
    char LEFT_SIDEWAYS_U_BRACKET = '\u2E26';
    /** ⸧ of type END_PUNCTUATION */
    char RIGHT_SIDEWAYS_U_BRACKET = '\u2E27';
    /** ⸨ of type START_PUNCTUATION */
    char LEFT_DOUBLE_PARENTHESIS = '\u2E28';
    /** ⸩ of type END_PUNCTUATION */
    char RIGHT_DOUBLE_PARENTHESIS = '\u2E29';
    /** ⸪ of type OTHER_PUNCTUATION */
    char TWO_DOTS_OVER_ONE_DOT_PUNCTUATION = '\u2E2A';
    /** ⸫ of type OTHER_PUNCTUATION */
    char ONE_DOT_OVER_TWO_DOTS_PUNCTUATION = '\u2E2B';
    /** ⸬ of type OTHER_PUNCTUATION */
    char SQUARED_FOUR_DOT_PUNCTUATION = '\u2E2C';
    /** ⸭ of type OTHER_PUNCTUATION */
    char FIVE_DOT_MARK = '\u2E2D';
    /** ⸮ of type OTHER_PUNCTUATION */
    char REVERSED_QUESTION_MARK = '\u2E2E';
    /** ⸯ of type MODIFIER_LETTER */
    char VERTICAL_TILDE = '\u2E2F';
    /** ⸰ of type OTHER_PUNCTUATION */
    char RING_POINT = '\u2E30';
    /** ⸱ of type OTHER_PUNCTUATION */
    char WORD_SEPARATOR_MIDDLE_DOT = '\u2E31';
    /** ⸲ of type OTHER_PUNCTUATION */
    char TURNED_COMMA = '\u2E32';
    /** ⸳ of type OTHER_PUNCTUATION */
    char RAISED_DOT = '\u2E33';
    /** ⸴ of type OTHER_PUNCTUATION */
    char RAISED_COMMA = '\u2E34';
    /** ⸵ of type OTHER_PUNCTUATION */
    char TURNED_SEMICOLON = '\u2E35';
    /** ⸶ of type OTHER_PUNCTUATION */
    char DAGGER_WITH_LEFT_GUARD = '\u2E36';
    /** ⸷ of type OTHER_PUNCTUATION */
    char DAGGER_WITH_RIGHT_GUARD = '\u2E37';
    /** ⸸ of type OTHER_PUNCTUATION */
    char TURNED_DAGGER = '\u2E38';
    /** ⸹ of type OTHER_PUNCTUATION */
    char TOP_HALF_SECTION_SIGN = '\u2E39';
    /** ⸺ of type DASH_PUNCTUATION */
    char TWO_EM_DASH = '\u2E3A';
    /** ⸻ of type DASH_PUNCTUATION */
    char THREE_EM_DASH = '\u2E3B';
    /** ⼀ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ONE = '\u2F00';
    /** ⼁ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LINE = '\u2F01';
    /** ⼂ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOT = '\u2F02';
    /** ⼃ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SLASH = '\u2F03';
    /** ⼄ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SECOND = '\u2F04';
    /** ⼅ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HOOK = '\u2F05';
    /** ⼆ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TWO = '\u2F06';
    /** ⼇ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LID = '\u2F07';
    /** ⼈ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MAN = '\u2F08';
    /** ⼉ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LEGS = '\u2F09';
    /** ⼊ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ENTER = '\u2F0A';
    /** ⼋ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EIGHT = '\u2F0B';
    /** ⼌ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOWN_BOX = '\u2F0C';
    /** ⼍ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_COVER = '\u2F0D';
    /** ⼎ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ICE = '\u2F0E';
    /** ⼏ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TABLE = '\u2F0F';
    /** ⼐ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_OPEN_BOX = '\u2F10';
    /** ⼑ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_KNIFE = '\u2F11';
    /** ⼒ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_POWER = '\u2F12';
    /** ⼓ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WRAP = '\u2F13';
    /** ⼔ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SPOON = '\u2F14';
    /** ⼕ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RIGHT_OPEN_BOX = '\u2F15';
    /** ⼖ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HIDING_ENCLOSURE = '\u2F16';
    /** ⼗ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TEN = '\u2F17';
    /** ⼘ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DIVINATION = '\u2F18';
    /** ⼙ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SEAL = '\u2F19';
    /** ⼚ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CLIFF = '\u2F1A';
    /** ⼛ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_PRIVATE = '\u2F1B';
    /** ⼜ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_AGAIN = '\u2F1C';
    /** ⼝ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MOUTH = '\u2F1D';
    /** ⼞ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ENCLOSURE = '\u2F1E';
    /** ⼟ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EARTH = '\u2F1F';
    /** ⼠ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SCHOLAR = '\u2F20';
    /** ⼡ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GO = '\u2F21';
    /** ⼢ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GO_SLOWLY = '\u2F22';
    /** ⼣ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EVENING = '\u2F23';
    /** ⼤ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BIG = '\u2F24';
    /** ⼥ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WOMAN = '\u2F25';
    /** ⼦ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CHILD = '\u2F26';
    /** ⼧ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ROOF = '\u2F27';
    /** ⼨ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_INCH = '\u2F28';
    /** ⼩ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SMALL = '\u2F29';
    /** ⼪ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LAME = '\u2F2A';
    /** ⼫ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CORPSE = '\u2F2B';
    /** ⼬ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SPROUT = '\u2F2C';
    /** ⼭ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MOUNTAIN = '\u2F2D';
    /** ⼮ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RIVER = '\u2F2E';
    /** ⼯ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WORK = '\u2F2F';
    /** ⼰ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ONESELF = '\u2F30';
    /** ⼱ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TURBAN = '\u2F31';
    /** ⼲ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DRY = '\u2F32';
    /** ⼳ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SHORT_THREAD = '\u2F33';
    /** ⼴ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOTTED_CLIFF = '\u2F34';
    /** ⼵ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LONG_STRIDE = '\u2F35';
    /** ⼶ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TWO_HANDS = '\u2F36';
    /** ⼷ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SHOOT = '\u2F37';
    /** ⼸ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BOW = '\u2F38';
    /** ⼹ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SNOUT = '\u2F39';
    /** ⼺ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BRISTLE = '\u2F3A';
    /** ⼻ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_STEP = '\u2F3B';
    /** ⼼ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HEART = '\u2F3C';
    /** ⼽ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HALBERD = '\u2F3D';
    /** ⼾ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOOR = '\u2F3E';
    /** ⼿ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HAND = '\u2F3F';
    /** ⽀ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BRANCH = '\u2F40';
    /** ⽁ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RAP = '\u2F41';
    /** ⽂ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SCRIPT = '\u2F42';
    /** ⽃ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DIPPER = '\u2F43';
    /** ⽄ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_AXE = '\u2F44';
    /** ⽅ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SQUARE = '\u2F45';
    /** ⽆ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_NOT = '\u2F46';
    /** ⽇ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SUN = '\u2F47';
    /** ⽈ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SAY = '\u2F48';
    /** ⽉ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MOON = '\u2F49';
    /** ⽊ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TREE = '\u2F4A';
    /** ⽋ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LACK = '\u2F4B';
    /** ⽌ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_STOP = '\u2F4C';
    /** ⽍ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DEATH = '\u2F4D';
    /** ⽎ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WEAPON = '\u2F4E';
    /** ⽏ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DO_NOT = '\u2F4F';
    /** ⽐ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_COMPARE = '\u2F50';
    /** ⽑ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FUR = '\u2F51';
    /** ⽒ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CLAN = '\u2F52';
    /** ⽓ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_STEAM = '\u2F53';
    /** ⽔ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WATER = '\u2F54';
    /** ⽕ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FIRE = '\u2F55';
    /** ⽖ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CLAW = '\u2F56';
    /** ⽗ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FATHER = '\u2F57';
    /** ⽘ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOUBLE_X = '\u2F58';
    /** ⽙ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HALF_TREE_TRUNK = '\u2F59';
    /** ⽚ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SLICE = '\u2F5A';
    /** ⽛ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FANG = '\u2F5B';
    /** ⽜ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_COW = '\u2F5C';
    /** ⽝ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOG = '\u2F5D';
    /** ⽞ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_PROFOUND = '\u2F5E';
    /** ⽟ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_JADE = '\u2F5F';
    /** ⽠ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MELON = '\u2F60';
    /** ⽡ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TILE = '\u2F61';
    /** ⽢ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SWEET = '\u2F62';
    /** ⽣ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LIFE = '\u2F63';
    /** ⽤ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_USE = '\u2F64';
    /** ⽥ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FIELD = '\u2F65';
    /** ⽦ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BOLT_OF_CLOTH = '\u2F66';
    /** ⽧ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SICKNESS = '\u2F67';
    /** ⽨ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DOTTED_TENT = '\u2F68';
    /** ⽩ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WHITE = '\u2F69';
    /** ⽪ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SKIN = '\u2F6A';
    /** ⽫ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DISH = '\u2F6B';
    /** ⽬ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EYE = '\u2F6C';
    /** ⽭ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SPEAR = '\u2F6D';
    /** ⽮ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ARROW = '\u2F6E';
    /** ⽯ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_STONE = '\u2F6F';
    /** ⽰ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SPIRIT = '\u2F70';
    /** ⽱ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TRACK = '\u2F71';
    /** ⽲ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GRAIN = '\u2F72';
    /** ⽳ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CAVE = '\u2F73';
    /** ⽴ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_STAND = '\u2F74';
    /** ⽵ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BAMBOO = '\u2F75';
    /** ⽶ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RICE = '\u2F76';
    /** ⽷ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SILK = '\u2F77';
    /** ⽸ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_JAR = '\u2F78';
    /** ⽹ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_NET = '\u2F79';
    /** ⽺ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SHEEP = '\u2F7A';
    /** ⽻ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FEATHER = '\u2F7B';
    /** ⽼ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_OLD = '\u2F7C';
    /** ⽽ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_AND = '\u2F7D';
    /** ⽾ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_PLOW = '\u2F7E';
    /** ⽿ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EAR = '\u2F7F';
    /** ⾀ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BRUSH = '\u2F80';
    /** ⾁ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MEAT = '\u2F81';
    /** ⾂ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MINISTER = '\u2F82';
    /** ⾃ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SELF = '\u2F83';
    /** ⾄ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_ARRIVE = '\u2F84';
    /** ⾅ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MORTAR = '\u2F85';
    /** ⾆ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TONGUE = '\u2F86';
    /** ⾇ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_OPPOSE = '\u2F87';
    /** ⾈ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BOAT = '\u2F88';
    /** ⾉ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_STOPPING = '\u2F89';
    /** ⾊ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_COLOR = '\u2F8A';
    /** ⾋ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GRASS = '\u2F8B';
    /** ⾌ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TIGER = '\u2F8C';
    /** ⾍ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_INSECT = '\u2F8D';
    /** ⾎ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BLOOD = '\u2F8E';
    /** ⾏ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WALK_ENCLOSURE = '\u2F8F';
    /** ⾐ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CLOTHES = '\u2F90';
    /** ⾑ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WEST = '\u2F91';
    /** ⾒ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SEE = '\u2F92';
    /** ⾓ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HORN = '\u2F93';
    /** ⾔ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SPEECH = '\u2F94';
    /** ⾕ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_VALLEY = '\u2F95';
    /** ⾖ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BEAN = '\u2F96';
    /** ⾗ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_PIG = '\u2F97';
    /** ⾘ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BADGER = '\u2F98';
    /** ⾙ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SHELL = '\u2F99';
    /** ⾚ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RED = '\u2F9A';
    /** ⾛ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RUN = '\u2F9B';
    /** ⾜ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FOOT = '\u2F9C';
    /** ⾝ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BODY = '\u2F9D';
    /** ⾞ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CART = '\u2F9E';
    /** ⾟ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BITTER = '\u2F9F';
    /** ⾠ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MORNING = '\u2FA0';
    /** ⾡ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WALK = '\u2FA1';
    /** ⾢ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CITY = '\u2FA2';
    /** ⾣ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WINE = '\u2FA3';
    /** ⾤ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DISTINGUISH = '\u2FA4';
    /** ⾥ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_VILLAGE = '\u2FA5';
    /** ⾦ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GOLD = '\u2FA6';
    /** ⾧ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LONG = '\u2FA7';
    /** ⾨ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GATE = '\u2FA8';
    /** ⾩ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MOUND = '\u2FA9';
    /** ⾪ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SLAVE = '\u2FAA';
    /** ⾫ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SHORT_TAILED_BIRD = '\u2FAB';
    /** ⾬ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RAIN = '\u2FAC';
    /** ⾭ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BLUE = '\u2FAD';
    /** ⾮ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WRONG = '\u2FAE';
    /** ⾯ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FACE = '\u2FAF';
    /** ⾰ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LEATHER = '\u2FB0';
    /** ⾱ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TANNED_LEATHER = '\u2FB1';
    /** ⾲ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LEEK = '\u2FB2';
    /** ⾳ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SOUND = '\u2FB3';
    /** ⾴ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_LEAF = '\u2FB4';
    /** ⾵ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WIND = '\u2FB5';
    /** ⾶ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FLY = '\u2FB6';
    /** ⾷ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EAT = '\u2FB7';
    /** ⾸ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HEAD = '\u2FB8';
    /** ⾹ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FRAGRANT = '\u2FB9';
    /** ⾺ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HORSE = '\u2FBA';
    /** ⾻ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BONE = '\u2FBB';
    /** ⾼ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TALL = '\u2FBC';
    /** ⾽ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HAIR = '\u2FBD';
    /** ⾾ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FIGHT = '\u2FBE';
    /** ⾿ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SACRIFICIAL_WINE = '\u2FBF';
    /** ⿀ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_CAULDRON = '\u2FC0';
    /** ⿁ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_GHOST = '\u2FC1';
    /** ⿂ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FISH = '\u2FC2';
    /** ⿃ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BIRD = '\u2FC3';
    /** ⿄ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_SALT = '\u2FC4';
    /** ⿅ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DEER = '\u2FC5';
    /** ⿆ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_WHEAT = '\u2FC6';
    /** ⿇ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_HEMP = '\u2FC7';
    /** ⿈ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_YELLOW = '\u2FC8';
    /** ⿉ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_MILLET = '\u2FC9';
    /** ⿊ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_BLACK = '\u2FCA';
    /** ⿋ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EMBROIDERY = '\u2FCB';
    /** ⿌ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FROG = '\u2FCC';
    /** ⿍ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TRIPOD = '\u2FCD';
    /** ⿎ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DRUM = '\u2FCE';
    /** ⿏ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_RAT = '\u2FCF';
    /** ⿐ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_NOSE = '\u2FD0';
    /** ⿑ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_EVEN = '\u2FD1';
    /** ⿒ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TOOTH = '\u2FD2';
    /** ⿓ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_DRAGON = '\u2FD3';
    /** ⿔ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_TURTLE = '\u2FD4';
    /** ⿕ of type OTHER_SYMBOL */
    char KANGXI_RADICAL_FLUTE = '\u2FD5';
    /** ⿰ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_LEFT_TO_RIGHT = '\u2FF0';
    /** ⿱ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_ABOVE_TO_BELOW = '\u2FF1';
    /** ⿲ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_LEFT_TO_MIDDLE_AND_RIGHT = '\u2FF2';
    /** ⿳ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_ABOVE_TO_MIDDLE_AND_BELOW = '\u2FF3';
    /** ⿴ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_FULL_SURROUND = '\u2FF4';
    /** ⿵ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_SURROUND_FROM_ABOVE = '\u2FF5';
    /** ⿶ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_SURROUND_FROM_BELOW = '\u2FF6';
    /** ⿷ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_SURROUND_FROM_LEFT = '\u2FF7';
    /** ⿸ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_SURROUND_FROM_UPPER_LEFT = '\u2FF8';
    /** ⿹ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_SURROUND_FROM_UPPER_RIGHT = '\u2FF9';
    /** ⿺ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_SURROUND_FROM_LOWER_LEFT = '\u2FFA';
    /** ⿻ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_DESCRIPTION_CHARACTER_OVERLAID = '\u2FFB';
    /** 　 of type SPACE_SEPARATOR */
    char IDEOGRAPHIC_SPACE = '\u3000';
    /** 、 of type OTHER_PUNCTUATION */
    char IDEOGRAPHIC_COMMA = '\u3001';
    /** 。 of type OTHER_PUNCTUATION */
    char IDEOGRAPHIC_FULL_STOP = '\u3002';
    /** 〃 of type OTHER_PUNCTUATION */
    char DITTO_MARK = '\u3003';
    /** 〄 of type OTHER_SYMBOL */
    char JAPANESE_INDUSTRIAL_STANDARD_SYMBOL = '\u3004';
    /** 々 of type MODIFIER_LETTER */
    char IDEOGRAPHIC_ITERATION_MARK = '\u3005';
    /** 〆 of type OTHER_LETTER */
    char IDEOGRAPHIC_CLOSING_MARK = '\u3006';
    /** 〇 of type LETTER_NUMBER */
    char IDEOGRAPHIC_NUMBER_ZERO = '\u3007';
    /** 〈 of type START_PUNCTUATION */
    char LEFT_ANGLE_BRACKET = '\u3008';
    /** 〉 of type END_PUNCTUATION */
    char RIGHT_ANGLE_BRACKET = '\u3009';
    /** 《 of type START_PUNCTUATION */
    char LEFT_DOUBLE_ANGLE_BRACKET = '\u300A';
    /** 》 of type END_PUNCTUATION */
    char RIGHT_DOUBLE_ANGLE_BRACKET = '\u300B';
    /** 「 of type START_PUNCTUATION */
    char LEFT_CORNER_BRACKET = '\u300C';
    /** 」 of type END_PUNCTUATION */
    char RIGHT_CORNER_BRACKET = '\u300D';
    /** 『 of type START_PUNCTUATION */
    char LEFT_WHITE_CORNER_BRACKET = '\u300E';
    /** 』 of type END_PUNCTUATION */
    char RIGHT_WHITE_CORNER_BRACKET = '\u300F';
    /** 【 of type START_PUNCTUATION */
    char LEFT_BLACK_LENTICULAR_BRACKET = '\u3010';
    /** 】 of type END_PUNCTUATION */
    char RIGHT_BLACK_LENTICULAR_BRACKET = '\u3011';
    /** 〒 of type OTHER_SYMBOL */
    char POSTAL_MARK = '\u3012';
    /** 〓 of type OTHER_SYMBOL */
    char GETA_MARK = '\u3013';
    /** 〔 of type START_PUNCTUATION */
    char LEFT_TORTOISE_SHELL_BRACKET = '\u3014';
    /** 〕 of type END_PUNCTUATION */
    char RIGHT_TORTOISE_SHELL_BRACKET = '\u3015';
    /** 〖 of type START_PUNCTUATION */
    char LEFT_WHITE_LENTICULAR_BRACKET = '\u3016';
    /** 〗 of type END_PUNCTUATION */
    char RIGHT_WHITE_LENTICULAR_BRACKET = '\u3017';
    /** 〘 of type START_PUNCTUATION */
    char LEFT_WHITE_TORTOISE_SHELL_BRACKET = '\u3018';
    /** 〙 of type END_PUNCTUATION */
    char RIGHT_WHITE_TORTOISE_SHELL_BRACKET = '\u3019';
    /** 〚 of type START_PUNCTUATION */
    char LEFT_WHITE_SQUARE_BRACKET = '\u301A';
    /** 〛 of type END_PUNCTUATION */
    char RIGHT_WHITE_SQUARE_BRACKET = '\u301B';
    /** 〜 of type DASH_PUNCTUATION */
    char WAVE_DASH = '\u301C';
    /** 〝 of type START_PUNCTUATION */
    char REVERSED_DOUBLE_PRIME_QUOTATION_MARK = '\u301D';
    /** 〞 of type END_PUNCTUATION */
    char DOUBLE_PRIME_QUOTATION_MARK = '\u301E';
    /** 〟 of type END_PUNCTUATION */
    char LOW_DOUBLE_PRIME_QUOTATION_MARK = '\u301F';
    /** 〠 of type OTHER_SYMBOL */
    char POSTAL_MARK_FACE = '\u3020';
    /** 〡 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_ONE = '\u3021';
    /** 〢 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_TWO = '\u3022';
    /** 〣 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_THREE = '\u3023';
    /** 〤 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_FOUR = '\u3024';
    /** 〥 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_FIVE = '\u3025';
    /** 〦 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_SIX = '\u3026';
    /** 〧 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_SEVEN = '\u3027';
    /** 〨 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_EIGHT = '\u3028';
    /** 〩 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_NINE = '\u3029';
    /** 〪 of type NON_SPACING_MARK */
    char IDEOGRAPHIC_LEVEL_TONE_MARK = '\u302A';
    /** 〫 of type NON_SPACING_MARK */
    char IDEOGRAPHIC_RISING_TONE_MARK = '\u302B';
    /** 〬 of type NON_SPACING_MARK */
    char IDEOGRAPHIC_DEPARTING_TONE_MARK = '\u302C';
    /** 〭 of type NON_SPACING_MARK */
    char IDEOGRAPHIC_ENTERING_TONE_MARK = '\u302D';
    /** 〰 of type DASH_PUNCTUATION */
    char WAVY_DASH = '\u3030';
    /** 〱 of type MODIFIER_LETTER */
    char VERTICAL_KANA_REPEAT_MARK = '\u3031';
    /** 〲 of type MODIFIER_LETTER */
    char VERTICAL_KANA_REPEAT_WITH_VOICED_SOUND_MARK = '\u3032';
    /** 〳 of type MODIFIER_LETTER */
    char VERTICAL_KANA_REPEAT_MARK_UPPER_HALF = '\u3033';
    /** 〴 of type MODIFIER_LETTER */
    char VERTICAL_KANA_REPEAT_WITH_VOICED_SOUND_MARK_UPPER_HALF = '\u3034';
    /** 〵 of type MODIFIER_LETTER */
    char VERTICAL_KANA_REPEAT_MARK_LOWER_HALF = '\u3035';
    /** 〶 of type OTHER_SYMBOL */
    char CIRCLED_POSTAL_MARK = '\u3036';
    /** 〷 of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_LINE_FEED_SEPARATOR_SYMBOL = '\u3037';
    /** 〸 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_TEN = '\u3038';
    /** 〹 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_TWENTY = '\u3039';
    /** 〺 of type LETTER_NUMBER */
    char HANGZHOU_NUMERAL_THIRTY = '\u303A';
    /** 〻 of type MODIFIER_LETTER */
    char VERTICAL_IDEOGRAPHIC_ITERATION_MARK = '\u303B';
    /** 〼 of type OTHER_LETTER */
    char MASU_MARK = '\u303C';
    /** 〽 of type OTHER_PUNCTUATION */
    char PART_ALTERNATION_MARK = '\u303D';
    /** 〾 of type OTHER_SYMBOL */
    char IDEOGRAPHIC_VARIATION_INDICATOR = '\u303E';
    /** 〿 of type OTHER_SYMBOL */
    char IDEOGRAPHIC_HALF_FILL_SPACE = '\u303F';
    /** ぁ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_A = '\u3041';
    /** あ of type OTHER_LETTER */
    char HIRAGANA_LETTER_A = '\u3042';
    /** ぃ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_I = '\u3043';
    /** い of type OTHER_LETTER */
    char HIRAGANA_LETTER_I = '\u3044';
    /** ぅ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_U = '\u3045';
    /** う of type OTHER_LETTER */
    char HIRAGANA_LETTER_U = '\u3046';
    /** ぇ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_E = '\u3047';
    /** え of type OTHER_LETTER */
    char HIRAGANA_LETTER_E = '\u3048';
    /** ぉ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_O = '\u3049';
    /** お of type OTHER_LETTER */
    char HIRAGANA_LETTER_O = '\u304A';
    /** か of type OTHER_LETTER */
    char HIRAGANA_LETTER_KA = '\u304B';
    /** が of type OTHER_LETTER */
    char HIRAGANA_LETTER_GA = '\u304C';
    /** き of type OTHER_LETTER */
    char HIRAGANA_LETTER_KI = '\u304D';
    /** ぎ of type OTHER_LETTER */
    char HIRAGANA_LETTER_GI = '\u304E';
    /** く of type OTHER_LETTER */
    char HIRAGANA_LETTER_KU = '\u304F';
    /** ぐ of type OTHER_LETTER */
    char HIRAGANA_LETTER_GU = '\u3050';
    /** け of type OTHER_LETTER */
    char HIRAGANA_LETTER_KE = '\u3051';
    /** げ of type OTHER_LETTER */
    char HIRAGANA_LETTER_GE = '\u3052';
    /** こ of type OTHER_LETTER */
    char HIRAGANA_LETTER_KO = '\u3053';
    /** ご of type OTHER_LETTER */
    char HIRAGANA_LETTER_GO = '\u3054';
    /** さ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SA = '\u3055';
    /** ざ of type OTHER_LETTER */
    char HIRAGANA_LETTER_ZA = '\u3056';
    /** し of type OTHER_LETTER */
    char HIRAGANA_LETTER_SI = '\u3057';
    /** じ of type OTHER_LETTER */
    char HIRAGANA_LETTER_ZI = '\u3058';
    /** す of type OTHER_LETTER */
    char HIRAGANA_LETTER_SU = '\u3059';
    /** ず of type OTHER_LETTER */
    char HIRAGANA_LETTER_ZU = '\u305A';
    /** せ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SE = '\u305B';
    /** ぜ of type OTHER_LETTER */
    char HIRAGANA_LETTER_ZE = '\u305C';
    /** そ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SO = '\u305D';
    /** ぞ of type OTHER_LETTER */
    char HIRAGANA_LETTER_ZO = '\u305E';
    /** た of type OTHER_LETTER */
    char HIRAGANA_LETTER_TA = '\u305F';
    /** だ of type OTHER_LETTER */
    char HIRAGANA_LETTER_DA = '\u3060';
    /** ち of type OTHER_LETTER */
    char HIRAGANA_LETTER_TI = '\u3061';
    /** ぢ of type OTHER_LETTER */
    char HIRAGANA_LETTER_DI = '\u3062';
    /** っ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_TU = '\u3063';
    /** つ of type OTHER_LETTER */
    char HIRAGANA_LETTER_TU = '\u3064';
    /** づ of type OTHER_LETTER */
    char HIRAGANA_LETTER_DU = '\u3065';
    /** て of type OTHER_LETTER */
    char HIRAGANA_LETTER_TE = '\u3066';
    /** で of type OTHER_LETTER */
    char HIRAGANA_LETTER_DE = '\u3067';
    /** と of type OTHER_LETTER */
    char HIRAGANA_LETTER_TO = '\u3068';
    /** ど of type OTHER_LETTER */
    char HIRAGANA_LETTER_DO = '\u3069';
    /** な of type OTHER_LETTER */
    char HIRAGANA_LETTER_NA = '\u306A';
    /** に of type OTHER_LETTER */
    char HIRAGANA_LETTER_NI = '\u306B';
    /** ぬ of type OTHER_LETTER */
    char HIRAGANA_LETTER_NU = '\u306C';
    /** ね of type OTHER_LETTER */
    char HIRAGANA_LETTER_NE = '\u306D';
    /** の of type OTHER_LETTER */
    char HIRAGANA_LETTER_NO = '\u306E';
    /** は of type OTHER_LETTER */
    char HIRAGANA_LETTER_HA = '\u306F';
    /** ば of type OTHER_LETTER */
    char HIRAGANA_LETTER_BA = '\u3070';
    /** ぱ of type OTHER_LETTER */
    char HIRAGANA_LETTER_PA = '\u3071';
    /** ひ of type OTHER_LETTER */
    char HIRAGANA_LETTER_HI = '\u3072';
    /** び of type OTHER_LETTER */
    char HIRAGANA_LETTER_BI = '\u3073';
    /** ぴ of type OTHER_LETTER */
    char HIRAGANA_LETTER_PI = '\u3074';
    /** ふ of type OTHER_LETTER */
    char HIRAGANA_LETTER_HU = '\u3075';
    /** ぶ of type OTHER_LETTER */
    char HIRAGANA_LETTER_BU = '\u3076';
    /** ぷ of type OTHER_LETTER */
    char HIRAGANA_LETTER_PU = '\u3077';
    /** へ of type OTHER_LETTER */
    char HIRAGANA_LETTER_HE = '\u3078';
    /** べ of type OTHER_LETTER */
    char HIRAGANA_LETTER_BE = '\u3079';
    /** ぺ of type OTHER_LETTER */
    char HIRAGANA_LETTER_PE = '\u307A';
    /** ほ of type OTHER_LETTER */
    char HIRAGANA_LETTER_HO = '\u307B';
    /** ぼ of type OTHER_LETTER */
    char HIRAGANA_LETTER_BO = '\u307C';
    /** ぽ of type OTHER_LETTER */
    char HIRAGANA_LETTER_PO = '\u307D';
    /** ま of type OTHER_LETTER */
    char HIRAGANA_LETTER_MA = '\u307E';
    /** み of type OTHER_LETTER */
    char HIRAGANA_LETTER_MI = '\u307F';
    /** む of type OTHER_LETTER */
    char HIRAGANA_LETTER_MU = '\u3080';
    /** め of type OTHER_LETTER */
    char HIRAGANA_LETTER_ME = '\u3081';
    /** も of type OTHER_LETTER */
    char HIRAGANA_LETTER_MO = '\u3082';
    /** ゃ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_YA = '\u3083';
    /** や of type OTHER_LETTER */
    char HIRAGANA_LETTER_YA = '\u3084';
    /** ゅ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_YU = '\u3085';
    /** ゆ of type OTHER_LETTER */
    char HIRAGANA_LETTER_YU = '\u3086';
    /** ょ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_YO = '\u3087';
    /** よ of type OTHER_LETTER */
    char HIRAGANA_LETTER_YO = '\u3088';
    /** ら of type OTHER_LETTER */
    char HIRAGANA_LETTER_RA = '\u3089';
    /** り of type OTHER_LETTER */
    char HIRAGANA_LETTER_RI = '\u308A';
    /** る of type OTHER_LETTER */
    char HIRAGANA_LETTER_RU = '\u308B';
    /** れ of type OTHER_LETTER */
    char HIRAGANA_LETTER_RE = '\u308C';
    /** ろ of type OTHER_LETTER */
    char HIRAGANA_LETTER_RO = '\u308D';
    /** ゎ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_WA = '\u308E';
    /** わ of type OTHER_LETTER */
    char HIRAGANA_LETTER_WA = '\u308F';
    /** ゐ of type OTHER_LETTER */
    char HIRAGANA_LETTER_WI = '\u3090';
    /** ゑ of type OTHER_LETTER */
    char HIRAGANA_LETTER_WE = '\u3091';
    /** を of type OTHER_LETTER */
    char HIRAGANA_LETTER_WO = '\u3092';
    /** ん of type OTHER_LETTER */
    char HIRAGANA_LETTER_N = '\u3093';
    /** ゔ of type OTHER_LETTER */
    char HIRAGANA_LETTER_VU = '\u3094';
    /** ゕ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_KA = '\u3095';
    /** ゖ of type OTHER_LETTER */
    char HIRAGANA_LETTER_SMALL_KE = '\u3096';
    /** ゝ of type MODIFIER_LETTER */
    char HIRAGANA_ITERATION_MARK = '\u309D';
    /** ゞ of type MODIFIER_LETTER */
    char HIRAGANA_VOICED_ITERATION_MARK = '\u309E';
    /** ゟ of type OTHER_LETTER */
    char HIRAGANA_DIGRAPH_YORI = '\u309F';
    /** ㆐ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_LINKING_MARK = '\u3190';
    /** ㆑ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_REVERSE_MARK = '\u3191';
    /** ㆒ of type OTHER_NUMBER */
    char IDEOGRAPHIC_ANNOTATION_ONE_MARK = '\u3192';
    /** ㆓ of type OTHER_NUMBER */
    char IDEOGRAPHIC_ANNOTATION_TWO_MARK = '\u3193';
    /** ㆔ of type OTHER_NUMBER */
    char IDEOGRAPHIC_ANNOTATION_THREE_MARK = '\u3194';
    /** ㆕ of type OTHER_NUMBER */
    char IDEOGRAPHIC_ANNOTATION_FOUR_MARK = '\u3195';
    /** ㆖ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_TOP_MARK = '\u3196';
    /** ㆗ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_MIDDLE_MARK = '\u3197';
    /** ㆘ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_BOTTOM_MARK = '\u3198';
    /** ㆙ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_FIRST_MARK = '\u3199';
    /** ㆚ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_SECOND_MARK = '\u319A';
    /** ㆛ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_THIRD_MARK = '\u319B';
    /** ㆜ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_FOURTH_MARK = '\u319C';
    /** ㆝ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_HEAVEN_MARK = '\u319D';
    /** ㆞ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_EARTH_MARK = '\u319E';
    /** ㆟ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_ANNOTATION_MAN_MARK = '\u319F';
    /** ㈀ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_KIYEOK = '\u3200';
    /** ㈁ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_NIEUN = '\u3201';
    /** ㈂ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_TIKEUT = '\u3202';
    /** ㈃ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_RIEUL = '\u3203';
    /** ㈄ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_MIEUM = '\u3204';
    /** ㈅ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_PIEUP = '\u3205';
    /** ㈆ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_SIOS = '\u3206';
    /** ㈇ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_IEUNG = '\u3207';
    /** ㈈ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_CIEUC = '\u3208';
    /** ㈉ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_CHIEUCH = '\u3209';
    /** ㈊ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_KHIEUKH = '\u320A';
    /** ㈋ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_THIEUTH = '\u320B';
    /** ㈌ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_PHIEUPH = '\u320C';
    /** ㈍ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_HIEUH = '\u320D';
    /** ㈎ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_KIYEOK_A = '\u320E';
    /** ㈏ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_NIEUN_A = '\u320F';
    /** ㈐ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_TIKEUT_A = '\u3210';
    /** ㈑ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_RIEUL_A = '\u3211';
    /** ㈒ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_MIEUM_A = '\u3212';
    /** ㈓ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_PIEUP_A = '\u3213';
    /** ㈔ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_SIOS_A = '\u3214';
    /** ㈕ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_IEUNG_A = '\u3215';
    /** ㈖ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_CIEUC_A = '\u3216';
    /** ㈗ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_CHIEUCH_A = '\u3217';
    /** ㈘ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_KHIEUKH_A = '\u3218';
    /** ㈙ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_THIEUTH_A = '\u3219';
    /** ㈚ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_PHIEUPH_A = '\u321A';
    /** ㈛ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_HIEUH_A = '\u321B';
    /** ㈜ of type OTHER_SYMBOL */
    char PARENTHESIZED_HANGUL_CIEUC_U = '\u321C';
    /** ㈝ of type OTHER_SYMBOL */
    char PARENTHESIZED_KOREAN_CHARACTER_OJEON = '\u321D';
    /** ㈞ of type OTHER_SYMBOL */
    char PARENTHESIZED_KOREAN_CHARACTER_O_HU = '\u321E';
    /** ㈠ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_ONE = '\u3220';
    /** ㈡ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_TWO = '\u3221';
    /** ㈢ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_THREE = '\u3222';
    /** ㈣ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_FOUR = '\u3223';
    /** ㈤ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_FIVE = '\u3224';
    /** ㈥ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_SIX = '\u3225';
    /** ㈦ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_SEVEN = '\u3226';
    /** ㈧ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_EIGHT = '\u3227';
    /** ㈨ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_NINE = '\u3228';
    /** ㈩ of type OTHER_NUMBER */
    char PARENTHESIZED_IDEOGRAPH_TEN = '\u3229';
    /** ㈪ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_MOON = '\u322A';
    /** ㈫ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_FIRE = '\u322B';
    /** ㈬ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_WATER = '\u322C';
    /** ㈭ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_WOOD = '\u322D';
    /** ㈮ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_METAL = '\u322E';
    /** ㈯ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_EARTH = '\u322F';
    /** ㈰ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_SUN = '\u3230';
    /** ㈱ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_STOCK = '\u3231';
    /** ㈲ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_HAVE = '\u3232';
    /** ㈳ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_SOCIETY = '\u3233';
    /** ㈴ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_NAME = '\u3234';
    /** ㈵ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_SPECIAL = '\u3235';
    /** ㈶ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_FINANCIAL = '\u3236';
    /** ㈷ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_CONGRATULATION = '\u3237';
    /** ㈸ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_LABOR = '\u3238';
    /** ㈹ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_REPRESENT = '\u3239';
    /** ㈺ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_CALL = '\u323A';
    /** ㈻ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_STUDY = '\u323B';
    /** ㈼ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_SUPERVISE = '\u323C';
    /** ㈽ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_ENTERPRISE = '\u323D';
    /** ㈾ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_RESOURCE = '\u323E';
    /** ㈿ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_ALLIANCE = '\u323F';
    /** ㉀ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_FESTIVAL = '\u3240';
    /** ㉁ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_REST = '\u3241';
    /** ㉂ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_SELF = '\u3242';
    /** ㉃ of type OTHER_SYMBOL */
    char PARENTHESIZED_IDEOGRAPH_REACH = '\u3243';
    /** ㉄ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_QUESTION = '\u3244';
    /** ㉅ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_KINDERGARTEN = '\u3245';
    /** ㉆ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SCHOOL = '\u3246';
    /** ㉇ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_KOTO = '\u3247';
    /** ㉈ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TEN_ON_BLACK_SQUARE = '\u3248';
    /** ㉉ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_ON_BLACK_SQUARE = '\u3249';
    /** ㉊ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_ON_BLACK_SQUARE = '\u324A';
    /** ㉋ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_ON_BLACK_SQUARE = '\u324B';
    /** ㉌ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FIFTY_ON_BLACK_SQUARE = '\u324C';
    /** ㉍ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_SIXTY_ON_BLACK_SQUARE = '\u324D';
    /** ㉎ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_SEVENTY_ON_BLACK_SQUARE = '\u324E';
    /** ㉏ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_EIGHTY_ON_BLACK_SQUARE = '\u324F';
    /** ㉐ of type OTHER_SYMBOL */
    char PARTNERSHIP_SIGN = '\u3250';
    /** ㉑ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_ONE = '\u3251';
    /** ㉒ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_TWO = '\u3252';
    /** ㉓ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_THREE = '\u3253';
    /** ㉔ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_FOUR = '\u3254';
    /** ㉕ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_FIVE = '\u3255';
    /** ㉖ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_SIX = '\u3256';
    /** ㉗ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_SEVEN = '\u3257';
    /** ㉘ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_EIGHT = '\u3258';
    /** ㉙ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_TWENTY_NINE = '\u3259';
    /** ㉚ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY = '\u325A';
    /** ㉛ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_ONE = '\u325B';
    /** ㉜ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_TWO = '\u325C';
    /** ㉝ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_THREE = '\u325D';
    /** ㉞ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_FOUR = '\u325E';
    /** ㉟ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_FIVE = '\u325F';
    /** ㉠ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_KIYEOK = '\u3260';
    /** ㉡ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_NIEUN = '\u3261';
    /** ㉢ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_TIKEUT = '\u3262';
    /** ㉣ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_RIEUL = '\u3263';
    /** ㉤ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_MIEUM = '\u3264';
    /** ㉥ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_PIEUP = '\u3265';
    /** ㉦ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_SIOS = '\u3266';
    /** ㉧ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_IEUNG = '\u3267';
    /** ㉨ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_CIEUC = '\u3268';
    /** ㉩ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_CHIEUCH = '\u3269';
    /** ㉪ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_KHIEUKH = '\u326A';
    /** ㉫ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_THIEUTH = '\u326B';
    /** ㉬ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_PHIEUPH = '\u326C';
    /** ㉭ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_HIEUH = '\u326D';
    /** ㉮ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_KIYEOK_A = '\u326E';
    /** ㉯ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_NIEUN_A = '\u326F';
    /** ㉰ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_TIKEUT_A = '\u3270';
    /** ㉱ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_RIEUL_A = '\u3271';
    /** ㉲ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_MIEUM_A = '\u3272';
    /** ㉳ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_PIEUP_A = '\u3273';
    /** ㉴ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_SIOS_A = '\u3274';
    /** ㉵ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_IEUNG_A = '\u3275';
    /** ㉶ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_CIEUC_A = '\u3276';
    /** ㉷ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_CHIEUCH_A = '\u3277';
    /** ㉸ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_KHIEUKH_A = '\u3278';
    /** ㉹ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_THIEUTH_A = '\u3279';
    /** ㉺ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_PHIEUPH_A = '\u327A';
    /** ㉻ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_HIEUH_A = '\u327B';
    /** ㉼ of type OTHER_SYMBOL */
    char CIRCLED_KOREAN_CHARACTER_CHAMKO = '\u327C';
    /** ㉽ of type OTHER_SYMBOL */
    char CIRCLED_KOREAN_CHARACTER_JUEUI = '\u327D';
    /** ㉾ of type OTHER_SYMBOL */
    char CIRCLED_HANGUL_IEUNG_U = '\u327E';
    /** ㉿ of type OTHER_SYMBOL */
    char KOREAN_STANDARD_SYMBOL = '\u327F';
    /** ㊀ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_ONE = '\u3280';
    /** ㊁ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_TWO = '\u3281';
    /** ㊂ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_THREE = '\u3282';
    /** ㊃ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_FOUR = '\u3283';
    /** ㊄ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_FIVE = '\u3284';
    /** ㊅ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_SIX = '\u3285';
    /** ㊆ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_SEVEN = '\u3286';
    /** ㊇ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_EIGHT = '\u3287';
    /** ㊈ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_NINE = '\u3288';
    /** ㊉ of type OTHER_NUMBER */
    char CIRCLED_IDEOGRAPH_TEN = '\u3289';
    /** ㊊ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_MOON = '\u328A';
    /** ㊋ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_FIRE = '\u328B';
    /** ㊌ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_WATER = '\u328C';
    /** ㊍ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_WOOD = '\u328D';
    /** ㊎ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_METAL = '\u328E';
    /** ㊏ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_EARTH = '\u328F';
    /** ㊐ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SUN = '\u3290';
    /** ㊑ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_STOCK = '\u3291';
    /** ㊒ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_HAVE = '\u3292';
    /** ㊓ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SOCIETY = '\u3293';
    /** ㊔ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_NAME = '\u3294';
    /** ㊕ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SPECIAL = '\u3295';
    /** ㊖ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_FINANCIAL = '\u3296';
    /** ㊗ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_CONGRATULATION = '\u3297';
    /** ㊘ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_LABOR = '\u3298';
    /** ㊙ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SECRET = '\u3299';
    /** ㊚ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_MALE = '\u329A';
    /** ㊛ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_FEMALE = '\u329B';
    /** ㊜ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SUITABLE = '\u329C';
    /** ㊝ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_EXCELLENT = '\u329D';
    /** ㊞ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_PRINT = '\u329E';
    /** ㊟ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_ATTENTION = '\u329F';
    /** ㊠ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_ITEM = '\u32A0';
    /** ㊡ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_REST = '\u32A1';
    /** ㊢ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_COPY = '\u32A2';
    /** ㊣ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_CORRECT = '\u32A3';
    /** ㊤ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_HIGH = '\u32A4';
    /** ㊥ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_CENTRE = '\u32A5';
    /** ㊦ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_LOW = '\u32A6';
    /** ㊧ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_LEFT = '\u32A7';
    /** ㊨ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_RIGHT = '\u32A8';
    /** ㊩ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_MEDICINE = '\u32A9';
    /** ㊪ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_RELIGION = '\u32AA';
    /** ㊫ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_STUDY = '\u32AB';
    /** ㊬ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_SUPERVISE = '\u32AC';
    /** ㊭ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_ENTERPRISE = '\u32AD';
    /** ㊮ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_RESOURCE = '\u32AE';
    /** ㊯ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_ALLIANCE = '\u32AF';
    /** ㊰ of type OTHER_SYMBOL */
    char CIRCLED_IDEOGRAPH_NIGHT = '\u32B0';
    /** ㊱ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_SIX = '\u32B1';
    /** ㊲ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_SEVEN = '\u32B2';
    /** ㊳ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_EIGHT = '\u32B3';
    /** ㊴ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_THIRTY_NINE = '\u32B4';
    /** ㊵ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY = '\u32B5';
    /** ㊶ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_ONE = '\u32B6';
    /** ㊷ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_TWO = '\u32B7';
    /** ㊸ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_THREE = '\u32B8';
    /** ㊹ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_FOUR = '\u32B9';
    /** ㊺ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_FIVE = '\u32BA';
    /** ㊻ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_SIX = '\u32BB';
    /** ㊼ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_SEVEN = '\u32BC';
    /** ㊽ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_EIGHT = '\u32BD';
    /** ㊾ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FORTY_NINE = '\u32BE';
    /** ㊿ of type OTHER_NUMBER */
    char CIRCLED_NUMBER_FIFTY = '\u32BF';
    /** ㋀ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_JANUARY = '\u32C0';
    /** ㋁ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_FEBRUARY = '\u32C1';
    /** ㋂ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_MARCH = '\u32C2';
    /** ㋃ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_APRIL = '\u32C3';
    /** ㋄ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_MAY = '\u32C4';
    /** ㋅ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_JUNE = '\u32C5';
    /** ㋆ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_JULY = '\u32C6';
    /** ㋇ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_AUGUST = '\u32C7';
    /** ㋈ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_SEPTEMBER = '\u32C8';
    /** ㋉ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_OCTOBER = '\u32C9';
    /** ㋊ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_NOVEMBER = '\u32CA';
    /** ㋋ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DECEMBER = '\u32CB';
    /** ㋌ of type OTHER_SYMBOL */
    char SQUARE_HG = '\u32CC';
    /** ㋍ of type OTHER_SYMBOL */
    char SQUARE_ERG = '\u32CD';
    /** ㋎ of type OTHER_SYMBOL */
    char SQUARE_EV = '\u32CE';
    /** ㋏ of type OTHER_SYMBOL */
    char LIMITED_LIABILITY_SIGN = '\u32CF';
    /** ㋐ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_A = '\u32D0';
    /** ㋑ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_I = '\u32D1';
    /** ㋒ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_U = '\u32D2';
    /** ㋓ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_E = '\u32D3';
    /** ㋔ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_O = '\u32D4';
    /** ㋕ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_KA = '\u32D5';
    /** ㋖ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_KI = '\u32D6';
    /** ㋗ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_KU = '\u32D7';
    /** ㋘ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_KE = '\u32D8';
    /** ㋙ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_KO = '\u32D9';
    /** ㋚ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_SA = '\u32DA';
    /** ㋛ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_SI = '\u32DB';
    /** ㋜ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_SU = '\u32DC';
    /** ㋝ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_SE = '\u32DD';
    /** ㋞ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_SO = '\u32DE';
    /** ㋟ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_TA = '\u32DF';
    /** ㋠ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_TI = '\u32E0';
    /** ㋡ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_TU = '\u32E1';
    /** ㋢ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_TE = '\u32E2';
    /** ㋣ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_TO = '\u32E3';
    /** ㋤ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_NA = '\u32E4';
    /** ㋥ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_NI = '\u32E5';
    /** ㋦ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_NU = '\u32E6';
    /** ㋧ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_NE = '\u32E7';
    /** ㋨ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_NO = '\u32E8';
    /** ㋩ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_HA = '\u32E9';
    /** ㋪ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_HI = '\u32EA';
    /** ㋫ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_HU = '\u32EB';
    /** ㋬ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_HE = '\u32EC';
    /** ㋭ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_HO = '\u32ED';
    /** ㋮ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_MA = '\u32EE';
    /** ㋯ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_MI = '\u32EF';
    /** ㋰ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_MU = '\u32F0';
    /** ㋱ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_ME = '\u32F1';
    /** ㋲ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_MO = '\u32F2';
    /** ㋳ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_YA = '\u32F3';
    /** ㋴ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_YU = '\u32F4';
    /** ㋵ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_YO = '\u32F5';
    /** ㋶ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_RA = '\u32F6';
    /** ㋷ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_RI = '\u32F7';
    /** ㋸ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_RU = '\u32F8';
    /** ㋹ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_RE = '\u32F9';
    /** ㋺ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_RO = '\u32FA';
    /** ㋻ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_WA = '\u32FB';
    /** ㋼ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_WI = '\u32FC';
    /** ㋽ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_WE = '\u32FD';
    /** ㋾ of type OTHER_SYMBOL */
    char CIRCLED_KATAKANA_WO = '\u32FE';
    /** ㋿ of type OTHER_SYMBOL */
    char SQUARE_ERA_NAME_REIWA = '\u32FF';
    /** ㌀ of type OTHER_SYMBOL */
    char SQUARE_APAATO = '\u3300';
    /** ㌁ of type OTHER_SYMBOL */
    char SQUARE_ARUHUA = '\u3301';
    /** ㌂ of type OTHER_SYMBOL */
    char SQUARE_ANPEA = '\u3302';
    /** ㌃ of type OTHER_SYMBOL */
    char SQUARE_AARU = '\u3303';
    /** ㌄ of type OTHER_SYMBOL */
    char SQUARE_ININGU = '\u3304';
    /** ㌅ of type OTHER_SYMBOL */
    char SQUARE_INTI = '\u3305';
    /** ㌆ of type OTHER_SYMBOL */
    char SQUARE_UON = '\u3306';
    /** ㌇ of type OTHER_SYMBOL */
    char SQUARE_ESUKUUDO = '\u3307';
    /** ㌈ of type OTHER_SYMBOL */
    char SQUARE_EEKAA = '\u3308';
    /** ㌉ of type OTHER_SYMBOL */
    char SQUARE_ONSU = '\u3309';
    /** ㌊ of type OTHER_SYMBOL */
    char SQUARE_OOMU = '\u330A';
    /** ㌋ of type OTHER_SYMBOL */
    char SQUARE_KAIRI = '\u330B';
    /** ㌌ of type OTHER_SYMBOL */
    char SQUARE_KARATTO = '\u330C';
    /** ㌍ of type OTHER_SYMBOL */
    char SQUARE_KARORII = '\u330D';
    /** ㌎ of type OTHER_SYMBOL */
    char SQUARE_GARON = '\u330E';
    /** ㌏ of type OTHER_SYMBOL */
    char SQUARE_GANMA = '\u330F';
    /** ㌐ of type OTHER_SYMBOL */
    char SQUARE_GIGA = '\u3310';
    /** ㌑ of type OTHER_SYMBOL */
    char SQUARE_GINII = '\u3311';
    /** ㌒ of type OTHER_SYMBOL */
    char SQUARE_KYURII = '\u3312';
    /** ㌓ of type OTHER_SYMBOL */
    char SQUARE_GIRUDAA = '\u3313';
    /** ㌔ of type OTHER_SYMBOL */
    char SQUARE_KIRO = '\u3314';
    /** ㌕ of type OTHER_SYMBOL */
    char SQUARE_KIROGURAMU = '\u3315';
    /** ㌖ of type OTHER_SYMBOL */
    char SQUARE_KIROMEETORU = '\u3316';
    /** ㌗ of type OTHER_SYMBOL */
    char SQUARE_KIROWATTO = '\u3317';
    /** ㌘ of type OTHER_SYMBOL */
    char SQUARE_GURAMU = '\u3318';
    /** ㌙ of type OTHER_SYMBOL */
    char SQUARE_GURAMUTON = '\u3319';
    /** ㌚ of type OTHER_SYMBOL */
    char SQUARE_KURUZEIRO = '\u331A';
    /** ㌛ of type OTHER_SYMBOL */
    char SQUARE_KUROONE = '\u331B';
    /** ㌜ of type OTHER_SYMBOL */
    char SQUARE_KEESU = '\u331C';
    /** ㌝ of type OTHER_SYMBOL */
    char SQUARE_KORUNA = '\u331D';
    /** ㌞ of type OTHER_SYMBOL */
    char SQUARE_KOOPO = '\u331E';
    /** ㌟ of type OTHER_SYMBOL */
    char SQUARE_SAIKURU = '\u331F';
    /** ㌠ of type OTHER_SYMBOL */
    char SQUARE_SANTIIMU = '\u3320';
    /** ㌡ of type OTHER_SYMBOL */
    char SQUARE_SIRINGU = '\u3321';
    /** ㌢ of type OTHER_SYMBOL */
    char SQUARE_SENTI = '\u3322';
    /** ㌣ of type OTHER_SYMBOL */
    char SQUARE_SENTO = '\u3323';
    /** ㌤ of type OTHER_SYMBOL */
    char SQUARE_DAASU = '\u3324';
    /** ㌥ of type OTHER_SYMBOL */
    char SQUARE_DESI = '\u3325';
    /** ㌦ of type OTHER_SYMBOL */
    char SQUARE_DORU = '\u3326';
    /** ㌧ of type OTHER_SYMBOL */
    char SQUARE_TON = '\u3327';
    /** ㌨ of type OTHER_SYMBOL */
    char SQUARE_NANO = '\u3328';
    /** ㌩ of type OTHER_SYMBOL */
    char SQUARE_NOTTO = '\u3329';
    /** ㌪ of type OTHER_SYMBOL */
    char SQUARE_HAITU = '\u332A';
    /** ㌫ of type OTHER_SYMBOL */
    char SQUARE_PAASENTO = '\u332B';
    /** ㌬ of type OTHER_SYMBOL */
    char SQUARE_PAATU = '\u332C';
    /** ㌭ of type OTHER_SYMBOL */
    char SQUARE_BAARERU = '\u332D';
    /** ㌮ of type OTHER_SYMBOL */
    char SQUARE_PIASUTORU = '\u332E';
    /** ㌯ of type OTHER_SYMBOL */
    char SQUARE_PIKURU = '\u332F';
    /** ㌰ of type OTHER_SYMBOL */
    char SQUARE_PIKO = '\u3330';
    /** ㌱ of type OTHER_SYMBOL */
    char SQUARE_BIRU = '\u3331';
    /** ㌲ of type OTHER_SYMBOL */
    char SQUARE_HUARADDO = '\u3332';
    /** ㌳ of type OTHER_SYMBOL */
    char SQUARE_HUIITO = '\u3333';
    /** ㌴ of type OTHER_SYMBOL */
    char SQUARE_BUSSYERU = '\u3334';
    /** ㌵ of type OTHER_SYMBOL */
    char SQUARE_HURAN = '\u3335';
    /** ㌶ of type OTHER_SYMBOL */
    char SQUARE_HEKUTAARU = '\u3336';
    /** ㌷ of type OTHER_SYMBOL */
    char SQUARE_PESO = '\u3337';
    /** ㌸ of type OTHER_SYMBOL */
    char SQUARE_PENIHI = '\u3338';
    /** ㌹ of type OTHER_SYMBOL */
    char SQUARE_HERUTU = '\u3339';
    /** ㌺ of type OTHER_SYMBOL */
    char SQUARE_PENSU = '\u333A';
    /** ㌻ of type OTHER_SYMBOL */
    char SQUARE_PEEZI = '\u333B';
    /** ㌼ of type OTHER_SYMBOL */
    char SQUARE_BEETA = '\u333C';
    /** ㌽ of type OTHER_SYMBOL */
    char SQUARE_POINTO = '\u333D';
    /** ㌾ of type OTHER_SYMBOL */
    char SQUARE_BORUTO = '\u333E';
    /** ㌿ of type OTHER_SYMBOL */
    char SQUARE_HON = '\u333F';
    /** ㍀ of type OTHER_SYMBOL */
    char SQUARE_PONDO = '\u3340';
    /** ㍁ of type OTHER_SYMBOL */
    char SQUARE_HOORU = '\u3341';
    /** ㍂ of type OTHER_SYMBOL */
    char SQUARE_HOON = '\u3342';
    /** ㍃ of type OTHER_SYMBOL */
    char SQUARE_MAIKURO = '\u3343';
    /** ㍄ of type OTHER_SYMBOL */
    char SQUARE_MAIRU = '\u3344';
    /** ㍅ of type OTHER_SYMBOL */
    char SQUARE_MAHHA = '\u3345';
    /** ㍆ of type OTHER_SYMBOL */
    char SQUARE_MARUKU = '\u3346';
    /** ㍇ of type OTHER_SYMBOL */
    char SQUARE_MANSYON = '\u3347';
    /** ㍈ of type OTHER_SYMBOL */
    char SQUARE_MIKURON = '\u3348';
    /** ㍉ of type OTHER_SYMBOL */
    char SQUARE_MIRI = '\u3349';
    /** ㍊ of type OTHER_SYMBOL */
    char SQUARE_MIRIBAARU = '\u334A';
    /** ㍋ of type OTHER_SYMBOL */
    char SQUARE_MEGA = '\u334B';
    /** ㍌ of type OTHER_SYMBOL */
    char SQUARE_MEGATON = '\u334C';
    /** ㍍ of type OTHER_SYMBOL */
    char SQUARE_MEETORU = '\u334D';
    /** ㍎ of type OTHER_SYMBOL */
    char SQUARE_YAADO = '\u334E';
    /** ㍏ of type OTHER_SYMBOL */
    char SQUARE_YAARU = '\u334F';
    /** ㍐ of type OTHER_SYMBOL */
    char SQUARE_YUAN = '\u3350';
    /** ㍑ of type OTHER_SYMBOL */
    char SQUARE_RITTORU = '\u3351';
    /** ㍒ of type OTHER_SYMBOL */
    char SQUARE_RIRA = '\u3352';
    /** ㍓ of type OTHER_SYMBOL */
    char SQUARE_RUPII = '\u3353';
    /** ㍔ of type OTHER_SYMBOL */
    char SQUARE_RUUBURU = '\u3354';
    /** ㍕ of type OTHER_SYMBOL */
    char SQUARE_REMU = '\u3355';
    /** ㍖ of type OTHER_SYMBOL */
    char SQUARE_RENTOGEN = '\u3356';
    /** ㍗ of type OTHER_SYMBOL */
    char SQUARE_WATTO = '\u3357';
    /** ㍘ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_ZERO = '\u3358';
    /** ㍙ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_ONE = '\u3359';
    /** ㍚ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWO = '\u335A';
    /** ㍛ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_THREE = '\u335B';
    /** ㍜ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_FOUR = '\u335C';
    /** ㍝ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_FIVE = '\u335D';
    /** ㍞ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_SIX = '\u335E';
    /** ㍟ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_SEVEN = '\u335F';
    /** ㍠ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_EIGHT = '\u3360';
    /** ㍡ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_NINE = '\u3361';
    /** ㍢ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TEN = '\u3362';
    /** ㍣ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_ELEVEN = '\u3363';
    /** ㍤ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWELVE = '\u3364';
    /** ㍥ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_THIRTEEN = '\u3365';
    /** ㍦ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_FOURTEEN = '\u3366';
    /** ㍧ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_FIFTEEN = '\u3367';
    /** ㍨ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_SIXTEEN = '\u3368';
    /** ㍩ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_SEVENTEEN = '\u3369';
    /** ㍪ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_EIGHTEEN = '\u336A';
    /** ㍫ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_NINETEEN = '\u336B';
    /** ㍬ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWENTY = '\u336C';
    /** ㍭ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWENTY_ONE = '\u336D';
    /** ㍮ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWENTY_TWO = '\u336E';
    /** ㍯ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWENTY_THREE = '\u336F';
    /** ㍰ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_HOUR_TWENTY_FOUR = '\u3370';
    /** ㍱ of type OTHER_SYMBOL */
    char SQUARE_HPA = '\u3371';
    /** ㍲ of type OTHER_SYMBOL */
    char SQUARE_DA = '\u3372';
    /** ㍳ of type OTHER_SYMBOL */
    char SQUARE_AU = '\u3373';
    /** ㍴ of type OTHER_SYMBOL */
    char SQUARE_BAR = '\u3374';
    /** ㍵ of type OTHER_SYMBOL */
    char SQUARE_OV = '\u3375';
    /** ㍶ of type OTHER_SYMBOL */
    char SQUARE_PC = '\u3376';
    /** ㍷ of type OTHER_SYMBOL */
    char SQUARE_DM = '\u3377';
    /** ㍸ of type OTHER_SYMBOL */
    char SQUARE_DM_SQUARED = '\u3378';
    /** ㍹ of type OTHER_SYMBOL */
    char SQUARE_DM_CUBED = '\u3379';
    /** ㍺ of type OTHER_SYMBOL */
    char SQUARE_IU = '\u337A';
    /** ㍻ of type OTHER_SYMBOL */
    char SQUARE_ERA_NAME_HEISEI = '\u337B';
    /** ㍼ of type OTHER_SYMBOL */
    char SQUARE_ERA_NAME_SYOUWA = '\u337C';
    /** ㍽ of type OTHER_SYMBOL */
    char SQUARE_ERA_NAME_TAISYOU = '\u337D';
    /** ㍾ of type OTHER_SYMBOL */
    char SQUARE_ERA_NAME_MEIZI = '\u337E';
    /** ㍿ of type OTHER_SYMBOL */
    char SQUARE_CORPORATION = '\u337F';
    /** ㎀ of type OTHER_SYMBOL */
    char SQUARE_PA_AMPS = '\u3380';
    /** ㎁ of type OTHER_SYMBOL */
    char SQUARE_NA = '\u3381';
    /** ㎂ of type OTHER_SYMBOL */
    char SQUARE_MU_A = '\u3382';
    /** ㎃ of type OTHER_SYMBOL */
    char SQUARE_MA = '\u3383';
    /** ㎄ of type OTHER_SYMBOL */
    char SQUARE_KA = '\u3384';
    /** ㎅ of type OTHER_SYMBOL */
    char SQUARE_KB = '\u3385';
    /** ㎆ of type OTHER_SYMBOL */
    char SQUARE_MB = '\u3386';
    /** ㎇ of type OTHER_SYMBOL */
    char SQUARE_GB = '\u3387';
    /** ㎈ of type OTHER_SYMBOL */
    char SQUARE_CAL = '\u3388';
    /** ㎉ of type OTHER_SYMBOL */
    char SQUARE_KCAL = '\u3389';
    /** ㎊ of type OTHER_SYMBOL */
    char SQUARE_PF = '\u338A';
    /** ㎋ of type OTHER_SYMBOL */
    char SQUARE_NF = '\u338B';
    /** ㎌ of type OTHER_SYMBOL */
    char SQUARE_MU_F = '\u338C';
    /** ㎍ of type OTHER_SYMBOL */
    char SQUARE_MU_G = '\u338D';
    /** ㎎ of type OTHER_SYMBOL */
    char SQUARE_MG = '\u338E';
    /** ㎏ of type OTHER_SYMBOL */
    char SQUARE_KG = '\u338F';
    /** ㎐ of type OTHER_SYMBOL */
    char SQUARE_HZ = '\u3390';
    /** ㎑ of type OTHER_SYMBOL */
    char SQUARE_KHZ = '\u3391';
    /** ㎒ of type OTHER_SYMBOL */
    char SQUARE_MHZ = '\u3392';
    /** ㎓ of type OTHER_SYMBOL */
    char SQUARE_GHZ = '\u3393';
    /** ㎔ of type OTHER_SYMBOL */
    char SQUARE_THZ = '\u3394';
    /** ㎕ of type OTHER_SYMBOL */
    char SQUARE_MU_L = '\u3395';
    /** ㎖ of type OTHER_SYMBOL */
    char SQUARE_ML = '\u3396';
    /** ㎗ of type OTHER_SYMBOL */
    char SQUARE_DL = '\u3397';
    /** ㎘ of type OTHER_SYMBOL */
    char SQUARE_KL = '\u3398';
    /** ㎙ of type OTHER_SYMBOL */
    char SQUARE_FM = '\u3399';
    /** ㎚ of type OTHER_SYMBOL */
    char SQUARE_NM = '\u339A';
    /** ㎛ of type OTHER_SYMBOL */
    char SQUARE_MU_M = '\u339B';
    /** ㎜ of type OTHER_SYMBOL */
    char SQUARE_MM = '\u339C';
    /** ㎝ of type OTHER_SYMBOL */
    char SQUARE_CM = '\u339D';
    /** ㎞ of type OTHER_SYMBOL */
    char SQUARE_KM = '\u339E';
    /** ㎟ of type OTHER_SYMBOL */
    char SQUARE_MM_SQUARED = '\u339F';
    /** ㎠ of type OTHER_SYMBOL */
    char SQUARE_CM_SQUARED = '\u33A0';
    /** ㎡ of type OTHER_SYMBOL */
    char SQUARE_M_SQUARED = '\u33A1';
    /** ㎢ of type OTHER_SYMBOL */
    char SQUARE_KM_SQUARED = '\u33A2';
    /** ㎣ of type OTHER_SYMBOL */
    char SQUARE_MM_CUBED = '\u33A3';
    /** ㎤ of type OTHER_SYMBOL */
    char SQUARE_CM_CUBED = '\u33A4';
    /** ㎥ of type OTHER_SYMBOL */
    char SQUARE_M_CUBED = '\u33A5';
    /** ㎦ of type OTHER_SYMBOL */
    char SQUARE_KM_CUBED = '\u33A6';
    /** ㎧ of type OTHER_SYMBOL */
    char SQUARE_M_OVER_S = '\u33A7';
    /** ㎨ of type OTHER_SYMBOL */
    char SQUARE_M_OVER_S_SQUARED = '\u33A8';
    /** ㎩ of type OTHER_SYMBOL */
    char SQUARE_PA = '\u33A9';
    /** ㎪ of type OTHER_SYMBOL */
    char SQUARE_KPA = '\u33AA';
    /** ㎫ of type OTHER_SYMBOL */
    char SQUARE_MPA = '\u33AB';
    /** ㎬ of type OTHER_SYMBOL */
    char SQUARE_GPA = '\u33AC';
    /** ㎭ of type OTHER_SYMBOL */
    char SQUARE_RAD = '\u33AD';
    /** ㎮ of type OTHER_SYMBOL */
    char SQUARE_RAD_OVER_S = '\u33AE';
    /** ㎯ of type OTHER_SYMBOL */
    char SQUARE_RAD_OVER_S_SQUARED = '\u33AF';
    /** ㎰ of type OTHER_SYMBOL */
    char SQUARE_PS = '\u33B0';
    /** ㎱ of type OTHER_SYMBOL */
    char SQUARE_NS = '\u33B1';
    /** ㎲ of type OTHER_SYMBOL */
    char SQUARE_MU_S = '\u33B2';
    /** ㎳ of type OTHER_SYMBOL */
    char SQUARE_MS = '\u33B3';
    /** ㎴ of type OTHER_SYMBOL */
    char SQUARE_PV = '\u33B4';
    /** ㎵ of type OTHER_SYMBOL */
    char SQUARE_NV = '\u33B5';
    /** ㎶ of type OTHER_SYMBOL */
    char SQUARE_MU_V = '\u33B6';
    /** ㎷ of type OTHER_SYMBOL */
    char SQUARE_MV = '\u33B7';
    /** ㎸ of type OTHER_SYMBOL */
    char SQUARE_KV = '\u33B8';
    /** ㎹ of type OTHER_SYMBOL */
    char SQUARE_MV_MEGA = '\u33B9';
    /** ㎺ of type OTHER_SYMBOL */
    char SQUARE_PW = '\u33BA';
    /** ㎻ of type OTHER_SYMBOL */
    char SQUARE_NW = '\u33BB';
    /** ㎼ of type OTHER_SYMBOL */
    char SQUARE_MU_W = '\u33BC';
    /** ㎽ of type OTHER_SYMBOL */
    char SQUARE_MW = '\u33BD';
    /** ㎾ of type OTHER_SYMBOL */
    char SQUARE_KW = '\u33BE';
    /** ㎿ of type OTHER_SYMBOL */
    char SQUARE_MW_MEGA = '\u33BF';
    /** ㏀ of type OTHER_SYMBOL */
    char SQUARE_K_OHM = '\u33C0';
    /** ㏁ of type OTHER_SYMBOL */
    char SQUARE_M_OHM = '\u33C1';
    /** ㏂ of type OTHER_SYMBOL */
    char SQUARE_AM = '\u33C2';
    /** ㏃ of type OTHER_SYMBOL */
    char SQUARE_BQ = '\u33C3';
    /** ㏄ of type OTHER_SYMBOL */
    char SQUARE_CC = '\u33C4';
    /** ㏅ of type OTHER_SYMBOL */
    char SQUARE_CD = '\u33C5';
    /** ㏆ of type OTHER_SYMBOL */
    char SQUARE_C_OVER_KG = '\u33C6';
    /** ㏇ of type OTHER_SYMBOL */
    char SQUARE_CO = '\u33C7';
    /** ㏈ of type OTHER_SYMBOL */
    char SQUARE_DB = '\u33C8';
    /** ㏉ of type OTHER_SYMBOL */
    char SQUARE_GY = '\u33C9';
    /** ㏊ of type OTHER_SYMBOL */
    char SQUARE_HA = '\u33CA';
    /** ㏋ of type OTHER_SYMBOL */
    char SQUARE_HP = '\u33CB';
    /** ㏌ of type OTHER_SYMBOL */
    char SQUARE_IN = '\u33CC';
    /** ㏍ of type OTHER_SYMBOL */
    char SQUARE_KK = '\u33CD';
    /** ㏎ of type OTHER_SYMBOL */
    char SQUARE_KM_CAPITAL = '\u33CE';
    /** ㏏ of type OTHER_SYMBOL */
    char SQUARE_KT = '\u33CF';
    /** ㏐ of type OTHER_SYMBOL */
    char SQUARE_LM = '\u33D0';
    /** ㏑ of type OTHER_SYMBOL */
    char SQUARE_LN = '\u33D1';
    /** ㏒ of type OTHER_SYMBOL */
    char SQUARE_LOG = '\u33D2';
    /** ㏓ of type OTHER_SYMBOL */
    char SQUARE_LX = '\u33D3';
    /** ㏔ of type OTHER_SYMBOL */
    char SQUARE_MB_SMALL = '\u33D4';
    /** ㏕ of type OTHER_SYMBOL */
    char SQUARE_MIL = '\u33D5';
    /** ㏖ of type OTHER_SYMBOL */
    char SQUARE_MOL = '\u33D6';
    /** ㏗ of type OTHER_SYMBOL */
    char SQUARE_PH = '\u33D7';
    /** ㏘ of type OTHER_SYMBOL */
    char SQUARE_PM = '\u33D8';
    /** ㏙ of type OTHER_SYMBOL */
    char SQUARE_PPM = '\u33D9';
    /** ㏚ of type OTHER_SYMBOL */
    char SQUARE_PR = '\u33DA';
    /** ㏛ of type OTHER_SYMBOL */
    char SQUARE_SR = '\u33DB';
    /** ㏜ of type OTHER_SYMBOL */
    char SQUARE_SV = '\u33DC';
    /** ㏝ of type OTHER_SYMBOL */
    char SQUARE_WB = '\u33DD';
    /** ㏞ of type OTHER_SYMBOL */
    char SQUARE_V_OVER_M = '\u33DE';
    /** ㏟ of type OTHER_SYMBOL */
    char SQUARE_A_OVER_M = '\u33DF';
    /** ㏠ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_ONE = '\u33E0';
    /** ㏡ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWO = '\u33E1';
    /** ㏢ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_THREE = '\u33E2';
    /** ㏣ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_FOUR = '\u33E3';
    /** ㏤ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_FIVE = '\u33E4';
    /** ㏥ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_SIX = '\u33E5';
    /** ㏦ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_SEVEN = '\u33E6';
    /** ㏧ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_EIGHT = '\u33E7';
    /** ㏨ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_NINE = '\u33E8';
    /** ㏩ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TEN = '\u33E9';
    /** ㏪ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_ELEVEN = '\u33EA';
    /** ㏫ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWELVE = '\u33EB';
    /** ㏬ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_THIRTEEN = '\u33EC';
    /** ㏭ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_FOURTEEN = '\u33ED';
    /** ㏮ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_FIFTEEN = '\u33EE';
    /** ㏯ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_SIXTEEN = '\u33EF';
    /** ㏰ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_SEVENTEEN = '\u33F0';
    /** ㏱ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_EIGHTEEN = '\u33F1';
    /** ㏲ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_NINETEEN = '\u33F2';
    /** ㏳ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY = '\u33F3';
    /** ㏴ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_ONE = '\u33F4';
    /** ㏵ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_TWO = '\u33F5';
    /** ㏶ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_THREE = '\u33F6';
    /** ㏷ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_FOUR = '\u33F7';
    /** ㏸ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_FIVE = '\u33F8';
    /** ㏹ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_SIX = '\u33F9';
    /** ㏺ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_SEVEN = '\u33FA';
    /** ㏻ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_EIGHT = '\u33FB';
    /** ㏼ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_TWENTY_NINE = '\u33FC';
    /** ㏽ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_THIRTY = '\u33FD';
    /** ㏾ of type OTHER_SYMBOL */
    char IDEOGRAPHIC_TELEGRAPH_SYMBOL_FOR_DAY_THIRTY_ONE = '\u33FE';
    /** ㏿ of type OTHER_SYMBOL */
    char SQUARE_GAL = '\u33FF';
    /** ䷀ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_CREATIVE_HEAVEN = '\u4DC0';
    /** ䷁ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_RECEPTIVE_EARTH = '\u4DC1';
    /** ䷂ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DIFFICULTY_AT_THE_BEGINNING = '\u4DC2';
    /** ䷃ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_YOUTHFUL_FOLLY = '\u4DC3';
    /** ䷄ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_WAITING = '\u4DC4';
    /** ䷅ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_CONFLICT = '\u4DC5';
    /** ䷆ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_ARMY = '\u4DC6';
    /** ䷇ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_HOLDING_TOGETHER = '\u4DC7';
    /** ䷈ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_SMALL_TAMING = '\u4DC8';
    /** ䷉ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_TREADING = '\u4DC9';
    /** ䷊ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_PEACE = '\u4DCA';
    /** ䷋ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_STANDSTILL = '\u4DCB';
    /** ䷌ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_FELLOWSHIP = '\u4DCC';
    /** ䷍ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_GREAT_POSSESSION = '\u4DCD';
    /** ䷎ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_MODESTY = '\u4DCE';
    /** ䷏ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_ENTHUSIASM = '\u4DCF';
    /** ䷐ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_FOLLOWING = '\u4DD0';
    /** ䷑ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_WORK_ON_THE_DECAYED = '\u4DD1';
    /** ䷒ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_APPROACH = '\u4DD2';
    /** ䷓ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_CONTEMPLATION = '\u4DD3';
    /** ䷔ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_BITING_THROUGH = '\u4DD4';
    /** ䷕ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_GRACE = '\u4DD5';
    /** ䷖ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_SPLITTING_APART = '\u4DD6';
    /** ䷗ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_RETURN = '\u4DD7';
    /** ䷘ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_INNOCENCE = '\u4DD8';
    /** ䷙ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_GREAT_TAMING = '\u4DD9';
    /** ䷚ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_MOUTH_CORNERS = '\u4DDA';
    /** ䷛ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_GREAT_PREPONDERANCE = '\u4DDB';
    /** ䷜ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_ABYSMAL_WATER = '\u4DDC';
    /** ䷝ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_CLINGING_FIRE = '\u4DDD';
    /** ䷞ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_INFLUENCE = '\u4DDE';
    /** ䷟ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DURATION = '\u4DDF';
    /** ䷠ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_RETREAT = '\u4DE0';
    /** ䷡ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_GREAT_POWER = '\u4DE1';
    /** ䷢ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_PROGRESS = '\u4DE2';
    /** ䷣ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DARKENING_OF_THE_LIGHT = '\u4DE3';
    /** ䷤ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_FAMILY = '\u4DE4';
    /** ䷥ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_OPPOSITION = '\u4DE5';
    /** ䷦ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_OBSTRUCTION = '\u4DE6';
    /** ䷧ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DELIVERANCE = '\u4DE7';
    /** ䷨ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DECREASE = '\u4DE8';
    /** ䷩ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_INCREASE = '\u4DE9';
    /** ䷪ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_BREAKTHROUGH = '\u4DEA';
    /** ䷫ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_COMING_TO_MEET = '\u4DEB';
    /** ䷬ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_GATHERING_TOGETHER = '\u4DEC';
    /** ䷭ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_PUSHING_UPWARD = '\u4DED';
    /** ䷮ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_OPPRESSION = '\u4DEE';
    /** ䷯ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_WELL = '\u4DEF';
    /** ䷰ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_REVOLUTION = '\u4DF0';
    /** ䷱ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_CAULDRON = '\u4DF1';
    /** ䷲ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_AROUSING_THUNDER = '\u4DF2';
    /** ䷳ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_KEEPING_STILL_MOUNTAIN = '\u4DF3';
    /** ䷴ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DEVELOPMENT = '\u4DF4';
    /** ䷵ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_MARRYING_MAIDEN = '\u4DF5';
    /** ䷶ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_ABUNDANCE = '\u4DF6';
    /** ䷷ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_WANDERER = '\u4DF7';
    /** ䷸ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_GENTLE_WIND = '\u4DF8';
    /** ䷹ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_THE_JOYOUS_LAKE = '\u4DF9';
    /** ䷺ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_DISPERSION = '\u4DFA';
    /** ䷻ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_LIMITATION = '\u4DFB';
    /** ䷼ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_INNER_TRUTH = '\u4DFC';
    /** ䷽ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_SMALL_PREPONDERANCE = '\u4DFD';
    /** ䷾ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_AFTER_COMPLETION = '\u4DFE';
    /** ䷿ of type OTHER_SYMBOL */
    char HEXAGRAM_FOR_BEFORE_COMPLETION = '\u4DFF';
    /** ꓐ of type OTHER_LETTER */
    char LISU_LETTER_BA = '\uA4D0';
    /** ꓑ of type OTHER_LETTER */
    char LISU_LETTER_PA = '\uA4D1';
    /** ꓒ of type OTHER_LETTER */
    char LISU_LETTER_PHA = '\uA4D2';
    /** ꓓ of type OTHER_LETTER */
    char LISU_LETTER_DA = '\uA4D3';
    /** ꓔ of type OTHER_LETTER */
    char LISU_LETTER_TA = '\uA4D4';
    /** ꓕ of type OTHER_LETTER */
    char LISU_LETTER_THA = '\uA4D5';
    /** ꓖ of type OTHER_LETTER */
    char LISU_LETTER_GA = '\uA4D6';
    /** ꓗ of type OTHER_LETTER */
    char LISU_LETTER_KA = '\uA4D7';
    /** ꓘ of type OTHER_LETTER */
    char LISU_LETTER_KHA = '\uA4D8';
    /** ꓙ of type OTHER_LETTER */
    char LISU_LETTER_JA = '\uA4D9';
    /** ꓚ of type OTHER_LETTER */
    char LISU_LETTER_CA = '\uA4DA';
    /** ꓛ of type OTHER_LETTER */
    char LISU_LETTER_CHA = '\uA4DB';
    /** ꓜ of type OTHER_LETTER */
    char LISU_LETTER_DZA = '\uA4DC';
    /** ꓝ of type OTHER_LETTER */
    char LISU_LETTER_TSA = '\uA4DD';
    /** ꓞ of type OTHER_LETTER */
    char LISU_LETTER_TSHA = '\uA4DE';
    /** ꓟ of type OTHER_LETTER */
    char LISU_LETTER_MA = '\uA4DF';
    /** ꓠ of type OTHER_LETTER */
    char LISU_LETTER_NA = '\uA4E0';
    /** ꓡ of type OTHER_LETTER */
    char LISU_LETTER_LA = '\uA4E1';
    /** ꓢ of type OTHER_LETTER */
    char LISU_LETTER_SA = '\uA4E2';
    /** ꓣ of type OTHER_LETTER */
    char LISU_LETTER_ZHA = '\uA4E3';
    /** ꓤ of type OTHER_LETTER */
    char LISU_LETTER_ZA = '\uA4E4';
    /** ꓥ of type OTHER_LETTER */
    char LISU_LETTER_NGA = '\uA4E5';
    /** ꓦ of type OTHER_LETTER */
    char LISU_LETTER_HA = '\uA4E6';
    /** ꓧ of type OTHER_LETTER */
    char LISU_LETTER_XA = '\uA4E7';
    /** ꓨ of type OTHER_LETTER */
    char LISU_LETTER_HHA = '\uA4E8';
    /** ꓩ of type OTHER_LETTER */
    char LISU_LETTER_FA = '\uA4E9';
    /** ꓪ of type OTHER_LETTER */
    char LISU_LETTER_WA = '\uA4EA';
    /** ꓫ of type OTHER_LETTER */
    char LISU_LETTER_SHA = '\uA4EB';
    /** ꓬ of type OTHER_LETTER */
    char LISU_LETTER_YA = '\uA4EC';
    /** ꓭ of type OTHER_LETTER */
    char LISU_LETTER_GHA = '\uA4ED';
    /** ꓮ of type OTHER_LETTER */
    char LISU_LETTER_A = '\uA4EE';
    /** ꓯ of type OTHER_LETTER */
    char LISU_LETTER_AE = '\uA4EF';
    /** ꓰ of type OTHER_LETTER */
    char LISU_LETTER_E = '\uA4F0';
    /** ꓱ of type OTHER_LETTER */
    char LISU_LETTER_EU = '\uA4F1';
    /** ꓲ of type OTHER_LETTER */
    char LISU_LETTER_I = '\uA4F2';
    /** ꓳ of type OTHER_LETTER */
    char LISU_LETTER_O = '\uA4F3';
    /** ꓴ of type OTHER_LETTER */
    char LISU_LETTER_U = '\uA4F4';
    /** ꓵ of type OTHER_LETTER */
    char LISU_LETTER_UE = '\uA4F5';
    /** ꓶ of type OTHER_LETTER */
    char LISU_LETTER_UH = '\uA4F6';
    /** ꓷ of type OTHER_LETTER */
    char LISU_LETTER_OE = '\uA4F7';
    /** ꓸ of type MODIFIER_LETTER */
    char LISU_LETTER_TONE_MYA_TI = '\uA4F8';
    /** ꓹ of type MODIFIER_LETTER */
    char LISU_LETTER_TONE_NA_PO = '\uA4F9';
    /** ꓺ of type MODIFIER_LETTER */
    char LISU_LETTER_TONE_MYA_CYA = '\uA4FA';
    /** ꓻ of type MODIFIER_LETTER */
    char LISU_LETTER_TONE_MYA_BO = '\uA4FB';
    /** ꓼ of type MODIFIER_LETTER */
    char LISU_LETTER_TONE_MYA_NA = '\uA4FC';
    /** ꓽ of type MODIFIER_LETTER */
    char LISU_LETTER_TONE_MYA_JEU = '\uA4FD';
    /** ꓾ of type OTHER_PUNCTUATION */
    char LISU_PUNCTUATION_COMMA = '\uA4FE';
    /** ꓿ of type OTHER_PUNCTUATION */
    char LISU_PUNCTUATION_FULL_STOP = '\uA4FF';
    /** ꔀ of type OTHER_LETTER */
    char VAI_SYLLABLE_EE = '\uA500';
    /** ꔁ of type OTHER_LETTER */
    char VAI_SYLLABLE_EEN = '\uA501';
    /** ꔂ of type OTHER_LETTER */
    char VAI_SYLLABLE_HEE = '\uA502';
    /** ꔃ of type OTHER_LETTER */
    char VAI_SYLLABLE_WEE = '\uA503';
    /** ꔄ of type OTHER_LETTER */
    char VAI_SYLLABLE_WEEN = '\uA504';
    /** ꔅ of type OTHER_LETTER */
    char VAI_SYLLABLE_PEE = '\uA505';
    /** ꔆ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHEE = '\uA506';
    /** ꔇ of type OTHER_LETTER */
    char VAI_SYLLABLE_BEE = '\uA507';
    /** ꔈ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBEE = '\uA508';
    /** ꔉ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPEE = '\uA509';
    /** ꔊ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBEE = '\uA50A';
    /** ꔋ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBEE = '\uA50B';
    /** ꔌ of type OTHER_LETTER */
    char VAI_SYLLABLE_FEE = '\uA50C';
    /** ꔍ of type OTHER_LETTER */
    char VAI_SYLLABLE_VEE = '\uA50D';
    /** ꔎ of type OTHER_LETTER */
    char VAI_SYLLABLE_TEE = '\uA50E';
    /** ꔏ of type OTHER_LETTER */
    char VAI_SYLLABLE_THEE = '\uA50F';
    /** ꔐ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHEE = '\uA510';
    /** ꔑ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHEE = '\uA511';
    /** ꔒ of type OTHER_LETTER */
    char VAI_SYLLABLE_LEE = '\uA512';
    /** ꔓ of type OTHER_LETTER */
    char VAI_SYLLABLE_REE = '\uA513';
    /** ꔔ of type OTHER_LETTER */
    char VAI_SYLLABLE_DEE = '\uA514';
    /** ꔕ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDEE = '\uA515';
    /** ꔖ of type OTHER_LETTER */
    char VAI_SYLLABLE_SEE = '\uA516';
    /** ꔗ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHEE = '\uA517';
    /** ꔘ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZEE = '\uA518';
    /** ꔙ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHEE = '\uA519';
    /** ꔚ of type OTHER_LETTER */
    char VAI_SYLLABLE_CEE = '\uA51A';
    /** ꔛ of type OTHER_LETTER */
    char VAI_SYLLABLE_JEE = '\uA51B';
    /** ꔜ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJEE = '\uA51C';
    /** ꔝ of type OTHER_LETTER */
    char VAI_SYLLABLE_YEE = '\uA51D';
    /** ꔞ of type OTHER_LETTER */
    char VAI_SYLLABLE_KEE = '\uA51E';
    /** ꔟ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGEE = '\uA51F';
    /** ꔠ of type OTHER_LETTER */
    char VAI_SYLLABLE_GEE = '\uA520';
    /** ꔡ of type OTHER_LETTER */
    char VAI_SYLLABLE_MEE = '\uA521';
    /** ꔢ of type OTHER_LETTER */
    char VAI_SYLLABLE_NEE = '\uA522';
    /** ꔣ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYEE = '\uA523';
    /** ꔤ of type OTHER_LETTER */
    char VAI_SYLLABLE_I = '\uA524';
    /** ꔥ of type OTHER_LETTER */
    char VAI_SYLLABLE_IN = '\uA525';
    /** ꔦ of type OTHER_LETTER */
    char VAI_SYLLABLE_HI = '\uA526';
    /** ꔧ of type OTHER_LETTER */
    char VAI_SYLLABLE_HIN = '\uA527';
    /** ꔨ of type OTHER_LETTER */
    char VAI_SYLLABLE_WI = '\uA528';
    /** ꔩ of type OTHER_LETTER */
    char VAI_SYLLABLE_WIN = '\uA529';
    /** ꔪ of type OTHER_LETTER */
    char VAI_SYLLABLE_PI = '\uA52A';
    /** ꔫ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHI = '\uA52B';
    /** ꔬ of type OTHER_LETTER */
    char VAI_SYLLABLE_BI = '\uA52C';
    /** ꔭ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBI = '\uA52D';
    /** ꔮ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPI = '\uA52E';
    /** ꔯ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBI = '\uA52F';
    /** ꔰ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBI = '\uA530';
    /** ꔱ of type OTHER_LETTER */
    char VAI_SYLLABLE_FI = '\uA531';
    /** ꔲ of type OTHER_LETTER */
    char VAI_SYLLABLE_VI = '\uA532';
    /** ꔳ of type OTHER_LETTER */
    char VAI_SYLLABLE_TI = '\uA533';
    /** ꔴ of type OTHER_LETTER */
    char VAI_SYLLABLE_THI = '\uA534';
    /** ꔵ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHI = '\uA535';
    /** ꔶ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHI = '\uA536';
    /** ꔷ of type OTHER_LETTER */
    char VAI_SYLLABLE_LI = '\uA537';
    /** ꔸ of type OTHER_LETTER */
    char VAI_SYLLABLE_RI = '\uA538';
    /** ꔹ of type OTHER_LETTER */
    char VAI_SYLLABLE_DI = '\uA539';
    /** ꔺ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDI = '\uA53A';
    /** ꔻ of type OTHER_LETTER */
    char VAI_SYLLABLE_SI = '\uA53B';
    /** ꔼ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHI = '\uA53C';
    /** ꔽ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZI = '\uA53D';
    /** ꔾ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHI = '\uA53E';
    /** ꔿ of type OTHER_LETTER */
    char VAI_SYLLABLE_CI = '\uA53F';
    /** ꕀ of type OTHER_LETTER */
    char VAI_SYLLABLE_JI = '\uA540';
    /** ꕁ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJI = '\uA541';
    /** ꕂ of type OTHER_LETTER */
    char VAI_SYLLABLE_YI = '\uA542';
    /** ꕃ of type OTHER_LETTER */
    char VAI_SYLLABLE_KI = '\uA543';
    /** ꕄ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGI = '\uA544';
    /** ꕅ of type OTHER_LETTER */
    char VAI_SYLLABLE_GI = '\uA545';
    /** ꕆ of type OTHER_LETTER */
    char VAI_SYLLABLE_MI = '\uA546';
    /** ꕇ of type OTHER_LETTER */
    char VAI_SYLLABLE_NI = '\uA547';
    /** ꕈ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYI = '\uA548';
    /** ꕉ of type OTHER_LETTER */
    char VAI_SYLLABLE_A = '\uA549';
    /** ꕊ of type OTHER_LETTER */
    char VAI_SYLLABLE_AN = '\uA54A';
    /** ꕋ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGAN = '\uA54B';
    /** ꕌ of type OTHER_LETTER */
    char VAI_SYLLABLE_HA = '\uA54C';
    /** ꕍ of type OTHER_LETTER */
    char VAI_SYLLABLE_HAN = '\uA54D';
    /** ꕎ of type OTHER_LETTER */
    char VAI_SYLLABLE_WA = '\uA54E';
    /** ꕏ of type OTHER_LETTER */
    char VAI_SYLLABLE_WAN = '\uA54F';
    /** ꕐ of type OTHER_LETTER */
    char VAI_SYLLABLE_PA = '\uA550';
    /** ꕑ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHA = '\uA551';
    /** ꕒ of type OTHER_LETTER */
    char VAI_SYLLABLE_BA = '\uA552';
    /** ꕓ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBA = '\uA553';
    /** ꕔ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPA = '\uA554';
    /** ꕕ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPAN = '\uA555';
    /** ꕖ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBA = '\uA556';
    /** ꕗ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBA = '\uA557';
    /** ꕘ of type OTHER_LETTER */
    char VAI_SYLLABLE_FA = '\uA558';
    /** ꕙ of type OTHER_LETTER */
    char VAI_SYLLABLE_VA = '\uA559';
    /** ꕚ of type OTHER_LETTER */
    char VAI_SYLLABLE_TA = '\uA55A';
    /** ꕛ of type OTHER_LETTER */
    char VAI_SYLLABLE_THA = '\uA55B';
    /** ꕜ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHA = '\uA55C';
    /** ꕝ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHA = '\uA55D';
    /** ꕞ of type OTHER_LETTER */
    char VAI_SYLLABLE_LA = '\uA55E';
    /** ꕟ of type OTHER_LETTER */
    char VAI_SYLLABLE_RA = '\uA55F';
    /** ꕠ of type OTHER_LETTER */
    char VAI_SYLLABLE_DA = '\uA560';
    /** ꕡ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDA = '\uA561';
    /** ꕢ of type OTHER_LETTER */
    char VAI_SYLLABLE_SA = '\uA562';
    /** ꕣ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHA = '\uA563';
    /** ꕤ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZA = '\uA564';
    /** ꕥ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHA = '\uA565';
    /** ꕦ of type OTHER_LETTER */
    char VAI_SYLLABLE_CA = '\uA566';
    /** ꕧ of type OTHER_LETTER */
    char VAI_SYLLABLE_JA = '\uA567';
    /** ꕨ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJA = '\uA568';
    /** ꕩ of type OTHER_LETTER */
    char VAI_SYLLABLE_YA = '\uA569';
    /** ꕪ of type OTHER_LETTER */
    char VAI_SYLLABLE_KA = '\uA56A';
    /** ꕫ of type OTHER_LETTER */
    char VAI_SYLLABLE_KAN = '\uA56B';
    /** ꕬ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGA = '\uA56C';
    /** ꕭ of type OTHER_LETTER */
    char VAI_SYLLABLE_GA = '\uA56D';
    /** ꕮ of type OTHER_LETTER */
    char VAI_SYLLABLE_MA = '\uA56E';
    /** ꕯ of type OTHER_LETTER */
    char VAI_SYLLABLE_NA = '\uA56F';
    /** ꕰ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYA = '\uA570';
    /** ꕱ of type OTHER_LETTER */
    char VAI_SYLLABLE_OO = '\uA571';
    /** ꕲ of type OTHER_LETTER */
    char VAI_SYLLABLE_OON = '\uA572';
    /** ꕳ of type OTHER_LETTER */
    char VAI_SYLLABLE_HOO = '\uA573';
    /** ꕴ of type OTHER_LETTER */
    char VAI_SYLLABLE_WOO = '\uA574';
    /** ꕵ of type OTHER_LETTER */
    char VAI_SYLLABLE_WOON = '\uA575';
    /** ꕶ of type OTHER_LETTER */
    char VAI_SYLLABLE_POO = '\uA576';
    /** ꕷ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHOO = '\uA577';
    /** ꕸ of type OTHER_LETTER */
    char VAI_SYLLABLE_BOO = '\uA578';
    /** ꕹ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBOO = '\uA579';
    /** ꕺ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPOO = '\uA57A';
    /** ꕻ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBOO = '\uA57B';
    /** ꕼ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBOO = '\uA57C';
    /** ꕽ of type OTHER_LETTER */
    char VAI_SYLLABLE_FOO = '\uA57D';
    /** ꕾ of type OTHER_LETTER */
    char VAI_SYLLABLE_VOO = '\uA57E';
    /** ꕿ of type OTHER_LETTER */
    char VAI_SYLLABLE_TOO = '\uA57F';
    /** ꖀ of type OTHER_LETTER */
    char VAI_SYLLABLE_THOO = '\uA580';
    /** ꖁ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHOO = '\uA581';
    /** ꖂ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHOO = '\uA582';
    /** ꖃ of type OTHER_LETTER */
    char VAI_SYLLABLE_LOO = '\uA583';
    /** ꖄ of type OTHER_LETTER */
    char VAI_SYLLABLE_ROO = '\uA584';
    /** ꖅ of type OTHER_LETTER */
    char VAI_SYLLABLE_DOO = '\uA585';
    /** ꖆ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDOO = '\uA586';
    /** ꖇ of type OTHER_LETTER */
    char VAI_SYLLABLE_SOO = '\uA587';
    /** ꖈ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHOO = '\uA588';
    /** ꖉ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZOO = '\uA589';
    /** ꖊ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHOO = '\uA58A';
    /** ꖋ of type OTHER_LETTER */
    char VAI_SYLLABLE_COO = '\uA58B';
    /** ꖌ of type OTHER_LETTER */
    char VAI_SYLLABLE_JOO = '\uA58C';
    /** ꖍ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJOO = '\uA58D';
    /** ꖎ of type OTHER_LETTER */
    char VAI_SYLLABLE_YOO = '\uA58E';
    /** ꖏ of type OTHER_LETTER */
    char VAI_SYLLABLE_KOO = '\uA58F';
    /** ꖐ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGOO = '\uA590';
    /** ꖑ of type OTHER_LETTER */
    char VAI_SYLLABLE_GOO = '\uA591';
    /** ꖒ of type OTHER_LETTER */
    char VAI_SYLLABLE_MOO = '\uA592';
    /** ꖓ of type OTHER_LETTER */
    char VAI_SYLLABLE_NOO = '\uA593';
    /** ꖔ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYOO = '\uA594';
    /** ꖕ of type OTHER_LETTER */
    char VAI_SYLLABLE_U = '\uA595';
    /** ꖖ of type OTHER_LETTER */
    char VAI_SYLLABLE_UN = '\uA596';
    /** ꖗ of type OTHER_LETTER */
    char VAI_SYLLABLE_HU = '\uA597';
    /** ꖘ of type OTHER_LETTER */
    char VAI_SYLLABLE_HUN = '\uA598';
    /** ꖙ of type OTHER_LETTER */
    char VAI_SYLLABLE_WU = '\uA599';
    /** ꖚ of type OTHER_LETTER */
    char VAI_SYLLABLE_WUN = '\uA59A';
    /** ꖛ of type OTHER_LETTER */
    char VAI_SYLLABLE_PU = '\uA59B';
    /** ꖜ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHU = '\uA59C';
    /** ꖝ of type OTHER_LETTER */
    char VAI_SYLLABLE_BU = '\uA59D';
    /** ꖞ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBU = '\uA59E';
    /** ꖟ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPU = '\uA59F';
    /** ꖠ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBU = '\uA5A0';
    /** ꖡ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBU = '\uA5A1';
    /** ꖢ of type OTHER_LETTER */
    char VAI_SYLLABLE_FU = '\uA5A2';
    /** ꖣ of type OTHER_LETTER */
    char VAI_SYLLABLE_VU = '\uA5A3';
    /** ꖤ of type OTHER_LETTER */
    char VAI_SYLLABLE_TU = '\uA5A4';
    /** ꖥ of type OTHER_LETTER */
    char VAI_SYLLABLE_THU = '\uA5A5';
    /** ꖦ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHU = '\uA5A6';
    /** ꖧ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHU = '\uA5A7';
    /** ꖨ of type OTHER_LETTER */
    char VAI_SYLLABLE_LU = '\uA5A8';
    /** ꖩ of type OTHER_LETTER */
    char VAI_SYLLABLE_RU = '\uA5A9';
    /** ꖪ of type OTHER_LETTER */
    char VAI_SYLLABLE_DU = '\uA5AA';
    /** ꖫ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDU = '\uA5AB';
    /** ꖬ of type OTHER_LETTER */
    char VAI_SYLLABLE_SU = '\uA5AC';
    /** ꖭ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHU = '\uA5AD';
    /** ꖮ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZU = '\uA5AE';
    /** ꖯ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHU = '\uA5AF';
    /** ꖰ of type OTHER_LETTER */
    char VAI_SYLLABLE_CU = '\uA5B0';
    /** ꖱ of type OTHER_LETTER */
    char VAI_SYLLABLE_JU = '\uA5B1';
    /** ꖲ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJU = '\uA5B2';
    /** ꖳ of type OTHER_LETTER */
    char VAI_SYLLABLE_YU = '\uA5B3';
    /** ꖴ of type OTHER_LETTER */
    char VAI_SYLLABLE_KU = '\uA5B4';
    /** ꖵ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGU = '\uA5B5';
    /** ꖶ of type OTHER_LETTER */
    char VAI_SYLLABLE_GU = '\uA5B6';
    /** ꖷ of type OTHER_LETTER */
    char VAI_SYLLABLE_MU = '\uA5B7';
    /** ꖸ of type OTHER_LETTER */
    char VAI_SYLLABLE_NU = '\uA5B8';
    /** ꖹ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYU = '\uA5B9';
    /** ꖺ of type OTHER_LETTER */
    char VAI_SYLLABLE_O = '\uA5BA';
    /** ꖻ of type OTHER_LETTER */
    char VAI_SYLLABLE_ON = '\uA5BB';
    /** ꖼ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGON = '\uA5BC';
    /** ꖽ of type OTHER_LETTER */
    char VAI_SYLLABLE_HO = '\uA5BD';
    /** ꖾ of type OTHER_LETTER */
    char VAI_SYLLABLE_HON = '\uA5BE';
    /** ꖿ of type OTHER_LETTER */
    char VAI_SYLLABLE_WO = '\uA5BF';
    /** ꗀ of type OTHER_LETTER */
    char VAI_SYLLABLE_WON = '\uA5C0';
    /** ꗁ of type OTHER_LETTER */
    char VAI_SYLLABLE_PO = '\uA5C1';
    /** ꗂ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHO = '\uA5C2';
    /** ꗃ of type OTHER_LETTER */
    char VAI_SYLLABLE_BO = '\uA5C3';
    /** ꗄ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBO = '\uA5C4';
    /** ꗅ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPO = '\uA5C5';
    /** ꗆ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBO = '\uA5C6';
    /** ꗇ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBO = '\uA5C7';
    /** ꗈ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBON = '\uA5C8';
    /** ꗉ of type OTHER_LETTER */
    char VAI_SYLLABLE_FO = '\uA5C9';
    /** ꗊ of type OTHER_LETTER */
    char VAI_SYLLABLE_VO = '\uA5CA';
    /** ꗋ of type OTHER_LETTER */
    char VAI_SYLLABLE_TO = '\uA5CB';
    /** ꗌ of type OTHER_LETTER */
    char VAI_SYLLABLE_THO = '\uA5CC';
    /** ꗍ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHO = '\uA5CD';
    /** ꗎ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHO = '\uA5CE';
    /** ꗏ of type OTHER_LETTER */
    char VAI_SYLLABLE_LO = '\uA5CF';
    /** ꗐ of type OTHER_LETTER */
    char VAI_SYLLABLE_RO = '\uA5D0';
    /** ꗑ of type OTHER_LETTER */
    char VAI_SYLLABLE_DO = '\uA5D1';
    /** ꗒ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDO = '\uA5D2';
    /** ꗓ of type OTHER_LETTER */
    char VAI_SYLLABLE_SO = '\uA5D3';
    /** ꗔ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHO = '\uA5D4';
    /** ꗕ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZO = '\uA5D5';
    /** ꗖ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHO = '\uA5D6';
    /** ꗗ of type OTHER_LETTER */
    char VAI_SYLLABLE_CO = '\uA5D7';
    /** ꗘ of type OTHER_LETTER */
    char VAI_SYLLABLE_JO = '\uA5D8';
    /** ꗙ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJO = '\uA5D9';
    /** ꗚ of type OTHER_LETTER */
    char VAI_SYLLABLE_YO = '\uA5DA';
    /** ꗛ of type OTHER_LETTER */
    char VAI_SYLLABLE_KO = '\uA5DB';
    /** ꗜ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGO = '\uA5DC';
    /** ꗝ of type OTHER_LETTER */
    char VAI_SYLLABLE_GO = '\uA5DD';
    /** ꗞ of type OTHER_LETTER */
    char VAI_SYLLABLE_MO = '\uA5DE';
    /** ꗟ of type OTHER_LETTER */
    char VAI_SYLLABLE_NO = '\uA5DF';
    /** ꗠ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYO = '\uA5E0';
    /** ꗡ of type OTHER_LETTER */
    char VAI_SYLLABLE_E = '\uA5E1';
    /** ꗢ of type OTHER_LETTER */
    char VAI_SYLLABLE_EN = '\uA5E2';
    /** ꗣ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGEN = '\uA5E3';
    /** ꗤ of type OTHER_LETTER */
    char VAI_SYLLABLE_HE = '\uA5E4';
    /** ꗥ of type OTHER_LETTER */
    char VAI_SYLLABLE_HEN = '\uA5E5';
    /** ꗦ of type OTHER_LETTER */
    char VAI_SYLLABLE_WE = '\uA5E6';
    /** ꗧ of type OTHER_LETTER */
    char VAI_SYLLABLE_WEN = '\uA5E7';
    /** ꗨ of type OTHER_LETTER */
    char VAI_SYLLABLE_PE = '\uA5E8';
    /** ꗩ of type OTHER_LETTER */
    char VAI_SYLLABLE_BHE = '\uA5E9';
    /** ꗪ of type OTHER_LETTER */
    char VAI_SYLLABLE_BE = '\uA5EA';
    /** ꗫ of type OTHER_LETTER */
    char VAI_SYLLABLE_MBE = '\uA5EB';
    /** ꗬ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPE = '\uA5EC';
    /** ꗭ of type OTHER_LETTER */
    char VAI_SYLLABLE_KPEN = '\uA5ED';
    /** ꗮ of type OTHER_LETTER */
    char VAI_SYLLABLE_MGBE = '\uA5EE';
    /** ꗯ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBE = '\uA5EF';
    /** ꗰ of type OTHER_LETTER */
    char VAI_SYLLABLE_GBEN = '\uA5F0';
    /** ꗱ of type OTHER_LETTER */
    char VAI_SYLLABLE_FE = '\uA5F1';
    /** ꗲ of type OTHER_LETTER */
    char VAI_SYLLABLE_VE = '\uA5F2';
    /** ꗳ of type OTHER_LETTER */
    char VAI_SYLLABLE_TE = '\uA5F3';
    /** ꗴ of type OTHER_LETTER */
    char VAI_SYLLABLE_THE = '\uA5F4';
    /** ꗵ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHE = '\uA5F5';
    /** ꗶ of type OTHER_LETTER */
    char VAI_SYLLABLE_DHHE = '\uA5F6';
    /** ꗷ of type OTHER_LETTER */
    char VAI_SYLLABLE_LE = '\uA5F7';
    /** ꗸ of type OTHER_LETTER */
    char VAI_SYLLABLE_RE = '\uA5F8';
    /** ꗹ of type OTHER_LETTER */
    char VAI_SYLLABLE_DE = '\uA5F9';
    /** ꗺ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDE = '\uA5FA';
    /** ꗻ of type OTHER_LETTER */
    char VAI_SYLLABLE_SE = '\uA5FB';
    /** ꗼ of type OTHER_LETTER */
    char VAI_SYLLABLE_SHE = '\uA5FC';
    /** ꗽ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZE = '\uA5FD';
    /** ꗾ of type OTHER_LETTER */
    char VAI_SYLLABLE_ZHE = '\uA5FE';
    /** ꗿ of type OTHER_LETTER */
    char VAI_SYLLABLE_CE = '\uA5FF';
    /** ꘀ of type OTHER_LETTER */
    char VAI_SYLLABLE_JE = '\uA600';
    /** ꘁ of type OTHER_LETTER */
    char VAI_SYLLABLE_NJE = '\uA601';
    /** ꘂ of type OTHER_LETTER */
    char VAI_SYLLABLE_YE = '\uA602';
    /** ꘃ of type OTHER_LETTER */
    char VAI_SYLLABLE_KE = '\uA603';
    /** ꘄ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGE = '\uA604';
    /** ꘅ of type OTHER_LETTER */
    char VAI_SYLLABLE_NGGEN = '\uA605';
    /** ꘆ of type OTHER_LETTER */
    char VAI_SYLLABLE_GE = '\uA606';
    /** ꘇ of type OTHER_LETTER */
    char VAI_SYLLABLE_GEN = '\uA607';
    /** ꘈ of type OTHER_LETTER */
    char VAI_SYLLABLE_ME = '\uA608';
    /** ꘉ of type OTHER_LETTER */
    char VAI_SYLLABLE_NE = '\uA609';
    /** ꘊ of type OTHER_LETTER */
    char VAI_SYLLABLE_NYE = '\uA60A';
    /** ꘋ of type OTHER_LETTER */
    char VAI_SYLLABLE_NG = '\uA60B';
    /** ꘌ of type MODIFIER_LETTER */
    char VAI_SYLLABLE_LENGTHENER = '\uA60C';
    /** ꘍ of type OTHER_PUNCTUATION */
    char VAI_COMMA = '\uA60D';
    /** ꘎ of type OTHER_PUNCTUATION */
    char VAI_FULL_STOP = '\uA60E';
    /** ꘏ of type OTHER_PUNCTUATION */
    char VAI_QUESTION_MARK = '\uA60F';
    /** ꘐ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDOLE_FA = '\uA610';
    /** ꘑ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDOLE_KA = '\uA611';
    /** ꘒ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDOLE_SOO = '\uA612';
    /** ꘓ of type OTHER_LETTER */
    char VAI_SYMBOL_FEENG = '\uA613';
    /** ꘔ of type OTHER_LETTER */
    char VAI_SYMBOL_KEENG = '\uA614';
    /** ꘕ of type OTHER_LETTER */
    char VAI_SYMBOL_TING = '\uA615';
    /** ꘖ of type OTHER_LETTER */
    char VAI_SYMBOL_NII = '\uA616';
    /** ꘗ of type OTHER_LETTER */
    char VAI_SYMBOL_BANG = '\uA617';
    /** ꘘ of type OTHER_LETTER */
    char VAI_SYMBOL_FAA = '\uA618';
    /** ꘙ of type OTHER_LETTER */
    char VAI_SYMBOL_TAA = '\uA619';
    /** ꘚ of type OTHER_LETTER */
    char VAI_SYMBOL_DANG = '\uA61A';
    /** ꘛ of type OTHER_LETTER */
    char VAI_SYMBOL_DOONG = '\uA61B';
    /** ꘜ of type OTHER_LETTER */
    char VAI_SYMBOL_KUNG = '\uA61C';
    /** ꘝ of type OTHER_LETTER */
    char VAI_SYMBOL_TONG = '\uA61D';
    /** ꘞ of type OTHER_LETTER */
    char VAI_SYMBOL_DO_O = '\uA61E';
    /** ꘟ of type OTHER_LETTER */
    char VAI_SYMBOL_JONG = '\uA61F';
    /** ꘠ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_ZERO = '\uA620';
    /** ꘡ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_ONE = '\uA621';
    /** ꘢ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_TWO = '\uA622';
    /** ꘣ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_THREE = '\uA623';
    /** ꘤ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_FOUR = '\uA624';
    /** ꘥ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_FIVE = '\uA625';
    /** ꘦ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_SIX = '\uA626';
    /** ꘧ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_SEVEN = '\uA627';
    /** ꘨ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_EIGHT = '\uA628';
    /** ꘩ of type DECIMAL_DIGIT_NUMBER */
    char VAI_DIGIT_NINE = '\uA629';
    /** ꘪ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDOLE_MA = '\uA62A';
    /** ꘫ of type OTHER_LETTER */
    char VAI_SYLLABLE_NDOLE_DO = '\uA62B';
    /** ꙳ of type OTHER_PUNCTUATION */
    char SLAVONIC_ASTERISK = '\uA673';
    /** ꜀ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YIN_PING = '\uA700';
    /** ꜁ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YANG_PING = '\uA701';
    /** ꜂ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YIN_SHANG = '\uA702';
    /** ꜃ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YANG_SHANG = '\uA703';
    /** ꜄ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YIN_QU = '\uA704';
    /** ꜅ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YANG_QU = '\uA705';
    /** ꜆ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YIN_RU = '\uA706';
    /** ꜇ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_CHINESE_TONE_YANG_RU = '\uA707';
    /** ꜈ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_HIGH_DOTTED_TONE_BAR = '\uA708';
    /** ꜉ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_HIGH_DOTTED_TONE_BAR = '\uA709';
    /** ꜊ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MID_DOTTED_TONE_BAR = '\uA70A';
    /** ꜋ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_DOTTED_TONE_BAR = '\uA70B';
    /** ꜌ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_LOW_DOTTED_TONE_BAR = '\uA70C';
    /** ꜍ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_HIGH_DOTTED_LEFT_STEM_TONE_BAR = '\uA70D';
    /** ꜎ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_HIGH_DOTTED_LEFT_STEM_TONE_BAR = '\uA70E';
    /** ꜏ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MID_DOTTED_LEFT_STEM_TONE_BAR = '\uA70F';
    /** ꜐ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_DOTTED_LEFT_STEM_TONE_BAR = '\uA710';
    /** ꜑ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_LOW_DOTTED_LEFT_STEM_TONE_BAR = '\uA711';
    /** ꜒ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_HIGH_LEFT_STEM_TONE_BAR = '\uA712';
    /** ꜓ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_HIGH_LEFT_STEM_TONE_BAR = '\uA713';
    /** ꜔ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_MID_LEFT_STEM_TONE_BAR = '\uA714';
    /** ꜕ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_LOW_LEFT_STEM_TONE_BAR = '\uA715';
    /** ꜖ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_EXTRA_LOW_LEFT_STEM_TONE_BAR = '\uA716';
    /** ꜗ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_DOT_VERTICAL_BAR = '\uA717';
    /** ꜘ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_DOT_SLASH = '\uA718';
    /** ꜙ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_DOT_HORIZONTAL_BAR = '\uA719';
    /** ꜚ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOWER_RIGHT_CORNER_ANGLE = '\uA71A';
    /** ꜛ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_RAISED_UP_ARROW = '\uA71B';
    /** ꜜ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_RAISED_DOWN_ARROW = '\uA71C';
    /** ꜝ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_RAISED_EXCLAMATION_MARK = '\uA71D';
    /** ꜞ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_RAISED_INVERTED_EXCLAMATION_MARK = '\uA71E';
    /** ꜟ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOW_INVERTED_EXCLAMATION_MARK = '\uA71F';
    /** ꜠ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_STRESS_AND_HIGH_TONE = '\uA720';
    /** ꜡ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_STRESS_AND_LOW_TONE = '\uA721';
    /** ꝰ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_US = '\uA770';
    /** ꞈ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_LOW_CIRCUMFLEX_ACCENT = '\uA788';
    /** ꞉ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_COLON = '\uA789';
    /** ꞊ of type MODIFIER_SYMBOL */
    char MODIFIER_LETTER_SHORT_EQUALS_SIGN = '\uA78A';
    /** ꟸ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_CAPITAL_H_WITH_STROKE = '\uA7F8';
    /** ꟹ of type MODIFIER_LETTER */
    char MODIFIER_LETTER_SMALL_LIGATURE_OE = '\uA7F9';
    /** ꠀ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_A = '\uA800';
    /** ꠁ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_I = '\uA801';
    /** ꠂ of type NON_SPACING_MARK */
    char SYLOTI_NAGRI_SIGN_DVISVARA = '\uA802';
    /** ꠃ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_U = '\uA803';
    /** ꠄ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_E = '\uA804';
    /** ꠅ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_O = '\uA805';
    /** ꠆ of type NON_SPACING_MARK */
    char SYLOTI_NAGRI_SIGN_HASANTA = '\uA806';
    /** ꠇ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_KO = '\uA807';
    /** ꠈ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_KHO = '\uA808';
    /** ꠉ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_GO = '\uA809';
    /** ꠊ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_GHO = '\uA80A';
    /** ꠋ of type NON_SPACING_MARK */
    char SYLOTI_NAGRI_SIGN_ANUSVARA = '\uA80B';
    /** ꠌ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_CO = '\uA80C';
    /** ꠍ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_CHO = '\uA80D';
    /** ꠎ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_JO = '\uA80E';
    /** ꠏ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_JHO = '\uA80F';
    /** ꠐ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_TTO = '\uA810';
    /** ꠑ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_TTHO = '\uA811';
    /** ꠒ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_DDO = '\uA812';
    /** ꠓ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_DDHO = '\uA813';
    /** ꠔ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_TO = '\uA814';
    /** ꠕ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_THO = '\uA815';
    /** ꠖ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_DO = '\uA816';
    /** ꠗ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_DHO = '\uA817';
    /** ꠘ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_NO = '\uA818';
    /** ꠙ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_PO = '\uA819';
    /** ꠚ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_PHO = '\uA81A';
    /** ꠛ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_BO = '\uA81B';
    /** ꠜ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_BHO = '\uA81C';
    /** ꠝ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_MO = '\uA81D';
    /** ꠞ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_RO = '\uA81E';
    /** ꠟ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_LO = '\uA81F';
    /** ꠠ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_RRO = '\uA820';
    /** ꠡ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_SO = '\uA821';
    /** ꠢ of type OTHER_LETTER */
    char SYLOTI_NAGRI_LETTER_HO = '\uA822';
    /** ꠣ of type COMBINING_SPACING_MARK */
    char SYLOTI_NAGRI_VOWEL_SIGN_A = '\uA823';
    /** ꠤ of type COMBINING_SPACING_MARK */
    char SYLOTI_NAGRI_VOWEL_SIGN_I = '\uA824';
    /** ꠥ of type NON_SPACING_MARK */
    char SYLOTI_NAGRI_VOWEL_SIGN_U = '\uA825';
    /** ꠦ of type NON_SPACING_MARK */
    char SYLOTI_NAGRI_VOWEL_SIGN_E = '\uA826';
    /** ꠧ of type COMBINING_SPACING_MARK */
    char SYLOTI_NAGRI_VOWEL_SIGN_OO = '\uA827';
    /** ꠨ of type OTHER_SYMBOL */
    char SYLOTI_NAGRI_POETRY_MARK_1 = '\uA828';
    /** ꠩ of type OTHER_SYMBOL */
    char SYLOTI_NAGRI_POETRY_MARK_2 = '\uA829';
    /** ꠪ of type OTHER_SYMBOL */
    char SYLOTI_NAGRI_POETRY_MARK_3 = '\uA82A';
    /** ꠫ of type OTHER_SYMBOL */
    char SYLOTI_NAGRI_POETRY_MARK_4 = '\uA82B';
    /** ꠰ of type OTHER_NUMBER */
    char NORTH_INDIC_FRACTION_ONE_QUARTER = '\uA830';
    /** ꠱ of type OTHER_NUMBER */
    char NORTH_INDIC_FRACTION_ONE_HALF = '\uA831';
    /** ꠲ of type OTHER_NUMBER */
    char NORTH_INDIC_FRACTION_THREE_QUARTERS = '\uA832';
    /** ꠳ of type OTHER_NUMBER */
    char NORTH_INDIC_FRACTION_ONE_SIXTEENTH = '\uA833';
    /** ꠴ of type OTHER_NUMBER */
    char NORTH_INDIC_FRACTION_ONE_EIGHTH = '\uA834';
    /** ꠵ of type OTHER_NUMBER */
    char NORTH_INDIC_FRACTION_THREE_SIXTEENTHS = '\uA835';
    /** ꠶ of type OTHER_SYMBOL */
    char NORTH_INDIC_QUARTER_MARK = '\uA836';
    /** ꠷ of type OTHER_SYMBOL */
    char NORTH_INDIC_PLACEHOLDER_MARK = '\uA837';
    /** ꠸ of type CURRENCY_SYMBOL */
    char NORTH_INDIC_RUPEE_MARK = '\uA838';
    /** ꠹ of type OTHER_SYMBOL */
    char NORTH_INDIC_QUANTITY_MARK = '\uA839';
    /** ꡀ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_KA = '\uA840';
    /** ꡁ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_KHA = '\uA841';
    /** ꡂ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_GA = '\uA842';
    /** ꡃ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_NGA = '\uA843';
    /** ꡄ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_CA = '\uA844';
    /** ꡅ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_CHA = '\uA845';
    /** ꡆ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_JA = '\uA846';
    /** ꡇ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_NYA = '\uA847';
    /** ꡈ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_TA = '\uA848';
    /** ꡉ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_THA = '\uA849';
    /** ꡊ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_DA = '\uA84A';
    /** ꡋ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_NA = '\uA84B';
    /** ꡌ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_PA = '\uA84C';
    /** ꡍ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_PHA = '\uA84D';
    /** ꡎ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_BA = '\uA84E';
    /** ꡏ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_MA = '\uA84F';
    /** ꡐ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_TSA = '\uA850';
    /** ꡑ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_TSHA = '\uA851';
    /** ꡒ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_DZA = '\uA852';
    /** ꡓ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_WA = '\uA853';
    /** ꡔ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_ZHA = '\uA854';
    /** ꡕ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_ZA = '\uA855';
    /** ꡖ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_SMALL_A = '\uA856';
    /** ꡗ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_YA = '\uA857';
    /** ꡘ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_RA = '\uA858';
    /** ꡙ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_LA = '\uA859';
    /** ꡚ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_SHA = '\uA85A';
    /** ꡛ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_SA = '\uA85B';
    /** ꡜ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_HA = '\uA85C';
    /** ꡝ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_A = '\uA85D';
    /** ꡞ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_I = '\uA85E';
    /** ꡟ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_U = '\uA85F';
    /** ꡠ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_E = '\uA860';
    /** ꡡ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_O = '\uA861';
    /** ꡢ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_QA = '\uA862';
    /** ꡣ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_XA = '\uA863';
    /** ꡤ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_FA = '\uA864';
    /** ꡥ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_GGA = '\uA865';
    /** ꡦ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_EE = '\uA866';
    /** ꡧ of type OTHER_LETTER */
    char PHAGS_PA_SUBJOINED_LETTER_WA = '\uA867';
    /** ꡨ of type OTHER_LETTER */
    char PHAGS_PA_SUBJOINED_LETTER_YA = '\uA868';
    /** ꡩ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_TTA = '\uA869';
    /** ꡪ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_TTHA = '\uA86A';
    /** ꡫ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_DDA = '\uA86B';
    /** ꡬ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_NNA = '\uA86C';
    /** ꡭ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_ALTERNATE_YA = '\uA86D';
    /** ꡮ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_VOICELESS_SHA = '\uA86E';
    /** ꡯ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_VOICED_HA = '\uA86F';
    /** ꡰ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_ASPIRATED_FA = '\uA870';
    /** ꡱ of type OTHER_LETTER */
    char PHAGS_PA_SUBJOINED_LETTER_RA = '\uA871';
    /** ꡲ of type OTHER_LETTER */
    char PHAGS_PA_SUPERFIXED_LETTER_RA = '\uA872';
    /** ꡳ of type OTHER_LETTER */
    char PHAGS_PA_LETTER_CANDRABINDU = '\uA873';
    /** ꡴ of type OTHER_PUNCTUATION */
    char PHAGS_PA_SINGLE_HEAD_MARK = '\uA874';
    /** ꡵ of type OTHER_PUNCTUATION */
    char PHAGS_PA_DOUBLE_HEAD_MARK = '\uA875';
    /** ꡶ of type OTHER_PUNCTUATION */
    char PHAGS_PA_MARK_SHAD = '\uA876';
    /** ꡷ of type OTHER_PUNCTUATION */
    char PHAGS_PA_MARK_DOUBLE_SHAD = '\uA877';
    /** ꢀ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_SIGN_ANUSVARA = '\uA880';
    /** ꢁ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_SIGN_VISARGA = '\uA881';
    /** ꢂ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_A = '\uA882';
    /** ꢃ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_AA = '\uA883';
    /** ꢄ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_I = '\uA884';
    /** ꢅ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_II = '\uA885';
    /** ꢆ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_U = '\uA886';
    /** ꢇ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_UU = '\uA887';
    /** ꢈ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_VOCALIC_R = '\uA888';
    /** ꢉ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_VOCALIC_RR = '\uA889';
    /** ꢊ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_VOCALIC_L = '\uA88A';
    /** ꢋ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_VOCALIC_LL = '\uA88B';
    /** ꢌ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_E = '\uA88C';
    /** ꢍ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_EE = '\uA88D';
    /** ꢎ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_AI = '\uA88E';
    /** ꢏ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_O = '\uA88F';
    /** ꢐ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_OO = '\uA890';
    /** ꢑ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_AU = '\uA891';
    /** ꢒ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_KA = '\uA892';
    /** ꢓ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_KHA = '\uA893';
    /** ꢔ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_GA = '\uA894';
    /** ꢕ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_GHA = '\uA895';
    /** ꢖ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_NGA = '\uA896';
    /** ꢗ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_CA = '\uA897';
    /** ꢘ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_CHA = '\uA898';
    /** ꢙ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_JA = '\uA899';
    /** ꢚ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_JHA = '\uA89A';
    /** ꢛ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_NYA = '\uA89B';
    /** ꢜ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_TTA = '\uA89C';
    /** ꢝ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_TTHA = '\uA89D';
    /** ꢞ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_DDA = '\uA89E';
    /** ꢟ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_DDHA = '\uA89F';
    /** ꢠ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_NNA = '\uA8A0';
    /** ꢡ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_TA = '\uA8A1';
    /** ꢢ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_THA = '\uA8A2';
    /** ꢣ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_DA = '\uA8A3';
    /** ꢤ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_DHA = '\uA8A4';
    /** ꢥ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_NA = '\uA8A5';
    /** ꢦ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_PA = '\uA8A6';
    /** ꢧ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_PHA = '\uA8A7';
    /** ꢨ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_BA = '\uA8A8';
    /** ꢩ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_BHA = '\uA8A9';
    /** ꢪ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_MA = '\uA8AA';
    /** ꢫ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_YA = '\uA8AB';
    /** ꢬ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_RA = '\uA8AC';
    /** ꢭ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_LA = '\uA8AD';
    /** ꢮ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_VA = '\uA8AE';
    /** ꢯ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_SHA = '\uA8AF';
    /** ꢰ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_SSA = '\uA8B0';
    /** ꢱ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_SA = '\uA8B1';
    /** ꢲ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_HA = '\uA8B2';
    /** ꢳ of type OTHER_LETTER */
    char SAURASHTRA_LETTER_LLA = '\uA8B3';
    /** ꢴ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_CONSONANT_SIGN_HAARU = '\uA8B4';
    /** ꢵ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_AA = '\uA8B5';
    /** ꢶ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_I = '\uA8B6';
    /** ꢷ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_II = '\uA8B7';
    /** ꢸ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_U = '\uA8B8';
    /** ꢹ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_UU = '\uA8B9';
    /** ꢺ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_VOCALIC_R = '\uA8BA';
    /** ꢻ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_VOCALIC_RR = '\uA8BB';
    /** ꢼ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_VOCALIC_L = '\uA8BC';
    /** ꢽ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_VOCALIC_LL = '\uA8BD';
    /** ꢾ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_E = '\uA8BE';
    /** ꢿ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_EE = '\uA8BF';
    /** ꣀ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_AI = '\uA8C0';
    /** ꣁ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_O = '\uA8C1';
    /** ꣂ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_OO = '\uA8C2';
    /** ꣃ of type COMBINING_SPACING_MARK */
    char SAURASHTRA_VOWEL_SIGN_AU = '\uA8C3';
    /** ꣄ of type NON_SPACING_MARK */
    char SAURASHTRA_SIGN_VIRAMA = '\uA8C4';
    /** ꣎ of type OTHER_PUNCTUATION */
    char SAURASHTRA_DANDA = '\uA8CE';
    /** ꣏ of type OTHER_PUNCTUATION */
    char SAURASHTRA_DOUBLE_DANDA = '\uA8CF';
    /** ꣐ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_ZERO = '\uA8D0';
    /** ꣑ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_ONE = '\uA8D1';
    /** ꣒ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_TWO = '\uA8D2';
    /** ꣓ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_THREE = '\uA8D3';
    /** ꣔ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_FOUR = '\uA8D4';
    /** ꣕ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_FIVE = '\uA8D5';
    /** ꣖ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_SIX = '\uA8D6';
    /** ꣗ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_SEVEN = '\uA8D7';
    /** ꣘ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_EIGHT = '\uA8D8';
    /** ꣙ of type DECIMAL_DIGIT_NUMBER */
    char SAURASHTRA_DIGIT_NINE = '\uA8D9';
    /** ꤀ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_ZERO = '\uA900';
    /** ꤁ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_ONE = '\uA901';
    /** ꤂ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_TWO = '\uA902';
    /** ꤃ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_THREE = '\uA903';
    /** ꤄ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_FOUR = '\uA904';
    /** ꤅ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_FIVE = '\uA905';
    /** ꤆ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_SIX = '\uA906';
    /** ꤇ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_SEVEN = '\uA907';
    /** ꤈ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_EIGHT = '\uA908';
    /** ꤉ of type DECIMAL_DIGIT_NUMBER */
    char KAYAH_LI_DIGIT_NINE = '\uA909';
    /** ꤊ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_KA = '\uA90A';
    /** ꤋ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_KHA = '\uA90B';
    /** ꤌ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_GA = '\uA90C';
    /** ꤍ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_NGA = '\uA90D';
    /** ꤎ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_SA = '\uA90E';
    /** ꤏ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_SHA = '\uA90F';
    /** ꤐ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_ZA = '\uA910';
    /** ꤑ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_NYA = '\uA911';
    /** ꤒ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_TA = '\uA912';
    /** ꤓ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_HTA = '\uA913';
    /** ꤔ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_NA = '\uA914';
    /** ꤕ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_PA = '\uA915';
    /** ꤖ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_PHA = '\uA916';
    /** ꤗ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_MA = '\uA917';
    /** ꤘ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_DA = '\uA918';
    /** ꤙ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_BA = '\uA919';
    /** ꤚ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_RA = '\uA91A';
    /** ꤛ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_YA = '\uA91B';
    /** ꤜ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_LA = '\uA91C';
    /** ꤝ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_WA = '\uA91D';
    /** ꤞ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_THA = '\uA91E';
    /** ꤟ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_HA = '\uA91F';
    /** ꤠ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_VA = '\uA920';
    /** ꤡ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_CA = '\uA921';
    /** ꤢ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_A = '\uA922';
    /** ꤣ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_OE = '\uA923';
    /** ꤤ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_I = '\uA924';
    /** ꤥ of type OTHER_LETTER */
    char KAYAH_LI_LETTER_OO = '\uA925';
    /** ꤦ of type NON_SPACING_MARK */
    char KAYAH_LI_VOWEL_UE = '\uA926';
    /** ꤧ of type NON_SPACING_MARK */
    char KAYAH_LI_VOWEL_E = '\uA927';
    /** ꤨ of type NON_SPACING_MARK */
    char KAYAH_LI_VOWEL_U = '\uA928';
    /** ꤩ of type NON_SPACING_MARK */
    char KAYAH_LI_VOWEL_EE = '\uA929';
    /** ꤪ of type NON_SPACING_MARK */
    char KAYAH_LI_VOWEL_O = '\uA92A';
    /** ꤫ of type NON_SPACING_MARK */
    char KAYAH_LI_TONE_PLOPHU = '\uA92B';
    /** ꤬ of type NON_SPACING_MARK */
    char KAYAH_LI_TONE_CALYA = '\uA92C';
    /** ꤭ of type NON_SPACING_MARK */
    char KAYAH_LI_TONE_CALYA_PLOPHU = '\uA92D';
    /** ꤮ of type OTHER_PUNCTUATION */
    char KAYAH_LI_SIGN_CWI = '\uA92E';
    /** ꤯ of type OTHER_PUNCTUATION */
    char KAYAH_LI_SIGN_SHYA = '\uA92F';
    /** ꤰ of type OTHER_LETTER */
    char REJANG_LETTER_KA = '\uA930';
    /** ꤱ of type OTHER_LETTER */
    char REJANG_LETTER_GA = '\uA931';
    /** ꤲ of type OTHER_LETTER */
    char REJANG_LETTER_NGA = '\uA932';
    /** ꤳ of type OTHER_LETTER */
    char REJANG_LETTER_TA = '\uA933';
    /** ꤴ of type OTHER_LETTER */
    char REJANG_LETTER_DA = '\uA934';
    /** ꤵ of type OTHER_LETTER */
    char REJANG_LETTER_NA = '\uA935';
    /** ꤶ of type OTHER_LETTER */
    char REJANG_LETTER_PA = '\uA936';
    /** ꤷ of type OTHER_LETTER */
    char REJANG_LETTER_BA = '\uA937';
    /** ꤸ of type OTHER_LETTER */
    char REJANG_LETTER_MA = '\uA938';
    /** ꤹ of type OTHER_LETTER */
    char REJANG_LETTER_CA = '\uA939';
    /** ꤺ of type OTHER_LETTER */
    char REJANG_LETTER_JA = '\uA93A';
    /** ꤻ of type OTHER_LETTER */
    char REJANG_LETTER_NYA = '\uA93B';
    /** ꤼ of type OTHER_LETTER */
    char REJANG_LETTER_SA = '\uA93C';
    /** ꤽ of type OTHER_LETTER */
    char REJANG_LETTER_RA = '\uA93D';
    /** ꤾ of type OTHER_LETTER */
    char REJANG_LETTER_LA = '\uA93E';
    /** ꤿ of type OTHER_LETTER */
    char REJANG_LETTER_YA = '\uA93F';
    /** ꥀ of type OTHER_LETTER */
    char REJANG_LETTER_WA = '\uA940';
    /** ꥁ of type OTHER_LETTER */
    char REJANG_LETTER_HA = '\uA941';
    /** ꥂ of type OTHER_LETTER */
    char REJANG_LETTER_MBA = '\uA942';
    /** ꥃ of type OTHER_LETTER */
    char REJANG_LETTER_NGGA = '\uA943';
    /** ꥄ of type OTHER_LETTER */
    char REJANG_LETTER_NDA = '\uA944';
    /** ꥅ of type OTHER_LETTER */
    char REJANG_LETTER_NYJA = '\uA945';
    /** ꥆ of type OTHER_LETTER */
    char REJANG_LETTER_A = '\uA946';
    /** ꥇ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_I = '\uA947';
    /** ꥈ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_U = '\uA948';
    /** ꥉ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_E = '\uA949';
    /** ꥊ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_AI = '\uA94A';
    /** ꥋ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_O = '\uA94B';
    /** ꥌ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_AU = '\uA94C';
    /** ꥍ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_EU = '\uA94D';
    /** ꥎ of type NON_SPACING_MARK */
    char REJANG_VOWEL_SIGN_EA = '\uA94E';
    /** ꥏ of type NON_SPACING_MARK */
    char REJANG_CONSONANT_SIGN_NG = '\uA94F';
    /** ꥐ of type NON_SPACING_MARK */
    char REJANG_CONSONANT_SIGN_N = '\uA950';
    /** ꥑ of type NON_SPACING_MARK */
    char REJANG_CONSONANT_SIGN_R = '\uA951';
    /** ꥒ of type COMBINING_SPACING_MARK */
    char REJANG_CONSONANT_SIGN_H = '\uA952';
    /** ꥓ of type COMBINING_SPACING_MARK */
    char REJANG_VIRAMA = '\uA953';
    /** ꥟ of type OTHER_PUNCTUATION */
    char REJANG_SECTION_MARK = '\uA95F';
    /** ꦀ of type NON_SPACING_MARK */
    char JAVANESE_SIGN_PANYANGGA = '\uA980';
    /** ꦁ of type NON_SPACING_MARK */
    char JAVANESE_SIGN_CECAK = '\uA981';
    /** ꦂ of type NON_SPACING_MARK */
    char JAVANESE_SIGN_LAYAR = '\uA982';
    /** ꦃ of type COMBINING_SPACING_MARK */
    char JAVANESE_SIGN_WIGNYAN = '\uA983';
    /** ꦄ of type OTHER_LETTER */
    char JAVANESE_LETTER_A = '\uA984';
    /** ꦅ of type OTHER_LETTER */
    char JAVANESE_LETTER_I_KAWI = '\uA985';
    /** ꦆ of type OTHER_LETTER */
    char JAVANESE_LETTER_I = '\uA986';
    /** ꦇ of type OTHER_LETTER */
    char JAVANESE_LETTER_II = '\uA987';
    /** ꦈ of type OTHER_LETTER */
    char JAVANESE_LETTER_U = '\uA988';
    /** ꦉ of type OTHER_LETTER */
    char JAVANESE_LETTER_PA_CEREK = '\uA989';
    /** ꦊ of type OTHER_LETTER */
    char JAVANESE_LETTER_NGA_LELET = '\uA98A';
    /** ꦋ of type OTHER_LETTER */
    char JAVANESE_LETTER_NGA_LELET_RASWADI = '\uA98B';
    /** ꦌ of type OTHER_LETTER */
    char JAVANESE_LETTER_E = '\uA98C';
    /** ꦍ of type OTHER_LETTER */
    char JAVANESE_LETTER_AI = '\uA98D';
    /** ꦎ of type OTHER_LETTER */
    char JAVANESE_LETTER_O = '\uA98E';
    /** ꦏ of type OTHER_LETTER */
    char JAVANESE_LETTER_KA = '\uA98F';
    /** ꦐ of type OTHER_LETTER */
    char JAVANESE_LETTER_KA_SASAK = '\uA990';
    /** ꦑ of type OTHER_LETTER */
    char JAVANESE_LETTER_KA_MURDA = '\uA991';
    /** ꦒ of type OTHER_LETTER */
    char JAVANESE_LETTER_GA = '\uA992';
    /** ꦓ of type OTHER_LETTER */
    char JAVANESE_LETTER_GA_MURDA = '\uA993';
    /** ꦔ of type OTHER_LETTER */
    char JAVANESE_LETTER_NGA = '\uA994';
    /** ꦕ of type OTHER_LETTER */
    char JAVANESE_LETTER_CA = '\uA995';
    /** ꦖ of type OTHER_LETTER */
    char JAVANESE_LETTER_CA_MURDA = '\uA996';
    /** ꦗ of type OTHER_LETTER */
    char JAVANESE_LETTER_JA = '\uA997';
    /** ꦘ of type OTHER_LETTER */
    char JAVANESE_LETTER_NYA_MURDA = '\uA998';
    /** ꦙ of type OTHER_LETTER */
    char JAVANESE_LETTER_JA_MAHAPRANA = '\uA999';
    /** ꦚ of type OTHER_LETTER */
    char JAVANESE_LETTER_NYA = '\uA99A';
    /** ꦛ of type OTHER_LETTER */
    char JAVANESE_LETTER_TTA = '\uA99B';
    /** ꦜ of type OTHER_LETTER */
    char JAVANESE_LETTER_TTA_MAHAPRANA = '\uA99C';
    /** ꦝ of type OTHER_LETTER */
    char JAVANESE_LETTER_DDA = '\uA99D';
    /** ꦞ of type OTHER_LETTER */
    char JAVANESE_LETTER_DDA_MAHAPRANA = '\uA99E';
    /** ꦟ of type OTHER_LETTER */
    char JAVANESE_LETTER_NA_MURDA = '\uA99F';
    /** ꦠ of type OTHER_LETTER */
    char JAVANESE_LETTER_TA = '\uA9A0';
    /** ꦡ of type OTHER_LETTER */
    char JAVANESE_LETTER_TA_MURDA = '\uA9A1';
    /** ꦢ of type OTHER_LETTER */
    char JAVANESE_LETTER_DA = '\uA9A2';
    /** ꦣ of type OTHER_LETTER */
    char JAVANESE_LETTER_DA_MAHAPRANA = '\uA9A3';
    /** ꦤ of type OTHER_LETTER */
    char JAVANESE_LETTER_NA = '\uA9A4';
    /** ꦥ of type OTHER_LETTER */
    char JAVANESE_LETTER_PA = '\uA9A5';
    /** ꦦ of type OTHER_LETTER */
    char JAVANESE_LETTER_PA_MURDA = '\uA9A6';
    /** ꦧ of type OTHER_LETTER */
    char JAVANESE_LETTER_BA = '\uA9A7';
    /** ꦨ of type OTHER_LETTER */
    char JAVANESE_LETTER_BA_MURDA = '\uA9A8';
    /** ꦩ of type OTHER_LETTER */
    char JAVANESE_LETTER_MA = '\uA9A9';
    /** ꦪ of type OTHER_LETTER */
    char JAVANESE_LETTER_YA = '\uA9AA';
    /** ꦫ of type OTHER_LETTER */
    char JAVANESE_LETTER_RA = '\uA9AB';
    /** ꦬ of type OTHER_LETTER */
    char JAVANESE_LETTER_RA_AGUNG = '\uA9AC';
    /** ꦭ of type OTHER_LETTER */
    char JAVANESE_LETTER_LA = '\uA9AD';
    /** ꦮ of type OTHER_LETTER */
    char JAVANESE_LETTER_WA = '\uA9AE';
    /** ꦯ of type OTHER_LETTER */
    char JAVANESE_LETTER_SA_MURDA = '\uA9AF';
    /** ꦰ of type OTHER_LETTER */
    char JAVANESE_LETTER_SA_MAHAPRANA = '\uA9B0';
    /** ꦱ of type OTHER_LETTER */
    char JAVANESE_LETTER_SA = '\uA9B1';
    /** ꦲ of type OTHER_LETTER */
    char JAVANESE_LETTER_HA = '\uA9B2';
    /** ꦳ of type NON_SPACING_MARK */
    char JAVANESE_SIGN_CECAK_TELU = '\uA9B3';
    /** ꦴ of type COMBINING_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_TARUNG = '\uA9B4';
    /** ꦵ of type COMBINING_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_TOLONG = '\uA9B5';
    /** ꦶ of type NON_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_WULU = '\uA9B6';
    /** ꦷ of type NON_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_WULU_MELIK = '\uA9B7';
    /** ꦸ of type NON_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_SUKU = '\uA9B8';
    /** ꦹ of type NON_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_SUKU_MENDUT = '\uA9B9';
    /** ꦺ of type COMBINING_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_TALING = '\uA9BA';
    /** ꦻ of type COMBINING_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_DIRGA_MURE = '\uA9BB';
    /** ꦼ of type NON_SPACING_MARK */
    char JAVANESE_VOWEL_SIGN_PEPET = '\uA9BC';
    /** ꦽ of type COMBINING_SPACING_MARK */
    char JAVANESE_CONSONANT_SIGN_KERET = '\uA9BD';
    /** ꦾ of type COMBINING_SPACING_MARK */
    char JAVANESE_CONSONANT_SIGN_PENGKAL = '\uA9BE';
    /** ꦿ of type COMBINING_SPACING_MARK */
    char JAVANESE_CONSONANT_SIGN_CAKRA = '\uA9BF';
    /** ꧀ of type COMBINING_SPACING_MARK */
    char JAVANESE_PANGKON = '\uA9C0';
    /** ꧁ of type OTHER_PUNCTUATION */
    char JAVANESE_LEFT_RERENGGAN = '\uA9C1';
    /** ꧂ of type OTHER_PUNCTUATION */
    char JAVANESE_RIGHT_RERENGGAN = '\uA9C2';
    /** ꧃ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_ANDAP = '\uA9C3';
    /** ꧄ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_MADYA = '\uA9C4';
    /** ꧅ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_LUHUR = '\uA9C5';
    /** ꧆ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_WINDU = '\uA9C6';
    /** ꧇ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_PANGKAT = '\uA9C7';
    /** ꧈ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_LINGSA = '\uA9C8';
    /** ꧉ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_LUNGSI = '\uA9C9';
    /** ꧊ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_ADEG = '\uA9CA';
    /** ꧋ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_ADEG_ADEG = '\uA9CB';
    /** ꧌ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_PISELEH = '\uA9CC';
    /** ꧍ of type OTHER_PUNCTUATION */
    char JAVANESE_TURNED_PADA_PISELEH = '\uA9CD';
    /** ꧏ of type MODIFIER_LETTER */
    char JAVANESE_PANGRANGKEP = '\uA9CF';
    /** ꧐ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_ZERO = '\uA9D0';
    /** ꧑ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_ONE = '\uA9D1';
    /** ꧒ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_TWO = '\uA9D2';
    /** ꧓ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_THREE = '\uA9D3';
    /** ꧔ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_FOUR = '\uA9D4';
    /** ꧕ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_FIVE = '\uA9D5';
    /** ꧖ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_SIX = '\uA9D6';
    /** ꧗ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_SEVEN = '\uA9D7';
    /** ꧘ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_EIGHT = '\uA9D8';
    /** ꧙ of type DECIMAL_DIGIT_NUMBER */
    char JAVANESE_DIGIT_NINE = '\uA9D9';
    /** ꧞ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_TIRTA_TUMETES = '\uA9DE';
    /** ꧟ of type OTHER_PUNCTUATION */
    char JAVANESE_PADA_ISEN_ISEN = '\uA9DF';
    /** ꨀ of type OTHER_LETTER */
    char CHAM_LETTER_A = '\uAA00';
    /** ꨁ of type OTHER_LETTER */
    char CHAM_LETTER_I = '\uAA01';
    /** ꨂ of type OTHER_LETTER */
    char CHAM_LETTER_U = '\uAA02';
    /** ꨃ of type OTHER_LETTER */
    char CHAM_LETTER_E = '\uAA03';
    /** ꨄ of type OTHER_LETTER */
    char CHAM_LETTER_AI = '\uAA04';
    /** ꨅ of type OTHER_LETTER */
    char CHAM_LETTER_O = '\uAA05';
    /** ꨆ of type OTHER_LETTER */
    char CHAM_LETTER_KA = '\uAA06';
    /** ꨇ of type OTHER_LETTER */
    char CHAM_LETTER_KHA = '\uAA07';
    /** ꨈ of type OTHER_LETTER */
    char CHAM_LETTER_GA = '\uAA08';
    /** ꨉ of type OTHER_LETTER */
    char CHAM_LETTER_GHA = '\uAA09';
    /** ꨊ of type OTHER_LETTER */
    char CHAM_LETTER_NGUE = '\uAA0A';
    /** ꨋ of type OTHER_LETTER */
    char CHAM_LETTER_NGA = '\uAA0B';
    /** ꨌ of type OTHER_LETTER */
    char CHAM_LETTER_CHA = '\uAA0C';
    /** ꨍ of type OTHER_LETTER */
    char CHAM_LETTER_CHHA = '\uAA0D';
    /** ꨎ of type OTHER_LETTER */
    char CHAM_LETTER_JA = '\uAA0E';
    /** ꨏ of type OTHER_LETTER */
    char CHAM_LETTER_JHA = '\uAA0F';
    /** ꨐ of type OTHER_LETTER */
    char CHAM_LETTER_NHUE = '\uAA10';
    /** ꨑ of type OTHER_LETTER */
    char CHAM_LETTER_NHA = '\uAA11';
    /** ꨒ of type OTHER_LETTER */
    char CHAM_LETTER_NHJA = '\uAA12';
    /** ꨓ of type OTHER_LETTER */
    char CHAM_LETTER_TA = '\uAA13';
    /** ꨔ of type OTHER_LETTER */
    char CHAM_LETTER_THA = '\uAA14';
    /** ꨕ of type OTHER_LETTER */
    char CHAM_LETTER_DA = '\uAA15';
    /** ꨖ of type OTHER_LETTER */
    char CHAM_LETTER_DHA = '\uAA16';
    /** ꨗ of type OTHER_LETTER */
    char CHAM_LETTER_NUE = '\uAA17';
    /** ꨘ of type OTHER_LETTER */
    char CHAM_LETTER_NA = '\uAA18';
    /** ꨙ of type OTHER_LETTER */
    char CHAM_LETTER_DDA = '\uAA19';
    /** ꨚ of type OTHER_LETTER */
    char CHAM_LETTER_PA = '\uAA1A';
    /** ꨛ of type OTHER_LETTER */
    char CHAM_LETTER_PPA = '\uAA1B';
    /** ꨜ of type OTHER_LETTER */
    char CHAM_LETTER_PHA = '\uAA1C';
    /** ꨝ of type OTHER_LETTER */
    char CHAM_LETTER_BA = '\uAA1D';
    /** ꨞ of type OTHER_LETTER */
    char CHAM_LETTER_BHA = '\uAA1E';
    /** ꨟ of type OTHER_LETTER */
    char CHAM_LETTER_MUE = '\uAA1F';
    /** ꨠ of type OTHER_LETTER */
    char CHAM_LETTER_MA = '\uAA20';
    /** ꨡ of type OTHER_LETTER */
    char CHAM_LETTER_BBA = '\uAA21';
    /** ꨢ of type OTHER_LETTER */
    char CHAM_LETTER_YA = '\uAA22';
    /** ꨣ of type OTHER_LETTER */
    char CHAM_LETTER_RA = '\uAA23';
    /** ꨤ of type OTHER_LETTER */
    char CHAM_LETTER_LA = '\uAA24';
    /** ꨥ of type OTHER_LETTER */
    char CHAM_LETTER_VA = '\uAA25';
    /** ꨦ of type OTHER_LETTER */
    char CHAM_LETTER_SSA = '\uAA26';
    /** ꨧ of type OTHER_LETTER */
    char CHAM_LETTER_SA = '\uAA27';
    /** ꨨ of type OTHER_LETTER */
    char CHAM_LETTER_HA = '\uAA28';
    /** ꨩ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_AA = '\uAA29';
    /** ꨪ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_I = '\uAA2A';
    /** ꨫ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_II = '\uAA2B';
    /** ꨬ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_EI = '\uAA2C';
    /** ꨭ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_U = '\uAA2D';
    /** ꨮ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_OE = '\uAA2E';
    /** ꨯ of type COMBINING_SPACING_MARK */
    char CHAM_VOWEL_SIGN_O = '\uAA2F';
    /** ꨰ of type COMBINING_SPACING_MARK */
    char CHAM_VOWEL_SIGN_AI = '\uAA30';
    /** ꨱ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_AU = '\uAA31';
    /** ꨲ of type NON_SPACING_MARK */
    char CHAM_VOWEL_SIGN_UE = '\uAA32';
    /** ꨳ of type COMBINING_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_YA = '\uAA33';
    /** ꨴ of type COMBINING_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_RA = '\uAA34';
    /** ꨵ of type NON_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_LA = '\uAA35';
    /** ꨶ of type NON_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_WA = '\uAA36';
    /** ꩀ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_K = '\uAA40';
    /** ꩁ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_G = '\uAA41';
    /** ꩂ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_NG = '\uAA42';
    /** ꩃ of type NON_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_FINAL_NG = '\uAA43';
    /** ꩄ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_CH = '\uAA44';
    /** ꩅ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_T = '\uAA45';
    /** ꩆ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_N = '\uAA46';
    /** ꩇ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_P = '\uAA47';
    /** ꩈ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_Y = '\uAA48';
    /** ꩉ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_R = '\uAA49';
    /** ꩊ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_L = '\uAA4A';
    /** ꩋ of type OTHER_LETTER */
    char CHAM_LETTER_FINAL_SS = '\uAA4B';
    /** ꩌ of type NON_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_FINAL_M = '\uAA4C';
    /** ꩍ of type COMBINING_SPACING_MARK */
    char CHAM_CONSONANT_SIGN_FINAL_H = '\uAA4D';
    /** ꩐ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_ZERO = '\uAA50';
    /** ꩑ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_ONE = '\uAA51';
    /** ꩒ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_TWO = '\uAA52';
    /** ꩓ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_THREE = '\uAA53';
    /** ꩔ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_FOUR = '\uAA54';
    /** ꩕ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_FIVE = '\uAA55';
    /** ꩖ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_SIX = '\uAA56';
    /** ꩗ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_SEVEN = '\uAA57';
    /** ꩘ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_EIGHT = '\uAA58';
    /** ꩙ of type DECIMAL_DIGIT_NUMBER */
    char CHAM_DIGIT_NINE = '\uAA59';
    /** ꩜ of type OTHER_PUNCTUATION */
    char CHAM_PUNCTUATION_SPIRAL = '\uAA5C';
    /** ꩝ of type OTHER_PUNCTUATION */
    char CHAM_PUNCTUATION_DANDA = '\uAA5D';
    /** ꩞ of type OTHER_PUNCTUATION */
    char CHAM_PUNCTUATION_DOUBLE_DANDA = '\uAA5E';
    /** ꩟ of type OTHER_PUNCTUATION */
    char CHAM_PUNCTUATION_TRIPLE_DANDA = '\uAA5F';
    /** ﬓ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LIGATURE_MEN_NOW = '\uFB13';
    /** ﬔ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LIGATURE_MEN_ECH = '\uFB14';
    /** ﬕ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LIGATURE_MEN_INI = '\uFB15';
    /** ﬖ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LIGATURE_VEW_NOW = '\uFB16';
    /** ﬗ of type LOWERCASE_LETTER */
    char ARMENIAN_SMALL_LIGATURE_MEN_XEH = '\uFB17';
    /** יִ of type OTHER_LETTER */
    char HEBREW_LETTER_YOD_WITH_HIRIQ = '\uFB1D';
    /** ﬞ of type NON_SPACING_MARK */
    char HEBREW_POINT_JUDEO_SPANISH_VARIKA = '\uFB1E';
    /** ײַ of type OTHER_LETTER */
    char HEBREW_LIGATURE_YIDDISH_YOD_YOD_PATAH = '\uFB1F';
    /** ﬠ of type OTHER_LETTER */
    char HEBREW_LETTER_ALTERNATIVE_AYIN = '\uFB20';
    /** ﬡ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_ALEF = '\uFB21';
    /** ﬢ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_DALET = '\uFB22';
    /** ﬣ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_HE = '\uFB23';
    /** ﬤ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_KAF = '\uFB24';
    /** ﬥ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_LAMED = '\uFB25';
    /** ﬦ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_FINAL_MEM = '\uFB26';
    /** ﬧ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_RESH = '\uFB27';
    /** ﬨ of type OTHER_LETTER */
    char HEBREW_LETTER_WIDE_TAV = '\uFB28';
    /** ﬩ of type MATH_SYMBOL */
    char HEBREW_LETTER_ALTERNATIVE_PLUS_SIGN = '\uFB29';
    /** שׁ of type OTHER_LETTER */
    char HEBREW_LETTER_SHIN_WITH_SHIN_DOT = '\uFB2A';
    /** שׂ of type OTHER_LETTER */
    char HEBREW_LETTER_SHIN_WITH_SIN_DOT = '\uFB2B';
    /** שּׁ of type OTHER_LETTER */
    char HEBREW_LETTER_SHIN_WITH_DAGESH_AND_SHIN_DOT = '\uFB2C';
    /** שּׂ of type OTHER_LETTER */
    char HEBREW_LETTER_SHIN_WITH_DAGESH_AND_SIN_DOT = '\uFB2D';
    /** אַ of type OTHER_LETTER */
    char HEBREW_LETTER_ALEF_WITH_PATAH = '\uFB2E';
    /** אָ of type OTHER_LETTER */
    char HEBREW_LETTER_ALEF_WITH_QAMATS = '\uFB2F';
    /** אּ of type OTHER_LETTER */
    char HEBREW_LETTER_ALEF_WITH_MAPIQ = '\uFB30';
    /** בּ of type OTHER_LETTER */
    char HEBREW_LETTER_BET_WITH_DAGESH = '\uFB31';
    /** גּ of type OTHER_LETTER */
    char HEBREW_LETTER_GIMEL_WITH_DAGESH = '\uFB32';
    /** דּ of type OTHER_LETTER */
    char HEBREW_LETTER_DALET_WITH_DAGESH = '\uFB33';
    /** הּ of type OTHER_LETTER */
    char HEBREW_LETTER_HE_WITH_MAPIQ = '\uFB34';
    /** וּ of type OTHER_LETTER */
    char HEBREW_LETTER_VAV_WITH_DAGESH = '\uFB35';
    /** זּ of type OTHER_LETTER */
    char HEBREW_LETTER_ZAYIN_WITH_DAGESH = '\uFB36';
    /** טּ of type OTHER_LETTER */
    char HEBREW_LETTER_TET_WITH_DAGESH = '\uFB38';
    /** יּ of type OTHER_LETTER */
    char HEBREW_LETTER_YOD_WITH_DAGESH = '\uFB39';
    /** ךּ of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_KAF_WITH_DAGESH = '\uFB3A';
    /** כּ of type OTHER_LETTER */
    char HEBREW_LETTER_KAF_WITH_DAGESH = '\uFB3B';
    /** לּ of type OTHER_LETTER */
    char HEBREW_LETTER_LAMED_WITH_DAGESH = '\uFB3C';
    /** מּ of type OTHER_LETTER */
    char HEBREW_LETTER_MEM_WITH_DAGESH = '\uFB3E';
    /** נּ of type OTHER_LETTER */
    char HEBREW_LETTER_NUN_WITH_DAGESH = '\uFB40';
    /** סּ of type OTHER_LETTER */
    char HEBREW_LETTER_SAMEKH_WITH_DAGESH = '\uFB41';
    /** ףּ of type OTHER_LETTER */
    char HEBREW_LETTER_FINAL_PE_WITH_DAGESH = '\uFB43';
    /** פּ of type OTHER_LETTER */
    char HEBREW_LETTER_PE_WITH_DAGESH = '\uFB44';
    /** צּ of type OTHER_LETTER */
    char HEBREW_LETTER_TSADI_WITH_DAGESH = '\uFB46';
    /** קּ of type OTHER_LETTER */
    char HEBREW_LETTER_QOF_WITH_DAGESH = '\uFB47';
    /** רּ of type OTHER_LETTER */
    char HEBREW_LETTER_RESH_WITH_DAGESH = '\uFB48';
    /** שּ of type OTHER_LETTER */
    char HEBREW_LETTER_SHIN_WITH_DAGESH = '\uFB49';
    /** תּ of type OTHER_LETTER */
    char HEBREW_LETTER_TAV_WITH_DAGESH = '\uFB4A';
    /** וֹ of type OTHER_LETTER */
    char HEBREW_LETTER_VAV_WITH_HOLAM = '\uFB4B';
    /** בֿ of type OTHER_LETTER */
    char HEBREW_LETTER_BET_WITH_RAFE = '\uFB4C';
    /** כֿ of type OTHER_LETTER */
    char HEBREW_LETTER_KAF_WITH_RAFE = '\uFB4D';
    /** פֿ of type OTHER_LETTER */
    char HEBREW_LETTER_PE_WITH_RAFE = '\uFB4E';
    /** ﭏ of type OTHER_LETTER */
    char HEBREW_LIGATURE_ALEF_LAMED = '\uFB4F';
    /** ﴾ of type START_PUNCTUATION */
    char ORNATE_LEFT_PARENTHESIS = '\uFD3E';
    /** ﴿ of type END_PUNCTUATION */
    char ORNATE_RIGHT_PARENTHESIS = '\uFD3F';
    /** ﷼ of type CURRENCY_SYMBOL */
    char RIAL_SIGN = '\uFDFC';
    /** ︐ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_COMMA = '\uFE10';
    /** ︑ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_IDEOGRAPHIC_COMMA = '\uFE11';
    /** ︒ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_IDEOGRAPHIC_FULL_STOP = '\uFE12';
    /** ︓ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_COLON = '\uFE13';
    /** ︔ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_SEMICOLON = '\uFE14';
    /** ︕ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_EXCLAMATION_MARK = '\uFE15';
    /** ︖ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_QUESTION_MARK = '\uFE16';
    /** ︗ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_WHITE_LENTICULAR_BRACKET = '\uFE17';
    /** ︘ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_WHITE_LENTICULAR_BRAKCET = '\uFE18';
    /** ︙ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_HORIZONTAL_ELLIPSIS = '\uFE19';
    /** ︰ of type OTHER_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_TWO_DOT_LEADER = '\uFE30';
    /** ︱ of type DASH_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_EM_DASH = '\uFE31';
    /** ︲ of type DASH_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_EN_DASH = '\uFE32';
    /** ︳ of type CONNECTOR_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LOW_LINE = '\uFE33';
    /** ︴ of type CONNECTOR_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_WAVY_LOW_LINE = '\uFE34';
    /** ︵ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_PARENTHESIS = '\uFE35';
    /** ︶ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_PARENTHESIS = '\uFE36';
    /** ︷ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_CURLY_BRACKET = '\uFE37';
    /** ︸ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_CURLY_BRACKET = '\uFE38';
    /** ︹ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_TORTOISE_SHELL_BRACKET = '\uFE39';
    /** ︺ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_TORTOISE_SHELL_BRACKET = '\uFE3A';
    /** ︻ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_BLACK_LENTICULAR_BRACKET = '\uFE3B';
    /** ︼ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_BLACK_LENTICULAR_BRACKET = '\uFE3C';
    /** ︽ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_DOUBLE_ANGLE_BRACKET = '\uFE3D';
    /** ︾ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_DOUBLE_ANGLE_BRACKET = '\uFE3E';
    /** ︿ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_ANGLE_BRACKET = '\uFE3F';
    /** ﹀ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_ANGLE_BRACKET = '\uFE40';
    /** ﹁ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_CORNER_BRACKET = '\uFE41';
    /** ﹂ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_CORNER_BRACKET = '\uFE42';
    /** ﹃ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_WHITE_CORNER_BRACKET = '\uFE43';
    /** ﹄ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_WHITE_CORNER_BRACKET = '\uFE44';
    /** ﹅ of type OTHER_PUNCTUATION */
    char SESAME_DOT = '\uFE45';
    /** ﹆ of type OTHER_PUNCTUATION */
    char WHITE_SESAME_DOT = '\uFE46';
    /** ﹇ of type START_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_LEFT_SQUARE_BRACKET = '\uFE47';
    /** ﹈ of type END_PUNCTUATION */
    char PRESENTATION_FORM_FOR_VERTICAL_RIGHT_SQUARE_BRACKET = '\uFE48';
    /** ﹉ of type OTHER_PUNCTUATION */
    char DASHED_OVERLINE = '\uFE49';
    /** ﹊ of type OTHER_PUNCTUATION */
    char CENTRELINE_OVERLINE = '\uFE4A';
    /** ﹋ of type OTHER_PUNCTUATION */
    char WAVY_OVERLINE = '\uFE4B';
    /** ﹌ of type OTHER_PUNCTUATION */
    char DOUBLE_WAVY_OVERLINE = '\uFE4C';
    /** ﹍ of type CONNECTOR_PUNCTUATION */
    char DASHED_LOW_LINE = '\uFE4D';
    /** ﹎ of type CONNECTOR_PUNCTUATION */
    char CENTRELINE_LOW_LINE = '\uFE4E';
    /** ﹏ of type CONNECTOR_PUNCTUATION */
    char WAVY_LOW_LINE = '\uFE4F';
    /** ﹐ of type OTHER_PUNCTUATION */
    char SMALL_COMMA = '\uFE50';
    /** ﹑ of type OTHER_PUNCTUATION */
    char SMALL_IDEOGRAPHIC_COMMA = '\uFE51';
    /** ﹒ of type OTHER_PUNCTUATION */
    char SMALL_FULL_STOP = '\uFE52';
    /** ﹔ of type OTHER_PUNCTUATION */
    char SMALL_SEMICOLON = '\uFE54';
    /** ﹕ of type OTHER_PUNCTUATION */
    char SMALL_COLON = '\uFE55';
    /** ﹖ of type OTHER_PUNCTUATION */
    char SMALL_QUESTION_MARK = '\uFE56';
    /** ﹗ of type OTHER_PUNCTUATION */
    char SMALL_EXCLAMATION_MARK = '\uFE57';
    /** ﹘ of type DASH_PUNCTUATION */
    char SMALL_EM_DASH = '\uFE58';
    /** ﹙ of type START_PUNCTUATION */
    char SMALL_LEFT_PARENTHESIS = '\uFE59';
    /** ﹚ of type END_PUNCTUATION */
    char SMALL_RIGHT_PARENTHESIS = '\uFE5A';
    /** ﹛ of type START_PUNCTUATION */
    char SMALL_LEFT_CURLY_BRACKET = '\uFE5B';
    /** ﹜ of type END_PUNCTUATION */
    char SMALL_RIGHT_CURLY_BRACKET = '\uFE5C';
    /** ﹝ of type START_PUNCTUATION */
    char SMALL_LEFT_TORTOISE_SHELL_BRACKET = '\uFE5D';
    /** ﹞ of type END_PUNCTUATION */
    char SMALL_RIGHT_TORTOISE_SHELL_BRACKET = '\uFE5E';
    /** ﹟ of type OTHER_PUNCTUATION */
    char SMALL_NUMBER_SIGN = '\uFE5F';
    /** ﹠ of type OTHER_PUNCTUATION */
    char SMALL_AMPERSAND = '\uFE60';
    /** ﹡ of type OTHER_PUNCTUATION */
    char SMALL_ASTERISK = '\uFE61';
    /** ﹢ of type MATH_SYMBOL */
    char SMALL_PLUS_SIGN = '\uFE62';
    /** ﹣ of type DASH_PUNCTUATION */
    char SMALL_HYPHEN_MINUS = '\uFE63';
    /** ﹤ of type MATH_SYMBOL */
    char SMALL_LESS_THAN_SIGN = '\uFE64';
    /** ﹥ of type MATH_SYMBOL */
    char SMALL_GREATER_THAN_SIGN = '\uFE65';
    /** ﹦ of type MATH_SYMBOL */
    char SMALL_EQUALS_SIGN = '\uFE66';
    /** ﹨ of type OTHER_PUNCTUATION */
    char SMALL_REVERSE_SOLIDUS = '\uFE68';
    /** ﹩ of type CURRENCY_SYMBOL */
    char SMALL_DOLLAR_SIGN = '\uFE69';
    /** ﹪ of type OTHER_PUNCTUATION */
    char SMALL_PERCENT_SIGN = '\uFE6A';
    /** ﹫ of type OTHER_PUNCTUATION */
    char SMALL_COMMERCIAL_AT = '\uFE6B';
    /** ﻿ of type FORMAT */
    char ZERO_WIDTH_NO_BREAK_SPACE = '\uFEFF';
    /** ！ of type OTHER_PUNCTUATION */
    char FULLWIDTH_EXCLAMATION_MARK = '\uFF01';
    /** ＂ of type OTHER_PUNCTUATION */
    char FULLWIDTH_QUOTATION_MARK = '\uFF02';
    /** ＃ of type OTHER_PUNCTUATION */
    char FULLWIDTH_NUMBER_SIGN = '\uFF03';
    /** ＄ of type CURRENCY_SYMBOL */
    char FULLWIDTH_DOLLAR_SIGN = '\uFF04';
    /** ％ of type OTHER_PUNCTUATION */
    char FULLWIDTH_PERCENT_SIGN = '\uFF05';
    /** ＆ of type OTHER_PUNCTUATION */
    char FULLWIDTH_AMPERSAND = '\uFF06';
    /** ＇ of type OTHER_PUNCTUATION */
    char FULLWIDTH_APOSTROPHE = '\uFF07';
    /** （ of type START_PUNCTUATION */
    char FULLWIDTH_LEFT_PARENTHESIS = '\uFF08';
    /** ） of type END_PUNCTUATION */
    char FULLWIDTH_RIGHT_PARENTHESIS = '\uFF09';
    /** ＊ of type OTHER_PUNCTUATION */
    char FULLWIDTH_ASTERISK = '\uFF0A';
    /** ＋ of type MATH_SYMBOL */
    char FULLWIDTH_PLUS_SIGN = '\uFF0B';
    /** ， of type OTHER_PUNCTUATION */
    char FULLWIDTH_COMMA = '\uFF0C';
    /** － of type DASH_PUNCTUATION */
    char FULLWIDTH_HYPHEN_MINUS = '\uFF0D';
    /** ． of type OTHER_PUNCTUATION */
    char FULLWIDTH_FULL_STOP = '\uFF0E';
    /** ／ of type OTHER_PUNCTUATION */
    char FULLWIDTH_SOLIDUS = '\uFF0F';
    /** ０ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_ZERO = '\uFF10';
    /** １ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_ONE = '\uFF11';
    /** ２ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_TWO = '\uFF12';
    /** ３ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_THREE = '\uFF13';
    /** ４ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_FOUR = '\uFF14';
    /** ５ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_FIVE = '\uFF15';
    /** ６ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_SIX = '\uFF16';
    /** ７ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_SEVEN = '\uFF17';
    /** ８ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_EIGHT = '\uFF18';
    /** ９ of type DECIMAL_DIGIT_NUMBER */
    char FULLWIDTH_DIGIT_NINE = '\uFF19';
    /** ： of type OTHER_PUNCTUATION */
    char FULLWIDTH_COLON = '\uFF1A';
    /** ； of type OTHER_PUNCTUATION */
    char FULLWIDTH_SEMICOLON = '\uFF1B';
    /** ＜ of type MATH_SYMBOL */
    char FULLWIDTH_LESS_THAN_SIGN = '\uFF1C';
    /** ＝ of type MATH_SYMBOL */
    char FULLWIDTH_EQUALS_SIGN = '\uFF1D';
    /** ＞ of type MATH_SYMBOL */
    char FULLWIDTH_GREATER_THAN_SIGN = '\uFF1E';
    /** ？ of type OTHER_PUNCTUATION */
    char FULLWIDTH_QUESTION_MARK = '\uFF1F';
    /** ＠ of type OTHER_PUNCTUATION */
    char FULLWIDTH_COMMERCIAL_AT = '\uFF20';
    /** Ａ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_A = '\uFF21';
    /** Ｂ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_B = '\uFF22';
    /** Ｃ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_C = '\uFF23';
    /** Ｄ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_D = '\uFF24';
    /** Ｅ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_E = '\uFF25';
    /** Ｆ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_F = '\uFF26';
    /** Ｇ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_G = '\uFF27';
    /** Ｈ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_H = '\uFF28';
    /** Ｉ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_I = '\uFF29';
    /** Ｊ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_J = '\uFF2A';
    /** Ｋ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_K = '\uFF2B';
    /** Ｌ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_L = '\uFF2C';
    /** Ｍ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_M = '\uFF2D';
    /** Ｎ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_N = '\uFF2E';
    /** Ｏ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_O = '\uFF2F';
    /** Ｐ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_P = '\uFF30';
    /** Ｑ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_Q = '\uFF31';
    /** Ｒ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_R = '\uFF32';
    /** Ｓ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_S = '\uFF33';
    /** Ｔ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_T = '\uFF34';
    /** Ｕ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_U = '\uFF35';
    /** Ｖ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_V = '\uFF36';
    /** Ｗ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_W = '\uFF37';
    /** Ｘ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_X = '\uFF38';
    /** Ｙ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_Y = '\uFF39';
    /** Ｚ of type UPPERCASE_LETTER */
    char FULLWIDTH_LATIN_CAPITAL_LETTER_Z = '\uFF3A';
    /** ［ of type START_PUNCTUATION */
    char FULLWIDTH_LEFT_SQUARE_BRACKET = '\uFF3B';
    /** ＼ of type OTHER_PUNCTUATION */
    char FULLWIDTH_REVERSE_SOLIDUS = '\uFF3C';
    /** ］ of type END_PUNCTUATION */
    char FULLWIDTH_RIGHT_SQUARE_BRACKET = '\uFF3D';
    /** ＾ of type MODIFIER_SYMBOL */
    char FULLWIDTH_CIRCUMFLEX_ACCENT = '\uFF3E';
    /** ＿ of type CONNECTOR_PUNCTUATION */
    char FULLWIDTH_LOW_LINE = '\uFF3F';
    /** ｀ of type MODIFIER_SYMBOL */
    char FULLWIDTH_GRAVE_ACCENT = '\uFF40';
    /** ａ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_A = '\uFF41';
    /** ｂ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_B = '\uFF42';
    /** ｃ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_C = '\uFF43';
    /** ｄ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_D = '\uFF44';
    /** ｅ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_E = '\uFF45';
    /** ｆ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_F = '\uFF46';
    /** ｇ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_G = '\uFF47';
    /** ｈ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_H = '\uFF48';
    /** ｉ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_I = '\uFF49';
    /** ｊ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_J = '\uFF4A';
    /** ｋ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_K = '\uFF4B';
    /** ｌ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_L = '\uFF4C';
    /** ｍ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_M = '\uFF4D';
    /** ｎ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_N = '\uFF4E';
    /** ｏ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_O = '\uFF4F';
    /** ｐ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_P = '\uFF50';
    /** ｑ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_Q = '\uFF51';
    /** ｒ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_R = '\uFF52';
    /** ｓ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_S = '\uFF53';
    /** ｔ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_T = '\uFF54';
    /** ｕ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_U = '\uFF55';
    /** ｖ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_V = '\uFF56';
    /** ｗ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_W = '\uFF57';
    /** ｘ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_X = '\uFF58';
    /** ｙ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_Y = '\uFF59';
    /** ｚ of type LOWERCASE_LETTER */
    char FULLWIDTH_LATIN_SMALL_LETTER_Z = '\uFF5A';
    /** ｛ of type START_PUNCTUATION */
    char FULLWIDTH_LEFT_CURLY_BRACKET = '\uFF5B';
    /** ｜ of type MATH_SYMBOL */
    char FULLWIDTH_VERTICAL_LINE = '\uFF5C';
    /** ｝ of type END_PUNCTUATION */
    char FULLWIDTH_RIGHT_CURLY_BRACKET = '\uFF5D';
    /** ～ of type MATH_SYMBOL */
    char FULLWIDTH_TILDE = '\uFF5E';
    /** ｟ of type START_PUNCTUATION */
    char FULLWIDTH_LEFT_WHITE_PARENTHESIS = '\uFF5F';
    /** ｠ of type END_PUNCTUATION */
    char FULLWIDTH_RIGHT_WHITE_PARENTHESIS = '\uFF60';
    /** ｡ of type OTHER_PUNCTUATION */
    char HALFWIDTH_IDEOGRAPHIC_FULL_STOP = '\uFF61';
    /** ｢ of type START_PUNCTUATION */
    char HALFWIDTH_LEFT_CORNER_BRACKET = '\uFF62';
    /** ｣ of type END_PUNCTUATION */
    char HALFWIDTH_RIGHT_CORNER_BRACKET = '\uFF63';
    /** ､ of type OTHER_PUNCTUATION */
    char HALFWIDTH_IDEOGRAPHIC_COMMA = '\uFF64';
    /** ･ of type OTHER_PUNCTUATION */
    char HALFWIDTH_KATAKANA_MIDDLE_DOT = '\uFF65';
    /** ｦ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_WO = '\uFF66';
    /** ｧ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_A = '\uFF67';
    /** ｨ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_I = '\uFF68';
    /** ｩ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_U = '\uFF69';
    /** ｪ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_E = '\uFF6A';
    /** ｫ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_O = '\uFF6B';
    /** ｬ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_YA = '\uFF6C';
    /** ｭ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_YU = '\uFF6D';
    /** ｮ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_YO = '\uFF6E';
    /** ｯ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SMALL_TU = '\uFF6F';
    /** ｰ of type MODIFIER_LETTER */
    char HALFWIDTH_KATAKANA_HIRAGANA_PROLONGED_SOUND_MARK = '\uFF70';
    /** ｱ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_A = '\uFF71';
    /** ｲ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_I = '\uFF72';
    /** ｳ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_U = '\uFF73';
    /** ｴ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_E = '\uFF74';
    /** ｵ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_O = '\uFF75';
    /** ｶ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_KA = '\uFF76';
    /** ｷ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_KI = '\uFF77';
    /** ｸ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_KU = '\uFF78';
    /** ｹ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_KE = '\uFF79';
    /** ｺ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_KO = '\uFF7A';
    /** ｻ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SA = '\uFF7B';
    /** ｼ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SI = '\uFF7C';
    /** ｽ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SU = '\uFF7D';
    /** ｾ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SE = '\uFF7E';
    /** ｿ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_SO = '\uFF7F';
    /** ﾀ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_TA = '\uFF80';
    /** ﾁ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_TI = '\uFF81';
    /** ﾂ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_TU = '\uFF82';
    /** ﾃ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_TE = '\uFF83';
    /** ﾄ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_TO = '\uFF84';
    /** ﾅ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_NA = '\uFF85';
    /** ﾆ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_NI = '\uFF86';
    /** ﾇ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_NU = '\uFF87';
    /** ﾈ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_NE = '\uFF88';
    /** ﾉ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_NO = '\uFF89';
    /** ﾊ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_HA = '\uFF8A';
    /** ﾋ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_HI = '\uFF8B';
    /** ﾌ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_HU = '\uFF8C';
    /** ﾍ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_HE = '\uFF8D';
    /** ﾎ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_HO = '\uFF8E';
    /** ﾏ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_MA = '\uFF8F';
    /** ﾐ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_MI = '\uFF90';
    /** ﾑ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_MU = '\uFF91';
    /** ﾒ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_ME = '\uFF92';
    /** ﾓ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_MO = '\uFF93';
    /** ﾔ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_YA = '\uFF94';
    /** ﾕ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_YU = '\uFF95';
    /** ﾖ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_YO = '\uFF96';
    /** ﾗ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_RA = '\uFF97';
    /** ﾘ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_RI = '\uFF98';
    /** ﾙ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_RU = '\uFF99';
    /** ﾚ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_RE = '\uFF9A';
    /** ﾛ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_RO = '\uFF9B';
    /** ﾜ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_WA = '\uFF9C';
    /** ﾝ of type OTHER_LETTER */
    char HALFWIDTH_KATAKANA_LETTER_N = '\uFF9D';
    /** ﾞ of type MODIFIER_LETTER */
    char HALFWIDTH_KATAKANA_VOICED_SOUND_MARK = '\uFF9E';
    /** ﾟ of type MODIFIER_LETTER */
    char HALFWIDTH_KATAKANA_SEMI_VOICED_SOUND_MARK = '\uFF9F';
    /** ﾠ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_FILLER = '\uFFA0';
    /** ﾡ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_KIYEOK = '\uFFA1';
    /** ﾢ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_SSANGKIYEOK = '\uFFA2';
    /** ﾣ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_KIYEOK_SIOS = '\uFFA3';
    /** ﾤ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_NIEUN = '\uFFA4';
    /** ﾥ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_NIEUN_CIEUC = '\uFFA5';
    /** ﾦ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_NIEUN_HIEUH = '\uFFA6';
    /** ﾧ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_TIKEUT = '\uFFA7';
    /** ﾨ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_SSANGTIKEUT = '\uFFA8';
    /** ﾩ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL = '\uFFA9';
    /** ﾪ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_KIYEOK = '\uFFAA';
    /** ﾫ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_MIEUM = '\uFFAB';
    /** ﾬ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_PIEUP = '\uFFAC';
    /** ﾭ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_SIOS = '\uFFAD';
    /** ﾮ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_THIEUTH = '\uFFAE';
    /** ﾯ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_PHIEUPH = '\uFFAF';
    /** ﾰ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_RIEUL_HIEUH = '\uFFB0';
    /** ﾱ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_MIEUM = '\uFFB1';
    /** ﾲ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_PIEUP = '\uFFB2';
    /** ﾳ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_SSANGPIEUP = '\uFFB3';
    /** ﾴ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_PIEUP_SIOS = '\uFFB4';
    /** ﾵ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_SIOS = '\uFFB5';
    /** ﾶ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_SSANGSIOS = '\uFFB6';
    /** ﾷ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_IEUNG = '\uFFB7';
    /** ﾸ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_CIEUC = '\uFFB8';
    /** ﾹ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_SSANGCIEUC = '\uFFB9';
    /** ﾺ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_CHIEUCH = '\uFFBA';
    /** ﾻ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_KHIEUKH = '\uFFBB';
    /** ﾼ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_THIEUTH = '\uFFBC';
    /** ﾽ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_PHIEUPH = '\uFFBD';
    /** ﾾ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_HIEUH = '\uFFBE';
    /** ￂ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_A = '\uFFC2';
    /** ￃ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_AE = '\uFFC3';
    /** ￄ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YA = '\uFFC4';
    /** ￅ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YAE = '\uFFC5';
    /** ￆ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_EO = '\uFFC6';
    /** ￇ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_E = '\uFFC7';
    /** ￊ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YEO = '\uFFCA';
    /** ￋ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YE = '\uFFCB';
    /** ￌ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_O = '\uFFCC';
    /** ￍ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_WA = '\uFFCD';
    /** ￎ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_WAE = '\uFFCE';
    /** ￏ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_OE = '\uFFCF';
    /** ￒ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YO = '\uFFD2';
    /** ￓ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_U = '\uFFD3';
    /** ￔ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_WEO = '\uFFD4';
    /** ￕ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_WE = '\uFFD5';
    /** ￖ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_WI = '\uFFD6';
    /** ￗ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YU = '\uFFD7';
    /** ￚ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_EU = '\uFFDA';
    /** ￛ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_YI = '\uFFDB';
    /** ￜ of type OTHER_LETTER */
    char HALFWIDTH_HANGUL_LETTER_I = '\uFFDC';
    /** ￠ of type CURRENCY_SYMBOL */
    char FULLWIDTH_CENT_SIGN = '\uFFE0';
    /** ￡ of type CURRENCY_SYMBOL */
    char FULLWIDTH_POUND_SIGN = '\uFFE1';
    /** ￢ of type MATH_SYMBOL */
    char FULLWIDTH_NOT_SIGN = '\uFFE2';
    /** ￣ of type MODIFIER_SYMBOL */
    char FULLWIDTH_MACRON = '\uFFE3';
    /** ￤ of type OTHER_SYMBOL */
    char FULLWIDTH_BROKEN_BAR = '\uFFE4';
    /** ￥ of type CURRENCY_SYMBOL */
    char FULLWIDTH_YEN_SIGN = '\uFFE5';
    /** ￦ of type CURRENCY_SYMBOL */
    char FULLWIDTH_WON_SIGN = '\uFFE6';
    /** ￨ of type OTHER_SYMBOL */
    char HALFWIDTH_FORMS_LIGHT_VERTICAL = '\uFFE8';
    /** ￩ of type MATH_SYMBOL */
    char HALFWIDTH_LEFTWARDS_ARROW = '\uFFE9';
    /** ￪ of type MATH_SYMBOL */
    char HALFWIDTH_UPWARDS_ARROW = '\uFFEA';
    /** ￫ of type MATH_SYMBOL */
    char HALFWIDTH_RIGHTWARDS_ARROW = '\uFFEB';
    /** ￬ of type MATH_SYMBOL */
    char HALFWIDTH_DOWNWARDS_ARROW = '\uFFEC';
    /** ￭ of type OTHER_SYMBOL */
    char HALFWIDTH_BLACK_SQUARE = '\uFFED';
    /** ￮ of type OTHER_SYMBOL */
    char HALFWIDTH_WHITE_CIRCLE = '\uFFEE';
    /** ￹ of type FORMAT */
    char INTERLINEAR_ANNOTATION_ANCHOR = '\uFFF9';
    /** ￺ of type FORMAT */
    char INTERLINEAR_ANNOTATION_SEPARATOR = '\uFFFA';
    /** ￻ of type FORMAT */
    char INTERLINEAR_ANNOTATION_TERMINATOR = '\uFFFB';
    /** ￼ of type OTHER_SYMBOL */
    char OBJECT_REPLACEMENT_CHARACTER = '\uFFFC';
    /** � of type OTHER_SYMBOL */
    char REPLACEMENT_CHARACTER = '\uFFFD';
}
// CHECKSTYLE:ON
