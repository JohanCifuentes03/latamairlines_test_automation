package co.com.sofka.utils;

import co.com.sofka.models.PassengerModel;
import net.datafaker.Faker;

public class CreateModel {
    private static final Faker faker = new Faker();
    public static PassengerModel createPassengerData() {
        return new PassengerModel(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.date().birthdayLocalDate(),
                faker.bothify("101#######"),
                faker.internet().emailAddress(),
                faker.bothify(312 + "#######")
                );
    }
}
