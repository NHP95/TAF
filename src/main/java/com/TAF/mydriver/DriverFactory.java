package com.TAF.mydriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	WebDriver driver = null;

	public WebDriver createDriver(DriverType driverType) {
		switch (driverType) {
		case CHROME:
			this.setSystemProperty("Chrome");
			driver = new ChromeDriver();
			return driver;
		case FIREFOX:
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("acceptInsecureCerts", true);
			driver = this.createCustomDriver(driverType.FIREFOX, capabilities);
			return driver;
		case CHROME_NEXUS5:
			this.setSystemProperty("Chrome");
			driver = new ChromeDriver(this.getDevice("Nexus 5"));
			return driver;
		case CHROME_IPAD:
			this.setSystemProperty("Chrome");
			driver = new ChromeDriver(this.getDevice("iPad"));
			return driver;
		default:
			this.setSystemProperty("Chrome");
			driver = new ChromeDriver();
			return driver;
		}
	}
	public WebDriver createCustomDriver(DriverType driverType, DesiredCapabilities cap) {
		switch (driverType) {
		case CHROME :
			this.setSystemProperty("Chrome");
			driver = new ChromeDriver(cap);
			return driver;
		case FIREFOX :
			this.setSystemProperty("Firefox");
			driver = new FirefoxDriver(cap);
			return driver;
		default :
			this.setSystemProperty("Chrome");
			driver = new ChromeDriver(cap);
			return driver;				
		}			
	}

	private void setSystemProperty(String browserName) {
		String os_seperator = File.separator;
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "chromedriver.exe");
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "geckodriver.exe");
		}
	}
	private DesiredCapabilities getDevice(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
		
		mobileEmulation.put("deviceName", deviceName);
		chromeOptions.put("mobileEmulation", mobileEmulation);
		Capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return Capabilities;		
	}
}
