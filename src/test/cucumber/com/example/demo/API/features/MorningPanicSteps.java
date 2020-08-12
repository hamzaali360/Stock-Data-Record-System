package com.example.demo.API.features;

import com.example.demo.controllers.messages.MorningPanicEnvelope;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class MorningPanicSteps {


    HttpResponse<String> response;

    @Before
    public void initTests(){

    }

    @When("^the following JSON response is sent")
    public  void submitApiRequest(String json) {
        Gson g = new Gson();
        MorningPanicEnvelope envelope = g.fromJson(json, MorningPanicEnvelope.class);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/morning_panic"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try { response = client.send(request, HttpResponse.BodyHandlers.ofString()); }
        catch (Exception e){ }

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
