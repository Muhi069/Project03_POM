package pages;

import org.openqa.selenium.By;

public class AuthorBookListPage extends BasePage{
	
	public By CHOSEN_BOOK= By.xpath("//div[@class='product_thumbnail_wrapper']//a");
	
	public void bookDetails() {
		clickOnElement(CHOSEN_BOOK);
	}

}
