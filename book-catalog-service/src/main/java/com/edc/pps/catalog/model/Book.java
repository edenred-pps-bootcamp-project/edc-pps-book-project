package com.edc.pps.catalog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;
    @Column(name = "title")
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String author;

    @Column(name = "average_rating")
    @Getter
    private double averageRating;

    public Book() {
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

