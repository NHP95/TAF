package com.TAF.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.io.FilenameUtils;

public class DataHelper {
	private String osSeperator = File.separator;
	private String path = System.getProperty("user.dir") + osSeperator + "data" + osSeperator;
	protected FileInputStream file = null;
	
	public DataHelper (String fileName) {
		this.path = this.path + fileName;
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}		
	}
	public String getFileExtension(String fileName) {
		String extension = FilenameUtils.getExtension(path);
		return extension;
	}
}
