package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AuthorPage extends BasePage{
	
	public By AUTHOR_NAME= By.xpath("//h3[normalize-space()='Ainun Nishat']");
	
	public void clickAuthorname() {
		WebElement authorName= getElement(AUTHOR_NAME);
		JavascriptExecutor js= (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView()", authorName);
		explicitWait(AUTHOR_NAME);
		clickOnElement(AUTHOR_NAME);
	}

}
