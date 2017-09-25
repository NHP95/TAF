package com.TAF.driver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DriverFactory {
	private WebDriver driver = null;
	private String osSeperator = File.separator;
	private String driverPath = System.getProperty("user.dir") + osSeperator + "driver" + osSeperator;

	public WebDriver createDriver(DriverType driverType) {
		this.setSystemProperty();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (driverType) {
		case CHROME:			
			return this.createDriver(DriverType.CHROME, capabilities);
		case FIREFOX:
			return this.createDriver(DriverType.FIREFOX, capabilities);
		case CHROME_NEXUS5:
			return this.createDriver(DriverType.CHROME, this.getDeviceCapabilities("Nexus 5"));
		case CHROME_IPAD:
			return this.createDriver(DriverType.CHROME, this.getDeviceCapabilities("iPads"));
		default:
			return this.createDriver(DriverType.CHROME, capabilities);
		}
		
	}
	public WebDriver createDriver(DriverType driverType, DesiredCapabilities cap) {
		this.setSystemProperty();
		switch (driverType) {
		case CHROME :
			driver = new ChromeDriver(cap);
			return driver;
		case FIREFOX :
			cap.setCapability("acceptInsecureCerts", true);
			driver = new FirefoxDriver(cap);
			return driver;
		default :
			driver = new ChromeDriver(cap);
			return driver;				
		}			
	}

	private void setSystemProperty() {		
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
	}
	private DesiredCapabilities getDeviceCapabilities(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
		
		mobileEmulation.put("deviceName", deviceName);
		chromeOptions.put("mobileEmulation", mobileEmulation);
		Capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return Capabilities;		
	}
}
