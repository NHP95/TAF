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
//		driver = new DriverFactory().createDriver(DriverType.CHROME);
//		driver.get("https://www.whatismybrowser.com/");
//		driver.quit();
		ExcelHelper test = new ExcelHelper("D:\\Downloads\\helper.xlsx");
		List<List<String>> test1 = test.getSheet("TEST");
		for (List i : test1) {
			System.out.println(i);
		}
	}
}
