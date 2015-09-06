package org.fedou.kata.foobarqix;

public class FooBarQix {
	
	public String fooBarQix(int number) {
		StringBuffer fooBarQix = new StringBuffer();
		fooBarQix.append(transformModulos(number));
		fooBarQix.append(transformParsedLine(number));
		if (fooBarQix.length() == 0) {
			return String.valueOf(number);
		}
		return fooBarQix.toString();
	}
	
	public String transformParsedLine(int number) {
		StringBuffer result = new StringBuffer();
		for (char current : Integer
			.toString(number)
			.toCharArray()) {
			if (current == '3') {
				result.append("foo");
			}
			if (current == '5') {
				result.append("bar");
			}
			if (current == '7') {
				result.append("qix");
			}
		}
		return result.toString();
	}
	
	public String transformModulos(int number) {
		StringBuffer result = new StringBuffer();
		if (number % 3 == 0) {
			result.append("foo");
		}
		if (number % 5 == 0) {
			result.append("bar");
		}
		if (number % 7 == 0) {
			result.append("qix");
		}
		return result.toString();
	}
}
