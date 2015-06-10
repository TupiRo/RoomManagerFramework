package org.roommanagerfw.test.admin;

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
import org.roommanagerfw.common.ReadFile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class enabledImpersonation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public ReadFile reader = new ReadFile();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = reader.getBaseURL();
    //baseUrl = "http://172.20.208.174:4042/admin";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(priority = 0)
  public void testEnabledImpersonation2() throws Exception {
	Logger logger = Logger.getLogger("testEnabledImpersonation");
	PropertyConfigurator.configure("Log4j.properties");
	
	driver.get(baseUrl + "/#/login");
	logger.info("Browser Opened");
	
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
    driver.findElement(By.xpath("//button")).click();
    logger.info("Click to Sign In");
    
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Impersonation")));
    driver.findElement(By.linkText("Impersonation")).click();
    logger.info("Go to Impersonation");
   
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']")));
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    logger.info("Check Impersonation to is Enabled");
    
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.info.pull-right")));
    driver.findElement(By.cssSelector("button.info.pull-right")).click();
    logger.info("Waiting for the Message");
	
	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ng-binding.ng-scope")));
    assertEquals("Impersonation is now enabled.", driver.findElement(By.cssSelector("div.ng-binding.ng-scope")).getText());
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

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
