package ui_test.ui_runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/uiFailedTests.txt",
        glue = "ui_test/ui_stepdefinitions",
        tags = "@regression",
        dryRun = false,
        plugin={"pretty","json:target/uiReport.json","html:target/uiReport.html","rerun:target/uiFailedTests.txt"})
public class UiReRun {
}
