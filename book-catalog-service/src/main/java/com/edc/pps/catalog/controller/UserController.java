package com.edc.pps.catalog.controller;

import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.dto.UserResponseList;
import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.dto.info.BookResponseList;
import com.edc.pps.catalog.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

@RequestMapping("api/users")
@RestController
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponse> update(@PathVariable(name ="userId") Long userId,@RequestBody UserRequest request) throws NotFoundException {

        UserResponse response = userService.update(userId, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/catalog/{userId}")
    @ResponseBody
    public ResponseEntity<UserResponse> addCatalogItem(@PathVariable("userId") Long userId,
                                                       @RequestParam(name = "bookId") Long bookId,
                                                       @RequestParam(name = "ratingId") Long ratingId) throws NotFoundException {
        return new ResponseEntity<>(userService.addCatalogItem(userId, bookId, ratingId), HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> delete(@PathVariable(name="userId") Long userId){
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }


}
