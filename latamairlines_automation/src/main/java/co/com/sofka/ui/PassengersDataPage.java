package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class PassengersDataPage extends PageObject {



    public static final Target FIRST_NAME_ADULT_INPUT =
            Target.the("The first name input")
                    .locatedBy("[aria-label = 'Ingresa el nombre de pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target LAST_NAME_ADULT_INPUT =
            Target.the("The last name input")
                    .locatedBy("[aria-label = 'Ingresa el apellido de pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target DATE_BIRTH_INPUT =
            Target.the("The date of bith input")
                    .locatedBy("[aria-label = 'Ingresa la fecha de nacimiento de pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target ID_INPUT =
            Target.the("The id input")
                    .locatedBy("[aria-label = 'ingresa el número de documento de pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target EMAIL_INPUT =
            Target.the("The email input")
                    .locatedBy("[aria-label = 'Ingresa el email de pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target PHONE_INPUT =
            Target.the("The phone input")
                    .locatedBy("[aria-label = 'ingresa el número de teléfono de pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target SAVE_USER_DATA_BTN =
            Target.the("The save user data button")
                    .locatedBy("[aria-label = 'Guardar los datos ingresados del pasajero.']")
                    .waitingForNoMoreThan(Duration.ofSeconds(10));

//    // Dynamic because this would be for adult 1 passengerDetails-firstName-ADT_1 and so on
//    public static final String FIRST_NAME_ADULT_INPUT = "#passengerDetails-firstName-ADT_%s";
//    public static final String LAST_NAME_ADULT_INPUT = "#passengerDetails-firstName-ADT_%s";
//    public static final String DATE_BIRTH_ADULT_INPUT = "#passengerInfo-dateOfBirth-ADT_%s";

}
