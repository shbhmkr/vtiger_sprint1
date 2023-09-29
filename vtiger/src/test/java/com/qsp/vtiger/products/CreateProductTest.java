package com.qsp.vtiger.products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qsp.vtiger.genericUtility.BaseClass;
import com.qsp.vtiger.genericUtility.IPathConstant;
import com.qsp.vtiger.pomRepository.CreatingNewProductPage;
import com.qsp.vtiger.pomRepository.CreatingNewVendorPage;
import com.qsp.vtiger.pomRepository.HomePage;
import com.qsp.vtiger.pomRepository.ProductInformationPage;
import com.qsp.vtiger.pomRepository.ProductsPage;
import com.qsp.vtiger.pomRepository.VendorInformationPage;
import com.qsp.vtiger.pomRepository.VendorsPage;



public class CreateProductTest extends BaseClass {
	
	@Test(groups="regression")
	public void createProductAndVerifyProductInformation() throws EncryptedDocumentException, IOException, InterruptedException {

		String vendorName = eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 18, 2);
		String productName = eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 21, 2);
//		String salesStartDate = eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 22, 2);
//		String salesEndDate = eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 23, 2);

		HomePage home = new HomePage(driver);
		VendorsPage vendors = new VendorsPage(driver);
		CreatingNewVendorPage createVendors = new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInfo = new VendorInformationPage(driver);
		ProductsPage product = new ProductsPage(driver);
		CreatingNewProductPage createProduct = new CreatingNewProductPage(driver);
		ProductInformationPage productInfo = new ProductInformationPage(driver);
		
		home.clickOnVendorsModule();
		vendors.clickOnVendorsPlusButton();
		
		createVendors.enterVendorName(vendorName);
		createVendors.clickOnSaveButton();
		
		String actualVendorName = vendorInfo.verifyVendorInfo(vendorName);
		
		Assert.assertTrue(actualVendorName.contains(vendorName));
		System.out.println("Pass: the Vendor has been created");
		
		home.clickOnProductsModule();
		
		product.clickOnProductPlusButton();
		
		createProduct.enterProductName(productName);
		
		createProduct.enterSalesStartDate();
		
		createProduct.enterSalesEndDate();
		
		Thread.sleep(2000);
		
		createProduct.handleVendorLookUpButton("Vendors&action", vendorName, "Products&action");
		
		createProduct.uploadProductImage(IPathConstant.PRODUCT_IMAGE_FILE_PATH);
		
		createProduct.clickOnSaveButton();
		
		String actualProductName = productInfo.verifyVendorInfo(productName);
		
		Assert.assertTrue(actualProductName.contains(productName));
		System.out.println("Pass: the product has been created");
		
	}


}
