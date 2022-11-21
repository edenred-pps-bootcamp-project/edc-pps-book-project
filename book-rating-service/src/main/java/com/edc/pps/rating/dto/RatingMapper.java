package com.edc.pps.rating.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.edc.pps.rating.model.Rating;

@Component
public class RatingMapper {

	public List<RatingResponse> toDto(List<Rating> entities) {
		List<RatingResponse> dtos = new ArrayList<>();
		for (Rating entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public RatingResponse toDto(Rating rating) {
		RatingResponse dto = new RatingResponse();
		dto.setRatingId(rating.getRatingId());
		dto.setBookId(rating.getBookId());
		dto.setRatingValue(rating.getRatingValue());
		dto.setUserId(rating.getUserId());
		return dto;
	}

	public List<Rating> toEntity(List<RatingRequest> ratingRequests) {
		List<Rating> ratings = new ArrayList<>();
		for (RatingRequest ratingRequest : ratingRequests) {
			ratings.add(toEntity(ratingRequest));
		}
		return ratings;
	}

	public Rating toEntity(RatingRequest ratingRequest) {
		Rating entity = new Rating();
		entity.setBookId(ratingRequest.getBookId());
		entity.setUserId(ratingRequest.getUserId());
		entity.setRatingValue(ratingRequest.getRatingValue());
		return entity;
	}

	//might not need return(same reference)
	public Rating toEntity(Rating entity, RatingRequest updateInfo) {
		entity.setRatingValue(updateInfo.getRatingValue());
		entity.setBookId(updateInfo.getBookId());
		entity.setUserId(updateInfo.getUserId());
		return entity;
	}

}
