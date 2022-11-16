package com.edc.pps.info.repository;

import com.edc.pps.catalogue.model.User;
import com.edc.pps.info.model.*;
import com.edc.pps.rating.model.Rating;


import java.util.Set;

// TODO: rename to InMemoryBookRepository
// extract an interface for this class: BookRepository
// and move the interface and this class to a new package: repository
public class InMemoryBookRepository implements BookRepository {

    @Override
    public Set<Book> getBookList() {
        return bookList;
    }

    @Override
    public Set<Rating> getRatings() {
        return ratings;
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

}
