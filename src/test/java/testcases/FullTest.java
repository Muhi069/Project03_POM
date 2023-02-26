package testcases;

import org.testng.annotations.Test;

import pages.AuthorBookListPage;
import pages.AuthorPage;
import pages.CheckoutDetails;
import pages.HomePage;
import pages.OrderProceed1;
import pages.OrderProceed2;
import utilities.DriverSetup;

public class FullTest extends DriverSetup{
	
	HomePage hp= new HomePage();
	AuthorPage auth= new AuthorPage();
	AuthorBookListPage auth_book= new AuthorBookListPage();
	OrderProceed1 ordr1= new OrderProceed1();
	OrderProceed2 ordr2= new OrderProceed2();
	CheckoutDetails checkout= new CheckoutDetails();
	
	@Test
	public void automate() throws InterruptedException {
		hp.clickAuthor();
		auth.clickAuthorname();
		auth_book.bookDetails();
		ordr1.clickOrder();
		ordr2.clickCheckout();
		checkout.fillInDetails();
	}
	

}
