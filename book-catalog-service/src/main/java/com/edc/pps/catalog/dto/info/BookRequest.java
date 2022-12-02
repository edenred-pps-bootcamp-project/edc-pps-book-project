package com.edc.pps.catalog.dto.info;

import lombok.Data;

@Data
public class BookRequest {

    private String title;

    private String author;

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
}
