package com.qsp.vtiger.leads;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qsp.vtiger.genericUtility.BaseClass;
import com.qsp.vtiger.genericUtility.DataBaseUtility;
import com.qsp.vtiger.genericUtility.IPathConstant;
import com.qsp.vtiger.pomRepository.CreatingNewLeadPage;
import com.qsp.vtiger.pomRepository.HomePage;
import com.qsp.vtiger.pomRepository.LeadInformationPage;
import com.qsp.vtiger.pomRepository.LeadsPage;

/**
 * 
 * @author SHUBHAM
 *
 */
@Listeners(com.qsp.vtiger.genericUtility.ListenerImplementationClass.class) //here @Listeners will act as a camera or messanger to implementation class so that if anything fails here implemetation class will come to know that script has failed and it will take screenshots.
public class ToCreateALeadTest extends BaseClass {
	
	@Test(retryAnalyzer=com.qsp.vtiger.genericUtility.RetryImplementationClass.class,groups="smoke")
	public void toCreateALeadAndVerifyTheLeadDetails() throws EncryptedDocumentException, IOException, InterruptedException, SQLException {
		
		        //Test Data
				String leadSalutation = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 17, 2);
				String leadFirstName = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 18, 2);
				String leadLastName = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 19, 2);
				String leadCompanyName = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 20, 2);
				String leadIndustry = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 21, 2);
				String leadassignedTo = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 23, 2);

				//Creating objects of all POM classes required
				HomePage home = new HomePage(driver);
				LeadsPage lead = new LeadsPage(driver);
				CreatingNewLeadPage createLead = new CreatingNewLeadPage(driver);
				LeadInformationPage leadInfo = new LeadInformationPage(driver);

				home.clickOnLeadsModule();
				//Assert.fail();
				lead.clickOnLeadsPlusButton();
				//Assert.fail();
				createLead.selectSalutation(leadSalutation);
				createLead.enterFirstName(leadFirstName);
				createLead.enterLastName(leadLastName);
				createLead.enterCompanyName(leadCompanyName);
				createLead.selectIndustry(leadIndustry);
				createLead.clickOnGroupsRadioButton();
				createLead.selectAssignTo(leadassignedTo);
				createLead.clickOnSaveButton();
				
				String actualLeadInfo = leadInfo.verifyLeadInfo(leadLastName);
				
				Assert.assertTrue(actualLeadInfo.contains(leadLastName));
				System.out.println("Pass: the Lead has been generated");
				
				DataBaseUtility dbUtils=new DataBaseUtility();
		     	String dataFromDataBase = dbUtils.fetchDataFromDataBase(connection,"select * from lead;", 1);
		     	
		     	System.out.println(dataFromDataBase);
                
        
        
        
        
	}

}
