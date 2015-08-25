package org.fedou.katas.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static final String specialRegexCharacters = "\\||\\?|\\+|\\*";
	private String delimiters = ",|\n";
	private String toParse = null;
	private String lastNullDelimiter = null;

	private abstract class Operator {
		private Double neutralElement;
		Operator(double neutralElement) {
			this.neutralElement = neutralElement;
		}
		
		abstract double operateNext(Matcher m, double result);
		
		Double getNeutralElement() {
			return neutralElement;
		}
	}
	
	double add(String input) {
		return calculate(input, new Operator(0.0){
			@Override
			double operateNext(Matcher m, double result) {
				return result + extractnumber(m);
			}});
	}
	
	double multiply(String input) {
		return calculate(input, new Operator(1.0){
			@Override
			double operateNext(Matcher m, double result) {
				return result * extractnumber(m);
			}});
	}
	
	private double calculate(String input, Operator op) {
		if (input.isEmpty()) {
			return 0;
		}
		extractCustomDelimiters(input);
		Matcher m = generateMatcher();
		double result = op.getNeutralElement();
		boolean found = false;
		while (m.find()) {
			found = true;
			result = op.operateNext(m, result);
		}
		failWhenInputDoesNotMatch(found);
		failWhenEndingWithADelimeter();
		return result;
	}

	private void failWhenEndingWithADelimeter() {
		if (lastNullDelimiter != null) {
			throw new IllegalArgumentException(
					"Input shall not end with delimiters.");
		}
	}

	private void failWhenInputDoesNotMatch(boolean found) {
		if (!found) {
			throw new IllegalArgumentException(
					"Input does not parse correctly.");
		}
	}

	private Matcher generateMatcher() {
		Pattern p = Pattern.compile("\\G[ \t]*(-?\\d+(\\.\\d+)*)[ \t]*("
				+ delimiters + ")?");
		Matcher m = p.matcher(toParse);
		return m;
	}

	private double extractnumber(Matcher m) {
		String number = m.group(1);
		lastNullDelimiter = m.group(3);
		System.out.println("\t[" + number + "] ended by [" + lastNullDelimiter
				+ "]");
		if (number.startsWith("-")) {
			throw new NegativeNumberException("Negative not allowed : "+number);
		}
		return Double.parseDouble(number);
	}

	
	private void extractCustomDelimiters(String input) {
		if (input.startsWith("//")) {
			String customDelimiter = input.split("\n")[0].substring(2);
			int toParseBeginIndex = customDelimiter.length() + 1 + 2;
			if (customDelimiter.matches(specialRegexCharacters)) {
				customDelimiter = "\\" + customDelimiter;
			}
			delimiters = delimiters.concat("|" + customDelimiter);
			toParse = input.substring(toParseBeginIndex);
		} else {
			toParse = input;
		}
	}
}
