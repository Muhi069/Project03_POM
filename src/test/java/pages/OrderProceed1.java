package pages;

import org.openqa.selenium.By;

public class OrderProceed1 extends BasePage{
	
	public By Order_korun= By.xpath("//div[@class='body-wrapper']//button[2]");
	
	public void clickOrder() {
		clickOnElement(Order_korun);
	}
	
}
