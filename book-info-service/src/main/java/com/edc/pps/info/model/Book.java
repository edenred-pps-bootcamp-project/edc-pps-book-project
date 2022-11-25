package com.edc.pps.info.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    private String author;

    @Column(name = "average_rating")
    private double averageRating;

    public Book() {
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

}

