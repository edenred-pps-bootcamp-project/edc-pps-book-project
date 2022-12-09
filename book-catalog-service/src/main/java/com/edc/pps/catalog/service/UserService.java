package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.dto.UserMapper;
import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.dto.rating.RatingResponse;
import com.edc.pps.catalog.exception.BadRequestException;
import com.edc.pps.catalog.exception.UserConstraintViolationException;
import com.edc.pps.catalog.exception.UserFailedToBeRegisteredException;
import com.edc.pps.catalog.exception.UserNotFoundException;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.UserRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
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


    @Autowired
    public UserService(UserRepository userRepository, BookService bookService, RatingService ratingService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.bookService = bookService;
        this.ratingService = ratingService;
        this.userMapper = userMapper;
    }

    /**
     * Saves a new user
     *
     * @param request Request object to be saved
     * @return Response object - created user
     */
    public UserResponse save(UserRequest request) throws UserFailedToBeRegisteredException {
        validateRequest(request);
        User user = userMapper.toEntity(request);
        try {
            userRepository.save(user);
        } catch (ConstraintViolationException e) {
            throw new UserConstraintViolationException("User fields cannot be empty!");
        } catch (Exception e) {
            throw new UserFailedToBeRegisteredException("User failed to be registered!");
        }
        return userMapper.toDto(user);
    }

    /**
     * Updates user with provided id
     *
     * @param userId  The id of the user we want to update
     * @param request Request object to replace old user
     * @return Returns updated user
     * @throws NotFoundException Throws not found exception in case user is not registered
     */
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

    /**
     * @param userId the id of the user we want to delete
     */
    public void delete(Long userId) {
        log.debug("deleting user with id: {}", userId);
        userRepository.deleteById(userId);
    }

    /**
     * Find user by username
     *
     * @param userName Username to find user by
     * @return Returns response object of the user found
     * @throws NotFoundException Throws not found exception if there is no user with such username
     */
    public UserResponse findUser(String userName) throws NotFoundException {
        log.info("getting user with username: {}", userName);
        Optional<User> response = userRepository.findAll().stream().filter(user -> user.getUserName().equals(userName)).findAny();
        if (response.isPresent()) {
            return userMapper.toDto(response.get());
        }
        throw new NotFoundException("user with given username is not registered");
    }

    /**
     * Find all users method
     *
     * @return Returns all users in the database
     */
    public List<UserResponse> findAll() {

        log.info("get all users");
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Method to return user by id
     *
     * @param id The id of the user we want to lookup in the database
     * @return Response object of the user we found
     * @throws NotFoundException Throws not found exception if there is no such user
     */
    public UserResponse findById(Long id) throws NotFoundException {
        Optional<User> response = userRepository.findAll().stream().filter(user -> user.getId().equals(id)).findAny();
        if (response.isPresent()) {
            return userMapper.toDto(response.get());
        }
        throw new NotFoundException("user with given id is not registered");
    }

    /**
     * Saves CatalogItem of a user
     *
     * @param userId The id of the user we want to save the CatalogItem to
     * @param bookId The book id that gives us information about the catalog item
     * @return Returns the updated user
     * @throws NotFoundException Throws not found exception if findById method fails
     */
    public UserResponse saveCatalogItem(Long userId, Long bookId) throws NotFoundException {
        User user = userRepository.findById(userId).get();

        List<RatingResponse> ratings = Arrays.asList(ratingService.getAllRatingsForBook(bookId));
        BookResponse book = bookService.findById(bookId);

        CatalogItem catalogItem = new CatalogItem();

        for (RatingResponse rating : ratings) {
            if (userId == rating.getUserId()) {
                catalogItem.setBookId(book.getId());
                catalogItem.setAuthor(book.getAuthor());
                catalogItem.setTitle(book.getTitle());
                catalogItem.setRating(rating.getRatingValue());
                catalogItem.setAverageRating(book.getAverageRating());

            } else {
                catalogItem.setBookId(book.getId());
                catalogItem.setAuthor(book.getAuthor());
                catalogItem.setTitle(book.getTitle());
                catalogItem.setRating(0);
                catalogItem.setAverageRating(book.getAverageRating());
            }
        }

        List<CatalogItem> catalogItems = user.getCatalogItems();
        catalogItems.add(catalogItem);

        user.setCatalogItems(catalogItems);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponse findByUserId(Long id) {
        try {
            User actualUser = userRepository.findById(id).get();
            return userMapper.toDto(actualUser);
        } catch (Exception e) {
            throw new UserNotFoundException("User with specified id " + id.toString() + " cannot be found");
        }
    }


    public UserResponse updateCatalogItem(Long userId, Long ratingId) {
        User user = userRepository.findById(userId).get();
        RatingResponse rating = ratingService.getRatingById(ratingId);
        BookResponse book = bookService.findById(rating.getBookId());

        List<CatalogItem> catalogItems = user.getCatalogItems();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getBookId() == rating.getBookId()) {
                catalogItem.setRating(rating.getRatingValue());
                catalogItem.setAverageRating(book.getAverageRating());
            }
        }

        userRepository.save(user);
        return userMapper.toDto(user);
    }

    private boolean validateRequest(UserRequest request) {
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            log.info("First name cannot be null: \n" + request.toString());
            throw new BadRequestException("Please complete the first name field");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            log.info("Author cannot be null: \n" + request.toString());
            throw new BadRequestException("Please complete the last name field");
        }
        if (request.getUserName() == null || request.getUserName().isEmpty()) {
            log.info("Username cannot be null: \n" + request.toString());
            throw new BadRequestException("Please complete the username field");
        }
        return true;
    }

}
