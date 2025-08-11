package com.thetestingacademy.ex_05_TestNGExamples.parallel.class_level;

import org.testng.annotations.Test;

public class ChromeTest {
    @Test
    public void test_chrome(){
        System.out.println("Chrome 1");
        System.out.println(Thread.currentThread().getId());
    }

}
