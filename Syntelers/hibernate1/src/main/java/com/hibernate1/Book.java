package com.hibernate1;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name = "pages")
	private Integer pages;
	
	public Book(){}

	public Book(Integer id, String title, String author, Integer year, Integer pages) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.pages = pages;
	}
	
	

	public Book(String title, String author, Integer year, Integer pages) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.pages = pages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book id= " + id + ", title= " + title + ", author= " + author + ", year= " + 
	year + ", pages= " + pages;
	}
	
	

}
