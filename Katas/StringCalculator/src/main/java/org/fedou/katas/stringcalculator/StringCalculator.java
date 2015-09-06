package org.fedou.katas.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static final String specialRegexCharacters = "\\||\\?|\\+|\\*";
	private String delimiters = ",|\n";
	private String lastNullDelimiter = null;
	private String input;

	public double add(String input) {
		this.input = input;
		return calculate(new Operator(0.0) {
			@Override
			double operateNext(Matcher m, double result) {
				return result + extractnumber(m);
			}
		});
	}

	public double multiply(String input) {
		this.input = input;
		return calculate(new Operator(1.0) {
			@Override
			double operateNext(Matcher m, double result) {
				return result * extractnumber(m);
			}
		});
	}

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

	private double calculate(Operator op) {
		if (input.isEmpty()) {
			return 0;
		}
		extractCustomDelimiters();
		Matcher m = generateMatcher();
		double result = op.getNeutralElement();
		boolean nothingFound = true;
		while (m.find()) {
			nothingFound = false;
			result = op.operateNext(m, result);
		}
		failWhenNothingMatched(nothingFound);
		failWhenEndingWithADelimeter();
		return result;
	}

	private double extractnumber(Matcher m) {
		String number = m.group(1);
		lastNullDelimiter = m.group(3);
		failWhenInputDoesNotMatch(m);
		failWhenNegativeNumberFound(number);
		return Double.parseDouble(number);
	}

	private void failWhenNothingMatched(boolean hasFailed) {
		if (hasFailed) {
			throw new IllegalArgumentException(
					"Input does not parse correctly.");
		}
	}
	
	private void failWhenNegativeNumberFound(String number) {
		if (number.startsWith("-")) {
			throw new NegativeNumberException("Negative not allowed : "
					+ number);
		}
	}

	private void failWhenInputDoesNotMatch(Matcher m) {
		if (m.group(3) == null) { // no more delimiters
			if (m.end() != input.length()) { // not at end of line
				throw new IllegalArgumentException(
						"Input does not parse correctly.");
			}
		}
	}

	private Matcher generateMatcher() {
		Pattern p = Pattern.compile("\\G(-?\\d+(\\.\\d+)*)(" + delimiters
				+ ")?");
		Matcher m = p.matcher(input);
		return m;
	}

	private void extractCustomDelimiters() {
		if (input.startsWith("//")) {
			String[] inputParsed = input.split("\n", 2);
			String customDelimiter = "\\" + inputParsed[0].substring(2);
			delimiters = delimiters.concat("|" + customDelimiter);
			input = inputParsed[1];
		}
	}

	private void failWhenEndingWithADelimeter() {
		if (lastNullDelimiter != null) {
			throw new IllegalArgumentException(
					"Input shall not end with delimiters.");
		}
	}
}
