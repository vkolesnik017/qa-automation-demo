package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqresTest {

    @Test
    public void testRequest() {

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .log().all()
                //   .pathParam("id", 1)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("email", hasItem("Sincere@april.biz"));



              /*  .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", not(emptyOrNullString()));*/
    }
}
