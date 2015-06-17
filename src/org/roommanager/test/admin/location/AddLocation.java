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
 

import org.roommanager.common.LoggerManager;
import org.roommanager.common.ReadFile;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.pageobjects.admin.location.LocationPage;
import org.roommanager.pageobjects.admin.login.LoginPage;
import org.roommanager.pageobjects.admin.main.MainPage;
import org.roommanager.pageobjects.browser.BrowserManager;



public class AddLocation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public ReadFile reader = new ReadFile();

  @BeforeSuite
  public void setUp() throws Exception {
	  driver = BrowserManager.initBrowser();
	  LoggerManager.initLogger();
  }
  
  @Test
  public void testAddLocationSelenium() throws Exception {
	
	/*Variables*/
	String nameLocation = "LocationTest01";
	
	/*Expected and Actual Result*/
	String expectedResult = "Location successfully added";
	By actualResult = LocationModel.MESSAGECREATE_LOCATION;
	  
	/*Test for Add a Location*/
	baseUrl = reader.getBaseURL();
	driver.get(baseUrl + "/#/login");
	LoggerManager.messageLogger("Browser Opened");
	
    LoginPage logIn = new LoginPage(driver);
    MainPage main = logIn.signInButton();
    LocationPage location = main.selectLocationOption();
    location.selectAddLocationButton()
    		.setName(nameLocation)
    		.setDisplayName(nameLocation)
    		.saveNewLocation();
    
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(actualResult));
	assertEquals(expectedResult, driver.findElement(actualResult).getText());
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(actualResult));
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
