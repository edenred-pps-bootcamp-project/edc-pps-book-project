package com.edc.pps.info.service;

import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.InMemoryBookRepository;
import com.edc.pps.rating.model.Rating;

import java.util.Set;
import java.util.stream.Collectors;

import static com.edc.pps.info.repository.InMemoryBookRepository.bookList;
import static com.edc.pps.info.repository.InMemoryBookRepository.ratings;


// TODO: format file
public class BookService extends InMemoryBookRepository {

    public static final BookService bookService = new BookService();

    //InMemoryBookRepository in = new InMemoryBookRepository();
    private BookService() {
    }

    public static BookService getInstance() {
        return bookService;
    }

    // create
    // TODO: add javadocs to public methods
    public Set<Book> createBook(String title, String author) {
        getBookList().add(new Book(title, author));
        return getBookList();
    }

    // read
    public void displayBook(String title) {
        System.out.println(searchBookByTitle(title));
    }

    public Book searchBookByTitle(String title){
        return getBookList()
                .stream()
                .filter(book -> book.getTitle()
                        .equals(title))
                .findFirst()
                .orElse(null);
    }

    public void displayBookRatings(String title) {
        Book book = searchBookByTitle(title);
        System.out.println(title);
        getRatings().stream()
                .forEach(rating -> System.out.println(rating.getRating()));
    }

    public void displayAllBooks() {
        System.out.println("bookinfo.Book collection \n");
        getBookList()
                .stream()
                .forEach(book -> System.out.println(book.toString()));
    }

    //update
    public void updateBookTitle(String oldTitle, String newTitle) {
        for (Book book : getBookList()) {
            if (book.getTitle().equals(oldTitle)) {
                book.setTitle(newTitle);
            }
        }
    }

    public void updateBookAuthor(String title, String newAuthor) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                book.setAuthor(newAuthor);
            }
        }
    }

    //delete
    public void deleteBook(String title) {
        for (Book book : getBookList()) {
            if (book.getTitle().equals(title)) {
                getBookList().remove(book);
                return;
            }
        }
        throw new RuntimeException("The book doesn't exist.");
    }

    public void deleteBooksByAuthor(String author) {
        getBookList()
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .forEach(book -> getBookList().remove(book));
    }

    public void displayAuthorBooks(String author) {
        System.out.println("Author: " + author);
        System.out.println("Book title(s): ");
        boolean found = false;
        for (Book book : getBookList()) {
            if(book.getAuthor().equals(author)) {
                System.out.println(book.getTitle());
                found = true;
            }
        }
        if (found == false) {
            System.out.println("None");
        }
    }



    public void getAverageRating(Long bookId, Set<Rating> ratings) {
        int count = 0;
        double ratingTotal = 0;

        for (Book book : getBookList()) {
            if (book.getId() == bookId) {
                for (Rating rating : ratings) {
                    if (book.getId() == rating.getRatingId()) {
                        count++;
                        ratingTotal += rating.getRating();
                    }
                }
                book.setAvgRating(ratingTotal / count);
                return;
            }
        }
        throw new RuntimeException("This book has no ratings.");
    }

}

