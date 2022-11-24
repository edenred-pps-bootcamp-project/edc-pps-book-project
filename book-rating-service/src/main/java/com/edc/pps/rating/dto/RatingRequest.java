package com.edc.pps.rating.dto;

import lombok.Data;

@Data
public class RatingRequest {

    private long bookId;

    private long userId;

    private int ratingValue;

    @Override
    public String toString() {
        return "RatingRequest{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", ratingValue=" + ratingValue +
                '}';
    }
}
