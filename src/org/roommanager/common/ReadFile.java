package org.roommanager.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class ReadFile {
  
	Properties prop = new Properties();
	InputStream input = null;
	
	public ReadFile(){
		try {
			 
			input = new FileInputStream("config/config.properties");
	 
			// load a properties file
			prop.load(input);
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	public String getBaseURL(){
		return prop.getProperty("baseURL");
	}
	
	public String getApiURL(){
		return prop.getProperty("apiURL");
	}
	
	
	public String getLoginURL(){
		return prop.getProperty("loginURL");
	}
	
	public String getUserName(){
		return prop.getProperty("userName");
	}
	
	public String getPassword(){
		return prop.getProperty("password");
	}
	
	public String getApiLocationsURL(){
		return prop.getProperty("apiLocationsURL");
	}
	
	public String getApiResourcesURL(){
		return prop.getProperty("apiResourcesURL");
	}
	
	public String getApiServicesURL(){
		return prop.getProperty("apiServicesURL");
	}
}

