package com.qsp.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
public ProductsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productPlusButton;

	public WebElement getProductPlusButton() {
		return productPlusButton;
	}
	
	public void clickOnProductPlusButton() {
		productPlusButton.click();
	}


}
