package test.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;



//configuration will scann all the beans, without this spring will not be able to scan these beans
@Configuration
public class BeanCollection {
    class Test {
        public String QQQQ;
        public Test(String QQQQ) {
            this.QQQQ = QQQQ;
        }
    }

    @Bean("samurai")
    public Test testClass1() {
        return new Test("t1");
    }

    @Bean("ninja")
    public Test testClass2() {
        return new Test("t2");
    }

    @Scheduled(cron = "${tryschedule2.cronString}")
    public void exportMetrics() {
        System.out.println("from Bean collection with :P");
    }
}
