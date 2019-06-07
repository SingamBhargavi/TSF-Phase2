package com.TSF.SpringBoot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TSF.SpringBoot.model.Course;

public interface courseRepository extends JpaRepository<Course, Integer> {

}
