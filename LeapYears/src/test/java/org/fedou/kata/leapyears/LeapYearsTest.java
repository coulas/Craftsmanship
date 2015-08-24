package org.fedou.kata.leapyears;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LeapYearsTest {
	
	@Test
	@Parameters(value = {
		"3, false",
		"4, true",
		"100, false",
		"400, true",
		"2001, false",
		"1996, true",
		"1900, false",
		"2000, true" })
	public void should_testName(int year, boolean expectedLeap) throws Exception {
		assertThat(new LeapYears().isLeapYear(year)).isEqualTo(expectedLeap);
	}
	
}
