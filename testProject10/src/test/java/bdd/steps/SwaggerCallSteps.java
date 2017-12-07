package bdd.steps;

import bdd.config.WithContext;
import bdd.utils.RestClientUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;


public class SwaggerCallSteps extends WithContext implements En {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  private RestClientUtils restClient;

  public SwaggerCallSteps() {
    When("^I try reaching swagger-ui index page$", () -> {
      restClient.getRequest("/swagger-ui.html");
    });
  }
}
