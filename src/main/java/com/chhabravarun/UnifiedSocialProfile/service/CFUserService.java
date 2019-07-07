package com.chhabravarun.UnifiedSocialProfile.service;


import com.chhabravarun.UnifiedSocialProfile.model.CFUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CFUserService {

    @Autowired
    CFUserDaoService cfUserDaoService;

    public CFUser getUserById(String id){
        return cfUserDaoService.getUserById(id);
    }


}
