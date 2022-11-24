package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.*;
import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.UserRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {


    public final UserRepository userRepository;
    private final BookService bookService;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate, BookService bookService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.bookService = bookService;
        this.userMapper = userMapper;
    }

    public UserResponse save(UserRequest user) {
        User entity = userMapper.toEntity(user);
        userRepository.findAll().add(entity);
        return userMapper.toDto(entity);
    }

    public UserResponse findUser(String userName) throws NotFoundException {
        log.info("getting user with username: {}", userName);
        Optional<User> response = userRepository.findAll().stream().filter(user -> user.getUserName().equals(userName)).findAny();
        if (response.isPresent()) {
            return userMapper.toDto(response.get());
        }
        throw new NotFoundException("user with given username is not registered");
    }

    public UserResponseList findAll() {
        log.info("get all users");
        return (UserResponseList) userMapper.toDto(userRepository.findAll());
    }


    public UserResponse findById(Long id) throws NotFoundException {
        Optional<User> response = userRepository.findAll().stream().filter(user -> user.getId().equals(id)).findAny();
        if (response.isPresent()) {
            return userMapper.toDto(response.get());
        }
        throw new NotFoundException("user with given id is not registered");
    }

    public UserResponse addCatalogItem(Long userId, Long bookId, int rating) throws NotFoundException {
        UserResponse user = findById(userId);
        BookResponse book = bookService.findById(bookId);

        user.getCatalogItems().add(new CatalogItem(book.getId(), book.getTitle(), book.getTitle(), rating));
        return user;
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
