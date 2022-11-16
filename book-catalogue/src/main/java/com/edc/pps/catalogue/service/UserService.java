package com.edc.pps.catalogue.service;

import com.edc.pps.catalogue.dto.CatalogItem;
import com.edc.pps.catalogue.model.User;
import com.edc.pps.catalogue.repository.InMemoryCatalogRepository;
import com.edc.pps.info.model.Book;
import com.edc.pps.info.repository.InMemoryBookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserService extends InMemoryCatalogRepository {

    // TODO: use constructor dependency injection
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

    // TODO: refactor to List<User> findAll()
    public void displayAllUsers() {
        getUsers().forEach(System.out::println);
    }

    // TODO: refactor to User findById()
    public void displayUser(Long id){
        getUsers().stream().filter(user -> user.getUserId().equals(id)).forEach(System.out::println);
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
