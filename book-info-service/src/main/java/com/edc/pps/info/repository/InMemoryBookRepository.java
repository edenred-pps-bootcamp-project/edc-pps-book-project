package com.edc.pps.info.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

import com.edc.pps.info.dto.RatingResponse;
import com.edc.pps.info.model.Book;

public class InMemoryBookRepository implements BookRepository {

	private Set<Book> bookList = new TreeSet<>();

	private Set<RatingResponse> ratings = new HashSet<>();

	@Override
	public Set<Book> getBookList() {
		return bookList;
	}

	@Override
	public Set<RatingResponse> getRatings() {
		return ratings;
	}
}
