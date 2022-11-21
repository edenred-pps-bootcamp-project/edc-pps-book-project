package com.edc.pps.info.model;

public class Book implements Comparable<Book> {

    private static long countId = 0L;

    {
        countId++;
    }

    private Long id;
    private String title;
    private String author;

    private double averageRating;

    public Book(String title, String author) {
        this.id = countId;
        this.title = title;
        this.author = author;
    }


    public long getId() {
        return id;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        if ((averageRating < 1) || (averageRating > 5))
            throw new IllegalArgumentException("value is out of range for rating; it must be between 1-5");
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return averageRating != 0.0 ? "Book details:\n" +
                "ID: " + id + "\n" +
                "Title: '" + title + "\'\n" +
                "Author: " + author + "\n" +
                "Rating: " + averageRating + "\n" :
                "Book details:\n" +
                        "ID: " + id + "\n" +
                        "Title: '" + title + "\'\n" +
                        "Author: " + author + "\n" +
                        "Nu are rating" + "\n";
    }


    @Override
    public int compareTo(Book otherBook) {
        ;
        return (int) (this.id - otherBook.getId());
    }
}

