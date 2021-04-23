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
	public void testLongitudCadenaIgualLength() {
		testLineBreaker("test", "test", 4);
	}
	
	@Test
	public void testLongitudCadenaMayorLength() {
		testLineBreaker("test", "test", 5);
	}
	
	@Test
	public void testDosPalabrasLongitudPalabraIgualLength() {
		testLineBreaker("test test", "test\ntest", 4);
	}
	
	@Test
	private void testLineBreaker(String originalText, String expectedText, int lineLength) {
		assertEquals(expectedText, new LineBreaker().breakText(originalText, lineLength));		
	}
	
	
}
