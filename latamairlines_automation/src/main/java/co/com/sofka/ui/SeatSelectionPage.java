package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class SeatSelectionPage extends PageObject {

    public static final Target SEAT_OPTIONS =
            Target.the("The available seats")
                    .located(By.cssSelector("button.available"))
                    .waitingForNoMoreThan(Duration.ofSeconds(20));

    public static final Target NEXT_FLIGHT_BTN =
            Target.the("The next flight button")
                    .located(By.cssSelector("#btn-next-flight"))
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target CONFIRM_CONTINUE_BTN =
            Target.the("The confirm and continue button")
                    .located(By.cssSelector("#btn-confirm-and-continue"))
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

}
