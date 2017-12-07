package bdd.model;

import lombok.Data;
import org.springframework.test.web.servlet.ResultActions;

@Data
public class TestContext {

  private String name;
  private Long age;
  private ResultActions lastRestCall;
}
