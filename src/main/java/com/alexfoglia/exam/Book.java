package com.alexfoglia.exam;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

public class Book {
	
	@Id
	private BigInteger id;
	
	private String author;
	
	private String title;
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setId(BigInteger id) {
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
	
	public BigInteger getId() {
		return this.id;
	}

}
