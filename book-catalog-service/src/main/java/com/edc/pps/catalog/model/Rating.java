package com.edc.pps.catalog.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Long ratingId;
    @Column(name = "book_id")
    @NotNull
    private Long bookId;
    @Column(name = "user_id")
    @NotNull
    private Long userId;
    @Column(name = "rating_value")
    @NotNull
    private Integer ratingValue;

    public Rating(long bookId, long userId, int rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
    }

}
