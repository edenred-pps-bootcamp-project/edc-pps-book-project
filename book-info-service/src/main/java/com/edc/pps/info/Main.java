package com.edc.pps.info;

import com.edc.pps.info.model.Book;
import com.edc.pps.info.service.BookService;

// TODO: rename to BookInfoApp
public class Main {
    public static void main(String[] args) {
        BookService bookService = BookService.getInstance();


        bookService.save(new Book("Ana are mere", "Ana"));
        bookService.save(new Book("Ana nu are mere", "Ana"));
        bookService.save(new Book("Maria are mere", "Maria"));
        bookService.save(new Book("Andrei are mere", "Andrei"));
        bookService.finaAll();

    }
}
