package co.com.sofka.stepdefinitions;


import co.com.sofka.models.FlightDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;

import static co.com.sofka.UrlConstant.MAIN_PAGE_URL;
import static co.com.sofka.tasks.ConfirmSearch.confirmSearch;
import static co.com.sofka.tasks.OpenMainPage.openMainPage;
import static co.com.sofka.tasks.SelectDates.selectDates;
import static co.com.sofka.tasks.SelectPassengers.selectPassengers;
import static co.com.sofka.tasks.SelectPlaces.selectPlaces;
import static co.com.sofka.utils.RandomUtilities.secureRandom;


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
        LocalDate baseDate = LocalDate.now();
        actor.attemptsTo(
                selectPlaces().withOrigin(flightDetails.getFrom()).andDestination(flightDetails.getTo()),
                selectDates().withDepartureDate(baseDate.plusDays(secureRandom.nextInt(3, 5))).andArrivalDate(baseDate
                        .plusMonths(secureRandom.nextInt(5))
                        .plusDays(secureRandom.nextInt(4, 29))),
                selectPassengers().withNAdults(flightDetails.getnAdults()).andNChildren(flightDetails.getnChildren()),
                confirmSearch()
        );
    }

    @When("confirms the preferences")
    public void confirmsThePreferences() {

    }

    @Then("the user should see a confirmation message")
    public void theUserShouldSeeAConfirmationMessage() {

    }


}
