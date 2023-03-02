package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{
	
	public By username= By.xpath("//input[@id='username']");
	public By passowrd= By.xpath("//input[@id='password']");
	public By Login_BTN= By.xpath("//input[@name='login']");
	
	@Test
	public void doLogin() {
		//username
		getDriver().get("https://www.wafilife.com/my-account/");
		explicitWait(username);
		clickOnElement(username);
		inputText(username, "tigen52205@wireps.com");
		
		//password
		explicitWait(passowrd);
		clickOnElement(passowrd);
		inputText(passowrd, "1234567890");
		
		//login
		explicitWait(Login_BTN);
		clickOnElement(Login_BTN);
		
	}

}
