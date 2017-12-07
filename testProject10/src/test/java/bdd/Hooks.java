package bdd;

import bdd.config.BDDConfig;
import bdd.model.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import test.learn.spring.Application;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("bdd")
@ContextConfiguration(classes = {Application.class, BDDConfig.class})
public class Hooks {

  @PostConstruct
  public void after(){
    int q = 1;
  }

  @Autowired
  private ThreadLocal<TestContext> context;

  @Before
  public void initComponent() {
    context.set(new TestContext());
  }

  /**
   * After Scenario: Step files are reset but not beans.
   */
  @After
  public void clearComponents() {
    context.remove();
  }

}
