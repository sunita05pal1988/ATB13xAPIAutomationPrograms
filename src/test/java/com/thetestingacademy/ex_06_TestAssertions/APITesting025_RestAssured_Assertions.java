package com.thetestingacademy.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class APITesting025_RestAssured_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Test
    public void test_createBooking_POST(){

        //payload
        // given - setting up body, url, base path, uri
        //when - making the req
        //then - extraction

        String request_payload = "{\n" +
                "    \"firstname\" : \"Sunita\",\n" +
                "    \"lastname\" : \"Pal\",\n" +
                "    \"totalprice\" : 3000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-08-15\",\n" +
                "        \"checkout\" : \"2025-08-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");

        //header information
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(request_payload).log().all();

        response = requestSpecification.when().log().all().post();

        //Get Validate response to perform validation

        validatableResponse = response.then().log().all();

        //RestAssured .Assertions
        validatableResponse.statusCode(200);

        //BookingId !=Null, firstname ==Sunita
        //Extract the response body and do it

      //  System.out.println(response.asString());
        //validatebaleResponse.statusCode(200);
validatableResponse.body("bookingid",Matchers.notNullValue());
validatableResponse.body("booking.firstname",Matchers.equalTo("Sunita"));
validatableResponse.body("booking.lastname",Matchers.equalTo("Pal"));
validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
validatableResponse.body("booking.totalprice",Matchers.equalTo(3000));


    }

}
