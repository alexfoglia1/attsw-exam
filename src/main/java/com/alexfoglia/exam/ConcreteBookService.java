package com.alexfoglia.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ConcreteBookService implements BookService {

	@Autowired
	private IMongoRepository repo;
	
	public Book findOneById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Book> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Book> findAllByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBook(String author, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

}
