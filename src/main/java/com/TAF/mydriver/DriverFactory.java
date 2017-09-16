package com.TAF.mydriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	static WebDriver driver = null;

	public DriverFactory() {

	}

	public static WebDriver getDriver(DriverType driverType) {
		String os_seperator = File.separator;
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		switch (driverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case CHROME_NEXUS5:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "chromedriver.exe");
			mobileEmulation.put("deviceName", "Nexus 5");
			chromeOptions.put("mobileEmulation", mobileEmulation);

			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(chromeCapabilities);
			break;
		case CHROME_IPAD:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "chromedriver.exe");
			mobileEmulation.put("deviceName", "iPad");
			chromeOptions.put("mobileEmulation", mobileEmulation);

			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(chromeCapabilities);
			break;
		default:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + os_seperator + "driver" + os_seperator + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	public static void disposeDriver() {
		driver.quit();
	}
}
