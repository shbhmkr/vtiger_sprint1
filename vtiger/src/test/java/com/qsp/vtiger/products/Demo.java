package com.qsp.vtiger.products;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;

import com.qsp.vtiger.genericUtility.ExcelUtility;
import com.qsp.vtiger.genericUtility.IPathConstant;

public class Demo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {


		 Date date = new ExcelUtility().fetchDateDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 22, 2);
		   String dateNow = date.toString();
		   
		   int month = date.getMonth();
		   
		   String year = dateNow.substring(24);
		   String day = dateNow.substring(8, 10);
		   
		   System.out.println(date);
		   System.out.println(year);
		   System.out.println(month);
		   
		   System.out.println(day);
	}

}
