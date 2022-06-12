package com.demoblaze.step_definitions;


import com.demoblaze.apiCalls.PutApiCall;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UpdatePet {

    PutApiCall putobj = new PutApiCall();

    @Then("^user get the response code '(\\d+)'$")
    public void user_get_the_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From PET POST API Call: " + respcode);

        int code = putobj.get_status_code();

        Assert.assertEquals(code, respcode);

    }


    @And("user gets the updated {string} status in response")
    public void userGetsTheUpdatedStatusInResponse(String status) {
        String responsemessage = putobj.receive_message();

        Assert.assertTrue(responsemessage.contains(status));
    }


    @Given("user put the update pet request to pet id {string} and pet name {string} status to {string}")
    public void userPutTheUpdatePetRequestToPetIdAndPetNameStatusTo(String id, String name, String status) {
        putobj.update_pet(id, name, status);
    }
}
