package com.edc.pps.rating.model;

public class Rating implements Comparable<Rating> {
    private long ratingId;
    private long bookId;
    private long userId;
    private int ratingValue;

    public Rating(long bookId, long userId, int rating) {
        this.ratingId = bookId * 10000 + userId;
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
        //getAverageRating();
    }

    @Override
    public int compareTo(Rating otherRating) {
        return (int) (this.ratingId - otherRating.ratingId);
    }

    public long getRatingId() {
        return ratingId;
    }

    public long getBookId() {
        return bookId;
    }

    public long getUserId() {
        return userId;
    }

    public int getRating() {
        return ratingValue;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "Rating ID=" + ratingId +
                ", Book ID=" + bookId +
                ", User ID=" + userId +
                ", Rating Value=" + ratingValue +
                '}';
    }
}