package rental.movie;

public class Movie {
	private String _title;
	
	private MoviePricing _priceCode;
	
	public Movie(String title, MoviePricing priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	
	public MoviePricing getPriceMaker() {
		return _priceCode;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public double makePrice(int daysRented) {
		return _priceCode.makePrice(daysRented);
	}
	
	public int makeFrequentRenterPoints(int daysRented) {
		return _priceCode.makeFrequentRenterPoints(daysRented);
	}
}
