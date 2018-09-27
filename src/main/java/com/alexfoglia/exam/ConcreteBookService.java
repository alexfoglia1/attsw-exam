package com.alexfoglia.exam;

import org.springframework.beans.factory.annotation.Autowired;

public class ConcreteBookService implements BookService {

	@Autowired
	private IMongoRepository repo;
	
	public Book findOneById(int id) {
		return repo.findOne(id);
	}

}
