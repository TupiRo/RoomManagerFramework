package org.roommanager.test.admin.impersonation;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.common.ReadFile;
import org.roommanager.pageobjects.admin.login.LoginPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class EnabledImpersonation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public ReadFile reader = new ReadFile();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = reader.getBaseURL();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test(priority = 0)
  public void testEnabledImpersonation() throws Exception {
	Logger logger = Logger.getLogger("testEnabledImpersonation");
	PropertyConfigurator.configure("resources/log4j.properties");
	
	driver.get(baseUrl + "/#/login");
	logger.info("Browser Opened");
	
	LoginPage log = new LoginPage(driver);
	
	/*Test Set Impersonation to Enabled*/
	log.signInButton()
	.selectImpersonationOption()
	.checkImpersonation()
	.saveImpersonation()
	.verifyImpersonationIsEnabled();
	logger.info("Verify Assert of the Test");
	
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
