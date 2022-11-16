package com.edc.pps.info.model;

public class Book implements Comparable<Book> {

    private static long countId = 0L;

    {
        countId++;
    }

    // TODO: use Long for ids
    private long id;
    private String title;
    private String author;

    // TODO: remove this, the rating is saved in the book-rating-service
    private int rating;
    private double avgRating = .2f;

    public Book(String title, String author) {
        this.id = countId;
        this.title = title;
        this.author = author;
    }

    public long getId() {
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

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if ((rating < 1) || (rating > 5))
            throw new IllegalArgumentException("value is out of range for rating; it must be between 1-5");
        this.rating = rating;
    }
    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    @Override
    public String toString() {
        return rating != 0.0 ? "bookinfo.Book details:\n" +
                "ID: " + id + "\n" +
                "Title: '" + title + "\'\n" +
                "Author: " + author + "\n" +
                "bookinfo.Rating: " + rating + "\n" :
                "bookinfo.Book details:\n" +
                        "ID: " + id + "\n" +
                        "Title: '" + title + "\'\n" +
                        "Author: " + author + "\n" +
                        "Nu are rating" + "\n";
    }


    @Override
    public int compareTo(Book o) {
        Book otherBook = (Book) o;
        return (int) (this.id - otherBook.getId());
    }
}

