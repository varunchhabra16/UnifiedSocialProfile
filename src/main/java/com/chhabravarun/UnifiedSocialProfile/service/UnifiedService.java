package com.chhabravarun.UnifiedSocialProfile.service;


import com.chhabravarun.UnifiedSocialProfile.model.CFUser;
import com.chhabravarun.UnifiedSocialProfile.model.UnifiedFeed;
import com.chhabravarun.UnifiedSocialProfile.model.UnifiedProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.User;

import java.util.List;

@Service
public class UnifiedService {

    @Autowired
    CFUserService cfUserService;

    @Autowired
    TwitterService twitterService;

    @Autowired
    FacebookService facebookService;


    public UnifiedProfile getUserProfile(String id){

        UnifiedProfile unifiedProfile = new UnifiedProfile();

        CFUser cfUser = cfUserService.getUserById(id);

        if( cfUser != null ){
            unifiedProfile.setCodeForceUser(cfUser);
        }


        User twitterUser = twitterService.getUser(id);

        if( twitterUser != null ){
            unifiedProfile.setTwitterUser(twitterUser);
        }


        com.restfb.types.User facebookUser = facebookService.getUser();

        unifiedProfile.setFacebookUser(facebookUser);

        return unifiedProfile;
    }

    public UnifiedFeed getUnifiedFeed(){

        UnifiedFeed unifiedFeed = new UnifiedFeed();

        List<String> twitterFeed = twitterService.getTimeLine();
        List<String> facebookFeed = facebookService.getTimeline();

        unifiedFeed.setFacebookFeed(facebookFeed);
        unifiedFeed.setTwitterFeed(twitterFeed);



        return unifiedFeed;

    }


}
