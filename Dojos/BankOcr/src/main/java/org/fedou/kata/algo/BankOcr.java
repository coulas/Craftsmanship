package org.fedou.kata.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankOcr {
	private static final String UNREADABLE = "?";
	
	public List<String> parse(String[] file) {
		return parse(Arrays.asList(file));
	}
	
	public List<String> parse(List<String> file) {
		List<String> accounts = new ArrayList<String>(file.size() / 4);
		String status = " ";
		for (int lineIndex = 0; lineIndex < file.size() - 3; lineIndex += 4) {
			parseLine(file, accounts, lineIndex);
		}
		return accounts;
	}
	
	private void parseLine(List<String> file, List<String> accounts, int lineIndex) {
		String top = file.get(lineIndex + 0);
		String middle = file.get(lineIndex + 1);
		String bottom = file.get(lineIndex + 2);
		String separatorLine = file.get(lineIndex + 3);
		int digitStartIndex = 0;
		int digitEndIndex = digitStartIndex + 3;
		final int nbDigits = 9;
		StringBuffer accountnumber = new StringBuffer(nbDigits);
		int checksum = 0;
		boolean ill = false;
		for (int digitIndex = 0; digitIndex < nbDigits; digitIndex++) {
			String nextDigit = readDigit(top, middle, bottom, digitIndex);
			final int digit = parseDigit(nextDigit);
			if (digit == -1) {
				ill = true;
				accountnumber.append(UNREADABLE);
			} else {
				accountnumber.append(digit);
			}
			checksum += (9 - digitIndex) * digit;
			digitStartIndex = digitEndIndex;
			digitEndIndex = digitStartIndex + 3;
		}
		if (ill) {
			accounts.add(accountnumber.toString() + " ill");
		} else {
			if (checksum % 11 == 0) {
				accounts.add(accountnumber.toString());
			} else {
				accounts.add(accountnumber.toString() + " err");
			}
		}
	}
	
	private String readDigit(String top, String middle, String bottom, int digitIndex) {
		StringBuilder nextDigit = new StringBuilder(3 * 3);
		int digitStartIndex = digitIndex * 3;
		int digitEndIndex = digitStartIndex + 3;
		nextDigit.append(top.substring(digitStartIndex, digitEndIndex));
		nextDigit.append(middle.substring(digitStartIndex, digitEndIndex));
		nextDigit.append(bottom.substring(digitStartIndex, digitEndIndex));
		return nextDigit.toString();
	}
	
	int parseDigit(String digit) {
		switch (digit) {
			case " _ | ||_|":
				return 0;
			case "     |  |":
				return 1;
			case " _  _||_ ":
				return 2;
			case " _  _| _|":
				return 3;
			case "   |_|  |":
				return 4;
			case " _ |_  _|":
				return 5;
			case " _ |_ |_|":
				return 6;
			case " _   |  |":
				return 7;
			case " _ |_||_|":
				return 8;
			case " _ |_| _|":
				return 9;
		}
		return -1;
	}
	
}
