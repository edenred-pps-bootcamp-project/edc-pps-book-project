package com.edc.pps.catalogue;

import com.edc.pps.catalogue.model.User;
import com.edc.pps.catalogue.service.UserService;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.model.Library;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("Abecedar", "Cezar Petrescu");
        UserService userService = UserService.getInstance();

        userService.createUser("Norin", "Seculae","sneculae");


        System.out.println(book);

        System.out.println("Welcome to green team's playground! :)");

        System.out.println(Library.getUsers());

    }

}
