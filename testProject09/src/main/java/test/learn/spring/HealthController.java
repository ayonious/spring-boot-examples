package test.learn.spring;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.learn.spring.Db.PersonRepository;

@RestController
public class HealthController {

  @RequestMapping(path = "health", method = GET)
  public String checkHealth() {
    return "Health is Good :D";
  }

  @RequestMapping(path = "create/{name}/age/{age}", method = POST)
  public String putting(@PathVariable String name, @PathVariable String age) {
    return String.format("Health Returning post value name:%s, age%s", name, age);
  }

  @RequestMapping(path = "delete/{name}/age/{age}", method = DELETE)
  public String deleting(@PathVariable String name, @PathVariable String age) {
    return String.format("Health Returning deleted value name:%s, age%s", name, age);
  }
}

