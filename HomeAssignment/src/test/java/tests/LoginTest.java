package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AccountDetailsPage;
import pages.BillingAddressPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.OrderPage;
import pages.ShippingAddressPage;
import utils.BaseClass;
import utils.ExcelReader;
@Listeners(testnglisteners.TestListeners.class)
public class LoginTest extends BaseClass {
	
//	Reference Variables.
	LoginPage loginpage;
	AccountDetailsPage accountDetailsPage;
	OrderPage orderpage;
	LogOutPage logoutpage;
	BillingAddressPage billingpage;
	ShippingAddressPage shippingpage;
//	logger
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
//	Soft Assertion declare
	SoftAssert softAssert = new SoftAssert();
	
//	login test method.
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "XLSheet")
	public void loginTest(String username, String password){
		loginpage = new LoginPage(driver);
		logger.info("Driver initialization done.");
		loginpage.clickMyAccount();
		logger.info("My Account is clicked.");
		loginpage.enterLoginDetails(username, password);
		logger.info("Data insrted.");
		loginpage.clickLogin();
		logger.info("Login button clicked.");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		logger.info("Assertion checked.");
		softAssert.assertAll();
	}

	
//	Account details test depend on login test.
	@Test( dataProviderClass = ExcelReader.class, dataProvider = "XLSheet", dependsOnMethods = "loginTest" )
	public void accountDetailsTest( String firstname, String lastname ) {
		accountDetailsPage = new AccountDetailsPage(driver);
		logger.info("Driver initialization done.");
		accountDetailsPage.clickOnAccountDetails();
		logger.info("Clicked on Account deatails");
		accountDetailsPage.enterAccountDetails(firstname, lastname);
		logger.info("Data inserted.");
		accountDetailsPage.clickOnSaveAccountDetails();
		logger.info("Clicked on Save acount Details.");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		softAssert.assertAll();
	}
//	billing Address method.
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "XLSheet" , dependsOnMethods = "loginTest")
	public void BillingAddressTest( String firstname,String lastname,String company, String phone,String address,
									 String city,String state,String pin){
		billingpage = new BillingAddressPage(driver);
		logger.info("Driver initialization done.");
		billingpage.clickOnAddressAndEdit();
		logger.info("click on Addresses then edit.");
		billingpage.enterAddressDetails(firstname, 
				(lastname), company, phone, address, city, state, pin);
		logger.info("Data inserted.");
		billingpage.clickOnSaveAddress();
		logger.info("Click on save address button.");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		softAssert.assertAll();
	}
	
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "XLSheet" , dependsOnMethods = "loginTest")
	public void shippingAddressTest(String firstname,String lastname,String company, String phone,String address,
			 String city,String state,String pin) {
		
		shippingpage = new ShippingAddressPage(driver);
		logger.info("Driver initialization done.");
		shippingpage.clickOnAddressAndEdit();
		logger.info("Click on shipping Addresses and edit");
		shippingpage.enterAddressDetails(firstname, lastname, company, address, city, state, pin);
		logger.info("Data inserted in shipping form");
		shippingpage.clickOnSaveAddress();
		logger.info("Click on save button");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		softAssert.assertAll();
		logger.info("Shipping assertion complete");
	}
	
//	Order test calling method 
	@Test(dependsOnMethods = "loginTest")
	public void orderTest() {
		orderpage = new OrderPage(driver);
		logger.info("Driver initialization done.");
		orderpage.clickOnOrders();
		logger.info("click on Orders.");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		softAssert.assertAll();
		logger.info("Order Test Assertion done.");
	}
	
//	logout function method.
	@Test(dependsOnMethods = "loginTest")
	public void logoutTest() {
		logoutpage = new LogOutPage(driver);
		logger.info("Driver initialization done.");
		logoutpage.clickOnLogout();
		logger.info("Click on Logout");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		softAssert.assertAll();
		logger.info("logout Assertion done.");
	}
}
