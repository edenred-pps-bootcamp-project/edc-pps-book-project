package com.edc.pps.rating;

import com.edc.pps.rating.dto.RatingMapper;
import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.model.Rating;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RatingMapperTest {
    @Test
    void givenEntity_whenToDto_thenReturnDto(){
        RatingMapper ratingMapper = new RatingMapper();
        Rating rating = new Rating();
        rating.setRatingValue(5);
        rating.setBookId(1);
        rating.setUserId(2);

        RatingResponse expected = new RatingResponse();
        expected.setUserId(2);
        expected.setBookId(1);
        expected.setRatingValue(5);

        RatingResponse actual = ratingMapper.toDto(rating);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void givenRatingRequest_whenToEntity_thenReturnEntity(){
        RatingMapper ratingMapper = new RatingMapper();
        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setBookId(1);
        ratingRequest.setUserId(2);
        ratingRequest.setRatingValue(5);

        Rating expected = new Rating();
        expected.setRatingValue(5);
        expected.setBookId(1);
        expected.setUserId(2);

        Rating actual = ratingMapper.toEntity(ratingRequest);
        
    }
    @Test
    void givenListOfEntities_whenToDto_thenReturnListOfDto(){
        
    }
    @Test
    void givenRatingRequestList_whenToEntity_thenReturnEntityList(){
    }


}
