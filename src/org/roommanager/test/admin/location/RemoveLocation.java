package org.roommanager.test.admin.location;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 

import org.roommanager.common.ApiManager;
import org.roommanager.common.LoggerManager;
import org.roommanager.common.ReadFile;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.pageobjects.admin.location.DeleteLocationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;
import org.roommanager.pageobjects.admin.login.LoginPage;
import org.roommanager.pageobjects.admin.main.MainPage;
import org.roommanager.pageobjects.browser.BrowserManager;



public class RemoveLocation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public ReadFile reader = new ReadFile();
  public String nameLocation;

  @BeforeSuite
  public void setUp() throws Exception {
	  driver = BrowserManager.initBrowser();
	  LoggerManager.initLogger();
  }
  
  @BeforeTest
  public void setUpTest() throws Exception {
	  nameLocation = "LocationTest01";
	  String locationDisplayName = "LocationTest01";
	  String locationDescription = "LocationTest01 Description";
	  String urlRequest = reader.getApiLocationsURL();
	  ApiManager.createNewLocation(nameLocation, locationDisplayName, locationDescription, urlRequest);
	  System.out.println("apiiii");
  }
    
  @Test
  public void testRemoveLocationSelenium() throws Exception {
	

	 /*Expected and Actual Result*/
	boolean expectedResult = true;
	
	  
	/*Test for Add a Location*/
	baseUrl = reader.getBaseURL();
	driver.get(baseUrl + reader.getLoginURL());
	LoggerManager.messageLogger("Browser Opened");
	
	driver.navigate().refresh();
    LoginPage logIn = new LoginPage(driver);
    MainPage main = logIn.signInButton();
    LocationPage location = main.selectLocationOption();
    			location.selectLocation(nameLocation);
    DeleteLocationPage deleteLocation = location.selectRemoveLocationButton();
    deleteLocation.removeLocation();
    
    location.refreshLocationPage();
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(LocationModel.GRID_LOCATION));
    
    /*Assert of the Test Case about Remove a Location*/
    boolean actualResult = location.VerifyLocationWasRemoved(nameLocation);
    assertTrue(actualResult);
    
    System.out.println("Location Name:"+nameLocation);
    System.out.println("Expected Result:"+expectedResult);
    System.out.println("Actual Result:"+actualResult);
  
  }

  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
