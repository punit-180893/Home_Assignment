package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class MyAccountPage  extends GenericsMethod{
	
	WebDriver driver;
//	Page Factory
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
//	locators
	@FindBy(how = How.LINK_TEXT, using="My Account")
	private WebElement textMyAccount;
	
	@FindBy(how = How.NAME, using = "email")
	private WebElement textEmail;
	
	@FindBy(how = How.ID, using = "reg_password")
	private WebElement textPassword;
	
	@FindBy(how = How.NAME,using= "register")
	private WebElement buttonRegistration;
//	Action methods
	public void clickMyAccount() {
		explicitWaitOnClick(driver, textMyAccount, 10);
	}
	
	public void enterRegistrationDetalis(String email, String password) {
		explicitWaitOnSendkeys(driver, textEmail, 10, email);
		explicitWaitOnSendkeys(driver, textPassword, 10, password);
	}
	public void clickRegistration() {
		
		explicitWaitOnClick(driver, buttonRegistration, 10);
	}
}
