package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    public static Response sendGetRequest(String endpoint) {
        RestAssured.baseURI = "https://reqres.in/";
        return RestAssured.given().get(endpoint);
    }
}
