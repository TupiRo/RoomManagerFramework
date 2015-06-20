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
import org.roommanager.models.admin.resource.ResourceModel;
import org.roommanager.pageobjects.admin.login.LoginPage;
import org.roommanager.pageobjects.admin.main.MainPage;
import org.roommanager.pageobjects.admin.resource.CreateResourcePage;
import org.roommanager.pageobjects.admin.resource.ResourcePage;
import org.roommanager.pageobjects.browser.BrowserManager;



public class AddResource {
  private WebDriver driver;
  private String baseUrl;
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
	nameResource = "ResourceTest01";
	
	/*Expected and Actual Result*/
	String expectedResult = nameResource;
	  
	/*Test for Add a Resource*/
	baseUrl = reader.getBaseURL();
	driver.get(baseUrl + reader.getLoginURL());
	LoggerManager.messageLogger("Browser Opened");
	
    LoginPage logIn = new LoginPage(driver);
    MainPage main = logIn.signInButton();
    ResourcePage resource = main.selectResourceOption();
    CreateResourcePage createResource = resource.selectAddResourceButton();
    		createResource.setName(nameResource)
    					.setDisplayName(nameResource);
        	
    ResourcePage newResource = createResource.saveNewResource();
    				newResource.selectGridResources();
    				
	
	/*Verifying Assert of the Test Case*/
   
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(ResourceModel.GRID_RESOURCES));
    String actualResult = newResource.getResourceName(nameResource);
    assertEquals(expectedResult, actualResult);
    
    System.out.println("Expected Result:"+expectedResult);
    System.out.println("Actual Result:"+actualResult);
    
  }
  
  @AfterTest
  public void tearDownTest() throws Exception{
	  
	  ApiManager.deleteRequest(nameResource, reader.getApiResourcesURL());
	  System.out.println("Apiiiiii");
  }
  
  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
  }
}

