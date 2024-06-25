package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.MainPage.SEARCH_BTN;

public class ConfirmSearch implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SEARCH_BTN));
    }

    public static ConfirmSearch confirmSearch(){
        return new ConfirmSearch();
    }
}
