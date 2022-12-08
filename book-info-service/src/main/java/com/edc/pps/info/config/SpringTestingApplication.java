package com.edc.pps.info.config;

import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Collections;
import java.util.List;

@Profile("test")
@SpringBootApplication
public class SpringTestingApplication {
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestingApplication.class);
    }

    @Bean
    CommandLineRunner data() {
        return args -> bookRepository.saveAll(createBooks());
    }

    private List<Book> createBooks() {
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        return Collections.singletonList(book);
    }
}
