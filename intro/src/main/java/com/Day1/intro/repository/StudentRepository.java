package com.Day1.intro.repository;

import com.Day1.intro.Controller.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> existsByEmail(String email);
}
