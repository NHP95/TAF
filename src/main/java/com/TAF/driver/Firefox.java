package com.TAF.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements DriverUtils{	
	private WebDriver driver = null;
	private DesiredCapabilities capabilities = null;
	
	Firefox() {
		this.setSystemProperty();
		this.capabilities = DesiredCapabilities.firefox();
		this.capabilities.setCapability("acceptInsecureCerts", true);
	}
	
	Firefox(DesiredCapabilities capabilities) {
		this.setSystemProperty();
		this.capabilities = capabilities;
		this.capabilities.setCapability("acceptInsecureCerts", true);
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		try {
			driver = new FirefoxDriver(this.capabilities);
		}
		catch (Exception e) {
			System.err.println("Driver not found");
		}
		return driver;
	}
	

	@Override
	public void setSystemProperty() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver",  Path + "geckodriver.exe");
	}

	@Override
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return this.driver;
	}
}
