package com.selenium.libraries;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	final static Logger logger = Logger.getLogger(Base.class);
	
	public static WebDriver driver;
	public GlobalSeleniumLibrary myLibrary;
	public boolean isCaptureScreenshot = true;
	public String myBrowser;
	public String myDemo;
	public String myRemote;

	@BeforeClass
	public void beforeAllTest() {
		JavaPropertiesManager readingProperty = new JavaPropertiesManager("src/test/resources/config.properties");
		myBrowser = readingProperty.readProperty("browserType");
		myDemo = readingProperty.readProperty("isDemo");
		myRemote = readingProperty.readProperty("isRemote");
		
		logger.info("Before all tests starts...");
	    myLibrary = new GlobalSeleniumLibrary(driver);
		if(myDemo.contains("true")){
			myLibrary.setDemoMode(true);
		}
		logger.info("demo variable value: " + myLibrary.getDemoMode());
	}

	@AfterClass
	public void afterAllTest() {
		logger.info("After all test completed...");
		if (driver != null) {
			// driver.close();
			driver.quit();
		}
	}

	@BeforeMethod
	public void beforeEachTest() {
		logger.info("Before each test started ...");
		if(myRemote.contains("true")){
			driver = myLibrary.startRemoteBrowser("http://192.168.1.228:4198/wd/hub/", myBrowser);
		}else{
			driver = myLibrary.startLocalBrowser(myBrowser);
		}
		
	}

	@AfterMethod
	public void afterEachTest(ITestResult result) {
		logger.info("After each test completed ...");
		if (isCaptureScreenshot) {
			if (ITestResult.FAILURE == result.getStatus()) {
				logger.error("Error: Test Failed...",result.getThrowable());
				myLibrary.captureScreenshot(result.getName(), "");
			}
		}
		//myLibrary.customWait(30);
		driver.close();
	}
}













