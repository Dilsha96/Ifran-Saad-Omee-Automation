package Ifran_Saad_Omee_API.APIAutomationRestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BoardApiTest {
	
	
	private static final String BASE_URL = "http://localhost:3000";

    @Test(priority = 1)
    public void testGetBoards() {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/boards")
                .then()
                .extract()
                .response();

        System.out.println("Response: " + response.asPrettyString());

        assertEquals(response.statusCode(), 200, "GET /boards should return 200 OK");
    }

    @Test(priority = 2)
    public void testCreateBoard() {
        String boardName = "Test Board 01";

        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"" + boardName + "\" }")
                .when()
                .post("/api/boards")
                .then()
                .extract()
                .response();

        System.out.println("Response: " + response.asPrettyString());

        assertEquals(response.statusCode(), 201, "Board should be created successfully");

        // Optional: verify the board name
        String returnedName = response.jsonPath().getString("name");
        assertEquals(returnedName, boardName, "Created board name should match");
    }
}
