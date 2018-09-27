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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BookServiceTest {

	@Mock
	private IMongoRepository repo;
	
	@InjectMocks
	private ConcreteBookService serv;
	
	@Captor
	private ArgumentCaptor<Book> captor;
	
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
	
	@Test
	public void testFindAllByAuthorWhenEmpty() {
		when(repo.findAll()).thenReturn(Arrays.asList());
		assertEquals(0,serv.findAllByAuthor("test").size());
		verify(repo,times(1)).findAll();
	}
	
	@Test
	public void testFindAllByAuthorWhenThatAuthorDoesNotExists() {
		Book b = new Book();
		b.setAuthor("foo");
		when(repo.findAll()).thenReturn(Arrays.asList(b));
		assertEquals(0,serv.findAllByAuthor("test").size());
		verify(repo,times(1)).findAll();
	}
	@Test
	public void testFindAllByAuthorWhenOneBookExists() {
		Book b = new Book();
		b.setAuthor("test");
		List<Book> expected = Arrays.asList(b);
		when(repo.findAll()).thenReturn(expected);
		List<Book> actual = serv.findAllByAuthor("test");
		verify(repo,times(1)).findAll();
		assertListEquality(expected, actual);
	}

	@Test
	public void testFindAllByAuthorWhenMoreBookExists() {
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		b1.setAuthor("test");
		b2.setAuthor("test");
		b3.setAuthor("foo");
		List<Book> expected = Arrays.asList(b1,b2);
		when(repo.findAll()).thenReturn(Arrays.asList(b1,b2,b3));
		List<Book> actual = serv.findAllByAuthor("test");
		verify(repo,times(1)).findAll();
		assertListEquality(expected, actual);
	}
	
	@Test
	public void testAddBook() {
		serv.addBook("test", "foo");
		verify(repo,times(1)).save(captor.capture());
		Book added = captor.getValue();
		assertEquals("test",added.getAuthor());
		assertEquals("foo",added.getTitle());
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
