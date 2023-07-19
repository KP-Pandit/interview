package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.Service;

@RestController
@RequestMapping("/req")
public class MyController {
	@Autowired
	Service service;
	
	
	@PostMapping("/save")
	public ResponseEntity<Student> save(Student stu){
		
		Student str=service.saveStu(stu);
		
		return new ResponseEntity<Student>(str, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Student>> get(){
	List<Student> students	=service.getAll();
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id){
		service.delete(id);
	}
	@PutMapping("/put")
	public ResponseEntity<Student> updateUser(@RequestBody Student str){
		Optional<Student> newStr=service.update(str);
		return new ResponseEntity<Student>(str, HttpStatus.OK);
		
	}
	
	
}
