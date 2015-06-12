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
	
	public String getUserName(){
		return prop.getProperty("userName");
	}
	
	public String getPassword(){
		return prop.getProperty("password");
	}
}

