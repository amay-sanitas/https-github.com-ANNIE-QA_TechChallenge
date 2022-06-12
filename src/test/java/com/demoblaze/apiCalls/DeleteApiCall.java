package com.demoblaze.apiCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteApiCall {


    private Response response;

    public void delete_pet(int id) {

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when().delete("https://petstore.swagger.io/v2/pet/" + id + "");

//        response.prettyPrint();

    }

    public int get_status_code() {

        int respcode = response.getStatusCode();
        return respcode;
    }


}
