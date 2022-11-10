package com.edc.pps.info.model;

public class Rating {
    private long ratingId;
    private double rating;

    public Rating(long ratingId, double rating) {
        this.ratingId = ratingId;
        this.rating = rating;
    }

    public long getRatingId() {
        return ratingId;
    }

    public double getRating() {
        return rating;
    }

}
