package extentreport;

import org.openqa.selenium.WebDriver;

public class ExtentLogger {
	
	static WebDriver driver;
//	Contractor
	private ExtentLogger() {}
//	Pass Status.
	public static void pass(String massage) {
		ExtentManager.getExtentTest().pass(massage);
	}
//	Failed status.
	public static void fail(String massage){
		ExtentManager.getExtentTest().fail(massage);
		ExtentManager.getExtentTest().addScreenCaptureFromPath("TakeScreenShotsClass.captureScreenShot(driver)");
		
		
	}
//	Skip status.
	public static void skip(String massage) {
		ExtentManager.getExtentTest().skip(massage);
	}
	
}
