package com.thetestingacademy.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting_Lab02_RA {

    //Gherkins Syntax
    //Given() -- Pre Req. URL, Headers, Auth Body....
    //When() -- HTTP method? - GET/POST/PUT/PATCH, DELETE.....
    //Then() -- Validation -> 200 ok, firstname  == PRAMOD


    //Full URL - https://api.zippopotam.us/IN/248001
    //base URI - https://api.zippopotam.us/IN/248001
    // bath Path - /IN/248001

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pincode!");
        String pincode = sc.next();

        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
