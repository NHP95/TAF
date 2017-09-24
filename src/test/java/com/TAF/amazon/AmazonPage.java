package com.TAF.amazon;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;

public class AmazonPage {
	WebDriver driver = null;
	@Test
	public void test() {
		driver = new DriverFactory().createDriver(DriverType.CHROME);
		driver.get("https://www.whatismybrowser.com/");
		driver.quit();
//
//		driver = new DriverFactory().createDriver(DriverType.CHROME_IPAD);
//		driver.get("https://www.whatismybrowser.com/");
//		driver.quit();
//
//		driver = new DriverFactory().createDriver(DriverType.CHROME_NEXUS5);
//		driver.get("https://www.whatismybrowser.com/");
//		driver.quit();

//		driver = new DriverFactory().createDriver(DriverType.FIREFOX);
//		driver.get("https://www.techtalk.vn");
//		driver.quit();
	}
}
