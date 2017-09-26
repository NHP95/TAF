package com.TAF.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;
import com.TAF.page.HomePage;
import com.TAF.page.LoginPage;
import com.TAF.test.data.Message;
import com.TAF.test.data.URL;

public class LoginSuccessfully {
	WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		driver = new DriverFactory().createDriver(DriverType.CHROME);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get(URL.LOGIN.toString());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("toanle", "kms");
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isOpened());
		Assert.assertTrue(homePage.getWelcomeMessage().contains(Message.LOGIN_SUCCESS.toString() + "toanle"));
	}

}
