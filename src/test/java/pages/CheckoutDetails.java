package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutDetails extends BasePage{
	
	public By namefield= By.xpath("//input[@id='billing_first_name']");
	public By contact= By.xpath("//input[@id='billing_phone']");
	public By email= By.xpath("//input[@id='billing_email']");
	public By district= By.xpath("(//span[@id='select2-billing_state-container'])[1]");
	public By district_input= By.xpath("//input[@role='combobox']");
	public By area= By.xpath("//select[@id='billing_area']");
	public By address= By.xpath("(//textarea[@id='billing_address_1'])[1]");
	public By bKash= By.xpath("//label[contains(text(),'বিকাশ')]");
	
	
	public void fillInDetails() throws InterruptedException {
		//give name
		clickOnElement(namefield);
		Thread.sleep(2000);
		inputText(namefield, "Al Mutasim Hasan Muhi");
		Thread.sleep(2000);
		
		//phone number
		clickOnElement(contact);
		Thread.sleep(2000);
		inputText(contact, "01634546430");
		Thread.sleep(2000);
		
		//email 
		clickOnElement(email);
		Thread.sleep(2000);
		inputText(email, "kalabhuna00019@gmail.com");
		Thread.sleep(2000);
		
		//district
		clickOnElement(district);
		Thread.sleep(2000);
		inputText(district_input, "Bogu");
		Thread.sleep(2000);
		Actions action= new Actions(getDriver());
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		//area
		WebElement jela= getElement(area);
		jela.click();
		Thread.sleep(2000);
		Select select= new Select(jela);
		select.selectByValue("123");
		Thread.sleep(2000);
		
		//address
		clickOnElement(address);
		Thread.sleep(2000);
		inputText(address, "Malgram Moddhopara, Bogura");
		Thread.sleep(3000);
		
		//bkash
		WebElement bkashPay= getElement(bKash);
		bkashPay.click();
		Thread.sleep(2000);
		
	}

}
