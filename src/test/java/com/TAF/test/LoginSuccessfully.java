package com.TAF.test;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;
import com.TAF.helper.ExcelHelper;
import com.TAF.page.HomePage;
import com.TAF.page.LoginPage;
import com.TAF.test.data.URL;

@RunWith(Parameterized.class)
public class LoginSuccessfully {
	WebDriver driver = null;
	String username;
	String password;
	String fullname;	
	
	public LoginSuccessfully(String username, String password, String fullname) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	
	@Parameters
	public static List data() {		
		return new ExcelHelper("credentials.xlsx", "Valid").getSheet();
		//return new ExcelHelper("credentials.xlsx", "Valid").getRow(1);	
  }
	
//	Column looping	
//	@Parameters 
//	public static Object data() {		
//		return new ExcelHelper("credentials.xlsx", "Valid").getColumnData(0);		
//    }

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
		System.out.println(this.username);
		driver.get(URL.LOGIN.toString());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(this.username, this.password);
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isOpened());
		Assert.assertTrue(homePage.getWelcomeMessage().contains("Welcome, " + this.username));
		
	}

}
