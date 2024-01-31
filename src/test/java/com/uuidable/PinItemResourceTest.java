package com.uuidable;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit5.virtual.ShouldPin;
import io.quarkus.test.junit5.virtual.VirtualThreadUnit;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
@VirtualThreadUnit
@ShouldPin
class PinItemResourceTest {

	@Test
	void create_newItem_shouldPin() {
		Item item = new Item();
		item.name = "name";
		given()
				.body(item)
				.contentType(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
				.when()
				.post("/pin-items")
				.then()
				.statusCode(HttpStatus.SC_CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body("name", is(item.name));
	}
}
