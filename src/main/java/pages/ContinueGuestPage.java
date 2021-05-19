package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;
import commons.ActionEngine;

public class ContinueGuestPage {
	ActionEngine action;
	
	@FindBy(xpath="//input[@name='guestEmail']")
    WebElement email;
	WebDriverWait wait;
	
	@FindBy(xpath="//button[contains(text(),'Continue As Guest')]")
	WebElement guestButton;
	public ContinueGuestPage(WebDriver driver) {
		PageFactory.initElements(Baseclass.driver,this);
		action=new ActionEngine();
		wait=new WebDriverWait(Baseclass.driver,10);
	}
	public SecureCheckoutPage clickoncontAsGuest() 
	{    ActionEngine.enterText(email, Constants.email);
		
		 ActionEngine.clickon(guestButton);
		return new SecureCheckoutPage(Baseclass.driver); 
	}
	
	
}
