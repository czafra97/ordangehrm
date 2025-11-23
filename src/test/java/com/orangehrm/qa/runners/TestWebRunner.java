package com.orangehrm.qa.runners;

import com.orangehrm.qa.utils.BeforeRunner;
import com.orangehrm.qa.utils.RunnerHrm;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(RunnerHrm.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.orangehrm.qa.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@RegistroEmpleado"
)

public class TestWebRunner {


    @BeforeRunner
    public static void test() throws Exception {
    }
}
