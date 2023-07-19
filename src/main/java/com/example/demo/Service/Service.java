package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.Repo;
@org.springframework.stereotype.Service
public class Service {

	
	@Autowired
	Repo repo;
	
	
	public List<Student> getAll() {
		return repo.findAll();
	}
	
	public Student saveStu(Student stu) {
		return repo.save(stu);
	}
	
	
	/*
	 * public Optional<Student> update(Student stu) { Optional<Student>
	 * stu1=repo.findById(stu.getId()); stu1.get().setName(stu.getName()); return
	 * stu1;) }
	 */
	
	public void delete(int id) {
		 repo.deleteById(id);
	}
	
	public Optional<Student> update(Student str) {
	Optional<Student> strStudent=	repo.findById(str.getId());
	strStudent.get().setName(str.getName());
	Student set=repo.save(strStudent);
	
		return Optional.of(set);
	
	}

	public Optional<Student> update(Optional<Student> str) {
		Optional<Student> strStudent=	repo.findById(str.get().getId());
		strStudent.get().setName(str.get().getName());
		Student set=repo.save(strStudent);
		return Optional.of(set);
	}
}
