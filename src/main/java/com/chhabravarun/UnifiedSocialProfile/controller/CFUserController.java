package com.chhabravarun.UnifiedSocialProfile.controller;


import com.chhabravarun.UnifiedSocialProfile.model.CFUser;
import com.chhabravarun.UnifiedSocialProfile.service.CFUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/codeForces")
public class CFUserController {

    @Autowired
    CFUserService cfUserService;

    @GetMapping("/{id}")
    public CFUser getUserById(@PathVariable("id") String id){
        return cfUserService.getUserById(id);
    }




}
