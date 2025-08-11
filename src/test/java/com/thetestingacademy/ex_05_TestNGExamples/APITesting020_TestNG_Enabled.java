package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class APITesting020_TestNG_Enabled {
    @Test
    public void test01(){
        System.out.println("test");
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test02(){
        System.out.println("test2");
        Assert.assertTrue(true);
    }

    @Test(enabled=true)
    public void test03(){
        System.out.println("test03");
        Assert.assertTrue(true);
    }
}
