package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;
import commons.ActionEngine;
import commons.ActionEngine;

public class ProductList {
	ActionEngine actions;
	WebDriverWait wait;
	@FindBy(xpath="(//div[@class='image-container']/a)[1]")
	WebElement lnkFirstProductOnPLP;
	@FindBy(xpath="//button[@class='search-view__count js-search-view-count m-active']")
	WebElement countResultsfield;
		
	
	public ProductList(WebDriver driver)
	{
		PageFactory.initElements(Baseclass.driver,this);
		 ActionEngine actions=new ActionEngine();
		 wait= new WebDriverWait(Baseclass.driver,20);
	}
	
	public ProductDisplay clickOnFirstProductInPLP() {
		
		
		ActionEngine.explicitWaitForClick(lnkFirstProductOnPLP);
		System.out.println("item clicked is"+ lnkFirstProductOnPLP.getText());		
	    return new ProductDisplay(Baseclass.driver);
	}
	
	    
	 public boolean validateCountSrchResults()    {
		
		return ActionEngine.isElementDisplayed(countResultsfield);
	
}	
}


