package com.marta.teaching.demo.it.stepdef;

import com.marta.teaching.demo.it.domain.Environment;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MoviesStepDefinitions {

    public static WebDriver browser;
    public String urlWhereApplicationIsDeployed = "";

    @Given("^I open the browser$")
    public void loadSystemProperties() {
       // Setup the request destination
        String environment = System.getProperty("environment");
        if(Environment.LOCAL.getValue().equals(environment)) {
            urlWhereApplicationIsDeployed = "http://localhost:5000";
        }else {
            urlWhereApplicationIsDeployed = "elasticbean";
        }
    }

    @Then("^I open the home page and some movies are displayed$")
    public void checkMoviesAreDisplayed() throws IOException{
        Document homePage = Jsoup.connect(urlWhereApplicationIsDeployed + "/home").get();
        int numberMoviesLoaded =homePage.select(".card-title").size();
        Assert.assertTrue(numberMoviesLoaded>19);
    }
}
