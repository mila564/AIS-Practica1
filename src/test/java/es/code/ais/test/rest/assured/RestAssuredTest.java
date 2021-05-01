package es.code.ais.test.rest.assured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import es.urjc.code.daw.library.Application;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest(
classes = Application.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestAssuredTest{
	
	@LocalServerPort
	int port;
	
	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
	}
	
	@Test
	void bookSaveRestAssuredTest() {
		
		// Given
		
		Response response = given().
			contentType("application/json").
			body("{\"title\":\"cumbres borrascosas\",\"description\":\"libro de amor\" }").
		
		// When
		
		when().
			post("/api/books/").thenReturn();
		
		Integer id = from(response.getBody().asString()).get("id");

		// Then
		
		when().
			get("api/books/{id}", id).
		then()
			.statusCode(200).
			body("title", equalTo("cumbres borrascosas")).
			body("description", equalTo("libro de\namor"));
		
	}
	
	@Test
	void bookDeleteRestAssuredTest() {
		
		//Given 
		
		Response response = given().
				contentType("application/json").
				body("{\"title\":\"cumbres borrascosas\",\"description\":\"libro de amor\" }").
				
		when().
			post("/api/books/").thenReturn();		
		
		Integer id = from(response.getBody().asString()).get("id");
		
		//When

		when().
			delete("/api/books/{id}",id).
			
	    //Then	
			
		then().
			statusCode(200);
		
		when()
			.get("/api/books/{id}",id).
		then()
			.statusCode(404);
		
	}
	
}
