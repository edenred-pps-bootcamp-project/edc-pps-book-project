package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.InMemoryCatalogRepository;
import com.edc.pps.info.model.Book;

import java.util.List;
import java.util.Optional;

public class UserService extends InMemoryCatalogRepository {

    // TODO: use constructor dependency injection
    public static final UserService userService = new UserService();

    private UserService() {

    }

    public static UserService getInstance() {
        return userService;
    }


    public User create(String firstName, String lastName, String userName, List<Book> books) {
        User user = new User(firstName, lastName, userName,books);
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
