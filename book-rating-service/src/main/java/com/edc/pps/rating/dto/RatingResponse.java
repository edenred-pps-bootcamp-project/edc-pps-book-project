package com.edc.pps.rating.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class RatingResponse {
    private Long ratingId;
    private Long bookId;
    private Long userId;
    private Integer ratingValue;

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
