package com.TSF.SpringBoot.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TSF.SpringBoot.model.Student;
import com.TSF.SpringBoot.model.repository.studentRepository;


@Service
public class studentDAO {
@Autowired
studentRepository stdrep;

//insert students
public Student save(Student std)
{
	return stdrep.save(std);
}

// retrieve all students
public List<Student> findAll()
{
	return stdrep.findAll();
}

//retrieve student by id
public Student findOne(Integer stdid)
{
	return stdrep.findOne(stdid);
}

//delete student
public void delete(Student std)
{
	stdrep.delete(std);
}
// delete all students
public void deleteAll()
{
	stdrep.deleteAll();
}
}
