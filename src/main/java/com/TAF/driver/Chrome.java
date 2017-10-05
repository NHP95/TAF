package com.TAF.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome extends DriverUtils{	
	private WebDriver driver = null;
	private DesiredCapabilities capabilities = null;
	
	Chrome() {
		this.setChromeProperty();
	}
	
	Chrome(DesiredCapabilities capabilities) {
		this.setChromeProperty();
		this.capabilities = capabilities;
	}
	
	Chrome(String deviceName) {
		this.setChromeProperty();
		this.capabilities = this.getDeviceCapabilities(deviceName);
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		try {
			if (this.capabilities != null)
				driver = new ChromeDriver(this.capabilities);
			else
				driver = new ChromeDriver();
		}
		catch (Exception e) {
			System.err.println("Driver not found");
		}
		return driver;
	}
	
	private void setChromeProperty() {
		super.setSystemProperty("webdriver.chrome.driver", "chromedriver.exe");
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
