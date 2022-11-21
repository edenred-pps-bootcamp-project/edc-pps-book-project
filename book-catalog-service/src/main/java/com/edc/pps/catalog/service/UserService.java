package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.InMemoryCatalogRepository;
import com.edc.pps.catalog.model.Book;
import com.edc.pps.rating.model.Rating;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService extends InMemoryCatalogRepository {

    // TODO: use constructor dependency injection
    public static final UserService userService = new UserService();

    private UserService() {

    }

    public static UserService getInstance() {
        return userService;
    }


    public User createExplicit(String firstName, String lastName, String userName) {
        User user = new User(firstName, lastName, userName);
        getUsers().add(user);
        return user;

    }

    public User create(User user){
        getUsers().add(user);
        return user;
    }

    public Optional<User> findUser(String userName) {
        return getUsers().stream().filter(user -> user.getUserName().equals(userName)).findAny();
    }


    public void findAll() {
        getUsers().forEach(System.out::println);
    }


    public Optional<User> findById(Long id){
        return getUsers().stream().filter(user -> user.getUserId().equals(id)).findAny();
    }

    public void addCatalogItem(Long id, Book book, Rating rating){
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
