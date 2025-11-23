package com.orangehrm.qa.stepdefinitions;

import com.orangehrm.qa.utils.ConfiguradorDriverUtil;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static com.orangehrm.qa.tasks.InicioSesionWebTask.inicioSesionWeb;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginPortalSteps {
    @Before("@Web")
    public void config() {
        ConfiguradorDriverUtil configuradorDriver = new ConfiguradorDriverUtil();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("cliente").can(BrowseTheWeb.with(configuradorDriver.newDriver()));
    }

    @Dado("que el usuario ingresa al portal hrm")
    public void queElUsuarioIngresaAlPortal() {
                OnStage.theActorCalled("clinte").wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @Cuando("el usuario inicie sesion con usuario {string} y passowrd {string}")
    public void elUsuarioInicieSesionConUsuarioYPassowrd(String usuario,String password) {
        theActorInTheSpotlight().attemptsTo(
                inicioSesionWeb(usuario,password)
        );
    }
}
