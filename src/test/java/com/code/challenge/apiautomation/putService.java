package com.code.challenge.apiautomation;

import static com.jayway.restassured.RestAssured.given;

import org.json.JSONObject;

import com.jayway.restassured.response.Response;

/**
 * Put Service class is created to test all the scenarios present 
 * in the code challenge
 */
public class putService {
	
	static Response resp;
	static int statusCode;
	static String statusLine;
	
	/**
	 * This method is used to trigger the API with rest assured libraries with URI
	 * @param uri
	 * @param inputRequest
	 * @param id
	 * @param title
	 * @param body
	 * @param userId
	 */
	public static void callJsonPlaceHolderPostService(String uri, String inputRequest, String id, String title, String body, String userId){
		JSONObject objectCreation = new JSONObject();
		objectCreation.put("id", id);
		objectCreation.put("title", title);
		objectCreation.put("body", body);
		objectCreation.put("userId", userId);
		System.out.println("The Test URI for PUT Service ---> " +uri+"/"+inputRequest);
		System.out.println("The Object body --->" +objectCreation);
		resp = given().body(objectCreation).when().put(uri +"/"+inputRequest);
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
		} else {
			System.out.println("Test execution failed, Status Code: "+statusCode+ "; Status Line: "+statusLine);
		}	
	}
	
	/**
	 * This method is used to validate whether record is updated.
	 * @param recordCount
	 */
	public static void validateRecordUpdated(int inputRequest){
		int actualId = resp.jsonPath().getInt("id");
		
		if (actualId == inputRequest){
			System.out.println("Test case passed for new record creation: Actual ID from response: " +actualId+" ---> Input Request ID: " +inputRequest);
		} else {
			System.out.println("Test case failed for new record creation: Actual ID from response: " +actualId+" ---> Input Request ID: " +inputRequest);
		}
	}

}
