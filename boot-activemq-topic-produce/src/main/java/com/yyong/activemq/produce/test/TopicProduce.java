package com.yyong.activemq.produce.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

@Component
public class TopicProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    public void produceTopic(){
        jmsMessagingTemplate.convertAndSend(topic,"主题消息:"+ UUID.randomUUID().toString().substring(0,6));
    }

    //间隔时间3秒定投
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(topic,"主题消息：Scheduled:"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("*主题消息*Scheduled:OK");
    }
}
