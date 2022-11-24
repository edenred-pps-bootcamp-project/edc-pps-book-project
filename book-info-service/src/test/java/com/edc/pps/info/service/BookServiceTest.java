package com.edc.pps.info.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	// TODO: write a unit test with mocks

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

	@Test
	void findAll() {

		// given

		// when

		// then
	}

	@Test
	void getBooksForTitle() {

		// given

		// when

		// then
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