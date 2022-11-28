package com.edc.pps.rating.repository;

import com.edc.pps.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

	@Query(value = "SELECT * FROM Rating WHERE book_id = :bookId and user_id = :userId",
			nativeQuery = true)
	Rating findByBookIdAndUserId(@Param("bookId") long bookId, @Param("userId") long userId);

	List<Rating> findByBookId(long id);

	List<Rating> findByUserId(long id);

	Optional<Rating> findByRatingId(long id);
}
