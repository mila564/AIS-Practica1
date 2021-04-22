package es.code.ais.test.unitarios.linebreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import es.urjc.code.daw.library.book.LineBreaker;

public class LineBreakerTest {
	
	@Test
	public void testEmptyString() {
		testLineBreaker("", "");
	}

	@Test
	private void testLineBreaker(String originalText, String expectedText) {
		assertEquals(expectedText, new LineBreaker().breakText(originalText, 10));		
	}
	
	
}
