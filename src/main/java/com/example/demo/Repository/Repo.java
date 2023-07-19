package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Student;

public interface Repo  extends JpaRepository<Student,Integer>{

	Student save(Optional<Student> strStudent);

	
}
