package org.fedou.katas.romannumerals;

import static org.assertj.core.api.Assertions.*;
import junitparams.JUnitParamsRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralsTest {
	
	@Test
	public void should_convert_units() throws Exception {
		assertThat(new RomanNumerals().convert(1)).isEqualTo("I");
	}
	
}
