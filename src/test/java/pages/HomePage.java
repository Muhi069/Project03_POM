package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends BasePage{
	
	public By LEKHOK= By.linkText("লেখক");
	public String URL= "https://www.wafilife.com/";
	
	
	public void clickAuthor() {
		//click on lekhok
		getDriver().get(URL);
		clickOnElement(LEKHOK);
	}
	
}
