package com.springBoot.Rest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Library")
public class Book  implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "Book_Id")
	private int Id;
	@Column(name = "Book_Title")
	private String title;
	@Column(name = "Book_Author")
	private String author;

	public Book(int id, String title, String author) {
		super();
		Id = id;
		this.title = title;
		this.author = author;
	}
    public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", author=" + author + "]";
	}
	
	public Book() {
		
	}
	

}
