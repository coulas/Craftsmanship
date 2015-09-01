package org.fedou.katas.romannumerals;

import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralsTest {
	@Test
	@Parameters(value={"1,I", "2,II", "3,III"})
	public void shouldConvertLowerUnitsToIs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"4,IV", "5,V", "6,VI", "7,VII", "8,VIII"})
	public void shouldConvertMiddleUnitsToVs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"9,IX", "10,X", "11, XI", "12,XII", "13,XIII"})
	public void shouldConvertLowerTensToXs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"14,XIV", "15,XV", "16, XVI"})
	public void shouldConvertMiddleTensToXVs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"19,XIX", "20,XX", "21,XXI", "24, XXIV", "26, XXVI"})
	public void shouldConvertTwentiesToXXs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"40,XL", "41, XLI", "44, XLIV", "46, XLVI"})
	public void shouldConvertFortiesToXLs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"50,L", "51,LI", "54,LIV", "56, LVI"})
	public void shouldConvertFiftiesToLsAndXs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"60,LX", "70,LXX", "80, LXXX"})
	public void shouldConvertMultipleOfTenToLXs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"90,XC", "100,C", "110, CX", "120,CXX"})
	public void shouldConvertLowerHundredsToLXs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"200,CC", "300,CCC", "400, CD", "500,D", "600,DC"})
	public void shouldConvertMiddleHundredsToLXs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"900,CM", "1000,M", "1100, MC", "2000, MM"})
	public void shouldConvertThousandsToMs(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}
	
	@Test
	@Parameters(value={"2987,MMCMLXXXVII", "1843,MDCCCXLIII"})
	public void shouldConvertCompleteArabicNumbersToRomanNumbers(int arabic, String roman) throws Exception {
		assertThat(new RomanNumerals().convert(arabic)).isEqualTo(roman);
	}}
