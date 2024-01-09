package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class OrderPage extends GenericsMethod{
	
	WebDriver driver;
//	Page Fatory.
	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
//	locators
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Orders')]")
	private WebElement textLinkOrder;
//	Action methods
	public void clickOnOrders() {
		explicitWaitOnClick(driver, textLinkOrder, 10);
	}

}
