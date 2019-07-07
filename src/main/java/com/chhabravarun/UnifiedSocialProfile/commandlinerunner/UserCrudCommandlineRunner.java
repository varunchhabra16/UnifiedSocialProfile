package com.chhabravarun.UnifiedSocialProfile.commandlinerunner;

import com.chhabravarun.UnifiedSocialProfile.model.Student;
import com.chhabravarun.UnifiedSocialProfile.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCrudCommandlineRunner implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(String... args) throws Exception {


        Student student = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);

        Student retrievedStudent =
                studentRepository.findById("Eng2015001").get();

        System.out.println(retrievedStudent);

        List<String> list = new ArrayList<>();

        list.add("Varun");



        redisTemplate.opsForList().leftPush("VARUN",list);

        Object obj = (List<String>)redisTemplate.opsForList().leftPop("VARUN");

        System.out.println(obj);



        System.out.println("Pushed Data into redis");



    }
}
