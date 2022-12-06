package com.edc.pps.info.service;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.edc.pps.info.dto.BookMapper;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.exceptions.BookAlreadyExistsException;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
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
	void givenBookRequest_whenSave_thenReturnBookResponse() throws BookAlreadyExistsException {
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

	@Test
	void givenTitle_whenFindByTitle_thenReturnBookResponse(){
		Book book = new Book();
		book.setTitle("title");
		book.setAuthor("author");

		List<Book> mockBook = Arrays.asList(book);
		//Optional<Book> mockBook = Optional.of(book);

		BookResponse mockResponse = new BookResponse();
		mockResponse.setTitle("title");
		mockResponse.setAuthor("author");

		when(bookRepository.findByTitle(any()))
				.thenReturn(mockBook);
		when(bookMapper.toDto(anyList()))
				.thenReturn(List.of(mockResponse));

		List<BookResponse> actual = bookService.getBooksForTitle("title");

		assertThat(actual.get(0)).isEqualTo(mockResponse);
	}

	@Test
	void givenBookList_whenFindAll_ThenReturnBookResponse(){

		Book mockBook1 = new Book();
		mockBook1.setId(1L);
		mockBook1.setTitle("test_title");
		mockBook1.setAuthor("test_author");

		Book mockBook2 = new Book();
		mockBook2.setId(2L);
		mockBook2.setTitle("test_title2");
		mockBook2.setAuthor("test_author2");

		BookResponse response1 = new BookResponse();
		response1.setTitle("test_title");
		response1.setAuthor("test_author");

		BookResponse response2 = new BookResponse();
		response2.setTitle("test_title2");
		response2.setAuthor("test_author2");

		when(bookRepository.findAll()).thenReturn(Arrays.asList(mockBook1, mockBook2));
		when(bookMapper.toDto(anyList())).thenReturn(List.of(response1, response2));

		List<BookResponse> actual = bookService.findAll();

		assertThat(actual).hasSize(2);


	}
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