package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.PersonalizedTravelPage.*;

public class ContinueBagsAndPriority implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BAGS_CONTINUE_BTN),
                Click.on(PRIORITY_CONTINUE_BTN),
                Click.on(CONFIRM_CART_BTN)
        );
    }

    public static ContinueBagsAndPriority continueBagsAndPriority(){
        return Tasks.instrumented(ContinueBagsAndPriority.class);
    }
}
