package com.edc.pps.service;

import com.edc.pps.model.Book;
import com.edc.pps.model.Rating;

import java.util.Set;

import static com.edc.pps.model.Library.getBookList;
import static com.edc.pps.model.Library.getRatings;


public class BookService {

    public static BookService bookService = new BookService();


    private BookService() {
    }

    public static BookService getInstance() {
        return bookService;
    }

    ;

    //create
    public Set<Book> createBook(String Title, String Author) {
        getBookList().add(new Book(Title, Author));
        return getBookList();
    }

    ;

    //read
    public Book displayBook(String Title) {
        for (Book book : getBookList()) {
            if (book.getBookTitle().equals(Title)) {
                System.out.println(book);
                return book;
            }
        }
        return null;
    }

    public void displayBookRatings(String Title) {
        Book book = displayBook(Title);
        System.out.println(Title);
        for (Rating rating : getRatings()) {
            if (rating.getRatingId() == book.getBookId()) {
                System.out.println(rating.getRating());
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("bookinfo.Book collection \n");
        for (Book book : getBookList()) {
            System.out.println(book);
        }
    }

    //update
    public void updateBookTitle(String oldTitle, String newTitle) {
        for (Book book : getBookList()) {
            if (book.getBookTitle().equals(oldTitle)) {
                book.setBookTitle(newTitle);
            }
        }

    }

    ;

    public void updateBookAuthor(String Title, String newAuthor) {
        for (Book book : getBookList()) {
            if (book.getBookTitle().equals(Title)) {
                book.setBookAuthor(newAuthor);
            }
        }
    }

    ;

    //delete
    public void deleteBook(String Title) {
        for (Book book : getBookList()) {
            if (book.getBookTitle().equals(Title)) {
                getBookList().remove(book);
                return;
            }
        }
        throw new RuntimeException("Cartea nu exista.");
    }

    public void getAverageRating(Long bookId, Set<Rating> ratings) {
        int count = 0;
        double ratingTotal = 0;

        for (Book book : getBookList()) {
            if (book.getBookId() == bookId) {
                for (Rating rating : ratings) {
                    if (book.getBookId() == rating.getRatingId()) {
                        count++;
                        ratingTotal += rating.getRating();
                    }
                }
                book.setBookRating(ratingTotal / count);
                return;
            }
        }
        throw new RuntimeException("Nu exista niciun rating pentru aceasta carte.");
    }

}

