package com.yyong.activemq.produce.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class QueueProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"vvvvvv:"+ UUID.randomUUID().toString().substring(0,6));
    }

    //间隔时间3秒定投
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"****Scheduled:"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("****Scheduled:OK");
    }
}
