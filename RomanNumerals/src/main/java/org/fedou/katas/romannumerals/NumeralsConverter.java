package org.fedou.katas.romannumerals;

import java.math.BigDecimal;

public class NumeralsConverter {
	enum RomanDigits {
		I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(
				500), CM(900), M(1000);
		final int value;

		private RomanDigits(int value) {
			this.value = value;
		}
	}

	public String convertToRoman(int arabic) {
		StringBuilder result = new StringBuilder();
		RomanDigits[] values = RomanDigits.values();
		for (int i = values.length - 1; i >= 0; i--) {
			RomanDigits romanDigit = values[i];
			while (arabic >= romanDigit.value) {
				result.append(romanDigit.toString());
				arabic -= romanDigit.value;
			}
		}
		return result.toString();
	}

	enum ArabicDigits {
		THOUSAND(1000, 'M'), FIVE_HUNDRED(500, 'D'), HUNDRED(100, 'C',
				FIVE_HUNDRED, THOUSAND), FIFTY(50, 'L'), TEN(10, 'X', FIFTY,
				HUNDRED), FIVE(5, 'V'), ONE(1, 'I', FIVE, TEN);

		private int arabic;
		private char roman;
		private ArabicDigits[] maySubstractOthers;

		private ArabicDigits(int arabic, char roman,
				ArabicDigits... maySubstractOthers) {
			this.arabic = arabic;
			this.roman = roman;
			this.maySubstractOthers = maySubstractOthers;
		}

	}

	public int convertToArabic(String roman) {
		int arabic = 0;
		for (int i = 0; i < roman.length(); i++) {
			char nextChar = '@';
			int j = i + 1;
			if (j < roman.length()) {
				nextChar = roman.charAt(j);
			}
			char currentChar = roman.charAt(i);
			arabic += evaluateLetter(currentChar, nextChar);
		}
		return arabic;
	}

	private int evaluateLetter(char currentChar, char nextChar) {
		for (ArabicDigits arabicDigit : ArabicDigits.values()) {
			if (arabicDigit.roman == currentChar) {
				for (ArabicDigits shallSubstract : arabicDigit.maySubstractOthers) {
					if (shallSubstract.roman == nextChar) {
						return -arabicDigit.arabic;
					}
				}
				return arabicDigit.arabic;
			}
		}
		return 0;
	}

}
