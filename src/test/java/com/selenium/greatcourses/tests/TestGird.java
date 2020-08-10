package com.selenium.greatcourses.tests;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestGird {
	@Test
	public void test1() throws Exception {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setPlatform(Platform.WINDOWS);
		URL url = new URL("http://192.168.1.228:4198/wd/hub/");
		                         
		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("https://www.mortgagecalculator.net/");
		System.out.println("Title is: " + driver.getTitle());
		driver.quit();

	}

}
