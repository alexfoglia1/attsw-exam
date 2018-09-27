package com.alexfoglia.exam;

import java.util.ArrayList;
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
		List<Book> all = repo.findAll();
		List<Book> byAuthor = new ArrayList<>();
		all.forEach((b)->{
			if(b.getAuthor().equals(author)) {
				byAuthor.add(b);
			}
		});
		return byAuthor;
	}

	@Override
	public void addBook(String author, String title) {
		Book b = new Book();
		b.setAuthor(author);
		b.setTitle(title);
		repo.save(b);
	}

	@Override
	public void removeBook(int id) {
		repo.delete(id);
	}

	@Override
	public void removeAll() {
		repo.deleteAll();
	}

}
