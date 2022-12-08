package com.edc.pps.info.controller;

import com.edc.pps.info.BookInfoApp;
import com.edc.pps.info.config.H2TestProfileJpaConfig;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.exceptions.BookAlreadyExistsException;
import com.edc.pps.info.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {BookInfoApp.class, H2TestProfileJpaConfig.class}
)
class ControllerMockMvcIntegrationTest {
    @LocalServerPort
    private static final int port = 8082;

    private static final String API_BOOKS = "/books";
    private static final String BASE_URI = "http://localhost:" + port + "/api";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp(){
    }

    @Test
    void create(){
    }

    @Test
    void givenRequest_whenFindAll_thenReturn200() throws Exception{
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("test_title");
        bookRequest.setAuthor("test_author");

        BookResponse bookResponse;
        try {
            bookResponse = bookService.save(bookRequest);
        } catch (BookAlreadyExistsException e) {
            throw new RuntimeException(e);
        }

        mockMvc.perform(
                MockMvcRequestBuilders.get(BASE_URI + "/" + API_BOOKS + "/find/" + bookResponse.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{" +
                                String.format("\"id\":%s,", bookResponse.getId().toString()) +
                                String.format("\"title\":\"%s\",", bookRequest.getTitle()) +
                                String.format("\"author\":\"%s\",", bookRequest.getAuthor()) +
                                "\"averageRating\":null" +
                                "}"));

        bookService.delete(bookResponse.getId());
    }

//    @Test
//    void givenRequest_whenFindById_ReturnBookResponse() throws Exception {
//        BookRequest bookRequest = new BookRequest();
//        bookRequest.setTitle("test_title");
//        bookRequest.setAuthor("test_author");
//
//        BookResponse bookResponse;
//        try {
//            bookResponse = bookService.save(bookRequest);
//        } catch (BookAlreadyExistsException e) {
//            throw new RuntimeException(e);
//        }
//        mockMvc.perform(
//                        MockMvcRequestBuilders.get(BASE_URI + "/" + API_BOOKS + "/find/" + bookResponse.getId()))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content());
//
//        bookService.delete(bookResponse.getId());
//    }
}
