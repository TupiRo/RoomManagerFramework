package org.roommanager.test.admin.resource;

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
import org.roommanager.pageobjects.admin.resource.CreateResourcePage;
import org.roommanager.pageobjects.admin.resource.ResourcePage;
import org.roommanager.pageobjects.browser.BrowserManager;



public class AddResource {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public ReadFile reader = new ReadFile();
  public String nameResource;

  @BeforeSuite
  public void setUp() throws Exception {
	  driver = BrowserManager.initBrowser();
	  LoggerManager.initLogger();
  }
  
  @Test
  public void testAddResourceSelenium() throws Exception {
	
	/*Variables*/
	nameResource = "LocationTest01";
	
	/*Expected and Actual Result*/
	String expectedResult = "Location successfully added";
	By actualResult = LocationModel.MESSAGECREATE_LOCATION;
	  
	/*Test for Add a Resource*/
	baseUrl = reader.getBaseURL();
	driver.get(baseUrl + "/#/login");
	LoggerManager.messageLogger("Browser Opened");
	
    LoginPage logIn = new LoginPage(driver);
    MainPage main = logIn.signInButton();
    ResourcePage resource = main.selectResourceOption();
    CreateResourcePage createResource = resource.selectAddResourceButton();
    		createResource.setName(nameResource)
    					.setDisplayName(nameResource);
    
    ResourcePage newResource = createResource.saveNewResource();
    	newResource.selectSeacrhField()
    				.setSearchField(nameResource);
    
    /*(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(actualResult));
	assertEquals(expectedResult, driver.findElement(actualResult).getText());
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(actualResult));*/
	
	/**/
	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ng-scope > span.ng-binding")));
    assertEquals(nameResource, driver.findElement(By.cssSelector("div.ng-scope > span.ng-binding")).getText());
    LoggerManager.messageLogger("Verifying the name resource");
    System.out.println("Expected Result: "+nameResource);
    System.out.println("Actual Result: "+driver.findElement(By.cssSelector("div.ng-scope > span.ng-binding")).getText());
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @AfterTest
  public void tearDownTest() throws Exception{
	  String resourceToBeDeleted = "LocationTest01";
	  ApiManager.deleteRequest(resourceToBeDeleted);
	  System.out.println("Apiiiiii");
  }
  
 /* @AfterTest
  public void testRemoveLocationSelenium() throws Exception {
	

	//Expected and Actual Result
	//By expectedResult = LocationModel.NAMEREMOVE_LOCATION;
	//String expectedResult = "Location "+nameLocation+" sucessfully removed";
	By actualResult = LocationModel.MESSAGECREATE_LOCATION;
	  
	/*Test for Add a Location
	baseUrl = reader.getBaseURL();
	driver.get(baseUrl + "/#/login");
	LoggerManager.messageLogger("Browser Opened");
	
	driver.navigate().refresh();
	
    LoginPage logIn = new LoginPage(driver);
    MainPage main = logIn.signInButton();
    LocationPage location = main.selectLocationOption();
    			location.selectLocation();
    DeleteLocationPage deleteLocation = location.selectRemoveLocationButton();
    deleteLocation.removeLocation();
    
    /*Assert of the Test Case
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(actualResult));
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(actualResult));
  }*/


  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

