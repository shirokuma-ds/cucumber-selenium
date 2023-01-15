package org.shirokuma.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.shirokuma.page.WikipediaPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class WikipediaSteps {

    public WikipediaSteps(WikipediaPage wikipediaPage) {
        this.wikipediaPage = wikipediaPage;
    }

    private WikipediaPage wikipediaPage;
    @Given("I open Wikipedia")
    public void iOpenWikipedia() {
        wikipediaPage.driver().get("https://en.wikipedia.org");
    }

    @When("I search {string}")
    public void iSearchFruit(String fruit) {
        wikipediaPage.typeIntoSearchInput(fruit);
        wikipediaPage.clickSearchButton();
    }

    @Then("I should see {string}")
    public void iShouldSeeFruit(String fruit) {
        assertThat(wikipediaPage.getPageTitle(), equalToIgnoringCase(fruit));
    }
}
