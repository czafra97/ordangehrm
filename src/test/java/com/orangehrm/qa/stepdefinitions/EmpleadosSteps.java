package com.orangehrm.qa.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;


import static com.orangehrm.qa.questions.EmpleadoConsultadoQuestion.empleadoConsultado;
import static com.orangehrm.qa.tasks.ConsultarEmpleadoTask.consultarEmpleado;
import static com.orangehrm.qa.tasks.IngresarEmpleadoTask.ingresarEmpleado;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmpleadosSteps {

    @Cuando("el usuario ingresa a crear un empleado con {string} {string} {string} y {string}")
    public void elUsuarioIngresaACrearUnEmpleadoConFirstNameMiddleNameLastNameYId(String firstName,String middleName,String lastName,String id) {
        theActorInTheSpotlight().attemptsTo(ingresarEmpleado(firstName,middleName,lastName,id));
    }

    @Entonces("el empleado es consultado para validar que si fue creado {string}")
    public void elEmpleadoEsConsultadoParaValidarQueSiFueCreadoId(String id) {
        theActorInTheSpotlight().attemptsTo(consultarEmpleado(id));
        theActorInTheSpotlight().should(
                seeThat(
                        empleadoConsultado()
                )
        );
    }
}
