package com.edc.pps.info.service;

import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookServiceIntegrationTest {

    @InjectMocks
    private BookService bookService;

//    @Test
//    void givenBookRequest_whenSave_thenReturnBookResponse(){
//
//        BookRequest request = new BookRequest();
//        request.setTitle("title");
//        request.setAuthor("author");
//
//        BookResponse expected = new BookResponse();
//        //expected.setId(1L);
//        expected.setTitle("title");
//        expected.setAuthor("author");
//
//        BookResponse actual = bookService.save(request);
//
//        assertThat(actual).isEqualTo(expected);
//    }
//    @Test
//    void givenExistingBook_whenSave_thenThrowException(){
//
//        BookRequest bookRequest = new BookRequest();
//        bookRequest.setTitle("title");
//        bookRequest.setAuthor("author");
//
//        bookService.save(bookRequest);
//
//        Assertions.assertThrows(RuntimeException.class,
//                () -> bookService.save(bookRequest));
//    }
}
