package com.alexfoglia.exam;

import java.util.List;

public interface BookService {
	
	public Book findOneById(int id);
	
	public List<Book> findAll();
	
	public List<Book> findAllByAuthor(String author);
	
	public void addBook(String author, String title);
	
	public void removeBook(int id);
	
	public void removeAll();
	
}
