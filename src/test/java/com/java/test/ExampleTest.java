package com.java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;
//import org.junit.Test;

import com.java.example.DigitToString;

class ExampleTest {

	DigitToString myObj = new DigitToString();

	@Test
	public void testResult() {
		String result = myObj.convertDigitToString(123);
		assertEquals("one hundred and twenty three", result);

	}

	@Test
	public void testForLargNum() {
		assertThrows(NumberFormatException.class, () -> {
			myObj.convertDigitToString(Integer.parseInt("9999999999"));
		});

	}
}
