package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.rating.RatingRequest;
import com.edc.pps.catalog.dto.rating.RatingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class RatingService {

    private static final String RATING_RESOURCE = "http://localhost:7601/api/ratings";

    private final RestTemplate restTemplate;

    @Autowired
    public RatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @param request
     * @return
     */
    public RatingResponse saveOrUpdate(RatingRequest request) {
        log.info("saved rating to db: {}", request);
        return restTemplate.postForObject(RATING_RESOURCE, request, RatingResponse.class);
    }

    /**
     * @return
     */
    public List<RatingResponse> findAll() {
        log.debug("getting all ratings...");

        return (List<RatingResponse>) restTemplate.getForObject(RATING_RESOURCE, RatingResponse.class);
    }

    public RatingResponse findById(Long id) {
        log.debug("getting rating with id {}", id);

        return restTemplate.getForObject(RATING_RESOURCE + "/" + id, RatingResponse.class);
    }

    /**
     * @param id
     */
    public void delete(Long id) {
        log.info("deleting rating {}", id);
        restTemplate.delete(RATING_RESOURCE + "/" + id);
    }

    // method to get all ratings for a certain book to calculate average

    public RatingResponse[] getAllRatingsForBook(Long bookId) {
        log.debug("getting all rating for bookId: {}", bookId);
        return restTemplate.getForObject(RATING_RESOURCE + "/books/" + bookId, RatingResponse[].class);
    }

    public RatingResponse[] getAllRatingsForUser(Long userId) {
        return restTemplate.getForObject(RATING_RESOURCE + "/users/" + userId, RatingResponse[].class);
    }

    public RatingResponse getRatingById(Long id) {
        return restTemplate.getForObject(RATING_RESOURCE + "/" + id, RatingResponse.class);
    }
}
