package com.TSF.SpringBoot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TSF.SpringBoot.model.Faculty;

public interface facultyRepository extends JpaRepository<Faculty, Integer> {

}
