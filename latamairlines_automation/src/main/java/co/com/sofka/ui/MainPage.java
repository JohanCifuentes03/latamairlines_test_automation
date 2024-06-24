package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class MainPage extends PageObject {
    public static Target INPUT_ORIGIN = Target.
            the("the input origin").
            locatedBy("#txtInputOrigin_field")
            .waitingForNoMoreThan(Duration.ofSeconds(5));

    public static Target FIRST_OPTION = Target.
            the("the first suggestion").
            locatedBy("#lstItem_0 button")
            .waitingForNoMoreThan(Duration.ofSeconds(5));

    public static Target INPUT_DESTINATION = Target.
            the("the input destination").
            locatedBy("#txtInputDestination_field");

    public static Target OPEN_CALENDAR_INPUT = Target.
            the("the open calendar input button").
            locatedBy("#departureDate");

    public static Target OPEN_CALENDAR_INPUT_DESTINATION = Target.
            the("the open calendar destination input button").
            locatedBy("#arrivalDate");

    public static Target MONTH_YEAR_OPTIONS = Target.
            the("the month and year options").
            locatedBy("[data-visible = 'true'] .CalendarMonth_caption strong");

    public static Target ADVANCE_BUTTON = Target.
            the("the advance month button").
            locatedBy("[aria-label = 'Avanza al mes de']");


    public static String buildDynamicXpathForDate(String month, String day) {
        return String.format("//strong[contains(text(), '%s')]/ancestor::div[@class = 'CalendarMonth CalendarMonth_1']//span[text() = '%s']/ancestor::td", month, day);
    }


    public static Target dateTarget(String month, String day) {
        return Target.the("Date in the calendar")
                .locatedBy(buildDynamicXpathForDate(month, day));
    }


}
