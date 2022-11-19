package com.edc.pps.rating.service;

import com.edc.pps.rating.dto.RatingMapper;
import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.model.Rating;
import com.edc.pps.rating.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RatingService {

    // TODO use constructor injection for the dependencies
    private static final Logger log = LoggerFactory.getLogger(RatingService.class);
    private RatingMapper ratingMapper;
    private RatingRepository ratingRepository;

    private RatingService() {
    }

    @Autowired
    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }


    // TODO: implement this method to save a user rating
    // the service should save use the repository to save in the database
    public RatingResponse save(RatingRequest request) {
        log.info("saved new rating to db: {}", request);
        System.out.println("we are inside the save method in ratingService");

        return null;
    }

    // TODO: implement this method to get all ratings
    public List<Rating> findAll() {
        return null;
    }

    // TODO: implement this method to update a rating
    public Rating update(Long id, Rating request) {
        return null;
    }

    // TODO: method names should use camelCase
    // remove this method
    public void AddRating(Rating rating, Set<Rating> ratingSet) {
        ratingSet.add(rating);
    }



    // TODO: remove this method
    /*
    public void addRating(long bookId, long userId, int ratingValue){
        ratings.add(new Rating(bookId, userId, ratingValue));
    }*/

// TODO: remove empty lines


}
