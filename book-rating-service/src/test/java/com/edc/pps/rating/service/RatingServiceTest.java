package com.edc.pps.rating.service;

import com.edc.pps.rating.dto.RatingMapper;
import com.edc.pps.rating.repository.RatingRepository;
import com.edc.pps.rating.service.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
