package bdd.utils;

import static java.util.Optional.ofNullable;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bdd.config.WithContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;
import javax.servlet.http.Cookie;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@Component
@Slf4j
public class RestClientUtils extends WithContext {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    private ResultActions lastCall() {
        return context().getLastRestCall();
    }
    private void lastCall(ResultActions lastCall) {
        context().setLastRestCall(lastCall);
    }

    @SneakyThrows
    public void getRequestSync(String url) {
        perform(get(url));
    }

    @SneakyThrows
    public void getRequest(String url) {
        perform(get(url));
    }

    public void getRequest(String url, HttpHeaders headers) {
        perform(get(url).headers(headers));
    }

    public void getRequestWithImmediateError(String url) {
        perform(get(url));
    }

    public void getRequestWithImmediateError(String url, HttpHeaders headers) {
        perform(get(url).headers(headers));
    }

    public void postRequest(String url, Object object) {
        perform(post(url), object);
    }

    public void postRequest(String url, Object object, HttpHeaders headers) {
        perform(post(url).headers(headers), object);
    }

  public void deleteRequest(String url, Object object, HttpHeaders headers) {
    perform(delete(url).headers(headers), object);
  }

    public void postRequest(String url, Object object, Cookie cookie) {
        perform(post(url).cookie(cookie), object);
    }

    public void postRequest(String url, Object object, Cookie... cookies) {
        MockHttpServletRequestBuilder post = post(url);
        post.cookie(cookies);
        perform(post, object);
    }

    public void putRequest(String url, Object object) {
        perform(put(url), object);
    }

    public void putRequest(String url, Object object, HttpHeaders headers) {
        perform(put(url).headers(headers), object);
    }

    @SneakyThrows
    private void perform(MockHttpServletRequestBuilder requestBuilder) {
        lastCall(mvc.perform(requestBuilder).andDo(print()));
    }

  @SneakyThrows
  private void perform(MockHttpServletRequestBuilder requestBuilder, Object payload) {
    Stream.of(
        ofNullable(payload)
            .map(this::getBody)
            .map(requestBuilder::content)
            .orElse(requestBuilder))
        .map(b -> b.contentType(MediaType.APPLICATION_JSON_UTF8))
        .findAny()
        .ifPresent(this::perform);
  }

  @SneakyThrows
  private String getBody(Object p) {
    String bodyStr = p instanceof String ? (String) p : objectMapper.writeValueAsString(p);
    log.info("Type: {}, Body: {}", p.getClass().getSimpleName(), bodyStr);
    return bodyStr;
  }


  @SneakyThrows
    public <T> T getLastResultAsModel(Class<T> type) {
        return objectMapper.readValue(lastCall().andReturn().getResponse().getContentAsString(), type);
    }

    @SneakyThrows
    public void assertBody(String body) {
        lastCall().andExpect(content().string(body));
    }

    @SneakyThrows
    public void assertStatusCode(int status) {
        lastCall().andExpect(status().is(status));
    }

    @SneakyThrows
    public <T> void assertJson(String path, Matcher<T> value) {
        lastCall().andExpect(jsonPath("$." + path).value(value));
    }

    @SneakyThrows
    public void assertJsonIsArray(String path) {
        lastCall().andExpect(jsonPath("$." + path).isNotEmpty());
        lastCall().andExpect(jsonPath("$." + path).isArray());
    }
    @SneakyThrows
    public void assertJsonArrayContains(String path, String... items) {
        lastCall().andExpect(jsonPath("$." + path).isNotEmpty());
        lastCall().andExpect(jsonPath("$." + path).isArray());
        lastCall().andExpect(jsonPath("$." + path, Matchers.containsInAnyOrder(items)));
    }

    @SneakyThrows
    public void assertJsonPathDoesntExist(String path) {
        lastCall().andExpect(jsonPath("$." + path).doesNotExist());
    }

    public void assertJson(Map<String, String> properties) {
        properties.forEach(this::assertJson);
    }

    @SneakyThrows
    public void assertJson(String path, String value) {
        lastCall().andExpect(jsonPath("$." + path).value(value));
    }

    @SneakyThrows
    public void assertJsonNull(List<String> properties) {
        properties.forEach(this::assertJsonNull);
    }

    @SneakyThrows
    public void assertJsonNull(String path) {
        lastCall().andExpect(jsonPath("$." + path).value(nullValue()));
    }

    @SneakyThrows
    public void assertJsonDoesNotExist(List<String> properties) {
        properties.forEach(this::assertJsonDoesNotExist);
    }

    @SneakyThrows
    public void assertJsonDoesNotExist(String path) {
        lastCall().andExpect(jsonPath("$." + path).doesNotExist());
    }

    public void assertJsonNotNull(List<String> properties) {
        properties.forEach(property -> assertJson(property, not(isEmptyOrNullString())));
    }

    public void assertJsonEmpty(List<String> properties) {
        properties.forEach(property ->
            assertJson(property + ".size()", is(0))
        );
    }
}

