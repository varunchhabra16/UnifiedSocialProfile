package com.chhabravarun.UnifiedSocialProfile.service;


import com.chhabravarun.UnifiedSocialProfile.model.CFUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CFUserDaoService {

    @Autowired
    RestTemplate restTemplate;

    public CFUser getUserById(String id){

        CFUser cfUser = null;

        try {
            cfUser = restTemplate.getForObject("https://codeforces.com/api/user.info?handles=" + id, CFUser.class);
        }
        catch (HttpClientErrorException clientException ){
            clientException.printStackTrace();
        }
        catch (HttpServerErrorException serverException ){
            serverException.printStackTrace();
        }
        return cfUser;
    }

}
