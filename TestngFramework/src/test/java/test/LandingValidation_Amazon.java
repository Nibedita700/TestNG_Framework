package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingValidation_Amazon extends Base {
	
	
	
	 @Test
	  public void ValidateTitle() {
		  String actualtitle=driver.getTitle();
		  String expectedtitle="Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		  Assert.assertTrue(actualtitle.contains(expectedtitle),"Title is not as expected"+actualtitle);
	  }
	 @Test
	  public void ValidateUrl() {
		  		String actualurl=driver.getCurrentUrl();
		  		String expectedurl="https://www.amazon.ca";
		  		Assert.assertTrue(actualurl.contains(expectedurl),"Url is not as expected"+actualurl);
	
	
	  }
	
	
	 

}
