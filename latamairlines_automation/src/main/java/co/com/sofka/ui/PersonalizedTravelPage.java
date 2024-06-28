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


}
