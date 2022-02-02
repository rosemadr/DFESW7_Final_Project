package com.qa.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.data.entity.Book;
import com.qa.service.BookService;

@WebMvcTest(BookController.class)
public class BookControllerWebIntegrationTests {

	@Autowired
	private BookController controller;

	@MockBean
	private BookService bookService;

	// test data
	private List<Book> books = new ArrayList<>();
	private Book bookToCreate;

	@BeforeEach
	public void init() {
		books.addAll(List.of(
				new Book(9781492077992l, "Head First Design Patterns", "Freeman", "Eric", 2020, true, "O'Reilly", "UM"),
				new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB")));
		bookToCreate = new Book(9780141182902l, "The Trail", "Kafka", "Franz", 1925, false, "Penguin", "FB");
	}

	@Test
	public void getBooksTest() {
		// given
		ResponseEntity<List<Book>> expected = new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		// when
		when(bookService.getBooks()).thenReturn(books);
		// then
		ResponseEntity<List<Book>> actual = controller.getBooks();
		assertThat(expected).isEqualTo(actual);
		// verify service called
		verify(bookService, times(1)).getBooks();
	}
}