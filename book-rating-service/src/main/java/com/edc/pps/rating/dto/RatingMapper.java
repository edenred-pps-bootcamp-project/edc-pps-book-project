package com.edc.pps.rating.dto;

import com.edc.pps.rating.model.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingMapper {

    public List<RatingResponse> toDto(List<Rating> ratings){
        List<RatingResponse> ratingDtos = new ArrayList<>();
        for(Rating rating: ratings){
            ratingDtos.add(toDto(rating));
        }
        return ratingDtos;
    }
    private RatingResponse toDto(Rating rating) {
        RatingResponse dto = new RatingResponse();
        dto.setRatingId(rating.getRatingId());
        dto.setBookId(rating.getBookId());
        dto.setRatingValue(rating.getRatingValue());
        dto.setUserId(rating.getUserId());
        return dto;
    }

    public List<Rating> toEntity(List<RatingRequest> ratingRequests){
        List<Rating> ratings = new ArrayList<>();
        for(RatingRequest ratingRequest: ratingRequests){
            ratings.add(toEntity(ratingRequest));
        }
    return ratings;
    }

    private Rating toEntity(RatingRequest ratingRequest) {
        Rating entity = new Rating();
        entity.setBookId(ratingRequest.getBookId());
        entity.setUserId(ratingRequest.getUserId());
        entity.setRatingValue(ratingRequest.getRatingValue());
        return  entity;
    }

    //might not need return(same reference)
    private Rating toEntity(Rating entity, RatingRequest updateInfo){
        entity.setRatingValue(updateInfo.getRatingValue());
        entity.setBookId(updateInfo.getBookId());
        entity.setUserId(updateInfo.getUserId());
        return  entity;
    }

}
