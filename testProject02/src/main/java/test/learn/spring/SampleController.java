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
    @Qualifier("ninja")
    BeanCollection.Test test1;

    @Autowired
    @Qualifier("samurai")
    BeanCollection.Test test2;

    @RequestMapping("/test1")
    public String t1(){
        return test1.QQQQ;
    }


    @RequestMapping("/test2")
    public String t2(){
        return test2.QQQQ;
    }

    //entire list containing all beans instance
    @Autowired
    List<BeanCollection.Test> testList;

    //entire set containing all beans instance
    @Autowired
    Set<BeanCollection.Test> testSet;


    @RequestMapping("/test3")
    public Set<String> t3(){
        return testSet.stream()
                .map( p-> p.QQQQ )
                .collect(toSet());
    }

    @RequestMapping("/test4")
    public List<String> t4() {
        return testList.stream()
                .map(p -> p.QQQQ)
                .collect(toList());
    }
}
