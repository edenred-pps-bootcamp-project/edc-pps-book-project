package com.edc.pps.info.service;

import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.InMemoryBookRepository;
import com.edc.pps.rating.model.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.stream.Collectors;


// TODO: format file
public class BookService extends InMemoryBookRepository {

    public static final BookService bookService = new BookService();
    private static Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    //InMemoryBookRepository in = new InMemoryBookRepository();
    private BookService() {
    }

    public static BookService getInstance() {
        return bookService;
    }

    // create

    /**
     * Add a book in a  book Set
     * @param book
     */
    public void save(Book book) {
        getBookList().add(book);
    }

    // read
    public void display(String title) {
        LOGGER.info(searchByTitle(title).toString());
    }

    public Book searchByTitle(String title){
        return getBookList()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public void displayRatings(String title) {
        Book book = searchByTitle(title);
        getRatings().stream()
                .forEach(rating -> System.out.println(rating.getRating()));
    }

    public Set<Book> finaAll() {
        LOGGER.info("Book collection \n");
        getBookList()
                .stream()
                .forEach(book -> System.out.println(book.toString()));
        return getBookList();
    }

    //update
    public void updateTitle(String oldTitle, String newTitle) {
        getBookList()
                .stream()
                .filter( book -> book.getTitle().equals(oldTitle))
                .findFirst()
                .get()
                .setTitle(newTitle);
    }

    public void updateAuthor(String title, String newAuthor) {
        getBookList()
                .stream()
                .filter( book -> book.getTitle().equals(title))
                .findFirst()
                .get()
                .setAuthor(newAuthor);
    }

    //delete
    public void delete(String title) {
        getBookList().remove(getBookList()
                .stream()
                .filter( book -> book.getTitle().equals(title))
                .findFirst()
                .get());
    }

    public void deleteByAuthor(String author) {
        getBookList()
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .forEach(book -> getBookList().remove(book));
    }

    // TODO: use logs instead of system out
    public void displayAuthorBooks(String author) {
        LOGGER.info("Author: " + author);
        LOGGER.info("Book title(s): ");
        getBookList()
                .stream()
                .filter( book -> book.getAuthor().equals(author))
                .forEach(System.out::println);
    }

    public Book getTitleById(long bookId) {
        return getBookList()
                .stream()
                .filter( book -> book.getId()==bookId).findFirst().get();
    }


    public void getAverageRating(long bookId) {
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
                book.setAverageRating(ratingTotal / count);
                return;
            }
        }
        throw new RuntimeException("This book has no ratings.");
    }

}

