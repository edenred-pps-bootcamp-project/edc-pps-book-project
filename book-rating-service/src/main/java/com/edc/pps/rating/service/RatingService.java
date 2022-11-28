package com.edc.pps.rating.service;

import com.edc.pps.rating.dto.RatingMapper;
import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.exception.BadRequestException;
import com.edc.pps.rating.exception.RatingNotFoundException;
import com.edc.pps.rating.model.Rating;
import com.edc.pps.rating.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     *  Saves or Updates the RatingRequest
     * @param request The ratingRequest
     * @return Returns a ratingResponse
     */
    public RatingResponse saveOrUpdate(RatingRequest request) {
        log.info("saved rating to db: {}", request);
        //get all ratings from db
        List<Rating> ratings = ratingRepository.findAll();
        //check if the user already rated the book
        long result = ratings.stream().filter(entry -> entry.getBookId() == request.getBookId() && entry.getUserId() == request.getUserId()).count();

        if(request.getUserId() == null || request.getBookId() == null || request.getRatingValue() == null){
            throw new BadRequestException("bad request");
        }

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

    /**
     * @return The list of Ratings in the db
     */
    public List<RatingResponse> findAll() {
        log.debug("getting all ratings...");
        List<Rating> ratings = ratingRepository.findAll();
        return ratingMapper.toDto(ratings);
    }

    /**
     * @param id deleted the rating by id
     */
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

    public List<RatingResponse> getAllRatingsForBook(long bookId) {
        log.debug("getting all rating for bookId: {}", bookId);
        List<Rating> ratings = ratingRepository.findByBookId(bookId);
        if(ratings.isEmpty()){
            throw  new RatingNotFoundException("the book with id  " + bookId + " has no ratings");
        }

        return ratingMapper.toDto(ratings);
    }

    public List<RatingResponse> getAllBooksForUser(long userId) {
        log.debug("getting all rating for bookId: {}", userId);
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        return ratingMapper.toDto(ratings);
    }


}
