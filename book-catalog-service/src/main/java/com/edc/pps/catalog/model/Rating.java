package com.edc.pps.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {

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
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
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