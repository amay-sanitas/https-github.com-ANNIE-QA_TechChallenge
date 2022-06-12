package com.demoblaze.step_definitions;

import com.demoblaze.apiCalls.GetApiCall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GetPet {

    GetApiCall getobj = new GetApiCall();

    @Given("^user call the get pet request with id '(\\d+)'$")
    public void user_get_the_pet_request_with_id(int id) throws Throwable {

        getobj.get_pet(id);

    }


    @Then("^user get the success response code '(\\d+)'$")
    public void user_get_the_success_response_code(int respcode) {

        System.out.println("Response Code From GET PET API Call: " + respcode);

        int code = getobj.get_status_code();

        Assert.assertEquals(respcode, code);

    }

    @Then("^user gets the pet details in the response$")
    public void user_gets_the_pet_details_in_the_response() throws Throwable {

        String responsemessage = getobj.receive_message();

        Assert.assertTrue(responsemessage.contains("\"status\": \"available\""));

    }

    @Given("user call the get pet by {string} request")
    public void userCallTheGetPetByRequest(String status) {
        getobj.get_pet_by_status(status);
    }
}
