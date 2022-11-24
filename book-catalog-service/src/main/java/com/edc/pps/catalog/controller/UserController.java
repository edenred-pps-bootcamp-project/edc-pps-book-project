package com.edc.pps.catalog.controller;

import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.dto.UserResponseList;
import com.edc.pps.catalog.service.BookService;
import com.edc.pps.catalog.service.RatingService;
import com.edc.pps.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/users")
@RestController
public class UserController {

    private final BookService bookService;
    private final RatingService ratingService;
    private final UserService userService;

    @Autowired
    public UserController(BookService bookService, RatingService ratingService, UserService userService) {
        this.bookService = bookService;
        this.ratingService = ratingService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserResponseList> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }


}
