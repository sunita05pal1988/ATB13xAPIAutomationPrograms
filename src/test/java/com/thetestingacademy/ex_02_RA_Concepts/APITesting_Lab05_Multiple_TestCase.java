package com.thetestingacademy.ex_02_RA_Concepts;

import io.restassured.RestAssured;

public class APITesting_Lab05_Multiple_TestCase {
    public static void main(String[] args) {

        String pincode = "248002";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then().log().all().statusCode(200);

        pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then().log().all().statusCode(200);

        pincode = "";
        RestAssured
                .given()
                .baseUri("https://api.zippotam.us")
                .baseUri("/IN" + pincode)
                .when()
                .then().log().all().statusCode(200);

    }
}
