package com.TAF.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper implements DataHelper {
	private Workbook excelFile = null;
	private Sheet sheet = null;
	private String fileExtension = null;

	public ExcelHelper(String fileName, String sheetName) {
		String filePath = DataHelper.path + fileName;
		fileExtension = FilenameUtils.getExtension(filePath);
		if (this.fileExtension.equals("xlsx")) {
			try {
				excelFile = new XSSFWorkbook(new FileInputStream(filePath));
				sheet = excelFile.getSheet(sheetName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("File not found");
			}
		} else {
			try {
				excelFile = new HSSFWorkbook(new FileInputStream(filePath));
				sheet = excelFile.getSheet(sheetName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("File not found");
			}
		}
	}

	@Override
	public List<String[]> getSheetData() {
		List<String[]> sheetData = new ArrayList<String[]>();
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 1; i <= rowCount; i++) {
			List<String> cellData = new ArrayList<String>();
			for (int j = 0; j < colCount; j++) {
				cellData.add(this.getCellData(i, j));
			}
			sheetData.add(cellData.toArray(new String[0]));
		}
		return sheetData;
	}

	@Override
	public String getCellData(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		return this.celltostring(this.sheet.getRow(rowIndex).getCell(colIndex));
	}

	@Override
	public String getCellData(int rowIndex, String colHeader) {
		// TODO Auto-generated method stub
		return this.celltostring(this.sheet.getRow(rowIndex).getCell(this.getColumnIndex(colHeader)));
	}

	@Override
	public String[] getColData(int colIndex) {
		// TODO Auto-generated method stub
		List<String> cellData = new ArrayList<String>();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			cellData.add(this.getCellData(i, colIndex));
		}
		return cellData.toArray(new String[0]);
	}

	@Override
	public String[] getColData(String colHeader) {
		// TODO Auto-generated method stub
		return this.getColData(this.getColumnIndex(colHeader));
	}

	private String celltostring(Cell cell) {
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}

	private int getColumnIndex(String header) {
		Row row = sheet.getRow(0);
		boolean found = false;
		int index = 0;
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (this.celltostring(cell).equals(header)) {
				index = cell.getColumnIndex();
				found = true;
			}
		}
		return (found) ? index : 0;
	}

}
