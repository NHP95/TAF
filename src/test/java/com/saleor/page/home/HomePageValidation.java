package com.saleor.page.home;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageValidation extends HomePage{
	
	
	public HomePageValidation(WebDriver driver) {
		super(driver);
	}

	public void validateNumberOfHeaders(int actual) {
		Assert.assertEquals(getNumberOfHeaders(), actual);
	}
	
	public void validateContentOfHeaders(List<String> contents) {
		List<String> expected_contents = getContentOfHeaders();
		for (int i = 0; i < contents.size(); i++) {
			contents.set(i, contents.get(i).toLowerCase());
		}
		Collections.sort(expected_contents);
		Collections.sort(contents);
		Assert.assertTrue(expected_contents.equals(contents));
	}
	
	public void validateAllHeadersAreClickable() {
		List<WebElement> headers = getAllHeaders();
		for (int i = 0; i < headers.size(); i++) {
			Assert.assertTrue(isClickable(headers.get(i), driver));
		}
	}
}
