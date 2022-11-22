package com.edc.pps.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edc.pps.catalog.dto.rating.RatingRequest;
import com.edc.pps.catalog.dto.rating.RatingResponse;
import com.edc.pps.catalog.service.RatingService;

@RequestMapping("api/ratings")
@RestController
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<RatingResponse> saveOrUpdate(@RequestBody RatingRequest request) {
        return new ResponseEntity<>(ratingService.saveOrUpdate(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RatingResponse>> findAll() {
        return new ResponseEntity<>(ratingService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
        ratingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // api/ratings/{id}
    // api/ratings/{bookId}
    // api/ratings/books/{bookId}/rating
    @GetMapping("/{id}")
    public ResponseEntity<List<RatingResponse>> getAllRatingsForBook(@PathVariable Long id) {
        return new ResponseEntity<>(ratingService.getAllRatingsForBook(id), HttpStatus.OK);
    }

}
