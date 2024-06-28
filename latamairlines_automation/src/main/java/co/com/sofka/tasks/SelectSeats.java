package co.com.sofka.tasks;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


import static co.com.sofka.ui.SeatSelectionPage.SEAT_OPTIONS;



public class SelectSeats implements Task {
    private int nPassengers;
    public SelectSeats forNPassengers(int nPassengers){
        this.nPassengers = nPassengers;
        return this;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades seats = SEAT_OPTIONS.resolveAllFor(actor);
        for (int i = 0; i < nPassengers; i++) {
            actor.attemptsTo(
                    Click.on(seats.get(i))
            );
        }
    }


    public static SelectSeats selectSeats(){
        return Tasks.instrumented(SelectSeats.class);
    }
}
