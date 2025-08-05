package com.thetestingacademy;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.when;

public class RestAssuredHelloWorld {
    public static void main(String[] args) {

        //https://restful-booker.herokuapp.com/ping
        //

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when()
                .log().all().get().
                then()
                .log().all().statusCode(201);
    }

}
