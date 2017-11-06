package com.TAF.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DriverFactory {
	private static WebDriver driver = null;
	
	public static WebDriver getDriver(DriverType driverType) {
		switch (driverType) {
		case CHROME :
			driver = new Chrome().createDriver();
			return driver;
		case FIREFOX :
			driver = new Firefox().createDriver();
			return driver;
		case NEXUS5 :
			driver = new Chrome("Nexus 5").createDriver();
			return driver;
		case IPAD :
			driver = new Chrome("iPad").createDriver();
			return driver;
		default :
			driver = new Chrome().createDriver();
			return driver;	
		}
	}
	
	public static WebDriver getDriver(DriverType driverType, DesiredCapabilities capabilities) {
		switch (driverType) {
		case CHROME :
			driver = new Chrome(capabilities).createDriver();
			return driver;
		case FIREFOX :
			driver = new Firefox(capabilities).createDriver();
			return driver;
		default :
			driver = new Chrome(capabilities).createDriver();
			return driver;
		}
	}
	
	public static void terminateDriver() {
		driver.quit();
	}
}
