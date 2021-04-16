package database_test.database_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/database_feature",
        glue = "database_test/database_stepdefinitions",
        tags = "@hrTest",
        dryRun = false,
        plugin={"pretty","json:target/databaseReport.json","html:target/databaseReport.html"})
public class DatabaseRunner {
}
