package com.chhabravarun.UnifiedSocialProfile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String facebook = "facebook";
    private static final String twitter = "twitter";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageFacebook(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(facebook, message);
    }

    public void sendMessageTwitter(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(twitter, message);
    }
}
