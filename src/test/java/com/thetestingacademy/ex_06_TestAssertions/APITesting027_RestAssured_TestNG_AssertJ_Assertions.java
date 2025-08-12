package com.thetestingacademy.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import static org.assertj.core.api.Assertions.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Test
    public void test_POST(){

        String payload = "{\n" +
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
        requestSpecification.contentType(ContentType.JSON);
        byte[] payload_POST;
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        //Get Validate response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //RestAssured - import org.hamcrest.Matchers;
        //Matchers.equalto()

        validatableResponse.body("bookingid",Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Sunita"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Pal"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));

        //Extraction
        // Concept 1 - Normal (TestNG or Assertj) Is Imp

        bookingID = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        //Concept 2 (Jsonpath class) Another mechanism to extract the keys, value by JSON Path

        JsonPath jp = new JsonPath(response.asString());
        String bookingID1 = jp.getString("bookingid");

     //   assertThat(jp.getInt("bookingid")).isEqualTo(4177);
        assertThat(jp.getString("booking.firstname")).isEqualTo("Sunita");
        assertThat(jp.getString("booking.lastname")).isEqualTo("Pal");
        assertThat(jp.getInt("booking.totalprice")).isEqualTo(3000);
        assertThat(jp.getBoolean("booking.depositpaid")).isTrue();

        //TestNG - Extract the details of the firstname, bookingid, lastname from response.
        //TestNG Assertions -75%
        //SoftAssert vs HardAssert (90%)
        //This means that is nay assertion is fails, the remaining statments in that test method will not be executed.

        Assert.assertEquals(firstname,"Sunita");
        Assert.assertEquals(lastname,"Pal");
        Assert.assertNotNull(bookingID);



        //AssertJ 3rd - lib to Assertions - 20%

        assertThat(bookingID).isNotZero().isNotNull().isNotNegative();
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Sunita");
    }
}
