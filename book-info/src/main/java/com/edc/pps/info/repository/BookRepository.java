package com.edc.pps.info.repository;



import com.edc.pps.info.model.*;
import com.edc.pps.rating.model.Rating;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public interface BookRepository {
    Set<Book> bookList = new ConcurrentSkipListSet<>();
    Set<Rating> ratings = new HashSet<>();
    Set<Book> getBookList();
    Set<Rating> getRatings();
}
