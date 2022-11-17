package com.edc.pps.catalog;


import com.edc.pps.catalog.service.UserService;
import com.edc.pps.info.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookCatalogApp {

    public static void main(String[] args) {

        Book book1 = new Book("Abecedar", "Cezar Petrescu");

        Book book2 = new Book("Fram Ursul Polar", "Cezar Petrescu");

        System.out.println(book1);
        Book book3 = new Book("Colt Alb", "Nu stiu");

        System.out.println(book1);

        System.out.println("Welcome to green team's playground! :)");

        // creating a list of books
        List<Book> userListOfBooks = new ArrayList<>();


        // adding books to the list
        userListOfBooks.add(book1);
        userListOfBooks.add(book2);
        userListOfBooks.add(book3);
        UserService userService = UserService.getInstance();

        userService.createExplicit("Norin", "Seculae","sneculae");

        System.out.println(book1);

        System.out.println("Welcome to green team's playground! :)");

        userService.findAll();

        SpringApplication.run(BookCatalogApp.class);

    }

}
