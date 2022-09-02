package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    public static WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
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

//web actions
    public void enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate(String name,String cardNum,String cvc,String months,String yr){
        nameOfCard.sendKeys(name);
        cardNumber.sendKeys(cardNum);
        cvcNumber.sendKeys(cvc);
        monthExpiration.sendKeys(months);
        yearExpiration.sendKeys(yr);
        payAndConfirmOrder.click();
    }

}

