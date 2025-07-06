package com.transmedia_ui.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.transmedia_ui.qa.base.TestBase;
import com.transmedia_ui.qa.pages.BoardPage;
import com.transmedia_ui.qa.pages.HomePage;
import com.transmedia_ui.qa.util.TestDataUtil;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	String listTitle;
    BoardPage boardPage;
    
    
    
    public HomePageTest()
    {
    	super();
    }

    @BeforeMethod
    public void setup() //set up method
    {
    	initialization(); // From TestBase: Launch browser, go to URL, etc.
       
    	boardPage=new BoardPage();
    	boardPage.clickCreateNewBoard();
    	homePage=new HomePage();
    	
    	
   
    	// Generate unique board name
        String boardName = "Test Board " + System.currentTimeMillis();
        boardPage.enterBoardName(boardName);
        boardPage.clickCreateBoardbtn();

        // Step 2: Navigate to HomePage 
        homePage = new HomePage(); 
        listTitle=TestDataUtil.getList1();
    }


   
      
    @Test(priority = 1)
    public void testAddTwoLists() {
        System.out.println("===== Test: Add Two Lists =====");
        
        
        
        //homePage.addList(listTitle);
        String list1 = "List One " + System.currentTimeMillis();
        String list2 = "List Two " + System.currentTimeMillis();

     // Add first list
         System.out.println("Adding list: " + list1);
         homePage.addList(list1);
         System.out.println("✅ List added: " + list1);
      // Assert.assertTrue(homePage.isListPresent(list1), "List1 should be present after creation");

      // Add second list
        System.out.println("Adding list: " + list2);
        homePage.addList(list2);
        System.out.println("✅ List added: " + list2);
       //Assert.assertTrue(homePage.isListPresent(list2), "List2 should be present after creation");

        /// Validate the total number of lists
        int actualCount = homePage.getListCount();
        System.out.println("Total lists present: " + actualCount);
        
        
        Assert.assertEquals(actualCount, 2, "Expected exactly 2 lists to exist.");
        System.out.println("✅ Test Passed: Two lists were added successfully.");
    
    } 
   	
    

	
@Test(priority = 2, dependsOnMethods = "testAddTwoLists")

public void testDeleteOneList() 
// Step 3: Delete one list
{
  
  homePage.deleteFirstList();
  assertEquals(1, homePage.getListCount(), "List count should be 1 after deleting one list.");
}
    
    
    
@AfterMethod
public void teardown() {
    driver.quit();
}
}   


