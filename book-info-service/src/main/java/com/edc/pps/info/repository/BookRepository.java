package com.edc.pps.info.repository;



import com.edc.pps.info.model.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public interface BookRepository {


    // TODO: move theses to the implementation class, never in interface

    Set<Book> bookList = new ConcurrentSkipListSet<>();
    Set<Rating> ratings = new HashSet<>();
    Set<Book> getBookList();
    Set<Rating> getRatings();

}
