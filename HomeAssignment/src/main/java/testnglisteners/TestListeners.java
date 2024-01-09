package testnglisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import extentreport.ExtentLogger;
import extentreport.ExtentReport;
import utils.BaseClass;
import utils.TakeScreenShotsClass;

public class TestListeners extends BaseClass implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped.");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
			ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed.");
			TakeScreenShotsClass.captureScreenShot(driver);
	}

	@Override
	public void onStart(ITestContext context) {
		String browserName =properties.getProperty("browserName");
		browserInitialze(browserName);
		openUrl();
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
		tearDown();
	}

}
