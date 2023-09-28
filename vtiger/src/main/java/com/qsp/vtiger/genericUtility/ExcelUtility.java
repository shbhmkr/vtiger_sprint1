package com.qsp.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author SHUBHAM
 *
 */

public class ExcelUtility {
/**
 * 
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */

	public String fetchStringDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new  FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
		
		
		public int fetchNumericDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
			
			FileInputStream fis=new  FileInputStream(IPathConstant.EXCEL_FILE_PATH);
			
			return (int) WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		}
		/**
		 * 
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws IOException 
		 * @throws EncryptedDocumentException 
		 */
			
			
			public boolean fetchBooleanDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
				
				FileInputStream fis=new  FileInputStream(IPathConstant.EXCEL_FILE_PATH);
				
				return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
				
		
	}
			
			/**
			 * 
			 * @param sheetName
			 * @param rowNo
			 * @param cellNo
			 * @return
			 * @throws EncryptedDocumentException
			 * @throws IOException
			 */
			
			public double fetchDecimalNumberFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
				
				FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
				
				return  WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
				
			}
			
			/**
			 * 
			 * @param sheetName
			 * @param rowNo
			 * @param cellNo
			 * @return
			 * @throws EncryptedDocumentException
			 * @throws IOException
			 */
	
			public Date fetchDateDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
				
				FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
				
				return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getDateCellValue();
				
			}

}
