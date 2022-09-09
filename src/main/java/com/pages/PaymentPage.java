package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PaymentPage {

    public static WebDriver driver;
    WebDriverWait wait;
    public PaymentPage(WebDriver driver) {

        this.driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    //web elements
    @FindBy(css="input[name='name_on_card']")
    WebElement nameOfCard;

    @FindBy(css="input[name='card_number']")
    WebElement cardNumber;

    @FindBy(css="input[name='cvc']")
    WebElement cvcNumber;

    @FindBy(css="input[name='expiry_month']")
    WebElement monthExpiration;

    @FindBy(css="input[name='expiry_year']")
    WebElement yearExpiration;

    @FindBy(id="submit")
    WebElement payAndConfirmOrder;


    @FindBy(xpath="//div[contains(.,'Your order has been placed successfully!')]//div[@class='alert-success alert']")
    WebElement successMessages;

//web actions
    public void enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate(String name,String cardNum,String cvc,String months,String yr){
        nameOfCard.sendKeys(name);
        cardNumber.sendKeys(cardNum);
        cvcNumber.sendKeys(cvc);
        monthExpiration.sendKeys(months);
        yearExpiration.sendKeys(yr);
        payAndConfirmOrder.click();
    }

    public void verifySuccessMessages(){
     // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
            //wait.until(ExpectedConditions.invisibilityOf()
    }





  /*  public void  gggggg(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.MILLISECONDS)
                .pollingEvery(2, TimeUni)
                .ignoring(NoSuchElementException.class);
        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
            }
        });
        //click on the selenium link
        clickseleniumlink.click();
    }*/


}

