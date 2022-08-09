package com.pages;

import org.apache.commons.lang3.RandomStringUtils;
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

    @FindBy(css="a[href*='delete']")
    WebElement  loggedInUser;

    @FindBy(css="a[href*='delete']")
    WebElement  deleteAccountLink;

    @FindBy(css="form[action='/signup'] >p")
    WebElement  emailErrorMessageText;



    @FindBy(xpath="//p[contains(.,'Your email or password is incorrect!')]")
    WebElement  errorMessageText;

    public String verifyEmailErrorMessageIsVisible(){
      String errorMessage=  emailErrorMessageText.getText();
      return errorMessage;
    }

    public boolean verifyNewUserSignupIsVisible() {
        // JavaScript Executor to check ready state
        //JavascriptExecutor j = (JavascriptExecutor)driver;
        return newUserSignUpText.isDisplayed();}

    public String verifyNewUserSignUPVisible(){
       return newUserSignUpText.getText();
    }

    public void enterRandomString() {
        String 	generatedString= RandomStringUtils.randomAlphabetic(8);
        RegnameField.sendKeys(generatedString);
    }

    public void enterRandomEmailField() {
        //WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        //w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[data-qa='signup-email']")));
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

    public void ClickDeleteAccountButton(){
        deleteAccountLink.click();
    }
    public boolean isErrorMessageTextVisible(){
        return errorMessageText.isDisplayed();


    }

}
