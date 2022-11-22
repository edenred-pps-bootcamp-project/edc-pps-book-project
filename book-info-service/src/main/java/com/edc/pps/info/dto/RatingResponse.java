package com.edc.pps.info.dto;
import java.util.Objects;

public class RatingResponse {

    private long ratingId;

    private long bookId;

    private long userId;

    private int ratingValue;

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingResponse that = (RatingResponse) o;
        return ratingId == that.ratingId && bookId == that.bookId && userId == that.userId && ratingValue == that.ratingValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, bookId, userId, ratingValue);
    }

    @Override
    public String toString() {
        return "RatingResponse{" +
                "ratingId=" + ratingId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", ratingValue=" + ratingValue +
                '}';
    }
}
