package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class APITesting019_TestNG_Parameter {

    @Parameters("browser")
    @Test
        public void demo1(String value){
        System.out.println("Hi I am demo");
        System.out.println("You are running this param");

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox");
        }

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome!");
        }
    }
}
