package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDate;

import static co.com.sofka.models.Months.MONTHS_IN_SPANISH;
import static co.com.sofka.ui.MainPage.*;
import static co.com.sofka.ui.MainPage.ADVANCE_BUTTON;

public class SelectDates implements Task {
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    public SelectDates withDepartureDate(LocalDate departureDate){
        this.departureDate = departureDate;
        return this;
    }

    public SelectDates andArrivalDate(LocalDate arrivalDate){
        this.arrivalDate = arrivalDate;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        openCalendar(actor);
        selectDate(actor, departureDate);
        selectDate(actor, arrivalDate);
    }

    private <T extends Actor> void selectDate(T actor, LocalDate date) {
        String expectedMonth = MONTHS_IN_SPANISH.get(date.getMonth().toString().toUpperCase());
        String currentMonth;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                currentMonth = MONTH_YEAR_OPTIONS.resolveAllFor(actor).get(j).getText();
                if (currentMonth.toLowerCase().contains(expectedMonth.toLowerCase())) {
                    actor.attemptsTo(
                            Click.on(dateTarget(expectedMonth, String.valueOf(date.getDayOfMonth())))
                    );
                    return;
                }
            }
            actor.attemptsTo(Click.on(ADVANCE_BUTTON));
        }

        throw new RuntimeException("The expected month " + expectedMonth + " was not found in the calendar.");
    }

    private <T extends Actor> void openCalendar(T actor) {
        actor.attemptsTo(
                Click.on(OPEN_CALENDAR_INPUT)
        );
    }

    public static SelectDates selectDates(){
        return new SelectDates();
    }
}
