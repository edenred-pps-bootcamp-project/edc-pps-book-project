package com.edc.pps;

import com.edc.pps.service.BookService;

// TODO: rename to BookInfoService
public class Main {
    public static void main(String[] args) {
        BookService bookService = BookService.getInstance();


        bookService.createBook("Ana are mere", "Ana");
        bookService.createBook("Ana nu are mere", "Ana");
        bookService.createBook("Ana are si nu are mere", "Ana");
        bookService.createBook("Maria are mere", "Maria");
        bookService.createBook("Andrei are mere", "Andrei");
        bookService.createBook("Cosmin are mere", "Cosmin");
        bookService.createBook("Florin are mere", "Florin");
        bookService.displayAllBooks();
        bookService.displayAuthorBooks("Ana");
        bookService.displayAllBooks();
        bookService.deleteBooksByAuthor("Ana");
        bookService.deleteBook("Florin are mere");
        bookService.displayAllBooks();

    }
}
