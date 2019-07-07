package com.chhabravarun.UnifiedSocialProfile.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TwitterUserDaoService {

    @Autowired
    Twitter twitter;

    @Autowired
    RedisConnection redisConnection;

    public twitter4j.User getUser(String id) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        twitter4j.User user = twitter.showUser(id);
        return user;
    }

    public List<String> getTimeLine() throws TwitterException {
        List<String> tweets = twitter.getHomeTimeline().stream().map(item -> item.getText()).collect(Collectors.toList());

        return tweets;
    }




}
