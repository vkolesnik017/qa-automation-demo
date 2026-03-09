package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestPostTest {
    @Test
    public void test() {
        int postId = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType("application/json")
                .body("""
                        {
                          "title": "test automation",
                          "body": "restassured practice",
                          "userId": 1
                        }
                        """)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");


        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/{id}", postId)
                .then()
                .statusCode(200);
    }
}
