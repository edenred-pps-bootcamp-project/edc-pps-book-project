package library;

import bookinfo.Rating;
import bookinfo.Book;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Library {
    private static Set<Book> bookList = new ConcurrentSkipListSet<>();
    private static Set<Rating> ratings = new HashSet<>();

    public static Set<Book> getBookList() {
        return bookList;
    }

    public static Set<Rating> getRatings() {
        return ratings;
    }
}
