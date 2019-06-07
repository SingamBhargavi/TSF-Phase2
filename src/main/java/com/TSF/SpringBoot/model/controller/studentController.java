package com.TSF.SpringBoot.model.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TSF.SpringBoot.model.Student;
import com.TSF.SpringBoot.model.dao.studentDAO;

@RestController
@RequestMapping("/institute")
public class studentController {
	@Autowired
	studentDAO stdDAO;
	
	//inserting details
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student std)
	{
		return stdDAO.save(std);
	}
	
	//Retrieve all students
	@GetMapping("/students/")
	public List<Student> getAllStudents()
	{
		return stdDAO.findAll();
	}
	
	//retrieve by id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Integer stdid)
	{
		Student std=stdDAO.findOne(stdid);
		if(std==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(std);
	}
	
	//update using id
	@PutMapping("/students/{id}")
	public ResponseEntity<Student>updateStudent(@PathVariable(value="id") Integer stdid,@Valid @RequestBody Student stdDetails)
	{
		Student std=stdDAO.findOne(stdid);
		if(std==null)
			return ResponseEntity.notFound().build();
		std.setName(stdDetails.getName());
		std.setDepartment(stdDetails.getDepartment());
		Student updateStudent=stdDAO.save(std);
	   return ResponseEntity.ok().body(updateStudent);
	}
	
	//delete a student
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student>deleteStudent(@PathVariable(value="id") Integer stdid)
	{
		Student std=stdDAO.findOne(stdid);
		if(std==null)
			return ResponseEntity.notFound().build();
		stdDAO.delete(std);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/students/")
	public ResponseEntity<Student> deleteAllStudents()
	{
		stdDAO.deleteAll();
		return ResponseEntity.ok().build();
	}

}
