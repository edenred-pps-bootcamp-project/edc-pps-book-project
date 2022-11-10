package ratinginfo;

import library.Library.*;

import java.util.Set;

import static library.Library.getRatings;


public class RatingService {

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
        getRatings().add(new Rating(bookId, userId, ratingValue));
    }





}
