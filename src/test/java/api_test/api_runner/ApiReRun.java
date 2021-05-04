package api_test.api_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/apiFailedTests.txt",glue = "api_test/api_stepdefinitions",
        plugin = {"pretty","json:target/apiReport.json","html:target/apiReport.html","rerun:target/apiFailedTests.txt"}
)
public class ApiReRun {
}
