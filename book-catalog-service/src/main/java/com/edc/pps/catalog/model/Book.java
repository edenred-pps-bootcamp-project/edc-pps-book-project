package com.edc.pps.catalog.model;

// TODO: implement this
// you need the same object from the book-info-service
public class Book {
    private static long countId = 0L;

    {
        countId++;
    }

    private Long id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.id = countId;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return
                "ID: " + id + "\n" +
                "Title: '" + title + "'\n" +
                "Author: " + author + "\n" +
                "book-catalog-service.Book details:\n" +
                        "ID: " + id + "\n" +
                        "Title: '" + title + "\n" +
                        "Author: " + author + "\n" ;
    }




}
