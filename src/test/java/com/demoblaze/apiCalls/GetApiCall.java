package com.demoblaze.apiCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetApiCall {


    private Response response;

    public void get_pet(int id) {

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/" + id + "");

//        response.prettyPrint();

    }

    public int get_status_code() {

        int respcode = response.getStatusCode();
        return respcode;
    }

    public String receive_message() {

        ResponseBody body = response.body();

        return body.asString();
    }

    public String get_pet_by_status(String status) {

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=" + status + "");

        return response.prettyPrint();

    }


}
