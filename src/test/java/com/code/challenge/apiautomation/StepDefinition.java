package com.code.challenge.apiautomation;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * This class contains piece of code which connects the Gherkin file and supporting Java code
 */
public class StepDefinition {
	
	@Given("^the place holder API is been hit with \"([^\"]*)\" and retrieve detail$")
	public void the_place_holder_API_is_been_hit_with_and_retrieve_detail(String uri) throws Throwable {
		getService.callJsonPlaceHolderGetService(uri);
	}

	@Then("^validate the status code as \"([^\"]*)\"$")
	public void validate_the_status_code_as(String responseCode) throws Throwable {
		getService.validateStatusCode(responseCode);
	}
	
	@Then("^validate the record count with (\\d+)$")
	public void validate_the_record_count_with(int recordCount) throws Throwable {
		getService.validateHundredRecord(recordCount);
	}
	
	@Given("^the place holder API is been hit with \"([^\"]*)\" \"([^\"]*)\" and retrieve detail for the input$")
	public void the_place_holder_API_is_been_hit_with_and_retrieve_detail_for_the_input(String uri, String inputRequest) throws Throwable {
	    getService.callJsonPlaceHolderServiceWithInput(uri, inputRequest);
	}

	@Then("^validate the response with (\\d+)$")
	public void validate_the_response_with(int inputRequest) throws Throwable {
		getService.validateResponseMatchesWithInput(inputRequest);
	}
	
	@Given("^the json place holder API mS is been hit with body request and allow to create new record$")
	public void the_json_place_holder_API_mS_is_been_hit_with_body_request_and_allow_to_create_new_record(DataTable uriPayload) throws Throwable {
		
		List<Map<String, String>> list = uriPayload.asMaps(String.class, String.class);
		String uri = list.get(0).get("uri");
		String postPayload = list.get(0).get("postPayload");
		postService.callJsonPlaceHolderPostService(uri, postPayload);
	}
	
	@Then("^validate the status code as for post service$")
	public void validate_the_status_code_as_for_post_service(DataTable responseCodeCheck) throws Throwable {
		List<Map<String, String>> list = responseCodeCheck.asMaps(String.class, String.class);
		String responseCode = list.get(0).get("responseCode");
		postService.validateStatusCode(responseCode);
	}

	@Then("^validate the new record$")
	public void validate_the_new_record(DataTable recordIdCheck) throws Throwable {
		List<Map<String, String>> list = recordIdCheck.asMaps(String.class, String.class);
		String recordId = list.get(0).get("recordId");
		int recordIdInt = Integer.parseInt(recordId);
		postService.validateNewRecordCreated(recordIdInt);
	}
	
	@Given("^the json place holder API mS is been hit with body request \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"and allow to update record$")
	public void the_json_place_holder_API_mS_is_been_hit_with_body_request_and_allow_to_update_record(String uri, String inputRequest, String id, String title, String body, String userId) throws Throwable {
		putService.callJsonPlaceHolderPostService(uri, inputRequest, id, title, body, userId);
	}
	
	@Then("^validate the status code as \"([^\"]*)\" for put service$")
	public void validate_the_status_code_as_for_put_service(String responseCode) throws Throwable {
	    putService.validateStatusCode(responseCode);
	}

	@Then("^validate the response with (\\d+) for put service$")
	public void validate_the_response_with_for_put_service(int inputRequest) throws Throwable {
	    putService.validateRecordUpdated(inputRequest);
	}
	
	@Given("^the place holder API is been hit with \"([^\"]*)\" \"([^\"]*)\" and delete the detail$")
	public void the_place_holder_API_is_been_hit_with_and_delete_the_detail(String uri, String inputRequest) throws Throwable {
	    deleteService.callJsonPlaceHolderDeleteService(uri, inputRequest);
	}

	@Then("^validate the status code as \"([^\"]*)\" for delete service$")
	public void validate_the_status_code_as_for_delete_service(String responseCode) throws Throwable {
	    deleteService.validateStatusCode(responseCode);
	}

}
