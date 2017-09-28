package com.TAF.amazon;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;
import com.TAF.helper.ExcelHelper;

public class AmazonPage {
	WebDriver driver = null;
	@Test
	public void test() {
		ExcelHelper valid_credentials = new ExcelHelper("D:\\Utilities\\Self-Study\\TAF\\data\\credentials.xlsx", "Valid");
		ExcelHelper invalid_credentials = new ExcelHelper("D:\\Utilities\\Self-Study\\TAF\\data\\credentials.xlsx", "Invalid");
		
		List<List<String>> valid = valid_credentials.getSheet();
		List<List<String>> invalid = invalid_credentials.getSheet();
		
		for (List<String> i : valid) {
			System.out.println(i);
			for (String j : i) {
				System.out.println(j);
			}
		}
		
		for (List<String> i : invalid) {
			System.out.println(i);
			for (String j : i) {
				System.out.println(j);
			}
		}
	}
}
