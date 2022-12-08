package com.edc.pps.rating.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

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
    @NotNull
    private Long userId;
    @Column(name = "rating_value")
    @NotNull
    private Double ratingValue;

    public Rating(long bookId, long userId, double rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
    }

}
