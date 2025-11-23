package com.orangehrm.qa.utils;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunnerHrm extends Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunnerHrm.class);
    private Class<CucumberWithSerenity> classValue;
    private CucumberWithSerenity cucumberWithSerenity;

    public RunnerHrm(Class<CucumberWithSerenity> classValue)
            throws IOException, InitializationError {
        this.classValue = classValue;
        cucumberWithSerenity = new CucumberWithSerenity(classValue);
    }

    @Override
    public Description getDescription() {
        return cucumberWithSerenity.getDescription();
    }

    private void runAnnotatedMethods(Class<?> annotation)
            throws IllegalAccessException, InvocationTargetException {
        if (!annotation.isAnnotation()) {
            return;
        }

        Method[] methods = this.classValue.getMethods();

        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation item : annotations) {
                if (item.annotationType().equals(annotation)) {
                    method.invoke(null);
                    break;
                }
            }
        }
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            runAnnotatedMethods(BeforeRunner.class);
            cucumberWithSerenity = new CucumberWithSerenity(classValue);
        } catch (IllegalAccessException
                 | InvocationTargetException
                 | InitializationError e) {
            LOGGER.error(e.getMessage(), e);
        }
        cucumberWithSerenity.run(notifier);
    }
}
