package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	public static WebDriver driver;
	protected static File file = new File("./payload/dataProvider.properties");
	protected static FileInputStream fiStream = null;
	protected static Properties properties = new Properties();
	static {
		try {
		fiStream = new FileInputStream(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			properties.load(fiStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
//	Browser initialization method
	public void browserInitialze(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("optionChrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("./Extentions/adguard.crx"));
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			// Get the handle of the current window
			String currentWindow = driver.getWindowHandle();
			// Switch to the new tab
			for (String handle : driver.getWindowHandles()) {
			    if (!handle.equals(currentWindow)) {
			        driver.switchTo().window(handle);
			        driver.close();
			    }
			}
			// Switch back to the original window
			driver.switchTo().window(currentWindow);

		}
		
	}
// open url method.
	public void openUrl() {
		driver.get(properties.getProperty("url"));

	}
//	tear down method.
	public void tearDown() {
		driver.quit();
	}
	
}
