package com.transmedia_ui.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.transmedia_ui.qa.base.TestBase;

public class HomePage extends TestBase 
{
	
	//bDriver driver;

   
	// Locators
	
	//Click Add List Btn
//	@FindBy(xpath = "//div[@class='p-2.5 ml-3 w-list text-sm text-gray-50 bg-white bg-opacity-20 hover:bg-opacity-30 rounded cursor-pointer flex-no-shrink']")
//	WebElement ClickAddListbtn;
//	
	//Enter List Title
	//indBy(css = "input[placeholder='Enter list title...']")
	
  @FindBy(xpath = "//input[@placeholder='Enter list title...']")
    WebElement listTitleInput;
    
    @FindBy(xpath = "//button[normalize-space()='Add list']")
    WebElement addListButton;
   
    // ========== Constructor ==========

//    public HomePage() {
//        PageFactory.initElements(driver, this);
//    }
    
    public HomePage() {
        PageFactory.initElements(driver, this); // ✅ use the initialized driver from base
    }
    
    


	

 // Method to add a list
    


    




	public void listTitleInput(String listName)
	{
	  listTitleInput.sendKeys(listName);
		
	}
	
	
	public void addList(String listTitle) 
    {
    	//ickAddListbtn.click();
    	///	listTitleInput.clear();
        listTitleInput.sendKeys(listTitle);
        addListButton.click();

       
    }}
    
//    public int getListCount() {
//        List<WebElement> lists = driver.findElements(By.xpath("//div[contains(@class, 'list-title')]"));
//        return lists.size();
//    }



	
 

    
    
 
    

    
   