package com.training.studentservice.controller;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.training.courseservice.model.Course;
import com.training.studentservice.model.Student;
import com.training.studentservice.repository.StudentRepository;

@RestController   //combination of @Controller and @ResponseBody
@RequestMapping("/studapi")
public class StudentController {
	
	@Autowired
	StudentRepository repository;
	
//	@GetMapping("/stud/{id}")
//	public Student getStudById(@PathVariable("id") long id) {
//		Optional<Student> stud = repository.findById(id);
//		
//		if(stud.isPresent())
//		{
//			return stud.get();
//		}
//		else {
//			return null;
//		}
//	}
	
//	@GetMapping("/stud/{id}")
//	public Student getStudById(@PathVariable("id") long id) {
//		Optional<Student> stud = repository.findById(id);
//		
//		if(stud.isPresent())
//		{
//			return stud.get();
//		}
//		else {
//			return null;
//		}
//	}
	
	@GetMapping("/stud")
	public List<Student> getStudr() {
		
		return repository.findAll();
	}
	//@ResponseBody
	public List<Student> getStud() {
		//return repository.findAll();
	List<Student> studList = new ArrayList<> ();
	studList.add(new Student("Deeks",22,"A+"));
	studList.add(new Student("Sravs",21,"A+"));
	studList.add(new Student("Janani",21,"A"));
	studList.add(new Student("Tharika",22,"A"));
	return studList;
	}
	
	@PostMapping("/stud")
	public Student post(@RequestBody long id) 
	{
		Optional<Student> stud = repository.findById(id);
		
		if(stud.isPresent())
		{
			return stud.get();
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/post")
	public void save(@RequestBody Student stud) 
	{
		repository.save(stud);
	}
	
	@PutMapping("/stud/{id}")
	public void updateUser(@PathVariable("id") long id, @RequestBody Student stud) {
		Optional<Student> oldData = repository.findById(id);
		if(oldData.isPresent()) {
			Student std= oldData.get();
			std.setAge(stud.getAge());
			std.setGrade(stud.getGrade());
			std.setStudName(stud.getStudName());
			repository.save(std);
		}
		else {
			System.out.println("No data found");
		}
	}

}
