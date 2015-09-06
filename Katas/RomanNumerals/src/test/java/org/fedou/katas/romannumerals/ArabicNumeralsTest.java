package org.fedou.katas.romannumerals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ArabicNumeralsTest {
	@Test
	@Parameters(value={"I,1", "II,2", "III,3"})
	public void shouldConvertLowerUnitsToIs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"IV, 4", "V,5", "VI,6", "VII,7", "VIII,8"})
	public void shouldConvertMiddleUnitsToVs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"IX,9", "X,10", "XI,11", "XII,12", "XIII,13"})
	public void shouldConvertLowerTensToXs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"XIV,14", "XV,15", "XVI,16"})
	public void shouldConvertMiddleTensToXVs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"XIX,19", "XX,20", "XXI,21", "XXIV,24", "XXVI,26"})
	public void shouldConvertTwentiesToXXs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"XL,40", "XLI,41", "XLIV,44", "XLVI,46"})
	public void shouldConvertFortiesToXLs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"L,50", "LI,51", "LIV,54", "LVI,56"})
	public void shouldConvertFiftiesToLsAndXs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"LX,60", "LXX,70", "LXXX,80"})
	public void shouldConvertMultipleOfTenToLXs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"XC,90", "C,100", "CX,110", "CXX,120"})
	public void shouldConvertLowerHundredsToLXs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"CC,200", "CCC,300", "CD,400", "D,500", "DC,600"})
	public void shouldConvertMiddleHundredsToLXs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"CM,900", "M,1000", "MC,1100", "MM,2000"})
	public void shouldConvertThousandsToMs(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}
	
	@Test
	@Parameters(value={"MMCMLXXXVII,2987", "MDCCCXLIII,1843"})
	public void shouldConvertCompleteArabicNumbersToRomanNumbers(String roman, int arabic) throws Exception {
		assertThat(new NumeralsConverter().convertToArabic(roman)).isEqualTo(arabic);
	}}
