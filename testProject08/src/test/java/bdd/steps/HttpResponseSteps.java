package bdd.steps;

import bdd.config.WithContext;
import bdd.utils.RestClientUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class HttpResponseSteps extends WithContext {

  @Autowired
  private RestClientUtils restClientUtils;

  @Then("^I expect a (\\d+) response$")
  public void iExpectAResponse(int statusCode) {
    restClientUtils.assertStatusCode(statusCode);
  }

  @And("^the API response contains$")
  public void theJSONResponseContains(Map<String, String> properties) {
    restClientUtils.assertJson(properties);
  }

  @And("^the API response contain properties with collections$")
  public void theJSONResponseContainsArray(Map<String, String> properties) {
    properties.forEach((s, s2) -> {
      log.info(s + ":" + s2);
      restClientUtils.assertJsonArrayContains(s, s2.split(","));
    });
  }

  @And("^the following properties are empty$")
  public void theJSONResponseContainsEmptyPropertiesOf(List<String> properties) {
    restClientUtils.assertJsonNotNull(properties);
  }

  @And("^the following properties do not exist$")
  public void theJSONResponseDoesNotContainPropertiesOf(List<String> properties) {
    restClientUtils.assertJsonDoesNotExist(properties);
  }

  @And("^the API response contains properties$")
  public void theAPIResponseContains(List<String> properties) {
    restClientUtils.assertJsonNotNull(properties);
  }

  @Then("^I expect a (\\d+) response with errorCode: (\\w+)$")
  public void iExpectAResponseWithErrorCode(int code, String errorCode) throws Throwable {
    iExpectAResponse(code);
    restClientUtils.assertJson("errorCode", errorCode);
  }

  @Then("^the API response has body$")
  public void iExpectAResponseWithErrorCode(String body) throws Throwable {
    restClientUtils.assertBody(body);
  }

}
