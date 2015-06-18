package org.roommanager.pageobjects.admin.location;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;

public class LocationPage {
	
	private final WebDriver driver;
	
	By addButtonLocator = LocationModel.ADDBUTTON_LOCATION;
	By messageLocator = LocationModel.MESSAGECREATE_LOCATION;
	By selectCheckBoxLocator = LocationModel.SELECTCHECKBOX_LOCATION;
	By removeButtonLocator = LocationModel.REMOVEBUTTON_LOCATION;
	By messageRemoveLocator = LocationModel.MESSAGEREMOVE_LOCATION;
	By message = LocationModel.MESSAGE;
	By locationLocator = LocationModel.NAMEREMOVE_LOCATION;
	
	
	
    public LocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateLocationPage selectAddLocationButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(addButtonLocator));
    	driver.findElement(addButtonLocator).click();
    	LoggerManager.messageLogger("Click on Add Location Button");
    	
        return new CreateLocationPage(driver);    
    }
    
	public LocationPage verifyLocationWasCreated() {
	    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(message));
    	assertEquals("Location successfully added", driver.findElement(messageLocator).getText());
        return this;    
    }
	
	public LocationPage selectLocation(){
		
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
	
	public DeleteLocationPage selectRemoveLocationButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(removeButtonLocator));
    	driver.findElement(removeButtonLocator).click();
    	LoggerManager.messageLogger("Click on Remove Button");
    	
        return new DeleteLocationPage(driver);    
    }
	
	public LocationPage verifyLocationWasRemoved(String nameLocation) {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(messageRemoveLocator));
    	assertEquals("Location "+nameLocation+" sucessfully removed", driver.findElement(messageRemoveLocator).getText());
        return this;    
    }

}

