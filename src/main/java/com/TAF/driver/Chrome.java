package com.TAF.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome extends Driver{	
	private WebDriver driver = null;
	private DesiredCapabilities capabilities = null;
	
	Chrome() {
		this.setChromeProperty();
	}
	
	Chrome(DesiredCapabilities capabilities) {
		this.setChromeProperty();
		this.capabilities = capabilities;
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
}
