package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    public static WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);}


    @FindBy(css="h2[class='title text-center']> b")
    WebElement accountCreatedText;

    @FindBy(css="div[class='pull-right'] a")
    WebElement continueButton;

//pull-right
    public String verifyThatACCOUNTCREATEDIsVisible(){
     String accountCreatedtxt=   accountCreatedText.getText();
     return accountCreatedtxt;
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
