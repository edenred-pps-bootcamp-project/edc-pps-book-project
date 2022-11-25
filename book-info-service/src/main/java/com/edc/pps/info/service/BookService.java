package com.edc.pps.info.service;

import java.util.List;
import java.util.Optional;


import com.edc.pps.info.dto.BookMapper;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.exceptions.BookNotFoundException;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    /**
     * Saves the new book
     * @param request object of the BookRequest dto
     * @return Returns the saved book
     */
    public BookResponse save(BookRequest request) {
        log.info("saved book to db: {}", request);

        List<Book> bookList = bookRepository.findAll();
        Book book = bookMapper.toEntity(request);

        if (bookList.stream()
                .filter(entry -> entry.getTitle().equals(request.getTitle()) && entry.getAuthor().equals(request.getAuthor()))
                .count() == 0) {
            bookRepository.save(book);
        }
        return bookMapper.toDto(book);
    }

    /**
     * Get all the books
     * @return The list of all books
     */
    public List<BookResponse> findAll() {
        log.debug("getting all books...");
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDto(books);
    }

    /**
     * Get all the books filtered by title
     * @param title Title of the book
     * @return The books with the requested title
     */
    public List<BookResponse> getBooksForTitle(String title) {
        log.debug("getting all books with title {}",title);
        List<Book> bookList = bookRepository.findByTitle(title);
        return bookMapper.toDto(bookList);
    }

    /**
     * Get all ratings for the requested book
     * @param title Title of the book
     */
//    public void displayRatings(String title) {
//        Book book = searchByTitle(title);
//        getRatings().stream()
//                .forEach(rating -> System.out.println(rating.getRating()));
//    }

    /**
     * Changes the title of the requested book
     * @param request The book whose title we want to change
     * @param newTitle The new title wanted
     */
    public void updateTitle(BookRequest request, String newTitle) {
        Book foundBook = bookRepository.findByTitleAndAuthor(request.getTitle(),request.getAuthor());
        foundBook.setTitle(newTitle);
        bookRepository.save(foundBook);
    }

    /**
     * Updates the author of the requested book
     * @param request The book whose author we want to update
     * @param newAuthor The new author wanted
     */
    public void updateAuthor(BookRequest request, String newAuthor) {
        Book foundBook = bookRepository.findByTitleAndAuthor(request.getTitle(),request.getAuthor());
        foundBook.setAuthor(newAuthor);
        bookRepository.save(foundBook);
    }

    /**
     * Deletes the book with the provided id
     * @param id The id of the book we want to delete
     * @throws BookNotFoundException throws exception it there is no book with the provided id
     */
    public void delete(Long id) {
        try {
            Book foundBook = bookRepository.findById(id).orElseThrow( () ->  new BookNotFoundException("no book with id: " + id));
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
        log.debug("deleting book with id: {}", id);
        bookRepository.deleteById(id);

    }

    /**
     * Return author's book list
     * @param author The author of the books we want to return
     * @return The list of the author's books
     */
    public List<BookResponse> getBooksByAuthor(String author) {
        log.debug("getting all books by author {}",author);
        List<Book> bookList = bookRepository.findByAuthor(author);
        return bookMapper.toDto(bookList);

    }

    /**
     * Get the average rating for the book requested
     * @param bookId The id of the book we want to get the average
     */
//    public void getAverageRating(long bookId) {
//        int count = 0;
//        double ratingTotal = 0;
//
//        for (Book book : getBookList()) {
//            if (book.getId() == bookId) {
//                for (Rating rating : ratings) {
//                    if (book.getId() == rating.getRatingId()) {
//                        count++;
//                        ratingTotal += rating.getRating();
//                    }
//                }
//                book.setAverageRating(ratingTotal / count);
//                return;
//            }
//        }
//        throw new RuntimeException("This book has no ratings.");
//    }

}

