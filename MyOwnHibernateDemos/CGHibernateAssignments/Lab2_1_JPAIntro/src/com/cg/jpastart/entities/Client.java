package com.cg.jpastart.entities;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) 
	{
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		BookAuthor bookAuthor1=new BookAuthor();		
		bookAuthor1.setAuthorName("Herbert Schield");
		
		BookAuthor bookAuthor2=new BookAuthor();		
		bookAuthor2.setAuthorName("Aarti Shaha");
		
		BookAuthor bookAuthor3=new BookAuthor();		
		bookAuthor3.setAuthorName("Yeshwant Kanetkar");
				
		BookAuthor bookAuthor4=new BookAuthor();		
		bookAuthor4.setAuthorName("John Lee");
		
		HashSet<BookAuthor> javaAuthorSet=new HashSet<BookAuthor>();
		javaAuthorSet.add(bookAuthor1);
		javaAuthorSet.add(bookAuthor2);
		
		HashSet<BookAuthor> cAuthorSet=new HashSet<BookAuthor>();
		cAuthorSet.add(bookAuthor3);
		cAuthorSet.add(bookAuthor4);
		
		Book b1=new Book();
		b1.setBookTitle("Let Us C");
		b1.setPrice(450.00F);
		b1.setAuthors(cAuthorSet);
				
		Book b2=new Book();
		b2.setBookTitle("Java Complete Reference");
		b2.setPrice(890.00F);
		b2.setAuthors(javaAuthorSet);	
		em.persist(b1);
		em.persist(b2);
		
		System.out.println("Added book-author to database.");

		em.getTransaction().commit();
				
		em.close();
		factory.close();
	}
}

