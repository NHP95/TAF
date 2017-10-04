package com.TAF.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DriverFactory {	
	
	public static WebDriver getDriver(DriverType driverType) {
		switch (driverType) {
		case CHROME :
			return new Chrome().createDriver();
		case FIREFOX :
			return new Firefox().createDriver();
		case NEXUS5 :
			return getDriver(DriverType.CHROME, getDeviceCapabilities("Nexus 5"));
		case IPAD :
			return getDriver(DriverType.CHROME, getDeviceCapabilities("iPad"));
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
	
	private static DesiredCapabilities getDeviceCapabilities(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
		
		mobileEmulation.put("deviceName", deviceName);
		chromeOptions.put("mobileEmulation", mobileEmulation);
		Capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return Capabilities;		
	}
}
