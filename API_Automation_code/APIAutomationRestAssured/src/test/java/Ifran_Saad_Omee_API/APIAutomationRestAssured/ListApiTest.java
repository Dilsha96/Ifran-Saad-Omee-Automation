package Ifran_Saad_Omee_API.APIAutomationRestAssured;

import io.restassured.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ListApiTest {
	
	private static final String BASE_URL = "http://localhost:3000";

    @Test(priority = 3)
    public void testCreateList() {
        // Set the request body
        int boardId = 190;  
        String listName = "Green";
        int order = 0;

        String requestBody = String.format(
            "{ \"boardId\": %d, \"name\": \"%s\", \"order\": %d }",
            boardId, listName, order
        );

        // Make the POST request
        Response response = RestAssured
            .given()
            .baseUri(BASE_URL)
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/api/lists")
            .then()
            .extract()
            .response();

        // Print response (for debug)
        System.out.println("Response: " + response.asPrettyString());

        // Assertions
        assertEquals(response.statusCode(), 201, "Expected status 201 Created");

        // Optional: Verify response values
        String returnedName = response.jsonPath().getString("name");
        int returnedBoardId = response.jsonPath().getInt("boardId");

        assertEquals(returnedName, listName, "List name should match");
        assertEquals(returnedBoardId, boardId, "Board ID should match");
    }

}
