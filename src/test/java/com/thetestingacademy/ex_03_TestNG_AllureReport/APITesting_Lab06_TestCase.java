package com.thetestingacademy.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {

    String pincode;
    @Test
    //valid pincode = 110001
    public void test_tc1_pincode_valid(){
       pincode = "110001";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then().log().all().statusCode(200);
    }

    @Test
    //$#%^##  special character
    public void test_tc2_pincoce_invalid(){
        pincode = "#$";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then().log().all().statusCode(200);
    }

    @Test
    //""  blank pincode
    public void test_tc3_pincode_invalid(){
            pincode = "";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then().log().all().statusCode(200);
    }
}
