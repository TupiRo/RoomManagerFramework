package org.roommanager.pageobjects.admin.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageobjects.admin.impersonation.ImpersonationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class MainPage {
	
	private final WebDriver driver;
	
	By impersonationLocator = By.linkText("Impersonation");
	By locationLocator = By.linkText("Locations");
	
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
   
    public ImpersonationPage selectImpersonationOption() {
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
        driver.findElement(impersonationLocator).click();
        
        return new ImpersonationPage(driver);    
    }
    
    public LocationPage selectLocationOption() {
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(locationLocator));
        driver.findElement(locationLocator).click();
        
        return new LocationPage(driver);    
    }
}
