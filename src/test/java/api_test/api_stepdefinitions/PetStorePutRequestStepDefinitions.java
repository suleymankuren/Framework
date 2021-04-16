package api_test.api_stepdefinitions;

import api_test.pojo.PetStorePojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.PropertyReader;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class PetStorePutRequestStepDefinitions {

    Response response;

    @Given("User checks pet 201020 is created before")
    public void user_checks_pet_is_created_before() {
        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/201020")
                .then().statusCode(200);
    }

    @When("User executes put request for pet 201020")
    public void user_executes_put_request() {
        PetStorePojo petStorePojo=new PetStorePojo();
        petStorePojo.setName(PropertyReader.apiPropertyReaderByKey("updatedPetName"));
        petStorePojo.setStatus(PropertyReader.apiPropertyReaderByKey("updatedPetStatus"));
        petStorePojo.setId(Long.parseLong(PropertyReader.apiPropertyReaderByKey("updatedId")));
        response=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petStorePojo)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().extract().response();
    }

    @Then("Status code is {int} or not")
    public void status_code_is_or_not(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("Pet has following updated attributes")
    public void pet_has_following_updated_attributes(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> maps=dataTable.asMaps();
        Map<String,String> petData=maps.get(0);

        String petName=petData.get("petName");
        String petStatus=petData.get("petStatus");
        long petId=Long.parseLong(petData.get("petId"));

        PetStorePojo petStorePojo=response.as(PetStorePojo.class);

        Assert.assertEquals(petId,petStorePojo.getId());
        Assert.assertEquals(petName,petStorePojo.getName());
        Assert.assertEquals(petStatus,petStorePojo.getStatus());
    }

}
