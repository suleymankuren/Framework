package ui_test.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ui_test.page.LoginOpenMrsPage;
import ui_test.page.PatientRegisterOpenMrsPage;
import utils.Driver;
import java.util.List;
import java.util.Map;

public class PatientRegisterOpenMrsStepDefinitions {

    WebDriver driver= Driver.driver();
    PatientRegisterOpenMrsPage patientRegisterOpenMrsPage=new PatientRegisterOpenMrsPage(driver);
    LoginOpenMrsPage loginOpenMrsPage=new LoginOpenMrsPage(driver);

    @When("User registers a new patient with following information:")
    public void user_registers_a_new_patient_with_following_information(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> dataTableList=dataTable.asMaps();
        Map<String,String> data=dataTableList.get(0);

        // Click register button
        patientRegisterOpenMrsPage.registerButton.click();

        // Provide given and family name
        patientRegisterOpenMrsPage.givenName.sendKeys(data.get("givenName"));
        patientRegisterOpenMrsPage.familyName.sendKeys(data.get("familyName"));

        // Switch to gender field and provide gender
        patientRegisterOpenMrsPage.genderLabel.click();

        Select select= new Select(patientRegisterOpenMrsPage.patientGender);
        select.selectByVisibleText(data.get("gender"));

        // Switch to birthday field

        patientRegisterOpenMrsPage.birthdayLabel.click();
        patientRegisterOpenMrsPage.birthDay.sendKeys(data.get("birthday"));

        select=new Select(patientRegisterOpenMrsPage.birthMonth);
        select.selectByValue(data.get("birthmonth"));
        patientRegisterOpenMrsPage.birthYear.sendKeys(data.get("birthyear"));

        // Switch to address field

        patientRegisterOpenMrsPage.addressField.click();
        patientRegisterOpenMrsPage.address.sendKeys(data.get("address"));
        patientRegisterOpenMrsPage.city.sendKeys(data.get("city"));
        patientRegisterOpenMrsPage.state.sendKeys(data.get("state"));
        patientRegisterOpenMrsPage.country.sendKeys(data.get("country"));
        patientRegisterOpenMrsPage.postalCode.sendKeys(data.get("postal code"));

        // Switch to phone number field

        patientRegisterOpenMrsPage.phoneNumberField.click();

        patientRegisterOpenMrsPage.phoneNumber.sendKeys(data.get("phoneNumber"));

        // Switch to relatives

        patientRegisterOpenMrsPage.relatives.click();

        select=new Select(patientRegisterOpenMrsPage.relationOfRelative);
        select.selectByVisibleText("Parent");
        patientRegisterOpenMrsPage.relativeName.sendKeys(data.get("relative name"));

        // Click confirm
        patientRegisterOpenMrsPage.confirm.click();
        patientRegisterOpenMrsPage.secondConfirm.click();
    }

    @Then("New patient is registered")
    public void new_patient_is_registered() {
        String actualGivenName=patientRegisterOpenMrsPage.givenNameCheck.getText().trim();
        String expectedGivenName="David";
        Assert.assertEquals(expectedGivenName,actualGivenName);

        //Handling with popup
        patientRegisterOpenMrsPage.toastMessage.click();

        // Main Page
        patientRegisterOpenMrsPage.mainPage.click();

        // Log out
        loginOpenMrsPage.logoutButton.click();
    }

    @When("User clicks Gender Label without filling required information")
    public void user_clicks_gender_label_without_filling_required_information() {
        // Click register button
        patientRegisterOpenMrsPage.registerButton.click();
        // Switch to gender field and provide gender
        patientRegisterOpenMrsPage.genderLabel.click();
    }

    @Then("User is not able to process")
    public void user_is_not_able_to_process() {
        for (int i=0;i<patientRegisterOpenMrsPage.errorMessages.size();i++){
            if(!patientRegisterOpenMrsPage.errorMessages.get(i).getText().equals("")) {
                Assert.assertEquals("Required", patientRegisterOpenMrsPage.errorMessages.get(i).getText());
            }
        }

        // Log out
        loginOpenMrsPage.logoutButton.click();

    }

    @When("User provides Given Name and Family Name")
    public void user_provides_given_name_and_family_name() {
        // Click register button
        patientRegisterOpenMrsPage.registerButton.click();
        // Provide given and family name
        patientRegisterOpenMrsPage.givenName.sendKeys("David");
        patientRegisterOpenMrsPage.familyName.sendKeys("Code");
    }

    @When("User navigates to Gender section")
    public void user_navigates_to_gender_section() {
        // Switch to gender field and provide gender
        patientRegisterOpenMrsPage.genderLabel.click();
    }

    @When("User clicks confirm button")
    public void user_clicks_confirm_button() {
        // Click confirm
        patientRegisterOpenMrsPage.confirm.click();
    }

    @Then("User is not able to confirm")
    public void user_is_not_able_to_confirm() {
        for (int i=0;i<patientRegisterOpenMrsPage.errorMessages.size();i++){
            if(!patientRegisterOpenMrsPage.errorMessages.get(i).getText().equals("")) {
                Assert.assertEquals("Required", patientRegisterOpenMrsPage.errorMessages.get(i).getText());
            }
        }

        // Log out
        loginOpenMrsPage.logoutButton.click();
    }
}
