package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericsMethod {
	static WebDriver driver;
	
	/* 
	 * use driver wait and  click operation
	 *  */
	public void explicitWaitOnClick(WebDriver driver,WebElement elements,int waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTimeInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elements));
		element.click();
	}
	
	/* 
	 * use driver wait and sendKeys operation.
	 *  */
	public static void explicitWaitOnSendkeys(WebDriver driver, WebElement elements, int waitTimeInSeconds,String value){
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(waitTimeInSeconds));
		WebElement element=wait	.until(ExpectedConditions.elementToBeClickable(elements));
		element.click();
		element.clear();
		element.sendKeys(value);
		}
	/* 
	 * Scroll
	 *  */
	public void scroll(WebDriver driver) {
		JavascriptExecutor javascriptexecuter = (JavascriptExecutor)driver;
		javascriptexecuter.executeScript("scroll(0,100)");
	}
	/* 
	 * Select element from a drop down box.
	 *  */
	public void selectByVisibilityText(WebElement element, String text) throws InterruptedException {
		Select select = new Select(element);
		Thread.sleep(1000);
		select.selectByVisibleText(text);
	}
	
}
