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

import com.TSF.SpringBoot.model.Course;
import com.TSF.SpringBoot.model.Faculty;
import com.TSF.SpringBoot.model.dao.courseDAO;

@RestController
@RequestMapping("/institute")
public class courseController {
	@Autowired
	courseDAO crsDAO;
	
	//inserting details
	@PostMapping("/courses")
	public Course createCourse(@Valid @RequestBody Course crs)
	{
		return crsDAO.save(crs);
	}
	
	//Retrieve all Courses
	@GetMapping("/courses/")
	public List<Course> getAllCourses()
	{
		return crsDAO.findAll();
	}
	
	//retrieve by id
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable(value="id") Integer crsid)
	{
		Course crs=crsDAO.findOne(crsid);
		if(crs==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(crs);
	}
	
	//update using id
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course>updateCourse(@PathVariable(value="id") Integer crsid,@Valid @RequestBody Course crsDetails)
	{
		Course crs=crsDAO.findOne(crsid);
		if(crs==null)
			return ResponseEntity.notFound().build();
		crs.setCname(crsDetails.getCname());
		crs.setUnits(crsDetails.getUnits());
		crs.setDays(crsDetails.getDays());
		Course updateCourse=crsDAO.save(crs);
	   return ResponseEntity.ok().body(updateCourse);
	}
	
	//delete a Course
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Course>deleteCourse(@PathVariable(value="id") Integer crsid)
	{
		Course crs=crsDAO.findOne(crsid);
		if(crs==null)
			return ResponseEntity.notFound().build();
		crsDAO.delete(crs);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/courses/")
	public ResponseEntity<Faculty>deleteFacultyAll()
	{
		crsDAO.deleteAll();
		return ResponseEntity.ok().build();
	}

}
