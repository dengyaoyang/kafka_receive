package com.cecgw.cq.conf;

import com.alibaba.fastjson.JSONArray;
import com.cecgw.cq.entity.FieldQueen;
import com.cecgw.cq.util.JedisUtil;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpoint;

import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;


import java.util.List;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-27
 */
//@Configuration
public class MyKafkaContainer extends ConcurrentKafkaListenerContainerFactory {

////    @Autowired
//    JedisUtil jedisUtil;
////    @Autowired
//    ConsumerFactory<String, String> consumerFactory;
//
//    @Override
//    protected void initializeContainer(ConcurrentMessageListenerContainer instance, KafkaListenerEndpoint endpoint) {
//        super.initializeContainer(instance, endpoint);
//        List<String> fieldQueen = jedisUtil.getList("Consumer_field_queen");
//        List<FieldQueen> fieldQueenList = JSONArray.parseArray(fieldQueen.toString(), FieldQueen.class);
//        for (FieldQueen f:fieldQueenList){
//            TopicPartition topicPartition = new TopicPartition(f.getTopicName(),f.getPartition());
//            Consumer consumer =  consumerFactory.createConsumer(topicPartition.toString());
//            consumer.seek(topicPartition, f.getOffset());
////            consumer.se
//        }
//    }
}
