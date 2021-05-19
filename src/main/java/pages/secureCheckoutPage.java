package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import base.Baseclass;

import commons.ActionEngine;

public class SecureCheckoutPage {

	Boolean presence;
	WebDriverWait wait;
	public ActionEngine action;

	
		public SecureCheckoutPage(WebDriver driver)
		{
			PageFactory.initElements(Baseclass.driver,this);
			 action=new ActionEngine();
			 wait=new WebDriverWait(Baseclass.driver,10);
		}

	@FindBy(name = "shippingPhoneNumber")
	WebElement txtBxShippingPhoneNumber;
	@FindBy(id = "shippingFirstNamedefault")
	WebElement txtBxFirstName;

	@FindBy(id = "shippingLastNamedefault")
	WebElement txtBxLastName;
	@FindBy(id = "select2-shippingSalutationdefault-container")
	WebElement ddlTitle;

	@FindBy(xpath = "//li[text()='Mrs']")
	WebElement lstMrs;
	@FindBy(id = "shippingAddressOnedefault")
	WebElement txtBxAddressOne;
	@FindBy(id = "select2-shippingCitydefault-container")
	WebElement ddlRegion;

	@FindBy(xpath = "//li[text()='Abu Dhabi']")
	WebElement lstAbuDhabi;
	@FindBy(id = "select2-shippingAreadefault-container")
	WebElement ddlArea;
	@FindBy(xpath = "//li[contains(text(),'Abu Al Abyad Island')]")
	WebElement lstAbuAlAbyadIsland;

	@FindBy(xpath = "(//p[@class='product-line-item__attributes']/span)[4]")
	WebElement lblQuantityValue;

	@FindBy(xpath = "(//h2[@class='product-line-item__brand'])[2]")
	WebElement lblBrandValue;

	public SecureCheckoutPage enterShippingPhoneNumber(String phoneNumber) {
		
			action.enterText(txtBxShippingPhoneNumber, phoneNumber);
		
		   return this;
	}

	

	public SecureCheckoutPage enterShippingFirstName(String fName) {
	
			action.enterText(txtBxFirstName, fName);
		
		    return this;
	}


	public SecureCheckoutPage enterShippingLastName(String lName) {
	
			ActionEngine.enterText(txtBxLastName, lName);
			
		    return this;
	}

	

	public SecureCheckoutPage clickTitleDropDown() {
		
	
			action.clickon(ddlTitle);
		
		    return this;
	}


	public SecureCheckoutPage selectTitleFromDropDown() {
	
			action.clickon(lstMrs);
		
		   return this;
	}

	

	public SecureCheckoutPage enterAddressOne(String address) {
		
			action.enterText(txtBxAddressOne, address);
		
		    return this;
	}

	

	public SecureCheckoutPage clickRegionDropDown() {
		
			action.clickon(ddlRegion);
	
	    	return this;
	}


	public SecureCheckoutPage selectAbuDhabi() {//	try {
	
			action.clickon(lstAbuDhabi);
	
		    return this;
	}

	

	public SecureCheckoutPage clickAreaDropDown() {
	
			action.clickon(ddlArea);
	
	     	return this;
	}

	

	public SecureCheckoutPage selectAbuAlAbyadIsland() {
		
		
			ActionEngine.explicitWaitForClick(lstAbuAlAbyadIsland);
		
		   return this;
	}


	public SecureCheckoutPage assertQuantity() {
		
			String qty = lblQuantityValue.getText().toString();
		
			if(qty.equals("1")) {
				System.out.println("Quantity is equal to 1 and this is expected result. ");
			}else {
				System.out.println("Quantity is not equal to 1 and this is unexpected result");
			}
		
		
		return this;
	
	}
	

	public SecureCheckoutPage assertBrand() {
		
			String brand = lblBrandValue.getText().toString();
			
			if(brand.equalsIgnoreCase("Nike")) {
				System.out.println("Brand is equal to NIKE and this is expected result.");
			}else {
				System.out.println("Brand is not equal to NIKE and this is unexpected result. ");
			}
		
		return this;
	}

}

	
   