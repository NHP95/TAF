package com.TAF.helper;

import java.io.File;
import java.util.List;

interface DataHelper {
	String path = System.getProperty("user.dir") + File.separator + "data" + File.separator;
	List<String[]> getSheetData();
	String[] getColData(int colIndex);
	String[] getColData(String colHeader);
	String getCellData(int rowIndex, int colIndex);
	String getCellData(int rowIndex, String colHeader);
}
