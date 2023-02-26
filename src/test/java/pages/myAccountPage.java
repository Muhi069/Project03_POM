package pages;

import org.openqa.selenium.By;

public class myAccountPage extends BasePage{
	
	public By LEKHOK= By.linkText("লেখক");
	
	public void clickAuthor() {
		clickOnElement(LEKHOK);
	}

}
