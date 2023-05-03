package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import driverManager.DriverManager;
import utils.CommonMethod;

public class LoginAction_Amazon {

	WebDriver driver;	
	CommonMethod common=new CommonMethod(DriverManager.getDriver());
	
	
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	public WebElement accountList;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	public WebElement accountList1;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	public WebElement accountList2;
	
	@CacheLookup
	@FindBy(partialLinkText = "Create a Wish List")
	public WebElement wishlist;
	
	@CacheLookup
	@FindBy(partialLinkText = "New Releases")
	public WebElement newreleases;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	public WebElement signIn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	public WebElement email;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	public WebElement email1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	public WebElement email2;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"continue\"]")
	public WebElement emailContinue;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"continue\"]")
	public WebElement emailContinue1;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"continue\"]")
	public WebElement emailContinue2;
	

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	public WebElement password;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	public WebElement password1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	public WebElement signinbutton;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	public WebElement signinbutton1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"nav-item-signout\"]")
	public WebElement signout;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"a-page\"]/div[1]/div[1]/div/a")
	public WebElement amazonLogo;	
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	public WebElement searchTextBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	public WebElement searchSubmitButton;
	
		
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"search\"]/span/div/h1/div")
	public WebElement searchResult;
	
		
	@CacheLookup
	@FindBy(partialLinkText = "Samsung Galaxy S10")
	public WebElement samsungS10;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr[2]/td[2]/span[1]")
	public WebElement productPrice;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]")
		public WebElement deliveryLocation;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"GLUXZipUpdateInput_0\"]")
	public WebElement postalCode1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"GLUXZipUpdateInput_1\"]")
	public WebElement postalCode2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"GLUXZipUpdate\"]/span/input")
	public WebElement applyPostalCode;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]/span[2]")
	public WebElement confirmPostalCode;
	
	@CacheLookup
	//@FindBy(xpath ="//*[@id=\"ape_Detail_hero-quick-promo_Desktop_iframe\"]")
	@FindBy(id = "ape_Detail_hero-quick-promo_Desktop_iframe")
	public WebElement iframeEle;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ad\"]/div/div/div[2]/div/div/a")
	//@FindBy(xpath = "//*[@id=\"sp_hqp_shared_inner\"]")
	//@FindBy(id = "sp_hqp_shared_inner")
	public WebElement iframeProductLink;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
	public WebElement addToCartButton;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"sw-atc-confirmation\"]")
	public WebElement addToCartBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")
	public WebElement addedToCartMessage;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
	public WebElement checkOutButton;
	
	public LoginAction_Amazon (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
    
	}
	
	//Navigation to Wishlist:
	public void navigateToWishList() {
		 
		Actions act=new Actions (driver);
		act.moveToElement(accountList).perform();
		
		common.waitforElement(accountList);
		common.waitforElement(wishlist);
		wishlist.click();
	}

	//Navigation to New Release:
	public void navigateToNewRelease() {
		
		common.waitforElement(newreleases);
		newreleases.click();
}
//Customer Login Action:
	public void customerLogin(){
		Actions act=new Actions (driver);
		act.moveToElement(accountList1).build().perform();
		common.waitforElement(signIn);
		signIn.click();
}
	
//Customer Logout Action:	
	public void customerLogout(){
		Actions act=new Actions (driver);
		act.moveToElement(accountList2).build().perform();
		common.waitforElement(signout);
		signout.click();
}

//Prouct Search Action:
	public void productSearch() {
	amazonLogo.click();
	common.waitforElement(searchTextBox);
	
}

//Select Product Action:
	public void selectProduct() {
		common.waitforElement(samsungS10);
		common.higlightelement(samsungS10);
		System.out.println(samsungS10.getText());
		samsungS10.click();
}

//Select Delivery Location Action:
	public void selectDeliveryLocation() {
		common.higlightelement(deliveryLocation);
		deliveryLocation.click();	
		
}

// Common Method to move to an element:
	public void actionContext(WebElement ele,String PC) { 
		Actions act=new Actions (driver);
		act.moveToElement(ele).build().perform();
	
}	

// Open Sponsored Product Action:
	public void openSponsoredProduct() {
		common.waitforElement(iframeEle);
		driver.switchTo().frame(iframeEle);
		Actions act=new Actions (driver);
		act.moveToElement(iframeProductLink).build().perform();
		iframeProductLink.click();
	
}	

// Add to Cart Action:
	public void addToCart() {
		common.higlightelement(addToCartButton);
		addToCartButton.click();
		common.waitforElement(addToCartBox);
	
}	

// Product Checkout Action:
	public void checkOut() {
		common.higlightelement(checkOutButton);
		checkOutButton.click();
	
}	

// Common method for sending keys Action:
public void sendingkeys(WebElement ele,String keys) { 
	
	common.higlightelement(ele);
	common.waitforElement(ele);	
	ele.sendKeys(keys);	
	
}	

	}


