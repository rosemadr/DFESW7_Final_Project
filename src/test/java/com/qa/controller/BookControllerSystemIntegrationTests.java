package com.qa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.entity.Book;
import com.qa.data.repository.BookRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class BookControllerSystemIntegrationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BookRepository repository;

	// test data
	private List<Book> booksInDb = new ArrayList<>();
	private Book testBook;
	private Long testBookIsbn;
	private Book expectedTestBook;
	private Book bookUpdateInfo;

	@BeforeEach
	public void init() {
		List<Book> books = List.of(
				new Book(9781492077992l, "Head First Design Patterns", "Freeman", "Eric", 2020, true, "O'Reilly", "UM"),
				new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB"));
		booksInDb.addAll(repository.saveAll(books));
		testBook = new Book(9780141182902l, "The Trail, English Translation", "Kafka", "Franz", 1994, false, "Penguin",
				"FB");
		testBookIsbn = testBook.getIsbn();
		expectedTestBook = new Book(testBook.getIsbn(), testBook.getTitle(), testBook.getAuthorSurname(),
				testBook.getAuthorForename(), testBook.getPubYear(), testBook.isDigital(), testBook.getPublisher(),
				testBook.getGenreCode());
		bookUpdateInfo = new Book(9781492077992l, "Head First Design Patterns, Second Edition", "Freeman", "Eric", 1993,
				true, "O'Reilly", "UM");

	}

	@Test
	public void getBooksTest() throws Exception {
		// mock http request builder
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/books");
		// specifying accept header return type
		mockRequest.accept(MediaType.APPLICATION_JSON);
		// JSON string for obj mapper
		String books = objectMapper.writeValueAsString(booksInDb);
		// result matcher
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(books);
		// request and assert
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void getByIsbnTest() throws Exception {
		booksInDb.add(repository.save(testBook));
		// mock http request builder
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"/books/" + testBookIsbn);
		// specifying accept header return type
		mockRequest.accept(MediaType.APPLICATION_JSON);
		// JSON string for obj mapper
		String testBookStr = objectMapper.writeValueAsString(testBook);
		// result matcher
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(testBookStr);
		// request and assert
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void createBookTest() throws Exception {
		// test object
		Book expectedTestBook = new Book(testBook.getIsbn(), testBook.getTitle(), testBook.getAuthorSurname(),
				testBook.getAuthorForename(), testBook.getPubYear(), testBook.isDigital(), testBook.getPublisher(),
				testBook.getGenreCode());
		// mock request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/books");
		// specifying accept header return type
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(testBook));

		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedTestBook));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void updateBookTest() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
				"/books/9781492077992");
		// specifying accept header return type
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(bookUpdateInfo));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(bookUpdateInfo));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

}
