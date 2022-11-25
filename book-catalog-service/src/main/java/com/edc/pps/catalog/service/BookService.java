package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.info.BookMapper;
import com.edc.pps.catalog.dto.info.BookRequest;
import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.dto.info.BookResponseList;
import com.edc.pps.catalog.exception.BookNotFoundException;
import com.edc.pps.catalog.model.Book;
import com.edc.pps.catalog.repository.BookRepository;
import jdk.jfr.Frequency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Slf4j
@Service
public class BookService {

    private static final String INFO_RESOURCE = "http://localhost:8082/api/books";
    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Saves the new book
     *
     * @param request object of the BookRequest dto
     * @return Returns the saved book
     */
    public BookResponse save(BookRequest request) {
        log.info("saved book to db: {}", request);

        return restTemplate.postForObject(INFO_RESOURCE, request, BookResponse.class);
    }

    /**
     * Get all the books using wrapper class
     *
     * @return The list of all books
     */
    public BookResponseList findAll() {
        log.debug("getting all books...");
        return restTemplate.getForObject(INFO_RESOURCE, BookResponseList.class);
    }

    /**
     * Get book by id
     * @param id The id of the book we want to return
     * @return bookResponse
     */
    public BookResponse findById(Long id){
     *
     * @param id The id of the book we want to return
     * @return bookResponse
     */
    public BookResponse findById(Long id) {
        log.debug("finding book with id: {}", id);
        return restTemplate.getForObject(INFO_RESOURCE + "/" + id, BookResponse.class);
    }

    /**
     * Updates book with the provided id
     * @param id The id of the book we want to update
     */
    public void update(Long id, BookRequest request){
     *
     * @param id The id of the book we want to update
     */
    public void update(Long id, BookRequest request) {
        log.info("updating book");
        restTemplate.put(INFO_RESOURCE + "/" + id, request);
    }

    /**
     * Deletes the book with the provided id
     *
     * @param id The id of the book we want to delete
     * @throws BookNotFoundException throws exception it there is no book with the provided id
     */
    public void delete(Long id) throws BookNotFoundException {
        log.info("deleting book");

        Map<String, Long> params = Map.of("id", id);
        restTemplate.delete(INFO_RESOURCE + "/" + id, params);
    }
}

