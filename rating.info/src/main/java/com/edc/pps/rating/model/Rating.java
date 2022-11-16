package com.edc.pps.rating.model;
import com.edc.pps.info.service.BookService;

import static com.edc.pps.info.repository.BookRepository.ratings;

public class Rating implements Comparable<Rating>{
    private long ratingId = 0;
    private long bookId = 0;
    private long userId = 0;
    private int ratingValue = 0;


    public Rating(long bookId, long userId, int rating) {
        this.ratingId = bookId * 10000 + userId;
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
 //       bookService.getAverageRating(bookId, ratings);
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

    @Override
    public int compareTo(Rating o) {
        Rating otherRating = (Rating)o;
        return (int)(this.ratingId-otherRating.ratingId);
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
}
