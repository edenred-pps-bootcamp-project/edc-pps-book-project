package com.edc.pps.model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

// TODO: rename to InMemoryBookRepository
// extract an interface for this class: BookRepository
// and move the interface and this class to a new package: repository
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

