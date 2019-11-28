package com.yyong.activemq.produce.config;



import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
@EnableJms
public class ActivemqConfig {

    @Value("${mytopic}")
    private String myTopic;


    @Bean
    public Topic topic(){
        return new ActiveMQTopic(myTopic);
    }
}
