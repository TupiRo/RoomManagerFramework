package org.roommanager.test.admin.impersonation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.common.ReadFile;
import org.roommanager.models.admin.impersonation.ImpersonationModel;
import org.roommanager.pageobjects.admin.impersonation.ImpersonationPage;
import org.roommanager.pageobjects.admin.login.LoginPage;
import org.roommanager.pageobjects.admin.main.MainPage;
import org.roommanager.pageobjects.browser.BrowserManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DisabledImpersonation {
  
  private static WebDriver driver;
  public String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public ReadFile reader = new ReadFile();

  @BeforeSuite
  public void setUp() throws Exception {
	  driver = BrowserManager.initFireFox();
    //driver = BrowserManager.initBrowser();
   
  }

  @Test(priority = 1)
  public void testDisabledImpersonation() throws Exception {
	
	String expectedResult = "Impersonation is now disabled.";
	By actualResult = ImpersonationModel.MESSAGE_IMPERSONATION;
	
	Logger logger = Logger.getLogger("testDisabledImpersonation");
	PropertyConfigurator.configure("config/log4j.properties");
	
    
    logger.info("Browser Opened");
    /*Test Impersonation is Disabled*/
    baseUrl = reader.getBaseURL();
    driver.get(baseUrl + "/#/login");
	
    LoginPage logIn = new LoginPage(driver);
	MainPage main = logIn.signInButton();
	ImpersonationPage impersonation = main.selectImpersonationOption();
	impersonation.checkImpersonation().saveImpersonation();
	
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(actualResult));
    assertEquals(expectedResult, driver.findElement(actualResult).getText());
	logger.info("Verify Assert of the Test");
  }

  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
