package com.chhabravarun.UnifiedSocialProfile.controller;


import com.chhabravarun.UnifiedSocialProfile.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.User;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    TwitterService twitterService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String id){
        return twitterService.getUser(id);
    }

    @GetMapping("/timeline/{id}")
    public List<String> getUserTimeline(@PathVariable("id") String id){
        List<String> tweets =  twitterService.getTimeLine();
        return tweets;
    }
}
