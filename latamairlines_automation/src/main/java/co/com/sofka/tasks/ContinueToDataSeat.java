package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.FlightsOptionsPage.CONTINUE_BUTTON;

public class ContinueToDataSeat implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CONTINUE_BUTTON)
        );
    }

    public static ContinueToDataSeat continueToDataSeat(){
        return Tasks.instrumented(ContinueToDataSeat.class);
    }
}
