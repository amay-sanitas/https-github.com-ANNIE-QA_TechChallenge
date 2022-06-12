package com.demoblaze.step_definitions;

import com.demoblaze.apiCalls.DeleteApiCall;
import com.demoblaze.apiCalls.GetApiCall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DeletePet {

    DeleteApiCall deleteobj = new DeleteApiCall();
    GetApiCall getobj = new GetApiCall();


    @Given("^user call the delete pet request with id '(\\d+)'$")
    public void user_call_the_delete_pet_request_with_id(int id) throws Throwable {

        deleteobj.delete_pet(id);

    }


    @Then("^record is deleted and user get the success response code '(\\d+)'$")
    public void record_is_deleted_and_user_get_the_success_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From Delete API Call: " + respcode);

        int code = deleteobj.get_status_code();

        Assert.assertEquals(respcode, code);


    }

    @Then("^user call the get pet request to validate deletion with id '(\\d+)'$")
    public void user_call_the_get_pet_request_to_validate_deletion_with_id(int id) throws Throwable {

        String idassert = Integer.toString(id);
        getobj.get_pet(id);

        int statuscode = getobj.get_status_code();

        Assert.assertEquals(statuscode, 404);

        String responsemessage = getobj.receive_message();

        Assert.assertFalse(responsemessage.contains(idassert));

    }


}
