package com.qa.data.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class BookUnitTests {

	@Test
	public void testEquals() {

		EqualsVerifier.forClass(Book.class).usingGetClass().verify();

	}

}
