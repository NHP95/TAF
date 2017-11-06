package com.saleor.test.home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;
import com.saleor.page.home.HomePageValidation;
import com.saleor.properties.Constants;
import com.saleor.properties.URLs;

public class Titles {
	WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverType.CHROME);
	}

	@After
	public void tearDown() throws Exception {
		DriverFactory.terminateDriver();
	}

	@Test
	public void test() {
		driver.get(URLs.homeURL);
		HomePageValidation homePage = new HomePageValidation(driver);
		homePage.validateNumberOfHeaders(Constants.NUMBER_OF_HEADERS);
		homePage.validateContentOfHeaders(Constants.CONTENT_OF_HEADERS);
		homePage.validateAllHeadersAreClickable();
	}
}
