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

import com.TSF.SpringBoot.model.Faculty;
import com.TSF.SpringBoot.model.dao.facultyDAO;



@RestController
@RequestMapping("/institute")
public class facultyController {
	@Autowired
	facultyDAO facDAO;
	
	//inserting details
	@PostMapping("/faculties")
	public Faculty createFaculty(@Valid @RequestBody Faculty fac)
	{
		return facDAO.save(fac);
	}
	
	//Retrieve all faculties
	@GetMapping("/faculties/")
	public List<Faculty> getAllfaculties()
	{
		return facDAO.findAll();
	}
	
	//retrieve by id
	@GetMapping("/faculties/{id}")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable(value="id") Integer facid)
	{
		Faculty fac=facDAO.findOne(facid);
		if(fac==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(fac);
	}
	
	//update using id
	@PutMapping("/faculties/{id}")
	public ResponseEntity<Faculty>updateFaculty(@PathVariable(value="id") Integer facid,@Valid @RequestBody Faculty facDetails)
	{
		Faculty fac=facDAO.findOne(facid);
		if(fac==null)
			return ResponseEntity.notFound().build();
		fac.setFname(facDetails.getFname());
		fac.setFdepartment(facDetails.getFdepartment());
		fac.setSalary(facDetails.getSalary());
		Faculty updateFaculty=facDAO.save(fac);
	   return ResponseEntity.ok().body(updateFaculty);
	}
	
	//delete a Faculty
	@DeleteMapping("/faculties/{id}")
	public ResponseEntity<Faculty>deleteFaculty(@PathVariable(value="id") Integer facid)
	{
		Faculty fac=facDAO.findOne(facid);
		if(fac==null)
			return ResponseEntity.notFound().build();
		facDAO.delete(fac);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/faculties/")
	public ResponseEntity<Faculty>deleteFacultyAll()
	{
		facDAO.deleteAll();
		return ResponseEntity.ok().build();
	}

}
