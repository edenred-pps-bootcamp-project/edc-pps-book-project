package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.model.Book;
import com.edc.pps.catalog.repository.UserRepository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {


    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
    }

    public User createExplicit(Long id, String firstName, String lastName, String userName) {
        User user = new User(id, firstName, lastName, userName);
        userRepository.findAll().add(user);
        return user;
    }

    public User create(User user){
        userRepository.findAll().add(user);
        return user;
    }

    public Optional<User> findUser(String userName) {
        return userRepository.findAll().stream().filter(user -> user.getUserName().equals(userName)).findAny();
    }

    public void findAll() {
        userRepository.findAll().forEach(System.out::println);
    }


    public Optional<User> findById(Long id){
        return userRepository.findAll().stream().filter(user -> user.getId().equals(id)).findAny();
    }

    public void addCatalogItem(Long id, Book book, int rating){
        User user = findById(id).get();

        user.getCatalogItems().add(new CatalogItem(book,rating));
    }

    // TODO: implement this
    public List<CatalogItem> findCatalogItemByUserId(Long userId) {
        // get all rated book ids, call book-ratings-service
            // hardcode a result for now like so:
            // bookId, rating
            // 1, 5
            // 1, 4
            // 2, 2

        // get each book id, call book-info-service and get details
            // make a call for each book
            // hardcode two books for now

            // a catalog item will have
                // bookId (from book-info-service)
                // bookTitle
                // bookAuthor
                // bookRating (from book-rating-service)

        return null;
    }


}
