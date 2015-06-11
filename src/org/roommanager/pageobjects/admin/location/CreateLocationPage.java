package org.roommanager.pageobjects.admin.location;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateLocationPage {
	
	private final WebDriver driver;
	By nameFieldLocator = By.id("location-add-name");
	By displayNameFieldLocator = By.id("location-add-display-name");
	By saveButtonLocator = By.cssSelector("button.btn.btn-primary");

	
    public CreateLocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateLocationPage setName(String nameLocation){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(nameFieldLocator));
        driver.findElement(nameFieldLocator).clear();
        driver.findElement(nameFieldLocator).sendKeys(nameLocation);

        return this;
    }
    
    public CreateLocationPage setDisplayName(String nameLocation){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(displayNameFieldLocator));
        driver.findElement(displayNameFieldLocator).clear();
        driver.findElement(displayNameFieldLocator).sendKeys(nameLocation);

        return this;
    }
    
    public LocationPage saveNewLocation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(saveButtonLocator));
    	driver.findElement(saveButtonLocator).click();
        
    	return new LocationPage(driver);    
    }  
}
