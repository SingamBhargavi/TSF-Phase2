package com.TSF.SpringBoot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TSF.SpringBoot.model.Student;

public interface studentRepository extends JpaRepository<Student, Integer> {

}
