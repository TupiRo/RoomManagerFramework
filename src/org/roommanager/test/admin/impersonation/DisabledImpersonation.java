package org.roommanager.test.admin.impersonation;




import static org.junit.Assert.*;

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

@Listeners({org.roommanager.common.ScreenshotManager.class})
public class DisabledImpersonation {
  
  private static WebDriver driver;
  public static Logger logger;
  public String baseUrl;
  public ReadFile reader = new ReadFile();

  @BeforeSuite
  public void setUp() throws Exception {
	 // driver = BrowserManager.initFireFox();
	 LoggerManager.initLogger();
     driver = BrowserManager.initBrowser();
   
  }

  @Test
  public void testDisabledImpersonation() throws Exception {
	
	/*Expected and Actual Result*/
	String expectedResult = "Impersonation is now disabled.";
	By actualResult = ImpersonationModel.MESSAGE_IMPERSONATION;
	
    
    /*Test for Impersonation is Disabled*/
    baseUrl = reader.getBaseURL();
    driver.get(baseUrl + "/#/login");
    LoggerManager.messageLogger("Browser is Open");
    
    driver.navigate().refresh();
    LoginPage logIn = new LoginPage(driver);
	MainPage main = logIn.signInButton();
	ImpersonationPage impersonation = main.selectImpersonationOption();
	impersonation.checkImpersonation().saveImpersonation();
	
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(actualResult));
    assertEquals(expectedResult, driver.findElement(actualResult).getText());
    (new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(actualResult));
  }

  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
