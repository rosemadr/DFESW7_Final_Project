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

	@BeforeEach
	public void init() {
		List<Book> books = List.of(
				new Book(9781492077992l, "Head First Design Patterns", "Freeman", "Eric", 2020, true, "O'Reilly", "UM"),
				new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB"));
		booksInDb.addAll(repository.saveAll(books));
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

}
