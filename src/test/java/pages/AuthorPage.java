package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AuthorPage extends BasePage{
	
	public By AUTHOR_NAME= By.xpath("//h3[normalize-space()='Ainun Nishat']");
	
	public void clickAuthorname() throws InterruptedException {
		WebElement authorName= getElement(AUTHOR_NAME);
		JavascriptExecutor js= (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView()", authorName);
		Thread.sleep(2000);
		clickOnElement(AUTHOR_NAME);
	}

}
