package com.edc.pps.catalog.repository.service;

import com.edc.pps.catalog.dto.info.BookResponse;
import com.edc.pps.catalog.dto.rating.RatingMapper;
import com.edc.pps.catalog.dto.rating.RatingRequest;
import com.edc.pps.catalog.dto.rating.RatingResponse;
import com.edc.pps.catalog.exception.RatingNotFoundException;
import com.edc.pps.catalog.model.Rating;
import com.edc.pps.catalog.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RatingService {

    private static final String RATING_RESOURCE = "http://localhost:8082/api/ratings";

    private final RestTemplate restTemplate;

    @Autowired
    public RatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     *
     * @param request
     * @return
     */
    public RatingResponse saveOrUpdate(RatingRequest request) {
        log.info("saved rating to db: {}", request);
        return restTemplate.postForObject(RATING_RESOURCE, request, RatingResponse.class);
    }

    /**
     *
     * @return
     */
    public List<RatingResponse> findAll() {
        log.debug("getting all ratings...");

        return (List<RatingResponse>) restTemplate.getForObject(RATING_RESOURCE, RatingResponse.class);
    }

    /**
     *
     * @param id
     */
    public void delete(Long id) {
        log.info("deleting rating {}", id);
        restTemplate.delete(RATING_RESOURCE + "/" + id);
    }

    // method to get all ratings for a certain book to calculate average

    public List<RatingResponse> getAllRatingsForBook(long bookId) {
        log.debug("getting all rating for bookId: {}", bookId);
        return (List<RatingResponse>) restTemplate.getForObject(RATING_RESOURCE + "/" + bookId, RatingResponse.class);
    }
}
