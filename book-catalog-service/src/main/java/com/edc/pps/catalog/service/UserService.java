package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.dto.UserMapper;
import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.dto.info.BookMapper;
import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.dto.rating.RatingResponse;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.UserRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {


    public final UserRepository userRepository;
    private final BookService bookService;
    private final RatingService ratingService;
    private final UserMapper userMapper;
    private final BookMapper bookMapper;


    @Autowired
    public UserService(UserRepository userRepository, BookService bookService, RatingService ratingService, UserMapper userMapper, BookMapper bookMapper) {
        this.userRepository = userRepository;
        this.bookService = bookService;
        this.ratingService = ratingService;
        this.userMapper = userMapper;
        this.bookMapper = bookMapper;
    }

    public UserResponse save(UserRequest request) {
        User user = userMapper.toEntity(request);
        userRepository.save(user);
        return userMapper.toDto(user);
    }


   public UserResponse update(Long userId, UserRequest request) throws NotFoundException {
        log.debug("updating by user id: {} with request body : {}", userId, request);

        //search user entity to update
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("user not found"));

        //update data
        User updatedUser = userMapper.toEntity(user, request);

        //save updated entity
        User savedUser = userRepository.save(updatedUser);

        //convert to dto
        return userMapper.toDto(savedUser);
    }


    public UserResponse findUser(String userName) throws NotFoundException {
        log.info("getting user with username: {}", userName);
        Optional<User> response = userRepository.findAll().stream().filter(user -> user.getUserName().equals(userName)).findAny();
        if (response.isPresent()) {
            return userMapper.toDto(response.get());
        }
        throw new NotFoundException("user with given username is not registered");
    }

    public List<UserResponse> findAll() {

        log.info("get all users");
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }


    public UserResponse findById(Long id) throws NotFoundException {
        Optional<User> response = userRepository.findAll().stream().filter(user -> user.getId().equals(id)).findAny();
        if (response.isPresent()) {
            return userMapper.toDto(response.get());
        }
        throw new NotFoundException("user with given id is not registered");
    }

    public UserResponse addCatalogItem(Long userId, Long bookId, Long ratingId) throws NotFoundException {
        User user = userRepository.findById(userId).get();
        RatingResponse ratings = Arrays.asList(ratingService.getAllRatingsForUser(userId)).get(0);
        BookResponse book = bookService.findById(1L);

        CatalogItem catalogItem = new CatalogItem(book.getId(), book.getTitle(), book.getTitle(), ratings.getRatingValue());

        List<CatalogItem> catalogItems = user.getCatalogItems();
        catalogItems.add(catalogItem);

        user.setCatalogItems(catalogItems);
        userRepository.save(user);
        return userMapper.toDto(user);
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
