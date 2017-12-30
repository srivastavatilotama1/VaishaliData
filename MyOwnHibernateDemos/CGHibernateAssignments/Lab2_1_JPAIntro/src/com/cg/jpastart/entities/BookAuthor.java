package com.cg.jpastart.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//By Default name of the  table column should be 
// same as name of the property of bean class.

@Entity
@Table(name="BookAuthor")
public class BookAuthor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="author_id")
	private int authorId;	
	
	@Column(name="author_name")
	private String authorName;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="authors")
	private Set<Book> bookList = new HashSet<>();

	public Set<Book> getBookList() {
		return bookList;
	}
	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "BookAuthor [authorId=" + authorId + ", authorName="
				+ authorName + "]";
	}

	

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}	
	
}

