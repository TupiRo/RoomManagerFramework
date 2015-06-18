package org.roommanager.pageobjects.admin.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.pageobjects.admin.location.CreateLocationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class CreateResourcePage {

	private final WebDriver driver;
	By nameFieldLocator = LocationModel.NAMEFIELD_LOCATION;
	By displayNameFieldLocator = LocationModel.DISPLAYNAMEFIELD_LOCATION;
	By saveButtonLocator = LocationModel.SAVEBUTTON_LOCATION;

	
    public CreateResourcePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateResourcePage setName(String nameResource){
    	
    	
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-xs-12 > div.row")));
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(nameResource);
        
        LoggerManager.messageLogger("Setting the Name of the New Location");

        return this;
    }
    
    public CreateResourcePage setDisplayName(String nameResource){
    	
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(nameResource);
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
        
        LoggerManager.messageLogger("Setting the DisplayName of the New Location");

        return this;
    }
    
    public ResourcePage saveNewResource() {
        
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.info")));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.info")));
    	driver.findElement(By.cssSelector("button.info")).click();
    	
    	LoggerManager.messageLogger("Click on Save Button");
    	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button.info")));
    	
    	return new ResourcePage(driver);    
    }  
}
