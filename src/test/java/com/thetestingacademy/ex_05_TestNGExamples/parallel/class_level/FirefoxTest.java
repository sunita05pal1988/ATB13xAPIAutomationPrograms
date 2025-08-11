package com.thetestingacademy.ex_05_TestNGExamples.parallel.class_level;

import org.testng.annotations.Test;

public class FirefoxTest {

        @Test
        public void test_firefox(){
            System.out.println("firefox 1");
            System.out.println(Thread.currentThread().getId());
        }
}
