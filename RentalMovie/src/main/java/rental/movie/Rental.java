package rental.movie;

public class Rental {
	private Movie _movie;
	
	private int _daysRented;
	
	private double rentAmount;
	
	private int frequentRenterPoints;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
		rentAmount = calculateRentalAmount();
		frequentRenterPoints = calculateFrequentRenterPoints();
	}
	
	public int getDaysRented() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
	
	private double calculateRentalAmount() {
		return _movie.makePrice(_daysRented);
	}
	
	private int calculateFrequentRenterPoints() {
		return _movie.makeFrequentRenterPoints(_daysRented);
	}
	
}
