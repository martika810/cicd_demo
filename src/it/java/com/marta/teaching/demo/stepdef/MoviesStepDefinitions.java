package com.marta.teaching.demo.stepdef;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MoviesStepDefinitions {

    public static WebDriver browser;

    @Given("^I open the browser$")
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver","./chromedriver");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Given("^I have opened the scrape page$")
    public void openScrapePage() {
        browser.get("http://localhost:5000/scrape");
    }

    @And("^The inprogress message was successfully displayed$")
    public void checkInProgressPageIsDisplayed() {
        String inProgressMessage = browser.findElement(By.cssSelector(".alert")).getText();
        Assert.assertEquals(inProgressMessage,"In progress!");
    }

    @When("^I open the home page$")
    public void openHomePage() {
        browser.get("http://localhost:5000/home");
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until( element -> element.findElement(By.cssSelector(".card-body")));
        // Add waiting here for the page to load
    }

    @Then("^some movies are displayed$")
    public void checkMoviesAreDisplayed() {
        int numberMoviesLoaded = browser.findElements(By.cssSelector(".card-title")).size();
        Assert.assertTrue(numberMoviesLoaded>19);
    }

    @Then("^Close the browser$")
    public void closeBrowser() {
        browser.quit();
    }
}
