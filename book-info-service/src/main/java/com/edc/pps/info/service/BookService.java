package com.edc.pps.info.service;

import com.edc.pps.info.dto.BookMapper;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.dto.BookResponse;
import com.edc.pps.info.exceptions.BookNotFoundException;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public BookResponse save(BookRequest request) {
        log.info("saved book to db: {}", request);

        List<Book> bookList = bookRepository.findAll();
        Book book = bookMapper.toEntity(request);

        if (bookList.stream()
                .filter(entry -> entry.getTitle() == request.getTitle() && entry.getAuthor() == request.getAuthor())
                .count() == 0) {
            bookRepository.save(book);
        }
        return bookMapper.toDto(book);
    }

    public List<BookResponse> findAll() {
        log.debug("getting all books...");
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDto(books);
    }
    public List<BookResponse> getBooksForTitle(String title) {
        log.debug("getting all books with title {}",title);
        List<Book> bookList = bookRepository.findByTitle(title);
        return bookMapper.toDto(bookList);
    }


//    public void displayRatings(String title) {
//        Book book = searchByTitle(title);
//        getRatings().stream()
//                .forEach(rating -> System.out.println(rating.getRating()));
//    }

    public void updateTitle(BookRequest request, String newTitle) {
        Book foundBook = bookRepository.findByTitleAndAuthor(request.getTitle(),request.getAuthor());
        foundBook.setTitle(newTitle);
        bookRepository.save(foundBook);
    }

    public void updateAuthor(BookRequest request, String newAuthor) {
        Book foundBook = bookRepository.findByTitleAndAuthor(request.getTitle(),request.getAuthor());
        foundBook.setAuthor(newAuthor);
        bookRepository.save(foundBook);
    }

    public void delete(Long id) throws BookNotFoundException {
        Optional<Book> foundBook = bookRepository.findById(id);
        if (foundBook.isEmpty()) {
            throw new BookNotFoundException("no book with id: " + id);
        } else {
            log.debug("deleting book with id: {}", id);
            bookRepository.deleteById(id);
        }
    }
    public List<BookResponse> getBooksByAUhtor(String author) {
        log.debug("getting all books by author {}",author);
        List<Book> bookList = bookRepository.findByAuthor(author);
        return bookMapper.toDto(bookList);

    }
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

