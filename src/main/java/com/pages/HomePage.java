package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.How.*;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
       this.driver=driver;
        PageFactory.initElements(driver,this);}
//li:nth-of-type(4) > a  //  //*[@text() = “Submit”]
  //  @FindBy(xpath="//*[contains(text(),'You have been successfully subscribed!')]")
//  "//p[contains(.,'Availability: In Stock')]")
    @FindBy(css="li:nth-of-type(4) > a")
    WebElement  signUpLink;

    @FindBy(id="susbscribe_email")
    WebElement  emailID;

    @FindBy(css="i[class*='fa-arrow-circle-o-right']")
    WebElement  arrowTab;

    @FindBy(css="div[class='logo pull-left'] a img")
    WebElement logoBanner;

    @FindBy(css="div[class='single-widget']>h2")
    WebElement subscriptionText;

    @FindBy(xpath="//*[contains(text(),'You have been successfully subscribed!')]")
    WebElement messsageText;

    public boolean VerifyThatHomePageIsVisibleSuccessfully() {
        return logoBanner.isDisplayed();}

    public void goToLoginPage() {
       signUpLink.click();}

    public void ScrollDownToFooter(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(500,document.body.scrollHeight)");
    }

    public String verifyTextSUBSCRIPTION(){
       return subscriptionText.getText();
    }

    public void enterEmailAndNavigateToNextPage(String email){
        emailID.sendKeys(email);
        arrowTab.click();
    }



public void confirmMessageSent(WebDriver driver) {

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
    // invisibilityOfElementLocated condition
      w.until(ExpectedConditions.
              invisibilityOfElementLocated(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]")));

}
}
