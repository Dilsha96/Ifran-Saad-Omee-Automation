package com.transmedia_ui.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.transmedia_ui.qa.base.TestBase;
import com.transmedia_ui.qa.pages.BoardPage;
import com.transmedia_ui.qa.pages.HomePage;
import com.transmedia_ui.qa.util.TestDataUtil;

public class BoardPageTest extends TestBase{
	
	HomePage homePage;
    BoardPage boardPage;
    String boardName;
    
    public BoardPageTest()
    {
    	super();
    }

    @BeforeMethod
    public void setup() //set up method
    {
        initialization();
        //homePage = new HomePage();
        boardPage = new BoardPage(); //create the object of boardPage class
        boardName = TestDataUtil.getBoardName(); // Save board name to use across tests
    }

    @Test(priority = 1)
    
    public void testCreateBoard()
    {
        System.out.println("===== Test: Create Board =====");

        // Step 1: Click on 'Create new board'
        System.out.println("Step 1: Click on 'Create New Board'");
    	
        boardPage.clickCreateNewBoard();
        
    
    
    

        // Step 2: Enter board name and press Enter
        String boardName = "Test Board " + System.currentTimeMillis(); // unique name
        System.out.println("Step 2: Generated board name → " + boardName);
        
        // Step 3: Enter the board name
        System.out.println("Step 3: Enter board name into input field");
        boardPage.enterBoardName(boardName);
        //boardPage.clickCreateBoardbtn();
        
        
        // Step 4: Click on 'Create Board' button
        System.out.println("Step 4: Click on 'Create Board' button");
        boardPage.clickCreateBoardbtn();
        
        
        
     // Step 5: Verify board is created
        
        Assert.assertTrue(boardPage.isBoardCreated(boardName));
        Assert.assertTrue(boardPage.isBoardCreated(boardName), boardName);

        Assert.assertTrue(boardPage.isBoardCreated(boardName));
        System.out.println("Step 5: Verify board is created successfully");

        
     
        System.out.println("===== Test Completed: UI Automation 1st Task =====");
        
    
    }
    
   
//    public void testAddTwoLists() {
//        System.out.println("===== Test: Add Two Lists =====");
//
//        // Step 1: Generate first list name
//        String list1 = "List One " + System.currentTimeMillis();
//        //System.out.println("Step 1: Generated list 1 name → " + list1);
//
//        // Step 2: Enter first list title
//        System.out.println("Step 1: Enter list 1 title into input field");
//        homePage.addList(list1);
//        System.out.println("Added list: " + list1);
//
//        // Optional small delay (if UI needs time to render)
//        try { Thread.sleep(1000); } catch (InterruptedException e) {}
//    }

//        // Step 3: Generate second list name
//        homePage.addList(list1);
//        String list2 = "List Two " + System.currentTimeMillis();
//       
//
//        // Step 4: Enter second list title
//        System.out.println("Step 4: Enter list 2 title into input field");
//        homePage.addList(list2);
//        System.out.println("Added list: " + list2);
//
//        // Step 5: Verify lists are added
//        int count = homePage.getListCount();
//        System.out.println("Step 5: Total lists present on board: " + count);
//        Assert.assertEquals(count, 2, "Expected 2 lists on the board.");
//    }
//}

        
        // Step 2: Verify board is created 
//        String actualTitle = boardPage.getBoardTitle(); // returns String
//        assertEquals(actualTitle, boardName, 
//                     "Board title does not match the expected name.");
    
    
//        
//    @Test(priority = 2)
//        public void testAddTwoLists() 
//     // Step 2: Add Two Lists
//        {
//            boardPage.addList(TestDataUtil.getList1());
//            boardPage.addList(TestDataUtil.getList2());
//            assertEquals(2, boardPage.getListCount(), "List count should be 2 after adding two lists.");
//        }}
//     
//     
//
//   
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    }
	
	


