package com.code.challenge.apiautomation;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;

/**
 * Put Service class is created to test all the scenarios present 
 * in the code challenge
 */
public class deleteService {
	
	static Map<String, String> headers = new HashMap<String, String>();
	static Response resp;
	static int statusCode;
	static String statusLine;
	
	/**
	 * This method is used to trigger the API with rest assured libraries with URI
	 * @param uri
	 */
	public static void callJsonPlaceHolderDeleteService(String uri, String inputRequest) {
		headers.put("Content-Type", "application/json");
		headers.put("charset", "UTF-8");
		System.out.println("The Test URI for delete Service ---> " +uri+"/"+inputRequest);
		resp = given().when().headers(headers).delete(uri +"/"+inputRequest);
	}
	
	/**
	 * This method is used to validate the status code of the response.
	 * @param responseCode
	 */
	public static void validateStatusCode(String responseCode){
		
		int responseCodeAssert = Integer.parseInt(responseCode);
		statusCode = resp.getStatusCode();
		statusLine = resp.getStatusLine();
		
		if (statusCode == responseCodeAssert && statusLine.contains("OK")) {
			System.out.println("Response Body --> " + resp.getBody().asString());
			System.out.println("Test case passed with Status Code: "+statusCode+ " & Status Line: "+statusLine);
		} else if (statusCode == 404 && statusLine.contains("Not Found")) {
			System.out.println("Test case passed for invalid request -->Status Code: "+statusCode+ "; Status Line: "+statusLine);
		} else {
			System.out.println("Test execution failed, Status Code: "+statusCode+ "; Status Line: "+statusLine);
		}
		
		Map<String, String> json = resp.jsonPath().getJsonObject("$");
		System.out.println("Size Check --> " +json.size());
		
		if (json.size() ==  0){
			System.out.println("Test case passed --> " +json.size());
		} else {
			System.out.println("Test case failed --> " +json.size());
		}
		
	}

}
