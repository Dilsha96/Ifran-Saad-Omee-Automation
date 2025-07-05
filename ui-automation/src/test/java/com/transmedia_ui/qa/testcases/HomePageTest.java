package com.transmedia_ui.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
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
        homePage.listTitleInput(listTitle);
        // Step 1: Generate first list name
        
        String list1 = "List One " + System.currentTimeMillis();
        String list2 = "List Two " + System.currentTimeMillis();

        homePage.addList(list1);
        System.out.println("Added list: " + list1);

        homePage.addList(list2);
        System.out.println("Added list: " + list2);

       // int actualCount = homePage.getListCount();
       // System.out.println("Total lists on UI: " + actualCount);

       // Assert.assertEquals(actualCount, 2, "Expected 2 lists after adding.");
    }
    

//        // Step 1: Create a unique list title
//        
//        System.out.println("Step 1: List title → " + listTitle);
//        homePage.addList(listTitle);
//
//        // Step 2: Add the list
//        System.out.println("Step 2: Enter title and click 'Add List'");
//        homePage.addList(listTitle);
//
//   
//
//        // Step 3: Verify the list was added
//        System.out.println("Step 3: Verifying list is present...");
//        Assert.assertTrue(homePage.isListPresent(listTitle), "List was not added successfully.");
//    }
//		
	
//@Test(priority = 3, dependsOnMethods = "testAddTwoLists")
@Test(priority = 3)
public void testDeleteOneList() 
// Step 3: Delete one list
{
  boardPage.deleteFirstList();
  assertEquals(1, boardPage.getListCount(), "List count should be 1 after deleting one list.");
}
}
    


