package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class FlightsOptionsPage extends PageObject {
    public static final Target FIRST_FLY_RECOMMENDED_OPTION =
            Target.the("The first fly option")
                    .locatedBy("#WrapperCardFlight0 div.fGajiU")
                    .waitingForNoMoreThan(Duration.ofSeconds(15));
    public static final Target LIGHT_RECOMMENDED_OPTION =
            Target.the("The light recommended option")
                    .locatedBy("#bundle-detail-1-flight-select")
                    .waitingForNoMoreThan(Duration.ofSeconds(15));

    public static final Target CONTINUE_BUTTON =
            Target.the("The continue button")
                    .locatedBy("#button9")
                    .waitingForNoMoreThan(Duration.ofSeconds(15));

}
