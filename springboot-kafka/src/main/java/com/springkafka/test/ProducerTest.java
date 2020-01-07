package com.springkafka.test;

import com.alibaba.fastjson.JSONObject;
import com.springkafka.Person;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-07
 */
public class ProducerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "123.206.202.43:9092");
        props.put("acks", "all");
        props.put("delivery.timeout.ms", 30000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("request.timeout.ms",20000);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++){
            Person person=new Person();
            person.setAge(i);
            person.setName("name_"+i);

            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), JSONObject.toJSONString(person)));
        }


        producer.close();
    }
}
