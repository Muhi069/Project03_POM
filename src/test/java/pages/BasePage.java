package pages;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Allure;
import utilities.DriverSetup;

public class BasePage extends DriverSetup{

	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
	}
	
	public void clickOnElement(By locator) {
		getElement(locator).click();
	}
	
	public void inputText(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
	
	public void getElementText(By locator) {
		getElement(locator).getText();
	}
	
	public void takeSS(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
	
	
	
}
