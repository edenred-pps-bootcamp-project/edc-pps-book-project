package com.edc.pps.info.clr;

import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import com.edc.pps.info.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookCommandLineRunner implements CommandLineRunner {
    @Autowired
    private BookRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Book firstBook = new Book("The Candy House","Jennifer Egan");
        Book secondBook = new Book("Young Mungo","Douglas Stuart");
        repository.save(firstBook);
        repository.save(secondBook);
    }
}
