package org.roommanager.pageobjects.admin.impersonation;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.models.admin.impersonation.ImpersonationModel;

public class ImpersonationPage {
	
	private final WebDriver driver;
	
	By impersonationLocator = ImpersonationModel.CHECKBOX_IMPERSONATION;
	By saveButtonLocator = ImpersonationModel.SAVEBUTTON;
	By messageLocator = ImpersonationModel.MESSAGE_IMPERSONATION;
	
    public ImpersonationPage(WebDriver driver) {
        this.driver = driver;
    }

    public ImpersonationPage checkImpersonation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(impersonationLocator));
    	driver.findElement(impersonationLocator).click();
        return this;    
    }
    
    public ImpersonationPage saveImpersonation() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(saveButtonLocator));
    	driver.findElement(saveButtonLocator).click();
        return this;    
    }
    
    public ImpersonationPage verifyImpersonationIsEnabled() {
    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(messageLocator));
        assertEquals("Impersonation is now enabled.", driver.findElement(messageLocator).getText());
        return this;    
    }
    
	public ImpersonationPage verifyImpersonationIsDisabled() {
	    	
    	(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(messageLocator));
        assertEquals("Impersonation is now disabled.", driver.findElement(messageLocator).getText());
        return this;    
    }

}
