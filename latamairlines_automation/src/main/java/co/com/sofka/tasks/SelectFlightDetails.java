package co.com.sofka.tasks;

import co.com.sofka.models.FlightDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.ui.MainPage.*;

public class SelectFlightDetails implements Task {
    private FlightDetails flightDetails;
    public SelectFlightDetails withDetails(FlightDetails flightDetails){
        this.flightDetails = flightDetails;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(flightDetails.getFrom()).into(INPUT_ORIGIN),
                Click.on(FIRST_OPTION),
                Enter.theValue(flightDetails.getTo()).into(INPUT_DESTINATION),
                Click.on(FIRST_OPTION)
        );
    }
    public static SelectFlightDetails selectFlightDetails(){
        return new SelectFlightDetails();
    }
}
