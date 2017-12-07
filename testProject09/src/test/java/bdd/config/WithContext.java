package bdd.config;


import bdd.model.TestContext;
import org.springframework.beans.factory.annotation.Autowired;

public class WithContext {

  @Autowired
  private ThreadLocal<TestContext> context;

  public TestContext context() {
    return context.get();
  }
}
