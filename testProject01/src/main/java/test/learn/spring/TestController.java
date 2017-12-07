package test.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/v1/ayon/controller")
public class TestController {

    @Value("${home.name}")
    String testValue;

    @Autowired
    Application.Test test;

    @RequestMapping("/test1")
    public String t1() {
        return test.QQQQ;
    }

    @RequestMapping("/test2")
    public String t2() {
        return testValue;
    }

    @RequestMapping(value = "/multiply/{amount}", method = GET)
    public Long getAmountMultiplied(@PathVariable Long amount) {
        return amount * 10;
    }

    @RequestMapping(value = "/multiply/{amount}/delete", method = DELETE)
    public String delAmount(@PathVariable Long amount) {
        return "deleted amount" + amount.toString();
    }

    @RequestMapping(value = "/multiply/{amount}/update", method = POST)
    public String delAmount(@PathVariable Long amount,
                            @RequestBody BodyDto dto) {
        return "updatedDatase with" + amount.toString() + dto.toString();
    }
}

