package org.irompion;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello tout le monde"));
    }

    @Test
    public void testBonjourEndpoint() {
        String greeting = "bonjour";
        given()
          .when().get("/hello/fr")
          .then()
             .statusCode(200)
             .body(is(greeting + " tout le monde"));
    }

}