package org.fedou.katas.rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class RPNCalculatorTest {

	@Test
	public void shouldReturnSelf() throws Exception {
		assertEquals(1, new RpnCalculator().calculate("1"));
	}
	
	@Test
	public void shouldAdd() throws Exception {
		assertEquals(3, new RpnCalculator().calculate("1", "2", "+"));
	}
	@Test
	public void shouldSubstract() throws Exception {
		assertEquals(1, new RpnCalculator().calculate("3", "2", "-"));
	}
	@Test
	public void shouldMutliply() throws Exception {
		assertEquals(6, new RpnCalculator().calculate("3", "2", "*"));
	}
	@Test
	public void shouldDivide() throws Exception {
		// Divide truncate ! : Thank you Yessine !
		assertEquals(2, new RpnCalculator().calculate("8", "3", "/"));
	}
	
	@Test
	public void shouldSqrt() throws Exception {
		// Divide truncate ! : Thank you Yessine !
		assertEquals(3, new RpnCalculator().calculate("9", "SQRT"));
	}
}
