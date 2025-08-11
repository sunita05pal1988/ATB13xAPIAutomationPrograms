package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {

    //PUT Request
    // get Token
    // get BookingID
    // test_PUT (which will use above two methods)
    // close All things

    @BeforeTest
    public void getToken(){
        System.out.println("Before GET Token");
    }
    @BeforeTest
    public void getBookingID(){
        System.out.println("Before GET BookingId");
    }

    @Test
    public void test_PUT(){
        //token and BookingId
    System.out.println(" PUT Request");
    }

    @AfterTest
    public void test_CloseAllThings(){
        System.out.println(" Close ");
    }
}
