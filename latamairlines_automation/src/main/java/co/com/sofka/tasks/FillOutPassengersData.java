package co.com.sofka.tasks;

import co.com.sofka.models.PassengerModel;
import co.com.sofka.utils.CreateModel;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.ui.PassengersDataPage.FIRST_NAME_ADULT_INPUT;

public class FillOutPassengersData implements Task {

    private int nPassengers;
    public FillOutPassengersData forNPassengers(int nPassengers){
        this.nPassengers = nPassengers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades namesInput = FIRST_NAME_ADULT_INPUT.resolveAllFor(actor);
        ListOfWebElementFacades lastnamesInput = FIRST_NAME_ADULT_INPUT.resolveAllFor(actor);
        ListOfWebElementFacades datesOfBirthInput = FIRST_NAME_ADULT_INPUT.resolveAllFor(actor);
        ListOfWebElementFacades idsInput = FIRST_NAME_ADULT_INPUT.resolveAllFor(actor);
        ListOfWebElementFacades emailsInput = FIRST_NAME_ADULT_INPUT.resolveAllFor(actor);
        ListOfWebElementFacades phonesInput = FIRST_NAME_ADULT_INPUT.resolveAllFor(actor);
        System.out.println(namesInput);
        System.out.println(lastnamesInput);

        List<PassengerModel> passengerModels = new ArrayList<>();
        for (int i = 0; i < nPassengers; i++) {
            passengerModels.add(CreateModel.createPassengerData());
        }
        System.out.println(passengerModels);

    }


    public static FillOutPassengersData fillOutPassengersData(){
        return Tasks.instrumented(FillOutPassengersData.class);
    }
}
