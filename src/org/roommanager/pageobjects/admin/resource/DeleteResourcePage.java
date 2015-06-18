package org.roommanager.pageobjects.admin.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class DeleteResourcePage {
	
	private final WebDriver driver;
	By removeButtonLocator = LocationModel.REMOVEBUTTON_DELETELOCATION;
	By formLocator = LocationModel.FORM_DELETELOCATION;
	
    public DeleteResourcePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public LocationPage removeLocation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(formLocator));
        driver.findElement(removeButtonLocator).click();
        
        LoggerManager.messageLogger("Click on Remove Button to confirm remove a Location");
        
    	return new LocationPage(driver);    
    }
}
