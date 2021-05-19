package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;
import commons.ActionEngine;

public class HomePage {
	
	ActionEngine action;
	WebDriverWait wait;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav d-lg-flex justify-content-lg-center']//li/a[text()='Men']")
    WebElement MenuMen;
	

	@FindBy(xpath="//div[@class='hero-banner__buttons']//a[contains(text(),'Shop All')]")
    WebElement shopAll;
	@FindBy(xpath="//div[@id='NC_background_image']//a[@id='NC_CLOSE_ICON']")
	WebElement randompop;
	//FindBy(xpath="//div[@class=\"product-grid js-product-grid\"]//div[@class=\"product\"]")
	//WebElement productlist;
	@FindBy(id="preview-notification-frame")
	WebElement frame;
	@FindBy(xpath = "//button[text()='I agree']")
	WebElement btnAgree;

	@FindBy(xpath = "//div[@id='__st_fancy_popup']//iframe")
	WebElement iFramePromo;
	@FindBy(name = "notnow")
	WebElement inptBlock;
	@FindBy(xpath="//a[@data-gtm-event-label='Store Locator']")
	WebElement StoreLocator;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		 action=new ActionEngine();
		 wait=new WebDriverWait(Baseclass.driver,10);
	}
	
	public void clickonPopUp() {
		Baseclass.driver.switchTo().frame(frame);
		ActionEngine.clickon(randompop);
		System.out.println("pop up clicked n closed");
	}
	public void clickonMenMenu()
	
	{ 
		ActionEngine.clickon(MenuMen);
		System.out.println("men menu clicked");
		
	}
	
	public HomePage clickAgree() {
		
			ActionEngine.explicitWaitForClick(btnAgree);
			System.out.println("agree clicked");
			
		    return this;
	}
	
	public HomePage clickBlock() {
		
			ActionEngine.switchToFrame(iFramePromo,Baseclass.driver);
			ActionEngine.explicitWaitForClick(inptBlock);
			System.out.println("block clicked");
			ActionEngine.switchToMainWindow(Baseclass.driver);
			
		return this;
	}
	
    public ProductDisplay clickonshopAll(WebDriver driver)
	
	{
    	ActionEngine.clickon(shopAll);
    	System.out.println("shopall menu clicked");
    	return new ProductDisplay(driver);
		
	}

	public boolean isStoreLocatordisplayed() {
	return	ActionEngine.isElementDisplayed(StoreLocator);
		
	}
}