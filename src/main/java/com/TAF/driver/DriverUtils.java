package com.TAF.driver;

import java.io.File;
import org.openqa.selenium.WebDriver;

abstract class DriverUtils {
	//Location of the folder which contains executable driver file
	private String Path = System.getProperty("user.dir") + File.separator + "driver" + File.separator;
	
	//Point to specific executable driver file in the folder
	private String getDriverPath(String driverName) {
		return this.Path + driverName;
	}
	
	public void setSystemProperty(String key, String driverName) {
		System.setProperty(key, this.getDriverPath(driverName));
	}
	
	public abstract WebDriver createDriver();
}
