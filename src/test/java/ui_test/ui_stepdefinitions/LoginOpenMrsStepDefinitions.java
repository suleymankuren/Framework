package ui_test.ui_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_test.page.LoginOpenMrsPage;
import utils.Driver;
import utils.PropertyReader;

public class LoginOpenMrsStepDefinitions {

    WebDriver driver=Driver.driver();
    LoginOpenMrsPage loginOpenMrsPage=new LoginOpenMrsPage(driver);

    // Negative Login Steps
    @Given("User navigated to openMRS login page with the link {string}")
    public void user_navigated_to_open_mrs_login_page_with_the_link(String url) {
        driver.get(url);
    }

    @When("User uses provides {string} and {string} to log in")
    public void user_uses_provides_and_and_to_log_in(String username, String password) {
        loginOpenMrsPage.userName.sendKeys(username);
        loginOpenMrsPage.passWord.sendKeys(password);
        loginOpenMrsPage.locatioN.click();
        loginOpenMrsPage.loginButton.click();
    }

    @Then("User has {string} message")
    public void user_has(String errorMessage) {
        String actualErrorMessage=loginOpenMrsPage.error.getText().trim();
        Assert.assertEquals(errorMessage,actualErrorMessage);
    }

    // Positive Login Steps
    @When("User navigates to open Mrs home page")
    public void user_navigates_to_open_mrs_home_page() throws InterruptedException {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        System.out.println("Navigate to open MRS home page");
    }

    @When("User logs in with username and password")
    public void user_logs_in_with_username_and_password() {

        loginOpenMrsPage.userName.sendKeys(PropertyReader.uiPropertyReaderByKey("username"));
        loginOpenMrsPage.passWord.sendKeys(PropertyReader.uiPropertyReaderByKey("password"));
        loginOpenMrsPage.locatioN.click();
        loginOpenMrsPage.loginButton.click();

    }

    @Then("User is logged in correctly")
    public void user_is_logged_as() {
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demo.openmrs.org/openmrs/referenceapplication/home.page";
        Assert.assertEquals(expectedUrl,actualUrl);

        // Log out
        loginOpenMrsPage.logoutButton.click();
    }
}
