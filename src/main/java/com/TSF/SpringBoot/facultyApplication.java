package com.TSF.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class facultyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  SpringApplication.run(facultyApplication.class, args);
	}

}
