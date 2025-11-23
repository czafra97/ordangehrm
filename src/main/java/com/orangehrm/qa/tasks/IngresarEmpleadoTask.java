package com.orangehrm.qa.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import static com.orangehrm.qa.userinterfaces.EmpleadosPage.*;


@AllArgsConstructor
public class IngresarEmpleadoTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngresarEmpleadoTask.class);
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String id;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String imagePath = System.getProperty("user.dir") + "/src/test/resources/testData/Sofka.png";

        try {
            LOGGER.info("Iniciando tarea ingresar empleado ");
            actor.attemptsTo(
                    Click.on(BTN_PIM),
                    Click.on(BTN_ADD),
                    SendKeys.of(firstName).into(TXT_FIRSTNAME),
                    SendKeys.of(middleName).into(TXT_MIDDLETNAME),
                    SendKeys.of(lastName).into(TXT_LASTNAME),
                    SendKeys.of(Keys.CONTROL + "a").into(TXT_ID),
                    SendKeys.of(Keys.DELETE).into(TXT_ID),
                    SendKeys.of(id).into(TXT_ID),
                    Upload.theFile(Path.of(imagePath)).to(BTN_IMAGEN),
                    Click.on(BTN_SAVE)
            );
            actor.remember("firstName", firstName);
            actor.remember("middleName", middleName);
            actor.remember("lastName", lastName);
            actor.remember("employeeId", id);



        } catch (Exception exception) {
            LOGGER.info("Error al ingresar elempleado " + exception);
        }

    }

    public static IngresarEmpleadoTask ingresarEmpleado(String firstName,String middleName,String lastName,String id) {
        return Tasks.instrumented(IngresarEmpleadoTask.class, firstName,middleName,lastName,id);
    }
}
