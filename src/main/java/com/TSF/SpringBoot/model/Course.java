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
@Table(name="courses")
@EntityListeners(AuditingEntityListener.class)
public class Course {
 @Id
 private int cid;
@NotBlank
 private String cname;

 private int units;
 
 private int days;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getUnits() {
	return units;
}
public void setUnits(int units) {
	this.units = units;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}

 
}