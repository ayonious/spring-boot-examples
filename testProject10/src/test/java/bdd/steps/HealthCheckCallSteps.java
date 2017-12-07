package bdd.steps;

import static com.google.common.collect.ImmutableMap.of;

import bdd.config.WithContext;
import bdd.utils.RestClientUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;


public class HealthCheckCallSteps extends WithContext implements En {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  private RestClientUtils restClient;

  @Given("^Ayon-API is up$")
  public void ayon_api_is_healthy() {
  }

  public HealthCheckCallSteps() {
    When("^I make a call to the health check$", () -> {
      restClient.getRequest("/health");
    });
  }
}
