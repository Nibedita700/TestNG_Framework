package test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.LoginAction_Amazon;

public class LoginTest_Amazon extends Base{

	LoginAction_Amazon login;
	
	@BeforeClass(alwaysRun = true)
	public void BeforeClass() {
		
		login= new LoginAction_Amazon(driver);
	}

@Test(priority=1,groups={"Regression"})
public void validateNavigateToWishList() {
	login.navigateToWishList();
	String actualtitle=driver.getTitle();
	String expectedtitle="Wish List";
	Assert.assertTrue(actualtitle.contains(expectedtitle),"Title is not as expected"+actualtitle);
}

@Test(priority=2,groups={"Regression"})
public void validateNavigateToNewRelease() {
	login.navigateToNewRelease();
	String actualtitle=driver.getTitle();
	String expectedtitle="Amazon.ca Hot New Releases: The bestselling new & future releases on Amazon";
	Assert.assertTrue(actualtitle.contains(expectedtitle),"Title is not as expected"+actualtitle);
}

@Parameters({"ValidEmail","ValidPassword"})
@Test(priority=3,groups={"Regression"})
public void validateCustomerLogin(String email,String password) {
	login.customerLogin();
	Assert.assertTrue(login.email.isDisplayed(),"Email field is not displayed");
	Assert.assertTrue(login.email.isEnabled(),"Email field is not enabled");
	login.sendingkeys(login.email,email);
	login.emailContinue.click();
	login.sendingkeys(login.password,password);
	login.signinbutton.click();

}
@Test(priority=4,groups={"Regression"})

public void validatecustomerLogout() {
	login.customerLogout();
	String actualtitle=driver.getTitle();
	String expectedtitle="Amazon Sign In";
	Assert.assertTrue(actualtitle.contains(expectedtitle),"Title is not as expected"+actualtitle);	
	
}

@Parameters({"InValidEmail"})
@Test(priority=5,groups={"Regression"})
public void inValidEmail(String email) {
	Assert.assertTrue(login.email1.isDisplayed(),"Email field is not displayed");
	Assert.assertTrue(login.email1.isEnabled(),"Email field is not enabled");
	login.sendingkeys(login.email1,email);
	login.emailContinue1.click();


}

@Parameters({"ValidEmail","InValidPassword"})
@Test(priority=6,groups={"Regression"})
public void validEmailInValidPassword(String email,String password) {
	Assert.assertTrue(login.email2.isDisplayed(),"Email field is not displayed");
	Assert.assertTrue(login.email2.isEnabled(),"Email field is not enabled");
	login.email2.clear();
	login.sendingkeys(login.email2,email);
	login.emailContinue2.click();
	
	Assert.assertTrue(login.password1.isDisplayed(),"Password field is not displayed");
	Assert.assertTrue(login.password1.isEnabled(),"Password field is not enabled");
	login.sendingkeys(login.password1,password);
	login.signinbutton1.click();

}

@Parameters({"ProductName","SearchResult"})
@Test(priority=7,groups={"Regression"})
public void validateProductSearch(String PN, String SR) {
	login.productSearch();
	login.sendingkeys(login.searchTextBox,PN);
	login.searchSubmitButton.click();
	String searchResultText=login.searchResult.getText();
	System.out.println(searchResultText);
	Assert.assertTrue(searchResultText.contains(SR), "Search result is not as expected");
	
	
	
}
@Parameters({"ProductPrice"})
@Test(priority=8,groups={"Regression"})
public void validateSelectProduct(String PP) {
	login.selectProduct();
	
	String actualtitle=driver.getTitle();
	String expectedtitle="Samsung Galaxy S10";
	Assert.assertTrue(actualtitle.contains(expectedtitle),"Title is not as expected"+actualtitle);
	
	String productPrice=login.productPrice.getText();
	System.out.println(productPrice);
	Assert.assertTrue(productPrice.contains(PP), "Product Price is not as expected");
	
}
@Parameters({"PostalCode1","PostalCode2"})
@Test(priority=9,groups={"Regression"})
public void validateselectDeliveryLocation(String PostalCode1,String PostalCode2)	{
	login.selectDeliveryLocation();
	Assert.assertTrue(login.deliveryLocation.isDisplayed(),"Delivery field is not displayed");
	Assert.assertTrue(login.deliveryLocation.isEnabled(),"Delivery field is not enabled");
		
	login.actionContext(login.postalCode1,PostalCode1);
	login.sendingkeys(login.postalCode1, PostalCode1);
	
	login.actionContext(login.postalCode2,PostalCode2);
	login.sendingkeys(login.postalCode2, PostalCode2);
	
	login.actionContext(login.applyPostalCode,"");
	login.applyPostalCode.click();
	String enteredPostalCode=login.confirmPostalCode.getText();
	System.out.println(enteredPostalCode);
	String pc= PostalCode1+ PostalCode2;
	Assert.assertTrue(enteredPostalCode.contains(pc),"Entered postal code is not as expected");
	
}
@Test(priority=10,groups={"Regression"})
public void validateSponsoredProduct() {
	String currentPageTitle = driver.getTitle();
	login.openSponsoredProduct();
	String sponsorPageTitle = driver.getTitle();
	Assert.assertFalse(currentPageTitle.equals(sponsorPageTitle), "Sponsored product page opened");
	driver.navigate().back();;
}
  
@Test(priority=11,groups={"Regression"}) 
public void validateAddToCart() {
	login.addToCart();
	String addedToCartMessage = login.addedToCartMessage.getText();
	System.out.println(addedToCartMessage);
	Assert.assertTrue(addedToCartMessage.equalsIgnoreCase("Added to Cart"),"Add to cart is not successful");
}

@Test(priority=12,groups={"Regression"})
public void validateCheckout() {
	login.checkOut();
	String actualtitle=driver.getTitle();
	String expectedtitle="Amazon Sign In";
	Assert.assertTrue(actualtitle.contains(expectedtitle),"Title is not as expected"+actualtitle);
}

	
}
	
	
	

