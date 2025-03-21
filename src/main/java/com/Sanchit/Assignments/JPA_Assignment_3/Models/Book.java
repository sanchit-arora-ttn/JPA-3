package com.Sanchit.Assignments.JPA_Assignment_3.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;

//    @ManyToOne
//    @JoinColumn(name = "author_id")

    @ManyToMany(mappedBy = "books")
    private List<Author> author;

    public Book(String bookName)
    {
        this.bookName=bookName;
    }
}
