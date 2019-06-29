package com.chhabravarun.UnifiedSocialProfile.controller;


import com.chhabravarun.UnifiedSocialProfile.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/codeforces")
public class CFUserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Quote getUserById(@PathVariable("id") String id){


        Quote quote = restTemplate.getForObject("https://codeforces.com/api/user.info?handles="+id, Quote.class);

        return quote;

    }


}
