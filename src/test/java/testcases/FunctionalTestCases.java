package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.AuthorBookListPage;
import pages.AuthorPage;
import pages.CheckoutDetails;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderProceed1;
import pages.OrderProceed2;
import pages.myAccountPage;
import utilities.Dataset;
import utilities.DriverSetup;

public class FunctionalTestCases extends DriverSetup{

	HomePage hp= new HomePage();
	LoginPage login= new LoginPage();
	AuthorPage auth= new AuthorPage();
	myAccountPage myacc= new myAccountPage();
	AuthorBookListPage auth_book= new AuthorBookListPage();
	OrderProceed1 ordr1= new OrderProceed1();
	OrderProceed2 ordr2= new OrderProceed2();
	CheckoutDetails checkout= new CheckoutDetails();
	
	
	@Test(priority = 1, description = "LoginTest")
	public void loginTest(){
		getDriver().get(hp.URL);
		assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/");

	}
	
	@Test(priority = 2, description = "Testing Login Button clcickable or not")
	public void loginButtonTest() {
		getDriver().get(hp.URL);
		WebElement logInBtn= hp.getElement(hp.login_btn);
		logInBtn.click();
		assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/my-account/");
		
	}
	
	
	@Test(priority = 3, description = "Wrong Emails", dataProvider = "invalidEmails", dataProviderClass = Dataset.class)
	public void emailCheckWithSpecialCharacters(String email, String pass, String msg) {
		getDriver().get("https://www.wafilife.com/my-account/");
		login.doLogin(email, pass);
		String error= login.getElementText(login.wrong_email_error_msg);
		assertEquals(error, "Error: The username @@##^^ is not registered on this site. If you are unsure of your username, try your email address instead.");
		
		
	}
	
	
	@Test(priority = 4, description = "No Input", dataProvider = "noCredentials", dataProviderClass = Dataset.class)
	public void noMailPass(String mail, String pass, String msg) {
		getDriver().get("https://www.wafilife.com/my-account/");
		login.doLogin(mail, pass);
		String error= login.getElementText(login.empty_mail_pass);
		assertEquals(error, "Error: ইউজার নাম প্রয়োজন");
	}
	
	
	@Test(priority = 5, description = "username with no password", dataProvider = "noPassword", dataProviderClass = Dataset.class)
	public void noPass(String mail, String pass, String msg) {
		getDriver().get("https://www.wafilife.com/my-account/");
		login.doLogin(mail, pass);
		String error= login.getElementText(login.no_pass_err_msg);
		assertEquals(error, "Error: The password field is empty.");
	}
	
	
	@Test(priority = 6, description = "Check correct login", dataProvider = "rightCredentials", dataProviderClass = Dataset.class)
	public void rightMailPass(String mail, String pass) {
		getDriver().get("https://www.wafilife.com/my-account/");
		login.doLogin(mail, pass);
		WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("লগআউট")));
		boolean yes= getDriver().findElement(By.linkText("লগআউট")).isDisplayed();
		
		if (yes) {
			System.out.println("Successfully logged in ");
		}
		else {
			System.out.println("Try again.");
		}
	}
	
	
	@Test(priority = 7, description = "Lekhok button check")
	public void lekhokBtnCheck() {
		getDriver().get(hp.URL);
		hp.clickOnElement(hp.LEKHOK);
		
		assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/cat/books/author/");
	}
	
	
	@Test(priority = 8, description = "Ainun Nishat button clickable?")
	public void ainunNishatButtonCheck() {
		getDriver().get("https://www.wafilife.com/cat/books/author/");
		Actions action = new Actions(getDriver());
		WebElement aut= auth.getElement(auth.AUTHOR_NAME);
		action.scrollToElement(aut);
		aut.click();
		assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/cat/books/author/ainun-nishat/");
		System.out.println(getDriver().getCurrentUrl());
	}
	
	
	@Test(priority = 9, description = "choosing a book from list")
	public void clickAbookFromList() {
		getDriver().get("https://www.wafilife.com/cat/books/author/ainun-nishat/?removed_item=1");
		auth_book.bookDetails();
		assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/shop/books/community-partnership-for-sustainable-water-management-experience-of-the-bwdb-systems-rehabitation-project-engineering-evaluation-volume-3");
	}
	
	
	@Test(priority = 10, description = "Order korun button works?")
	public void orderButtonCheck() {
		getDriver().get("https://www.wafilife.com/shop/books/community-partnership-for-sustainable-water-management-experience-of-the-bwdb-systems-rehabitation-project-engineering-evaluation-volume-3");
		ordr1.clickOrder();
		WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("অর্ডার সম্পন্ন করুন")));
		boolean t= getDriver().findElement(By.linkText("অর্ডার সম্পন্ন করুন")).isDisplayed();
		
		if(t) {
			System.out.println("order korun button works");
		}
		else {
			System.out.println("try again!");
		}
	}
	
	
	@Test(priority = 11, description = "Checkout button clickable?")
	public void checkoutBottonClickable() {
		getDriver().get("https://www.wafilife.com/shop/books/community-partnership-for-sustainable-water-management-experience-of-the-bwdb-systems-rehabitation-project-engineering-evaluation-volume-3");
		ordr1.clickOrder();
		WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("অর্ডার সম্পন্ন করুন")));
		getDriver().findElement(By.linkText("অর্ডার সম্পন্ন করুন")).click();
		assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/checkout/");
		System.out.println("Checkout button works");
		
	}
	
	
	@Test(priority = 12, description = "No giving information works?")
	public void confirmOrderWithAllEmptyField() {
		getDriver().get("https://www.wafilife.com/cat/books/author/ainun-nishat/?removed_item=1");
		auth_book.bookDetails();
		ordr1.clickOrder();
		WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("অর্ডার সম্পন্ন করুন")));
		getDriver().findElement(By.linkText("অর্ডার সম্পন্ন করুন")).click();
		
		WebElement placeOrder= getDriver().findElement(By.xpath("//button[@id='place_order']"));
		JavascriptExecutor js= (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView()", placeOrder);
		placeOrder.click();
		WebDriverWait waitPopUp= new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("\"//ul[@class='woocommerce-error']\"")));
		String msg= getDriver().findElement(By.xpath("\"//ul[@class='woocommerce-error']\"")).getText();
		assertEquals(msg, "আপনার নাম দিন\r\n"
				+ "আপনার ফোন নাম্বার ইংরেজিতে দিন\r\n"
				+ "আপনার এরিয়া/উপজেলা দিন\r\n"
				+ "আপনার পূর্ণ ঠিকানা দিন");
		
		System.out.println("Details dewa lagbe");
		
		
	}

	
}
