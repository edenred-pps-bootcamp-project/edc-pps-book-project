package com.edc.pps.rating.model;

import com.sun.istack.NotNull;
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
    private Long ratingId;
    @Column(name = "book_id")
    @NotNull
    private Long bookId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "rating_value")
    private int ratingValue;

    public Rating(long bookId, long userId, int rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
    }

}
