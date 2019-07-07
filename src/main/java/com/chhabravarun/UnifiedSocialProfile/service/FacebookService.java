package com.chhabravarun.UnifiedSocialProfile.service;


import com.restfb.Connection;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacebookService {

    @Autowired
    FacebookDaoService facebookDaoService;

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    Producer producer;


    public User getUser(){

        return facebookDaoService.getUser();

    }

    public List<String> getTimeline(){

        List<String> posts = new ArrayList<>();

        Connection<Post> myFeed = facebookDaoService.getTimeLine();

        for (List<Post> myFeedPage : myFeed) {

            // Iterate over the list of contained data
            // to access the individual object
            for (Post post : myFeedPage) {
                if(post.getMessage() != null)
                posts.add(post.getMessage());
            }
        }

        RedisConnection redisConnection = jedisConnectionFactory.getConnection();

        for (int i = 0; i < posts.size(); i++) {
            redisConnection.listCommands().lPush((new String("facebook")).getBytes(),posts.get(i).getBytes());
            producer.sendMessageFacebook(posts.get(i));
        }

        return posts;

    }



}
