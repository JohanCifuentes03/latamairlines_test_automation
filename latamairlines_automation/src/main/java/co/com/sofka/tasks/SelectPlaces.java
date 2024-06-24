package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.ui.MainPage.*;
import static co.com.sofka.ui.MainPage.FIRST_OPTION;

public class SelectPlaces implements Task {
    private String origin;
    private String destination;

    public SelectPlaces withOrigin(String origin){
        this.origin = origin;
        return this;
    }

    public SelectPlaces andDestination(String destination){
        this.destination = destination;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(origin).into(INPUT_ORIGIN),
                Click.on(FIRST_OPTION),
                Enter.theValue(destination).into(INPUT_DESTINATION),
                Click.on(FIRST_OPTION)
        );
    }
    public static SelectPlaces selectPlaces(){
        return new SelectPlaces();
    }
}
