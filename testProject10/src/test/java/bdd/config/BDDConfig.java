package bdd.config;

import bdd.model.TestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@Configuration
@ComponentScan("bdd")
public class BDDConfig {

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Bean
  public MockMvc mockMvc() {
    return MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Bean
  public ThreadLocal<TestContext> contextThreadLocal(){
    return new ThreadLocal<>();
  }
}
