package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends BasePage{
	
	public By LEKHOK= By.linkText("লেখক");
	public String URL= "https://www.wafilife.com/";
	public By login_btn= By.cssSelector("div[class='login-links'] a[title='আমার অ্যাকাউন্ট']");
	
	
	public void clickAuthor() {
		//click on lekhok
		getDriver().get(URL);
		clickOnElement(login_btn);
	}
	
}
