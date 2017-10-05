package com.TAF.test;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;
import com.TAF.helper.ExcelHelper;
import com.TAF.page.HomePage;
import com.TAF.page.LoginPage;
import com.TAF.test.data.URL;

@RunWith(Enclosed.class)
public class LoginUnsuccessfully {

	@RunWith(Parameterized.class)
	public static class Blank_Credentials {
		WebDriver driver = null;
		String username;
		String password;
		String message;
		public Blank_Credentials(String username, String password, String message) {
			this.username = username;
			this.password = password;
			this.message = message;
		}
		
		@Parameters
		public static Collection data() {		
			return new ExcelHelper("credentials.xlsx", "Blank").getSheetData();
	    }

		@Before
		public void setUp() throws Exception {
			driver =  DriverFactory.getDriver(DriverType.CHROME);
		}

		@After
		public void tearDown() throws Exception {
			driver.quit();
		}

		@Test
		public void test() {
			driver.get(URL.LOGIN.toString());
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(this.username, this.password);
			
			Assert.assertTrue(loginPage.getEmptyTextMessage().contains(this.message));
			Assert.assertTrue(loginPage.isOpened());
		}
	}
	
	@RunWith(Parameterized.class)
	public static class Invalid_Credentials {
		WebDriver driver = null;
		String username;
		String password;
		String message;
		public Invalid_Credentials(String username, String password, String message) {
			this.username = username;
			this.password = password;
			this.message = message;
		}
		
		@Parameters
		public static Collection data() {		
			return new ExcelHelper("credentials.xlsx", "Invalid").getSheetData();
	    }

		@Before
		public void setUp() throws Exception {
			driver =  DriverFactory.getDriver(DriverType.CHROME);
		}

		@After
		public void tearDown() throws Exception {
			driver.quit();
		}

		@Test
		public void test() {
			driver.get(URL.LOGIN.toString());
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(this.username, this.password);
			
			Assert.assertTrue(loginPage.getWrongCredentialTextMessage().contains(this.message));
			Assert.assertTrue(loginPage.isOpened());
		}
	}
}
