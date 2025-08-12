package com.thetestingacademy.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

  /*  @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Assert.assertEquals("sunita","Sunita");
        System.out.println("End of the program");
    }
*/
    @Test
    public void test_softAssertExample(){
        SoftAssert softAssert =new SoftAssert();

        System.out.println("Strat of the program");
        softAssert.assertEquals("sunita","Sunita");
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
