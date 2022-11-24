package com.edc.pps.rating.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@NoArgsConstructor
@Data
@ToString
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private long ratingId;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "rating_value")
    private int ratingValue;

    public Rating(long bookId, long userId, int rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
    }

}
