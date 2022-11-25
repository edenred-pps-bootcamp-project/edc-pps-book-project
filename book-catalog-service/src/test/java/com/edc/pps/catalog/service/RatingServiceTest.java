package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.rating.RatingMapper;
import com.edc.pps.catalog.dto.rating.RatingRequest;
import com.edc.pps.catalog.model.Rating;
import com.edc.pps.catalog.repository.RatingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatingServiceTest {

    @InjectMocks
    private RatingService ratingService;

    @Mock
    private RatingRepository ratingrepository;

    @Mock
    private RatingMapper ratingMapper;

    @Test
    void givenRatingRequest_whenSaveOrUpdate_thenReturnRatingResponse() {
        List<Rating> ratings = new ArrayList<>();
        Rating rating = new Rating();
        ratings.add(rating);
        long result = 1;
        RatingRequest request = new RatingRequest();


        Mockito.when(ratingrepository.findAll()).thenReturn(ratings);
        Mockito.when(ratingMapper.toEntity(request)).thenReturn(rating);

        assertEquals(ratings, ratingService.saveOrUpdate(request));

    }

    @Test
    void whenFindAll_thenReturnRatingResponseList() {
    }

    @Test
    void delete() {
    }

    @Test
    void givenBookId_whenGetAllRatingsForBook_thenReturnRatingResponseList() {
    }
}