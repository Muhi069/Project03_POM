package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{
	
	public By username= By.xpath("//input[@id='username']");
	public By passowrd= By.xpath("//input[@id='password']");
	public By Login_BTN= By.xpath("//input[@name='login']");
	public By wrong_email_error_msg= By.xpath("//li[contains(text(),'The username')]");
	public By empty_mail_pass= By.xpath("//li[contains(text(),'ইউজার নাম প্রয়োজন')]");
	public By no_pass_err_msg = By.xpath("//div[@id='main-module-container']//li[1]");
	
	@Test
	public void doLogin(String email, String pass) {
		inputText(username, email);
		inputText(passowrd, pass);

		explicitWait(Login_BTN);
		clickOnElement(Login_BTN);
		
	}

}
