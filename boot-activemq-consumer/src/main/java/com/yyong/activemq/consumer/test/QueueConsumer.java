package com.yyong.activemq.consumer.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class QueueConsumer {

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage)throws Exception{
        System.out.println("****消费者收到消息："+ textMessage.getText());
    }

}
