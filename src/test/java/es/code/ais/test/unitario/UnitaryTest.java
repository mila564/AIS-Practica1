package es.code.ais.test.unitario;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.urjc.code.daw.library.book.Book;
import es.urjc.code.daw.library.book.BookRepository;
import es.urjc.code.daw.library.book.BookService;
import es.urjc.code.daw.library.notification.NotificationService;

class UnitaryTest {
	
	BookRepository repository;
	NotificationService notification;
	BookService bookService;
	Book book;
	
	@BeforeEach
	public void setUp() {
		
		repository = mock(BookRepository.class);
		notification = mock(NotificationService.class);
		bookService = new BookService(repository, notification);
	    book = new Book("Cumbres Borrascosas", "libro de amor");
	    
	} 
	
	@Test
	void bookSaveUnitaryTest() {

	    Book newbook = mock(Book.class);

	    // When
	    
	    when(repository.save(book)).thenReturn(newbook);
	    when(newbook.getTitle()).thenReturn("Cumbres Borrascosas");
		
		bookService.save(book);
			
		// Then
		
		verify(repository, times(1)).save(book);
		verify(notification).notify("Book Event: book with title="+"Cumbres Borrascosas"+" was created");
			
	}
	
	@Test
	void bookDeleteUnitaryTest() {
		
		Book newbook = mock(Book.class);

	    // When
	    
		long id = 21l;
	    when(repository.save(book)).thenReturn(newbook);
	    when(newbook.getTitle()).thenReturn("Cumbres Borrascosas");
	    
		bookService.save(book);
		
		bookService.delete(id);
			
		// Then
		
		verify(repository).deleteById(id);
		verify(notification).notify("Book Event: book with id="+id+" was deleted");	
		
	}
	
}





   







