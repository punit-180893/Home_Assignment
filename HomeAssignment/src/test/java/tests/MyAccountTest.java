package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MyAccountPage;
import utils.BaseClass;
import utils.ExcelReader;
@Listeners(testnglisteners.TestListeners.class)
public class MyAccountTest extends BaseClass {
	
//	logger
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
//	Soft Assertion declare
	SoftAssert softAssert = new SoftAssert();
	
	
//	Creating my account.
	@Test (dataProviderClass = ExcelReader.class, dataProvider = "XLSheet")
	public void createAccount(String email,String password ) {
		MyAccountPage account = new MyAccountPage(driver);
		logger.info("Driver initialization done.");
		account.clickMyAccount();
		logger.info("Clicked on My Account");
		account.enterRegistrationDetalis(email, password);
		logger.info("Account Creation data inserted.");
//		account.clickRegistration();
		logger.info("Clicked on Registration button.");
		softAssert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		softAssert.assertAll();
		logger.info("Create account assertion checked.");
	}
}
