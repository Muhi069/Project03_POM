package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.AuthorBookListPage;
import pages.AuthorPage;
import pages.BasePage;
import pages.CheckoutDetails;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderProceed1;
import pages.OrderProceed2;
import pages.myAccountPage;
import utilities.Dataset;
import utilities.DriverSetup;

public class FullTest extends DriverSetup{
	
	HomePage hp= new HomePage();
	LoginPage login= new LoginPage();
	AuthorPage auth= new AuthorPage();
	myAccountPage myacc= new myAccountPage();
	AuthorBookListPage auth_book= new AuthorBookListPage();
	OrderProceed1 ordr1= new OrderProceed1();
	OrderProceed2 ordr2= new OrderProceed2();
	CheckoutDetails checkout= new CheckoutDetails();
	
	@Test(priority = 0, description = "full automation")
	public void automate() {
		hp.clickAuthor();
		login.doLogin("tigen52205@wireps.com", "1234567890");
		myacc.clickAuthor();
		auth.clickAuthorname();
		auth_book.bookDetails();
		ordr1.clickOrder();
		ordr2.clickCheckout();
		checkout.fillInDetails();
	}
}
