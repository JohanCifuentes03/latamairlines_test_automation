package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class SeatSelectionPage extends PageObject {
    public static Target SEAT_OPTIONS =
            Target.the("The light recommended option")
                    .locatedBy("button.Seat__ButtonSeat-sc-1xsdv1h-0.iJHVZh.available")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));
}
