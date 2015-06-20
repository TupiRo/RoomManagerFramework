package org.roommanager.test.admin.resource;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByCssSelector;
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
import org.roommanager.pageobjects.admin.resource.DeleteResourcePage;
import org.roommanager.pageobjects.admin.resource.ResourcePage;
import org.roommanager.pageobjects.browser.BrowserManager;



public class RemoveResource {
  private WebDriver driver;
  private String baseUrl;
  public ReadFile reader = new ReadFile();
  public String resourceName;

  @BeforeSuite
  public void setUp() throws Exception {
	  driver = BrowserManager.initBrowser();
	  LoggerManager.initLogger();
  }
  
  @BeforeTest
  public void setUpTest() throws Exception {
	  resourceName = "ResourceTest01";
	  String resourceDisplayName = "ResourceTest01";
	  String resourceDescription = "ResourceTest01 Description";
	  String resourceIcon = "";
	  String urlRequest = reader.getApiResourcesURL();
	  ApiManager.createNewResource(resourceName, resourceDisplayName, resourceIcon, resourceDescription,urlRequest);
  }
  
  @Test
  public void testRemoveResourceSelenium() throws Exception {
	
	/*Variables*/
	  resourceName = "ResourceTest01";
	
	/*Expected and Actual Result*/
	boolean expectedResult = true;
	  
	/*Test for Add a Resource*/
	baseUrl = reader.getBaseURL();
	driver.get(baseUrl + reader.getLoginURL());
	LoggerManager.messageLogger("Browser Opened");
	
	driver.navigate().refresh();
    LoginPage logIn = new LoginPage(driver);
    MainPage main = logIn.signInButton();
    ResourcePage resource = main.selectResourceOption();
    			resource.selectGridResources()
    					.selectResource(resourceName);
    DeleteResourcePage deleteResource = resource.selectRemoveResourceButton();
    ResourcePage removedResource = deleteResource.removeResource();
    
    removedResource.refreshResourcePage();
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(ResourceModel.GRID_RESOURCES));
    
    /*Assert about Remove a Location*/
    boolean actualResult = removedResource.VerifyResourceWasRemoved(resourceName);
    assertTrue(actualResult);
    
    System.out.println("Resource Name:"+resourceName);
    System.out.println("Expected Result:"+expectedResult);
    System.out.println("Actual Result:"+actualResult);
    
  }
  
  
  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
  }
}