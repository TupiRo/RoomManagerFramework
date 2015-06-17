package org.roommanager.common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiManager {
	
	public static ReadFile reader;
	public String json;

	public static String jsonImpersonation(String impersonation){
		String impersonationBody = "{"
			+ " \"impersonate\": \""+ impersonation +"\""
			+ "}";
		return impersonationBody;
	}
	
	private  String postRequest(String jsonImpersonation, String urlRequest) {
		reader = new ReadFile();
		String url = reader.getBaseURL()+ "services";
		 
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(jsonImpersonation);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            json = EntityUtils.toString(result.getEntity(), "UTF-8");
            
       
        } 
		catch (IOException ex) {
			
        }
		return json;
		
		
    }
	
	private static void deleteRequest(String id) {
		reader = new ReadFile();
		String url = reader.getBaseURL() + "resources/" + id;
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpDelete request = new HttpDelete(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
        } 
		catch (IOException ex) {
        }
    }
	
	private static void jsonRequest(String json){
		
        try {
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(json);

            if (resultObject instanceof JSONArray) {
                JSONArray array=(JSONArray)resultObject;
                for (Object object : array) {
                    JSONObject obj =(JSONObject)object;
                    System.out.println(obj.get("example"));
                    System.out.println(obj.get("fr"));
                }

            }else if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                System.out.println(obj.get("example"));
                System.out.println(obj.get("fr"));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
	}
	
}
