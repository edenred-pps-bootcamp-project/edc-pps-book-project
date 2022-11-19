package com.edc.pps.rating.controller;

import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequestMapping("api/ratings")
@RestController
public class RatingController {

    private final RatingService ratingService;



    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @PostMapping
    public ResponseEntity<RatingResponse> saveNewRating(@RequestBody RatingRequest request){
        return new ResponseEntity<>(ratingService.save(request), HttpStatus.CREATED);
    }
}
