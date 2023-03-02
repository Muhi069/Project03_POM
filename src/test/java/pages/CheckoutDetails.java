package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutDetails extends BasePage{
	
	public By namefield= By.xpath("//input[@id='billing_first_name']");
	public By contact= By.xpath("//input[@id='billing_phone']");
	public By email= By.xpath("//input[@id='billing_email']");
	public By district= By.xpath("(//span[@id='select2-billing_state-container'])[1]");
	public By district_input= By.xpath("//input[@role='combobox']");
	public By area= By.xpath("//select[@id='billing_area']");
	public By address= By.xpath("(//textarea[@id='billing_address_1'])[1]");
	public By bKash= By.xpath("//label[contains(text(),'বিকাশ')]");
	
	
	public void fillInDetails() {
		//give name
		explicitWait(namefield);
		clickOnElement(namefield);
		WebElement nameField= getElement(namefield);
		nameField.clear();
		nameField.sendKeys("Al Mutasim Hasan Muhi");
		
		
		//phone number
		explicitWait(contact);
		clickOnElement(contact);
		WebElement Contact= getElement(contact);
		Contact.clear();
		Contact.sendKeys("01634546430");
		
		//email 
		explicitWait(email);
		clickOnElement(email);
		WebElement Email= getElement(email);
		Email.clear();
		Email.sendKeys("kalabhuna00019@gmail.com");
		
		//district
		explicitWait(district);
		clickOnElement(district);
		inputText(district_input, "Bogu");
		//getDriver().wait(1);
		Actions action= new Actions(getDriver());
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		//getDriver().wait(1);
		action.sendKeys(Keys.ENTER).build().perform();
		
		
		//area
		explicitWait(area);
		WebElement jela= getElement(area);
		WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(jela));
		jela.click();
		
		Select select= new Select(jela);
		select.selectByValue("123");
		
		
		//address
		explicitWait(address);
		clickOnElement(address);
		inputText(address, "Malgram Moddhopara, Bogura");
		
		//bkash
		WebElement bkashPay= getElement(bKash);
		bkashPay.click();
		
	}

}
