package com.TAF.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DriverFactory {
	
	public static WebDriver getDriver(DriverType driverType) {
		switch (driverType) {
		case CHROME :
			return new Chrome().createDriver();
		case FIREFOX :
			return new Firefox().createDriver();
		case NEXUS5 :
			return new Chrome("Nexus 5").createDriver();
		case IPAD :
			return new Chrome("iPad").createDriver();
		default :
			return new Chrome().createDriver();	
		}
	}
	
	public static WebDriver getDriver(DriverType driverType, DesiredCapabilities capabilities) {
		switch (driverType) {
		case CHROME :
			return new Chrome(capabilities).createDriver();
		case FIREFOX :
			return new Firefox(capabilities).createDriver();
		default :
			return new Chrome(capabilities).createDriver();	
		}
	}	
}
