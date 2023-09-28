package com.qsp.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
public VendorsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement vendorsPlusButton;

	public WebElement getVendorsPlusButton() {
		return vendorsPlusButton;
	}
	
	public void clickOnVendorsPlusButton() {
		vendorsPlusButton.click();

	}
}
