package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDDStyle_Create_Token(){
        //URL - https://restful-booker.herokuapp.com/auth
        //PAYLOAD -{
        //    "username" : "admin",
        //    "password" : "password123"
        //}
        //Header - Content-Type : application/json
        //Auth  - NA
        //Cookie - NA
        //Validate- 200 ok
        //Body Response - Token is generated or not.

        String payload = "{\n" +
                " \"username\" : \"admin\",\n" +
                " \"password\": \"password123\"\n" +
                "}";

        System.out.println("----------Part 1------------------------");

        //Part 1 - Pre - Condtion - Preparing Request - URL, Headers, Auth...
        r  = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        System.out.println("-----------Part 2 ----------------------");
        //Making HTTP request -> Part 2
        response= r.when().log().all().post();

        System.out.println("----------------Part 3----------------");
       //Verification Part - > Part 3
       vr=response.then().log().all();
       vr.statusCode(200);


     //  vr.statusCode(200).body("token", notNullValue()).body("token",)
    }


}
