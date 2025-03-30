package TestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dz17Postman{

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGet() {
        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    public void testPost() {
        String requestBody = "{\"test\": \"value\"}";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post");
        assertEquals(200, response.getStatusCode());
        assertEquals("value", response.jsonPath().getString("json.test"));
        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"));
    }

    @Test
    public void testPut() {
        String requestBody = "{\"updated\": \"data\"}";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put");
        assertEquals(200, response.getStatusCode());
        assertEquals("data", response.jsonPath().getString("json.updated"));
        assertEquals("https://postman-echo.com/put", response.jsonPath().getString("url"));
    }

    @Test
    public void testPatch() {
        String requestBody = "{\"patched\": \"value\"}";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch");
        assertEquals(200, response.getStatusCode());
        assertEquals("value", response.jsonPath().getString("json.patched"));
        assertEquals("https://postman-echo.com/patch", response.jsonPath().getString("url"));
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "{\"id\": 123}";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .delete("/delete");
        assertEquals(200, response.getStatusCode());
        assertEquals(123, response.jsonPath().getInt("json.id"));
        assertEquals("https://postman-echo.com/delete", response.jsonPath().getString("url"));
    }
}