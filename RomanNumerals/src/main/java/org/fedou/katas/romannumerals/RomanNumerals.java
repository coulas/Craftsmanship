package org.fedou.katas.romannumerals;


public class RomanNumerals {
	enum RomanDigits {
		I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
		final int value;

		private RomanDigits(int value) {
			this.value = value;
		}
	}
	
	public String convert(int arabic) {
		StringBuilder result = new StringBuilder();
		RomanDigits[] values = RomanDigits.values();
		for (int i = values.length-1; i >= 0; i--) {
			RomanDigits romanDigit = values[i];
			while (arabic >= romanDigit.value) {
				result.append(romanDigit.toString());
				arabic -= romanDigit.value;
			}
		}
		return result.toString();
	}

}
