package com.yyong.activemq.produce.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableJms
public class ActivemqConfig {

    @Value("${myqueue}")
    private String myQueue;


    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }
}
