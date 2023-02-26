package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
	
	public By username= By.xpath("//input[@id='username']");
	public By passowrd= By.xpath("//input[@id='password']");
	public By Login_BTN= By.xpath("//input[@name='login']");
	
	
	public void doLogin() throws InterruptedException {
		//username
		clickOnElement(username);
		Thread.sleep(2000);
		inputText(username, "tigen52205@wireps.com");
		
		//password
		clickOnElement(passowrd);
		Thread.sleep(2000);
		inputText(passowrd, "1234567890");
		
		//login
		Thread.sleep(2000);
		clickOnElement(Login_BTN);
		
	}

}
