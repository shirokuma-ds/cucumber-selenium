package org.shirokuma.step.yugioh;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.shirokuma.page.yugioh.YugiOhPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class YugiOhSteps {

    public YugiOhSteps(YugiOhPage yugiOhPage) {
        this.yugiOhPage = yugiOhPage;
    }

    private final YugiOhPage yugiOhPage;

    @Given("I open Yugi Oh DB")
    public void iOpenYugiOhDB() {
        yugiOhPage.driver().get("https://db.ygorganization.com");
    }

    @When("I search for card {string}")
    public void iSearchForCardCard(String cardName) {
        yugiOhPage.typeIntoSearchInput(cardName);
    }

    @And("I click for the first result")
    public void iClickForTheFirstResult() {
        yugiOhPage.clickCardEntry(0);
    }

    @Then("I should see the card{string}")
    public void iShouldSeeTheCardCard(String cardName) {
        assertThat(yugiOhPage.getCardName(), equalToIgnoringCase(cardName));
    }
}
