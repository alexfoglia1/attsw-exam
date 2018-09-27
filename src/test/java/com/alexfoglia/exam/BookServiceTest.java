package com.alexfoglia.exam;

import static org.junit.Assert.*;

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
	public void test() {
		fail("Not yet implemented");
	}

}
