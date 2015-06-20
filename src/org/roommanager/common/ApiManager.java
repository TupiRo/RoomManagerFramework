package org.roommanager.common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bsh.ParseException;

public class ApiManager {
	
	public static ReadFile reader = new ReadFile();
	public static String json;

	public static Object jsonRequest(String json){
		Object resultObject = null; 
		try {
             JSONParser parser = new JSONParser();
             resultObject = parser.parse(json);
		 }
		 catch(Exception ex){
			 LoggerManager.errorLogger("Error Message", ex);
		 }
		 return resultObject;

	}
	
	public static void postRequest(String jsonImpersonation, String urlRequest) {
		 
		String url = reader.getApiURL()+ urlRequest;
		System.out.println(url);
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(jsonImpersonation);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);   
       
        } 
		catch (Exception ex) {
			LoggerManager.errorLogger("Error Message", ex);
        }	
    }
	
	
	public static String getRequest(String urlRequest) {
		
		
		
		System.out.println(urlRequest);
		 
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(urlRequest);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            json = EntityUtils.toString(result.getEntity(), "UTF-8");
                  
        } 
		catch (IOException ex) {
			LoggerManager.errorLogger("Error Message", ex);
        }
		return json;
		
		
    }
	
	public static String getResource(String name, String urlRequest) {
		String id = null;
		String url = reader.getApiURL()+urlRequest;
	System.out.println(url);
		String propertyName = "name";
		String propertyId = "_id";
		
		String json = getRequest(url);
		Object resourcesAsJson = jsonRequest(json);
		
		if (resourcesAsJson instanceof JSONArray) {
            JSONArray array=(JSONArray)resourcesAsJson;
            for (Object object : array) {
                JSONObject obj =(JSONObject)object;
                if(obj.get(propertyName).toString().equals(name)){
                	return obj.get(propertyId).toString();
                }
            }
        }else if (resourcesAsJson instanceof JSONObject) {
            JSONObject obj =(JSONObject)resourcesAsJson;
            if(obj.get(propertyName).toString().equals(name)){
            	return obj.get(propertyId).toString();
            }
        }
		return id;
    }
	
	
	public static void deleteRequest(String name, String urlRequest) {
		String id = getResource(name,urlRequest);
		String urlDelete = reader.getApiURL()+urlRequest+"/"+ id;
		System.out.println(urlDelete);
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpDelete request = new HttpDelete(urlDelete);
            request.addHeader("content-type", "application/json");
            httpClient.execute(request);
        } 
		catch (IOException ex) {
			LoggerManager.errorLogger("Error Message", ex);
        }
    }
	
	
	public static void createNewResource(String name, String displayName, String icon, String description, String urlRequest){
		
		String jsonResource = "{ \"name\": \"[name]\", \"customName\": \"[displayName]\","
				+ " \"fontIcon\": \"[fontIcon]\", \"from\": \"\", \"description\": \"[description]\"}";
		
		jsonResource = jsonResource.replace("[name]", name)
			.replace("[displayName]", displayName)
			.replace("[fontIcon]", icon)
			.replace("[description]", description);
		postRequest(jsonResource, urlRequest);
	}	
	
	public static void createNewLocation(String name, String displayName,String description, String urlRequest){
		
		String jsonLocation = "{ \"name\": \"[name]\", \"customName\": \"[displayName]\","
				+ " \"description\": \"[description]\"}";
		System.out.println(jsonLocation);
		
		jsonLocation = jsonLocation.replace("[name]", name)
			.replace("[displayName]", displayName)
			.replace("[description]", description);
		postRequest(jsonLocation, urlRequest);
	}	
	
	
	public static void setImpersonation(String impersonation, String urlRequest, String name){
		String id = getResource(name, urlRequest);
		
		
		String jsonLocation = "{\"impersonate\": \"[impersonation]\"}";
		System.out.println(jsonLocation);
		
		jsonLocation = jsonLocation.replace("[impersonation]", impersonation);
		
		String url = reader.getApiURL()+ urlRequest+"/"+id;
		System.out.println(url);
		
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPut request = new HttpPut(url);
            StringEntity params = new StringEntity(jsonLocation);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);   
       
        } 
		catch (Exception ex) {
			LoggerManager.errorLogger("Error Message", ex);
        }	
		
		
	}	
	
	
	
}
