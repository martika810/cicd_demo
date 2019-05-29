package com.marta.teaching.demo.it.stepdef;

import com.marta.teaching.demo.it.domain.Environment;
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
    public String urlWhereApplicationIsDeployed = "";



    @Given("^I open the browser$")
    public void setupBrowser() {
        String webdriverFileLocation = System.getProperty("webdrive.file.location");
        System.setProperty("webdriver.chrome.driver", webdriverFileLocation);
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
        browser.get(urlWhereApplicationIsDeployed + "/scrape");
    }

    @And("^The inprogress message was successfully displayed$")
    public void checkInProgressPageIsDisplayed() {
        String inProgressMessage = browser.findElement(By.cssSelector(".alert")).getText();
        Assert.assertEquals(inProgressMessage,"In progress!");
    }

    @When("^I open the home page$")
    public void openHomePage() {
        browser.get(urlWhereApplicationIsDeployed + "/home");
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
