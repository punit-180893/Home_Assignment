package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class BillingAddressPage extends GenericsMethod {

//	Page Factory
	
	WebDriver driver;
	public BillingAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
//	Locators
	
	@FindBy(how = How.XPATH, using="//a[contains(text(),'Addresses')]")
	private WebElement textLinkAddresses;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/a")
	private WebElement textLinkEdit;
	
	@FindBy(how = How.ID,using = "billing_first_name")
	private WebElement textFieldFirstName;
	
	@FindBy(how = How.ID, using = "billing_last_name")
	private WebElement textFieldLastName;
	
	@FindBy(how = How.ID, using = "billing_company")
	private WebElement textFieldCompany;
	
	@FindBy(how = How.ID, using = "billing_phone")
	private WebElement textFieldPhone;
	
	@FindBy(how = How.ID, using = "billing_address_1")
	private WebElement textFieldAddress;
	
	@FindBy(how = How.ID, using = "billing_city")
	private WebElement textFieldCity;

	@FindBy(how = How.ID, using = "s2id_billing_state")
	private WebElement dropState;
	
	@FindBy(how = How.ID, using = "billing_postcode")
	private WebElement textFieldPinCode;
	
	@FindBy(how = How.ID,using="s2id_autogen2_search")
	private WebElement dropSearch;
	
	@FindBy(how = How.NAME, using = "save_address")
	private WebElement buttonSaveAddress;
	
//	Action Methods
	
	public void clickOnAddressAndEdit() {
		explicitWaitOnClick(driver, textLinkAddresses, 10);
		explicitWaitOnClick(driver, textLinkEdit, 10);
	}
	public void enterAddressDetails(String firstname,String lastname,String company,
			String phone,String address, String city,String state,String pin) {
		explicitWaitOnSendkeys(driver, textFieldFirstName, 10, firstname);
		explicitWaitOnSendkeys(driver, textFieldLastName, 10, lastname);
		explicitWaitOnSendkeys(driver, textFieldCompany, 10, company);
		explicitWaitOnSendkeys(driver, textFieldPhone, 10, phone);
		explicitWaitOnSendkeys(driver, textFieldAddress, 10, address);
		explicitWaitOnSendkeys(driver, textFieldCity, 10, city);
		explicitWaitOnClick(driver, dropState, 10);
		dropSearch.sendKeys(state,Keys.ENTER);
		
		explicitWaitOnSendkeys(driver, textFieldPinCode, 10, pin);
		
	}
	
	public void clickOnSaveAddress() {
		explicitWaitOnClick(driver, buttonSaveAddress, 10);
	}
	
}
