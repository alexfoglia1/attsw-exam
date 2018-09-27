package com.alexfoglia.exam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void testFindAllWhenEmpty() {
		when(repo.findAll()).thenReturn(Arrays.asList());
		assertEquals(0,serv.findAll().size());
		verify(repo,times(1)).findAll();
	}
	
	@Test
	public void testFindAllWhenOneBookExists() {
		List<Book> expected = Arrays.asList(new Book());
		when(repo.findAll()).thenReturn(expected);
		List<Book> actual = serv.findAll();
		verify(repo,times(1)).findAll();
		assertListEquality(expected, actual);
	}

	@Test
	public void testFindAllWhenMoreBookExists() {
		List<Book> expected = Arrays.asList(new Book(),new Book(),new Book());
		when(repo.findAll()).thenReturn(expected);
		List<Book> actual = serv.findAll();
		verify(repo,times(1)).findAll();
		assertListEquality(expected, actual);
	}
	
	private void assertListEquality(List<Book> expected, List<Book> actual) {
		assertEquals(expected.size(),actual.size());
		assertSameElements(actual,expected);
		
	}
	
	private void assertSameElements(List<Book> actual, List<Book> expected) {
		int size = actual.size();
		for(int i=0; i<size; i++) {
			assertEquals(actual.get(i),expected.get(i));
		}
		
	}

}
