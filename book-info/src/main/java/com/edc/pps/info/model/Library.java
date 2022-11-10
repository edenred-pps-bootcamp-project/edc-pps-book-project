package com.edc.pps.info.model;


import com.edc.pps.catalogue.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Library {
    private static Set<Book> bookList = new ConcurrentSkipListSet<>();
    private static Set<Rating> ratings = new HashSet<>();

    private static Set<User> users = new HashSet<>();

    public static Set<Book> getBookList() {
        return bookList;
    }

    public static Set<Rating> getRatings() {
        return ratings;
    }

    public static Set<User> getUsers(){
        return users;
    }
}

