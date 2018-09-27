package com.alexfoglia.exam;

import org.springframework.data.annotation.Id;

public class Book {
	
	@Id
	private int id;
	
	private String author;
	
	private String title;
	
	public void setAuthor(String author) {
		this.author = author;
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

}
