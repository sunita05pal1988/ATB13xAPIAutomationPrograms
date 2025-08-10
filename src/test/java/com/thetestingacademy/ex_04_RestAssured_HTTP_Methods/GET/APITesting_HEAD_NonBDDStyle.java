package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_HEAD_NonBDDStyle {
    RequestSpecification r;  // pre request - given part 3
    Response response; // making the request - when
    ValidatableResponse vr;  // post request - then
    String pincode;

    @Test
    public void test_Head_NonBDD(){
        pincode = "560048";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //part 2

        response = r.when().log().all().head();
        System.out.println(response.asString());

        //part 3
        vr= response.then().log().all();
        vr.statusCode(200);
    }

    @Test
    public void test_HEAD_NonBDD_Negative(){
        pincode = "@";
        //Given

        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //When
        response = r.when().log().all().head();
        System.out.println(response.asString());

        //then
        vr=response.then().log().all();
        vr.statusCode(404);



    }

}
