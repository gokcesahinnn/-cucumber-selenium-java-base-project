package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ApiUtils;

import static org.junit.Assert.assertEquals;

public class ApiStepDefs {

    private Response response;

    @Given("^I make a GET request to \"([^\"]*)\"$")
    public void iMakeAGetRequestTo(String endpoint) {
        response = ApiUtils.sendGetRequest(endpoint);
    }

    @Then("^I should get a successful response$")
    public void iShouldGetASuccessfulResponse() {
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }
}
