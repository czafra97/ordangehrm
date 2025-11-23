package com.orangehrm.qa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmpleadosPage extends PageObject {
    public static final Target BTN_PIM = Target
            .the("Opcion PIM").located(By.xpath("//span[normalize-space()='PIM']"));

    public static final Target BTN_ADD = Target
            .the("Opcion ADD").located(By.xpath("//button[normalize-space()='Add']"));

    public static final Target TXT_FIRSTNAME = Target
            .the("input name").located(By.xpath("//input[@name='firstName']"));

    public static final Target TXT_MIDDLETNAME = Target
            .the("input middlename").located(By.xpath("//input[@name='middleName']"));

    public static final Target TXT_LASTNAME = Target
            .the("input lastName").located(By.xpath("//input[@name='lastName']"));

    public static final Target TXT_ID = Target
            .the("input lastName").located(By.xpath("//label[text()='Employee Id']/../following-sibling::div//input"));

    public static final Target BTN_IMAGEN = Target
            .the("Cargar la imagen").located(By.xpath("//input[@type='file' and contains(@class,'oxd-file-input')]"));

    public static final Target BTN_SAVE = Target
            .the("Boton de guardar formulario").located(By.xpath("//button[normalize-space()='Save']"));

    public static final Target BTN_SEARCH = Target
            .the("Boton de buscar").located(By.xpath("//button[normalize-space()='Search']"));

    public static final Target LBL_NAMEYMIDDLE = Target
            .the("texto de nombre y middle name concatenados").located(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[3]/div"));

}

