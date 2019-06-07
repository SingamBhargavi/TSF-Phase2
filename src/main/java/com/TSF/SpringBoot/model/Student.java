package com.TSF.SpringBoot.model;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="students")
@EntityListeners(AuditingEntityListener.class)
public class Student {
 @Id

 private int id;
 @NotBlank
 private String name;
 @NotBlank
 private String department;
 private int year;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

}
