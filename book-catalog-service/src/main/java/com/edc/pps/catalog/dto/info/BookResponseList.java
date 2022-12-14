package com.edc.pps.catalog.dto.info;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResponseList {

    @JsonProperty
    private List<BookResponse> bookResponses;

    public List<BookResponse> getBookResponses() {
        return bookResponses;
    }

    public void setBookResponses(List<BookResponse> bookResponses) {
        this.bookResponses = bookResponses;
    }
}
