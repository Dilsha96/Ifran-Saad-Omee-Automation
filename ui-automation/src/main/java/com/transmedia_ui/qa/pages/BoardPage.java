package com.transmedia_ui.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.transmedia_ui.qa.base.TestBase;

public class BoardPage  extends TestBase{

	// ========== Object Repository (Page Elements) ==========
	
	//1. Input a Board name, press enter. Verify Board created successfully.
	
	@FindBy(xpath = "//h1[normalize-space()='Create new board']")
	WebElement CreateNewboard;
	
	
	//Add board title
	
	@FindBy(xpath="//input[@placeholder='Add board title']")
	WebElement AddBoardTitle;
	
	//click Create Board Btn
	@FindBy(xpath="//button[normalize-space()='Create board']")
	//button[normalize-space()='Create board']
	WebElement CraeteBoardBtn;
	
	//Verify board is created
	@FindBy(xpath="//input[@name='board-title']")
	WebElement BoardTitle;
	//-----------------
	
	
	//Add List
	 @FindBy(xpath = "//input[@placeholder='Enter list title...']")
	 WebElement listTitleInput;
	    
	    @FindBy(xpath = "//button[normalize-space()='Add list']")
	 WebElement addListButton;
	

	public BoardPage() 
    {
        PageFactory.initElements(driver, this); // Initializes elements with driver
    }

    // ========== Actions/Methods ==========
	
	public void clickCreateNewBoard() {
		
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CreateNewboard);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(CreateNewboard));
	    CreateNewboard.click();
	}
    
	public void enterBoardName(String boardName) {
		AddBoardTitle.sendKeys(boardName);
		
	}
	
	
	public HomePage clickCreateBoardbtn()
	{
		CraeteBoardBtn.click();
		return null;
	}



	
//---
	
//	public boolean isBoardCreated(String boardName) {
//	    try {
//	        WebElement BoardTitle = driver.findElement(
//	            By.xpath("//*[contains(text(), '" + boardName + "')]")
//	        );
//	        return BoardTitle.isDisplayed();
//	    } catch (NoSuchElementException e) {
//	        return false;
//	    }
	

//	public void addList(String listTitle) {
//	    WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Enter list title']"));
//	    inputField.clear();
//	    inputField.sendKeys(listTitle);
//
//	    WebElement addButton = driver.findElement(By.xpath("//input[@value='Add List']"));
//	    addButton.click();
//	}

	

	
//	public boolean isBoardDisplayed(String boardName) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    try {
//	    	
//	        WebElement boardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("//*[contains(text(),'" + boardName + "')]")));
//	        return boardTitle.isDisplayed();
//	    } catch (Exception e) {
//	        return false;
//	    }
//	}
//	public boolean isBoardDisplayed(String boardName) {
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        return wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("//*[contains(text(),'" + boardName + "')]")
//	        )).isDisplayed();
//	    } catch (Exception e) {
//	        System.out.println("Board not found after wait: " + boardName);
//	        return false;
//	    }
//	}
	
	
	
	// Method to check if board is created successfully
//    public boolean isBoardCreated(String boardName) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            return wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(text(),'" + boardName + "')]")
//            )).isDisplayed();
//        } catch (Exception e) {
//            System.out.println("Board not visible: " + boardName);
//            return false;
//        }
//    }
	
	public boolean isBoardCreated(String boardName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Adjust this XPath based on your DOM structure
            By locator = By.xpath("//input[@name='board-title']");

            // Wait for visibility and optionally click
            boolean visible = wait
              .until(ExpectedConditions.visibilityOfElementLocated(locator))
              .isDisplayed();

            return visible;
        } catch (Exception e) {
            System.out.println("Board not visible: " + boardName);
            return false;
        }
	}
	
	public Object getListCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteFirstList() {
		
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
    

	
}









	
	

	    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
