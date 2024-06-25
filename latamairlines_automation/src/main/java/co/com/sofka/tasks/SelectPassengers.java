package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.MainPage.*;

public class SelectPassengers implements Task {
    private int nAdults;
    private int nChildren;

    public SelectPassengers withNAdults(int nAdults){
        this.nAdults = nAdults;
        return this;
    }

    public SelectPassengers andNChildren(int nChildren){
        this.nChildren = nChildren;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        openPassengersAddOptions(actor);
        selectNAdults(actor);
        selectNChildren(actor);
    }


    private <T extends Actor> void openPassengersAddOptions(T actor) {
        actor.attemptsTo(Click.on(ADD_PASSENGERS_BTN));
    }

    private <T extends Actor> void selectNAdults(T actor) {
        for (int i = 0; i < nAdults - 1; i++){
            actor.attemptsTo(
                    Click.on(ADD_ADULTS_BTN)
            );
        }
    }

    private <T extends Actor> void selectNChildren(T actor) {
        for (int i = 0; i < nChildren ; i++){
            actor.attemptsTo(
                    Click.on(ADD_CHILDREN_BTN)
            );
        }
    }



    public static SelectPassengers selectPassengers(){
        return new SelectPassengers();
    }
}
