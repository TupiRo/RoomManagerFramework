package org.roommanager.pageobjects.admin.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.impersonation.ImpersonationModel;
import org.roommanager.pageobjects.admin.main.MainPage;

public  class LoginPage {
	
	private static WebDriver driver;
	
	By signinButtonLocator = By.xpath("//button");
	By messageLocator = ImpersonationModel.MESSAGE_IMPERSONATION;
	
    public LoginPage(WebDriver driver) {
      this.driver = driver;
    }

    // The login page allows the user to type their username into the username field
    public MainPage signInButton() {
    	
    	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(messageLocator));
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(signinButtonLocator));
    	driver.findElement(signinButtonLocator).click();
    	
    	LoggerManager.messageLogger("click on SignIn Button");
    	
        return new MainPage(driver);    
    }

}
