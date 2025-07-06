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
    
   




        
     
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    }
	
	


