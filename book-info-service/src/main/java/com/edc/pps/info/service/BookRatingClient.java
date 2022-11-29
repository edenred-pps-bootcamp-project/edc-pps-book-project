package com.edc.pps.info.service;

import com.edc.pps.info.dto.rating.RatingResponse;
import com.edc.pps.info.dto.rating.RatingResponseList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class BookRatingClient {

    private static final String RATING_RESOURCE = "http://localhost:7601/api/ratings/books/";
    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    public BookRatingClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<RatingResponse> findRatingsById(Long bookId) {
        log.debug("getting all books...");
        return (List<RatingResponse>) restTemplate.getForObject(RATING_RESOURCE + bookId, RatingResponse.class);
    }
}
