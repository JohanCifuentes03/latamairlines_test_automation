package co.com.sofka.stepdefinitions;


import co.com.sofka.models.FlightDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;

import static co.com.sofka.UrlConstant.MAIN_PAGE_URL;
import static co.com.sofka.tasks.ConfirmSearch.confirmSearch;
import static co.com.sofka.tasks.ConfirmSeats.confirmSeats;
import static co.com.sofka.tasks.ContinueToDataSeat.continueToDataSeat;
import static co.com.sofka.tasks.GoNextFlightSeats.goNextFlightSeats;
import static co.com.sofka.tasks.OpenMainPage.openMainPage;
import static co.com.sofka.tasks.SelectDates.selectDates;
import static co.com.sofka.tasks.SelectFlightPreferences.selectFlightPreferences;
import static co.com.sofka.tasks.SelectPassengers.selectPassengers;
import static co.com.sofka.tasks.SelectPlaces.selectPlaces;
import static co.com.sofka.tasks.SelectSeats.selectSeats;
import static co.com.sofka.tasks.SwitchToNewWindow.changeWindow;
import static co.com.sofka.utils.RandomUtilities.secureRandom;


public class ReserveFlySD extends WebSetup {
    private FlightDetails flightDetails;

    @Given("the user is on the LATAM Airlines platform using {string}")
    public void theUserIsOnTheLATAMAirlinesPlatformUsing(String webDriver) {
        actorSetupTheBrowser(webDriver);
        actor.wasAbleTo(
                openMainPage().withUrl(MAIN_PAGE_URL)
        );

    }

    @When("the user reserves a flight with following details")
    public void theUserReservesAFlightWithFollowingDetails(List<FlightDetails> flightDetailsList) {
        // In this context, people can reserve a fly from 0, 8 months of anticipation,
        // but back flight generally is 1 week after or less
        flightDetails = flightDetailsList.get(0);
        LocalDate flightDate = LocalDate.now()
                .plusMonths(secureRandom.nextInt(0, 9) )
                .plusDays(secureRandom.nextInt(1,30 ));

        LocalDate backFlightDate = flightDate
                .plusDays(secureRandom.nextInt(1,8 ));

        actor.attemptsTo(
                selectPlaces().withOrigin(flightDetails.getFrom()).andDestination(flightDetails.getTo()),
                selectDates()
                        .withDepartureDate(flightDate)
                        .andArrivalDate(backFlightDate),
                selectPassengers().withNAdults(flightDetails.getnAdults()).andNChildren(flightDetails.getnChildren()),
                confirmSearch()
        );
    }

    @When("confirms the preferences")
    public void confirmsThePreferences() {
        int totalPassengers = flightDetails.getnAdults() + flightDetails.getnChildren();
        actor.attemptsTo(
                changeWindow(),
                selectFlightPreferences(), // outbound flight
                selectFlightPreferences(), // back flight
                continueToDataSeat(),
                selectSeats().forNPassengers(totalPassengers), // outbound flight
                goNextFlightSeats(),
                selectSeats().forNPassengers(totalPassengers), // back flight
                confirmSeats()
        );
    }

    @Then("the user should see a confirmation message")
    public void theUserShouldSeeAConfirmationMessage() {

    }


}
