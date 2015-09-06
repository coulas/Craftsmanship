package org.fedou.kata.leapyears;

public class LeapYears {
	
	public boolean isLeapYear(int year) {
		// more common cases first
		if (year % 4 == 0) {
			// then less common
			if (year % 100 == 0) {
				// rare or exceptional cases last
				if (year % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	
}
