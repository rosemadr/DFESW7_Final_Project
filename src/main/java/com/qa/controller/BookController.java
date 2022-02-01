package com.qa.controller;

//import java.time.Year;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.entity.Book;
import com.qa.data.repository.BookRepository;
import com.qa.service.BookService;

@RestController
@RequestMapping(path = "/books")
public class BookController {

//	private List<Book> books = new ArrayList<>(List.of(new Book(9781492077992l, 
//			"Head First Design Patterns", "Freeman","Eric", 2020 , true, "O'Reilly", "UM"), 
//			new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB")));
//	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.ok(bookService.getBooks());
	}

	@RequestMapping(path = "/{isbn}", method = { RequestMethod.GET })
	public ResponseEntity<Book> getByIsbn(@PathVariable("isbn") Long isbn) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getByIsbn(isbn));
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/books/" + String.valueOf(book.getIsbn()));
		
		return new ResponseEntity<Book>(bookService.createBook(book), headers, HttpStatus.CREATED);
	}

	@PutMapping("/{isbn}")
	public ResponseEntity<Book> updateBook(@PathVariable("isbn") Long isbn, @Valid @RequestBody Book book) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/books/" + String.valueOf(isbn));
		
		return new ResponseEntity<Book>(bookService.updateBook(isbn, book), headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{isbn}")
	public ResponseEntity<?> deleteByIsbn(@PathVariable("isbn") Long isbn) {
		bookService.deleteByIsbn(isbn);
		return ResponseEntity.accepted().build();
	}
}