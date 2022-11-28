package com.edc.pps.info.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.edc.pps.info.dto.BookMapper;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {


	@Mock
	private BookRepository bookRepository;

	@Mock
	private BookMapper bookMapper;

	@InjectMocks
	private BookService bookService;

	@Test
	void givenBookRequest_whenSave_thenReturnBookResponse(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setAuthor("author");
		bookRequest.setTitle("title");

		List<Book> mockBooks = new ArrayList<>();
		Book book = new Book();
		book.setAuthor("author");
		book.setTitle("title");
		mockBooks.add(book);

		BookResponse expected = new BookResponse();
		expected.setAuthor("author");
		expected.setTitle("title");

		when(bookMapper.toEntity(any(BookRequest.class)))
				.thenReturn(book);
		when(bookRepository.save(any(Book.class)))
				.thenReturn(book);
		when(bookMapper.toDto(any(Book.class)))
				.thenReturn(expected);

		BookResponse actual = bookService.save(bookRequest);

		assertThat(actual).isEqualTo(expected);
	}

//	@Test
//	void givenBookList_whenFindAll_ThenReturnBookResponse(){
//		Book mockB1 = new Book();
//		mockB1.setTitle("title1");
//		mockB1.setAuthor("author1");
//		bookRepository.save(mockB1);
//
//		Book mockB2 = new Book();
//		mockB2.setTitle("title2");
//		mockB2.setAuthor("author2");
//		bookRepository.save(mockB2);
//
//		List<Book> expected = new ArrayList<>();
//		expected.add(mockB1);
//		expected.add(mockB2);
//
//		List<Book> actual = bookRepository.findAll();
//
//		assertEquals(expected, actual);
//	}

//	@Test
//	void givenTitle_whenFindByTitle_thenReturnBookResponse(){
//		Book book = new Book();
//		book.setTitle("title");
//		book.setAuthor("author");
//
//		Optional<Book> mockBook = Optional.of(book);
//
//		BookResponse mockResponse = new BookResponse();
//		mockResponse.setTitle("title");
//		mockResponse.setAuthor("author");
//
//		when(bookRepository.findByTitle(anyString()))
//				.thenReturn(mockBook);
//		when(bookMapper.toDto(any(Book.class)))
//				.thenReturn(mockResponse);
//
//		BookResponse actual = bookService.getBooksForTitle();
//
//		assertThat(actual).isEqualTo(mockResponse);
//	}

	@Test
	void updateTitle() {

		// given

		// when

		// then
	}

	@Test
	void updateAuthor() {

		// given

		// when

		// then
	}

	@Test
	void delete() {

		// given

		// when

		// then
	}

	@Test
	void getBooksByAuthor() {

		// given

		// when

		// then
	}
}