package com.edc.pps.info.dto;

import com.edc.pps.info.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public List<BookResponse> toDto(List<Book> books) {
        return books.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BookResponse toDto(Book book) {
        BookResponse dto = new BookResponse();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        return dto;
    }

    public List<Book> toEntity(List<BookRequest> bookRequests){
        return bookRequests.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public Book toEntity(BookRequest bookRequest) {
        Book entity = new Book();
        entity.setTitle(bookRequest.getTitle());
        entity.setAuthor(bookRequest.getAuthor());

        return entity;
    }
}
