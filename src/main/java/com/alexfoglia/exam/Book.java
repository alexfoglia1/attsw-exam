package com.alexfoglia.exam;

import org.springframework.data.annotation.Id;

public class Book {
	
	@Id
	private Integer id;
	
	private String author;
	
	private String title;
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Integer getId() {
		return this.id;
	}

}
