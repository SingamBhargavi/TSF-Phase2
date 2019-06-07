package com.TSF.SpringBoot.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TSF.SpringBoot.model.Course;
import com.TSF.SpringBoot.model.repository.courseRepository;


@Service
public class courseDAO {
@Autowired
courseRepository crsrep;

//insert Courses
public Course save(Course crs)
{
	return crsrep.save(crs);
}

// retrieve all Courses
public List<Course> findAll()
{
	return crsrep.findAll();
}

//retrieve Course by id
public Course findOne(Integer crsid)
{
	return crsrep.findOne(crsid);
}

//delete Course
public void delete(Course crs)
{
	crsrep.delete(crs);
}
public void deleteAll()
{
	crsrep.deleteAll();
}
}
