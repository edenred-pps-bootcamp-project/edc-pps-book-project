//package com.edc.pps.info.service;
//
//import com.edc.pps.info.model.Book;
//import com.edc.pps.info.repository.InMemoryBookRepository;
//import org.junit.jupiter.api.*;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class BookServiceTest extends InMemoryBookRepository{
//
//    static BookService bookService = BookService.getInstance();
//
//    @BeforeAll
//    static void clear(){
//        bookService.clearBookList();
//    }
//
//    @Test
//    void givenBook_whenSaveBook_thenReturnBook() {
//        Book book = new Book("Title","Author");
//
//        bookService.save(book);
//        Book actualBook = bookService.searchByTitle("Title").get();
//
//        assertThat(actualBook.getId()).isEqualTo(book.getId());
//    }
//
//    @Test
//    void givenBookTitle_whenDisplay_thenReturnBook() {
//        String title = "Title";
//        Book book = new Book(title,"Author");
//
//        bookService.save(book);
//        Book actualBook = bookService.find(title).get();
//
//        assertThat(actualBook.getId()).isEqualTo(book.getId());
//    }
//
//    @Test
//    Book searchByTitle(String title) {
//        return null;
//    }
//
//    @Test
//    void displayRatings() {
//    }
//
//    @Test
//    void finaAll() {
//    }
//
//    @Test
//    void updateTitle() {
//    }
//
//    @Test
//    void updateAuthor() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void deleteByAuthor() {
//    }
//
//    @Test
//    void displayAuthorBooks() {
//    }
//
//    @Test
//    void getTitleById() {
//    }
//
//    @Test
//    void getAverageRating() {
//    }
//}