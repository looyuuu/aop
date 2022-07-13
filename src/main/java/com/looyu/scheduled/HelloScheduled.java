package com.looyu.scheduled;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;




@Component
@EnableScheduling
public class HelloScheduled {

    @Async
    @Scheduled(cron = "1 * * * * * *")
    public void sayHello() {
        System.out.println("hello");
        System.out.println("hello git 1");
        System.out.println("hello git 2");
    }

}
