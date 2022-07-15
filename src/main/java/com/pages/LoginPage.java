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

    @FindBy(css="form[method='post'] > input[name='name']")
    WebElement  RegnameField;

    @FindBy(css="input[data-qa='signup-email']")
    WebElement  RegemailField;

   // @FindBy(css="button[data-qa='signup-button']")
    @FindBy(xpath="//form[@action='/signup']/button[@type='submit']")
    WebElement  signUpButton;
    //li:nth-of-type(4) > a

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
    public void loginIntoRegistrationPage() {
        signUpButton.click();
    }

}
