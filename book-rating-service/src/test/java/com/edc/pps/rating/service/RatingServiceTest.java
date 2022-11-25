package com.edc.pps.rating.service;

import com.edc.pps.rating.dto.RatingMapper;
import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.model.Rating;
import com.edc.pps.rating.repository.RatingRepository;
import com.edc.pps.rating.service.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private RatingMapper ratingMapper;

    @InjectMocks
    private RatingService ratingService;

    @Test
    void givenRatingRequest_whenSaveOrUpdate_thenReturnRatingResponse(){
        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setRatingValue(5);
        ratingRequest.setBookId(1L);
        ratingRequest.setUserId(23L);

        List<Rating> mockRatings = new ArrayList<>();
        Rating rating = new Rating();
        rating.setUserId(23L);
        rating.setRatingValue(5);
        rating.setBookId(1L);
        mockRatings.add(rating);

        RatingResponse expected = new RatingResponse();
        expected.setUserId(23L);
        expected.setRatingValue(5);
        expected.setBookId(1L);

        when(ratingMapper.toEntity(any(RatingRequest.class)))
                .thenReturn(rating);
        when(ratingRepository.save(any(Rating.class)))
                .thenReturn(rating);
        when(ratingMapper.toDto(any(Rating.class)))
                .thenReturn(expected);

        RatingResponse actual = ratingService.saveOrUpdate(ratingRequest);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenFindAll_thenReturnRatingResponseList(){

    }

    @Test
    void delete(){

    }
    @Test
    void givenBookId_whenGetAllRatingsForBook_thenReturnRatingResponseList(){


    }

}
