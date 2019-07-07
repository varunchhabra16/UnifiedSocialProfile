package com.chhabravarun.UnifiedSocialProfile.controller;


import com.chhabravarun.UnifiedSocialProfile.model.UnifiedFeed;
import com.chhabravarun.UnifiedSocialProfile.model.UnifiedProfile;
import com.chhabravarun.UnifiedSocialProfile.service.UnifiedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/unified")
public class Controller {

    @Autowired
    UnifiedService unifiedService;

    @GetMapping("/profile/{id}")
    public UnifiedProfile getUnifiedProfile(@PathVariable("id") String id){
        return unifiedService.getUserProfile(id);
    }

    @GetMapping("/feed/{id}")
    public UnifiedFeed getUnifiedFeed(@PathVariable("id") String id){
        return unifiedService.getUnifiedFeed();
    }



}
