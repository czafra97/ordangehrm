package com.orangehrm.qa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionWebPage extends PageObject {

    public static final Target TXT_USUARIO = Target
            .the("input usuario").located(By.xpath("//input[@name='username']"));
    public static final Target TXT_CONTRASENA = Target
            .the("input contraseña").located(By.xpath("//input[@name='password']"));
    public static final Target BTN_LOGIN = Target
            .the("boton de iniciar sesion").located(By.xpath("//button[@type='submit']"));
    public static final Target OBJ_USERAREA = Target
            .the("objeto del usuario logueado").located(By.xpath("//div[contains(@class,'oxd-topbar-header-userarea')]"));
}
