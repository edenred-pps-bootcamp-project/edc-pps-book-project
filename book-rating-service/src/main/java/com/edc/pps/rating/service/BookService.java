package com.edc.pps.rating.service;


import com.edc.pps.rating.dto.BookResponse;
import com.edc.pps.rating.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BookService {
    private static final String BOOKS_RESOURCES = "http://localhost:8082/api/books";
    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BookResponse checkIfBookExists(long id){
        try {
            BookResponse response = restTemplate.getForObject(BOOKS_RESOURCES + "/find/" + id, BookResponse.class);
        return response;
        }catch (HttpClientErrorException exception){
            throw new BookNotFoundException("No book with ID: " + id);
        }
    }

    public void callForUpdateRating(long id){
        restTemplate.put(BOOKS_RESOURCES+"/"+id, BookResponse.class);
    }

}