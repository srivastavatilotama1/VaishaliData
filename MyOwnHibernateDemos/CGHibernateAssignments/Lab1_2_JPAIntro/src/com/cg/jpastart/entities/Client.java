package com.cg.jpastart.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Client {

	public static void main(String[] args) 
	{
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
	//	Author a1=new Author();
		
	//	a1.setFirstName("Pranil");
	//	a1.setMiddleName("P");
	//	a1.setLastName("Ashtana");
	//	a1.setPhoneNo(8744553456L);
		
		//em.persist(a1);
		
		System.out.println("Added author to database.");

		em.getTransaction().commit();
		System.out.println(" ************Find Author with id 24***********");
		
		Author aa=em.find(Author.class,24);
		System.out.println(" Get....."+aa);
		
		System.out.println("**********Get All Author Info***********");
		String qStr1 = "SELECT au FROM Author au ";
		TypedQuery<Author> query1 = em.createQuery(qStr1,Author.class);
		List<Author> authorList = query1.getResultList();
		System.out.println(authorList);

		
		System.out.println(" Get Author With author id 26********");
		
		String qStr2 = "SELECT au FROM Author au WHERE au.authorId='26' ";
		TypedQuery<Author> query2= em.createQuery(qStr2,Author.class);
		Author author = query2.getSingleResult();
		System.out.println(author);
		
		System.out.println("****************Parameterized Query**********");
		String qStr3 = "SELECT au FROM Author au WHERE au.authorId=:pid";
		TypedQuery<Author> query3 = em.createQuery(qStr3,Author.class);
		query3.setParameter("pid", 26);
		Author auu = query3.getSingleResult();
		System.out.println("*****************"+auu);
		
		System.out.println("****************Parameterized Query**********");
		String qStr4 = "SELECT au FROM Author au WHERE au.firstName=:pname";
		TypedQuery<Author> query4 = em.createQuery(qStr4,Author.class);
		query4.setParameter("pname", "Vaishali");
		Author auu4 = query4.getSingleResult();
		System.out.println("*****************"+auu4);

		System.out.println("******************name Query**************");
			
		Query  query5=em.createNamedQuery("getAllAuthors");
		List<Author> list=query5.getResultList();
		System.out.println(list);
		
		
		
		em.close();
		factory.close();
	}
}

