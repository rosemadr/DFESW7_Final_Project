package com.qa.data.entity;

import java.time.Year;

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
	private Long isbn; //personal stretch goal: add@pattern annotation and use regexp to confirm is valid isbn
	
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
}


