package com.edc.pps.info.repository;

import java.util.Set;

import com.edc.pps.info.dto.RatingResponse;
import com.edc.pps.info.model.Book;

public interface BookRepository {

	// TODO: move theses to the implementation class, never in interface
	Set<Book> getBookList();

	Set<RatingResponse> getRatings();

}
