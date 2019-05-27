package com.code.challenge.apiautomation;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.restassured.response.Response;

/**
 * Get Service class is created to test all the scenarios present 
 * in the code challenge
 */
public class getService {
	
	static Map<String, String> headers = new HashMap<String, String>();
	static Response resp;
	static int statusCode;
	static String statusLine;
	
	/**
	 * This method is used to trigger the API with rest assured libraries with URI
	 * @param uri
	 */
	public static void callJsonPlaceHolderGetService(String uri) {
		headers.put("Content-Type", "application/json");
		headers.put("charset", "UTF-8");
		System.out.println("The Test URI for Get Service ---> " +uri);
		resp = given().when().headers(headers).get(uri);
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
		
	}
	
	/**
	 * This method is used to validate the number of records in the response.
	 * @param recordCount
	 */
	public static void validateHundredRecord(int recordCount){
		List<String> jsonList = resp.jsonPath().getList("$");
		
		if (jsonList.size() == recordCount) {
			System.out.println("Test case passed with record count of -->  " +jsonList.size());
		} else {
			System.out.println("Test case failed with record count of -->  " +jsonList.size());
		}
	}
	
	/**
	 * This method is used to trigger the API with rest assured libraries with URI
	 * @param uri
	 * @param inputRequest
	 */
	public static void callJsonPlaceHolderServiceWithInput(String uri, String inputRequest) {
		headers.put("Content-Type", "application/json");
		headers.put("charset", "UTF-8");
		System.out.println("The Test URI for Get Service ---> " +uri+"/"+inputRequest);
		resp = given().when().headers(headers).get(uri +"/"+inputRequest);
	}
	
	/**
	 * This method is used to validate the ID with the input request.
	 * @param inputRequest
	 */
	public static void validateResponseMatchesWithInput(int inputRequest){
		
		int actualId = resp.jsonPath().getInt("id");
		
		if (actualId == inputRequest){
			System.out.println("Test case passed; \nActual ID from response: " +actualId+" ---> Input Request ID: " +inputRequest);
		} else {
			System.out.println("Test case failed; \nActual ID from response: " +actualId+" ---> Input Request ID: " +inputRequest);
		}
		
		Map<String, String> json = resp.jsonPath().getJsonObject("$");
		System.out.println("Size Check --> " +json.size());
		
		if (json.size() >=  4){
			System.out.println("Test case passed with one record --> " +json.size()/4);
		} else {
			System.out.println("Test case failed and record size is --> " +json.size()/4);
		}
	}
}

