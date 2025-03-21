package com.Sanchit.Assignments.JPA_Assignment_3;

import com.Sanchit.Assignments.JPA_Assignment_3.Models.Address;
import com.Sanchit.Assignments.JPA_Assignment_3.Models.Author;
import com.Sanchit.Assignments.JPA_Assignment_3.Models.Book;
import com.Sanchit.Assignments.JPA_Assignment_3.Repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootTest
@Rollback(false)
class JpaAssignment3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	void saveAuthors()
	{
		Book book = new Book("The Adventures of Tintin");
		Book book2 = new Book("Interstellar");
		Book book3 = new Book("Romeo Juliet");
		Book book4 = new Book("Star Trek");
		Book book5 = new Book("Harry Potter");
		Book book6 = new Book("Beauty and the beast");

		Address address=new Address("144/SEZ","Noida","Uttar Pradesh");
		Author author=new Author("Sanchit Arora","123456789","kr@gmail.com",
				Arrays.asList("Sci-Fi","Fantasy", "Isekai"), address, Arrays.asList(book,book2));
		authorRepository.save(author);


		Address address2=new Address("14/Alpha","Sultanpur","Uttar Pradesh");
		Author author2=new Author("Akshat Rawat","123456789","ar@gmail.com",
				Arrays.asList("Space","Fantasy", "Magic"), address2, Arrays.asList(book3,book4));
		authorRepository.save(author2);

		Address address3=new Address("44/KLZ","Noida","Uttar Pradesh");
		Author author3=new Author("Manvi Jain","123456789","mj@gmail.com",
				Arrays.asList("Sci-Fi","Satire", "Space"), address3, Arrays.asList(book5,book6));
		authorRepository.save(author3);
	}

	@Test
	@Transactional
	void saveAuthors2()
	{
		Book book = new Book("The Adventures of Tintin");
		Book book2 = new Book("Interstellar");
		Book book3 = new Book("Romeo Juliet");
		Book book4 = new Book("Star Trek");
		Book book5 = new Book("Harry Potter");
		Book book6 = new Book("Beauty and the beast");

		Address address=new Address("144/SEZ","Noida","Uttar Pradesh");
		Author author=new Author("Kunal Rawat","123456789","kr@gmail.com",
				Arrays.asList("Sci-Fi","Fantasy", "Isekai"), address, Arrays.asList(book,book2,book5,book4));
		authorRepository.save(author);


		Address address2=new Address("14/Alpha","Sultanpur","Uttar Pradesh");
		Author author2=new Author("Akshat Rawat","123456789","ar@gmail.com",
				Arrays.asList("Space","Fantasy", "Magic"), address2, Arrays.asList(book3,book4,book,book5));
		authorRepository.save(author2);

		Address address3=new Address("44/KLZ","Noida","Uttar Pradesh");
		Author author3=new Author("Manvi Jain","123456789","mj@gmail.com",
				Arrays.asList("Sci-Fi","Satire", "Space"), address3, Arrays.asList(book5,book6,book2,book4));
		authorRepository.save(author3);
	}

	@Test
	@Transactional
	 void testCache() {
		Session session = entityManager.unwrap(Session.class);

		Author author1 = session.get(Author.class, 1L);
		System.out.println("1st Query :- "+author1);

		Author author2 = session.get(Author.class, 1L);
		System.out.println("2nd Query :- "+author2);

		session.evict(author1);

		Author author3 = session.get(Author.class, 1L);
		System.out.println("1st Query after eviction :- "+author3);

		session.clear();

		Author author4 = session.get(Author.class, 1L);
		System.out.println("1st Query after clear:- "+author4);
	}

}
