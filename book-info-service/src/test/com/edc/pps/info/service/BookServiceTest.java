package com.edc.pps.info.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Starting tests...");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Testing ended");
    }
    @Test
    void givenBook_whenSave_thenReturnBook(){
        //given

        //when


        //add
    }

    @Test
    void save() {
        assertThat(true).isTrue();
    }

    @Test
    void findAll() {
    }

    @Test
    void getBooksForTitle() {
    }

    @Test
    void updateTitle() {
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void delete() {
    }

    @Test
    void getBooksByAuthor() {
    }

    @Test
    void assertNull(){

    }
}