package co.com.sofka.stepdefinitions;


import co.com.sofka.models.FlightDetails;
import co.com.sofka.tasks.SelectFlightDetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static co.com.sofka.UrlConstant.MAIN_PAGE_URL;
import static co.com.sofka.tasks.OpenMainPage.openMainPage;
import static co.com.sofka.tasks.SelectFlightDetails.selectFlightDetails;


public class ReserveFlySD extends WebSetup {

    @Given("the user is on the LATAM Airlines platform using {string}")
    public void theUserIsOnTheLATAMAirlinesPlatformUsing(String webDriver) {
        actorSetupTheBrowser(webDriver);
        actor.wasAbleTo(
                openMainPage().withUrl(MAIN_PAGE_URL)
        );

    }

    @When("the user reserves a flight with following details")
    public void theUserReservesAFlightWithFollowingDetails(List<FlightDetails> flightDetailsList) {
        FlightDetails flightDetails = flightDetailsList.get(0);
        actor.attemptsTo(
                selectFlightDetails().withDetails(flightDetails)
        );
    }

    @When("confirms the preferences")
    public void confirmsThePreferences() {

    }

    @Then("the user should see a confirmation message")
    public void theUserShouldSeeAConfirmationMessage() {

    }


}
