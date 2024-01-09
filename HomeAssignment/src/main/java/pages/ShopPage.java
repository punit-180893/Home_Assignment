package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class ShopPage extends GenericsMethod {
	WebDriver driver;
	//		Page Factory
	public ShopPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	//locators
	@FindBy(how = How.LINK_TEXT,using="Shop")
	private WebElement shopTextLink;

	@FindBy(how = How.LINK_TEXT,using="selenium")
	WebElement seleniumTextLink;

	@FindBy(how=How.XPATH,using = "//*[@id=\"content\"]/ul/li/a[2]")
	private WebElement buttonReadMore;
	//Actions methods
	public void clickOnShop() {
		explicitWaitOnClick(driver,shopTextLink,10);
	}
	public void clickOnSeleniumTextLink(){
		explicitWaitOnClick(driver, seleniumTextLink, 10);
	}
	public void clickOnReadMore(){
		scroll(driver);
		explicitWaitOnClick(driver, buttonReadMore, 10);
	}
}
