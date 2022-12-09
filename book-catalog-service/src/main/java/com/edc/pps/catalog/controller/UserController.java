//package com.edc.pps.catalog.controller;
//
//import com.edc.pps.catalog.dto.UserRequest;
//import com.edc.pps.catalog.dto.UserResponse;
//import com.edc.pps.catalog.exception.UserFailedToBeRegisteredException;
//import com.edc.pps.catalog.model.User;
//import com.edc.pps.catalog.service.UserService;
//import javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequestMapping("api/users")
//@RestController
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) throws UserFailedToBeRegisteredException {
//        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserResponse>> findAll() {
//        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
//        return new ResponseEntity<>(userService.findByUserId(id), HttpStatus.OK);
//    }
//
//    @PutMapping("/{userId}")
//    public ResponseEntity<UserResponse> update(@PathVariable(name ="userId") Long userId,@RequestBody UserRequest request) throws NotFoundException {
//
//        UserResponse response = userService.update(userId, request);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @PostMapping("/catalog/{userId}")
//    @ResponseBody
//    public ResponseEntity<UserResponse> saveCatalogItem(@PathVariable("userId") Long userId,
//                                                       @RequestParam(name = "bookId") Long bookId) throws NotFoundException {
//        return new ResponseEntity<>(userService.saveCatalogItem(userId, bookId), HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Object> delete(@PathVariable(name="userId") Long userId){
//
//        userService.delete(userId);
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/catalog/{userId}/{ratingId}")
//    public ResponseEntity<UserResponse> updateCatalogItem(@PathVariable Long userId,
//                                                          @PathVariable Long ratingId){
//        return new ResponseEntity<>(userService.updateCatalogItem(userId, ratingId), HttpStatus.OK);
//    }
//
//
//}
