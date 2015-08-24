package rental.movie;

public enum MoviePricing {
	REGULAR {
		@Override
		public double makePrice(int daysRented) {
			double thisAmount = 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;
			return thisAmount;
		}
	},
	NEW_RELEASE {
		@Override
		public double makePrice(int daysRented) {
			return daysRented * 3;
		}
		
		@Override
		public int makeFrequentRenterPoints(int daysRented) {
			int points = super.makeFrequentRenterPoints(daysRented);
			if (daysRented > 1) {
				points += 1;
			}
			return points;
		}
		
	},
	CHILDRENS {
		@Override
		public double makePrice(int daysRented) {
			double thisAmount = 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			return thisAmount;
		}
	};
	
	public abstract double makePrice(int daysRented);
	
	public int makeFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
