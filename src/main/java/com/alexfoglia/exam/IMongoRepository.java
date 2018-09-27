package com.alexfoglia.exam;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoRepository extends MongoRepository<Book,Integer> {

}
