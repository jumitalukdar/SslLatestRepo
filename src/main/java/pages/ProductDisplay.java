package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;

import commons.ActionEngine;

public class ProductDisplay {
	 ActionEngine actions;

	@FindBy(xpath="//img[@src='https://en-ae.sssports.com/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw023e1163/sss/N/K/C/NKCV0978_107_194956610281_2.jpg?sw=400&sh=400&sm=fit']")
	WebElement itemimage;
	
	@FindBy(xpath="//div[@class='container cart']//div[@class='line-item-name']/span")
	WebElement itemaddedincart;
	
	@FindBy(xpath="//span[@id='select2-vendorSize-shoesize-container']")
	WebElement selectsizeLabel;
	
	@FindBy(xpath="(//li[contains(@role,'treeitem')])[58]")
	//@FindBy(xpath="//ul[@id='select2-vendorSize-shoesize-results']//li[contains(text(), 'EU 40.5')]")
	//@FindBy(xpath="(//li[contains(@id,'https://en-ae.sssports.com/on/demandware.store/Sites-UAE-Site')])[6]")	
	WebElement sizefigure;
	
	@FindBy(xpath="//button[text()='Add to bag']")
	WebElement addTobag;
	
	@FindBy(xpath="//div[@class='card-body']//div[@class='line-item-name']/span]")
	WebElement itemvisibleinCart;
	
//	@FindBy(xpath="//a[@class='btn btn-secondary btn-block checkout-btn']")
	@FindBy(xpath="//div[@class='row checkout-buttons']//a[@data-gtm-click='checkoutSecurely']")
	WebElement checkout;
	
	@FindBy(xpath="//div[@class='roduct-grid js-product-grid']//div[@class='product']")
	WebElement productlist;
	
	@FindBy(xpath="//iframe[@id='preview-notification-frame']")
	WebElement frame;
	
	@FindBy(xpath="//div[@id='NC_background_image']//a[@id='NC_CLOSE_ICON']")
	WebElement randompop;
	
	@FindBy(xpath="//button[@class='affirm btn btn-primary btn--affirm js-consent-submit']")
	WebElement iagree;
	
	@FindBy(xpath="(//div[@class='image-container']/a)[1]")
	WebElement lnkFirstProductOnPLP;
	
	@FindBy(xpath="//a[contains(@href,'Checkout-Login')]")
	WebElement lnkCheckoutSecurely;

	@FindBy(xpath = "(//div[@class='minicart__total']/button/span)[1]")
	WebElement btnMiniCart;
	
	@FindBy(xpath="//img[@src='/on/demandware.static/Sites-UAE-Site/-/default/dw80ee6a39/images/logo.svg']")
	WebElement brandLogo;
	
	ActionEngine action;
	WebDriverWait wait;
	
	public ProductDisplay(WebDriver driver)
	{
		PageFactory.initElements(Baseclass.driver,this);
		 action=new ActionEngine();
		 wait=new WebDriverWait(Baseclass.driver,10);
	}
	
	
	public void clickRandomPopUp() {
		Baseclass.driver.switchTo().frame(frame);
		ActionEngine.clickon(randompop);
		System.out.println("pop up closed");
	}
	
	
   public void clickAddToBag()
   {
	    ActionEngine.explicitWaitForClick(addTobag);
	    System.out.println("clicked on addTobag");
		
	    return;
   }
	
	

	
	public ProductDisplay clickMiniCart() {
		
			ActionEngine.explicitWaitForClick(btnMiniCart);
			System.out.println("clicked on minicart button");
			
		    return this;
	}
	
	
	
	public ContinueGuestPage clickCheckoutSecurely() {
		
			
			ActionEngine.explicitWaitForClick(lnkCheckoutSecurely);
			System.out.println("clicked on checkout Securely button");
		
		    return new ContinueGuestPage(Baseclass.driver);
	
}

	
	
   public void clickSizeDropDown()
	
	{

	ActionEngine.explicitWaitForClick(selectsizeLabel);
	System.out.println("size drop down clicked");
	
   	
	
	}


   public void selectSize()

 {
//	ActionEngine.scroollIntoView(sizefigure,Baseclass.driver);
   ActionEngine.explicitWaitForClick(sizefigure);
   System.out.println("size selected");

	
 }
//   public ContinueGuestPage clickonCheckout()

//{   ActionEngine.explicitWaitForClick(checkout);
//	System.out.println("clicked on secure checkout button");
//	return new ContinueGuestPage(Baseclass.driver);
//}


   
   public boolean validateLogoDisplayed()
   {
	   
	return ActionEngine.isElementDisplayed(brandLogo);   
	
	   
   }
		
	

}
