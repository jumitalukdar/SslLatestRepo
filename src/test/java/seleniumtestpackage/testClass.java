package seleniumtestpackage;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Constants;
import pages.ContinueGuestPage;
import pages.HomePage;
import pages.ProductDisplay;
import pages.ProductList;
import pages.SecureCheckoutPage;

public class testClass {
HomePage home;
ProductDisplay pdisplay;
ProductList plist;
SecureCheckoutPage securechkpage;
ContinueGuestPage guestpage;
	
@BeforeClass
public void setUp()
{

    Baseclass.Initialize();
    

}

@Test(priority=1)
public void validatehomepage()
{
	String expTitle= "Mens Fashion & Sportswear Online in Dubai, Abu Dhabi, UAE | SSS";
	home=new HomePage(Baseclass.driver);
	home.clickonPopUp();
	
	home.clickAgree();
	
	home.clickBlock();
	
	home.clickonMenMenu();
	home.clickAgree();
	
//	home.clickonPopUp();
	
	home.clickonshopAll(Baseclass.driver);
	
//	home.clickonpop();
	System.out.println(Baseclass.driver.getTitle());
	Assert.assertEquals(expTitle,Baseclass.driver.getTitle());
	
	
	
}
@Ignore
@Test(priority=2)
public void validateStoreLocatorDisplayed()
{
	Assert.assertTrue(home.isStoreLocatordisplayed());
}

@Ignore
@Test(priority=3)
public void validateaddtoCart()
{
	String GuestPageTitle=Constants.Guest_Title;
	plist=new ProductList(Baseclass.driver);
	pdisplay=plist.clickOnFirstProductInPLP();
	pdisplay.clickSizeDropDown();
	pdisplay.selectSize();
	pdisplay.clickAddToBag();
	pdisplay.clickMiniCart();
	pdisplay.clickCheckoutSecurely();
	Assert.assertTrue(pdisplay.validateLogoDisplayed());
	
	
		
}
	
@Ignore
@Test(priority=3)
public void validateguestlogin()
{
	String expTitle=Constants.Checkout_Title;
	guestpage=new ContinueGuestPage(Baseclass.driver);
	guestpage.clickoncontAsGuest();
	Assert.assertEquals(expTitle,Baseclass.driver.getTitle());
	
	
}
@Ignore	
@Test(priority=4)
public void validatasecurechkout()
{
	securechkpage=new SecureCheckoutPage(Baseclass.driver);
	securechkpage.clickTitleDropDown();
	securechkpage.selectTitleFromDropDown() ;
	securechkpage.enterShippingFirstName(Constants.fname);
	securechkpage.enterShippingLastName(Constants.lname);
	securechkpage.enterAddressOne(Constants.address1);
	securechkpage.clickRegionDropDown();
	securechkpage.selectAbuDhabi();
	securechkpage.clickAreaDropDown();
	securechkpage.selectAbuAlAbyadIsland();
	//Assert.assertEquals(securechkpage.validateRegionselected(),Constants.region);
//	Assert.assertEquals(securechkpage.validateAreaselected(),Constants.area);
}
	


@AfterClass
public void teardown()
{
	System.out.println("closing the browser");
	//Baseclass.quitdriver();
}
}
