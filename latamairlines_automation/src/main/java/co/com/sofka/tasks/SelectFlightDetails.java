package co.com.sofka.tasks;

import co.com.sofka.models.FlightDetails;
import co.com.sofka.models.Months;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.time.LocalDate;

import static co.com.sofka.ui.MainPage.*;

public class SelectFlightDetails implements Task {
    private FlightDetails flightDetails;
    public SelectFlightDetails withDetails(FlightDetails flightDetails){
        this.flightDetails = flightDetails;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        selectOriginAndDestination(actor);
        selectDate(actor, Months.MONTHS_IN_SPANISH.get(LocalDate.now().getMonth().toString()));
    }

    private <T extends Actor> void selectOriginAndDestination(T actor) {
        actor.attemptsTo(
                Enter.theValue(flightDetails.getFrom()).into(INPUT_ORIGIN),
                Click.on(FIRST_OPTION),
                Enter.theValue(flightDetails.getTo()).into(INPUT_DESTINATION),
                Click.on(FIRST_OPTION),
                Click.on(OPEN_CALENDAR_INPUT)
        );
    }

    private <T extends Actor> void selectDate(T actor, String expectedMonth) {
        String currentMonth;
        for(int i = 0; i <= 8; i++){
            for (int j = 0; j <= 2; j++){
                currentMonth= MONTH_YEAR_OPTIONS
                        .resolveAllFor(actor)
                        .get(j)
                        .getText();
                System.out.println(currentMonth.toLowerCase());
                System.out.println(expectedMonth);
                System.out.println(currentMonth.toLowerCase().contains(expectedMonth));
            }
            actor.attemptsTo(
                    Click.on(ADVANCE_BUTTON)
            );
        }

    }

    public static SelectFlightDetails selectFlightDetails(){
        return new SelectFlightDetails();
    }
}
