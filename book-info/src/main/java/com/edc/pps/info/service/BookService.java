package com.edc.pps.info.service;

import com.edc.pps.info.model.Book;
import com.edc.pps.rating.model.Rating;

import java.util.Set;

import static com.edc.pps.info.repository.InMemoryBookRepository.bookList;
import static com.edc.pps.info.repository.InMemoryBookRepository.ratings;


// TODO: format file
public class BookService {

    // TODO: make final
    public static BookService bookService = new BookService();

    //InMemoryBookRepository in = new InMemoryBookRepository();
    private BookService() {
    }

    public static BookService getInstance() {
        return bookService;
    }

    // create
    // TODO: add javadocs to public methods
    public Set<Book> createBook(String title, String author) {
        bookList.add(new Book(title, author));
        return bookList;
    }

    // read
    // TODO: should be void
    // TODO: refactor methods to use lambda where possible
    public Book displayBook(String title) {
        for (Book book : bookList) {
            if (book.getBookTitle().equals(title)) {
                System.out.println(book);
                return book;
            }
        }
        return null;
    }

    public void displayBookRatings(String title) {
        Book book = displayBook(title);
        System.out.println(title);
        for (Rating rating : ratings) {
            if (rating.getRatingId() == book.getBookId()) {
                System.out.println(rating.getRating());
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("bookinfo.Book collection \n");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    //update
    public void updateBookTitle(String oldTitle, String newTitle) {
        for (Book book : bookList) {
            if (book.getBookTitle().equals(oldTitle)) {
                book.setBookTitle(newTitle);
            }
        }
    }

    public void updateBookAuthor(String title, String newAuthor) {
        for (Book book : bookList) {
            if (book.getBookTitle().equals(title)) {
                book.setBookAuthor(newAuthor);
            }
        }
    }

    //delete
    public void deleteBook(String title) {
        for (Book book : bookList) {
            if (book.getBookTitle().equals(title)) {
                bookList.remove(book);
                return;
            }
        }
        // TODO: use english everywhere in code
        throw new RuntimeException("Cartea nu exista.");
    }

    public void deleteBooksByAuthor(String author) {
        for (Book book : bookList) {
            if(book.getBookAuthor().equals(author)) {
                bookList.remove(book);
            }
        }
    }

    public void displayAuthorBooks(String author) {
        System.out.println("Author: " + author);
        System.out.println("Book title(s): ");
        boolean found = false;
        for (Book book : bookList) {
            if(book.getBookAuthor().equals(author)) {
                System.out.println(book.getBookTitle());
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

        for (Book book : bookList) {
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

