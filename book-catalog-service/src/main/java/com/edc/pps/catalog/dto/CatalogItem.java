package com.edc.pps.catalog.dto;

import com.edc.pps.catalog.model.Book;
import com.edc.pps.rating.model.Rating;

public class CatalogItem {

    private Long bookId;
    private String title;
    private String author;
    private int rating;

    public Long getBookId() {
        return bookId;
    }

    public CatalogItem(Book book, Rating rating) {
        this.bookId = book.getId();
        this.author = book.getAuthor();
        this.title = book.getTitle();
        this.rating = rating.getRating();
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
