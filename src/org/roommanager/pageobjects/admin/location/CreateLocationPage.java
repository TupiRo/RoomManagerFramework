package org.roommanager.pageobjects.admin.location;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.CreateLocationModel;
import org.roommanager.models.admin.location.LocationModel;


public class CreateLocationPage {
	
	private final WebDriver driver;
	By nameFieldLocator = CreateLocationModel.NAMEFIELD_LOCATION;
	By displayNameFieldLocator = CreateLocationModel.DISPLAYNAMEFIELD_LOCATION;
	By saveButtonLocator = CreateLocationModel.SAVEBUTTON_LOCATION;

	
    public CreateLocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateLocationPage setName(String nameLocation){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(nameFieldLocator));
        driver.findElement(nameFieldLocator).clear();
        driver.findElement(nameFieldLocator).sendKeys(nameLocation);
        
        LoggerManager.messageLogger("Setting the Name of the New Location");

        return this;
    }
    
    public CreateLocationPage setDisplayName(String nameLocation){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(displayNameFieldLocator));
        driver.findElement(displayNameFieldLocator).clear();
        driver.findElement(displayNameFieldLocator).sendKeys(nameLocation);
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(displayNameFieldLocator));
        
        LoggerManager.messageLogger("Setting the DisplayName of the New Location");

        return this;
    }
    
    public LocationPage saveNewLocation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(saveButtonLocator));
    	driver.findElement(saveButtonLocator).click();
    	
    	LoggerManager.messageLogger("Click on Save Button");
    	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(saveButtonLocator));
        
    	return new LocationPage(driver);    
    }  
}
