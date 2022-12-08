package com.edc.pps.info.service;

import com.edc.pps.info.dto.BookMapper;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.dto.rating.RatingResponse;
import com.edc.pps.info.exceptions.BadRequestException;
import com.edc.pps.info.exceptions.BookAlreadyExistsException;
import com.edc.pps.info.exceptions.BookNotFoundException;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class BookService {

    private static final String RATING_RESOURCE = "http://localhost:7601/api/ratings/average/";
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final RestTemplate client;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper, RestTemplate client) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.client = client;
    }

    /**
     * Saves the new book
     *
     * @param request object of the BookRequest dto
     * @return Returns the saved book
     */
    public BookResponse save(BookRequest request) throws BookAlreadyExistsException {
        log.info("saved book to db: {}", request);
        Book book = bookMapper.toEntity(request);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            throw new BookAlreadyExistsException("Book already exists");
        }
        return bookMapper.toDto(book);
    }

    /**
     * Get all the books
     *
     * @return The list of all books
     */
    public List<BookResponse> findAll() {
        log.debug("getting all books...");
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDto(books);
    }

    /**
     * Get all the books filtered by title
     *
     * @param title Title of the book
     * @return The books with the requested title
     */
    public List<BookResponse> getBooksForTitle(String title) {
        log.debug("getting all books with title {}", title);
        List<Book> bookList = bookRepository.findByTitle(title);
        if (bookList.size() == 0) try {
            throw new BookNotFoundException("No book with title: \"" + title + "\"");
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bookMapper.toDto(bookList);
    }

    /**
     * Return author's book list
     *
     * @param author The author of the books we want to return
     * @return The list of the author's books
     */
    public List<BookResponse> getBooksByAuthor(String author) {
        log.debug("getting all books by author {}", author);
        List<Book> bookList = bookRepository.findByAuthor(author);
        if (bookList.size() == 0) try {
            throw new BookNotFoundException("No book with author: " + author);
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bookMapper.toDto(bookList);
    }

    public BookResponse findById(Long bookId) throws BookNotFoundException {
        try {
            Book actualBook = bookRepository.findById(bookId).get();
            return bookMapper.toDto(actualBook);
        }catch (Exception e) {
            throw new BookNotFoundException("No book with id " + bookId);
        }

    }

    /**
     * Updates the author of the requested book
     *
     * @param request   The book whose author we want to update
     * @param newAuthor The new author wanted
     */
    public void updateAuthor(BookRequest request, String newAuthor) {
        Book foundBook = bookRepository.findByTitleAndAuthor(request.getTitle(), request.getAuthor());
        foundBook.setAuthor(newAuthor);
        bookRepository.save(foundBook);
    }
    
    /**
     * Deletes the book with the provided id
     *
     * @param id The id of the book we want to delete
     * @throws BookNotFoundException throws exception if there is no book with the provided id
     */
    public void delete(Long id) {
        try {
            Book foundBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("No book with id: " + id));
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        log.debug("deleting book with id: {}", id);
        bookRepository.deleteById(id);
    }

    private boolean validateRequest(BookRequest request) {
        if (request.getTitle() == null) {
            log.info("Title cannot be null: \n" + request.toString());
            throw new BadRequestException("Add a title");
        }
        if (request.getAuthor() == null) {
            log.info("Author cannot be null: \n" + request.toString());
            throw new BadRequestException("Add an author");
        }
        return true;
    }

    /**
     * Get the average rating for the book requested
     *
     * @param bookId The id of the book we want to get the average
     */
    public RatingResponse getAverageRating(Long bookId) {
        try {
            return Arrays.asList(client.getForObject(RATING_RESOURCE + bookId, RatingResponse[].class)).get(0);
        } catch(Exception e){
            return null;
        }
    }

    public void updateRating(Long bookId, Double average) throws BookNotFoundException {
        Book actualBook = bookRepository.findById(bookId).get();
        actualBook.setAverageRating(average);
        bookRepository.save(actualBook);
    }

}


