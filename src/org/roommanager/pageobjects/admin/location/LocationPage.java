package org.roommanager.pageobjects.admin.location;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.location.LocationModel;

import com.thoughtworks.selenium.webdriven.commands.Refresh;

public class LocationPage {
	
	private final WebDriver driver;
	
	By addButtonLocator = LocationModel.ADDBUTTON_LOCATION;
	By messageLocator = LocationModel.MESSAGECREATE_LOCATION;
	By selectCheckBoxLocator = LocationModel.SELECTCHECKBOX_LOCATION;
	By removeButtonLocator = LocationModel.REMOVEBUTTON_LOCATION;
	By messageRemoveLocator = LocationModel.MESSAGEREMOVE_LOCATION;
	By message = LocationModel.MESSAGE;
	By locationLocator = LocationModel.NAMEREMOVE_LOCATION;
	
	By gridLocator = LocationModel.GRID_LOCATION;
	By textGridLocator = LocationModel.TEXTGRID_LOCATION;
	By divLocator = LocationModel.DIV_LOCATION;
	
	
	
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
	
	public LocationPage selectLocation(String name){
		
		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(selectCheckBoxLocator));
		WebElement location = findLocation(name);
		location.click();
		
		return this;
	}
	
	public DeleteLocationPage selectRemoveLocationButton(){
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(removeButtonLocator));
    	driver.findElement(removeButtonLocator).click();
    	LoggerManager.messageLogger("Click on Remove Button");
    	
        return new DeleteLocationPage(driver);    
    }
	
	
	private WebElement findLocation(String name){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(gridLocator));
    	WebElement locations = driver.findElement(gridLocator);
    	
    	List<WebElement> locationList = locations.findElements(divLocator);
    	
    	for (WebElement location : locationList) {
			String locationName = location.findElement(textGridLocator).getText();
			System.out.println(locationName);
			if(locationName.equals(name)){
				LoggerManager.messageLogger("The Location was found");
				return location;
			}
		}
    	
    	LoggerManager.messageLogger("The Location does not exists");
    	
        return null;    
    }
	
	public String getLocationName(String locationName){
		WebElement location = findLocation(locationName);
		return location.findElement(textGridLocator).getText();	
	}
	
	public boolean VerifyLocationWasRemoved(String locationName){
		WebElement location = findLocation(locationName);
		return (location == null) ? true : false;
	}
	
	public void refreshLocationPage(){
		driver.navigate().refresh();
	}

}

