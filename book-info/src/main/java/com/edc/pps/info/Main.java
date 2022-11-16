package com.edc.pps.info;

import com.edc.pps.info.service.BookService;
import com.edc.pps.rating.service.RatingService;

// TODO: rename to BookInfoApp
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
        //bookService.displayBook("Florin are mere");
        //bookService.displayAllBooks();
        //bookService.displayAuthorBooks("Ana");
        //bookService.displayAllBooks();
        bookService.deleteBooksByAuthor("Ana");
        bookService.deleteBook("Florin are mere");
        bookService.displayAllBooks();
        RatingService ratingService = RatingService.getInstance();
//        ratingService.addRating2(2,2,3);
//        ratingService.addRating2(2,2,4);
//        ratingService.addRating2(2,2,5);
//        ratingService.getRatings();
//        double a = 0;
//        for (int i = 0; i < 21; i++) {
//            a+=10;
//            a=a*1.06;
//        }
//        System.out.println(a);
    }
}
