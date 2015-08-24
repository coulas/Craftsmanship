package rental.movie;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	
	private List<Rental> _rentals = new ArrayList<Rental>();
	
	private int frequentRenterPoints = 0;
	
	public Customer(String name) {
		_name = name;
	};
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
		frequentRenterPoints += arg.getFrequentRenterPoints();
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		double totalAmount = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : _rentals) {
			
			// determine amounts for each line
			double thisAmount = each.getRentAmount();
			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" +
				String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
			
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) +
			" frequent renter points";
		return result;
	}
	
}
