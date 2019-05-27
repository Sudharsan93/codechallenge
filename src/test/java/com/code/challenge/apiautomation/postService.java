package com.code.challenge.apiautomation;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;

/**
 * Post Service class is created to test all the scenarios present 
 * in the code challenge
 */
public class postService {
	
	static Response resp;
	static int statusCode;
	static String statusLine;

	/**
	 * This method is used to trigger the API with rest assured libraries with URI
	 * @param uri
	 */
	public static void callJsonPlaceHolderPostService(String uri, String postPayload) {
		resp = given().body(postPayload).when().post(uri);
	}
	
	/**
	 * This method is used to validate the status code of the response.
	 * @param responseCode
	 */
	public static void validateStatusCode(String responseCode){
		
		int responseCodeAssert = Integer.parseInt(responseCode);
		statusCode = resp.getStatusCode();
		statusLine = resp.getStatusLine();
		
		if (statusCode == responseCodeAssert && statusLine.contains("Created")) {
			System.out.println("Response Body -->" + resp.getBody().asString());
			System.out.println("Test case passed with Status Code: "+statusCode+ " & Status Line: "+statusLine);
		} else {
			System.out.println("Test execution failed, Status Code: "+statusCode+ "; Status Line: "+statusLine);
		}
		
	}
	
	/**
	 * This method is used to validate whether the new record is created in the response.
	 * @param recordCount
	 */
	public static void validateNewRecordCreated(int recordId){
		int actualId = resp.jsonPath().getInt("id");
		
		if (actualId == recordId){
			System.out.println("Test case passed for new record creation: Actual ID from response: " +actualId+" ---> Input Request ID: " +recordId);
		} else {
			System.out.println("Test case failed for new record creation: Actual ID from response: " +actualId+" ---> Input Request ID: " +recordId);
		}
	}

}
