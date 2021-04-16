package api_test.api_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/api_feature",
        glue = "api_test/api_stepdefinitions",
        tags = "@smoke",
        dryRun = false,
        plugin={"pretty","json:target/apiReport.json","html:target/apiReport.html"})
public class ApiRunner {
}
