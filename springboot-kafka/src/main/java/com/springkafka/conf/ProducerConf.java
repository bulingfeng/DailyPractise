package com.springkafka.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-07
 */
@Configuration
public class ProducerConf {

    @Value("spring.kafka.bootstrap.servers")
    private String servers;

    @Bean
    public Properties getProperties(){
        System.out.println(this.servers);
        Properties properties=new Properties();
        properties.setProperty("bootstrap.servers",this.servers);
        return properties;
    }

}
