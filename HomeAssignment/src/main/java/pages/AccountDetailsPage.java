package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class AccountDetailsPage extends GenericsMethod{
//	Page Factory
	WebDriver driver;
	public AccountDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
//	Locators 
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Account Details')]")
	private WebElement textAccountDetails;
	
	@FindBy(how = How.ID, using = "account_first_name")
	private WebElement textFieldFirstName;
	
	@FindBy(how = How.ID, using = "account_last_name")
	private WebElement textFieldlastName;
	
	@FindBy(how = How.NAME,using = "save_account_details")
	private WebElement buttonSaveAccountDetails;
	
//	Action Method
	
	public void clickOnAccountDetails() {
		explicitWaitOnClick(driver, textAccountDetails, 10);
	}
	
	public void enterAccountDetails(String firstname,String lastname) {
		explicitWaitOnSendkeys(driver, textFieldFirstName, 10, firstname);
		explicitWaitOnSendkeys(driver, textFieldlastName, 10, lastname);
	}
	
	public void clickOnSaveAccountDetails() {
		explicitWaitOnClick(driver, buttonSaveAccountDetails, 10);
	}

}
