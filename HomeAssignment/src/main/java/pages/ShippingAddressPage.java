package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class ShippingAddressPage extends GenericsMethod {
	
	WebDriver driver;
	public ShippingAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//a[contains(text(),'Addresses')]")
	private WebElement textLinkAddresses;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")
	private WebElement textLinkEdit;
	
	@FindBy(how = How.ID,using = "shipping_first_name")
	private WebElement textFieldFirstName;
	
	@FindBy(how = How.ID, using = "shipping_last_name")
	private WebElement textFieldLastName;
	
	@FindBy(how = How.ID, using = "shipping_company")
	private WebElement textFieldCompany;
	
	@FindBy(how = How.ID, using = "shipping_address_1")
	private WebElement textFieldAddress;
	
	@FindBy(how = How.ID, using = "shipping_city")
	private WebElement textFieldCity;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_shipping_state\"]/a")
	private WebElement dropState;
	
	@FindBy(how = How.ID, using="s2id_autogen2_search")
	private WebElement dropSearch;
	
	@FindBy(how = How.ID, using = "shipping_postcode")
	private WebElement textFieldPinCode;
	
	@FindBy(how = How.NAME, using = "save_address")
	private WebElement buttonSaveAddress;
	
	
	public void clickOnAddressAndEdit() {
		explicitWaitOnClick(driver, textLinkAddresses, 10);
		explicitWaitOnClick(driver, textLinkEdit, 10);
	}
	
	public void enterAddressDetails(String firstname,String lastname,String company,
			String address, String city,String state,String pin) {
		explicitWaitOnSendkeys(driver, textFieldFirstName, 10, firstname);
		explicitWaitOnSendkeys(driver, textFieldLastName, 10, lastname);
		explicitWaitOnSendkeys(driver, textFieldCompany, 10, company);
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
