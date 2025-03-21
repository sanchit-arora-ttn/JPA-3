package com.Sanchit.Assignments.JPA_Assignment_3.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> subjects;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id",referencedColumnName = "id")

//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "author_id")

//    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_book_map",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

//    public void setBooks(List<Book> books)
//    {
//        if(books!=null)
//        {
//            if(this.books==null) this.books=new ArrayList<>();
//            this.books.addAll(books);
//            books.forEach(book -> book.setAuthor(this));
//        }
//    }

    public Author(String name, String phoneNumber, String email, List<String> subjects, Address address, List<Book> books)
    {
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.subjects=subjects;
        this.books=books;
//        this.setBooks(books);
    }
}