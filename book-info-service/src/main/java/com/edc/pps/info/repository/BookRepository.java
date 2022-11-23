package com.edc.pps.info.repository;

import com.edc.pps.info.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(@Param("title") String title);
    List<Book> findByAuthor(@Param("author") String author);
    Book findByTitleAndAuthor(String title, String author);
}
