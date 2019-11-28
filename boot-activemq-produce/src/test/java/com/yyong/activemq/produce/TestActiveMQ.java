package com.yyong.activemq.produce;

import com.yyong.activemq.produce.test.QueueProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = MQProduceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {

    @Resource
    private QueueProduce queueProduce;

    @Test
    public void testSend()throws Exception{
        queueProduce.produceMsg();
    }

    //间隔定投


}
