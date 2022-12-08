package com.edc.pps.rating.service;


import com.edc.pps.rating.dto.BookResponse;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.dto.UserResponse;
import com.edc.pps.rating.exception.BookNotFoundException;
import com.edc.pps.rating.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BookService {
    private static final String BOOKS_RESOURCES = "http://localhost:8084/api/books";
    private static final String USERS_RESOURCES = "http://localhost:8081/api/users";
    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BookResponse checkIfBookExists(long bookId){
        try {
            BookResponse response = restTemplate.getForObject(BOOKS_RESOURCES + "/find/" + bookId, BookResponse.class);
        return response;
        }catch (HttpClientErrorException exception){
            throw new BookNotFoundException("No book with ID: " + bookId);
        }
    }

    public void callForUpdateRating(long id, RatingResponse average){
        System.out.println(average);
        //restTemplate.postForObject(BOOKS_RESOURCES+"/average", average, BookResponse.class);
        restTemplate.put(BOOKS_RESOURCES+"/"+id, average);
    }

    public UserResponse checkIfUserExists(Long userId) {
        try{
            UserResponse response = restTemplate.getForObject(USERS_RESOURCES + "/" + userId , UserResponse.class);
            return response;
        } catch (HttpClientErrorException exception){
            throw new UserNotFoundException("No User with ID: " + userId);
        }
    }
}