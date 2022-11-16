package com.edc.pps.rating.model;
// TODO: remove unused imports

// TODO: format this file

// TODO: Comparable is generic, use <>
public class Rating implements Comparable<Rating> {

    // TODO: the id should have type Long
    // using the Long object, in case the id is missing it will be null
    // using primitive long, in case the id is missing it will be 0
    private long ratingId;


    // TODO: no need to initialize
    // in intellij gray means unused or redundant, you can see that by hovering a gray value
    private long bookId;
    private long userId;

    // TODO: decide between int and Integer
    // having 0 as default for a book means that all books are trash :)
    // having null as default means that a book has no rating yet
    private short ratingValue;


    public Rating(long bookId, long userId, short rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
    }



    @Override
    public int compareTo(Rating rating) {
        return (int) (this.ratingId - rating.ratingId);
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
