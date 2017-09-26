package com.TAF.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TAF.test.data.Title;

public class LoginPage {
	private WebDriver driver = null;
	
	@FindBy(tagName = "title")
	private WebElement txt_Title;
	
	@FindBy(id = "username")
	private WebElement txb_Username;
	
	@FindBy(id = "password")
	private WebElement txb_Password;
	
	@FindBy(id = "btnSubmit")
	private WebElement btn_Login;
	
	@FindBy(xpath = "(//ul[@id='noty_topCenter_layout_container']//*[contains(normalize-space(.),'may not be empty') and contains(concat(' ', @class, ' '), ' noty_text ')])[last()]")
	private WebElement msg_Empty;
	
	@FindBy(id = "pageMessage")
	private WebElement msg_Incorrect_Crendentials;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		this.txb_Username.sendKeys(username);
		this.txb_Password.sendKeys(password);
		this.btn_Login.click();
	}
	
	public String getEmptyTextMessage() {
		try {
			String temp = this.msg_Empty.getText().trim();
			return temp;
		}
		catch (NoSuchElementException e) {
			System.err.println("No such element is found");
		}
		return null;
	}
	
	public String getWrongCredentialTextMessage() {
		try {
			String temp = this.msg_Incorrect_Crendentials.getText().trim();
			return temp;
		}
		catch (NoSuchElementException e) {
			System.err.println("No such element is found");
		}
		return null;
	}
	
	public boolean isOpened() {
		return this.driver.getTitle().trim().contains(Title.LOGIN.toString());
	}
}
