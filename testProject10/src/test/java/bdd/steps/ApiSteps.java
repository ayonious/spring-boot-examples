package bdd.steps;


import bdd.config.WithContext;
import bdd.utils.DBUtils;
import bdd.utils.RestClientUtils;
import cucumber.api.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import test.learn.spring.dto.UpdateRequestDto;


@Slf4j
public class ApiSteps extends WithContext implements En {

  @Autowired
  private RestClientUtils restClient;

  public ApiSteps() {
    Given("^I make a call to Create a User with Name ([a-zA-Z0-9-]+)$",
        (String userName) -> {
          context().setName(userName);
          restClient.putRequest(String.format("/v1/create/%s/age/%s", userName, "10"), defaultHeaders());
        });

    Given("^I make a call to Create a User with Name ([a-zA-Z0-9-]+) and Age ([a-zA-Z0-9-]+)$",
        (String userName, Long age) -> {
          context().setName(userName);
          restClient.putRequest(String.format("/v1/create/%s/age/%s", userName, age), defaultHeaders());
        });

    Given(
        "^I make a call to Update a User ([a-zA-Z0-9-]+) With NewAge ([a-zA-Z0-9-]+)$",
        (String userName, Long newAge) -> {
          context().setName(userName);
          restClient.postRequest(String.format("/v1/update/%s", userName),
              new UpdateRequestDto(userName, newAge),
              defaultHeaders());
        });

    Given(
        "^I make a call to Delete a User With Name ([a-zA-Z0-9-]+)$",
        (String userName) -> {
          context().setName(userName);
          restClient.postRequest(String.format("/v1/delete/%s", userName),
              null,
              defaultHeaders());
        });

    Given("^I make a call to Fetch a User with Name ([a-zA-Z0-9-]+)$",
        (String userName) -> {
          restClient.getRequest(String.format("/v1/get/%s", userName));
        });
  }


  private HttpHeaders defaultHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");
    return headers;
  }
}







