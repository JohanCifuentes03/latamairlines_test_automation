package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenMainPage implements Task {
    private String url;
    public OpenMainPage withUrl(String url){
        this.url = url;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static OpenMainPage openMainPage(){
        return new OpenMainPage();
    }
}
