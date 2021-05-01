package es.code.ais.test.unitarios.linebreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	public void testWordsLengthEqualsLineLengthAndMoreThanOneSpace() {
		testLineBreaker("test  test", "test\ntest", 4);
	}
	
	@Test 
	public void testWordsLengthGreaterLineLengthAndMoreThanOneSpace() {
		testLineBreaker("test   test", "test\ntest", 6);
	}
	
	@Test
	public void test2WordsConcatenationNeedPartition() {
		testLineBreaker("testtest", "test-\ntest", 5);
	}
	
	@Test
	public void test3WordsConcatenationNeedPartition() {
		testLineBreaker("testtesttest", "test-\ntest-\ntest", 5);
	}
	
	@Test
	public void testWordsLengthGreaterThanLineLengtNeedPartition() {
		testLineBreaker("test test", "te-\nst\nte-\nst", 3);
	}
	
	@Test
	public void testMixWordsLengthGreaterThanLineLengtConcatenationNeedPartition() {
		testLineBreaker("test 1234567 test", "test\n12345-\n67\ntest", 6);
	}
	
	@Test
	public void testNumbersLengthGreaterThanLineLengtNeedPartition() {
		testLineBreaker("123456789", "12-\n34-\n56-\n789", 3);
	}
	
	@Test
	public void testLineLengthLessThan2throwException() {
		assertThrows(RuntimeException.class, ()->{
			LineBreaker.breakLine("",  1);
        });
	}
	
	@Test
	private void testLineBreaker(String originalText, String expectedText, int lineLength) {
		assertEquals(expectedText, LineBreaker.breakLine(originalText, lineLength));		
	}
	
}
