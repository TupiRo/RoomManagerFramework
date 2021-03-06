package org.roommanager.pageobjects.admin.impersonation;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.common.LoggerManager;
import org.roommanager.models.admin.impersonation.ImpersonationModel;

public class ImpersonationPage {
	
	public static WebDriver driver;
	
	By impersonationLocator = ImpersonationModel.CHECKBOX_IMPERSONATION;
	By saveButtonLocator = ImpersonationModel.SAVEBUTTON;
	By messageLocator = ImpersonationModel.MESSAGE_IMPERSONATION;
	
    public ImpersonationPage(WebDriver driver) {
        this.driver = driver;
    }

    public ImpersonationPage checkImpersonation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("label.control.checkbox > span.checkbox-label")));
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
    	driver.findElement(impersonationLocator).click();
    	LoggerManager.messageLogger("Click on Impersonation CheckBox");
        return this;    
    }
    
    public ImpersonationPage saveImpersonation() {
    	
    	(new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(saveButtonLocator));
    	driver.findElement(saveButtonLocator).click();
    	LoggerManager.messageLogger("Click on Save Button");
        return this;    
    }
    
    public ImpersonationPage verifyImpersonationIsEnabled() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
        if(driver.findElement(impersonationLocator).isSelected()){
        	driver.findElement(impersonationLocator).click();
        }
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
        return this;    
    }
    
	public ImpersonationPage verifyImpersonationIsDisabled() {
	    	
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
        if(!driver.findElement(impersonationLocator).isSelected()){
        	driver.findElement(impersonationLocator).click();
        }
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
        return this;     
    }

}
