package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.SeatSelectionPage.NEXT_FLIGHT_BTN;

public class GoNextFlightSeats implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NEXT_FLIGHT_BTN)
        );
    }

    public static GoNextFlightSeats goNextFlightSeats(){
        return Tasks.instrumented(GoNextFlightSeats.class);
    }
}
