package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    public static WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //webelements
    @FindBy(css="a[class='btn btn-default check_out']")
    WebElement downloadInvoiceButton;

    @FindBy(css="a[data-qa='continue-button']")
    WebElement contintueButton;

    @FindBy(xpath="//h2[contains(.,'Review Your Order')]")
    WebElement reviewYourOrder;

  //webactions
    public void clickContinueButton(){
        contintueButton.click();
    }

    public boolean reviewYourOrderText(){
       return reviewYourOrder.isDisplayed();

    }
    public void clickDownloadInvoiceButton(){
        downloadInvoiceButton.click();

    }

}

