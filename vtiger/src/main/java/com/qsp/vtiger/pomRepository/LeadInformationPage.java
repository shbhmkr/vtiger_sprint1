package com.qsp.vtiger.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadInformationPage {
	
	WebDriver driver;
	public LeadInformationPage(WebDriver driver) {     //used to avoid null pointer exeception as driver will be null in global variable
		this.driver=driver;
	}
	
	public String verifyLeadInfo(String lastName) {
		
	return	driver.findElement(By.xpath("//span[contains(text(),'"+lastName+"')]")).getText();
		
	}
	

}
