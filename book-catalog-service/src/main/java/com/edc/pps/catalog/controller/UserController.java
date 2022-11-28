package com.edc.pps.catalog.controller;

import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/catalog/{userId}")
    @ResponseBody
    public ResponseEntity<UserResponse> addCatalogItem(@PathVariable("userId") Long userId,
                                                       @RequestParam(name = "bookId") Long bookId,
                                                       @RequestParam(name = "ratingId") Long ratingId) throws NotFoundException {
        return new ResponseEntity<>(userService.addCatalogItem(userId, bookId, ratingId), HttpStatus.OK);
    }

}
