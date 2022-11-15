package com.edc.pps.catalogue.service;

import com.edc.pps.catalogue.model.User;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.InMemoryBookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserService extends InMemoryBookRepository{

    public static final UserService userService = new UserService();

    private UserService() {

    }

    public static UserService getInstance() {
        return userService;
    }


    public Set<User> createUser(String firstName, String lastName, String userName, List<Book> books) {
        getUsers().add(new User(firstName, lastName, userName,books));
        return getUsers();

    }

    public Optional<User> findUser(String userName) {
        return getUsers().stream().filter(user -> user.getUserName().equals(userName)).findAny();
    }

    public void displayAllUsers() {
        getUsers().forEach(System.out::println);
    }

    public void displayUser(Long id){
        getUsers().stream().filter(user -> user.getUserId().equals(id)).forEach(System.out::println);
    }

}
