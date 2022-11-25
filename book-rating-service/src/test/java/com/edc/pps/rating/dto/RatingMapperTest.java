package com.edc.pps.rating.dto;

import com.edc.pps.rating.model.Rating;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RatingMapperTest {
    @Test
    void givenEntity_whenToDto_thenReturnDto(){
        RatingMapper ratingMapper = new RatingMapper();
        Rating rating = new Rating();
        rating.setRatingValue(5);
        rating.setBookId((long)1);
        rating.setUserId((long)2);

        RatingResponse expected = new RatingResponse();
        expected.setUserId((long)2);
        expected.setBookId((long)1);
        expected.setRatingValue(5);

        RatingResponse actual = ratingMapper.toDto(rating);
        assertThat(actual)
                .isEqualTo(expected);
    }
    @Test
    void givenRatingRequest_whenToEntity_thenReturnEntity(){
        RatingMapper ratingMapper = new RatingMapper();
        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setBookId((long)1);
        ratingRequest.setUserId((long)2);
        ratingRequest.setRatingValue(5);

        Rating expected = new Rating();
        expected.setRatingValue(5);
        expected.setBookId((long)1);
        expected.setUserId((long)2);

        Rating actual = ratingMapper.toEntity(ratingRequest);
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
        
    }
    @Test
    void givenListOfEntities_whenToDto_thenReturnListOfDto(){
        RatingMapper ratingMapper = new RatingMapper();
        List<Rating> ratings = new ArrayList<Rating>();
        Rating rating = new Rating();
        rating.setRatingValue(5);
        rating.setBookId((long)1);
        rating.setUserId((long)2);
        ratings.add(rating);

        List<RatingResponse> expected = new ArrayList<RatingResponse>();
        RatingResponse ratingResponse = new RatingResponse();
        ratingResponse.setUserId((long)2);
        ratingResponse.setBookId((long)1);
        ratingResponse.setRatingValue(5);
        expected.add(ratingResponse);

        List<RatingResponse> actual = ratingMapper.toDto(ratings);
        assertThat(actual)
                .isEqualTo(expected);

    }
    @Test
    void givenRatingRequestList_whenToEntity_thenReturnEntityList(){
        RatingMapper ratingMapper = new RatingMapper();
        List<RatingRequest> ratingRequests = new ArrayList<RatingRequest>();
        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setBookId((long)1);
        ratingRequest.setUserId((long)2);
        ratingRequest.setRatingValue(5);
        ratingRequests.add(ratingRequest);

        List<Rating> expected = new ArrayList<Rating>();
        Rating rating = new Rating();
        rating.setRatingValue(5);
        rating.setBookId((long)1);
        rating.setUserId((long)2);
        expected.add(rating);

        List<Rating> actual = ratingMapper.toEntity(ratingRequests);
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }


}
