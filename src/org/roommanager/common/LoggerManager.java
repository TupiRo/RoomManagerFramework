package org.roommanager.common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoggerManager {
	
	public static Logger logger = Logger.getLogger(LoggerManager.class.getName());
		
	
	public static void initLogger(){
		PropertyConfigurator.configure("config/log4j.properties");
	}
	
	public static void messageLogger(String message){
		logger.info(message);
	}
	
}
