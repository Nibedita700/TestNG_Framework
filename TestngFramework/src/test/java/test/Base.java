package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import driverManager.DriverManager;
import utils.ReadPropertyFile;

public class Base {
	WebDriver driver;
	DriverManager dm=new DriverManager();
	ReadPropertyFile prop;
	Properties property;
  
  @Parameters({"browser","url"})
  @BeforeClass(alwaysRun =true)
  
  public void beforeSuite(String browser,String url) {
	 //prop=new ReadPropertyFile();
	 //property= prop.readProperties();
	 //dm.setup(property.getProperty("Browser"),property.getProperty("Url"));
	  dm.setup(browser, url);
	  driver= DriverManager.getDriver();
  }

  

  @AfterSuite
  public void afterSuite() {
	  dm.teardown();
  }

}
