package org.roommanager.pageobjects.admin.resource;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	
	
    public ResourcePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateResourcePage selectAddResourceButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(addButtonLocator));
        driver.findElement(addButtonLocator).click();
    	LoggerManager.messageLogger("Click on Add Resource Button");
    	
        return new CreateResourcePage(driver);    
    }
    
		
	public ResourcePage selectResource(){
		
		/*(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(selectCheckBoxLocator));
		int locationCreated = (driver.findElements(By.xpath("//div[@id='locationGrid']/div/div[2]/div/div"))).size(); 
	    driver.findElement(selectCheckBoxLocator).click();
	    LoggerManager.messageLogger("Selecting a Location");
	    
		return this;*/
		
		/*(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(selectCheckBoxLocator));
		int locationPosition = (driver.findElements(By.xpath("//div[@id='locationGrid']/div/div[2]/div/div"))).size(); 
	    locationLocator.toString().replace("numbColumn", ""+locationPosition);
		driver.findElement(locationLocator.toString().replace("numbColumn", ""+locationPosition)).click();
	    LoggerManager.messageLogger("Selecting a Location");
	    
		return this;*/
		//div[@id='locationGrid']/div[2]/div/div[4]/div[3]/div[2]/div/span
		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ngSelectionCell.ng-scope")));
		//int resourcePosition = (driver.findElements(By.xpath("//div[@id='resourceGrid']/div[2]/div/*"))).size(); 
	    //System.out.println("Position gf "+resourcePosition);
	    System.out.println("//div[@id='resourcesGrid']/div[2]/div/div/div[3]/div[2]/div");
		//locationLocator.toString().replace("numbColumn", ""+locationPosition);
		driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div/div[3]/div[2]/div")).click();
	    LoggerManager.messageLogger("Selecting a Location");
	    
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
    	
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.id("btnRemove")));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("btnRemove")));
    	driver.findElement(By.id("btnRemove")).click();
    	LoggerManager.messageLogger("Click on Remove Button");
    	
        return new DeleteResourcePage(driver);    
    }
	
	
}
