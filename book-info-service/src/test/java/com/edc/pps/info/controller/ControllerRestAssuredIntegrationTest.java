package com.edc.pps.info.controller;

import com.edc.pps.info.config.H2TestProfileJpaConfig;
import com.edc.pps.info.config.SpringTestingApplication;
import com.edc.pps.info.dto.BookRequest;
import com.edc.pps.info.exceptions.BookAlreadyExistsException;
import com.edc.pps.info.service.BookService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {SpringTestingApplication.class, H2TestProfileJpaConfig.class}
)
class ControllerRestAssuredIntegrationTest {

    private static final String API_BOOKS = "/books";
    public final String JSON_CT = "application/json";

    @LocalServerPort
    public int port;

    @Autowired
    BookService bookService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port + "/api";
        RestAssured.port = port;
    }

    @Test
    void create() {
    }

    @Test
    void givenRequest_whenFindAll_thenReturn200() throws BookAlreadyExistsException {
        BookRequest request = new BookRequest();
        request.setTitle("title");
        request.setAuthor("author");
        bookService.save(request);

        given()
                .baseUri("http://localhost:8084/api")
                .when()
                .get(API_BOOKS)
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(JSON_CT);
    }

    @Test
    public void createBookPositiveTest() {
        given()
                .baseUri("http://localhost:8084/api/books")
                .contentType("application/json")
                .body("{\n" +
                        "  \"author\": \"author\",\n" +
                        "  \"title\": \"title\"\n" +
                        "}")
                .when()
                .post()
//                .then().statusCode(200)
                .getBody()
                .prettyPrint();

    }

}