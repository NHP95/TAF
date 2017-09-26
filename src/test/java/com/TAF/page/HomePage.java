package com.TAF.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TAF.test.data.Title;

public class HomePage {
	private WebDriver driver = null;

	@FindBy(tagName = "title")
	private WebElement txt_Title;

	@FindBy(xpath = "//div[@id='header']//*[contains(normalize-space(.),'Welcome')]")
	private WebElement msg_Welcome;

	@FindBy(xpath = "//div[@id='header']//a[contains(normalize-space(.),'Logout')]")
	private WebElement lnk_Logout;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getWelcomeMessage() {
		String temp = this.msg_Welcome.getText().trim();
		System.out.println(temp);
		return temp;
	}

	public boolean isOpened() {
		return this.driver.getTitle().trim().contains(Title.HOME.toString());
	}
}
