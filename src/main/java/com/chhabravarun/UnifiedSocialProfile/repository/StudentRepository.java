package com.chhabravarun.UnifiedSocialProfile.repository;

import com.chhabravarun.UnifiedSocialProfile.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends CrudRepository<Student, String> {}
