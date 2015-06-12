package org.roommanager.pageobjects.browser;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.roommanager.common.ReadFile;

public class BrowserManager {
	
	public static WebDriver driver;
		
	public BrowserManager(){	
	}
	
	public static WebDriver initBrowser(){
		if(driver == null){
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		}
	    return driver;
	}
	
	public static WebDriver initFireFox(){
		if(driver == null){
			
		    driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		}
	    return driver;
	}
	
}
