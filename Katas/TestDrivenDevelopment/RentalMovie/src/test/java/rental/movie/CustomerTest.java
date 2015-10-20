package rental.movie;

import junitparams.Parameters;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

	@Test
	public void should_state_several_rentals() throws Exception {
		final Customer customer = new Customer("test");
		customer.addRental(new Rental(new Movie("title", Movie.REGULAR), 5));
		customer.addRental(new Rental(new Movie("eltit", Movie.REGULAR), 5));
		assertThat(customer.statement())
			.isEqualTo(
				"Rental Record for test\n\ttitle\t6.5\n\teltit\t6.5\nAmount owed is 13.0\nYou earned 2 frequent renter points");
	}
	
}
