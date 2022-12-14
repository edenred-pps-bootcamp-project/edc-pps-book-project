package com.edc.pps.info.controller;

import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.dto.rating.RatingResponse;
import com.edc.pps.info.exceptions.BadRequestException;
import com.edc.pps.info.exceptions.BookAlreadyExistsException;
import com.edc.pps.info.exceptions.BookNotFoundException;
import com.edc.pps.info.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<BookResponse> save(@RequestBody BookRequest request) throws BookAlreadyExistsException {
        return new ResponseEntity<>(bookService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable String id) throws BookNotFoundException {

        if (isNumber(id)) {
            BookResponse response = bookService.findById(Long.parseLong(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") String id) throws BookNotFoundException {

        if (isNumber(id)) {
            BookResponse response = bookService.delete(Long.parseLong(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/title={title}")
    public ResponseEntity<List<BookResponse>> getBooksForTitle(@PathVariable(name = "title") String title) {
        return new ResponseEntity<>(bookService.getBooksForTitle(title), HttpStatus.OK);
    }

    @GetMapping("/author={author}")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@PathVariable(name = "author") String author) {
        return new ResponseEntity<>(bookService.getBooksByAuthor(author), HttpStatus.OK);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> partialUpdate(
            @PathVariable(name = "id") Long id,
            @RequestBody BookRequest request) {
        BookResponse response = bookService.partialUpdate(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBooks(@RequestBody RatingResponse ratingResponse) throws BookNotFoundException {
        bookService.updateRating(ratingResponse.getBookId(), ratingResponse.getRatingValue());
        return new ResponseEntity<>(bookService.findById(ratingResponse.getBookId()),HttpStatus.OK);
    }

    public boolean isNumber(String id){
        try{
            Long.parseLong(id);
            return true;
        }catch (NumberFormatException e) {
            throw new BadRequestException("Id must be a number");
        }

    }
}
