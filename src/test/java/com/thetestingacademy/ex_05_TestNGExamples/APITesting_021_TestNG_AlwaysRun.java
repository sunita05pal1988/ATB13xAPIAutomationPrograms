package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_021_TestNG_AlwaysRun {

    public void test_new_register(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun =true)
    public void test_loginPage(){
        Assert.assertTrue(true);
    }

    public void test_normal(){
        Assert.assertTrue(true);
    }
}
