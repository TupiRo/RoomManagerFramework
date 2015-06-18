package org.roommanager.pageobjects.admin.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.models.admin.resource.CreateResourceModel;
import org.roommanager.pageobjects.admin.location.CreateLocationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class CreateResourcePage {

	private final WebDriver driver;
	By formCreateResourceLocator = CreateResourceModel.FORMCREATE_RESOURCE;
	By nameFieldLocator = CreateResourceModel.NAMEFIELD_RESOURCE;
	By displayNameFieldLocator = CreateResourceModel.DISPLAYNAMEFIELD_RESOURCE;
	By saveButtonLocator = CreateResourceModel.SAVEBUTTON_RESOURCE;

	
    public CreateResourcePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateResourcePage setName(String nameResource){
    	
    	
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(formCreateResourceLocator));
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(nameFieldLocator));
        driver.findElement(nameFieldLocator).clear();
        driver.findElement(nameFieldLocator).sendKeys(nameResource);
        
        LoggerManager.messageLogger("Setting the Name of the New Resource");

        return this;
    }
    
    public CreateResourcePage setDisplayName(String nameResource){
    	
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(displayNameFieldLocator));
        driver.findElement(displayNameFieldLocator).clear();
        driver.findElement(displayNameFieldLocator).sendKeys(nameResource);
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(displayNameFieldLocator));
        
        LoggerManager.messageLogger("Setting the DisplayName of the New Resource");

        return this;
    }
    
    public ResourcePage saveNewResource() {
        
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(saveButtonLocator));
    	driver.findElement(saveButtonLocator).click();
    	
    	LoggerManager.messageLogger("Click on Save Button");
    	(new WebDriverWait(driver, 120)).until(ExpectedConditions.invisibilityOfElementLocated(saveButtonLocator));
    	
    	return new ResourcePage(driver);    
    }  
}
