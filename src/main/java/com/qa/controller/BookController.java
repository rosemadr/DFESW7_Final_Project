package com.qa.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(path ="/books")
public class BookController {
	
//	private List<Book> books = new ArrayList<>(List.of(new Book(9781492077992l, 
//			"Head First Design Patterns", "Freeman","Eric", 2020 , true, "O'Reilly", "UM"), 
//			new Book(9780140237504l, "The Catcher in the Rye", "Salinger", "J.D.", 1946, false, "Penguin", "FB")));
//	
	private BookRepository bookRepo;
	
	@Autowired
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	@GetMapping
	public List<Book> getBooks() {
		return bookRepo.findAll();
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
	
	@DeleteMapping("/{isbn}")
	public void deleteByIsbn(@PathVariable("isbn") Long isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				int index = books.indexOf(book);
				Book bookToDelete = books.get(index);
				books.remove(bookToDelete);
				System.out.println(bookToDelete + " has been deleted.");
			} else {
				throw new EntityNotFoundException("Book with ISBN " + isbn + " not found");
			}
	} 
	
}
}
				
		

		


