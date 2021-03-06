package org.roommanager.pageobjects.admin.main;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.pageobjects.admin.impersonation.ImpersonationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;
import org.roommanager.pageobjects.admin.resource.ResourcePage;

public class MainPage {
	
	private static WebDriver driver;
	
	By impersonationLocator = By.linkText("Impersonation");
	By locationLocator = By.linkText("Locations");
	By resourceLocator = By.linkText("Resources");
	
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
   
    public ImpersonationPage selectImpersonationOption() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(impersonationLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
        driver.findElement(impersonationLocator).click();
        LoggerManager.messageLogger("Selecting Impersonation Option");
        return new ImpersonationPage(driver);    
    }
    
    public LocationPage selectLocationOption() {
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(locationLocator));
        driver.findElement(locationLocator).click();
        
        LoggerManager.messageLogger("Selecting Location Option");
        return new LocationPage(driver);    
    }
    
    public ResourcePage selectResourceOption() {
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(resourceLocator));
        driver.findElement(resourceLocator).click();
        
        LoggerManager.messageLogger("Selecting Resource Option");
        return new ResourcePage(driver);    
    }
}
