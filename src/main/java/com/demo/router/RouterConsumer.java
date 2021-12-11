package com.demo.router;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouterConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
            exchange = @Exchange(value = "directs",type="direct"),
            key={"info","warn","error"})
    })
    public void receive1(String message) {
        System.out.println("message1 = "+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "directs",type="direct"),
                    key={"error"})
    })
    public void receive2(String message) {
        System.out.println("message2 = "+message);
    }
}
