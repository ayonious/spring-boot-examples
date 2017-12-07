package test.learn.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class Scheduledtasks {
    @Scheduled(cron = "${tryschedule.cronString}")
    public void exportMetrics() {
        System.out.println("sample try to run a task by cron every 5 seconds");
    }
}
