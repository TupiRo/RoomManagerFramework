package org.roommanager.pageobjects.admin.resource;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;
import org.roommanager.pageobjects.admin.location.CreateLocationPage;
import org.roommanager.pageobjects.admin.location.DeleteLocationPage;
import org.roommanager.pageobjects.admin.location.LocationPage;

public class ResourcePage {
	
	private final WebDriver driver;
	
	By addButtonLocator = LocationModel.ADDBUTTON_LOCATION;
	By messageLocator = LocationModel.MESSAGECREATE_LOCATION;
	By selectCheckBoxLocator = LocationModel.SELECTCHECKBOX_LOCATION;
	By removeButtonLocator = LocationModel.REMOVEBUTTON_LOCATION;
	By messageRemoveLocator = LocationModel.MESSAGEREMOVE_LOCATION;
	By message = LocationModel.MESSAGE;
	By locationLocator = LocationModel.NAMEREMOVE_LOCATION;
	
	
	
    public ResourcePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateResourcePage selectAddResourceButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/button")));
        driver.findElement(By.xpath("//div/div/button")).click();
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
		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(selectCheckBoxLocator));
		int locationPosition = (driver.findElements(By.xpath("//div[@id='locationGrid']/div[2]/div/*"))).size(); 
	    System.out.println("Position gf "+locationPosition);
	    System.out.println("//div[@id='locationGrid']/div[2]/div/div["+locationPosition+"]/div[3]/div[2]/div/span");
		//locationLocator.toString().replace("numbColumn", ""+locationPosition);
		driver.findElement(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+locationPosition+"]/div[3]/div[2]/div/span")).click();
	    LoggerManager.messageLogger("Selecting a Location");
	    
		return this;
	}
	
	public ResourcePage selectSeacrhField(){
	    
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button")));
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/button")));
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    	LoggerManager.messageLogger("Click on Search Field");
    	
    	
        return this;    
	}
	
	public ResourcePage setSearchField(String nameResource){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(nameResource);
        
        LoggerManager.messageLogger("Setting the Name of the New Location");

        return this;
    }
	
	
	public DeleteLocationPage selectRemoveLocationButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(removeButtonLocator));
    	driver.findElement(removeButtonLocator).click();
    	LoggerManager.messageLogger("Click on Remove Button");
    	
        return new DeleteLocationPage(driver);    
    }
	
}
