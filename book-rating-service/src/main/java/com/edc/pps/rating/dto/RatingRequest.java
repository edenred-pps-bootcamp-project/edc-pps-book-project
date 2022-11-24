package com.edc.pps.rating.dto;


public class RatingRequest {

    private long bookId;

    private long userId;

    private int ratingValue;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    @Override
    public String toString() {
        return "RatingRequest{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", ratingValue=" + ratingValue +
                '}';
    }
}
