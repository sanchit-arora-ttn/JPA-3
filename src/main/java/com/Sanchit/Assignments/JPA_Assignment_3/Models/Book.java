package com.Sanchit.Assignments.JPA_Assignment_3.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
//q5
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;
//q7
//    @ManyToOne
    // bidirectional

//    @JoinColumn(name = "author_id")
//q8
    @ManyToMany(mappedBy = "books")
    private List<Author> author;

    public Book(String bookName)
    {
        this.bookName=bookName;
    }
}
