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
@Table(name="faculties")
@EntityListeners(AuditingEntityListener.class)
public class Faculty {
 @Id
 private int fid;
 @NotBlank
 private String fname;
 @NotBlank
 private String fdepartment;
 
 private int salary;
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getFdepartment() {
	return fdepartment;
}
public void setFdepartment(String fdepartment) {
	this.fdepartment = fdepartment;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
 }
