package com.edc.pps.rating.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating implements Comparable<Rating> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long ratingId;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "rating_value")
    private int ratingValue;

    public Rating() {
    }

    public Rating(long bookId, long userId, int rating) {
        this.ratingId = bookId * 10000 + userId;
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
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
        return "Rating{" +
                "Rating ID=" + ratingId +
                ", Book ID=" + bookId +
                ", User ID=" + userId +
                ", Rating Value=" + ratingValue +
                '}';
    }
}
