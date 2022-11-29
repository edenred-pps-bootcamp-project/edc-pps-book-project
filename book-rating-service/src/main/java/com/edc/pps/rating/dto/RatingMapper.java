package com.edc.pps.rating.dto;

import com.edc.pps.rating.model.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingMapper {
    public List<RatingResponse> toDto(List<Rating> entities) {
        if(entities == null){
            return null;
        }
        List<RatingResponse> dtos = new ArrayList<>();
        for (Rating entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public RatingResponse toDto(Rating rating) {
        if(rating == null){
            return null;
        }
        RatingResponse dto = new RatingResponse();
        dto.setRatingId(rating.getRatingId());
        dto.setBookId(rating.getBookId());
        dto.setRatingValue(rating.getRatingValue());
        dto.setUserId(rating.getUserId());
        return dto;
    }

    public List<Rating> toEntity(List<RatingRequest> ratingRequests) {
        if(ratingRequests == null){
            return null;
        }
        List<Rating> ratings = new ArrayList<>();
        for (RatingRequest ratingRequest : ratingRequests) {
            ratings.add(toEntity(ratingRequest));
        }
        return ratings;
    }

    public Rating toEntity(RatingRequest ratingRequest) {
        if(ratingRequest == null){
            return null;
        }
        Rating entity = new Rating();
        entity.setBookId(ratingRequest.getBookId());
        entity.setUserId(ratingRequest.getUserId());
        entity.setRatingValue(ratingRequest.getRatingValue());
        return entity;
    }

    public Rating toEntity(Rating entity, RatingRequest updateInfo) {
        if(updateInfo == null){
            return null;
        }
        entity.setRatingValue(updateInfo.getRatingValue());
        entity.setBookId(updateInfo.getBookId());
        entity.setUserId(updateInfo.getUserId());
        return entity;
    }

}
