package com.orangehrm.qa.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.orangehrm.qa.userinterfaces.EmpleadosPage.*;
@AllArgsConstructor
public class ConsultarEmpleadoTask implements Task {

        private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarEmpleadoTask.class);

        private final String id;

        @Override
        public <T extends Actor > void performAs(T actor) {

            try {
                LOGGER.info("Iniciando la busqueda del empleado ");
                actor.attemptsTo(
                        Click.on(BTN_PIM),
                        SendKeys.of(id).into(TXT_ID),
                        Click.on(BTN_SEARCH)
                );
                Serenity.takeScreenshot();



            } catch (Exception exception) {
                LOGGER.info("Error al ingresar elempleado " + exception);
            }

        }

        public static ConsultarEmpleadoTask consultarEmpleado(String id) {
            return Tasks.instrumented(ConsultarEmpleadoTask.class,id);
        }
}
