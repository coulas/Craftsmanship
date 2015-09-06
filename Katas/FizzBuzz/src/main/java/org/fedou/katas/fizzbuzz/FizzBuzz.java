package org.fedou.katas.fizzbuzz;

public class FizzBuzz {

	public String compute(String input) {
		StringBuilder result = new StringBuilder();
		int number = Integer.parseInt(input);
		if (number % 3 == 0) {
			result.append("Fizz");
		}
		if (number % 5 == 0) {
			result.append("Buzz");
		}
		return result.length() == 0 ? input : result.toString();
	}

}
