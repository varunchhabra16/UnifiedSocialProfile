package com.chhabravarun.UnifiedSocialProfile.config;


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Configuration
@EnableTransactionManagement

public class BeanFactory {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public Twitter twitter(){
        return TwitterFactory.getSingleton();
    }

    @Bean
    public FacebookClient getFaceBookClient(@Value("${facebook.accesstoken}") String AccessToken ){

        return new DefaultFacebookClient(AccessToken,Version.VERSION_3_3);

    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        /*jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);*/
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public RedisConnection redisConnection(JedisConnectionFactory jedisConnectionFactory){
        return jedisConnectionFactory.getConnection();
    }

}
