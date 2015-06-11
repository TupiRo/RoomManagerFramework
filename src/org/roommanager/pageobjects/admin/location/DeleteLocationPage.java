package org.roommanager.pageobjects.admin.location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteLocationPage {
	
	private final WebDriver driver;
	By removeButtonLocator = By.xpath("//button[2]");
	
	
	
	
    public DeleteLocationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public LocationPage removeLocation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(removeButtonLocator));
    	driver.findElement(removeButtonLocator).click();
        
    	return new LocationPage(driver);    
    }
    


}

