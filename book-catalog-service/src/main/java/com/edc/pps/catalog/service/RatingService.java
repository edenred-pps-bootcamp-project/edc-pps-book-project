package com.edc.pps.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edc.pps.catalog.dto.rating.RatingMapper;
import com.edc.pps.catalog.dto.rating.RatingRequest;
import com.edc.pps.catalog.dto.rating.RatingResponse;
import com.edc.pps.catalog.exception.RatingNotFoundException;
import com.edc.pps.catalog.model.Rating;
import com.edc.pps.catalog.repository.RatingRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RatingService {

    private final RatingMapper ratingMapper;
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public RatingResponse saveOrUpdate(RatingRequest request) {
        log.info("saved rating to db: {}", request);
        //get all ratings from db
        List<Rating> ratings = ratingRepository.findAll();
        //check if the user already rated the book
        long result = ratings.stream().filter(entry -> entry.getBookId() == request.getBookId() && entry.getUserId() == request.getUserId()).count();

        //if the user never rated the book it will be added as a new entry in db
        if (result == 0) {
            Rating rating = ratingMapper.toEntity(request);
            ratingRepository.save(rating);
            return ratingMapper.toDto(rating);
        }
        //if the user already rated the book it will be updated
        else {
            Rating foundRating = ratingRepository.findByBookIdAndUserId(request.getBookId(), request.getUserId());
            foundRating.setRatingValue(request.getRatingValue());
            ratingRepository.save(foundRating);
            return ratingMapper.toDto(foundRating);
        }
    }

    public List<RatingResponse> findAll() {
        log.debug("getting all ratings...");
        List<Rating> ratings = ratingRepository.findAll();
        return ratingMapper.toDto(ratings);
    }

    public void delete(Long id) {
        //1. rating with id was not found
        Optional<Rating> rating = ratingRepository.findByRatingId(id);
        if (rating.isEmpty()) {
            throw new RatingNotFoundException("no rating with id: " + id);
        } else {
            log.debug("deleting rating with id: {}", id);
            ratingRepository.deleteById(id);
        }
    }

    // method to get all ratings for a certain book to calculate average

    public List<RatingResponse> getAllRatingsForBook(long bookId) {
        log.debug("getting all rating for bookId: {}", bookId);
        List<Rating> ratings = ratingRepository.findByBookId(bookId);
        return ratingMapper.toDto(ratings);
    }
}
