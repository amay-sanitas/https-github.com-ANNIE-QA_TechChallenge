package com.demoblaze.step_definitions;

import com.demoblaze.apiCalls.PostApiCall;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AddPet {

    PostApiCall obj = new PostApiCall();

    @Given("^user post the add pet request with id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_post_the_add_pet_request_with_id_and_dog_name(int id, String name) {
        // Write code here that turns the phrase above into concrete actions
        obj.add_pet(id,name);

    }

    @Then("^user get response code '(\\d+)'$")
    public void user_get_response_code(int acccode) throws Throwable {

        System.out.println("Response Code From PET POST API Call: " + acccode);

        int code = obj.get_status_code();

        Assert.assertEquals(code,acccode);
    }


    @And("user verify the dog name {string} in response")
    public void userVerifyTheDogNameInResponse(String name) {

        String responsemessage = obj.receive_message();

        Assert.assertTrue(responsemessage.contains(name));
    }
}
