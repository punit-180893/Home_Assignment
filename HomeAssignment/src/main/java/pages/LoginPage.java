package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.GenericsMethod;

public class LoginPage extends GenericsMethod {
WebDriver driver;
//	Page Factory

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
//	Locators
	
	@FindBy(how = How.XPATH, using="//*[@id=\"menu-item-50\"]/a")
	private WebElement textMyAccount;
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement textUsername;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement textPassword;
	
	@FindBy(how = How.NAME,using= "login")
	private WebElement buttonLogin;
	
//	Action Methods
	
	public void clickMyAccount() {
		explicitWaitOnClick(driver, textMyAccount, 10);
	}
	public void enterLoginDetails(String username, String password) {
		explicitWaitOnSendkeys(driver, textUsername, 10, username);
		explicitWaitOnSendkeys(driver, textPassword, 10, password);
	}
	public void clickLogin(){
		explicitWaitOnClick(driver, buttonLogin, 10);
		
	}
}

