package com.transmedia_ui.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.transmedia_ui.qa.base.TestBase;

public class HomePage extends TestBase 
{
	
	// Locators
	
    @FindBy(xpath = "//div[@data-cy=\"create-list\"]")
    WebElement addListButtonVisible;

    @FindBy(xpath = "//input[@placeholder=\"Enter list title...\"]")
    WebElement listTitleInput1;
    
    @FindBy(xpath = "//input[@placeholder=\"Enter list title...\"]")
    WebElement listTitleInput2;

    @FindBy(xpath = "//button[@style=\"width: fit-content;\"]")
    WebElement confirmAddListBtn;
    
    
    
    //Add Another List btn click
    
    @FindBy(xpath = "//div[@data-cy=\"create-list\"]")
    //@FindBy(xpath = "//input[@placeholder='Enter list title...']")
    //@FindBy(xpath = "//div[@class='p-2.5 ml-3 w-list text-sm text-gray-50 bg-white bg-opacity-20 hover:bg-opacity-30 rounded cursor-pointer flex-no-shrink']")
    WebElement AddAnotherListBtn;
    
    
    @FindBy(xpath = "//button[@style=\"width: fit-content;\"]")
    WebElement confirmListBtn2;
    
    
  @FindBy(xpath="//button[@data-cy='list-options']//*[name()='svg']")
  WebElement ClickDot;
    
  @FindBy(xpath="//div[@class='block py-1 px-2 pt-2 text-sm text-gray-700 hover:bg-gray1 active:bg-gray2 cursor-pointer text-red-600']")
  WebElement DeleteList;
    
    
    
    
//    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div")
//    WebElement page;
    // ========== Constructor ==========

   
    public HomePage() {
        PageFactory.initElements(driver, this); // ✅ use the initialized driver from base
    }
    
    public void addList(String listTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
     // wait.until(ExpectedConditions.elementToBeClickable(addListButtonVisible)).click();
        
        
        
        //1.Enter the list title 
        wait.until(ExpectedConditions.visibilityOf(listTitleInput1));
        listTitleInput1.clear();
        listTitleInput1.sendKeys(listTitle);
        
     // Click the confirm button
        confirmAddListBtn.click();
        
 
        
        
     // Wait for it to disappear
        // Wait for the form to close before next list
       wait.until(ExpectedConditions.invisibilityOf(confirmAddListBtn));
        
     
        // Wait for "Add Another List" button to appear
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
        //wait1.until(ExpectedConditions.elementToBeClickable(addListButtonVisible)).click();
     wait1.until(ExpectedConditions.elementToBeClickable(AddAnotherListBtn)).click();
     
        listTitleInput2.sendKeys(listTitle);
        listTitleInput2.clear();
        confirmListBtn2.click();
       
    
    }

    
   
    public int getListCount() {
        List<WebElement> lists = driver.findElements(By.xpath("//div[contains(@class,'list-title') or contains(@class,'list_header-name')]"));
        return lists.size();
    }

    public boolean isListPresent(String listTitle) {
        return driver.findElements(By.xpath("//*[contains(text(),'" + listTitle + "')]")).size() > 0;
    }
    
    
    
    
 // Methods
    
    public void openFirstBoard() {
    	
        //WebElement board = driver.findElement(ClickDot);
        ClickDot.click();
        
    }

	public void deleteFirstList() {
		ClickDot.click();
		DeleteList.click();
		// TODO Auto-generated method stub
		
	}
}
    
    


	


    


    




	