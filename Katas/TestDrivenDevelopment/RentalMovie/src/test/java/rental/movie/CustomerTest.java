package rental.movie;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CustomerTest {
	@Test
	public void should_emptyStatement() throws Exception {
		assertThat(givenASimpleCustomer().statement()).isEqualTo(
			"Rental Record for test\nAmount owed is 0.0\nYou earned 0 frequent renter points");
	}
	
	private Customer givenASimpleCustomer() {
		return new Customer("test");
	}
	
	@Test
	@Parameters({ "1, 2.0", "2, 2.0", "3, 3.5", "4, 5.0" })
	public void should_state_regular_rental_for_several_days(int days, String cost) throws Exception {
		final Customer customer = givenASimpleCustomer();
		customer.addRental(new Rental(new Movie("title", MoviePricing.REGULAR), days));
		assertThat(customer.statement()).isEqualTo(
			"Rental Record for test\n\ttitle\t" + cost + "\nAmount owed is " + cost
				+ "\nYou earned 1 frequent renter points");
	}
	
	@Test
	@Parameters({ "1, 3.0, 1", "2, 6.0, 2", "3, 9.0, 2", "4, 12.0, 2" })
	public void should_state_new_release_rental_for_several_days(int days, String cost, int frequentPoints)
		throws Exception {
		final Customer customer = givenASimpleCustomer();
		customer.addRental(new Rental(new Movie("title", MoviePricing.NEW_RELEASE), days));
		assertThat(customer.statement()).isEqualTo(
			"Rental Record for test\n\ttitle\t" + cost + "\nAmount owed is " + cost
				+ "\nYou earned " + frequentPoints + " frequent renter points");
	}
	
	@Test
	@Parameters({ "1, 1.5", "2, 1.5", "3, 1.5", "4, 3.0", "5, 4.5" })
	public void should_state_children_rental_for_several_days(int days, String cost) throws Exception {
		final Customer customer = givenASimpleCustomer();
		customer.addRental(new Rental(new Movie("title", MoviePricing.CHILDRENS), days));
		assertThat(customer.statement()).isEqualTo(
			"Rental Record for test\n\ttitle\t" + cost + "\nAmount owed is " + cost
				+ "\nYou earned 1 frequent renter points");
	}
	
	@Test
	public void should_state_several_rentals() throws Exception {
		final Customer customer = givenASimpleCustomer();
		customer.addRental(new Rental(new Movie("title", MoviePricing.REGULAR), 5));
		customer.addRental(new Rental(new Movie("eltit", MoviePricing.REGULAR), 5));
		assertThat(customer.statement())
			.isEqualTo(
				"Rental Record for test\n\ttitle\t6.5\n\teltit\t6.5\nAmount owed is 13.0\nYou earned 2 frequent renter points");
	}
	
	@Test(expected = NullPointerException.class)
	public void should_state_without_rental_type() throws Exception {
		final Customer customer = givenASimpleCustomer();
		customer.addRental(new Rental(new Movie("title", null), 1));
		customer.statement();
	}
}
