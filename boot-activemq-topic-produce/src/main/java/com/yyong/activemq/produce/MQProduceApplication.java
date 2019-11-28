package com.yyong.activemq.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时器
public class MQProduceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MQProduceApplication.class,args);
    }
}
