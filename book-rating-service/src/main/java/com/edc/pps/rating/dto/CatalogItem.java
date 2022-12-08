package com.edc.pps.rating.dto;

import javax.persistence.Embeddable;

@Embeddable
public class CatalogItem {
    private Long bookId;
    private String title;
    private String author;
    private int rating;


    public CatalogItem() {
    }

    public CatalogItem(Long bookId, String title, String author, int rating) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.rating = rating;
    }

    public Long getBookId() {
        return bookId;
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
