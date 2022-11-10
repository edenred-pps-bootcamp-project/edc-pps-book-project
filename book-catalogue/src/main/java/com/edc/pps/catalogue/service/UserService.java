package com.edc.pps.catalogue.service;

import com.edc.pps.catalogue.model.User;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.model.Library;
import com.edc.pps.info.service.BookService;

import java.security.Provider;
import java.util.Set;

public class UserService {

    public static UserService userService = new UserService();

    private UserService(){

    }

    public static UserService getInstance(){
        return userService;
    }

    public Set<User> createUser(String firstName, String lastName, String userName){
        Library.getUsers().add(new User(firstName,lastName,userName));
        return Library.getUsers();

    }

    public User findUser(String userName){
        for (User user: Library.getUsers()){
            if(user.getUserName().equals(user)){
                return user;
            }
        }

        return null;
    }

    public void displayAllUsers(){
        for(User user: Library.getUsers()){
            System.out.println(user);
        }
    }

}
