package org.fedou.katas.fizzbuzz;

import static org.assertj.core.api.Assertions.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {

	@Test
	@Parameters(value = { "1", "2", "4", "8"})
	public void should_return_number(String number) throws Exception {
		assertThat(new FizzBuzz().compute(number)).isEqualTo("" + number);
	}
	
	@Test
	@Parameters(value = { "3", "6", "9", "12" })
	public void should_return_Fizz(String number) throws Exception {
		assertThat(new FizzBuzz().compute(number)).isEqualTo("Fizz");
	}
	
	@Test
	@Parameters(value = { "5", "10"})
	public void should_return_Buzz(String number) throws Exception {
		assertThat(new FizzBuzz().compute(number)).isEqualTo("Buzz");
	}
	
	@Test
	@Parameters(value = { "15", "30"})
	public void should_return_FizzBuzz(String number) throws Exception {
		assertThat(new FizzBuzz().compute(number)).isEqualTo("FizzBuzz");
	}
	
}
