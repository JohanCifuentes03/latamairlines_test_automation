package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class SeatSelectionPage extends PageObject {
    public static final Target CABINS_GROUP =
            Target.the("The cabins group")
                    .locatedBy("#cabins-group")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target SEAT_OPTIONS =
            Target.the("The available seats")
                    .locatedBy("button.available")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));


}
