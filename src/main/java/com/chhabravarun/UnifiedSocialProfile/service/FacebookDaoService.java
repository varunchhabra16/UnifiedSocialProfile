package com.chhabravarun.UnifiedSocialProfile.service;


import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookDaoService {

    @Autowired
    FacebookClient facebookClient;


    public User getUser(){

        return facebookClient.fetchObject("me",User.class);

    }

    public Connection<Post> getTimeLine(){

        Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);

        return myFeed;

    }


}
