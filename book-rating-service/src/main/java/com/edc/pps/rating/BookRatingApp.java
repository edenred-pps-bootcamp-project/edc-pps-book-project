package com.edc.pps.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookRatingApp {
    public static void main(String[] args) {
        SpringApplication.run(BookRatingApp.class);
    }
}
