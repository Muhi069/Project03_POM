package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProceed2 extends BasePage{
	
	public By CHECKOUT= By.cssSelector("a[title='checkout'] span");
	
	public void clickCheckout() {
		explicitWait(CHECKOUT);
		clickOnElement(CHECKOUT);
	}

}
