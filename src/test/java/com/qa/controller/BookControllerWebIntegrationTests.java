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
import org.springframework.http.HttpHeaders;
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
	private Book testBook;
	private Book bookUpdateInfo;
	private Book updatedTestBook;
	private Long updatedBookIsbn;

	@BeforeEach
	public void init() {
		books.addAll(List.of(
				new Book(9781492077992l, "Head First Design Patterns", "Freeman", "Eric", 2020, true, "O'Reilly", "UM"),
				new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB")));
		testBook = new Book(9780141182902l, "The Trail", "Kafka", "Franz", 1925, false, "Penguin", "FB");
		updatedTestBook = new Book(9780141182902l, "The Trail, English Translation", "Kafka", "Franz", 1994, false,
				"Penguin", "FB");
		bookUpdateInfo = new Book("The Trail, English Translation", "Kafka", "Franz", 1994, false, "Penguin", "FB");
		updatedBookIsbn = 9780141182902l;
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

	@Test
	public void getByIsbnTest() {
		// given
		ResponseEntity<Book> expected = ResponseEntity.status(HttpStatus.OK).body(testBook);
		// when
		when(bookService.getByIsbn(9780141182902l)).thenReturn(testBook);
		// then
		ResponseEntity<Book> actual = controller.getByIsbn(9780141182902l);
		assertThat(expected).isEqualTo(actual);
		// verify service called
		verify(bookService, times(1)).getByIsbn(9780141182902l);
	}

	@Test
	public void createBookTest() {
		// given
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/books/9780141182902");
		ResponseEntity<Book> expected = new ResponseEntity<Book>(testBook, headers, HttpStatus.CREATED);
		// when
		when(bookService.createBook(testBook)).thenReturn(testBook);
		// then
		ResponseEntity<Book> actual = controller.createBook(testBook);
		assertThat(expected).isEqualTo(actual);
		// verify service called
		verify(bookService, times(1)).createBook(testBook);
	}

	@Test
	public void updateBookTest() {
		// given
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/books/" + updatedBookIsbn);
		ResponseEntity<Book> expected = new ResponseEntity<Book>(updatedTestBook, headers, HttpStatus.ACCEPTED);
		// when
		when(bookService.updateBook(updatedBookIsbn, bookUpdateInfo)).thenReturn(updatedTestBook);
		// then
		ResponseEntity<Book> actual = controller.updateBook(updatedBookIsbn, bookUpdateInfo);
		assertThat(expected).isEqualTo(actual);
		// verify
		verify(bookService, times(1)).updateBook(updatedBookIsbn, bookUpdateInfo);

	}

	@Test
	public void deleteByIsbnTest() {
		// given
		ResponseEntity<?> expected = ResponseEntity.status(HttpStatus.ACCEPTED).build();
		// then
		ResponseEntity<?> actual = controller.deleteByIsbn(updatedBookIsbn);
		assertThat(expected).isEqualTo(actual);
		// verify
		verify(bookService, times(1)).deleteByIsbn(updatedBookIsbn);
	}
}