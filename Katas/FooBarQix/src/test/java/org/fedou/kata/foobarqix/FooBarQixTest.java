package org.fedou.kata.foobarqix;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FooBarQixTest {
	
	@Test
	@Parameters(value = {
		"1, 1",
		"2, 2",
		"3, foofoo",
		"9, foo",
		"13, foo",
		"31, foo",
		"5, barbar",
		"52, bar",
		"10, bar",
		"7, qixqix",
		"71, qix",
		"14, qix",
		"15, foobarbar",
		"21, fooqix",
		"51, foobar",
		"53, barfoo", })
	public void should_return_number(int number, String expected) throws Exception {
		assertThat(new FooBarQix().fooBarQix(number)).isEqualTo(expected);
	}
}
