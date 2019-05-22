package com.marta.teaching.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/it/resources", glue = "com.marta.teaching.demo.stepdef")
public class RunCucumberApplicationTest {

}
