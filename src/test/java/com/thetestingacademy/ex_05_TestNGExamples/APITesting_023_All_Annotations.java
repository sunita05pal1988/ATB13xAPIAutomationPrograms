package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.*;

public class APITesting_023_All_Annotations {

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void BeforeMethods(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void test(){
        System.out.println("Test");
    }

    @AfterMethod
    public void AfterMethods(){
        System.out.println("AfterMethod");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }


}
