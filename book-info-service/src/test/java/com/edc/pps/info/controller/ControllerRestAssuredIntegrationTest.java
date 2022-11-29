//package com.edc.pps.info.controller;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static io.restassured.RestAssured.given;
//import com.edc.pps.info.config.H2TestProfileJpaConfig;
//import com.edc.pps.info.config.SpringTestingApplication;
//import com.edc.pps.info.dto.BookRequest;
//import com.edc.pps.info.service.BookService;
//import jdk.jfr.ContentType;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(
//		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//		classes = {SpringTestingApplication.class, H2TestProfileJpaConfig.class}
//)
//class ControllerRestAssuredIntegrationTest {
//
//	private static final API_BOOKS = "/books";
//
//	@LocalServerPort
//	public int port;
//
//	@Autowired
//	BookService bookService;
//
//	@BeforeEach
//	void setUp(){
//		RestAssured.baseURI = "http://localhost:" + port + "/api";
//		RestAssured.port = port;
//	}
//
//	@Test
//	void create() {
//	}
//
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
//
//}