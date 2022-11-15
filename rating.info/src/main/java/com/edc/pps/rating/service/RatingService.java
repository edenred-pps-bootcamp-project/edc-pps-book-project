package com.edc.pps.rating.service;

import com.edc.pps.info.repository.InMemoryBookRepository;
import com.edc.pps.rating.model.Rating;

import java.util.Set;


public class RatingService extends InMemoryBookRepository {

    private static RatingService ratingService = new RatingService();

    private RatingService(){

    }

    public void AddRating(Rating rating, Set<Rating> ratingSet){
        ratingSet.add(rating);
    }

    public static RatingService getInstance(){
        return ratingService;
    }

    public void addRating(long bookId, long userId, int ratingValue){
        ratings.add(new Rating(bookId, userId, ratingValue));
    }




}
