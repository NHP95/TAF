package com.TAF.driver;

import java.io.File;
import org.openqa.selenium.WebDriver;

interface DriverUtils {
	//Location of the folder which contains executable driver file
	String Path = System.getProperty("user.dir") + File.separator + "driver" + File.separator;
	
	void setSystemProperty();	
	WebDriver createDriver();
}
