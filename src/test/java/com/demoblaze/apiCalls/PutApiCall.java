package com.demoblaze.apiCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class PutApiCall {


    private Response response;

    public void update_pet(String id, String name, String status) {

        response = RestAssured.given().body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"" + name + "\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"" + status + "\"\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when().put("https://petstore.swagger.io/v2/pet");

//        response.prettyPrint();

    }

    public int get_status_code() {

        int respcode = response.getStatusCode();
        return respcode;
    }

    public String receive_message() {

        ResponseBody body = response.body();
//        body.prettyPrint();
        return body.asString();
    }


}
