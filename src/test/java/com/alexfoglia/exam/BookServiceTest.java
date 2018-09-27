package com.alexfoglia.exam;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BookServiceTest {

	@Mock
	private IMongoRepository repo;
	
	@InjectMocks
	private ConcreteBookService serv;
	
	@Test
	public void testFindBookByIdWhenEmpty() {
		when(repo.findOne(0)).thenReturn(null);
		assertNull(serv.findOneById(0));
		verify(repo,times(1)).findOne(0);
	}
	
	@Test
	public void testFindBookByIdWhenItExists() {
		Book b = new Book();
		when(repo.findOne(0)).thenReturn(b);
		assertEquals(b,serv.findOneById(0));
		verify(repo,times(1)).findOne(0);
	}
	
	

}
