package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    // 注入RabbitMQ模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // hello world
    @Test
    public void testHelloWorld() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    /**
     * 工作模式
     */
    @Test
    public void testWork() {
        rabbitTemplate.convertAndSend("work","work模型");
    }

    /**
     * 广播模式
     */
    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("logs","","Fanout模型传递的消息");
    }

    /**
     * 路由模式
     */
    @Test
    public void testRouter() {
        rabbitTemplate.convertAndSend("directs","error","发送error的key的路由信息");
    }

    /**
     * topic 动态路由
     */
    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("topics","order","order路由消息");
    }

}

