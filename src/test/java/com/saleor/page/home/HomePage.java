package com.saleor.page.home;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TAF.test.data.Title;

public class HomePage {
	protected WebDriver driver = null;

	@FindBy(xpath = "//*[contains(' navigation ', concat(' ',@class,' '))]//li[contains(' nav-item ', concat(' ',@class,' '))]")
	private List<WebElement> navigationBar;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isOpened() {
		return this.driver.getTitle().trim().contains(Title.HOME.toString());
	}
	
	public boolean isClickable(WebElement element, WebDriver driver) {
		try{
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e){
            return false;
        }
	}

	public WebElement getHeader(String headerName) {
		for (int i = 0; i < navigationBar.size(); i++) {
			if (navigationBar.get(i).getText().trim().equals(headerName)) {
				return navigationBar.get(i);
			}
		}
		return null;
	}

	public List<WebElement> getAllHeaders() {
		return navigationBar;
	}
	
	public int getNumberOfHeaders() {
		return navigationBar.size();
	}
	
	public List<String> getContentOfHeaders() {
		List<String> contents = new ArrayList<String>();
		for (int i = 0; i < navigationBar.size(); i++) {
			contents.add(navigationBar.get(i).getText().trim().toLowerCase());
		}
		return contents;
	}

}
