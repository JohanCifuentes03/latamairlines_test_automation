package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class PersonalizedTravelPage extends PageObject {
    public static final Target BAGS_CONTINUE_BTN =
            Target.the("The bags continue button")
                    .locatedBy("#BAGS-continue-button")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target PRIORITY_CONTINUE_BTN =
            Target.the("The bags continue button")
                    .locatedBy("#PRIORITY_BOARDING-continue-button")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));


    public static final Target CONFIRM_CART_BTN =
            Target.the("The confirm cart button")
                    .locatedBy("#button-cart-confirm")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    // Dynamic because this would be for adult 1 passengerDetails-firstName-ADT_1 and so on
    public static final String FIRST_NAME_ADULT_INPUT = "#passengerDetails-firstName-ADT_%s";
    public static final String LAST_NAME_ADULT_INPUT = "#passengerDetails-firstName-ADT_%s";
    public static final String DATE_BIRTH_ADULT_INPUT = "#passengerInfo-dateOfBirth-ADT_%s";

}
