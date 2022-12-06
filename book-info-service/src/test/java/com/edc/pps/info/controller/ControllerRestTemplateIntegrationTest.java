package com.edc.pps.info.controller;

import com.edc.pps.info.config.H2TestProfileJpaConfig;
import com.edc.pps.info.config.SpringTestingApplication;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.exceptions.BookAlreadyExistsException;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import com.edc.pps.info.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {SpringTestingApplication.class, H2TestProfileJpaConfig.class}
)
public class ControllerRestTemplateIntegrationTest {

    @LocalServerPort
    static final int port = 8082;
    static final String API_BOOKS = "/books";
    static final String BASE_URI = "http://localhost:" + port + "/api";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void create(){
    }

    @Test
    void givenRequest_whenFindAll_thenReturn200() throws BookAlreadyExistsException {
        Book book = new Book();
        book.setTitle("test_title");
        book.setAuthor("test_author");
        bookRepository.save(book);
        String url = BASE_URI + API_BOOKS;
        System.out.println(BASE_URI);
        System.out.println(API_BOOKS);
        System.out.println(url);
//        ResponseEntity<List<BookResponse>> response = restTemplate.exchange(
//                BASE_URI + API_BOOKS, HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<BookResponse>>(){});
//
//        assertEquals(200, response.getStatusCode().value());
//        assertThat(response.getBody().get(0).getTitle()).isEqualTo("test_title");
    }
}
