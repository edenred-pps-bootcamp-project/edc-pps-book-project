package com.edc.pps.rating.controller;
import com.edc.pps.rating.dto.RatingRequest;
import com.edc.pps.rating.dto.RatingResponse;
import com.edc.pps.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RequestMapping("api/ratings")
@RestController
public class RatingController {

    private final RatingService ratingService;


    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<RatingResponse> saveOrUpdate(@RequestBody RatingRequest request) {
        return new ResponseEntity<>(ratingService.saveOrUpdate(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RatingResponse>> findAll() {
        return new ResponseEntity<>(ratingService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
        ratingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<RatingResponse>> getAllRatingsForBook(@PathVariable Long id) {
        return new ResponseEntity<>(ratingService.getAllRatingsForBook(id), HttpStatus.OK);
    }

}
