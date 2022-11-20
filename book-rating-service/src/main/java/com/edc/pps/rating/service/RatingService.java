package com.edc.pps.rating.service;

import com.edc.pps.rating.dto.RatingMapper;
import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.model.Rating;
import com.edc.pps.rating.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RatingService {

    // TODO use constructor injection for the dependencies
    private static final Logger log = LoggerFactory.getLogger(RatingService.class);
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
      if(result == 0) {
          Rating rating = ratingMapper.toEntity(request);
          ratingRepository.save(rating);
          return ratingMapper.toDto(rating);
      }
      //if the user already rated the book it will be updated
        else{
          Rating foundRating =  ratingRepository.findByBookIdAndUserId(request.getBookId(),request.getUserId());
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
        log.debug("deleting rating with id: {}", id);
        ratingRepository.deleteById(id);
    }

    //method to get all ratings for a certain book to calculate avergae

    public List<RatingResponse> getAllRatingsForBook(long bookId){
        //find all books where book_id = ?
        log.debug("getting all rating for bookId: {}", bookId);
    List<Rating> ratings = ratingRepository.findByBookId(bookId);
    return ratingMapper.toDto(ratings) ;
    }


}
