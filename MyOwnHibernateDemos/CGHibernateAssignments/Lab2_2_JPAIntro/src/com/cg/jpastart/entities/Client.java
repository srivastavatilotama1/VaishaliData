package com.cg.jpastart.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
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
		
		/*BookAuthor bookAuthor1=new BookAuthor();		
		bookAuthor1.setAuthorName("Abrahaum Link");
		
		BookAuthor bookAuthor2=new BookAuthor();		
		bookAuthor2.setAuthorName("Sunil Sharma");
		
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
		b1.setBookTitle("jQuery Head First");
		b1.setPrice(1450.00F);
		b1.setAuthors(cAuthorSet);
				
		Book b2=new Book();
		b2.setBookTitle("Pointer In C");
		b2.setPrice(234.00F);
		b2.setAuthors(javaAuthorSet);	
		em.persist(b1);
		em.persist(b2);
		*/
		System.out.println("Added book-author to database.");

		em.getTransaction().commit();
		
		System.out.println("***********Query all books in database**********");
			
		String bookQry1=" SELECT bk FROM Book bk ";
		TypedQuery<Book> query1 = em.createQuery(bookQry1,Book.class);
		List<Book> bList=query1.getResultList();
		System.out.println(bList);
		
		System.out.println("************************************");
		System.out.println("***Query all books written by given author name**********");
		String bookQry2=" select bk "+
				 		"	from  Book bk JOIN bk.authors au "+
				 				" WHERE   au.authorName =  :aName ";	
		TypedQuery<Book> query2 = em.createQuery(bookQry2,Book.class);
		query2.setParameter("aName", "Sunil Sharma");
		List<Book> bList2=query2.getResultList();
		System.out.println(bList2);
	
		System.out.println("***List all books with given price"+ 
		" range. e.g. between Rs. 500 to 1000*");
		
		String bookQry3=" select bk "+
		 		"	from  Book bk  "+
		 				" WHERE   bk.price  >=:pMin "+
		 		"  AND  bk.price  <=:pMax  ";	
		TypedQuery<Book> query3 = em.createQuery(bookQry3,Book.class);
		query3.setParameter("pMin", 100.00f);
		query3.setParameter("pMax", 1000.00f);
		List<Book> bList3=query3.getResultList();
		System.out.println(bList3);
				
		System.out.println("*******List the author name for given book id. *****");
		String bookQry4=" select au.authorName "+
		 		"	from  Book bk JOIN bk.authors au "+
		 				" WHERE   bk.isbn =  :bookId ";	
			TypedQuery<String> query4 = em.createQuery(bookQry4,String.class);
			query4.setParameter("bookId", 145);
			List<String> authorNameL=query4.getResultList();
			System.out.println(" Author Name For  book 145 Is :"+authorNameL);
			
			
	System.out.println("************************************");
	System.out.println("***Query all books written by given author name**********");
	String bookQry5=" select bk.isbn,bk.bookTitle ,bk.price, "+
					 		"	au.authorId, au.authorName  "+
			 " from  Book bk JOIN bk.authors au "+
					 " WHERE   au.authorName =  :aName ";	
	Query query5 = em.createQuery(bookQry5);
	query5.setParameter("aName", "Sunil Sharma");
	ArrayList<HashMap> data=new ArrayList<HashMap>();
	List<Object[]> bList5=query5.getResultList();	
	for(Object[] temp:bList5)
	{
		HashMap resultMap=new HashMap();
		resultMap.put("ISBN", temp[0]);
		resultMap.put("BookTitle", temp[1]);
		resultMap.put("AuthorId", temp[2]);
		resultMap.put("AuthorName", temp[3]);
		data.add(resultMap);
	}
	
	for(HashMap objj:data)
	{
		System.out.println("....."+objj);
		System.out.println(".......................");
		Set mapS=objj.entrySet();
		Iterator setIt=mapS.iterator();
		while(setIt.hasNext())
		{
			System.out.println(setIt.next());
		}
		
	}
	
		
		
		
		
		
		
		
		
		em.close();
		factory.close();
	}
}

