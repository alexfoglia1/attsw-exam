package com.alexfoglia.exam;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoRepository extends MongoRepository<Book,BigInteger> {

}
