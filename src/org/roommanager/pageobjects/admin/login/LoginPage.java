package org.roommanager.pageobjects.admin.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageobjects.admin.main.MainPage;

public  class LoginPage {
	
	public WebDriver driver;
	
	By signinButtonLocator = By.xpath("//button");
	
    public LoginPage(WebDriver driver) {
      this.driver = driver;
    }

    // The login page allows the user to type their username into the username field
    public MainPage signInButton() {
    	
    	WebElement element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(signinButtonLocator));
    	driver.findElement(signinButtonLocator).click();
    	element.click();
        return new MainPage(driver);    
    }

}
