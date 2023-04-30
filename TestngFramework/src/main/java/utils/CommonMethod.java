package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethod {
	
	
	
	WebDriver driver;
	
	 public CommonMethod (WebDriver driver) {
		 this.driver=driver;
	
	
	 }
	
	
	//Selenium waits > explicit wait> element level wait  and implicit wait >> page level

		public void waitforElement(WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		
		
		public void jsScroll(WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver ;
			js.executeScript("arguments[0].scrollIntoView();", ele)	;
			}
		
		public void higlightelement(WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver ;
			js.executeScript("arguments[0].style.border='2px solid red'", ele);
		}

		public void jsclick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].click();", ele);
		}


}
