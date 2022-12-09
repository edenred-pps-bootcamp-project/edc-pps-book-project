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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Service
public class RatingService {

    private final RatingMapper ratingMapper;
    private final RatingRepository ratingRepository;

    private final BookService bookService;

    @Autowired
    public RatingService(RatingMapper ratingMapper, RatingRepository ratingRepository, BookService bookService) {
        this.ratingMapper = ratingMapper;
        this.ratingRepository = ratingRepository;
        this.bookService = bookService;
    }



    /**
     *  Saves or Updates the Rating
     * @param request The ratingRequest
     * @return Returns a ratingResponse
     */
    public RatingResponse saveOrUpdate(RatingRequest request) {
        //validate request
        validateRequest(request);
        //check if book and user exist in database
       bookService.checkIfBookExists(request.getBookId());
       bookService.checkIfUserExists(request.getUserId());

        //get all ratings from db
        List<Rating> ratings = ratingRepository.findAll();
        //check if the user already rated the book
        long result = ratings.stream().filter(entry -> entry.getBookId().equals(request.getBookId()) && entry.getUserId().equals(request.getUserId())).count();


        //if the user never rated the book it will be added as a new entry in db
        if (result == 0) {
            Rating rating = ratingMapper.toEntity(request);
            ratingRepository.save(rating);
            bookService.callForUpdateRating(request.getBookId(), getAverageRatingForBook(request.getBookId()));
            return ratingMapper.toDto(rating);
        }
        //if the user already rated the book it will be updated
        else {
            Rating foundRating = ratingRepository.findByBookIdAndUserId(request.getBookId(), request.getUserId());
            foundRating.setRatingValue(new Double(request.getRatingValue()));
            ratingRepository.save(foundRating);
            bookService.callForUpdateRating(request.getBookId(), getAverageRatingForBook(request.getBookId()));
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
     * @param id Rating id to be deleted.
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

    /** Given a book id will return all the ratings for the specified book.
     * @param bookId The book id
     * @return Returns a list of RatingResponse,
     */
    public List<RatingResponse> getAllRatingsForBook(long bookId) {
        log.debug("getting all rating for bookId: {}", bookId);
        List<Rating> ratings = ratingRepository.findByBookId(bookId);
        if(ratings.isEmpty()){
            throw  new RatingNotFoundException("the book with id  " + bookId + " has no ratings");
        }

        return ratingMapper.toDto(ratings);
    }

    /** Given an user id will return all the books that the user has rated.
     * @param userId The user id
     * @return Returns a list of RatingResponse.
     */
    public List<RatingResponse> getAllRatingsForUser(long userId) {
        log.debug("getting all rating for bookId: {}", userId);
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        if(ratings.isEmpty()){
            throw  new RatingNotFoundException("the user with id  " + userId + " didn't rate any books");
        }
        return ratingMapper.toDto(ratings);
    }

    private void validateRequest(RatingRequest request){
        if(request.getUserId() == null){
            log.info("UserId cannot be null: \n" + request.toString());
            throw new BadRequestException("UserId cannot be null");
        } else if (request.getUserId() < 0) {
            log.info("UserId cannot be negative: \n" + request.toString());
            throw new BadRequestException("UserId cannot be negative");
        }
        if(request.getBookId() == null){
            log.info("BookId cannot be null: \n" + request.toString()) ;
            throw new BadRequestException("BookId cannot be null");
        } else if (request.getBookId() < 0) {
            log.info("BookId cannot be negative: \n" + request.toString());
            throw new BadRequestException("BookId cannot be negative");
        }
        if(request.getRatingValue() == null){
            log.info("RatingValue cannot be null: \n" + request.toString());
            throw new BadRequestException("RatingValue cannot be null");
        } else if (request.getRatingValue() < 0) {
            log.info("RatingValue cannot be negative: \n" + request.toString());
            throw new BadRequestException("RatingValue cannot be negative");
        }

    }



    public RatingResponse getAverageRatingForBook(long bookId) {
        Double ratingTotal = 0d;
        List<RatingResponse> responses = getAllRatingsForBook(bookId);
        Stream<RatingResponse> ratingResponseStream = responses.stream();
        ratingTotal = ratingResponseStream
                .mapToDouble(ratingResponse -> ratingResponse.getRatingValue())
                .sum();
        long ratingNumber = responses.size();
        RatingResponse averageRatingResponse = new RatingResponse();
        averageRatingResponse.setRatingValue(ratingTotal/ratingNumber);
        averageRatingResponse.setBookId(bookId);
        averageRatingResponse.setUserId(-1L);
        List<RatingResponse> ratingResponses = new ArrayList<>();
        ratingResponses.add(averageRatingResponse);
        return averageRatingResponse;
    }

    public RatingResponse getRatingById(Long id) {
        Optional<Rating> foundRating = ratingRepository.findByRatingId(id);
        if(foundRating.isPresent()){
            return ratingMapper.toDto(foundRating.get());
        }
        throw new RatingNotFoundException("No rating with ID: " + id);
    }
}
