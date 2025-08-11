package com.thetestingacademy.ex_05_TestNGExamples;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Groups {

    //reg -> all 3 testcases -3
    //Sanity - sanity run -1
    // smoke - smoke run -1
    @Test(groups = {"reg", "sanity"})
    public void test_sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg","smoke"})
    public void test_smokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }
    @Test(groups = {"reg"})
    public void test_regRun(){
        System.out.println("Regression");
        Assert.assertTrue(true);
    }
}
