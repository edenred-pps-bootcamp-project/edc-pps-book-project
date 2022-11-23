package com.edc.pps.catalog.controller;


import com.edc.pps.catalog.dto.info.BookRequest;
import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.exception.BookNotFoundException;
import com.edc.pps.catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("api/books")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody BookRequest request) {
        return new ResponseEntity<>(bookService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) throws BookNotFoundException {
        try {
            bookService.delete(id);
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<BookResponse>> getBooksForTitle(@PathVariable(name = "title") String title) {
        return new ResponseEntity<>(bookService.getBooksForTitle(title), HttpStatus.OK);
    }
}
