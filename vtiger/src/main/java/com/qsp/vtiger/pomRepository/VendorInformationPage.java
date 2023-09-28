package com.qsp.vtiger.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VendorInformationPage {
	
WebDriver driver;
	
	public VendorInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String verifyVendorInfo(String vendorName) {
		return driver.findElement(By.xpath("//span[contains(text(), '"+vendorName+"')]")).getText();
		
	}


}
