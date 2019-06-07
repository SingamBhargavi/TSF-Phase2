package com.TSF.SpringBoot.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TSF.SpringBoot.model.Faculty;
import com.TSF.SpringBoot.model.repository.facultyRepository;


@Service
public class facultyDAO {
@Autowired
facultyRepository facrep;

//insert students
public Faculty save(Faculty fac)
{
	return facrep.save(fac);
}

// retrieve all students
public List<Faculty> findAll()
{
	return facrep.findAll();
}

//retrieve student by id
public Faculty findOne(Integer facid)
{
	return facrep.findOne(facid);
}

//delete student
public void delete(Faculty facid)
{
	facrep.delete(facid);
}
public void deleteAll()
{
	facrep.deleteAll();
}
}
