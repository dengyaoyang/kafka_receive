package com.cecgw.cq.listen;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-26
 */
//@Component
public class TestLis {

//    @KafkaListener(topics = "test666")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional optional = Optional.of(record.value());
        if (optional.isPresent()){
            System.out.println(optional.get());
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.abs("0".hashCode()) % 50);
    }
}
