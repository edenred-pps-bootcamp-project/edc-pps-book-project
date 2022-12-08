package com.edc.pps.info.controller;

import com.edc.pps.info.config.H2TestProfileJpaConfig;
import com.edc.pps.info.config.SpringTestingApplication;
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
import static org.assertj.core.api.BDDAssumptions.given;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = {SpringTestingApplication.class, H2TestProfileJpaConfig.class}
)
class ControllerRestAssuredIntegrationTest {

	private static final String API_BOOKS = "/books";

	@LocalServerPort
	public int port;

	@Autowired
	BookService bookService;

	@BeforeEach
	void setUp(){
		RestAssured.baseURI = "http://localhost:" + port + "/api";
		RestAssured.port = port;
	}

	@Test
	void create() {
	}

//	@Test
//	void givenRequest_whenFindAll_thenReturn200(){
//		BookRequest request = new BookRequest();
//		request.setTitle("title");
//		request.setAuthor("author");
//		bookService.save(request);
//
//		given()
//				.when()
//				.get(API_BOOKS)
//				.then()
//				.assertThat()
//				.statusCode(200)
//				.contentType(ContentType.JSON)
//				.body("[0].title", equalTo("title"));
//	}
//	@Test
//	public void createBookPositiveTest() {
//		given()
//				.baseUri("http://localhost:8082/api/books")
//				.contentType("application/json")
//				.body("{\n" +
//						"  \"author\": \"autor_alex\",\n" +
//						"  \"averageRating\": 0,\n" +
//						"  \"id\": 0,\n" +
//						"  \"title\": \"titlu_test\"\n" +
//						"}")
//				.when()
//				.post()
////                .then().statusCode(200)
//				.getBody()
//				.prettyPrint();
//
//	}

}