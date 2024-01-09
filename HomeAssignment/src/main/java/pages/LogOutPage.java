package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class LogOutPage extends GenericsMethod{

WebDriver driver;
//	Page Factory
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
//	locators
	@FindBy(how =How.XPATH, using = "//a[contains(text(),'Logout')]")
	private WebElement textLinkLogout;
//	Actions
	public void clickOnLogout() {
		explicitWaitOnClick(driver, textLinkLogout, 10);
	}
}
