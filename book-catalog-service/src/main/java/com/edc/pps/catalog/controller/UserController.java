package com.edc.pps.catalog.controller;

import com.edc.pps.catalog.service.BookService;
import com.edc.pps.catalog.service.RatingService;
import com.edc.pps.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
