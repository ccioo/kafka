package com.message.consumer;

import com.message.model.Foo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @Author wen.yang
 */
@Component
public class ComsumerDemo {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(id = "fooGroup2", topics = "topic2")
    public void listen1(List<Foo2> foos) throws IOException {
        foos.forEach(f -> kafkaTemplate.send("topic3", f.getFoo().toUpperCase()));
        System.in.read();
    }

    @KafkaListener(id = "fooGroup3", topics = "topic3")
    public void listen2(List<String> in) {
        System.out.println("topic3 接收到：" + in);
    }
}
