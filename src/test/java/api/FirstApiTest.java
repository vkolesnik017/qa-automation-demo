package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FirstApiTest {
    @Test
    public void test() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
              //  .pathParam("id", 1)
                     .queryParam("userId", 1)
                .log().all()
                .when()
              //  .get("/posts/{id}")
                    .get("/posts")
                .then()
                .log().all()
                .statusCode(200)
        //        .body("id", equalTo(1))
         //       .body("userId", equalTo(1))
                .body("title", not(emptyString()));
    }
}
