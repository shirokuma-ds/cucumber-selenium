package org.shirokuma.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.shirokuma.page.BulbapediaPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class BulbapediaSteps {

    public BulbapediaSteps(BulbapediaPage bulbapediaPage) {
        this.bulbapediaPage = bulbapediaPage;
    }

    private BulbapediaPage bulbapediaPage;

    @Given("I open Bulbapedia")
    public void iOpenBulbapedia() {
        bulbapediaPage.driver().get("https://bulbapedia.bulbagarden.net");
    }

    @When("I search a {string}")
    public void iSearchAPokemon(String keyword) {
        bulbapediaPage.typeIntoSearchInput(keyword);
        bulbapediaPage.clickSearchButton();
    }

    @Then("I should see the pokemon {string}")
    public void iShouldSeeThePokemonPokemon(String keyword) {
       assertThat(bulbapediaPage.getPokemonName(), equalToIgnoringCase(keyword));
    }
}
