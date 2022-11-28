package com.edc.pps.info.dto;

import com.edc.pps.info.model.Book;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BookMapperTest {
    @Test
    void givenEntity_whenToDto_thenReturnDto(){
        BookMapper bookMapper = new BookMapper();

        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");

        BookResponse expected = new BookResponse();
        expected.setId(0L);
        expected.setTitle("title");
        expected.setAuthor("author");

        BookResponse actual = bookMapper.toDto(book);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void givenBookRequest_whenToEntity_thenReturnEntity(){
        BookMapper bookMapper = new BookMapper();
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");

        Book expected = new Book();
        expected.setTitle("title");
        expected.setAuthor("author");

        Book actual = bookMapper.toEntity(bookRequest);
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
