package com.edc.pps.info.dto.rating;

import lombok.Data;

@Data
public class RatingRequest {

    private Long bookId;

    private Long userId;

    private Integer ratingValue;

    @Override
    public String toString() {
        return "RatingRequest{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", ratingValue=" + ratingValue +
                '}';
    }
}
