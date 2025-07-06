package Ifran_Saad_Omee_API.APIAutomationRestAssured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class DeleteList {
	
	
	 private static final String BASE_URL = "http://localhost:3000";

	    @Test(priority = 4)
	    public void testDeleteList() {
	        int listId = 142; 

	        Response response = RestAssured
	            .given()
	            .baseUri(BASE_URL)
	            .when()
	            .delete("/api/lists/" + listId)
	            .then()
	            .extract()
	            .response();

	        System.out.println("Response: " + response.asPrettyString());

	        // Assert correct status code (assumes 200 or 204)
	        int statusCode = response.statusCode();
	        boolean isSuccess = statusCode == 200 || statusCode == 204;

	        assertEquals(isSuccess, true, "List should be deleted successfully. Status: " + statusCode);
	    }

}
