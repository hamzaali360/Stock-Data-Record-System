package com.example.demo.API.features.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.Assert.assertEquals;

public class MorningPanicSteps {

    HttpResponse<String> response;

    @When("^the following JSON response is sent")
    public  void submitApiRequest(String json) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/morning_panic"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try { response = client.send(request, HttpResponse.BodyHandlers.ofString()); }
        catch (Exception e){ e.printStackTrace(); }

    }

    @Then("^the response code is (\\d+)$")
    public void theResponseCodeIs(int responseCode) {
        assertEquals(responseCode, response.statusCode());
    }

    @And("^the body is \"([^\"]*)\"$")
    public void theBodyIs(String responseBody) {
        assertEquals(responseBody, response.body());
    }

}
