package com.qsp.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains generics method to fetch data from property file
 * @author SHUBHAM
 *
 */

public class FileUtility {

	public String fetchDataFromPropertFile(String key) throws IOException {
	FileInputStream fis=new  FileInputStream(IPathConstant.PROPERTY_FILE_PATH);
	
	Properties prop=new Properties();
	
	prop.load(fis);
	
	return prop.getProperty(key);


	}

}
