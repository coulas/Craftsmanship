package org.fedou.katas.stringcalculator;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.condition.Negative;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class StringCalculatorAdditionTest {
	@Test
	public void should_return_0_on_empty_input() throws Exception {
		assertThat(new StringCalculator().add("")).isEqualTo(0);
	}

	@Test
	@Parameters(value = { "1", "123", "123456790" })
	public void should_return_input_when_given_a_single_number(String input)
			throws Exception {
		assertThat(new StringCalculator().add(input)).isEqualTo(
				Double.parseDouble(input));
	}

	@Test
	@Parameters()
	public void should_return_sum_when_given_two_numbers(String input,
			double expected) throws Exception {
		assertThat(new StringCalculator().add(input)).isEqualTo(expected);
	}

	public Object[] parametersForShould_return_sum_when_given_two_numbers() {
		return $(
				$("1,0", 1),
				$("1,1", 2),
				$("1,23", 24),
				$("1, 23", 24),
				$("1.2,3.4", 4.6));
	}

	@Test
	@Parameters()
	public void should_return_sum_when_given_any_numbers(String input,
			double expected) throws Exception {
		assertThat(new StringCalculator().add(input)).isEqualTo(expected);
	}

	public Object[] parametersForShould_return_sum_when_given_any_numbers() {
		return $(
				$("1,0, 1", 2), 
				$("1,23,456", 480), 
				$("0,1,2,3,4,5,6,7,8,9", 45));
	}

	@Test
	@Parameters()
	public void should_return_sum_when_given_numbers_seperated_by_comma_as_well_as_new_lines(String input,
			double expected) throws Exception {
		assertThat(new StringCalculator().add(input)).isEqualTo(expected);
	}

	public Object[] parametersForShould_return_sum_when_given_numbers_seperated_by_comma_as_well_as_new_lines() {
		return $($("1\n2,3", 6));
	}

	@Test(expected=IllegalArgumentException.class)
	@Parameters()
	public void should_throw_exception_on_wrong_separations(String input) throws Exception {
		assertThat(new StringCalculator().add(input)).isNotNull();
	}
	
	public Object[] parametersForShould_throw_exception_on_wrong_separations() {
		return $(
				$("1,,2"), 
				$("1,2,"), 
				$("\n1,2"), 
				$(",1,2"), 
				$("1,\n2"), 
				$("1\n,2"), 
				$("1\n,"), 
				$("1,\n"));
	}

	@Test
	@Parameters()
	public void should_return_sum_whith_custom_delimiters(String input,
			double expected) throws Exception {
		assertThat(new StringCalculator().add(input)).isEqualTo(expected);
	}

	public Object[] parametersForShould_return_sum_whith_custom_delimiters() {
		return $($("//;\n1;2", 3), $("//|\n2|3|4", 9));
	}

	@Test(expected=NegativeNumberException.class)
	@Parameters()
	public void should_throw_exception_on_negative_numbers(String input, String message) throws Exception {
		try {
			assertThat(new StringCalculator().add(input)).isNotNull();
		} catch(NegativeNumberException nne) {
			assertThat(nne.getMessage()).isEqualToIgnoringCase(message);
			throw nne;
		}
	}
	
	public Object[] parametersForShould_throw_exception_on_negative_numbers() {
		return $(
				$("-1,2", "Negative not allowed : -1"), 
				$("1,-2", "Negative not allowed : -2"));
	}
}
