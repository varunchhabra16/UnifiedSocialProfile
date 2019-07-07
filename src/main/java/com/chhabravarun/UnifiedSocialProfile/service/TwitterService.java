package com.chhabravarun.UnifiedSocialProfile.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;
import twitter4j.User;

import java.util.List;

@Service
public class TwitterService {

    @Autowired
    TwitterUserDaoService twitterUserDaoService;

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    Producer producer;

    public User getUser(String id){
        User user = null;
        try {
            user =  twitterUserDaoService.getUser(id);
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return user;

    }

    public List<String> getTimeLine(){
        List<String> timeline = null;
        try {
            timeline =  twitterUserDaoService.getTimeLine();
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        System.out.println("Here");


        RedisConnection redisConnection = jedisConnectionFactory.getConnection();

        for (int i = 0; i < timeline.size(); i++) {
            redisConnection.listCommands().lPush((new String("twitter")).getBytes(),timeline.get(i).getBytes());
            producer.sendMessageTwitter(timeline.get(i));
        }

        return timeline;
    }

}
