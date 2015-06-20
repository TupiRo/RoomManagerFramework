package org.roommanager.pageobjects.admin.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.models.admin.resource.ResourceModel;
import org.roommanager.pageobjects.admin.location.CreateLocationPage;
import org.roommanager.pageobjects.admin.location.DeleteLocationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class ResourcePage {
	
	private final WebDriver driver;
	
	By addButtonLocator = ResourceModel.ADDBUTTON_RESOURCE;
	By searchFieldLocator = ResourceModel.SEARCHFIELD_RESOURCE;
	By selectSearchFieldLocator = ResourceModel.SELECTSEARCHFIELD_RESOURCE;
	By textFieldSearchLocator = ResourceModel.SEARCHTEXTFIELD_RESOURCE;
	By removeButtonLocator = ResourceModel.REMOVEBUTTON_RESOURCES;
	
	By selectGridLocator = ResourceModel.SELECTGRID_RESOURCES;
	By gridLocator = ResourceModel.GRID_RESOURCES;
	By textGridLocator = ResourceModel.TEXTGRID_RESOURCES;
	By divLocator = ResourceModel.DIV_RESOURCES;
	
	
	
    public ResourcePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateResourcePage selectAddResourceButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(addButtonLocator));
        driver.findElement(addButtonLocator).click();
    	LoggerManager.messageLogger("Click on Add Resource Button");
    	
        return new CreateResourcePage(driver);    
    }
    
		
	public ResourcePage selectResource(String name){
		
		
		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(gridLocator));
		WebElement resource = findResource(name);
		resource.click();
		
		return this;
	}
	
	public ResourcePage selectSeacrhField(){
	    
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(searchFieldLocator));
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(searchFieldLocator));
	    driver.findElement(selectSearchFieldLocator).click();
    	LoggerManager.messageLogger("Click on Search Field");
    	
        return this;    
	}
	
	public ResourcePage setSearchField(String nameResource){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(textFieldSearchLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(textFieldSearchLocator));
        driver.findElement(textFieldSearchLocator).clear();
        driver.findElement(textFieldSearchLocator).sendKeys(nameResource);
        
        LoggerManager.messageLogger("Setting the Name of the New Location");

        return this;
    }
	
	public DeleteResourcePage selectRemoveResourceButton(){
    	
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(removeButtonLocator));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(removeButtonLocator));
    	driver.findElement(removeButtonLocator).click();
    	LoggerManager.messageLogger("Click on Remove Button");
    	
        return new DeleteResourcePage(driver);    
    }
	
	public ResourcePage selectGridResources(){
	    
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(selectGridLocator));
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(selectGridLocator));
	    driver.findElement(selectGridLocator).click();
    	LoggerManager.messageLogger("Click on Next Page Button");
    	
        return this;    
	}
	
	
	
	private WebElement findResource(String name){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(gridLocator));
    	WebElement resources = driver.findElement(gridLocator);
    	
    	List<WebElement> resourceList = resources.findElements(divLocator);
    	
    	for (WebElement resource : resourceList) {
			String resourceName = resource.findElement(textGridLocator).getText();
			System.out.println(resourceName);
			if(resourceName.equals(name)){
				LoggerManager.messageLogger("The resource was found");
				return resource;
			}
		}
    	
    	LoggerManager.messageLogger("The resource not exists");
    	
        return null;    
    }
	
	public String getResourceName(String resourceName){
		WebElement resource = findResource(resourceName);
		return resource.findElement(textGridLocator).getText();	
	}
	
	public boolean VerifyResourceWasRemoved(String resourceName){
		WebElement resource = findResource(resourceName);
		return (resource == null) ? true : false;
	}
	
	public void refreshResourcePage(){
		driver.navigate().refresh();
	}
	
	
}
