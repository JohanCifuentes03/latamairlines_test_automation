package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.FlightsOptionsPage.FIRST_FLY_RECOMMENDED_OPTION;
import static co.com.sofka.ui.FlightsOptionsPage.LIGHT_RECOMMENDED_OPTION;

public class SelectFlightPreferences implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FIRST_FLY_RECOMMENDED_OPTION),
                Click.on(LIGHT_RECOMMENDED_OPTION)
        );
    }

    public static SelectFlightPreferences selectFlightPreferences(){
        return Tasks.instrumented(SelectFlightPreferences.class);
    }
}
