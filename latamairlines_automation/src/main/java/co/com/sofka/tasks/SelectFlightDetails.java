package co.com.sofka.tasks;

import co.com.sofka.models.FlightDetails;
import co.com.sofka.models.Months;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.time.LocalDate;

import static co.com.sofka.ui.MainPage.*;
import static co.com.sofka.utils.RandomUtilities.secureRandom;

public class SelectFlightDetails implements Task {
    private FlightDetails flightDetails;
    public SelectFlightDetails withDetails(FlightDetails flightDetails){
        this.flightDetails = flightDetails;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LocalDate baseDate = LocalDate.now();
        actor.attemptsTo(
                Click.on(OPEN_CALENDAR_INPUT)
        );
        selectDate(actor,
                Months.MONTHS_IN_SPANISH.get(baseDate.getMonth().toString()),
                String.valueOf(baseDate.getDayOfMonth()));

        LocalDate plusNDaysDate = LocalDate.now().plusDays(secureRandom.nextInt(60));
        actor.attemptsTo(
                Click.on(OPEN_CALENDAR_INPUT_DESTINATION)
        );

        selectDate(actor,
                Months.MONTHS_IN_SPANISH.get(plusNDaysDate.getMonth().toString()),
                String.valueOf(plusNDaysDate.getDayOfMonth()));

    }



    private <T extends Actor> void selectDate(T actor, String expectedMonth, String day) {
        String currentMonth;
        for(int i = 0; i <= 8; i++){
            for (int j = 0; j <= 2; j++){
                currentMonth= MONTH_YEAR_OPTIONS
                        .resolveAllFor(actor)
                        .get(j)
                        .getText();
                if (currentMonth.toLowerCase().contains(expectedMonth)){
                    actor.attemptsTo(
                            Click.on(dateTarget(expectedMonth, day))
                    );
                    return;
                }
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
