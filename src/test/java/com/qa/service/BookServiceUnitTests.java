package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.data.entity.Book;
import com.qa.data.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTests {

	@Mock
	private BookRepository repository;

	@InjectMocks
	private BookService bookService;

	private List<Book> books = new ArrayList<>();
	private Book testBook;
	private Long testBookIsbn;

	@BeforeEach
	public void init() {
		books.addAll(List.of(
				new Book(9781492077992l, "Head First Design Patterns", "Freeman", "Eric", 2020, true, "O'Reilly", "UM"),
				new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB")));
		testBook = new Book(9780141182902l, "The Trail, English Translation", "Kafka", "Franz", 1994, false, "Penguin",
				"FB");
		testBookIsbn = testBook.getIsbn();
	}

	@Test
	public void getBooksTest() {
		// when
		when(repository.findAll()).thenReturn(books);
		// assert
		assertThat(bookService.getBooks()).isEqualTo(books);
		// verify
		verify(repository, times(1)).findAll();
	}

	@Test
	public void getByIsbnTest() { // TODO fix test fail, entity not found
		// when
		when(repository.findById(testBookIsbn)).thenReturn(Optional.of(testBook));
		// assert
		assertThat(bookService.getByIsbn(testBookIsbn)).isEqualTo(testBook);
		// verify
		verify(repository).findById(testBookIsbn);
	}

	@Test
	public void createBook() {
		// when
		when(repository.save(testBook)).thenReturn(testBook);
		// assert
		assertThat(bookService.createBook(testBook)).isEqualTo(testBook);
		// verify
		verify(repository).save(testBook);
	}

	@Test
	public void updateBook() { // test fails? TODO
		// when
		when(repository.existsById(testBookIsbn)).thenReturn(true);
		when(repository.findById(testBookIsbn)).thenReturn(Optional.of(testBook));
		// assert
		assertThat(bookService.updateBook(testBookIsbn, testBook)).isEqualTo(testBook);
		// verify
		verify(repository, times(2)).findById(testBookIsbn).get();

	}

	@Test
	public void updateBookSave() {
		// when
		when(repository.save(testBook)).thenReturn(testBook);
		// assert
		assertThat(bookService.updateBook(testBookIsbn, testBook)).isEqualTo(testBook);
		// verify
		verify(repository).save(testBook);
	}

	@Test
	public void deleteByIsbn() {
		// when
		when(repository.existsById(testBookIsbn)).thenReturn(true);
		// assert
		bookService.deleteByIsbn(testBookIsbn);
		// verify
		verify(repository).existsById(testBookIsbn);
		verify(repository).deleteById(testBookIsbn);
	}

	@Test
	public void deleteByIsbnException() {
		when(repository.existsById(testBookIsbn)).thenReturn(false);
		// assert
		EntityNotFoundException notFound = Assertions.assertThrows(EntityNotFoundException.class, () -> {
			bookService.deleteByIsbn(testBookIsbn);
		});
		// assert
		String expectedMessage = "Book with ISBN " + testBookIsbn + " not found";
		assertThat(notFound.getMessage()).isEqualTo(expectedMessage);
		verify(repository).existsById(testBookIsbn);
	}

}
