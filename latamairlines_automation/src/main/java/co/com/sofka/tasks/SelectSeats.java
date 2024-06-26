package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectSeats implements Task {
    private int nAdults;
    private int nChildren;

    @Override
    public <T extends Actor> void performAs(T actor) {

    }


    public static SelectSeats selectSeats(){
        return Tasks.instrumented(SelectSeats.class);
    }
}
