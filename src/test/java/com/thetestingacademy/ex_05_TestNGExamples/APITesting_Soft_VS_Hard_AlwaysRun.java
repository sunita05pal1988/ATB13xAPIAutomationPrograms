package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting_Soft_VS_Hard_AlwaysRun {

    @Test
    public void login(){
     //might fail
    }
    @Test(dependsOnMethods = "login")
    public void placeorder(){   // hard dependency
        // runs only if login is passed
    }

    @Test(dependsOnMethods = "login", alwaysRun =true)
    public void closeBrowser(){    //soft dependency
        //runs even if login is failed
    }
}
