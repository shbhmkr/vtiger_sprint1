package com.qsp.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	
	public  CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="salutationtype")
	private WebElement salutationDropdown;
	
	
	@FindBy(name="firstname")
	private WebElement fistNameTextField;
	
	
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name="company")
    private WebElement companyNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@value=\"T\"]")
	private WebElement groupRadioButton;
	
	@FindBy(xpath="//input[@value=\"U\"]")
	private WebElement userRadioButton;
	
	@FindBy(xpath="//select[@name=\"assigned_group_id\"]")
	private WebElement assignToDropdown;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	
	
	
	public WebElement getSalutationDropdown() {
		return salutationDropdown;
	}

	public WebElement getFistNameTextField() {
		return fistNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getUserRadioButton() {
		return userRadioButton;
	}

	public WebElement getAssignToDropdown() {
		return assignToDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	//Business logics
	
	public void enterLeadMandatoryInfo(String lastName, String companyName) {
		lastNameTextField.sendKeys(lastName); 
		companyNameTextField.sendKeys(companyName);
		saveButton.click();
	}
	
	
	public void selectSalutation(String Option) {
	  new Select(salutationDropdown).selectByVisibleText(Option);
	}
	
	
	public void enterFirstName(String firstName) {
		fistNameTextField.sendKeys(firstName);
	}
	
	
	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	
	
	public void enterCompanyName(String companyName) {
		companyNameTextField.sendKeys(companyName);
		
	}
	
	
	public void selectIndustry(String option) {
		new Select(industryDropdown).selectByVisibleText(option);
	}
	
	
	public void clickOnGroupsRadioButton() {
		groupRadioButton.click();
	}
	
	
	public void selectAssignTo(String option) {
		new Select(assignToDropdown).selectByVisibleText(option);
	}
	
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
	
	
	
	
}
