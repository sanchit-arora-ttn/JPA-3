package com.Sanchit.Assignments.JPA_Assignment_3.Repository;

import com.Sanchit.Assignments.JPA_Assignment_3.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
