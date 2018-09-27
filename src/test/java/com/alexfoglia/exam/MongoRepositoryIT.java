package com.alexfoglia.exam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoRepositoryIT {

	@Autowired 
	private IMongoRepository repo;

	@Autowired 
	private MongoOperations mongoOps;

	@Before
	public void setUp() {
		mongoOps.dropCollection(Book.class);
	}

	@Test
	public void testSave() {
		Book toSave = new Book();
		toSave.setAuthor("test");
		toSave.setTitle("foo");
		repo.save(toSave);
		List<Book> allBooks=mongoOps.findAll(Book.class);
		assertEquals(1,allBooks.size());
		assertEquals("test",allBooks.get(0).getAuthor());
		assertEquals("foo",allBooks.get(0).getTitle());
		assertNotNull(allBooks.get(0).getId());
	}

	@Test
	public void testFindOne() {
		Book toSave = new Book();
		toSave.setAuthor("test");
		toSave.setTitle("foo");
		toSave.setId(BigInteger.valueOf(17));
		mongoOps.save(toSave);
		Book found=repo.findOne(BigInteger.valueOf(17));
		assertEquals("test",found.getAuthor());
		assertEquals("foo",found.getTitle());
		assertEquals(BigInteger.valueOf(17),found.getId());
	}

	@Test
	public void testFindAll() {
		Book b1=new Book();
		Book b2=new Book();
		b1.setId(BigInteger.valueOf(0));
		b2.setId(BigInteger.valueOf(1));
		mongoOps.save(b1);
		mongoOps.save(b2);
		List<Book> allBooks=repo.findAll();
		assertEquals(2,allBooks.size());
		assertEquals(BigInteger.valueOf(0),allBooks.get(0).getId());
		assertEquals(BigInteger.valueOf(1),allBooks.get(1).getId());
	}

}