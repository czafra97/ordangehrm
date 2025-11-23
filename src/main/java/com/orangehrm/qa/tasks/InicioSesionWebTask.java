package com.orangehrm.qa.tasks;


import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.orangehrm.qa.userinterfaces.InicioSesionWebPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
@AllArgsConstructor
public class InicioSesionWebTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(InicioSesionWebTask.class);

    private final String usuario;
    private final String password;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(TXT_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(usuario).into(TXT_USUARIO),
                    Enter.theValue(password).into(TXT_CONTRASENA),
                    Click.on(BTN_LOGIN),
                    WaitUntil.the(OBJ_USERAREA, isVisible()).forNoMoreThan(10).seconds()
            );
            LOGGER.info("el usuario ha iniciado sesion correctamente");
        } catch (Exception e) {
            LOGGER.error("el usuario tuvo problemas para iniciar sesion");
            throw new IllegalArgumentException(e);
        }
    }

    public static Performable inicioSesionWeb(String usuario,String password) {
        return Tasks.instrumented(InicioSesionWebTask.class, usuario,password);
    }
}
