package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ThirdTask {
    @Test
    public void test() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .when()
                .get("/comments")
                .then()
                .statusCode(200)
                .body("",hasSize(greaterThan(400)))
                .body("email", everyItem(containsString("@")));
    }
}
