package es.code.ais.test.unitarios.linebreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import es.urjc.code.daw.library.book.LineBreaker;

public class LineBreakerTest {
	
	@Test
	public void testEmptyString() {
		testLineBreaker("", "", 2);
	}
	
	@Test
	public void testWordLengthEqualsLineLength() {
		testLineBreaker("test", "test", 4);
	}
	
	@Test
	public void testWordLengthGreaterThanLineLength() {
		testLineBreaker("test", "test", 5);
	}
	
	@Test
	public void testWordsLengthEqualsLineLength() {
		testLineBreaker("test test", "test\ntest", 4);
	}
	
	@Test
	public void testWordsLength1UnitGreaterThanLineLength() {
		testLineBreaker("test test", "test\ntest", 5);
	}
	
	@Test
	public void testWordsLength2UnitsGreaterThanLineLength() {
		testLineBreaker("test test", "test\ntest", 6);
	}
	
	@Test
	public void testWordsLength2EqualsLineLength() {
		testLineBreaker("test test test test", "test test\ntest test", 9);
	}
	
	@Test
	private void testLineBreaker(String originalText, String expectedText, int lineLength) {
		assertEquals(expectedText, new LineBreaker().breakText(originalText, lineLength));		
	}
	
}
