package com.qsp.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title=\"Create Lead...\"]")
	   private WebElement leadsPlusButton;


	public WebElement getLeadsPlusButton() {
		return leadsPlusButton;
	}

	
	public void clickOnLeadsPlusButton() {
		leadsPlusButton.click();
	}
	
}
