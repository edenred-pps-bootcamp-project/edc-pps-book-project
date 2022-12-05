package com.edc.pps.rating;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ConnTest {
    public static void main(String[] args){
        HttpResponse<String> response = Unirest.post("http://localhost:7601/api/ratings")
                .header("Content-Type", "application/json")
                .body("{\r\n    \"bookId\": 3,\r\n    \"userId\": 31,\r\n    \"ratingValue\": 2\r\n}")
                .asString();
        System.out.println(response);
    }
}

