package com.cg.jpastart.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_isbn")
	private int isbn;	
	
	@Column(name="book_title")
	private String bookTitle;	
	
	@Column(name="book_price")
	private float price;
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Book_Author", 
	joinColumns = { @JoinColumn(name = "book_isbn") }, 
	inverseJoinColumns = { @JoinColumn(name = "author_id") }
	)
	private Set<BookAuthor> authors = new HashSet<>();

	public Set<BookAuthor> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<BookAuthor> authors) {
		this.authors = authors;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookTitle=" + bookTitle + ", price="
				+ price + "]";
	}

	
	
}
