package com.qa.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.data.entity.Book;
import com.qa.data.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepo;

	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	public Book getByIsbn(Long isbn) {
		if (bookRepo.existsById(isbn)) {
			return bookRepo.findById(isbn).get();
		}
		throw new EntityNotFoundException("Book with ISBN " + isbn + " not found");
	} // TODO develop with Optional?

	public Book createBook(Book book) {
		bookRepo.save(book);
		return book;
	}

	public Book updateBook(Long isbn, Book book) {
		if (bookRepo.existsById(isbn)) {
			Book bookInDb = bookRepo.findById(isbn).get();
			// update each field
			bookInDb.setTitle(book.getTitle());
			bookInDb.setAuthorSurname(book.getAuthorSurname());
			bookInDb.setAuthorForename(book.getAuthorForename());
			bookInDb.setPubYear(book.getPubYear());
			bookInDb.setDigital(book.isDigital());
			bookInDb.setPublisher(book.getPublisher());
			bookInDb.setGenreCode(book.getGenreCode());
			bookInDb.setIsbn(isbn);

			return bookRepo.save(bookInDb);
		} else {
			book.setIsbn(isbn);
			return bookRepo.save(book);
		}

	}

	public void deleteByIsbn(Long isbn) {
		if (bookRepo.existsById(isbn)) {
//			Book deletedBook = bookRepo.findById(isbn).get();
			bookRepo.deleteById(isbn);
//			System.out.println(deletedBook + " has been deleted.");
		} else {
			throw new EntityNotFoundException("Book with ISBN " + isbn + " not found");
		}
	}

}
