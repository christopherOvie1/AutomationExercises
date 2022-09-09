package com.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver driver;

    public LoginPage(WebDriver driver) {
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //webelements
    @FindBy(xpath="//h2[contains(.,'New User Signup!')]")
    WebElement newUserSignUpText;

    @FindBy(css="form[action='/login']>input[name='email']")
    WebElement  loginEmailField;

    @FindBy(css="form[action='/login']>input[name='password']")
    WebElement  loginPasswordField;

    @FindBy(css="form[action='/login']>button[type='submit']")
    WebElement  loginSubmitField;

    @FindBy(css="form[method='post'] > input[name='name']")
    WebElement  RegnameField;

    @FindBy(css="input[data-qa='signup-email']")
    WebElement  RegemailField;

    @FindBy(xpath="//form[@action='/signup']/button[@type='submit']")
    WebElement  signUpButton;

    @FindBy(css="li:nth-of-type(10) > a")
    WebElement  loggedInUser;

    @FindBy(css="a[href*='delete']")
    WebElement  deleteAccountLink;

    @FindBy(css="form[action='/signup'] >p")
    WebElement  emailErrorMessageText;

    @FindBy(xpath="//div[@class='container']//h2[.='Login to your account']")
    WebElement  loginIntoAccountText;

    @FindBy(xpath="//p[contains(.,'Your email or password is incorrect!')]")
    WebElement  errorMessageText;

    //web actions
    public String verifyEmailErrorMessageIsVisible(){
      String errorMessage=  emailErrorMessageText.getText();
      return errorMessage;
    }

    public boolean verifyNewUserSignupIsVisible() {
        // JavaScript Executor to check ready state
        //JavascriptExecutor j = (JavascriptExecutor)driver;
        return newUserSignUpText.isDisplayed();}

    public void enterRandomString() {
        String 	generatedString= RandomStringUtils.randomAlphabetic(8);
        RegnameField.sendKeys(generatedString);
    }

    public void enterRandomEmailField() {
        String 	generatedString=RandomStringUtils.randomAlphabetic(8);
        String email =  generatedString + "@gmail.com";
        System.out.println(email);
        RegemailField.sendKeys(email);
    }
    public void EnterNameAndAlreadyRegisteredEmailAddress(String name,String mailId){
        RegnameField.sendKeys(name);
        RegemailField.sendKeys(mailId);

    }

    public void loginAsValidUser(String email,String password){
        loginEmailField.sendKeys(email);
        loginPasswordField.sendKeys(password);
        loginSubmitField.click();
    }

    public void loginIntoRegistrationPage() {
        signUpButton.click();
    }


    public boolean verifyThatLoggedusernameIsVisible(){
        return loggedInUser.isDisplayed();
    }
public void validateLoggedUsername(String name){
    loggedInUser.getText().toLowerCase().equals(name);
}

    public String validLogername(){
      return   loggedInUser.getText();
    }
    public boolean verifyloginIntoAccountText(){
        return loginIntoAccountText.isDisplayed();
    }

    public boolean verifyLoggedInUsernmameVisibility(){
        WebElement result=driver.findElement(By.cssSelector("a[href*='delete']"));
        if(result.isDisplayed()){
            System.out.println("logged in username is correctly displayed");
        }
     else{
    System.out.println("logged in username is incorrectly displayed");
        }
     return true;
    }
    public void loggedInAs(String section)
    {
        WebElement name=  driver.findElement(By.xpath("//b[contains(.,'" + section + "')]"));
       // name.getText();
        System.out.println(name.getText());
    }
    public void ClickDeleteAccountButton(){
        deleteAccountLink.click();
    }
    public boolean isErrorMessageTextVisible(){
        return errorMessageText.isDisplayed();
    }

}
