package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ShopPage;
import utils.BaseClass;

@Listeners(testnglisteners.TestListeners.class)
public class ShopTest extends BaseClass{

//	logger
	private static final Logger logger = LogManager.getLogger(ShopTest.class);
//	Soft Assertion declare
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void testShop(){
		ShopPage shoppage = new ShopPage(driver);
		logger.info("Driver initialized.");
		shoppage.clickOnShop();
		logger.info("Clicked on Shop link.");
		shoppage.clickOnSeleniumTextLink();
		logger.info("Clicked on selenium link.");
		shoppage.clickOnReadMore();
		logger.info("Clicked in read more.");
		softAssert.assertEquals(driver.getTitle(), "Selenium Ruby – Automation Practice Site");
		softAssert.assertAll();
		logger.info("Shop Page assertion checked.");
	}

}
