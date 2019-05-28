package com.marta.teaching.demo.it;

import com.marta.teaching.demo.DemoApplication;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.marta.teaching.demo.it.stepdef")
public class RunCucumberApplicationIT {

}
