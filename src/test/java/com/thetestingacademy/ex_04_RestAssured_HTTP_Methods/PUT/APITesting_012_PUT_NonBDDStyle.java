package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_012_PUT_NonBDDStyle {
    //PUT
    // token , bookingID - A
    //public void get_token(){}
    //public void get_booking_id(){}

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd(){
        String bookingid ="209";
        String token = "f242c1da8bc4100";
        String payload = "{\n" +
                "    \"firstname\" : \"test\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" +bookingid);
        r.contentType(ContentType.JSON);
       // r.header("Cookie", "token="+token);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().put();
        vr = response.then().log().all();
        vr.statusCode(200);
// we are not verified the response, we have only verified the statuscode.


    }



}
