package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.SeatSelectionPage.CONFIRM_CONTINUE_BTN;

public class ConfirmSeats implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CONFIRM_CONTINUE_BTN)
        );
    }

    public static ConfirmSeats confirmSeats(){
        return Tasks.instrumented(ConfirmSeats.class);
    }
}
