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
    public void setupBrowser() {
       // Setup the request destination
        String environment = System.getProperty("environment");
        if(Environment.LOCAL.getValue().equals(environment)) {
            urlWhereApplicationIsDeployed = "http://localhost:5001";
        }else {
            urlWhereApplicationIsDeployed = "elasticbean";
        }

    }

    @Given("^I have opened the scrape page$")
    public void openScrapePage() {
       // Jsoup.connect(urlWhereApplicationIsDeployed + "/scrape").get();
       // browser.get(urlWhereApplicationIsDeployed + "/scrape");
    }

    @And("^The inprogress message was successfully displayed$")
    public void checkInProgressPageIsDisplayed() throws IOException {
        Document inProgressPage = Jsoup.connect(urlWhereApplicationIsDeployed + "/scrape").get();
        String inProgressMessage = inProgressPage.select(".alert").text();
        Assert.assertEquals(inProgressMessage,"In progress!");
    }

    @When("^I open the home page$")
    public void openHomePage() throws IOException{
//        Document homePage = Jsoup.connect(urlWhereApplicationIsDeployed + "/home").get();
//        WebDriverWait wait = new WebDriverWait(browser, 10);
//        wait.until( element -> element.findElement(By.cssSelector(".card-body")));
        // Add waiting here for the page to load
    }

    @Then("^I open the home page and some movies are displayed$")
    public void checkMoviesAreDisplayed() throws IOException{
        Document homePage = Jsoup.connect(urlWhereApplicationIsDeployed + "/home").get();
        int numberMoviesLoaded =homePage.select(".card-title").size();
        Assert.assertTrue(numberMoviesLoaded>19);
    }

    @Then("^Close the browser$")
    public void closeBrowser() {

        //browser.quit();
    }
}
