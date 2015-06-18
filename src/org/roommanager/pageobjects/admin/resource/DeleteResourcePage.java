package org.roommanager.pageobjects.admin.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.models.admin.resource.DeleteResourceModel;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class DeleteResourcePage {
	
	private final WebDriver driver;
	By removeButtonLocator = DeleteResourceModel.REMOVEBUTTON_DELETERESOURCE;
	By formDeleteResourceLocator = DeleteResourceModel.FORM_DELETERESOURCE;
	
    public DeleteResourcePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public ResourcePage removeResource() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(formDeleteResourceLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(removeButtonLocator));
    	driver.findElement(removeButtonLocator).click();
        
        LoggerManager.messageLogger("Click on Remove Button to confirm remove a Resource");
        
    	return new ResourcePage(driver);    
    }
}
