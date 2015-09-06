package org.fedou.kata.algo;

import java.util.Arrays;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BankOcrTest {
	final BankOcr bankOcr = new BankOcr();
	
	@Test
	@Parameters()
	public void should_parse_digits(List<String> digitToScan, int digit) throws Exception {
		assertThat(bankOcr.parseDigit(Strings.join(digitToScan).with(""))).isEqualTo(digit);
	}
	
	public Object[] parametersForShould_parse_digits() {
		return $(
			$(Arrays.asList(
				" _ ",
				"| |",
				"|_|"), 0),
			$(Arrays.asList(
				"   ",
				"  |",
				"  |"
				), 1),
			$(Arrays.asList(
				" _ ",
				" _|",
				"|_ "), 2),
			$(Arrays.asList(
				" _ ",
				" _|",
				" _|"), 3),
			$(Arrays.asList(
				"   ",
				"|_|",
				"  |"), 4),
			$(Arrays.asList(
				" _ ",
				"|_ ",
				" _|"), 5),
			$(Arrays.asList(
				" _ ",
				"|_ ",
				"|_|"), 6),
			$(Arrays.asList(
				" _ ",
				"  |",
				"  |"), 7),
			$(Arrays.asList(
				" _ ",
				"|_|",
				"|_|"), 8),
			$(Arrays.asList(
				" _ ",
				"|_|",
				" _|"), 9));
	}
	
	@Test
	@Parameters()
	public void should_parse_numbers(List<String> file, List<String> accountNumber) throws Exception {
		assertThat(new BankOcr().parse(file)).isEqualTo(accountNumber);
	}
	
	public Object[] parametersForShould_parse_numbers() {
		return $(
			$(Arrays.asList(
				" _  _  _  _  _  _  _  _  _ ",
				"| || || || || || || || || |",
				"|_||_||_||_||_||_||_||_||_|",
				"                           "), Arrays.asList("000000000")),
			$(Arrays.asList(
				"    _  _     _  _  _  _  _ ",
				"  | _| _||_||_ |_   ||_||_|",
				"  ||_  _|  | _||_|  ||_| _|",
				"                           "), Arrays.asList("123456789")),
			$(Arrays.asList(
				" _  _  _  _  _  _  _  _  _ ",
				"|_||_||_||_||_||_| _||_||_|",
				"|_||_||_||_||_||_||_||_||_|",
				"                           "), Arrays.asList("888888?88 ill")),
			$(Arrays.asList(
				" _  _  _  _  _  _  _  _  _ ",
				"|_||_||_||_||_||_||_||_||_|",
				"|_||_||_||_||_||_||_||_||_|",
				"                           "), Arrays.asList("888888888 err")),
			$(Arrays.asList(
				"    _  _     _  _  _  _  _ ",
				"  | _| _||_||_ |_   ||_||_|",
				"  ||_  _|  | _||_|  ||_| _|",
				"                           ",
				"    _  _     _  _  _  _  _ ",
				"  | _| _||_||_ |_   ||_||_|",
				"  ||_  _|  | _||_|  ||_| _|",
				"                           "), Arrays.asList("123456789", "123456789")));
	}
	
	Object[] $(Object... o) {
		return o;
	}
	
}
