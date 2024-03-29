package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    WebDriver driver;

public  TestCasesPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
//web elements
    @FindBy(css="h2[class='title text-center']>b")
    WebElement testCasesText;

//web actions
public boolean isTestCasePageNavigatedToSuccessfully(){
    return  testCasesText.isDisplayed();
}



}
