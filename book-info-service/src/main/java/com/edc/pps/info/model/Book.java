package com.edc.pps.info.model;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "books",
        uniqueConstraints={
        @UniqueConstraint(columnNames = {"title", "author"})
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NonNull
    private String title;

    @NotNull
    private String author;

    @Nullable
    @Column(name = "average_rating")
    private Double averageRating;

    public Book() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author.trim();
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        if ((averageRating < 1) || (averageRating > 5))
            throw new IllegalArgumentException("Value is out of range for rating. It must be between 1-5");
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return averageRating != null ? "Book details:\n" +
                "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Rating: " + averageRating + "\n" :
                "Book details:\n" +
                        "ID: " + id + "\n" +
                        "Title: " + title + "\n" +
                        "Author: " + author + "\n" +
                        "Nu are rating" + "\n";
    }

}

