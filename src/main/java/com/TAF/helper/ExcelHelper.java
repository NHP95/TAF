package com.TAF.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelHelper extends DataHelper{
	XSSFWorkbook excelFile = null;
	//Workbook excelFile = null;
	
	public ExcelHelper (String path) {
		super(path);
		try {
			excelFile = new XSSFWorkbook(super.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Cannot create excel file");
		}
	}
		
	public List<List<String>> getSheet(String sheetName) {
		Sheet sheet = excelFile.getSheet(sheetName);
		List<List<String>> sheetData = new ArrayList<List<String>>();
		Iterator<Row> rowIterator = sheet.iterator();
		
		//Omit header
		rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			List<String> cellData = new ArrayList<String>();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String temp = this.getCellValue(cell);
				if (temp != "") {
					cellData.add(temp);
				}
			}
			sheetData.add(cellData);
		}
		return sheetData;		
	}
	
	
	private String getCellValue(Cell cell) {
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}
}
