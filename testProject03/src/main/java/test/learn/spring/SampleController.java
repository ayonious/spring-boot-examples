package test.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


@RestController
public class SampleController {

    @Autowired
    List<BeanCollection.Test> tests;

    @RequestMapping("/test1")
    public List<BeanCollection.Test >t1(){
        return tests;
    }
}
