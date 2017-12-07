package test.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    class Test {
        public String QQQQ = "qqqqqq";
    }

    @Bean
    public Test testClass() {
        return new Test();
    }
}
