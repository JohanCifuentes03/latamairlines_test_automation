package co.com.sofka.tasks;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import static co.com.sofka.ui.SeatSelectionPage.CABINS_GROUP;
import static co.com.sofka.ui.SeatSelectionPage.SEAT_OPTIONS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectSeats implements Task {
    private int nPassengers;
    public SelectSeats forNPassengers(int nPassengers){
        this.nPassengers = nPassengers;
        return this;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(CABINS_GROUP, isVisible()).forNoMoreThan(15).seconds());
        String pageTitle = BrowseTheWeb.as(actor).getTitle();
        System.out.println("==========Page title==========: " + pageTitle);
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
