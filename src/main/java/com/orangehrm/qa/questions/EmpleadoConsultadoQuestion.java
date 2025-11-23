package com.orangehrm.qa.questions;

import com.orangehrm.qa.userinterfaces.EmpleadosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class EmpleadoConsultadoQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String firstName = actor.recall("firstName");
        String middleName = actor.recall("middleName");

        String nombreEsprado = firstName + " " + middleName;
        String actualFullName = Text.of(EmpleadosPage.LBL_NAMEYMIDDLE).answeredBy(actor).toString();

        return  actualFullName.equals(nombreEsprado);


    }

    @Override
    public String getSubject() {
        return String.format("Validar que el empleado es consultado y sus nombres son iguales");

    }


    public static EmpleadoConsultadoQuestion empleadoConsultado() {
        return new EmpleadoConsultadoQuestion();
    }
}
