package com.Sanchit.Assignments.JPA_Assignment_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAssignment3Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaAssignment3Application.class, args);
	}
  //Q10)What does @transactional annotation do?
	//Opens a transaction before the method starts.
	//Commits the transaction if the method completes successfully.
	//Roll back the transaction if an exception occurs.
}
