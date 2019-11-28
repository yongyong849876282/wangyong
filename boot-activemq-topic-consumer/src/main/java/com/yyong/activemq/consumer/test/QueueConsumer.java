package com.yyong.activemq.consumer.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class QueueConsumer {

    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage)throws Exception{
        System.out.println("****消费者收到订阅的主题："+ textMessage.getText());
    }

}
