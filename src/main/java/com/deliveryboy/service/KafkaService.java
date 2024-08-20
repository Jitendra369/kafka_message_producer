package com.deliveryboy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {


    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${apache.kafaka.topic.local.update}")
    private String topic;

    public boolean locationUpdate(String location) {
        try{
            this.kafkaTemplate.send(topic, location);
            log.info("produce the location updater.......");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
    }

}
