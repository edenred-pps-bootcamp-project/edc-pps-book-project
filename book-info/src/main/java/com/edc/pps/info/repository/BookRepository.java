package com.edc.pps.info.repository;



import com.edc.pps.info.model.*;
import com.edc.pps.rating.model.Rating;
import com.edc.pps.catalogue.model.User;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public interface BookRepository {

    // TODO: move theses to the implementation class, never in interface
    Set<User> users = new TreeSet<>();
    Set<Book> bookList = new ConcurrentSkipListSet<>();
    Set<Rating> ratings = new HashSet<>();
    Set<Book> getBookList();
    Set<Rating> getRatings();
    Set<User> getUsers();
}
