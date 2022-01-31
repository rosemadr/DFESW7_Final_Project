package com.qa.data.entity;

import java.time.Year;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Books")

public class Book {
	
	@Id
	@Min(999999999)
	private Long isbn; //personal stretch goal: add @pattern annotation and use regexp to confirm is valid isbn
	
	@NotNull
	private String title;
	

	@NotNull
	private String authorSurname;
	
	@PastOrPresent
	private Year pubYear;
	
	@NotNull
	private boolean isDigital;
	
	private String publisher;
	
	@Size(min = 2, max = 3, message ="Please enter a valid Thema or BIC code")
	private String genreCode;



public Book(@Min(999999999) Long isbn, @NotNull String title, @NotNull String authorSurname,
		@PastOrPresent Year pubYear, @NotNull boolean isDigital, String publisher,
		@Size(min = 2, max = 3, message = "Please enter a valid Thema or BIC code") String genreCode) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.authorSurname = authorSurname;
	this.pubYear = pubYear;
	this.isDigital = isDigital;
	this.publisher = publisher;
	this.genreCode = genreCode;
	
}


public Book() {
	super();
}


public Long getIsbn() {
	return isbn;
}


public void setIsbn(Long isbn) {
	this.isbn = isbn;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getAuthorSurname() {
	return authorSurname;
}


public void setAuthorSurname(String authorSurname) {
	this.authorSurname = authorSurname;
}


public Year getPubYear() {
	return pubYear;
}


public void setPubYear(Year pubYear) {
	this.pubYear = pubYear;
}


public boolean isDigital() {
	return isDigital;
}


public void setDigital(boolean isDigital) {
	this.isDigital = isDigital;
}


public String getPublisher() {
	return publisher;
}


public void setPublisher(String publisher) {
	this.publisher = publisher;
}


public String getGenreCode() {
	return genreCode;
}


public void setGenreCode(String genreCode) {
	this.genreCode = genreCode;
}


@Override
public String toString() {
	return "Book: ISBN: " + isbn + ", title :" + title + ", author surname: " + authorSurname + ", publication year: " + pubYear
			+ ", ebook: " + isDigital + ", publisher: " + publisher + ", genre code: " + genreCode + ".";
}


@Override
public int hashCode() {
	return Objects.hash(authorSurname, genreCode, isDigital, isbn, pubYear, publisher, title);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	return Objects.equals(authorSurname, other.authorSurname) && Objects.equals(genreCode, other.genreCode)
			&& isDigital == other.isDigital && Objects.equals(isbn, other.isbn)
			&& Objects.equals(pubYear, other.pubYear) && Objects.equals(publisher, other.publisher)
			&& Objects.equals(title, other.title);
}

}


