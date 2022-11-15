package com.edc.pps.catalogue;

import com.edc.pps.catalogue.model.User;
import com.edc.pps.catalogue.service.UserService;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.InMemoryBookRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Abecedar", "Cezar Petrescu");

        Book book2 = new Book("Fram Ursul Polar", "Cezar Petrescu");

        System.out.println(book1);
        Book book3 = new Book("Colt Alb", "Nu stiu");

        System.out.println(book1);

        System.out.println("Welcome to green team's playground! :)");

        //crearea listei care contine carti
        List<Book> userListOfBooks = new ArrayList<Book>();

        //adaugarea cartilor la lista
        userListOfBooks.add(book1);
        userListOfBooks.add(book2);
        userListOfBooks.add(book3);
        UserService userService = UserService.getInstance();


        userService.createUser("Norin", "Seculae","sneculae", userListOfBooks);


        System.out.println(book1);

        System.out.println("Welcome to green team's playground! :)");

        userService.displayAllUsers();







    }

}
