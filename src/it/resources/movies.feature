Feature: Open movie home page

    Scenario: Demostrating how our page return movies
        Given I open the browser
        Given I have opened the scrape page
        And The inprogress message was successfully displayed
        When I open the home page
        Then some movies are displayed
        Then Close the browser
