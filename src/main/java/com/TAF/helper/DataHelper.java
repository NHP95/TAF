package com.TAF.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DataHelper {
	protected String path = null;
	protected FileInputStream file = null;
	
	public DataHelper (String path) {
		this.path = path;
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}		
	}
	public String getFileExtension(String fileName) {
		return null;
	}
	
	public String getFileName() {
		return null;
	}
}
