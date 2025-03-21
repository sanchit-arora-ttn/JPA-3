package com.Sanchit.Assignments.JPA_Assignment_3.Repository;

import com.Sanchit.Assignments.JPA_Assignment_3.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
