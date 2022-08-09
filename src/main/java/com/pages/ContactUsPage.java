package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

   public static WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);}

    @FindBy(xpath="//h2[contains(.,'Get In Touch')]")
    WebElement getInTouchText;
    @FindBy(css="form[id='contact-us-form']>div[class='form-group col-md-6'] input[data-qa='name']")
    WebElement  contactUsNameField;

    @FindBy(css="form[id='contact-us-form']>div[class='form-group col-md-6'] input[data-qa='email']")
    WebElement  contactUsEmailField;

    @FindBy(css="form[id='contact-us-form'] div[class='form-group col-md-12'] input[data-qa='subject']")
    WebElement  contactUsSubjectField;

    @FindBy(css="#message")
    WebElement  contactUsMessageField;

    @FindBy(css="div[class='status alert alert-success']")
    WebElement  successfulMessageText;

@FindBy(css="div[class='form-group col-md-12'] input[data-qa='submit-button']")
WebElement  submitButton;

    @FindBy(css="a[class='btn btn-success'] span")
    WebElement backButton;

   public boolean VerifyGETINTOUCHisVisible(){
      return getInTouchText.isDisplayed();
   }
   public void fillContactUsForm(String name,String email,String subject,String message){
       contactUsNameField.sendKeys(name);
       contactUsEmailField.sendKeys(email);
       contactUsSubjectField.sendKeys(subject);
       contactUsMessageField.sendKeys(message);
   }
public void clickSubmitButton(){
       submitButton.click();
}
    public  void AcceptAlerts(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
       public static void acceptAlert(WebDriver driver){

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    //wait.until(ExpectedConditions.alertIsPresent());
    Alert alert = driver.switchTo().alert();
    alert.accept();
}
public boolean isSuccessMessagePresent(){
   return    successfulMessageText.isDisplayed();
}
//or

    public boolean isSuccessMessagPresent(){
       boolean successMessage =    successfulMessageText.isDisplayed();
        return successMessage;
    }



public void clickBackButton(){
       backButton.click();
}



}
