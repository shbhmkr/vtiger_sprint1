package com.qsp.vtiger.genericUtility;

public interface IPathConstant {
	
	String PROPERTY_FILE_PATH="./src/test/resources/vtigerCommonData.properties";
	String EXCEL_FILE_PATH="./src/test/resources/vtigerTestData.xlsx";
	
	String LEAD_SHEET_NAME="LEAD_001";
	String PRODUCT_SHEET_NAME = "Product_001";
	
	int IMPLICIT_WAIT=20;
	int EXPLICIT_WAIT=20;
	
	String SCREENSHOT_PATH="./vtiger/Screenshots/";

	String DATABASE_URL="jdbc:mysql://localhost:3306/project";
	String DATABASE_USERNAME="root";
	String DATABASE_PASSWORD="root";
	
	String PRODUCT_IMAGE_FILE_PATH = "\\src\\test\\resources\\demoPic.png";

}
