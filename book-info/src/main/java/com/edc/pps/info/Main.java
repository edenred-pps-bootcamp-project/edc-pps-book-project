package com.edc.pps.info;

import com.edc.pps.info.service.BookService;

public class Main {
    public static void main(String[] args) {
        BookService bookService = BookService.getInstance();


        bookService.createBook("Ana are mere", "Ana");
        bookService.createBook("Maria are mere", "Maria");
        bookService.createBook("Andrei are mere", "Andrei");
        bookService.createBook("Cosmin are mere", "Cosmin");
        bookService.createBook("Florin are mere", "Florin");
        bookService.displayAllBooks();

    }
}
