package org.roommanager.pageobjects.admin.location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;


public class DeleteLocationPage {
	
	private final WebDriver driver;
	By removeButtonLocator = LocationModel.REMOVEBUTTON_DELETELOCATION;
	By formLocator = LocationModel.FORM_DELETELOCATION;
	
    public DeleteLocationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public LocationPage removeLocation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(formLocator));
        driver.findElement(removeButtonLocator).click();
        
        LoggerManager.messageLogger("Click on Remove Button to confirm remove a Location");
        
    	return new LocationPage(driver);    
    }
    


}

