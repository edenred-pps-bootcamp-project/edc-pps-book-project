package com.edc.pps.rating.service;

import com.edc.pps.info.repository.InMemoryBookRepository;
import com.edc.pps.rating.model.Rating;

import java.util.List;
import java.util.Set;


public class RatingService extends InMemoryBookRepository {

    // TODO use constructor injection for the dependencies
    private static RatingService ratingService = new RatingService();

    private RatingService(){

    }

    // TODO: implement this method to save a user rating
    // the service should save use the repository to save in the database
    public Rating save(Long userId, Rating request) {
        return null;
    }

    // TODO: implement this method to get all ratings
    public List<Rating> findAll() {
        return null;
    }

    // TODO: implement this method to update a rating
    public Rating update(Long id, Rating request)  {
        return null;
    }

    // TODO: method names should use camelCase
    // remove this method
    public void AddRating(Rating rating, Set<Rating> ratingSet){
        ratingSet.add(rating);
    }

    public static RatingService getInstance(){
        return ratingService;
    }

    // TODO: remove this method
    public void addRating(long bookId, long userId, int ratingValue){
        ratings.add(new Rating(bookId, userId, ratingValue));
    }

// TODO: remove empty lines


}
