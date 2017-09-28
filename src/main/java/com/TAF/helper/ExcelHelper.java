package com.TAF.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper extends DataHelper {
	private Workbook excelFile = null;
	private Sheet sheet = null;

	public ExcelHelper(String path, String sheetName) {
		super(path);

		if (this.getFileExtension(path).equals("xlsx")) {
			try {
				excelFile = new XSSFWorkbook(super.file);
				sheet = excelFile.getSheet(sheetName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Cannot read excel file");
			}
		} else {
			try {
				excelFile = new HSSFWorkbook(super.file);
				sheet = excelFile.getSheet(sheetName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Cannot read excel file");
			}
		}
	}
	
	public Collection getSheet() {
		Collection sheetData = new ArrayList();
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 1; i <= rowCount; i++) {
			List cellData = new ArrayList();
			for (int j = 0; j < colCount; j++) {
				cellData.add(this.celltostring(sheet.getRow(i).getCell(j)));
			}
			sheetData.add(cellData.toArray());
		}
		return sheetData;
	}

//	public List<List<String>> getSheet() {
//		List<List<String>> sheetData = new ArrayList<List<String>>();
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//		for (int i = 1; i <= rowCount; i++) {
//			List<String> cellData = new ArrayList<String>();
//			for (int j = 0; j < colCount; j++) {
//				cellData.add(this.celltostring(sheet.getRow(i).getCell(j)));
//			}
//			sheetData.add(cellData);
//		}
//		return sheetData;
//	}

//	public List<String> getRowData(int index) {
//		List<String> rowData = new ArrayList<String>();
//		this.getDataInRow(rowData, index, sheet.getRow(index).getPhysicalNumberOfCells());
//		return rowData;
//	}
//
//	public List<String> getColumnData(int index) {
//		List<String> colData = new ArrayList<String>();
//		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//			Row row = sheet.getRow(i);
//			String temp = this.celltostring(row.getCell(index));
//			colData.add(temp);
//		}
//		return colData;
//	}
//
//	public List<String> getColumnData(String header) {
//		int index = this.getColumnIndex(header);
//		return this.getColumnData(index);
//	}
//
//	public String getCellData(int rowIndex, int columnIndex) {
//		String cellData = this.getRowData(rowIndex).get(columnIndex);
//		return cellData;
//	}
//
//	public String getCellData(int rowIndex, String header) {
//		int columnIndex = this.getColumnIndex(header);
//		return this.getCellData(rowIndex, columnIndex);
//	}
//
	private String celltostring(Cell cell) {
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}
//
//	private void getDataInRow(List<String> cellData, int index, int colCount) {
//		for (int j = 0; j < colCount; j++) {
//			cellData.add(this.celltostring(sheet.getRow(index).getCell(j)));
//		}
//	}
//
//	private int getColumnIndex(String header) {
//		Row row = sheet.getRow(0);
//		boolean found = false;
//		int index = 0;
//		Iterator<Cell> cellIterator = row.cellIterator();
//		while (cellIterator.hasNext()) {
//			Cell cell = cellIterator.next();
//			if (this.celltostring(cell).equals(header)) {
//				index = cell.getColumnIndex();
//				found = true;
//			}
//		}
//		return (found) ? index : 0;
//	}

//	private boolean isBlank(String string) {
//		if (string != "") {
//			return true;
//		} else {
//			return false;
//		}
//	}
}
