package com.qa.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.entity.Book;

@RestController
@RequestMapping(path ="/books")
public class BookController {
	
	private List<Book> books = new ArrayList<>(List.of(new Book(9781492077992l, 
			"Head First Design Patterns", "Freeman","Eric", 2020 , true, "O'Reilly", "UM"), 
			new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB")));
	
	
	@GetMapping
	public List<Book> getBooks() {
		return books;
	}
	
	@RequestMapping(path ="/{isbn}", method = {RequestMethod.GET} )
	public Book getByIsbn(@PathVariable("isbn") Long isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		} throw new EntityNotFoundException("Book with ISBN " + isbn + " not found");
	} 
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}
	
	@PutMapping("/{isbn}")
	public Book updateBook(@PathVariable("isbn") Long isbn, @RequestBody Book book) {
		for (Book bookInList : books) {
			if (bookInList.getIsbn().equals(isbn)) {
				bookInList.setTitle(book.getTitle());
				bookInList.setAuthorSurname(book.getAuthorSurname());
				bookInList.setAuthorForename(book.getAuthorForename());
				bookInList.setPubYear(book.getPubYear());
				bookInList.setDigital(book.isDigital());
				bookInList.setPublisher(book.getPublisher());
				bookInList.setGenreCode(book.getGenreCode());
				
				return bookInList;
			} 
				
		} throw new EntityNotFoundException();
	}
	
}
				
		

		


