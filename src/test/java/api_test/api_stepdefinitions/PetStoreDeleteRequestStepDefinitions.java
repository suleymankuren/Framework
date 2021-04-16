package api_test.api_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetStoreDeleteRequestStepDefinitions {

    Response response;

    @Given("User checks pet 201020 is created")
    public void user_checks_pet_is_created() {
        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/201020")
                .then().statusCode(200);
    }

    @When("User executes delete request for pet 201020")
    public void user_executes_delete_request() {
        response=given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/201020")
                .then().extract().response();
    }

    @Then("User validates status code is {int} or not")
    public void user_validates_status_code_is_or_not(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("User executes get request for existing pet")
    public void user_executes_get_request_for_existing_pet() {
        response=given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/201020")
                .then().extract().response();
    }

    @Then("User checks {int} status code")
    public void user_checks_status_code(Integer statusCodeCheck) {
        response.then().statusCode(statusCodeCheck);
    }

}
