package com.chhabravarun.UnifiedSocialProfile.service;

import com.chhabravarun.UnifiedSocialProfile.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDaoService {

    @Autowired
    RestTemplate restTemplate;

    public Quote getUserById(String id) {


        Quote quote = restTemplate.getForObject("https://codeforces.com/api/user.info?handles=" + id, Quote.class);

        return quote;
    }
}
