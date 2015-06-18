package org.roommanager.test.admin.impersonation;






import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.roommanager.common.LoggerManager;
import org.roommanager.common.ReadFile;
import org.roommanager.models.admin.impersonation.ImpersonationModel;
import org.roommanager.pageobjects.admin.impersonation.ImpersonationPage;
import org.roommanager.pageobjects.admin.login.LoginPage;
import org.roommanager.pageobjects.admin.main.MainPage;
import org.roommanager.pageobjects.browser.BrowserManager;
import org.apache.log4j.Logger;


public class EnabledImpersonation {
  private static WebDriver driver;
  public static Logger logger;
  public ReadFile reader = new ReadFile();
  public String baseUrl = reader.getBaseURL();

  @BeforeSuite
  public void setUp() throws Exception {
	  
	  //driver = BrowserManager.initFireFox();
	  driver = BrowserManager.initBrowser();
	  LoggerManager.initLogger();
	  

  }

  @BeforeTest
  public void setUpTest() throws Exception {
	  
	  driver.get(baseUrl + "/#/login");
	  LoggerManager.messageLogger("Browser Opened");
	
	  LoginPage logIn = new LoginPage(driver);
	  MainPage main = logIn.signInButton();
	  ImpersonationPage impersonation = main.selectImpersonationOption();
	  impersonation.verifyImpersonationIsEnabled()
					.saveImpersonation();
	  
	  (new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(ImpersonationModel.MESSAGE_IMPERSONATION));
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }
  
  @Test
  public void testEnabledImpersonation() throws Exception {
	
	/*Expected and Actual Result*/
	String expectedResult = "Impersonation is now enabled."; 
	By actualResult = ImpersonationModel.MESSAGE_IMPERSONATION;
	
	
	/*Test for Set Impersonation to Enabled*/
	//baseUrl = reader.getBaseURL();
	driver.get(baseUrl + "/#/login");
	LoggerManager.messageLogger("Browser Opened");
	
	driver.navigate().refresh();
	LoginPage logIn = new LoginPage(driver);
	MainPage main = logIn.signInButton();
	ImpersonationPage impersonation = main.selectImpersonationOption();
	impersonation.checkImpersonation()
				.saveImpersonation();
	
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(actualResult));
    assertEquals(expectedResult, driver.findElement(actualResult).getText());
    (new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(actualResult));
	
	
  }
  
  @AfterTest
  public void tearDownTest() throws Exception {
	  
	  driver.get(baseUrl + "/#/login");
		LoggerManager.messageLogger("Browser Opened");
		
		driver.navigate().refresh();
		LoginPage logIn = new LoginPage(driver);
		MainPage main = logIn.signInButton();
		ImpersonationPage impersonation = main.selectImpersonationOption();
		impersonation.checkImpersonation()
					.saveImpersonation();
		
	  (new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(ImpersonationModel.MESSAGE_IMPERSONATION));
	  (new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(ImpersonationModel.MESSAGE_IMPERSONATION));
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


  }

  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
  }
}
