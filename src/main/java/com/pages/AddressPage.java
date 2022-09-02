package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddressPage {

    public static WebDriver driver;
    WebDriverWait wait;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
// webelements
@FindBy(xpath="//ul[@id='address_delivery']/li[2]")
WebElement fullnameAddressBilling;

    @FindBy(xpath="//ul[@id='address_delivery']/li[3]")
    WebElement companyAddressBilling;

    @FindBy(xpath="//ul[@id='address_delivery']/li[4]")
    WebElement firstLineOFAddressBilling;

    @FindBy(xpath="//ul[@id='address_delivery']/li[5]")
    WebElement secondLineOFAddressBilling;


    @FindBy(xpath="//ul[@id='address_delivery']/li[6]")
    WebElement thirdLineOFAddressIncludingCityBilling;

    @FindBy(xpath="//ul[@id='address_delivery']/li[7]")
    WebElement city;

    public boolean checkAddress(String componentName)
    {
        boolean checkElementDisplay = true;

        if(componentName.contains("abc")){
            checkElementDisplay=  firstLineOFAddressBilling.isDisplayed();
        }

     else{
            checkElementDisplay= secondLineOFAddressBilling.isDisplayed();
        }
        return checkElementDisplay;
    }

    public void clickRad(){
        List <WebElement> radioButton= driver.findElements(By.cssSelector("input[type='radio']"));
        int  size= radioButton.size();
        for(int i =0;i<size;i++){
            radioButton.get(1).click();

        }
    }

    public void clickEitherRadioButtons() {
        List<WebElement> radioButton = driver.findElements(By.cssSelector("input[type='radio']"));
        int Size = radioButton.size();
        for (int i = 0; i < Size; i++)                      // starts the loop from first Radio button to the last one
        {
            String val = radioButton.get(i).getAttribute("value"); // starts the loop from first Radio button to the last on
            // Radio button name stored to the string variable, using 'Value' attribute
            if (val.equalsIgnoreCase("Mrs")){
                radioButton.get(i).click();
                break;
            }
        }
    }
    public boolean validateAddressContents(){
        boolean fullname=  fullnameAddressBilling.isDisplayed();
        boolean companyAdd=   companyAddressBilling.isDisplayed();
        boolean firstAdd=  firstLineOFAddressBilling.isDisplayed();
        boolean secondAdd=    secondLineOFAddressBilling.isDisplayed();
        boolean thirdAdd=  thirdLineOFAddressIncludingCityBilling.isDisplayed();
        boolean cit=  city.isDisplayed();
        return (fullname && companyAdd && firstAdd && secondAdd && thirdAdd||cit);

    }

}
