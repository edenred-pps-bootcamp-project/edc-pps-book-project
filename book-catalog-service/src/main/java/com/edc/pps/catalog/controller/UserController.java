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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




}
